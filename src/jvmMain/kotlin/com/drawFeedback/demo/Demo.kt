

package com.dragfeedback.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.*

import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.dragfeedback.core.DragHighlightBox
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

data class CanvasItem(
    val id: String,
    val xPx: Float,
    val yPx: Float,
    val wPx: Float,
    val hPx: Float,
    val color: Color,
    val groupId: String? = null
) {
    fun rect(): Rect = Rect(xPx, yPx, xPx + wPx, yPx + hPx)
    fun movedBy(delta: Offset): CanvasItem = copy(xPx = xPx + delta.x, yPx = yPx + delta.y)
}

data class EditorSnapshot(
    val items: List<CanvasItem>,
    val groups: Map<String, Set<String>>,
    val selectedIds: Set<String>,
    val clipboard: List<CanvasItem>,
    val copyCounter: Int,
    val groupCounter: Int
)

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Editor Demo") {
        DemoScreen()
    }
}

@Composable
fun DemoScreen() {
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) { focusRequester.requestFocus() }
    fun ensureKeyboardFocus() = focusRequester.requestFocus()

    var selectionEnabled by remember { mutableStateOf(true) }
    var shiftDown by remember { mutableStateOf(false) }
    var ctrlDown by remember { mutableStateOf(false) }

    val items = remember {
        mutableStateListOf(
            CanvasItem("A", 40f, 40f, 140f, 70f, Color(0xFF3B82F6)),
            CanvasItem("B", 220f, 90f, 160f, 90f, Color(0xFF22C55E)),
            CanvasItem("C", 120f, 220f, 200f, 80f, Color(0xFFF97316)),
            CanvasItem("D", 360f, 210f, 140f, 120f, Color(0xFFA855F7))
        )
    }

    var selectedIds by remember { mutableStateOf(setOf<String>()) }
    var clipboard by remember { mutableStateOf<List<CanvasItem>>(emptyList()) }
    val groups = remember { mutableStateMapOf<String, MutableSet<String>>() }

    var copyCounter by remember { mutableStateOf(1) }
    var groupCounter by remember { mutableStateOf(1) }
    fun newCopyId(id : String): String = "Copy ${copyCounter++} of " + id;
    fun newGroupId(): String = "G${groupCounter++}"

    val undoStack = remember { mutableStateListOf<EditorSnapshot>() }
    val redoStack = remember { mutableStateListOf<EditorSnapshot>() }

    fun snapshot(): EditorSnapshot =
        EditorSnapshot(
            items = items.toList(),
            groups = groups.mapValues { it.value.toSet() },
            selectedIds = selectedIds.toSet(),
            clipboard = clipboard.map { it.copy() },
            copyCounter = copyCounter,
            groupCounter = groupCounter
        )

    fun restore(s: EditorSnapshot) {
        items.clear(); items.addAll(s.items)
        groups.clear()
        for ((gid, set) in s.groups) groups[gid] = set.toMutableSet()
        selectedIds = s.selectedIds.toSet()
        clipboard = s.clipboard.map { it.copy() }
        copyCounter = s.copyCounter
        groupCounter = s.groupCounter
    }

    fun pushUndoPoint() { undoStack.add(snapshot()); redoStack.clear() }
    fun undo() { if (undoStack.isNotEmpty()) { val prev = undoStack.removeLast(); redoStack.add(snapshot()); restore(prev) } }
    fun redo() { if (redoStack.isNotEmpty()) { val next = redoStack.removeLast(); undoStack.add(snapshot()); restore(next) } }

    fun recomputeGroupsAfterItemChange() {
        val existing = items.map { it.id }.toSet()
        for ((_, set) in groups) set.removeIf { it !in existing }
        val empty = groups.filterValues { it.isEmpty() }.keys.toList()
        empty.forEach { groups.remove(it) }
    }

    fun clearSelection() { selectedIds = emptySet() }

    fun clickSelect(id: String) {
        selectedIds =
            if (shiftDown || ctrlDown) {
                if (id in selectedIds) selectedIds - id else selectedIds + id
            } else setOf(id)
    }

    fun selectByRect(selectionRect: Rect) {
        val hit = items.filter { it.rect().overlaps(selectionRect) }.map { it.id }.toSet()
        selectedIds = if (shiftDown || ctrlDown) (selectedIds xor hit) else hit
    }

    fun deleteSelected() {
        if (selectedIds.isEmpty()) return
        pushUndoPoint()
        items.removeAll { it.id in selectedIds }
        clearSelection()
        recomputeGroupsAfterItemChange()
    }

    fun copySelected() { clipboard = items.filter { it.id in selectedIds }.map { it.copy() } }

    fun pasteClipboard() {
        if (clipboard.isEmpty()) return
        pushUndoPoint()
        val pasted = clipboard.map { t ->
            t.copy(id = newCopyId(t.id), xPx = t.xPx + 20f, yPx = t.yPx + 20f, groupId = null)
        }
        items.addAll(pasted)
        recomputeGroupsAfterItemChange()
        selectedIds = pasted.map { it.id }.toSet()
    }

    fun groupSelected() {
        if (selectedIds.size < 2) return
        pushUndoPoint()
        for ((_, set) in groups) set.removeAll(selectedIds)

        val gid = newGroupId()
        groups[gid] = selectedIds.toMutableSet()

        val updated = items.map { it2 -> if (it2.id in selectedIds) it2.copy(groupId = gid) else it2 }
        items.clear(); items.addAll(updated)
        recomputeGroupsAfterItemChange()
    }

    fun ungroupSelected() {
        val sel = items.filter { it.id in selectedIds }
        val gid = sel.mapNotNull { it.groupId }.distinct().singleOrNull() ?: return
        val groupIds = groups[gid]?.toSet() ?: return
        if (selectedIds != groupIds) return

        pushUndoPoint()
        groups.remove(gid)

        val updated = items.map { it2 -> if (it2.groupId == gid) it2.copy(groupId = null) else it2 }
        items.clear(); items.addAll(updated)
        recomputeGroupsAfterItemChange()
    }

    fun moveItems(ids: Set<String>, delta: Offset) {
        if (ids.isEmpty()) return
        val updated = items.map { it2 -> if (it2.id in ids) it2.movedBy(delta) else it2 }
        items.clear(); items.addAll(updated)
    }

    var moveUndoArmed by remember { mutableStateOf(false) }
    fun beginMoveUndoIfNeeded() { if (!moveUndoArmed) { pushUndoPoint(); moveUndoArmed = true } }
    fun endMove() { moveUndoArmed = false }

    var overlayPosPx by remember { mutableStateOf(Offset(40f, 80f)) }
    var lightTheme by remember { mutableStateOf(false) }

    val overlayStyle = remember(lightTheme) {
        if (!lightTheme) {
            OverlayStyle(
                background = Color(0xFF1F2937),
                borderColor = Color(0xFF374151),
                chipColor = Color(0xFF334155),
                chipDisabledColor = Color(0xFF223044)
            )
        } else {
            OverlayStyle(
                background = Color(0xFFF5F5F5),
                borderColor = Color(0xFFCCCCCC),
                titleColor = Color(0xFF111111),
                chipColor = Color(0xFFE9E9E9),
                chipDisabledColor = Color(0xFFDADADA),
                chipTextColor = Color(0xFF111111)
            )
        }
    }

    val keyHandler = Modifier.onPreviewKeyEvent { e ->
        if (e.type == KeyEventType.KeyDown || e.type == KeyEventType.KeyUp) {
            shiftDown = e.isShiftPressed
            ctrlDown = e.isCtrlPressed
        }
        if (e.type == KeyEventType.KeyDown) {
            when {
                e.isCtrlPressed && e.key == Key.Z -> { undo(); true }
                e.isCtrlPressed && e.key == Key.Y -> { redo(); true }
                e.isCtrlPressed && e.key == Key.C -> { copySelected(); true }
                e.isCtrlPressed && e.key == Key.V -> { pasteClipboard(); true }
                e.isCtrlPressed && e.key == Key.G && e.isShiftPressed -> { ungroupSelected(); true }
                e.isCtrlPressed && e.key == Key.G -> { groupSelected(); true }
                e.key == Key.Delete -> { deleteSelected(); true }
                else -> false
            }
        } else false
    }

    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    val dragScroll = rememberDraggableState { delta -> scope.launch { scrollState.scrollBy(-delta) } }

    val density = LocalDensity.current
    val closeGapPx = with(density) { 10.dp.toPx() }
    val closeSizePx = with(density) { 30.dp.toPx() }

    //  Reliable window size: constraints update on resize
    BoxWithConstraints(
        Modifier
            .fillMaxSize()
            .focusRequester(focusRequester)
            .focusable()
            .then(keyHandler)
    ) {
        val windowSizePx = IntSizePx(constraints.maxWidth, constraints.maxHeight)

        Box(Modifier.fillMaxSize()) {
            Column(
                Modifier
                    .fillMaxSize()
                    .draggable(state = dragScroll, orientation = Orientation.Vertical)
                    .verticalScroll(scrollState)
                    .padding(16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = selectionEnabled, onCheckedChange = { selectionEnabled = it })
                    Spacer(Modifier.width(8.dp))
                    Text(if (selectionEnabled) "Selection ON" else "Selection OFF")
                }

                Spacer(Modifier.height(12.dp))

                DragHighlightBox(
                    enabled = selectionEnabled,
                    onSelectionEnd = { rect ->
                        ensureKeyboardFocus()
                        selectByRect(rect)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(420.dp)
                        .background(Color(0xFF202020))
                        .border(1.dp, Color(0xFF444444))
                ) {
                    CanvasItemsLayer(
                        items = items,
                        selectedIds = selectedIds,
                        ensureKeyboardFocus = { ensureKeyboardFocus() },
                        onClickItem = { id ->
                            ensureKeyboardFocus()
                            clickSelect(id)
                        },
                        onBeginDragItem = { id ->
                            ensureKeyboardFocus()
                            if (id !in selectedIds) clickSelect(id)
                            beginMoveUndoIfNeeded()
                        },
                        onDragItem = { id, delta ->
                            val moveSet = if (id in selectedIds) selectedIds else setOf(id)
                            moveItems(moveSet, delta)
                        },
                        onEndDragItem = { endMove() }
                    )
                }

                Spacer(Modifier.height(600.dp))
            }

            if (selectedIds.isNotEmpty()) {
                val actions = listOf(
                    OverlayAction("Undo", undoStack.isNotEmpty(), icon = { Icon(Icons.Filled.Undo, null, tint = Color.White) }) { ensureKeyboardFocus(); undo() },
                    OverlayAction("Redo", redoStack.isNotEmpty(), icon = { Icon(Icons.Filled.Redo, null, tint = Color.White) }) { ensureKeyboardFocus(); redo() },
                    OverlayAction("Copy", true, icon = { Icon(Icons.Filled.ContentCopy, null, tint = Color.White) }) { ensureKeyboardFocus(); copySelected() },
                    OverlayAction("Paste", clipboard.isNotEmpty(), icon = { Icon(Icons.Filled.ContentPaste, null, tint = Color.White) }) { ensureKeyboardFocus(); pasteClipboard() },
                    OverlayAction("Delete", true, icon = { Icon(Icons.Filled.Delete, null, tint = Color.White) }) { ensureKeyboardFocus(); deleteSelected() },
                    OverlayAction("Group", selectedIds.size >= 2, icon = { Icon(Icons.Filled.CallMerge, null, tint = Color.White) }) { ensureKeyboardFocus(); groupSelected() },
                    OverlayAction("Ungroup", true, icon = { Icon(Icons.Filled.CallSplit, null, tint = Color.White) }) { ensureKeyboardFocus(); ungroupSelected() },
                    OverlayAction("Clear", true, icon = { Icon(Icons.Filled.Clear, null, tint = Color.White) }) { ensureKeyboardFocus(); clearSelection() },
                    OverlayAction("Theme", true, icon = { Icon(Icons.Filled.ColorLens, null, tint = Color.White) }) { ensureKeyboardFocus(); lightTheme = !lightTheme }
                )

                SelectionOverlay(
                    selectedCount = selectedIds.size,
                    actions = actions,
                    style = overlayStyle,
                    closeButtonGapPx = closeGapPx,
                    closeButtonSizePx = closeSizePx,
                    windowSizePx = windowSizePx,
                    positionPx = overlayPosPx,
                    onPositionChangePx = { overlayPosPx = it },
                    onClose = { ensureKeyboardFocus(); clearSelection() }
                )
            }
        }
    }
}

@Composable
private fun CanvasItemsLayer(
    items: List<CanvasItem>,
    selectedIds: Set<String>,
    ensureKeyboardFocus: () -> Unit,
    onClickItem: (String) -> Unit,
    onBeginDragItem: (String) -> Unit,
    onDragItem: (String, Offset) -> Unit,
    onEndDragItem: () -> Unit
) {
    val density = LocalDensity.current

    Box(
        Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { ensureKeyboardFocus() }
    ) {
        for (item in items) {
            val isSelected = item.id in selectedIds
            val wDp = with(density) { item.wPx.toDp() }
            val hDp = with(density) { item.hPx.toDp() }

            Box(
                Modifier
                    .offset { IntOffset(item.xPx.roundToInt(), item.yPx.roundToInt()) }
                    .size(wDp, hDp)
                    .background(item.color)
                    .border(if (isSelected) 2.dp else 0.dp, Color.Yellow)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { onClickItem(item.id) }
                    .pointerInput(item.id) {
                        detectDragGestures(
                            onDragStart = { onBeginDragItem(item.id) },
                            onDrag = { change, dragAmount ->
                                change.consume()
                                onDragItem(item.id, Offset(dragAmount.x, dragAmount.y))
                            },
                            onDragEnd = { onEndDragItem() },
                            onDragCancel = { onEndDragItem() }
                        )
                    }
                    .padding(8.dp)
            ) {
                DisableSelection {
                    Column {
                        Text(item.id, color = Color.White)
                        Text(
                            text = item.groupId?.let { "Group: $it" } ?: "Ungrouped",
                            color = Color(0xFFDDDDDD)
                        )
                    }
                }
            }
        }
    }
}

private infix fun <T> Set<T>.xor(other: Set<T>): Set<T> {
    val out = this.toMutableSet()
    for (v in other) {
        if (!out.add(v)) out.remove(v)
    }
    return out
}