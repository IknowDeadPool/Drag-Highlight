//////////////////////////package com.dragfeedback.demo
//////////////////////////
//////////////////////////import androidx.compose.foundation.background
//////////////////////////import androidx.compose.foundation.layout.*
//////////////////////////import androidx.compose.foundation.rememberScrollState
//////////////////////////import androidx.compose.foundation.verticalScroll
//////////////////////////import androidx.compose.material3.Text
//////////////////////////import androidx.compose.runtime.Composable
//////////////////////////import androidx.compose.ui.Modifier
//////////////////////////import androidx.compose.ui.graphics.Color
//////////////////////////import androidx.compose.ui.unit.dp
//////////////////////////import com.dragfeedback.core.DragFeedbackBox
//////////////////////////
//////////////////////////@Composable
//////////////////////////fun DemoScreen() {
//////////////////////////    val scroll = rememberScrollState()
//////////////////////////
//////////////////////////    Column(
//////////////////////////        Modifier.fillMaxSize().verticalScroll(scroll).padding(16.dp)
//////////////////////////    ) {
//////////////////////////        repeat(20) {
//////////////////////////            Box(Modifier.fillMaxWidth().height(60.dp).background(Color.DarkGray))
//////////////////////////            Spacer(Modifier.height(8.dp))
//////////////////////////        }
//////////////////////////
//////////////////////////        // Drag inside this box: parent should NOT scroll
//////////////////////////        DragFeedbackBox(
//////////////////////////            modifier = Modifier
//////////////////////////                .fillMaxWidth()
//////////////////////////                .height(200.dp)
//////////////////////////                .background(Color(0xFF333333))
//////////////////////////        ) {
//////////////////////////            Box(Modifier.fillMaxSize().padding(12.dp)) {
//////////////////////////                Text("Drag inside me. Parent scroll should not react.", color = Color.White)
//////////////////////////            }
//////////////////////////        }
//////////////////////////
//////////////////////////        Spacer(Modifier.height(600.dp))
//////////////////////////    }
//////////////////////////}
////////////////////////
////////////////////////
////////////////////////package com.dragfeedback.demo
////////////////////////
////////////////////////import androidx.compose.foundation.background
////////////////////////import androidx.compose.foundation.layout.*
////////////////////////import androidx.compose.foundation.rememberScrollState
////////////////////////import androidx.compose.foundation.verticalScroll
////////////////////////import androidx.compose.material.Text
////////////////////////import androidx.compose.runtime.Composable
////////////////////////import androidx.compose.ui.Modifier
////////////////////////import androidx.compose.ui.graphics.Color
////////////////////////import androidx.compose.ui.unit.dp
////////////////////////import androidx.compose.ui.window.Window
////////////////////////import androidx.compose.ui.window.application
////////////////////////import com.dragfeedback.core.DragFeedbackBox
////////////////////////
////////////////////////fun main() = application {
////////////////////////    Window(onCloseRequest = ::exitApplication, title = "DragFeedbackBox Demo") {
////////////////////////        DemoScreen()
////////////////////////    }
////////////////////////}
////////////////////////
////////////////////////@Composable
////////////////////////fun DemoScreen() {
////////////////////////    val scroll = rememberScrollState()
////////////////////////
////////////////////////    Column(
////////////////////////        Modifier.fillMaxSize().verticalScroll(scroll).padding(16.dp)
////////////////////////    ) {
////////////////////////        Text("Scroll the page. Then drag inside the big dark box; the page should NOT scroll.")
////////////////////////        Spacer(Modifier.height(12.dp))
////////////////////////
////////////////////////        repeat(12) {
////////////////////////            Box(
////////////////////////                Modifier
////////////////////////                    .fillMaxWidth()
////////////////////////                    .height(60.dp)
////////////////////////                    .background(Color.DarkGray)
////////////////////////            )
////////////////////////            Spacer(Modifier.height(8.dp))
////////////////////////        }
////////////////////////
////////////////////////        DragFeedbackBox(
////////////////////////            modifier = Modifier
////////////////////////                .fillMaxWidth()
////////////////////////                .height(220.dp)
////////////////////////                .background(Color(0xFF333333))
////////////////////////        ) {
////////////////////////            Box(Modifier.fillMaxSize().padding(12.dp)) {
////////////////////////                Text(
////////////////////////                    "Drag inside me.\nParent scroll should NOT move.",
////////////////////////                    color = Color.White
////////////////////////                )
////////////////////////            }
////////////////////////        }
////////////////////////
////////////////////////        Spacer(Modifier.height(800.dp))
////////////////////////    }
////////////////////////}
//////////////////////
//////////////////////
//////////////////////
////////////////////////
////////////////////////package com.dragfeedback.demo
////////////////////////
////////////////////////import androidx.compose.foundation.background
////////////////////////import androidx.compose.foundation.layout.*
////////////////////////import androidx.compose.foundation.rememberScrollState
////////////////////////import androidx.compose.foundation.verticalScroll
////////////////////////import androidx.compose.material.Button
////////////////////////import androidx.compose.material.Text
////////////////////////import androidx.compose.runtime.*
////////////////////////import androidx.compose.ui.Modifier
////////////////////////import androidx.compose.ui.graphics.Color
////////////////////////import androidx.compose.ui.unit.dp
////////////////////////import androidx.compose.ui.window.Window
////////////////////////import androidx.compose.ui.window.application
////////////////////////import com.dragfeedback.core.DragFeedbackBox
////////////////////////
////////////////////////fun main() = application {
////////////////////////    Window(onCloseRequest = ::exitApplication, title = "DragFeedbackBox Demo") {
////////////////////////        DemoScreen()
////////////////////////    }
////////////////////////}
////////////////////////
////////////////////////@Composable
////////////////////////fun DemoScreen() {
////////////////////////    var blockDrag by remember { mutableStateOf(true) }
////////////////////////    val scroll = rememberScrollState()
////////////////////////
////////////////////////    Column(
////////////////////////        Modifier.fillMaxSize().verticalScroll(scroll).padding(16.dp)
////////////////////////    ) {
////////////////////////
////////////////////////        Button(onClick = { blockDrag = !blockDrag }) {
////////////////////////            Text(if (blockDrag) "Disable Drag Blocking" else "Enable Drag Blocking")
////////////////////////        }
////////////////////////
////////////////////////        Spacer(Modifier.height(16.dp))
////////////////////////
////////////////////////        repeat(10) {
////////////////////////            Box(
////////////////////////                Modifier
////////////////////////                    .fillMaxWidth()
////////////////////////                    .height(60.dp)
////////////////////////                    .background(Color.DarkGray)
////////////////////////            )
////////////////////////            Spacer(Modifier.height(8.dp))
////////////////////////        }
////////////////////////
////////////////////////        DragFeedbackBox(
////////////////////////            enabled = blockDrag,
////////////////////////            modifier = Modifier
////////////////////////                .fillMaxWidth()
////////////////////////                .height(220.dp)
////////////////////////                .background(Color(0xFF333333))
////////////////////////        ) {
////////////////////////            Box(Modifier.fillMaxSize().padding(12.dp)) {
////////////////////////                Text(
////////////////////////                    if (blockDrag)
////////////////////////                        "Drag here → parent will NOT scroll"
////////////////////////                    else
////////////////////////                        "Drag here → parent WILL scroll",
////////////////////////                    color = Color.White
////////////////////////                )
////////////////////////            }
////////////////////////        }
////////////////////////
////////////////////////        Spacer(Modifier.height(800.dp))
////////////////////////    }
////////////////////////}
//////////////////////
//////////////////////
//////////////////////
//////////////////////
//////////////////////package com.dragfeedback.demo
//////////////////////
//////////////////////import androidx.compose.foundation.background
//////////////////////import androidx.compose.foundation.layout.*
//////////////////////import androidx.compose.foundation.rememberScrollState
//////////////////////import androidx.compose.foundation.verticalScroll
//////////////////////import androidx.compose.material.Button
//////////////////////import androidx.compose.material.Checkbox
//////////////////////import androidx.compose.material.Text
//////////////////////import androidx.compose.runtime.*
//////////////////////import androidx.compose.ui.Modifier
//////////////////////import androidx.compose.ui.graphics.Color
//////////////////////import androidx.compose.ui.unit.dp
//////////////////////import androidx.compose.ui.window.Window
//////////////////////import androidx.compose.ui.window.application
//////////////////////import com.dragfeedback.core.DragHighlightBox
//////////////////////
//////////////////////fun main() = application {
//////////////////////    Window(onCloseRequest = ::exitApplication, title = "Drag Highlight Demo") {
//////////////////////        App()
//////////////////////    }
//////////////////////}
//////////////////////
//////////////////////@Composable
//////////////////////private fun App() {
//////////////////////    var enabled by remember { mutableStateOf(true) }
//////////////////////    val scroll = rememberScrollState()
//////////////////////
//////////////////////    Column(
//////////////////////        Modifier.fillMaxSize().verticalScroll(scroll).padding(16.dp)
//////////////////////    ) {
//////////////////////        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
//////////////////////            Checkbox(checked = enabled, onCheckedChange = { enabled = it })
//////////////////////            Spacer(Modifier.width(8.dp))
//////////////////////            Text(if (enabled) "Drag highlight: ON (drag is consumed)" else "Drag highlight: OFF (normal behavior)")
//////////////////////        }
//////////////////////
//////////////////////        Spacer(Modifier.height(12.dp))
//////////////////////        Text("Scroll works outside the box. Inside the box, drag to see the Windows-style selection rectangle.")
//////////////////////        Spacer(Modifier.height(12.dp))
//////////////////////
//////////////////////        // Some filler to make scrolling obvious
//////////////////////        repeat(8) {
//////////////////////            Box(Modifier.fillMaxWidth().height(60.dp).background(Color.DarkGray))
//////////////////////            Spacer(Modifier.height(8.dp))
//////////////////////        }
//////////////////////
//////////////////////        // The test area
//////////////////////        DragHighlightBox(
//////////////////////            enabled = enabled,
//////////////////////            modifier = Modifier
//////////////////////                .fillMaxWidth()
//////////////////////                .height(320.dp)
//////////////////////                .background(Color(0xFF202020))
//////////////////////        ) {
//////////////////////            Column(Modifier.fillMaxSize().padding(12.dp)) {
//////////////////////                Text("Drag inside this area.", color = Color.White)
//////////////////////                Spacer(Modifier.height(8.dp))
//////////////////////                Text(
//////////////////////                    "When ON: you see a selection rectangle and the page won't scroll from this drag.\n" +
//////////////////////                            "When OFF: normal behavior (dragging here can scroll the page if you move enough).",
//////////////////////                    color = Color(0xFFCCCCCC)
//////////////////////                )
//////////////////////            }
//////////////////////        }
//////////////////////
//////////////////////        Spacer(Modifier.height(600.dp))
//////////////////////    }
//////////////////////}
//////////////////////
////////////////////
////////////////////
////////////////////
//////////////////////
//////////////////////package com.dragfeedback.demo
//////////////////////
//////////////////////import androidx.compose.foundation.background
//////////////////////import androidx.compose.foundation.gestures.Orientation
//////////////////////import androidx.compose.foundation.gestures.scrollBy
//////////////////////import androidx.compose.foundation.gestures.scrollable
//////////////////////import androidx.compose.foundation.layout.*
//////////////////////import androidx.compose.foundation.rememberScrollState
//////////////////////import androidx.compose.foundation.verticalScroll
//////////////////////import androidx.compose.material.Checkbox
//////////////////////import androidx.compose.material.Text
//////////////////////import androidx.compose.runtime.*
//////////////////////import androidx.compose.ui.Alignment
//////////////////////import androidx.compose.ui.Modifier
//////////////////////import androidx.compose.ui.graphics.Color
//////////////////////import androidx.compose.ui.input.pointer.PointerEventPass
//////////////////////import androidx.compose.ui.input.pointer.pointerInput
//////////////////////import androidx.compose.ui.unit.dp
//////////////////////import androidx.compose.ui.window.Window
//////////////////////import androidx.compose.ui.window.application
//////////////////////import com.dragfeedback.core.DragHighlightBox
//////////////////////import kotlinx.coroutines.launch
//////////////////////
//////////////////////fun main() = application {
//////////////////////    Window(onCloseRequest = ::exitApplication, title = "Drag Highlight Demo") {
//////////////////////        App()
//////////////////////    }
//////////////////////}
//////////////////////
//////////////////////@Composable
//////////////////////private fun App() {
//////////////////////    var enabled by remember { mutableStateOf(true) }
//////////////////////
//////////////////////    // We keep a ScrollState, but we will scroll it by drag using scrollable().
//////////////////////    val scrollState = rememberScrollState()
//////////////////////    val scope = rememberCoroutineScope()
//////////////////////
//////////////////////    // This makes dragging anywhere (unless consumed) scroll the page:
//////////////////////    val dragScroll = androidx.compose.foundation.gestures.rememberScrollableState { delta ->
//////////////////////        // delta > 0 means user drags down; we want content to move accordingly
//////////////////////        scope.launch {
//////////////////////            scrollState.scrollBy(-delta)
//////////////////////        }
//////////////////////        delta
//////////////////////    }
//////////////////////
//////////////////////    Column(
//////////////////////        Modifier
//////////////////////            .fillMaxSize()
//////////////////////            // IMPORTANT: scrollable enables drag-to-scroll on desktop
//////////////////////            .scrollable(state = dragScroll, orientation = Orientation.Vertical)
//////////////////////            // verticalScroll still allows mouse wheel / trackpad scrolling
//////////////////////            .verticalScroll(scrollState)
//////////////////////            .padding(16.dp)
//////////////////////    ) {
//////////////////////        Row(verticalAlignment = Alignment.CenterVertically) {
//////////////////////            Checkbox(checked = enabled, onCheckedChange = { enabled = it })
//////////////////////            Spacer(Modifier.width(8.dp))
//////////////////////            Text(if (enabled) "ON: highlight + blocks parent drag scroll" else "OFF: no highlight + parent drag scroll works")
//////////////////////        }
//////////////////////
//////////////////////        Spacer(Modifier.height(12.dp))
//////////////////////        Text("Try click+drag anywhere to scroll. Inside the dark box:")
//////////////////////        Text("• ON: you’ll see a blue selection rectangle and the page won’t scroll from that drag.")
//////////////////////        Text("• OFF: dragging inside will scroll the page (normal behavior).")
//////////////////////
//////////////////////        Spacer(Modifier.height(12.dp))
//////////////////////
//////////////////////        repeat(8) {
//////////////////////            Box(Modifier.fillMaxWidth().height(60.dp).background(Color.DarkGray))
//////////////////////            Spacer(Modifier.height(8.dp))
//////////////////////        }
//////////////////////
//////////////////////        DragHighlightBox(
//////////////////////            enabled = enabled,
//////////////////////            modifier = Modifier
//////////////////////                .fillMaxWidth()
//////////////////////                .height(320.dp)
//////////////////////                .background(Color(0xFF202020))
//////////////////////        ) {
//////////////////////            Box(Modifier.fillMaxSize().padding(12.dp)) {
//////////////////////                Text("Drag inside this box.", color = Color.White)
//////////////////////            }
//////////////////////        }
//////////////////////
//////////////////////        Spacer(Modifier.height(600.dp))
//////////////////////    }
//////////////////////}
////////////////////
////////////////////
//////////////////////
//////////////////////package com.dragfeedback.demo
//////////////////////
//////////////////////import androidx.compose.foundation.background
//////////////////////import androidx.compose.foundation.gestures.Orientation
//////////////////////import androidx.compose.foundation.gestures.draggable
//////////////////////import androidx.compose.foundation.gestures.rememberDraggableState
//////////////////////import androidx.compose.foundation.gestures.scrollBy
//////////////////////import androidx.compose.foundation.layout.*
//////////////////////import androidx.compose.foundation.rememberScrollState
//////////////////////import androidx.compose.foundation.verticalScroll
//////////////////////import androidx.compose.material.Checkbox
//////////////////////import androidx.compose.material.Text
//////////////////////import androidx.compose.runtime.*
//////////////////////import androidx.compose.ui.Alignment
//////////////////////import androidx.compose.ui.Modifier
//////////////////////import androidx.compose.ui.graphics.Color
//////////////////////import androidx.compose.ui.unit.dp
//////////////////////import androidx.compose.ui.window.Window
//////////////////////import androidx.compose.ui.window.application
//////////////////////import com.dragfeedback.core.DragHighlightBox
//////////////////////import kotlinx.coroutines.launch
//////////////////////
//////////////////////fun main() = application {
//////////////////////    Window(onCloseRequest = ::exitApplication, title = "Drag Highlight Demo") {
//////////////////////        App()
//////////////////////    }
//////////////////////}
//////////////////////
//////////////////////@Composable
//////////////////////private fun App() {
//////////////////////    var enabled by remember { mutableStateOf(true) }
//////////////////////
//////////////////////    val scrollState = rememberScrollState()
//////////////////////    val scope = rememberCoroutineScope()
//////////////////////
//////////////////////    // 🔥 THIS is the correct desktop drag-to-scroll mechanic
//////////////////////    val dragScroll = rememberDraggableState { delta ->
//////////////////////        scope.launch {
//////////////////////            scrollState.scrollBy(-delta)
//////////////////////        }
//////////////////////    }
//////////////////////
//////////////////////    Column(
//////////////////////        Modifier
//////////////////////            .fillMaxSize()
//////////////////////            // 🔥 Only ONE scroll system: draggable + scroll state
//////////////////////            .draggable(
//////////////////////                state = dragScroll,
//////////////////////                orientation = Orientation.Vertical
//////////////////////            )
//////////////////////            .verticalScroll(scrollState)
//////////////////////            .padding(16.dp)
//////////////////////    ) {
//////////////////////        Row(verticalAlignment = Alignment.CenterVertically) {
//////////////////////            Checkbox(checked = enabled, onCheckedChange = { enabled = it })
//////////////////////            Spacer(Modifier.width(8.dp))
//////////////////////            Text(
//////////////////////                if (enabled)
//////////////////////                    "ON: highlight + blocks drag scrolling"
//////////////////////                else
//////////////////////                    "OFF: normal behavior (drag scroll works)"
//////////////////////            )
//////////////////////        }
//////////////////////
//////////////////////        Spacer(Modifier.height(12.dp))
//////////////////////        Text("Drag anywhere to scroll.")
//////////////////////        Text("Inside dark box: ON = highlight, OFF = scroll")
//////////////////////
//////////////////////        Spacer(Modifier.height(12.dp))
//////////////////////
//////////////////////        repeat(8) {
//////////////////////            Box(
//////////////////////                Modifier
//////////////////////                    .fillMaxWidth()
//////////////////////                    .height(60.dp)
//////////////////////                    .background(Color.DarkGray)
//////////////////////            )
//////////////////////            Spacer(Modifier.height(8.dp))
//////////////////////        }
//////////////////////
//////////////////////        DragHighlightBox(
//////////////////////            enabled = enabled,
//////////////////////            modifier = Modifier
//////////////////////                .fillMaxWidth()
//////////////////////                .height(320.dp)
//////////////////////                .background(Color(0xFF202020))
//////////////////////        ) {
//////////////////////            Box(Modifier.fillMaxSize().padding(12.dp)) {
//////////////////////                Text("Drag inside this box.", color = Color.White)
//////////////////////            }
//////////////////////        }
//////////////////////
//////////////////////        Spacer(Modifier.height(600.dp))
//////////////////////    }
//////////////////////}
////////////////////
////////////////////
////////////////////
////////////////////
////////////////////package com.dragfeedback.demo
////////////////////
////////////////////import androidx.compose.foundation.background
////////////////////import androidx.compose.foundation.gestures.Orientation
////////////////////import androidx.compose.foundation.gestures.draggable
////////////////////import androidx.compose.foundation.gestures.rememberDraggableState
////////////////////import androidx.compose.foundation.gestures.scrollBy
////////////////////import androidx.compose.foundation.layout.*
////////////////////import androidx.compose.foundation.rememberScrollState
////////////////////import androidx.compose.foundation.verticalScroll
////////////////////import androidx.compose.material.Checkbox
////////////////////import androidx.compose.material.Text
////////////////////import androidx.compose.runtime.*
////////////////////import androidx.compose.ui.Alignment
////////////////////import androidx.compose.ui.Modifier
////////////////////import androidx.compose.ui.graphics.Color
////////////////////import androidx.compose.ui.unit.dp
////////////////////import androidx.compose.ui.window.Window
////////////////////import androidx.compose.ui.window.application
////////////////////import com.dragfeedback.core.DragHighlightBox
////////////////////import kotlinx.coroutines.launch
////////////////////
////////////////////fun main() = application {
////////////////////    Window(onCloseRequest = ::exitApplication, title = "DragFeedback Demo") {
////////////////////        DemoScreen()
////////////////////    }
////////////////////}
////////////////////
////////////////////@Composable
////////////////////fun DemoScreen() {
////////////////////    var enabled by remember { mutableStateOf(true) }
////////////////////
////////////////////    val scrollState = rememberScrollState()
////////////////////    val scope = rememberCoroutineScope()
////////////////////
////////////////////    // Drag-to-scroll for desktop:
////////////////////    val dragScroll = rememberDraggableState { delta ->
////////////////////        scope.launch { scrollState.scrollBy(-delta) }
////////////////////    }
////////////////////
////////////////////    Column(
////////////////////        Modifier
////////////////////            .fillMaxSize()
////////////////////            .draggable(state = dragScroll, orientation = Orientation.Vertical)
////////////////////            .verticalScroll(scrollState)
////////////////////            .padding(16.dp)
////////////////////    ) {
////////////////////        Row(verticalAlignment = Alignment.CenterVertically) {
////////////////////            Checkbox(checked = enabled, onCheckedChange = { enabled = it })
////////////////////            Spacer(Modifier.width(8.dp))
////////////////////            Text(if (enabled) "ON: highlight + blocks drag scroll" else "OFF: normal behavior (drag scroll works)")
////////////////////        }
////////////////////
////////////////////        Spacer(Modifier.height(12.dp))
////////////////////        Text("Drag anywhere to scroll. Inside the dark box:")
////////////////////        Text("ON = blue selection rectangle, OFF = scroll works.")
////////////////////        Spacer(Modifier.height(12.dp))
////////////////////
////////////////////        repeat(8) {
////////////////////            Box(Modifier.fillMaxWidth().height(60.dp).background(Color.DarkGray))
////////////////////            Spacer(Modifier.height(8.dp))
////////////////////        }
////////////////////
////////////////////        DragHighlightBox(
////////////////////            enabled = enabled,
////////////////////            modifier = Modifier
////////////////////                .fillMaxWidth()
////////////////////                .height(320.dp)
////////////////////                .background(Color(0xFF202020))
////////////////////        ) {
////////////////////            Box(Modifier.fillMaxSize().padding(12.dp)) {
////////////////////                Text("Draggable area.", color = Color.White)
////////////////////            }
////////////////////        }
////////////////////
////////////////////        Spacer(Modifier.height(600.dp))
////////////////////    }
////////////////////}
////////////////////
////////////////////
////////////////////
////////////////////
//////////////////
//////////////////
//////////////////
//////////////////package com.dragfeedback.demo
//////////////////
//////////////////import androidx.compose.foundation.background
//////////////////import androidx.compose.foundation.border
//////////////////import androidx.compose.foundation.gestures.Orientation
//////////////////import androidx.compose.foundation.gestures.draggable
//////////////////import androidx.compose.foundation.gestures.rememberDraggableState
//////////////////import androidx.compose.foundation.gestures.scrollBy
//////////////////import androidx.compose.foundation.layout.*
//////////////////import androidx.compose.foundation.rememberScrollState
//////////////////import androidx.compose.foundation.verticalScroll
//////////////////import androidx.compose.material.Button
//////////////////import androidx.compose.material.Checkbox
//////////////////import androidx.compose.material.Text
//////////////////import androidx.compose.runtime.*
//////////////////import androidx.compose.ui.Alignment
//////////////////import androidx.compose.ui.Modifier
//////////////////import androidx.compose.ui.geometry.Rect
//////////////////import androidx.compose.ui.graphics.Color
//////////////////import androidx.compose.ui.platform.LocalDensity
//////////////////import androidx.compose.ui.unit.IntOffset
//////////////////import androidx.compose.ui.unit.dp
//////////////////import androidx.compose.ui.window.Window
//////////////////import androidx.compose.ui.window.application
//////////////////import com.dragfeedback.core.DragHighlightBox
//////////////////import kotlinx.coroutines.launch
//////////////////import kotlin.math.roundToInt
//////////////////
//////////////////data class CanvasItem(
//////////////////    val id: String,
//////////////////    val xPx: Float,
//////////////////    val yPx: Float,
//////////////////    val wPx: Float,
//////////////////    val hPx: Float,
//////////////////    val color: Color
//////////////////) {
//////////////////    fun rect(): Rect = Rect(xPx, yPx, xPx + wPx, yPx + hPx)
//////////////////}
//////////////////
//////////////////fun main() = application {
//////////////////    Window(onCloseRequest = ::exitApplication, title = "Drag Select + Copy Demo") {
//////////////////        DemoScreen()
//////////////////    }
//////////////////}
//////////////////
//////////////////@Composable
//////////////////fun DemoScreen() {
//////////////////    var selectionEnabled by remember { mutableStateOf(true) }
//////////////////    var selectedIds by remember { mutableStateOf(setOf<String>()) }
//////////////////
//////////////////    // Items on the "canvas"
//////////////////    val items = remember {
//////////////////        mutableStateListOf(
//////////////////            CanvasItem("A", 40f, 40f, 140f, 70f, Color(0xFF3B82F6)),
//////////////////            CanvasItem("B", 220f, 90f, 160f, 90f, Color(0xFF22C55E)),
//////////////////            CanvasItem("C", 120f, 220f, 200f, 80f, Color(0xFFF97316)),
//////////////////            CanvasItem("D", 360f, 210f, 140f, 120f, Color(0xFFA855F7))
//////////////////        )
//////////////////    }
//////////////////
//////////////////    // Simple id generator
////////////////////    var counter by remember { mutableStateOf(1) }
//////////////////    fun newId(id : String): String = "Copy of " + id;
//////////////////
//////////////////    // Parent scrolling (drag-to-scroll)
//////////////////    val scrollState = rememberScrollState()
//////////////////    val scope = rememberCoroutineScope()
//////////////////    val dragScroll = rememberDraggableState { delta ->
//////////////////        scope.launch { scrollState.scrollBy(-delta) }
//////////////////    }
//////////////////
//////////////////    Column(
//////////////////        Modifier
//////////////////            .fillMaxSize()
//////////////////            .draggable(state = dragScroll, orientation = Orientation.Vertical)
//////////////////            .verticalScroll(scrollState)
//////////////////            .padding(16.dp)
//////////////////    ) {
//////////////////        Row(verticalAlignment = Alignment.CenterVertically) {
//////////////////            Checkbox(checked = selectionEnabled, onCheckedChange = { selectionEnabled = it })
//////////////////            Spacer(Modifier.width(8.dp))
//////////////////            Text(if (selectionEnabled) "Selection ON (drag draws rectangle)" else "Selection OFF (normal drag scroll)")
//////////////////        }
//////////////////
//////////////////        Spacer(Modifier.height(8.dp))
//////////////////
//////////////////        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//////////////////            Button(
//////////////////                onClick = {
//////////////////                    // Copy selected items with a small offset
//////////////////                    val toCopy = items.filter { it.id in selectedIds }
//////////////////                    val copies = toCopy.map { it.copy(id = newId(it.id), xPx = it.xPx + 50f, yPx = it.yPx + 50f) }
//////////////////                    items.addAll(copies)
//////////////////                },
//////////////////                enabled = selectedIds.isNotEmpty()
//////////////////            ) { Text("Copy Selected") }
//////////////////
//////////////////            Button(
//////////////////                onClick = {
//////////////////                    // Delete selected
//////////////////                    items.removeAll { it.id in selectedIds }
//////////////////                    selectedIds = emptySet()
//////////////////                },
//////////////////                enabled = selectedIds.isNotEmpty()
//////////////////            ) { Text("Delete Selected") }
//////////////////
//////////////////            Button(
//////////////////                onClick = { selectedIds = emptySet() },
//////////////////                enabled = selectedIds.isNotEmpty()
//////////////////            ) { Text("Clear Selection") }
//////////////////
//////////////////            Text("Selected: ${selectedIds.size}", modifier = Modifier.align(Alignment.CenterVertically))
//////////////////        }
//////////////////
//////////////////        Spacer(Modifier.height(12.dp))
//////////////////
//////////////////        Text("Drag inside the dark canvas to select boxes. Release mouse to select. Then Copy/Delete.")
//////////////////        Spacer(Modifier.height(12.dp))
//////////////////
//////////////////        // The "canvas" area
//////////////////        DragHighlightBox(
//////////////////            enabled = selectionEnabled,
//////////////////            onSelectionEnd = { selectionRect ->
//////////////////                // Select items whose rect overlaps the selection rectangle
//////////////////                val selected = items
//////////////////                    .filter { it.rect().overlaps(selectionRect) }
//////////////////                    .map { it.id }
//////////////////                    .toSet()
//////////////////                selectedIds = selected
//////////////////            },
//////////////////            modifier = Modifier
//////////////////                .fillMaxWidth()
//////////////////                .height(380.dp)
//////////////////                .background(Color(0xFF202020))
//////////////////                .border(1.dp, Color(0xFF444444))
//////////////////        ) {
//////////////////            CanvasItemsLayer(items = items, selectedIds = selectedIds)
//////////////////        }
//////////////////
//////////////////        Spacer(Modifier.height(600.dp))
//////////////////    }
//////////////////}
//////////////////
//////////////////@Composable
//////////////////private fun CanvasItemsLayer(
//////////////////    items: List<CanvasItem>,
//////////////////    selectedIds: Set<String>
//////////////////) {
//////////////////    val density = LocalDensity.current
//////////////////
//////////////////    Box(Modifier.fillMaxSize()) {
//////////////////        for (item in items) {
//////////////////            val isSelected = item.id in selectedIds
//////////////////            val wDp = with(density) { item.wPx.toDp() }
//////////////////            val hDp = with(density) { item.hPx.toDp() }
//////////////////
//////////////////            Box(
//////////////////                Modifier
//////////////////                    // offset in *pixels* (works well because pointer coords are px too)
//////////////////                    .offset { IntOffset(item.xPx.roundToInt(), item.yPx.roundToInt()) }
//////////////////                    .size(wDp, hDp)
//////////////////                    .background(item.color)
//////////////////                    .border(if (isSelected) 2.dp else 0.dp, Color.Yellow)
//////////////////            ) {
//////////////////                Text(
//////////////////                    text = item.id,
//////////////////                    color = Color.White,
//////////////////                    modifier = Modifier.padding(8.dp)
//////////////////                )
//////////////////            }
//////////////////        }
//////////////////    }
//////////////////}
////////////////
////////////////
////////////////
////////////////package com.dragfeedback.demo
////////////////
////////////////import androidx.compose.foundation.background
////////////////import androidx.compose.foundation.border
////////////////import androidx.compose.foundation.gestures.Orientation
////////////////import androidx.compose.foundation.gestures.detectDragGestures
////////////////import androidx.compose.foundation.gestures.draggable
////////////////import androidx.compose.foundation.gestures.rememberDraggableState
////////////////import androidx.compose.foundation.gestures.scrollBy
////////////////import androidx.compose.foundation.layout.*
////////////////import androidx.compose.foundation.rememberScrollState
////////////////import androidx.compose.foundation.verticalScroll
////////////////import androidx.compose.material.Button
////////////////import androidx.compose.material.Checkbox
////////////////import androidx.compose.material.Text
////////////////import androidx.compose.runtime.*
////////////////import androidx.compose.ui.Alignment
////////////////import androidx.compose.ui.Modifier
////////////////import androidx.compose.ui.geometry.Offset
////////////////import androidx.compose.ui.geometry.Rect
////////////////import androidx.compose.ui.graphics.Color
////////////////import androidx.compose.ui.input.key.*
////////////////
////////////////import androidx.compose.ui.input.pointer.pointerInput
////////////////import androidx.compose.ui.platform.LocalDensity
////////////////import androidx.compose.ui.unit.IntOffset
////////////////import androidx.compose.ui.unit.dp
////////////////import androidx.compose.ui.window.Window
////////////////import androidx.compose.ui.window.application
////////////////import com.dragfeedback.core.DragHighlightBox
////////////////import kotlinx.coroutines.launch
////////////////import kotlin.math.roundToInt
////////////////
////////////////// ---------------------------
////////////////// Models
////////////////// ---------------------------
////////////////data class CanvasItem(
////////////////    val id: String,
////////////////    val xPx: Float,
////////////////    val yPx: Float,
////////////////    val wPx: Float,
////////////////    val hPx: Float,
////////////////    val color: Color,
////////////////    val groupId: String? = null
////////////////) {
////////////////    fun rect(): Rect = Rect(xPx, yPx, xPx + wPx, yPx + hPx)
////////////////    fun movedBy(delta: Offset): CanvasItem =
////////////////        copy(xPx = xPx + delta.x, yPx = yPx + delta.y)
////////////////}
////////////////
////////////////fun main() = application {
////////////////    Window(onCloseRequest = ::exitApplication, title = "Select + Move + Copy/Paste + Group") {
////////////////        DemoScreen()
////////////////    }
////////////////}
////////////////
////////////////@Composable
////////////////fun DemoScreen() {
////////////////    // toggles
////////////////    var selectionEnabled by remember { mutableStateOf(true) }
////////////////
////////////////    // keyboard modifier tracking (for Shift/Ctrl behavior)
////////////////    var shiftDown by remember { mutableStateOf(false) }
////////////////    var ctrlDown by remember { mutableStateOf(false) }
////////////////
////////////////    // items
////////////////    val items = remember {
////////////////        mutableStateListOf(
////////////////            CanvasItem("A", 40f, 40f, 140f, 70f, Color(0xFF3B82F6)),
////////////////            CanvasItem("B", 220f, 90f, 160f, 90f, Color(0xFF22C55E)),
////////////////            CanvasItem("C", 120f, 220f, 200f, 80f, Color(0xFFF97316)),
////////////////            CanvasItem("D", 360f, 210f, 140f, 120f, Color(0xFFA855F7))
////////////////        )
////////////////    }
////////////////
////////////////    // selection + clipboard
////////////////    var selectedIds by remember { mutableStateOf(setOf<String>()) }
////////////////    var clipboard by remember { mutableStateOf<List<CanvasItem>>(emptyList()) }
////////////////
////////////////    // groups: groupId -> itemIds
////////////////    val groups = remember { mutableStateMapOf<String, MutableSet<String>>() }
////////////////
////////////////    // ids
////////////////    var copyCounter by remember { mutableStateOf(1) }
////////////////    var groupCounter by remember { mutableStateOf(1) }
////////////////    fun newCopyId(): String = "Copy${copyCounter++}"
////////////////    fun newGroupId(): String = "G${groupCounter++}"
////////////////
////////////////    // parent scroll (drag-to-scroll desktop)
////////////////    val scrollState = rememberScrollState()
////////////////    val scope = rememberCoroutineScope()
////////////////    val dragScroll = rememberDraggableState { delta ->
////////////////        scope.launch { scrollState.scrollBy(-delta) }
////////////////    }
////////////////
////////////////    // ---------------------------
////////////////    // Helpers
////////////////    // ---------------------------
////////////////    fun recomputeGroupsAfterItemChange() {
////////////////        // remove dead ids
////////////////        val existing = items.map { it.id }.toSet()
////////////////        val toRemove = groups.keys.filter { gid ->
////////////////            val set = groups[gid] ?: return@filter true
////////////////            set.removeIf { it !in existing }
////////////////            set.isEmpty()
////////////////        }
////////////////        toRemove.forEach { groups.remove(it) }
////////////////    }
////////////////
////////////////    fun selectByRect(selectionRect: Rect) {
////////////////        val hit = items.filter { it.rect().overlaps(selectionRect) }.map { it.id }.toSet()
////////////////        selectedIds =
////////////////            if (shiftDown || ctrlDown) {
////////////////                // toggle add/remove
////////////////                selectedIds xor hit
////////////////            } else {
////////////////                hit
////////////////            }
////////////////    }
////////////////
////////////////    fun clickSelect(id: String) {
////////////////        selectedIds =
////////////////            if (shiftDown || ctrlDown) {
////////////////                if (id in selectedIds) selectedIds - id else selectedIds + id
////////////////            } else {
////////////////                setOf(id)
////////////////            }
////////////////    }
////////////////
////////////////    fun clearSelection() {
////////////////        selectedIds = emptySet()
////////////////    }
////////////////
////////////////    fun copySelected() {
////////////////        val selected = items.filter { it.id in selectedIds }
////////////////        clipboard = selected.map { it.copy() } // store templates
////////////////    }
////////////////
////////////////    fun pasteClipboard() {
////////////////        if (clipboard.isEmpty()) return
////////////////
////////////////        val pasted = clipboard.map { template ->
////////////////            template.copy(
////////////////                id = newCopyId(),
////////////////                xPx = template.xPx + 20f,
////////////////                yPx = template.yPx + 20f,
////////////////                groupId = null // pasted items start ungrouped
////////////////            )
////////////////        }
////////////////
////////////////        // add and select pasted
////////////////        items.addAll(pasted)
////////////////        recomputeGroupsAfterItemChange()
////////////////        selectedIds = pasted.map { it.id }.toSet()
////////////////    }
////////////////
////////////////    fun deleteSelected() {
////////////////        if (selectedIds.isEmpty()) return
////////////////        items.removeAll { it.id in selectedIds }
////////////////        clearSelection()
////////////////        recomputeGroupsAfterItemChange()
////////////////    }
////////////////
////////////////    fun groupSelected() {
////////////////        val ids = selectedIds
////////////////        if (ids.size < 2) return
////////////////
////////////////        // Remove from existing groups first (simplify)
////////////////        val updated = items.map { item ->
////////////////            if (item.id in ids) item.copy(groupId = null) else item
////////////////        }
////////////////        items.clear()
////////////////        items.addAll(updated)
////////////////        groups.values.forEach { it.removeAll(ids) }
////////////////        recomputeGroupsAfterItemChange()
////////////////
////////////////        val gid = newGroupId()
////////////////        groups[gid] = ids.toMutableSet()
////////////////
////////////////        val groupedItems = items.map { item ->
////////////////            if (item.id in ids) item.copy(groupId = gid) else item
////////////////        }
////////////////        items.clear()
////////////////        items.addAll(groupedItems)
////////////////    }
////////////////
////////////////    fun ungroupSelected() {
////////////////        // Ungroup if all selected belong to the same group
////////////////        val selected = items.filter { it.id in selectedIds }
////////////////        val gid = selected.mapNotNull { it.groupId }.distinct().singleOrNull() ?: return
////////////////
////////////////        val groupIds = groups[gid]?.toSet() ?: return
////////////////        // only ungroup when selection covers the full group (prevents surprises)
////////////////        if (selectedIds != groupIds) return
////////////////
////////////////        groups.remove(gid)
////////////////
////////////////        val ungrouped = items.map { item ->
////////////////            if (item.groupId == gid) item.copy(groupId = null) else item
////////////////        }
////////////////        items.clear()
////////////////        items.addAll(ungrouped)
////////////////    }
////////////////
////////////////    fun moveItems(ids: Set<String>, delta: Offset) {
////////////////        if (ids.isEmpty()) return
////////////////        val moved = items.map { item ->
////////////////            if (item.id in ids) item.movedBy(delta) else item
////////////////        }
////////////////        items.clear()
////////////////        items.addAll(moved)
////////////////    }
////////////////
////////////////    // ---------------------------
////////////////    // Keyboard shortcuts
////////////////    // ---------------------------
////////////////    val keyHandler = Modifier.onPreviewKeyEvent { e ->
////////////////        // Track Shift/Ctrl state
////////////////        if (e.type == KeyEventType.KeyDown || e.type == KeyEventType.KeyUp) {
////////////////            shiftDown = e.isShiftPressed
////////////////            ctrlDown = e.isCtrlPressed
////////////////        }
////////////////
////////////////        if (e.type == KeyEventType.KeyDown && e.isCtrlPressed) {
////////////////            when (e.key) {
////////////////                Key.C -> { copySelected(); true }
////////////////                Key.V -> { pasteClipboard(); true }
////////////////                Key.G -> {
////////////////                    if (e.isShiftPressed) ungroupSelected() else groupSelected()
////////////////                    true
////////////////                }
////////////////                else -> false
////////////////            }
////////////////        } else if (e.type == KeyEventType.KeyDown && e.key == Key.Delete) {
////////////////            deleteSelected()
////////////////            true
////////////////        } else {
////////////////            false
////////////////        }
////////////////    }
////////////////
////////////////    // ---------------------------
////////////////    // UI
////////////////    // ---------------------------
////////////////    Column(
////////////////        Modifier
////////////////            .fillMaxSize()
////////////////            .then(keyHandler)
////////////////            .draggable(state = dragScroll, orientation = Orientation.Vertical)
////////////////            .verticalScroll(scrollState)
////////////////            .padding(16.dp)
////////////////    ) {
////////////////        Row(verticalAlignment = Alignment.CenterVertically) {
////////////////            Checkbox(checked = selectionEnabled, onCheckedChange = { selectionEnabled = it })
////////////////            Spacer(Modifier.width(8.dp))
////////////////            Text(if (selectionEnabled) "Selection ON" else "Selection OFF")
////////////////            Spacer(Modifier.width(16.dp))
////////////////            Text("Shift/Ctrl: multiselect  |  Ctrl+C/V  |  Ctrl+G / Ctrl+Shift+G  |  Del")
////////////////        }
////////////////
////////////////        Spacer(Modifier.height(10.dp))
////////////////
////////////////        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
////////////////            Button(onClick = { copySelected() }, enabled = selectedIds.isNotEmpty()) { Text("Copy") }
////////////////            Button(onClick = { pasteClipboard() }, enabled = clipboard.isNotEmpty()) { Text("Paste") }
////////////////            Button(onClick = { deleteSelected() }, enabled = selectedIds.isNotEmpty()) { Text("Delete") }
////////////////            Button(onClick = { groupSelected() }, enabled = selectedIds.size >= 2) { Text("Group") }
////////////////            Button(onClick = { ungroupSelected() }, enabled = selectedIds.isNotEmpty()) { Text("Ungroup") }
////////////////            Button(onClick = { clearSelection() }, enabled = selectedIds.isNotEmpty()) { Text("Clear") }
////////////////            Text("Selected: ${selectedIds.size}", modifier = Modifier.align(Alignment.CenterVertically))
////////////////        }
////////////////
////////////////        Spacer(Modifier.height(12.dp))
////////////////
////////////////        // filler content to show parent drag-scroll works
////////////////        repeat(6) {
////////////////            Box(Modifier.fillMaxWidth().height(50.dp).background(Color.DarkGray))
////////////////            Spacer(Modifier.height(6.dp))
////////////////        }
////////////////
////////////////        // Canvas area
////////////////        DragHighlightBox(
////////////////            enabled = selectionEnabled,
////////////////            onSelectionEnd = { rect -> selectByRect(rect) },
////////////////            modifier = Modifier
////////////////                .fillMaxWidth()
////////////////                .height(420.dp)
////////////////                .background(Color(0xFF202020))
////////////////                .border(1.dp, Color(0xFF444444))
////////////////        ) {
////////////////            CanvasItemsLayer(
////////////////                items = items,
////////////////                selectedIds = selectedIds,
////////////////                onClickItem = { id -> clickSelect(id) },
////////////////                onDragItem = { id, delta ->
////////////////                    // Dragging an item moves selected items (if it's selected), else moves only that item.
////////////////                    val moveSet =
////////////////                        if (id in selectedIds) selectedIds else setOf(id).also { clickSelect(id) }
////////////////
////////////////                    moveItems(moveSet, delta)
////////////////                }
////////////////            )
////////////////        }
////////////////
////////////////        Spacer(Modifier.height(600.dp))
////////////////    }
////////////////}
////////////////
////////////////@Composable
////////////////private fun CanvasItemsLayer(
////////////////    items: List<CanvasItem>,
////////////////    selectedIds: Set<String>,
////////////////    onClickItem: (String) -> Unit,
////////////////    onDragItem: (String, Offset) -> Unit
////////////////) {
////////////////    val density = LocalDensity.current
////////////////
////////////////    Box(Modifier.fillMaxSize()) {
////////////////        for (item in items) {
////////////////            val isSelected = item.id in selectedIds
////////////////
////////////////            val wDp = with(density) { item.wPx.toDp() }
////////////////            val hDp = with(density) { item.hPx.toDp() }
////////////////
////////////////            Box(
////////////////                Modifier
////////////////                    .offset { IntOffset(item.xPx.roundToInt(), item.yPx.roundToInt()) }
////////////////                    .size(wDp, hDp)
////////////////                    .background(item.color)
////////////////                    .border(if (isSelected) 2.dp else 0.dp, Color.Yellow)
////////////////                    .pointerInput(item.id) {
////////////////                        detectDragGestures(
////////////////                            onDragStart = {
////////////////                                onClickItem(item.id) // click-select on drag start too
////////////////                            },
////////////////                            onDrag = { change, dragAmount ->
////////////////                                change.consume() // prevents parent drag-scroll while moving items
////////////////                                onDragItem(item.id, Offset(dragAmount.x, dragAmount.y))
////////////////                            }
////////////////                        )
////////////////                    }
////////////////                    .pointerInput(item.id) {
////////////////                        // click (without drag)
////////////////                        // Simple: treat "tap" as down+up without movement using a minimal detector
////////////////                        // For demo, selection is handled in onDragStart already; this is optional.
////////////////                    }
////////////////                    .padding(8.dp)
////////////////            ) {
////////////////                Column {
////////////////                    Text(item.id, color = Color.White)
////////////////                    Text(
////////////////                        text = item.groupId?.let { "Group: $it" } ?: "Ungrouped",
////////////////                        color = Color(0xFFDDDDDD)
////////////////                    )
////////////////                }
////////////////            }
////////////////        }
////////////////    }
////////////////}
////////////////
////////////////// XOR helper for sets
////////////////private infix fun <T> Set<T>.xor(other: Set<T>): Set<T> {
////////////////    val out = this.toMutableSet()
////////////////    for (v in other) {
////////////////        if (!out.add(v)) out.remove(v)
////////////////    }
////////////////    return out
////////////////}
////////////////
//////////////
//////////////
//////////////
//////////////
//////////////package com.dragfeedback.demo
//////////////
//////////////import androidx.compose.foundation.background
//////////////import androidx.compose.foundation.border
//////////////import androidx.compose.foundation.gestures.*
//////////////import androidx.compose.foundation.layout.*
//////////////import androidx.compose.foundation.rememberScrollState
//////////////import androidx.compose.foundation.verticalScroll
//////////////import androidx.compose.foundation.text.selection.DisableSelection
//////////////import androidx.compose.material.Button
//////////////import androidx.compose.material.Checkbox
//////////////import androidx.compose.material.Text
//////////////import androidx.compose.runtime.*
//////////////import androidx.compose.ui.Alignment
//////////////import androidx.compose.ui.Modifier
//////////////import androidx.compose.ui.geometry.Offset
//////////////import androidx.compose.ui.geometry.Rect
//////////////import androidx.compose.ui.graphics.Color
//////////////import androidx.compose.ui.input.key.*
////////////////import androidx.compose.ui.input.pointer.consume
//////////////import androidx.compose.ui.input.pointer.pointerInput
//////////////import androidx.compose.ui.platform.LocalDensity
//////////////import androidx.compose.ui.unit.IntOffset
//////////////import androidx.compose.ui.unit.dp
//////////////import androidx.compose.ui.window.Window
//////////////import androidx.compose.ui.window.application
//////////////import com.dragfeedback.core.DragHighlightBox
//////////////import kotlinx.coroutines.launch
//////////////import kotlin.math.roundToInt
//////////////
//////////////data class CanvasItem(
//////////////    val id: String,
//////////////    val xPx: Float,
//////////////    val yPx: Float,
//////////////    val wPx: Float,
//////////////    val hPx: Float,
//////////////    val color: Color,
//////////////    val groupId: String? = null
//////////////) {
//////////////    fun rect(): Rect = Rect(xPx, yPx, xPx + wPx, yPx + hPx)
//////////////    fun movedBy(delta: Offset): CanvasItem = copy(xPx = xPx + delta.x, yPx = yPx + delta.y)
//////////////}
//////////////
//////////////// Snapshot for undo/redo (simple and robust)
//////////////data class EditorSnapshot(
//////////////    val items: List<CanvasItem>,
//////////////    val groups: Map<String, Set<String>>,
//////////////    val selectedIds: Set<String>,
//////////////    val clipboard: List<CanvasItem>,
//////////////    val copyCounter: Int,
//////////////    val groupCounter: Int
//////////////)
//////////////
//////////////fun main() = application {
//////////////    Window(onCloseRequest = ::exitApplication, title = "DragFeedback Demo") {
//////////////        DemoScreen()
//////////////    }
//////////////}
//////////////
//////////////@Composable
//////////////fun DemoScreen() {
//////////////    var selectionEnabled by remember { mutableStateOf(true) }
//////////////
//////////////    // Track Shift/Ctrl for multiselect behavior
//////////////    var shiftDown by remember { mutableStateOf(false) }
//////////////    var ctrlDown by remember { mutableStateOf(false) }
//////////////
//////////////    val items = remember {
//////////////        mutableStateListOf(
//////////////            CanvasItem("A", 40f, 40f, 140f, 70f, Color(0xFF3B82F6)),
//////////////            CanvasItem("B", 220f, 90f, 160f, 90f, Color(0xFF22C55E)),
//////////////            CanvasItem("C", 120f, 220f, 200f, 80f, Color(0xFFF97316)),
//////////////            CanvasItem("D", 360f, 210f, 140f, 120f, Color(0xFFA855F7))
//////////////        )
//////////////    }
//////////////
//////////////    var selectedIds by remember { mutableStateOf(setOf<String>()) }
//////////////    var clipboard by remember { mutableStateOf<List<CanvasItem>>(emptyList()) }
//////////////
//////////////    // groupId -> itemIds
//////////////    val groups = remember { mutableStateMapOf<String, MutableSet<String>>() }
//////////////
//////////////    var copyCounter by remember { mutableStateOf(1) }
//////////////    var groupCounter by remember { mutableStateOf(1) }
//////////////    fun newCopyId(): String = "Copy${copyCounter++}"
//////////////    fun newGroupId(): String = "G${groupCounter++}"
//////////////
//////////////    // Undo/Redo stacks
//////////////    val undoStack = remember { mutableStateListOf<EditorSnapshot>() }
//////////////    val redoStack = remember { mutableStateListOf<EditorSnapshot>() }
//////////////
//////////////    fun snapshot(): EditorSnapshot =
//////////////        EditorSnapshot(
//////////////            items = items.toList(),
//////////////            groups = groups.mapValues { it.value.toSet() },
//////////////            selectedIds = selectedIds.toSet(),
//////////////            clipboard = clipboard.map { it.copy() },
//////////////            copyCounter = copyCounter,
//////////////            groupCounter = groupCounter
//////////////        )
//////////////
//////////////    fun restore(s: EditorSnapshot) {
//////////////        items.clear()
//////////////        items.addAll(s.items)
//////////////
//////////////        groups.clear()
//////////////        for ((gid, set) in s.groups) {
//////////////            groups[gid] = set.toMutableSet()
//////////////        }
//////////////
//////////////        selectedIds = s.selectedIds.toSet()
//////////////        clipboard = s.clipboard.map { it.copy() }
//////////////        copyCounter = s.copyCounter
//////////////        groupCounter = s.groupCounter
//////////////    }
//////////////
//////////////    fun pushUndoPoint() {
//////////////        undoStack.add(snapshot())
//////////////        redoStack.clear()
//////////////    }
//////////////
//////////////    fun undo() {
//////////////        if (undoStack.isEmpty()) return
//////////////        val prev = undoStack.removeLast()
//////////////        redoStack.add(snapshot())
//////////////        restore(prev)
//////////////    }
//////////////
//////////////    fun redo() {
//////////////        if (redoStack.isEmpty()) return
//////////////        val next = redoStack.removeLast()
//////////////        undoStack.add(snapshot())
//////////////        restore(next)
//////////////    }
//////////////
//////////////    fun recomputeGroupsAfterItemChange() {
//////////////        val existing = items.map { it.id }.toSet()
//////////////
//////////////        // Remove ids that no longer exist
//////////////        for ((_, set) in groups) {
//////////////            set.removeIf { it !in existing }
//////////////        }
//////////////
//////////////        // Drop empty groups
//////////////        val empty = groups.filterValues { it.isEmpty() }.keys.toList()
//////////////        empty.forEach { groups.remove(it) }
//////////////    }
//////////////
//////////////    // ---- Selection helpers ----
//////////////    fun clickSelect(id: String) {
//////////////        selectedIds =
//////////////            if (shiftDown || ctrlDown) {
//////////////                if (id in selectedIds) selectedIds - id else selectedIds + id
//////////////            } else {
//////////////                setOf(id)
//////////////            }
//////////////    }
//////////////
//////////////    fun selectByRect(selectionRect: Rect) {
//////////////        val hit = items.filter { it.rect().overlaps(selectionRect) }.map { it.id }.toSet()
//////////////        selectedIds =
//////////////            if (shiftDown || ctrlDown) {
//////////////                selectedIds xor hit
//////////////            } else {
//////////////                hit
//////////////            }
//////////////    }
//////////////
//////////////    fun clearSelection() {
//////////////        selectedIds = emptySet()
//////////////    }
//////////////
//////////////    // ---- Actions ----
//////////////    fun deleteSelected() {
//////////////        if (selectedIds.isEmpty()) return
//////////////        pushUndoPoint()
//////////////        items.removeAll { it.id in selectedIds }
//////////////        selectedIds = emptySet()
//////////////        recomputeGroupsAfterItemChange()
//////////////    }
//////////////
//////////////    fun copySelected() {
//////////////        // Copy does not mutate canvas; no undo point needed
//////////////        clipboard = items.filter { it.id in selectedIds }.map { it.copy() }
//////////////    }
//////////////
//////////////    fun pasteClipboard() {
//////////////        if (clipboard.isEmpty()) return
//////////////        pushUndoPoint()
//////////////
//////////////        val pasted = clipboard.map { t ->
//////////////            t.copy(
//////////////                id = newCopyId(),
//////////////                xPx = t.xPx + 20f,
//////////////                yPx = t.yPx + 20f,
//////////////                groupId = null
//////////////            )
//////////////        }
//////////////        items.addAll(pasted)
//////////////        recomputeGroupsAfterItemChange()
//////////////        selectedIds = pasted.map { it.id }.toSet()
//////////////    }
//////////////
//////////////    fun groupSelected() {
//////////////        if (selectedIds.size < 2) return
//////////////        pushUndoPoint()
//////////////
//////////////        // remove selected ids from any existing groups first
//////////////        for ((_, set) in groups) set.removeAll(selectedIds)
//////////////
//////////////        val gid = newGroupId()
//////////////        groups[gid] = selectedIds.toMutableSet()
//////////////
//////////////        val updated = items.map { item ->
//////////////            if (item.id in selectedIds) item.copy(groupId = gid) else item
//////////////        }
//////////////        items.clear()
//////////////        items.addAll(updated)
//////////////
//////////////        recomputeGroupsAfterItemChange()
//////////////    }
//////////////
//////////////    fun ungroupSelected() {
//////////////        // Ungroup only if selection is exactly one full group
//////////////        val sel = items.filter { it.id in selectedIds }
//////////////        val gid = sel.mapNotNull { it.groupId }.distinct().singleOrNull() ?: return
//////////////        val groupIds = groups[gid]?.toSet() ?: return
//////////////        if (selectedIds != groupIds) return
//////////////
//////////////        pushUndoPoint()
//////////////
//////////////        groups.remove(gid)
//////////////
//////////////        val updated = items.map { item ->
//////////////            if (item.groupId == gid) item.copy(groupId = null) else item
//////////////        }
//////////////        items.clear()
//////////////        items.addAll(updated)
//////////////
//////////////        recomputeGroupsAfterItemChange()
//////////////    }
//////////////
//////////////    fun moveItems(ids: Set<String>, delta: Offset) {
//////////////        if (ids.isEmpty()) return
//////////////        val updated = items.map { item ->
//////////////            if (item.id in ids) item.movedBy(delta) else item
//////////////        }
//////////////        items.clear()
//////////////        items.addAll(updated)
//////////////    }
//////////////
//////////////    // IMPORTANT: for undo on move, push snapshot ONCE per drag-start
//////////////    var moveUndoArmed by remember { mutableStateOf(false) }
//////////////    fun beginMoveUndoIfNeeded() {
//////////////        if (!moveUndoArmed) {
//////////////            pushUndoPoint()
//////////////            moveUndoArmed = true
//////////////        }
//////////////    }
//////////////    fun endMove() { moveUndoArmed = false }
//////////////
//////////////    // ---- Keyboard shortcuts + modifier tracking ----
//////////////    val keyHandler = Modifier.onPreviewKeyEvent { e ->
//////////////        if (e.type == KeyEventType.KeyDown || e.type == KeyEventType.KeyUp) {
//////////////            shiftDown = e.isShiftPressed
//////////////            ctrlDown = e.isCtrlPressed
//////////////        }
//////////////
//////////////        if (e.type == KeyEventType.KeyDown) {
//////////////            when {
//////////////                e.isCtrlPressed && e.key == Key.Z -> { undo(); true }
//////////////                e.isCtrlPressed && e.key == Key.Y -> { redo(); true }
//////////////                e.isCtrlPressed && e.key == Key.C -> { copySelected(); true }
//////////////                e.isCtrlPressed && e.key == Key.V -> { pasteClipboard(); true }
//////////////                e.isCtrlPressed && e.key == Key.G && e.isShiftPressed -> { ungroupSelected(); true }
//////////////                e.isCtrlPressed && e.key == Key.G -> { groupSelected(); true }
//////////////                e.key == Key.Delete -> { deleteSelected(); true }
//////////////                else -> false
//////////////            }
//////////////        } else false
//////////////    }
//////////////
//////////////    // Parent scroll (drag-to-scroll desktop)
//////////////    val scrollState = rememberScrollState()
//////////////    val scope = rememberCoroutineScope()
//////////////    val dragScroll = rememberDraggableState { delta ->
//////////////        scope.launch { scrollState.scrollBy(-delta) }
//////////////    }
//////////////
//////////////    // UI
//////////////    Column(
//////////////        Modifier
//////////////            .fillMaxSize()
//////////////            .then(keyHandler)
//////////////            .draggable(state = dragScroll, orientation = Orientation.Vertical)
//////////////            .verticalScroll(scrollState)
//////////////            .padding(16.dp)
//////////////    ) {
//////////////        Row(verticalAlignment = Alignment.CenterVertically) {
//////////////            Checkbox(checked = selectionEnabled, onCheckedChange = { selectionEnabled = it })
//////////////            Spacer(Modifier.width(8.dp))
//////////////            Text(if (selectionEnabled) "Selection ON" else "Selection OFF")
//////////////            Spacer(Modifier.width(16.dp))
//////////////            Text("Ctrl+Z undo | Ctrl+Y redo | Ctrl+C/V | Ctrl+G / Ctrl+Shift+G | Del")
//////////////        }
//////////////
//////////////        Spacer(Modifier.height(10.dp))
//////////////
//////////////        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//////////////            Button(onClick = { undo() }, enabled = undoStack.isNotEmpty()) { Text("Undo") }
//////////////            Button(onClick = { redo() }, enabled = redoStack.isNotEmpty()) { Text("Redo") }
//////////////
//////////////            Spacer(Modifier.width(12.dp))
//////////////
//////////////            Button(onClick = { copySelected() }, enabled = selectedIds.isNotEmpty()) { Text("Copy") }
//////////////            Button(onClick = { pasteClipboard() }, enabled = clipboard.isNotEmpty()) { Text("Paste") }
//////////////            Button(onClick = { deleteSelected() }, enabled = selectedIds.isNotEmpty()) { Text("Delete") }
//////////////            Button(onClick = { groupSelected() }, enabled = selectedIds.size >= 2) { Text("Group") }
//////////////            Button(onClick = { ungroupSelected() }, enabled = selectedIds.isNotEmpty()) { Text("Ungroup") }
//////////////            Button(onClick = { clearSelection() }, enabled = selectedIds.isNotEmpty()) { Text("Clear") }
//////////////
//////////////            Text("Selected: ${selectedIds.size}", modifier = Modifier.align(Alignment.CenterVertically))
//////////////        }
//////////////
//////////////        Spacer(Modifier.height(12.dp))
//////////////
//////////////        repeat(6) {
//////////////            Box(Modifier.fillMaxWidth().height(50.dp).background(Color.DarkGray))
//////////////            Spacer(Modifier.height(6.dp))
//////////////        }
//////////////
//////////////        DragHighlightBox(
//////////////            enabled = selectionEnabled,
//////////////            onSelectionEnd = { rect -> selectByRect(rect) },
//////////////            modifier = Modifier
//////////////                .fillMaxWidth()
//////////////                .height(420.dp)
//////////////                .background(Color(0xFF202020))
//////////////                .border(1.dp, Color(0xFF444444))
//////////////        ) {
//////////////            CanvasItemsLayer(
//////////////                items = items,
//////////////                selectedIds = selectedIds,
//////////////                onTapItem = { id -> clickSelect(id) },
//////////////                onBeginDragItem = { id ->
//////////////                    // ensure item is selected when starting drag
//////////////                    if (id !in selectedIds) clickSelect(id)
//////////////                    beginMoveUndoIfNeeded()
//////////////                },
//////////////                onDragItem = { id, delta ->
//////////////                    val moveSet = if (id in selectedIds) selectedIds else setOf(id)
//////////////                    moveItems(moveSet, delta)
//////////////                },
//////////////                onEndDragItem = { endMove() }
//////////////            )
//////////////        }
//////////////
//////////////        Spacer(Modifier.height(600.dp))
//////////////    }
//////////////}
//////////////
//////////////@Composable
//////////////private fun CanvasItemsLayer(
//////////////    items: List<CanvasItem>,
//////////////    selectedIds: Set<String>,
//////////////    onTapItem: (String) -> Unit,
//////////////    onBeginDragItem: (String) -> Unit,
//////////////    onDragItem: (String, Offset) -> Unit,
//////////////    onEndDragItem: () -> Unit
//////////////) {
//////////////    val density = LocalDensity.current
//////////////
//////////////    Box(Modifier.fillMaxSize()) {
//////////////        for (item in items) {
//////////////            val isSelected = item.id in selectedIds
//////////////            val wDp = with(density) { item.wPx.toDp() }
//////////////            val hDp = with(density) { item.hPx.toDp() }
//////////////
//////////////            Box(
//////////////                Modifier
//////////////                    .offset { IntOffset(item.xPx.roundToInt(), item.yPx.roundToInt()) }
//////////////                    .size(wDp, hDp)
//////////////                    .background(item.color)
//////////////                    .border(if (isSelected) 2.dp else 0.dp, Color.Yellow)
//////////////                    // ✅ Tap selection FIX (so Del works on any selected item)
//////////////                    .pointerInput(item.id) {
//////////////                        detectTapGestures(
//////////////                            onTap = { onTapItem(item.id) }
//////////////                        )
//////////////                    }
//////////////                    // Drag to move selected items
//////////////                    .pointerInput(item.id) {
//////////////                        detectDragGestures(
//////////////                            onDragStart = {
//////////////                                onBeginDragItem(item.id)
//////////////                            },
//////////////                            onDrag = { change, dragAmount ->
//////////////                                change.consume() // blocks parent drag-scroll while moving items
//////////////                                onDragItem(item.id, Offset(dragAmount.x, dragAmount.y))
//////////////                            },
//////////////                            onDragEnd = { onEndDragItem() },
//////////////                            onDragCancel = { onEndDragItem() }
//////////////                        )
//////////////                    }
//////////////                    .padding(8.dp)
//////////////            ) {
//////////////                DisableSelection {
//////////////                    Column {
//////////////                        Text(item.id, color = Color.White)
//////////////                        Text(
//////////////                            text = item.groupId?.let { "Group: $it" } ?: "Ungrouped",
//////////////                            color = Color(0xFFDDDDDD)
//////////////                        )
//////////////                    }
//////////////                }
//////////////            }
//////////////        }
//////////////    }
//////////////}
//////////////
//////////////// XOR helper for sets
//////////////private infix fun <T> Set<T>.xor(other: Set<T>): Set<T> {
//////////////    val out = this.toMutableSet()
//////////////    for (v in other) {
//////////////        if (!out.add(v)) out.remove(v)
//////////////    }
//////////////    return out
//////////////}
////////////
////////////
////////////
////////////package com.dragfeedback.demo
////////////
////////////import androidx.compose.foundation.background
////////////import androidx.compose.foundation.border
////////////import androidx.compose.foundation.clickable
////////////import androidx.compose.foundation.gestures.Orientation
////////////import androidx.compose.foundation.gestures.detectDragGestures
////////////import androidx.compose.foundation.gestures.draggable
////////////import androidx.compose.foundation.gestures.rememberDraggableState
////////////import androidx.compose.foundation.gestures.scrollBy
////////////import androidx.compose.foundation.interaction.MutableInteractionSource
////////////import androidx.compose.foundation.layout.*
////////////import androidx.compose.foundation.rememberScrollState
////////////import androidx.compose.foundation.text.selection.DisableSelection
////////////import androidx.compose.foundation.verticalScroll
////////////import androidx.compose.material.Button
////////////import androidx.compose.material.Checkbox
////////////import androidx.compose.material.Text
////////////import androidx.compose.runtime.*
////////////import androidx.compose.ui.Alignment
////////////import androidx.compose.ui.Modifier
////////////import androidx.compose.ui.focus.FocusRequester
////////////import androidx.compose.ui.focus.focusRequester
////////////import androidx.compose.foundation.focusable
////////////import androidx.compose.ui.geometry.Offset
////////////import androidx.compose.ui.geometry.Rect
////////////import androidx.compose.ui.graphics.Color
////////////import androidx.compose.ui.input.key.*
//////////////import androidx.compose.ui.input.pointer.consume
////////////import androidx.compose.ui.input.pointer.pointerInput
////////////import androidx.compose.ui.platform.LocalDensity
////////////import androidx.compose.ui.unit.IntOffset
////////////import androidx.compose.ui.unit.dp
////////////import androidx.compose.ui.window.Window
////////////import androidx.compose.ui.window.application
////////////import com.dragfeedback.core.DragHighlightBox
////////////import kotlinx.coroutines.launch
////////////import kotlin.math.roundToInt
////////////
////////////data class CanvasItem(
////////////    val id: String,
////////////    val xPx: Float,
////////////    val yPx: Float,
////////////    val wPx: Float,
////////////    val hPx: Float,
////////////    val color: Color,
////////////    val groupId: String? = null
////////////) {
////////////    fun rect(): Rect = Rect(xPx, yPx, xPx + wPx, yPx + hPx)
////////////    fun movedBy(delta: Offset): CanvasItem = copy(xPx = xPx + delta.x, yPx = yPx + delta.y)
////////////}
////////////
////////////// Snapshot-based undo/redo
////////////data class EditorSnapshot(
////////////    val items: List<CanvasItem>,
////////////    val groups: Map<String, Set<String>>,
////////////    val selectedIds: Set<String>,
////////////    val clipboard: List<CanvasItem>,
////////////    val copyCounter: Int,
////////////    val groupCounter: Int
////////////)
////////////
////////////fun main() = application {
////////////    Window(onCloseRequest = ::exitApplication, title = "Select + Move + Copy/Paste + Group + Undo/Redo") {
////////////        DemoScreen()
////////////    }
////////////}
////////////
////////////@Composable
////////////fun DemoScreen() {
////////////    // Auto-focus so keyboard shortcuts work immediately
////////////    val focusRequester = remember { FocusRequester() }
////////////    LaunchedEffect(Unit) { focusRequester.requestFocus() }
////////////
////////////    var selectionEnabled by remember { mutableStateOf(true) }
////////////
////////////    // Track Shift/Ctrl
////////////    var shiftDown by remember { mutableStateOf(false) }
////////////    var ctrlDown by remember { mutableStateOf(false) }
////////////
////////////    val items = remember {
////////////        mutableStateListOf(
////////////            CanvasItem("A", 40f, 40f, 140f, 70f, Color(0xFF3B82F6)),
////////////            CanvasItem("B", 220f, 90f, 160f, 90f, Color(0xFF22C55E)),
////////////            CanvasItem("C", 120f, 220f, 200f, 80f, Color(0xFFF97316)),
////////////            CanvasItem("D", 360f, 210f, 140f, 120f, Color(0xFFA855F7))
////////////        )
////////////    }
////////////
////////////    var selectedIds by remember { mutableStateOf(setOf<String>()) }
////////////    var clipboard by remember { mutableStateOf<List<CanvasItem>>(emptyList()) }
////////////
////////////    // groupId -> itemIds
////////////    val groups = remember { mutableStateMapOf<String, MutableSet<String>>() }
////////////
////////////    var copyCounter by remember { mutableStateOf(1) }
////////////    var groupCounter by remember { mutableStateOf(1) }
////////////    fun newCopyId(): String = "Copy${copyCounter++}"
////////////    fun newGroupId(): String = "G${groupCounter++}"
////////////
////////////    // Undo/Redo stacks
////////////    val undoStack = remember { mutableStateListOf<EditorSnapshot>() }
////////////    val redoStack = remember { mutableStateListOf<EditorSnapshot>() }
////////////
////////////    fun snapshot(): EditorSnapshot =
////////////        EditorSnapshot(
////////////            items = items.toList(),
////////////            groups = groups.mapValues { it.value.toSet() },
////////////            selectedIds = selectedIds.toSet(),
////////////            clipboard = clipboard.map { it.copy() },
////////////            copyCounter = copyCounter,
////////////            groupCounter = groupCounter
////////////        )
////////////
////////////    fun restore(s: EditorSnapshot) {
////////////        items.clear()
////////////        items.addAll(s.items)
////////////
////////////        groups.clear()
////////////        for ((gid, set) in s.groups) {
////////////            groups[gid] = set.toMutableSet()
////////////        }
////////////
////////////        selectedIds = s.selectedIds.toSet()
////////////        clipboard = s.clipboard.map { it.copy() }
////////////        copyCounter = s.copyCounter
////////////        groupCounter = s.groupCounter
////////////    }
////////////
////////////    fun pushUndoPoint() {
////////////        undoStack.add(snapshot())
////////////        redoStack.clear()
////////////    }
////////////
////////////    fun undo() {
////////////        if (undoStack.isEmpty()) return
////////////        val prev = undoStack.removeLast()
////////////        redoStack.add(snapshot())
////////////        restore(prev)
////////////    }
////////////
////////////    fun redo() {
////////////        if (redoStack.isEmpty()) return
////////////        val next = redoStack.removeLast()
////////////        undoStack.add(snapshot())
////////////        restore(next)
////////////    }
////////////
////////////    fun recomputeGroupsAfterItemChange() {
////////////        val existing = items.map { it.id }.toSet()
////////////
////////////        for ((_, set) in groups) {
////////////            set.removeIf { it !in existing }
////////////        }
////////////
////////////        val empty = groups.filterValues { it.isEmpty() }.keys.toList()
////////////        empty.forEach { groups.remove(it) }
////////////    }
////////////
////////////    // ---------- Selection helpers ----------
////////////    fun clickSelect(id: String) {
////////////        selectedIds =
////////////            if (shiftDown || ctrlDown) {
////////////                if (id in selectedIds) selectedIds - id else selectedIds + id
////////////            } else {
////////////                setOf(id)
////////////            }
////////////    }
////////////
////////////    fun selectByRect(selectionRect: Rect) {
////////////        val hit = items.filter { it.rect().overlaps(selectionRect) }.map { it.id }.toSet()
////////////        selectedIds =
////////////            if (shiftDown || ctrlDown) {
////////////                selectedIds xor hit
////////////            } else {
////////////                hit
////////////            }
////////////    }
////////////
////////////    fun clearSelection() {
////////////        selectedIds = emptySet()
////////////    }
////////////
////////////    // ---------- Actions ----------
////////////    fun deleteSelected() {
////////////        if (selectedIds.isEmpty()) return
////////////        pushUndoPoint()
////////////        items.removeAll { it.id in selectedIds }
////////////        selectedIds = emptySet()
////////////        recomputeGroupsAfterItemChange()
////////////    }
////////////
////////////    fun copySelected() {
////////////        clipboard = items.filter { it.id in selectedIds }.map { it.copy() }
////////////    }
////////////
////////////    fun pasteClipboard() {
////////////        if (clipboard.isEmpty()) return
////////////        pushUndoPoint()
////////////
////////////        val pasted = clipboard.map { t ->
////////////            t.copy(
////////////                id = newCopyId(),
////////////                xPx = t.xPx + 20f,
////////////                yPx = t.yPx + 20f,
////////////                groupId = null
////////////            )
////////////        }
////////////
////////////        items.addAll(pasted)
////////////        recomputeGroupsAfterItemChange()
////////////        selectedIds = pasted.map { it.id }.toSet()
////////////    }
////////////
////////////    fun groupSelected() {
////////////        if (selectedIds.size < 2) return
////////////        pushUndoPoint()
////////////
////////////        for ((_, set) in groups) set.removeAll(selectedIds)
////////////
////////////        val gid = newGroupId()
////////////        groups[gid] = selectedIds.toMutableSet()
////////////
////////////        val updated = items.map { item ->
////////////            if (item.id in selectedIds) item.copy(groupId = gid) else item
////////////        }
////////////        items.clear()
////////////        items.addAll(updated)
////////////
////////////        recomputeGroupsAfterItemChange()
////////////    }
////////////
////////////    fun ungroupSelected() {
////////////        val sel = items.filter { it.id in selectedIds }
////////////        val gid = sel.mapNotNull { it.groupId }.distinct().singleOrNull() ?: return
////////////        val groupIds = groups[gid]?.toSet() ?: return
////////////        if (selectedIds != groupIds) return
////////////
////////////        pushUndoPoint()
////////////
////////////        groups.remove(gid)
////////////
////////////        val updated = items.map { item ->
////////////            if (item.groupId == gid) item.copy(groupId = null) else item
////////////        }
////////////        items.clear()
////////////        items.addAll(updated)
////////////
////////////        recomputeGroupsAfterItemChange()
////////////    }
////////////
////////////    fun moveItems(ids: Set<String>, delta: Offset) {
////////////        if (ids.isEmpty()) return
////////////        val updated = items.map { item ->
////////////            if (item.id in ids) item.movedBy(delta) else item
////////////        }
////////////        items.clear()
////////////        items.addAll(updated)
////////////    }
////////////
////////////    // Push undo ONCE per drag-start (not every frame)
////////////    var moveUndoArmed by remember { mutableStateOf(false) }
////////////    fun beginMoveUndoIfNeeded() {
////////////        if (!moveUndoArmed) {
////////////            pushUndoPoint()
////////////            moveUndoArmed = true
////////////        }
////////////    }
////////////    fun endMove() { moveUndoArmed = false }
////////////
////////////    // ---------- Keyboard shortcuts ----------
////////////    val keyHandler = Modifier.onPreviewKeyEvent { e ->
////////////        if (e.type == KeyEventType.KeyDown || e.type == KeyEventType.KeyUp) {
////////////            shiftDown = e.isShiftPressed
////////////            ctrlDown = e.isCtrlPressed
////////////        }
////////////
////////////        if (e.type == KeyEventType.KeyDown) {
////////////            when {
////////////                e.isCtrlPressed && e.key == Key.Z -> { undo(); true }
////////////                e.isCtrlPressed && e.key == Key.Y -> { redo(); true }
////////////                e.isCtrlPressed && e.key == Key.C -> { copySelected(); true }
////////////                e.isCtrlPressed && e.key == Key.V -> { pasteClipboard(); true }
////////////                e.isCtrlPressed && e.key == Key.G && e.isShiftPressed -> { ungroupSelected(); true }
////////////                e.isCtrlPressed && e.key == Key.G -> { groupSelected(); true }
////////////                e.key == Key.Delete -> { deleteSelected(); true }
////////////                else -> false
////////////            }
////////////        } else false
////////////    }
////////////
////////////    // Parent drag-scroll
////////////    val scrollState = rememberScrollState()
////////////    val scope = rememberCoroutineScope()
////////////    val dragScroll = rememberDraggableState { delta ->
////////////        scope.launch { scrollState.scrollBy(-delta) }
////////////    }
////////////
////////////    Column(
////////////        Modifier
////////////            .fillMaxSize()
////////////            .focusRequester(focusRequester)
////////////            .focusable()
////////////            .then(keyHandler)
////////////            .draggable(state = dragScroll, orientation = Orientation.Vertical)
////////////            .verticalScroll(scrollState)
////////////            .padding(16.dp)
////////////    ) {
////////////        Row(verticalAlignment = Alignment.CenterVertically) {
////////////            Checkbox(checked = selectionEnabled, onCheckedChange = { selectionEnabled = it })
////////////            Spacer(Modifier.width(8.dp))
////////////            Text(if (selectionEnabled) "Selection ON" else "Selection OFF")
////////////            Spacer(Modifier.width(16.dp))
////////////            Text("Ctrl+Z undo | Ctrl+Y redo | Ctrl+C/V | Ctrl+G / Ctrl+Shift+G | Del")
////////////        }
////////////
////////////        Spacer(Modifier.height(10.dp))
////////////
////////////        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
////////////            Button(onClick = { undo() }, enabled = undoStack.isNotEmpty()) { Text("Undo") }
////////////            Button(onClick = { redo() }, enabled = redoStack.isNotEmpty()) { Text("Redo") }
////////////
////////////            Spacer(Modifier.width(12.dp))
////////////
////////////            Button(onClick = { copySelected() }, enabled = selectedIds.isNotEmpty()) { Text("Copy") }
////////////            Button(onClick = { pasteClipboard() }, enabled = clipboard.isNotEmpty()) { Text("Paste") }
////////////            Button(onClick = { deleteSelected() }, enabled = selectedIds.isNotEmpty()) { Text("Delete") }
////////////            Button(onClick = { groupSelected() }, enabled = selectedIds.size >= 2) { Text("Group") }
////////////            Button(onClick = { ungroupSelected() }, enabled = selectedIds.isNotEmpty()) { Text("Ungroup") }
////////////            Button(onClick = { clearSelection() }, enabled = selectedIds.isNotEmpty()) { Text("Clear") }
////////////
////////////            Text("Selected: ${selectedIds.size}", modifier = Modifier.align(Alignment.CenterVertically))
////////////        }
////////////
////////////        Spacer(Modifier.height(12.dp))
////////////
////////////        repeat(6) {
////////////            Box(Modifier.fillMaxWidth().height(50.dp).background(Color.DarkGray))
////////////            Spacer(Modifier.height(6.dp))
////////////        }
////////////
////////////        DragHighlightBox(
////////////            enabled = selectionEnabled,
////////////            onSelectionEnd = { rect -> selectByRect(rect) },
////////////            modifier = Modifier
////////////                .fillMaxWidth()
////////////                .height(420.dp)
////////////                .background(Color(0xFF202020))
////////////                .border(1.dp, Color(0xFF444444))
////////////        ) {
////////////            CanvasItemsLayer(
////////////                items = items,
////////////                selectedIds = selectedIds,
////////////                onClickItem = { id -> clickSelect(id) },
////////////                onBeginDragItem = { id ->
////////////                    if (id !in selectedIds) clickSelect(id)
////////////                    beginMoveUndoIfNeeded()
////////////                },
////////////                onDragItem = { id, delta ->
////////////                    val moveSet = if (id in selectedIds) selectedIds else setOf(id)
////////////                    moveItems(moveSet, delta)
////////////                },
////////////                onEndDragItem = { endMove() }
////////////            )
////////////        }
////////////
////////////        Spacer(Modifier.height(600.dp))
////////////    }
////////////}
////////////
////////////@Composable
////////////private fun CanvasItemsLayer(
////////////    items: List<CanvasItem>,
////////////    selectedIds: Set<String>,
////////////    onClickItem: (String) -> Unit,
////////////    onBeginDragItem: (String) -> Unit,
////////////    onDragItem: (String, Offset) -> Unit,
////////////    onEndDragItem: () -> Unit
////////////) {
////////////    val density = LocalDensity.current
////////////
////////////    Box(Modifier.fillMaxSize()) {
////////////        for (item in items) {
////////////            val isSelected = item.id in selectedIds
////////////            val wDp = with(density) { item.wPx.toDp() }
////////////            val hDp = with(density) { item.hPx.toDp() }
////////////
////////////            Box(
////////////                Modifier
////////////                    .offset { IntOffset(item.xPx.roundToInt(), item.yPx.roundToInt()) }
////////////                    .size(wDp, hDp)
////////////                    .background(item.color)
////////////                    .border(if (isSelected) 2.dp else 0.dp, Color.Yellow)
////////////
////////////                    // ✅ reliable selection for ALL items
////////////                    .clickable(
////////////                        interactionSource = remember { MutableInteractionSource() },
////////////                        indication = null
////////////                    ) { onClickItem(item.id) }
////////////
////////////                    // drag to move
////////////                    .pointerInput(item.id) {
////////////                        detectDragGestures(
////////////                            onDragStart = { onBeginDragItem(item.id) },
////////////                            onDrag = { change, dragAmount ->
////////////                                change.consume() // blocks parent drag-scroll while moving items
////////////                                onDragItem(item.id, Offset(dragAmount.x, dragAmount.y))
////////////                            },
////////////                            onDragEnd = { onEndDragItem() },
////////////                            onDragCancel = { onEndDragItem() }
////////////                        )
////////////                    }
////////////                    .padding(8.dp)
////////////            ) {
////////////                DisableSelection {
////////////                    Column {
////////////                        Text(item.id, color = Color.White)
////////////                        Text(
////////////                            text = item.groupId?.let { "Group: $it" } ?: "Ungrouped",
////////////                            color = Color(0xFFDDDDDD)
////////////                        )
////////////                    }
////////////                }
////////////            }
////////////        }
////////////    }
////////////}
////////////
////////////private infix fun <T> Set<T>.xor(other: Set<T>): Set<T> {
////////////    val out = this.toMutableSet()
////////////    for (v in other) {
////////////        if (!out.add(v)) out.remove(v)
////////////    }
////////////    return out
////////////}
//////////
//////////
//////////
//////////package com.dragfeedback.demo
//////////
//////////import androidx.compose.foundation.background
//////////import androidx.compose.foundation.border
//////////import androidx.compose.foundation.clickable
//////////import androidx.compose.foundation.focusable
//////////import androidx.compose.foundation.gestures.Orientation
//////////import androidx.compose.foundation.gestures.detectDragGestures
//////////import androidx.compose.foundation.gestures.draggable
//////////import androidx.compose.foundation.gestures.rememberDraggableState
//////////import androidx.compose.foundation.gestures.scrollBy
//////////import androidx.compose.foundation.interaction.MutableInteractionSource
//////////import androidx.compose.foundation.layout.*
//////////import androidx.compose.foundation.rememberScrollState
//////////import androidx.compose.foundation.text.selection.DisableSelection
//////////import androidx.compose.foundation.verticalScroll
//////////import androidx.compose.material.Button
//////////import androidx.compose.material.Checkbox
//////////import androidx.compose.material.Text
//////////import androidx.compose.runtime.*
//////////import androidx.compose.ui.Alignment
//////////import androidx.compose.ui.Modifier
//////////import androidx.compose.ui.focus.FocusRequester
//////////import androidx.compose.ui.focus.focusRequester
//////////import androidx.compose.ui.geometry.Offset
//////////import androidx.compose.ui.geometry.Rect
//////////import androidx.compose.ui.graphics.Color
//////////import androidx.compose.ui.input.key.*
//////////
//////////import androidx.compose.ui.input.pointer.pointerInput
//////////import androidx.compose.ui.platform.LocalDensity
//////////import androidx.compose.ui.unit.IntOffset
//////////import androidx.compose.ui.unit.dp
//////////import androidx.compose.ui.window.Window
//////////import androidx.compose.ui.window.application
//////////import com.dragfeedback.core.DragHighlightBox
//////////import kotlinx.coroutines.launch
//////////import kotlin.math.roundToInt
//////////
//////////data class CanvasItem(
//////////    val id: String,
//////////    val xPx: Float,
//////////    val yPx: Float,
//////////    val wPx: Float,
//////////    val hPx: Float,
//////////    val color: Color,
//////////    val groupId: String? = null
//////////) {
//////////    fun rect(): Rect = Rect(xPx, yPx, xPx + wPx, yPx + hPx)
//////////    fun movedBy(delta: Offset): CanvasItem = copy(xPx = xPx + delta.x, yPx = yPx + delta.y)
//////////}
//////////
//////////data class EditorSnapshot(
//////////    val items: List<CanvasItem>,
//////////    val groups: Map<String, Set<String>>,
//////////    val selectedIds: Set<String>,
//////////    val clipboard: List<CanvasItem>,
//////////    val copyCounter: Int,
//////////    val groupCounter: Int
//////////)
//////////
//////////fun main() = application {
//////////    Window(onCloseRequest = ::exitApplication, title = "Editor Demo") {
//////////        DemoScreen()
//////////    }
//////////}
//////////
//////////@Composable
//////////fun DemoScreen() {
//////////    // Root focus (so keyboard shortcuts work)
//////////    val focusRequester = remember { FocusRequester() }
//////////
//////////    // Request focus on startup
//////////    LaunchedEffect(Unit) { focusRequester.requestFocus() }
//////////
//////////    // Helper: call this on ANY canvas interaction (drag-select, click, drag)
//////////    fun ensureKeyboardFocus() {
//////////        focusRequester.requestFocus()
//////////    }
//////////
//////////    var selectionEnabled by remember { mutableStateOf(true) }
//////////
//////////    var shiftDown by remember { mutableStateOf(false) }
//////////    var ctrlDown by remember { mutableStateOf(false) }
//////////
//////////    val items = remember {
//////////        mutableStateListOf(
//////////            CanvasItem("A", 40f, 40f, 140f, 70f, Color(0xFF3B82F6)),
//////////            CanvasItem("B", 220f, 90f, 160f, 90f, Color(0xFF22C55E)),
//////////            CanvasItem("C", 120f, 220f, 200f, 80f, Color(0xFFF97316)),
//////////            CanvasItem("D", 360f, 210f, 140f, 120f, Color(0xFFA855F7))
//////////        )
//////////    }
//////////
//////////    var selectedIds by remember { mutableStateOf(setOf<String>()) }
//////////    var clipboard by remember { mutableStateOf<List<CanvasItem>>(emptyList()) }
//////////
//////////    val groups = remember { mutableStateMapOf<String, MutableSet<String>>() }
//////////
//////////    var copyCounter by remember { mutableStateOf(1) }
//////////    var groupCounter by remember { mutableStateOf(1) }
//////////    fun newCopyId(): String = "Copy${copyCounter++}"
//////////    fun newGroupId(): String = "G${groupCounter++}"
//////////
//////////    val undoStack = remember { mutableStateListOf<EditorSnapshot>() }
//////////    val redoStack = remember { mutableStateListOf<EditorSnapshot>() }
//////////
//////////    fun snapshot(): EditorSnapshot =
//////////        EditorSnapshot(
//////////            items = items.toList(),
//////////            groups = groups.mapValues { it.value.toSet() },
//////////            selectedIds = selectedIds.toSet(),
//////////            clipboard = clipboard.map { it.copy() },
//////////            copyCounter = copyCounter,
//////////            groupCounter = groupCounter
//////////        )
//////////
//////////    fun restore(s: EditorSnapshot) {
//////////        items.clear()
//////////        items.addAll(s.items)
//////////
//////////        groups.clear()
//////////        for ((gid, set) in s.groups) {
//////////            groups[gid] = set.toMutableSet()
//////////        }
//////////
//////////        selectedIds = s.selectedIds.toSet()
//////////        clipboard = s.clipboard.map { it.copy() }
//////////        copyCounter = s.copyCounter
//////////        groupCounter = s.groupCounter
//////////    }
//////////
//////////    fun pushUndoPoint() {
//////////        undoStack.add(snapshot())
//////////        redoStack.clear()
//////////    }
//////////
//////////    fun undo() {
//////////        if (undoStack.isEmpty()) return
//////////        val prev = undoStack.removeLast()
//////////        redoStack.add(snapshot())
//////////        restore(prev)
//////////    }
//////////
//////////    fun redo() {
//////////        if (redoStack.isEmpty()) return
//////////        val next = redoStack.removeLast()
//////////        undoStack.add(snapshot())
//////////        restore(next)
//////////    }
//////////
//////////    fun recomputeGroupsAfterItemChange() {
//////////        val existing = items.map { it.id }.toSet()
//////////        for ((_, set) in groups) set.removeIf { it !in existing }
//////////        val empty = groups.filterValues { it.isEmpty() }.keys.toList()
//////////        empty.forEach { groups.remove(it) }
//////////    }
//////////
//////////    fun clickSelect(id: String) {
//////////        selectedIds =
//////////            if (shiftDown || ctrlDown) {
//////////                if (id in selectedIds) selectedIds - id else selectedIds + id
//////////            } else setOf(id)
//////////    }
//////////
//////////    fun selectByRect(selectionRect: Rect) {
//////////        val hit = items.filter { it.rect().overlaps(selectionRect) }.map { it.id }.toSet()
//////////        selectedIds =
//////////            if (shiftDown || ctrlDown) selectedIds xor hit else hit
//////////    }
//////////
//////////    fun deleteSelected() {
//////////        if (selectedIds.isEmpty()) return
//////////        pushUndoPoint()
//////////        items.removeAll { it.id in selectedIds }
//////////        selectedIds = emptySet()
//////////        recomputeGroupsAfterItemChange()
//////////    }
//////////
//////////    fun copySelected() {
//////////        clipboard = items.filter { it.id in selectedIds }.map { it.copy() }
//////////    }
//////////
//////////    fun pasteClipboard() {
//////////        if (clipboard.isEmpty()) return
//////////        pushUndoPoint()
//////////        val pasted = clipboard.map { t ->
//////////            t.copy(id = newCopyId(), xPx = t.xPx + 20f, yPx = t.yPx + 20f, groupId = null)
//////////        }
//////////        items.addAll(pasted)
//////////        recomputeGroupsAfterItemChange()
//////////        selectedIds = pasted.map { it.id }.toSet()
//////////    }
//////////
//////////    fun groupSelected() {
//////////        if (selectedIds.size < 2) return
//////////        pushUndoPoint()
//////////
//////////        for ((_, set) in groups) set.removeAll(selectedIds)
//////////
//////////        val gid = newGroupId()
//////////        groups[gid] = selectedIds.toMutableSet()
//////////
//////////        val updated = items.map { it2 -> if (it2.id in selectedIds) it2.copy(groupId = gid) else it2 }
//////////        items.clear(); items.addAll(updated)
//////////        recomputeGroupsAfterItemChange()
//////////    }
//////////
//////////    fun ungroupSelected() {
//////////        val sel = items.filter { it.id in selectedIds }
//////////        val gid = sel.mapNotNull { it.groupId }.distinct().singleOrNull() ?: return
//////////        val groupIds = groups[gid]?.toSet() ?: return
//////////        if (selectedIds != groupIds) return
//////////
//////////        pushUndoPoint()
//////////        groups.remove(gid)
//////////
//////////        val updated = items.map { it2 -> if (it2.groupId == gid) it2.copy(groupId = null) else it2 }
//////////        items.clear(); items.addAll(updated)
//////////        recomputeGroupsAfterItemChange()
//////////    }
//////////
//////////    fun moveItems(ids: Set<String>, delta: Offset) {
//////////        if (ids.isEmpty()) return
//////////        val updated = items.map { it2 -> if (it2.id in ids) it2.movedBy(delta) else it2 }
//////////        items.clear(); items.addAll(updated)
//////////    }
//////////
//////////    var moveUndoArmed by remember { mutableStateOf(false) }
//////////    fun beginMoveUndoIfNeeded() {
//////////        if (!moveUndoArmed) {
//////////            pushUndoPoint()
//////////            moveUndoArmed = true
//////////        }
//////////    }
//////////    fun endMove() { moveUndoArmed = false }
//////////
//////////    val keyHandler = Modifier.onPreviewKeyEvent { e ->
//////////        if (e.type == KeyEventType.KeyDown || e.type == KeyEventType.KeyUp) {
//////////            shiftDown = e.isShiftPressed
//////////            ctrlDown = e.isCtrlPressed
//////////        }
//////////
//////////        if (e.type == KeyEventType.KeyDown) {
//////////            when {
//////////                e.isCtrlPressed && e.key == Key.Z -> { undo(); true }
//////////                e.isCtrlPressed && e.key == Key.Y -> { redo(); true }
//////////                e.isCtrlPressed && e.key == Key.C -> { copySelected(); true }
//////////                e.isCtrlPressed && e.key == Key.V -> { pasteClipboard(); true }
//////////                e.isCtrlPressed && e.key == Key.G && e.isShiftPressed -> { ungroupSelected(); true }
//////////                e.isCtrlPressed && e.key == Key.G -> { groupSelected(); true }
//////////                e.key == Key.Delete -> { deleteSelected(); true }
//////////                else -> false
//////////            }
//////////        } else false
//////////    }
//////////
//////////    val scrollState = rememberScrollState()
//////////    val scope = rememberCoroutineScope()
//////////    val dragScroll = rememberDraggableState { delta ->
//////////        scope.launch { scrollState.scrollBy(-delta) }
//////////    }
//////////
//////////    Column(
//////////        Modifier
//////////            .fillMaxSize()
//////////            .focusRequester(focusRequester)
//////////            .focusable() // Desktop: foundation.focusable
//////////            .then(keyHandler)
//////////            .draggable(state = dragScroll, orientation = Orientation.Vertical)
//////////            .verticalScroll(scrollState)
//////////            .padding(16.dp)
//////////    ) {
//////////        Row(verticalAlignment = Alignment.CenterVertically) {
//////////            Checkbox(checked = selectionEnabled, onCheckedChange = { selectionEnabled = it })
//////////            Spacer(Modifier.width(8.dp))
//////////            Text(if (selectionEnabled) "Selection ON" else "Selection OFF")
//////////            Spacer(Modifier.width(16.dp))
//////////            Text("Ctrl+Z undo | Ctrl+Y redo | Ctrl+C/V | Ctrl+G / Ctrl+Shift+G | Del")
//////////        }
//////////
//////////        Spacer(Modifier.height(10.dp))
//////////
//////////        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//////////            Button(onClick = { ensureKeyboardFocus(); undo() }, enabled = undoStack.isNotEmpty()) { Text("Undo") }
//////////            Button(onClick = { ensureKeyboardFocus(); redo() }, enabled = redoStack.isNotEmpty()) { Text("Redo") }
//////////
//////////            Spacer(Modifier.width(12.dp))
//////////
//////////            Button(onClick = { ensureKeyboardFocus(); copySelected() }, enabled = selectedIds.isNotEmpty()) { Text("Copy") }
//////////            Button(onClick = { ensureKeyboardFocus(); pasteClipboard() }, enabled = clipboard.isNotEmpty()) { Text("Paste") }
//////////            Button(onClick = { ensureKeyboardFocus(); deleteSelected() }, enabled = selectedIds.isNotEmpty()) { Text("Delete") }
//////////            Button(onClick = { ensureKeyboardFocus(); groupSelected() }, enabled = selectedIds.size >= 2) { Text("Group") }
//////////            Button(onClick = { ensureKeyboardFocus(); ungroupSelected() }, enabled = selectedIds.isNotEmpty()) { Text("Ungroup") }
//////////
//////////            Text("Selected: ${selectedIds.size}", modifier = Modifier.align(Alignment.CenterVertically))
//////////        }
//////////
//////////        Spacer(Modifier.height(12.dp))
//////////
//////////        DragHighlightBox(
//////////            enabled = selectionEnabled,
//////////            onSelectionEnd = { rect ->
//////////                ensureKeyboardFocus() // ✅ focus after drag-select
//////////                selectByRect(rect)
//////////            },
//////////            modifier = Modifier
//////////                .fillMaxWidth()
//////////                .height(420.dp)
//////////                .background(Color(0xFF202020))
//////////                .border(1.dp, Color(0xFF444444))
//////////        ) {
//////////            CanvasItemsLayer(
//////////                items = items,
//////////                selectedIds = selectedIds,
//////////                ensureKeyboardFocus = { ensureKeyboardFocus() },
//////////                onClickItem = { id ->
//////////                    ensureKeyboardFocus() // ✅ focus after click-select
//////////                    clickSelect(id)
//////////                },
//////////                onBeginDragItem = { id ->
//////////                    ensureKeyboardFocus() // ✅ focus after drag-start
//////////                    if (id !in selectedIds) clickSelect(id)
//////////                    beginMoveUndoIfNeeded()
//////////                },
//////////                onDragItem = { id, delta ->
//////////                    val moveSet = if (id in selectedIds) selectedIds else setOf(id)
//////////                    moveItems(moveSet, delta)
//////////                },
//////////                onEndDragItem = { endMove() }
//////////            )
//////////        }
//////////    }
//////////}
//////////
//////////@Composable
//////////private fun CanvasItemsLayer(
//////////    items: List<CanvasItem>,
//////////    selectedIds: Set<String>,
//////////    ensureKeyboardFocus: () -> Unit,
//////////    onClickItem: (String) -> Unit,
//////////    onBeginDragItem: (String) -> Unit,
//////////    onDragItem: (String, Offset) -> Unit,
//////////    onEndDragItem: () -> Unit
//////////) {
//////////    val density = LocalDensity.current
//////////
//////////    Box(
//////////        Modifier
//////////            .fillMaxSize()
//////////            // clicking empty canvas also restores focus
//////////            .clickable(
//////////                interactionSource = remember { MutableInteractionSource() },
//////////                indication = null
//////////            ) { ensureKeyboardFocus() }
//////////    ) {
//////////        for (item in items) {
//////////            val isSelected = item.id in selectedIds
//////////            val wDp = with(density) { item.wPx.toDp() }
//////////            val hDp = with(density) { item.hPx.toDp() }
//////////
//////////            Box(
//////////                Modifier
//////////                    .offset { IntOffset(item.xPx.roundToInt(), item.yPx.roundToInt()) }
//////////                    .size(wDp, hDp)
//////////                    .background(item.color)
//////////                    .border(if (isSelected) 2.dp else 0.dp, Color.Yellow)
//////////                    .clickable(
//////////                        interactionSource = remember { MutableInteractionSource() },
//////////                        indication = null
//////////                    ) { onClickItem(item.id) }
//////////                    .pointerInput(item.id) {
//////////                        detectDragGestures(
//////////                            onDragStart = { onBeginDragItem(item.id) },
//////////                            onDrag = { change, dragAmount ->
//////////                                change.consume()
//////////                                onDragItem(item.id, Offset(dragAmount.x, dragAmount.y))
//////////                            },
//////////                            onDragEnd = { onEndDragItem() },
//////////                            onDragCancel = { onEndDragItem() }
//////////                        )
//////////                    }
//////////                    .padding(8.dp)
//////////            ) {
//////////                DisableSelection {
//////////                    Column {
//////////                        Text(item.id, color = Color.White)
//////////                        Text(
//////////                            text = item.groupId?.let { "Group: $it" } ?: "Ungrouped",
//////////                            color = Color(0xFFDDDDDD)
//////////                        )
//////////                    }
//////////                }
//////////            }
//////////        }
//////////    }
//////////}
//////////
//////////private infix fun <T> Set<T>.xor(other: Set<T>): Set<T> {
//////////    val out = this.toMutableSet()
//////////    for (v in other) {
//////////        if (!out.add(v)) out.remove(v)
//////////    }
//////////    return out
//////////}
////////
////////
////////
////////
////////
////////package com.dragfeedback.demo
////////
////////import androidx.compose.foundation.background
////////import androidx.compose.foundation.border
////////import androidx.compose.foundation.clickable
////////import androidx.compose.foundation.focusable
////////import androidx.compose.foundation.gestures.Orientation
////////import androidx.compose.foundation.gestures.detectDragGestures
////////import androidx.compose.foundation.gestures.draggable
////////import androidx.compose.foundation.gestures.rememberDraggableState
////////import androidx.compose.foundation.gestures.scrollBy
////////import androidx.compose.foundation.interaction.MutableInteractionSource
////////import androidx.compose.foundation.layout.*
////////import androidx.compose.foundation.rememberScrollState
////////import androidx.compose.foundation.text.selection.DisableSelection
////////import androidx.compose.foundation.verticalScroll
////////import androidx.compose.material.*
////////import androidx.compose.material.icons.Icons
////////import androidx.compose.material.icons.filled.Clear
////////import androidx.compose.material.icons.filled.Close
////////import androidx.compose.material.icons.filled.ContentCopy
////////import androidx.compose.material.icons.filled.ContentPaste
////////import androidx.compose.material.icons.filled.Delete
////////import androidx.compose.material.icons.filled.Redo
////////import androidx.compose.material.icons.filled.Undo
////////import androidx.compose.material.icons.filled.CallMerge   // group icon-ish
////////import androidx.compose.material.icons.filled.CallSplit   // ungroup icon-ish
////////import androidx.compose.runtime.*
////////import androidx.compose.ui.Alignment
////////import androidx.compose.ui.Modifier
////////import androidx.compose.ui.focus.FocusRequester
////////import androidx.compose.ui.focus.focusRequester
////////import androidx.compose.ui.geometry.Offset
////////import androidx.compose.ui.geometry.Rect
////////import androidx.compose.ui.graphics.Color
////////import androidx.compose.ui.input.key.*
//////////import androidx.compose.ui.input.pointer.consume
////////import androidx.compose.ui.input.pointer.pointerInput
////////import androidx.compose.ui.platform.LocalDensity
////////import androidx.compose.ui.unit.IntOffset
////////import androidx.compose.ui.unit.dp
////////import androidx.compose.ui.window.Window
////////import androidx.compose.ui.window.application
////////import com.dragfeedback.core.DragHighlightBox
////////import kotlinx.coroutines.launch
////////import kotlin.math.roundToInt
////////
////////data class CanvasItem(
////////    val id: String,
////////    val xPx: Float,
////////    val yPx: Float,
////////    val wPx: Float,
////////    val hPx: Float,
////////    val color: Color,
////////    val groupId: String? = null
////////) {
////////    fun rect(): Rect = Rect(xPx, yPx, xPx + wPx, yPx + hPx)
////////    fun movedBy(delta: Offset): CanvasItem = copy(xPx = xPx + delta.x, yPx = yPx + delta.y)
////////}
////////
////////data class EditorSnapshot(
////////    val items: List<CanvasItem>,
////////    val groups: Map<String, Set<String>>,
////////    val selectedIds: Set<String>,
////////    val clipboard: List<CanvasItem>,
////////    val copyCounter: Int,
////////    val groupCounter: Int
////////)
////////
////////fun main() = application {
////////    Window(onCloseRequest = ::exitApplication, title = "Editor Demo") {
////////        DemoScreen()
////////    }
////////}
////////
////////@Composable
////////fun DemoScreen() {
////////    // Root focus so keyboard works immediately
////////    val focusRequester = remember { FocusRequester() }
////////    LaunchedEffect(Unit) { focusRequester.requestFocus() }
////////    fun ensureKeyboardFocus() = focusRequester.requestFocus()
////////
////////    var selectionEnabled by remember { mutableStateOf(true) }
////////    var shiftDown by remember { mutableStateOf(false) }
////////    var ctrlDown by remember { mutableStateOf(false) }
////////
////////    val items = remember {
////////        mutableStateListOf(
////////            CanvasItem("A", 40f, 40f, 140f, 70f, Color(0xFF3B82F6)),
////////            CanvasItem("B", 220f, 90f, 160f, 90f, Color(0xFF22C55E)),
////////            CanvasItem("C", 120f, 220f, 200f, 80f, Color(0xFFF97316)),
////////            CanvasItem("D", 360f, 210f, 140f, 120f, Color(0xFFA855F7))
////////        )
////////    }
////////
////////    var selectedIds by remember { mutableStateOf(setOf<String>()) }
////////    var clipboard by remember { mutableStateOf<List<CanvasItem>>(emptyList()) }
////////    val groups = remember { mutableStateMapOf<String, MutableSet<String>>() }
////////
////////    var copyCounter by remember { mutableStateOf(1) }
////////    var groupCounter by remember { mutableStateOf(1) }
////////    fun newCopyId(): String = "Copy${copyCounter++}"
////////    fun newGroupId(): String = "G${groupCounter++}"
////////
////////    val undoStack = remember { mutableStateListOf<EditorSnapshot>() }
////////    val redoStack = remember { mutableStateListOf<EditorSnapshot>() }
////////
////////    fun snapshot(): EditorSnapshot =
////////        EditorSnapshot(
////////            items = items.toList(),
////////            groups = groups.mapValues { it.value.toSet() },
////////            selectedIds = selectedIds.toSet(),
////////            clipboard = clipboard.map { it.copy() },
////////            copyCounter = copyCounter,
////////            groupCounter = groupCounter
////////        )
////////
////////    fun restore(s: EditorSnapshot) {
////////        items.clear(); items.addAll(s.items)
////////
////////        groups.clear()
////////        for ((gid, set) in s.groups) groups[gid] = set.toMutableSet()
////////
////////        selectedIds = s.selectedIds.toSet()
////////        clipboard = s.clipboard.map { it.copy() }
////////        copyCounter = s.copyCounter
////////        groupCounter = s.groupCounter
////////    }
////////
////////    fun pushUndoPoint() { undoStack.add(snapshot()); redoStack.clear() }
////////    fun undo() { if (undoStack.isNotEmpty()) { val prev = undoStack.removeLast(); redoStack.add(snapshot()); restore(prev) } }
////////    fun redo() { if (redoStack.isNotEmpty()) { val next = redoStack.removeLast(); undoStack.add(snapshot()); restore(next) } }
////////
////////    fun recomputeGroupsAfterItemChange() {
////////        val existing = items.map { it.id }.toSet()
////////        for ((_, set) in groups) set.removeIf { it !in existing }
////////        val empty = groups.filterValues { it.isEmpty() }.keys.toList()
////////        empty.forEach { groups.remove(it) }
////////    }
////////
////////    fun clearSelection() { selectedIds = emptySet() }
////////
////////    fun clickSelect(id: String) {
////////        selectedIds =
////////            if (shiftDown || ctrlDown) {
////////                if (id in selectedIds) selectedIds - id else selectedIds + id
////////            } else setOf(id)
////////    }
////////
////////    fun selectByRect(selectionRect: Rect) {
////////        val hit = items.filter { it.rect().overlaps(selectionRect) }.map { it.id }.toSet()
////////        selectedIds = if (shiftDown || ctrlDown) selectedIds xor hit else hit
////////    }
////////
////////    fun deleteSelected() {
////////        if (selectedIds.isEmpty()) return
////////        pushUndoPoint()
////////        items.removeAll { it.id in selectedIds }
////////        clearSelection()
////////        recomputeGroupsAfterItemChange()
////////    }
////////
////////    fun copySelected() { clipboard = items.filter { it.id in selectedIds }.map { it.copy() } }
////////
////////    fun pasteClipboard() {
////////        if (clipboard.isEmpty()) return
////////        pushUndoPoint()
////////        val pasted = clipboard.map { t -> t.copy(id = newCopyId(), xPx = t.xPx + 20f, yPx = t.yPx + 20f, groupId = null) }
////////        items.addAll(pasted)
////////        recomputeGroupsAfterItemChange()
////////        selectedIds = pasted.map { it.id }.toSet()
////////    }
////////
////////    fun groupSelected() {
////////        if (selectedIds.size < 2) return
////////        pushUndoPoint()
////////        for ((_, set) in groups) set.removeAll(selectedIds)
////////
////////        val gid = newGroupId()
////////        groups[gid] = selectedIds.toMutableSet()
////////
////////        val updated = items.map { it2 -> if (it2.id in selectedIds) it2.copy(groupId = gid) else it2 }
////////        items.clear(); items.addAll(updated)
////////        recomputeGroupsAfterItemChange()
////////    }
////////
////////    fun ungroupSelected() {
////////        val sel = items.filter { it.id in selectedIds }
////////        val gid = sel.mapNotNull { it.groupId }.distinct().singleOrNull() ?: return
////////        val groupIds = groups[gid]?.toSet() ?: return
////////        if (selectedIds != groupIds) return
////////
////////        pushUndoPoint()
////////        groups.remove(gid)
////////
////////        val updated = items.map { it2 -> if (it2.groupId == gid) it2.copy(groupId = null) else it2 }
////////        items.clear(); items.addAll(updated)
////////        recomputeGroupsAfterItemChange()
////////    }
////////
////////    fun moveItems(ids: Set<String>, delta: Offset) {
////////        if (ids.isEmpty()) return
////////        val updated = items.map { it2 -> if (it2.id in ids) it2.movedBy(delta) else it2 }
////////        items.clear(); items.addAll(updated)
////////    }
////////
////////    // push undo ONCE per drag-start
////////    var moveUndoArmed by remember { mutableStateOf(false) }
////////    fun beginMoveUndoIfNeeded() { if (!moveUndoArmed) { pushUndoPoint(); moveUndoArmed = true } }
////////    fun endMove() { moveUndoArmed = false }
////////
////////    // Overlay visibility rules
////////    var overlayVisible by remember { mutableStateOf(false) }
////////    LaunchedEffect(selectedIds) {
////////        overlayVisible = selectedIds.isNotEmpty()
////////    }
////////
////////    val keyHandler = Modifier.onPreviewKeyEvent { e ->
////////        if (e.type == KeyEventType.KeyDown || e.type == KeyEventType.KeyUp) {
////////            shiftDown = e.isShiftPressed
////////            ctrlDown = e.isCtrlPressed
////////        }
////////        if (e.type == KeyEventType.KeyDown) {
////////            when {
////////                e.isCtrlPressed && e.key == Key.Z -> { undo(); true }
////////                e.isCtrlPressed && e.key == Key.Y -> { redo(); true }
////////                e.isCtrlPressed && e.key == Key.C -> { copySelected(); true }
////////                e.isCtrlPressed && e.key == Key.V -> { pasteClipboard(); true }
////////                e.isCtrlPressed && e.key == Key.G && e.isShiftPressed -> { ungroupSelected(); true }
////////                e.isCtrlPressed && e.key == Key.G -> { groupSelected(); true }
////////                e.key == Key.Delete -> { deleteSelected(); true }
////////                else -> false
////////            }
////////        } else false
////////    }
////////
////////    val scrollState = rememberScrollState()
////////    val scope = rememberCoroutineScope()
////////    val dragScroll = rememberDraggableState { delta -> scope.launch { scrollState.scrollBy(-delta) } }
////////
////////    // Root overlay container
////////    Box(
////////        Modifier
////////            .fillMaxSize()
////////            .focusRequester(focusRequester)
////////            .focusable()
////////            .then(keyHandler)
////////    ) {
////////        Column(
////////            Modifier
////////                .fillMaxSize()
////////                .draggable(state = dragScroll, orientation = Orientation.Vertical)
////////                .verticalScroll(scrollState)
////////                .padding(16.dp)
////////        ) {
////////            Row(verticalAlignment = Alignment.CenterVertically) {
////////                Checkbox(checked = selectionEnabled, onCheckedChange = { selectionEnabled = it })
////////                Spacer(Modifier.width(8.dp))
////////                Text(if (selectionEnabled) "Selection ON" else "Selection OFF")
////////            }
////////
////////            Spacer(Modifier.height(12.dp))
////////
////////            DragHighlightBox(
////////                enabled = selectionEnabled,
////////                onSelectionEnd = { rect ->
////////                    ensureKeyboardFocus()
////////                    selectByRect(rect)
////////                },
////////                modifier = Modifier
////////                    .fillMaxWidth()
////////                    .height(420.dp)
////////                    .background(Color(0xFF202020))
////////                    .border(1.dp, Color(0xFF444444))
////////            ) {
////////                CanvasItemsLayer(
////////                    items = items,
////////                    selectedIds = selectedIds,
////////                    ensureKeyboardFocus = { ensureKeyboardFocus() },
////////                    onClickItem = { id ->
////////                        ensureKeyboardFocus()
////////                        clickSelect(id)
////////                    },
////////                    onBeginDragItem = { id ->
////////                        ensureKeyboardFocus()
////////                        if (id !in selectedIds) clickSelect(id)
////////                        beginMoveUndoIfNeeded()
////////                    },
////////                    onDragItem = { id, delta ->
////////                        val moveSet = if (id in selectedIds) selectedIds else setOf(id)
////////                        moveItems(moveSet, delta)
////////                    },
////////                    onEndDragItem = { endMove() }
////////                )
////////            }
////////
////////            Spacer(Modifier.height(600.dp))
////////        }
////////
////////        // ✅ Selection overlay toolbar
////////        if (overlayVisible && selectedIds.isNotEmpty()) {
////////            SelectionOverlay(
////////                modifier = Modifier
////////                    .align(Alignment.TopEnd)
////////                    .padding(16.dp),
////////                selectedCount = selectedIds.size,
////////                canUndo = undoStack.isNotEmpty(),
////////                canRedo = redoStack.isNotEmpty(),
////////                canPaste = clipboard.isNotEmpty(),
////////                canGroup = selectedIds.size >= 2,
////////                onClose = {
////////                    ensureKeyboardFocus()
////////                    overlayVisible = false
////////                    clearSelection() // ✅ requirement: close clears selection
////////                },
////////                onUndo = { ensureKeyboardFocus(); undo() },
////////                onRedo = { ensureKeyboardFocus(); redo() },
////////                onCopy = { ensureKeyboardFocus(); copySelected() },
////////                onPaste = { ensureKeyboardFocus(); pasteClipboard() },
////////                onDelete = { ensureKeyboardFocus(); deleteSelected() },
////////                onGroup = { ensureKeyboardFocus(); groupSelected() },
////////                onUngroup = { ensureKeyboardFocus(); ungroupSelected() },
////////                onClear = { ensureKeyboardFocus(); clearSelection() }
////////            )
////////        }
////////    }
////////}
////////
////////@Composable
////////private fun SelectionOverlay(
////////    modifier: Modifier = Modifier,
////////    selectedCount: Int,
////////    canUndo: Boolean,
////////    canRedo: Boolean,
////////    canPaste: Boolean,
////////    canGroup: Boolean,
////////    onClose: () -> Unit,
////////    onUndo: () -> Unit,
////////    onRedo: () -> Unit,
////////    onCopy: () -> Unit,
////////    onPaste: () -> Unit,
////////    onDelete: () -> Unit,
////////    onGroup: () -> Unit,
////////    onUngroup: () -> Unit,
////////    onClear: () -> Unit
////////) {
////////    Surface(
////////        modifier = modifier,
////////        elevation = 8.dp,
////////        shape = MaterialTheme.shapes.medium
////////    ) {
////////        Column(
////////            Modifier
////////                .background(Color(0xFF2B2B2B))
////////                .border(1.dp, Color(0xFF444444))
////////                .padding(10.dp)
////////                .widthIn(min = 240.dp)
////////        ) {
////////            Row(verticalAlignment = Alignment.CenterVertically) {
////////                Text("Selected: $selectedCount", color = Color.White, modifier = Modifier.weight(1f))
////////                IconButton(onClick = onClose) {
////////                    Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White)
////////                }
////////            }
////////
////////            Spacer(Modifier.height(8.dp))
////////
////////            OverlayActionRow(
////////                Icon = { Icon(Icons.Default.Undo, null) },
////////                text = "Undo",
////////                enabled = canUndo,
////////                onClick = onUndo
////////            )
////////            OverlayActionRow(
////////                Icon = { Icon(Icons.Default.Redo, null) },
////////                text = "Redo",
////////                enabled = canRedo,
////////                onClick = onRedo
////////            )
////////
////////            Spacer(Modifier.height(6.dp))
////////
////////            OverlayActionRow(
////////                Icon = { Icon(Icons.Default.ContentCopy, null) },
////////                text = "Copy",
////////                enabled = true,
////////                onClick = onCopy
////////            )
////////            OverlayActionRow(
////////                Icon = { Icon(Icons.Default.ContentPaste, null) },
////////                text = "Paste",
////////                enabled = canPaste,
////////                onClick = onPaste
////////            )
////////            OverlayActionRow(
////////                Icon = { Icon(Icons.Default.Delete, null) },
////////                text = "Delete",
////////                enabled = true,
////////                onClick = onDelete
////////            )
////////
////////            Spacer(Modifier.height(6.dp))
////////
////////            OverlayActionRow(
////////                Icon = { Icon(Icons.Default.CallMerge, null) },
////////                text = "Group",
////////                enabled = canGroup,
////////                onClick = onGroup
////////            )
////////            OverlayActionRow(
////////                Icon = { Icon(Icons.Default.CallSplit, null) },
////////                text = "Ungroup",
////////                enabled = true,
////////                onClick = onUngroup
////////            )
////////            OverlayActionRow(
////////                Icon = { Icon(Icons.Default.Clear, null) },
////////                text = "Clear Selection",
////////                enabled = true,
////////                onClick = onClear
////////            )
////////        }
////////    }
////////}
////////
////////@Composable
////////private fun OverlayActionRow(
////////    Icon: @Composable () -> Unit,
////////    text: String,
////////    enabled: Boolean,
////////    onClick: () -> Unit
////////) {
////////    TextButton(
////////        onClick = onClick,
////////        enabled = enabled,
////////        modifier = Modifier.fillMaxWidth(),
////////        colors = ButtonDefaults.textButtonColors(contentColor = Color.White)
////////    ) {
////////        Box(Modifier.size(18.dp)) { Icon() }
////////        Spacer(Modifier.width(10.dp))
////////        Text(text, color = Color.White)
////////    }
////////}
////////
////////@Composable
////////private fun CanvasItemsLayer(
////////    items: List<CanvasItem>,
////////    selectedIds: Set<String>,
////////    ensureKeyboardFocus: () -> Unit,
////////    onClickItem: (String) -> Unit,
////////    onBeginDragItem: (String) -> Unit,
////////    onDragItem: (String, Offset) -> Unit,
////////    onEndDragItem: () -> Unit
////////) {
////////    val density = LocalDensity.current
////////
////////    Box(
////////        Modifier
////////            .fillMaxSize()
////////            .clickable(
////////                interactionSource = remember { MutableInteractionSource() },
////////                indication = null
////////            ) { ensureKeyboardFocus() }
////////    ) {
////////        for (item in items) {
////////            val isSelected = item.id in selectedIds
////////            val wDp = with(density) { item.wPx.toDp() }
////////            val hDp = with(density) { item.hPx.toDp() }
////////
////////            Box(
////////                Modifier
////////                    .offset { IntOffset(item.xPx.roundToInt(), item.yPx.roundToInt()) }
////////                    .size(wDp, hDp)
////////                    .background(item.color)
////////                    .border(if (isSelected) 2.dp else 0.dp, Color.Yellow)
////////                    .clickable(
////////                        interactionSource = remember { MutableInteractionSource() },
////////                        indication = null
////////                    ) { onClickItem(item.id) }
////////                    .pointerInput(item.id) {
////////                        detectDragGestures(
////////                            onDragStart = { onBeginDragItem(item.id) },
////////                            onDrag = { change, dragAmount ->
////////                                change.consume()
////////                                onDragItem(item.id, Offset(dragAmount.x, dragAmount.y))
////////                            },
////////                            onDragEnd = { onEndDragItem() },
////////                            onDragCancel = { onEndDragItem() }
////////                        )
////////                    }
////////                    .padding(8.dp)
////////            ) {
////////                DisableSelection {
////////                    Column {
////////                        Text(item.id, color = Color.White)
////////                        Text(
////////                            text = item.groupId?.let { "Group: $it" } ?: "Ungrouped",
////////                            color = Color(0xFFDDDDDD)
////////                        )
////////                    }
////////                }
////////            }
////////        }
////////    }
////////}
////////
////////private infix fun <T> Set<T>.xor(other: Set<T>): Set<T> {
////////    val out = this.toMutableSet()
////////    for (v in other) {
////////        if (!out.add(v)) out.remove(v)
////////    }
////////    return out
////////}
//////
//////
//////
//////
//////
//////package com.dragfeedback.demo
//////
////////import androidx.compose.foundation.ExperimentalLayoutApi
//////import androidx.compose.foundation.background
//////import androidx.compose.foundation.border
//////import androidx.compose.foundation.clickable
//////import androidx.compose.foundation.focusable
//////import androidx.compose.foundation.gestures.Orientation
//////import androidx.compose.foundation.gestures.detectDragGestures
//////import androidx.compose.foundation.gestures.draggable
//////import androidx.compose.foundation.gestures.rememberDraggableState
//////import androidx.compose.foundation.gestures.scrollBy
//////import androidx.compose.foundation.interaction.MutableInteractionSource
//////import androidx.compose.foundation.layout.*
//////import androidx.compose.foundation.layout.FlowRow
//////import androidx.compose.foundation.rememberScrollState
//////import androidx.compose.foundation.text.selection.DisableSelection
//////import androidx.compose.foundation.verticalScroll
//////import androidx.compose.material.*
//////import androidx.compose.material.icons.Icons
//////import androidx.compose.material.icons.filled.CallMerge
//////import androidx.compose.material.icons.filled.CallSplit
//////import androidx.compose.material.icons.filled.Clear
//////import androidx.compose.material.icons.filled.Close
//////import androidx.compose.material.icons.filled.ContentCopy
//////import androidx.compose.material.icons.filled.ContentPaste
//////import androidx.compose.material.icons.filled.Delete
//////import androidx.compose.material.icons.filled.Redo
//////import androidx.compose.material.icons.filled.Undo
//////import androidx.compose.runtime.*
//////import androidx.compose.ui.Alignment
//////import androidx.compose.ui.Modifier
//////import androidx.compose.ui.focus.FocusRequester
//////import androidx.compose.ui.focus.focusRequester
//////import androidx.compose.ui.geometry.Offset
//////import androidx.compose.ui.geometry.Rect
//////import androidx.compose.ui.graphics.Color
//////import androidx.compose.ui.input.key.*
////////import androidx.compose.ui.input.pointer.consume
//////import androidx.compose.ui.input.pointer.pointerInput
//////import androidx.compose.ui.platform.LocalDensity
//////import androidx.compose.ui.unit.IntOffset
//////import androidx.compose.ui.unit.dp
//////import androidx.compose.ui.window.Window
//////import androidx.compose.ui.window.application
//////import com.dragfeedback.core.DragHighlightBox
//////import kotlinx.coroutines.launch
//////import kotlin.math.roundToInt
//////
//////// ---------------- Models ----------------
//////data class CanvasItem(
//////    val id: String,
//////    val xPx: Float,
//////    val yPx: Float,
//////    val wPx: Float,
//////    val hPx: Float,
//////    val color: Color,
//////    val groupId: String? = null
//////) {
//////    fun rect(): Rect = Rect(xPx, yPx, xPx + wPx, yPx + hPx)
//////    fun movedBy(delta: Offset): CanvasItem = copy(xPx = xPx + delta.x, yPx = yPx + delta.y)
//////}
//////
//////data class EditorSnapshot(
//////    val items: List<CanvasItem>,
//////    val groups: Map<String, Set<String>>,
//////    val selectedIds: Set<String>,
//////    val clipboard: List<CanvasItem>,
//////    val copyCounter: Int,
//////    val groupCounter: Int
//////)
//////
//////data class OverlayAction(
//////    val text: String,
//////    val enabled: Boolean = true,
//////    val icon: (@Composable () -> Unit)? = null,
//////    val onClick: () -> Unit
//////)
//////
//////// ---------------- App ----------------
//////fun main() = application {
//////    Window(onCloseRequest = ::exitApplication, title = "Editor Demo") {
//////        DemoScreen()
//////    }
//////}
//////
//////@Composable
//////fun DemoScreen() {
//////    // Focus so keyboard works immediately
//////    val focusRequester = remember { FocusRequester() }
//////    LaunchedEffect(Unit) { focusRequester.requestFocus() }
//////    fun ensureKeyboardFocus() = focusRequester.requestFocus()
//////
//////    var selectionEnabled by remember { mutableStateOf(true) }
//////    var shiftDown by remember { mutableStateOf(false) }
//////    var ctrlDown by remember { mutableStateOf(false) }
//////
//////    val items = remember {
//////        mutableStateListOf(
//////            CanvasItem("A", 40f, 40f, 140f, 70f, Color(0xFF3B82F6)),
//////            CanvasItem("B", 220f, 90f, 160f, 90f, Color(0xFF22C55E)),
//////            CanvasItem("C", 120f, 220f, 200f, 80f, Color(0xFFF97316)),
//////            CanvasItem("D", 360f, 210f, 140f, 120f, Color(0xFFA855F7))
//////        )
//////    }
//////
//////    var selectedIds by remember { mutableStateOf(setOf<String>()) }
//////    var clipboard by remember { mutableStateOf<List<CanvasItem>>(emptyList()) }
//////
//////    val groups = remember { mutableStateMapOf<String, MutableSet<String>>() }
//////
//////    var copyCounter by remember { mutableStateOf(1) }
//////    var groupCounter by remember { mutableStateOf(1) }
//////    fun newCopyId(): String = "Copy${copyCounter++}"
//////    fun newGroupId(): String = "G${groupCounter++}"
//////
//////    val undoStack = remember { mutableStateListOf<EditorSnapshot>() }
//////    val redoStack = remember { mutableStateListOf<EditorSnapshot>() }
//////
//////    fun snapshot(): EditorSnapshot =
//////        EditorSnapshot(
//////            items = items.toList(),
//////            groups = groups.mapValues { it.value.toSet() },
//////            selectedIds = selectedIds.toSet(),
//////            clipboard = clipboard.map { it.copy() },
//////            copyCounter = copyCounter,
//////            groupCounter = groupCounter
//////        )
//////
//////    fun restore(s: EditorSnapshot) {
//////        items.clear(); items.addAll(s.items)
//////        groups.clear()
//////        for ((gid, set) in s.groups) groups[gid] = set.toMutableSet()
//////        selectedIds = s.selectedIds.toSet()
//////        clipboard = s.clipboard.map { it.copy() }
//////        copyCounter = s.copyCounter
//////        groupCounter = s.groupCounter
//////    }
//////
//////    fun pushUndoPoint() { undoStack.add(snapshot()); redoStack.clear() }
//////    fun undo() { if (undoStack.isNotEmpty()) { val prev = undoStack.removeLast(); redoStack.add(snapshot()); restore(prev) } }
//////    fun redo() { if (redoStack.isNotEmpty()) { val next = redoStack.removeLast(); undoStack.add(snapshot()); restore(next) } }
//////
//////    fun recomputeGroupsAfterItemChange() {
//////        val existing = items.map { it.id }.toSet()
//////        for ((_, set) in groups) set.removeIf { it !in existing }
//////        val empty = groups.filterValues { it.isEmpty() }.keys.toList()
//////        empty.forEach { groups.remove(it) }
//////    }
//////
//////    fun clearSelection() { selectedIds = emptySet() }
//////
//////    fun clickSelect(id: String) {
//////        selectedIds =
//////            if (shiftDown || ctrlDown) {
//////                if (id in selectedIds) selectedIds - id else selectedIds + id
//////            } else setOf(id)
//////    }
//////
//////    fun selectByRect(selectionRect: Rect) {
//////        val hit = items.filter { it.rect().overlaps(selectionRect) }.map { it.id }.toSet()
//////        selectedIds = if (shiftDown || ctrlDown) selectedIds xor hit else hit
//////    }
//////
//////    fun deleteSelected() {
//////        if (selectedIds.isEmpty()) return
//////        pushUndoPoint()
//////        items.removeAll { it.id in selectedIds }
//////        clearSelection()
//////        recomputeGroupsAfterItemChange()
//////    }
//////
//////    fun copySelected() { clipboard = items.filter { it.id in selectedIds }.map { it.copy() } }
//////
//////    fun pasteClipboard() {
//////        if (clipboard.isEmpty()) return
//////        pushUndoPoint()
//////        val pasted = clipboard.map { t ->
//////            t.copy(id = newCopyId(), xPx = t.xPx + 20f, yPx = t.yPx + 20f, groupId = null)
//////        }
//////        items.addAll(pasted)
//////        recomputeGroupsAfterItemChange()
//////        selectedIds = pasted.map { it.id }.toSet()
//////    }
//////
//////    fun groupSelected() {
//////        if (selectedIds.size < 2) return
//////        pushUndoPoint()
//////        for ((_, set) in groups) set.removeAll(selectedIds)
//////
//////        val gid = newGroupId()
//////        groups[gid] = selectedIds.toMutableSet()
//////
//////        val updated = items.map { it2 -> if (it2.id in selectedIds) it2.copy(groupId = gid) else it2 }
//////        items.clear(); items.addAll(updated)
//////        recomputeGroupsAfterItemChange()
//////    }
//////
//////    fun ungroupSelected() {
//////        val sel = items.filter { it.id in selectedIds }
//////        val gid = sel.mapNotNull { it.groupId }.distinct().singleOrNull() ?: return
//////        val groupIds = groups[gid]?.toSet() ?: return
//////        if (selectedIds != groupIds) return
//////
//////        pushUndoPoint()
//////        groups.remove(gid)
//////
//////        val updated = items.map { it2 -> if (it2.groupId == gid) it2.copy(groupId = null) else it2 }
//////        items.clear(); items.addAll(updated)
//////        recomputeGroupsAfterItemChange()
//////    }
//////
//////    fun moveItems(ids: Set<String>, delta: Offset) {
//////        if (ids.isEmpty()) return
//////        val updated = items.map { it2 -> if (it2.id in ids) it2.movedBy(delta) else it2 }
//////        items.clear(); items.addAll(updated)
//////    }
//////
//////    // Move undo: one snapshot per drag start
//////    var moveUndoArmed by remember { mutableStateOf(false) }
//////    fun beginMoveUndoIfNeeded() { if (!moveUndoArmed) { pushUndoPoint(); moveUndoArmed = true } }
//////    fun endMove() { moveUndoArmed = false }
//////
//////    // Overlay visibility: show whenever selection exists
//////    var overlayVisible by remember { mutableStateOf(false) }
//////    LaunchedEffect(selectedIds) { overlayVisible = selectedIds.isNotEmpty() }
//////
//////    // Keyboard shortcuts
//////    val keyHandler = Modifier.onPreviewKeyEvent { e ->
//////        if (e.type == KeyEventType.KeyDown || e.type == KeyEventType.KeyUp) {
//////            shiftDown = e.isShiftPressed
//////            ctrlDown = e.isCtrlPressed
//////        }
//////
//////        if (e.type == KeyEventType.KeyDown) {
//////            when {
//////                e.isCtrlPressed && e.key == Key.Z -> { undo(); true }
//////                e.isCtrlPressed && e.key == Key.Y -> { redo(); true }
//////                e.isCtrlPressed && e.key == Key.C -> { copySelected(); true }
//////                e.isCtrlPressed && e.key == Key.V -> { pasteClipboard(); true }
//////                e.isCtrlPressed && e.key == Key.G && e.isShiftPressed -> { ungroupSelected(); true }
//////                e.isCtrlPressed && e.key == Key.G -> { groupSelected(); true }
//////                e.key == Key.Delete -> { deleteSelected(); true }
//////                else -> false
//////            }
//////        } else false
//////    }
//////
//////    // Parent drag-scroll
//////    val scrollState = rememberScrollState()
//////    val scope = rememberCoroutineScope()
//////    val dragScroll = rememberDraggableState { delta -> scope.launch { scrollState.scrollBy(-delta) } }
//////
//////    // Root overlay container
//////    Box(
//////        Modifier
//////            .fillMaxSize()
//////            .focusRequester(focusRequester)
//////            .focusable()
//////            .then(keyHandler)
//////    ) {
//////        Column(
//////            Modifier
//////                .fillMaxSize()
//////                .draggable(state = dragScroll, orientation = Orientation.Vertical)
//////                .verticalScroll(scrollState)
//////                .padding(16.dp)
//////        ) {
//////            Row(verticalAlignment = Alignment.CenterVertically) {
//////                Checkbox(checked = selectionEnabled, onCheckedChange = { selectionEnabled = it })
//////                Spacer(Modifier.width(8.dp))
//////                Text(if (selectionEnabled) "Selection ON" else "Selection OFF")
//////            }
//////
//////            Spacer(Modifier.height(12.dp))
//////
//////            DragHighlightBox(
//////                enabled = selectionEnabled,
//////                onSelectionEnd = { rect ->
//////                    ensureKeyboardFocus()
//////                    selectByRect(rect)
//////                },
//////                modifier = Modifier
//////                    .fillMaxWidth()
//////                    .height(420.dp)
//////                    .background(Color(0xFF202020))
//////                    .border(1.dp, Color(0xFF444444))
//////            ) {
//////                CanvasItemsLayer(
//////                    items = items,
//////                    selectedIds = selectedIds,
//////                    ensureKeyboardFocus = { ensureKeyboardFocus() },
//////                    onClickItem = { id ->
//////                        ensureKeyboardFocus()
//////                        clickSelect(id)
//////                    },
//////                    onBeginDragItem = { id ->
//////                        ensureKeyboardFocus()
//////                        if (id !in selectedIds) clickSelect(id)
//////                        beginMoveUndoIfNeeded()
//////                    },
//////                    onDragItem = { id, delta ->
//////                        val moveSet = if (id in selectedIds) selectedIds else setOf(id)
//////                        moveItems(moveSet, delta)
//////                    },
//////                    onEndDragItem = { endMove() }
//////                )
//////            }
//////
//////            Spacer(Modifier.height(500.dp))
//////        }
//////
//////        // Actions for overlay (you can swap any icon with Image(...) here)
//////        val overlayActions = remember(
//////            selectedIds, clipboard, undoStack.size, redoStack.size
//////        ) {
//////            listOf(
//////                OverlayAction(
//////                    text = "Undo",
//////                    enabled = undoStack.isNotEmpty(),
//////                    icon = { Icon(Icons.Filled.Undo, null, tint = Color.White) },
//////                    onClick = { ensureKeyboardFocus(); undo() }
//////                ),
//////                OverlayAction(
//////                    text = "Redo",
//////                    enabled = redoStack.isNotEmpty(),
//////                    icon = { Icon(Icons.Filled.Redo, null, tint = Color.White) },
//////                    onClick = { ensureKeyboardFocus(); redo() }
//////                ),
//////                OverlayAction(
//////                    text = "Copy",
//////                    enabled = true,
//////                    icon = { Icon(Icons.Filled.ContentCopy, null, tint = Color.White) },
//////                    onClick = { ensureKeyboardFocus(); copySelected() }
//////                ),
//////                OverlayAction(
//////                    text = "Paste",
//////                    enabled = clipboard.isNotEmpty(),
//////                    icon = { Icon(Icons.Filled.ContentPaste, null, tint = Color.White) },
//////                    onClick = { ensureKeyboardFocus(); pasteClipboard() }
//////                ),
//////                OverlayAction(
//////                    text = "Delete",
//////                    enabled = true,
//////                    icon = { Icon(Icons.Filled.Delete, null, tint = Color.White) },
//////                    onClick = { ensureKeyboardFocus(); deleteSelected() }
//////                ),
//////                OverlayAction(
//////                    text = "Group",
//////                    enabled = selectedIds.size >= 2,
//////                    icon = { Icon(Icons.Filled.CallMerge, null, tint = Color.White) },
//////                    onClick = { ensureKeyboardFocus(); groupSelected() }
//////                ),
//////                OverlayAction(
//////                    text = "Ungroup",
//////                    enabled = true,
//////                    icon = { Icon(Icons.Filled.CallSplit, null, tint = Color.White) },
//////                    onClick = { ensureKeyboardFocus(); ungroupSelected() }
//////                ),
//////                OverlayAction(
//////                    text = "Clear",
//////                    enabled = true,
//////                    icon = { Icon(Icons.Filled.Clear, null, tint = Color.White) },
//////                    onClick = { ensureKeyboardFocus(); clearSelection() }
//////                )
//////            )
//////        }
//////
//////        // Overlay shows when there is selection
//////        if (overlayVisible && selectedIds.isNotEmpty()) {
//////            SelectionOverlay(
//////                modifier = Modifier
//////                    .align(Alignment.TopEnd)
//////                    .padding(16.dp),
//////                selectedCount = selectedIds.size,
//////                actions = overlayActions,
//////                onClose = {
//////                    ensureKeyboardFocus()
//////                    overlayVisible = false
//////                    clearSelection()
//////                }
//////            )
//////        }
//////    }
//////}
//////
//////@OptIn(ExperimentalLayoutApi::class)
//////@Composable
//////private fun SelectionOverlay(
//////    modifier: Modifier = Modifier,
//////    selectedCount: Int,
//////    actions: List<OverlayAction>,
//////    onClose: () -> Unit
//////) {
//////    Surface(modifier = modifier, elevation = 8.dp, shape = MaterialTheme.shapes.medium) {
//////        Column(
//////            Modifier
//////                .background(Color(0xFF2B2B2B))
//////                .border(1.dp, Color(0xFF444444))
//////                .padding(10.dp)
//////                .wrapContentHeight()
//////                .widthIn(min = 260.dp)
//////        ) {
//////            Row(verticalAlignment = Alignment.CenterVertically) {
//////                Text("Selected: $selectedCount", color = Color.White, modifier = Modifier.weight(1f))
//////                IconButton(onClick = onClose) {
//////                    Icon(Icons.Filled.Close, contentDescription = "Close", tint = Color.White)
//////                }
//////            }
//////
//////            Spacer(Modifier.height(8.dp))
//////
//////            FlowRow(
//////                horizontalArrangement = Arrangement.spacedBy(8.dp),
//////                verticalArrangement = Arrangement.spacedBy(8.dp),
//////                maxItemsInEachRow = 4
//////            ) {
//////                actions.forEach { a ->
//////                    OverlayChip(
//////                        icon = a.icon,
//////                        text = a.text,
//////                        enabled = a.enabled,
//////                        onClick = a.onClick
//////                    )
//////                }
//////            }
//////        }
//////    }
//////}
//////
//////@Composable
//////private fun OverlayChip(
//////    icon: (@Composable () -> Unit)?,
//////    text: String,
//////    enabled: Boolean,
//////    onClick: () -> Unit
//////) {
//////    Surface(
//////        shape = MaterialTheme.shapes.small,
//////        color = if (enabled) Color(0xFF3A3A3A) else Color(0xFF2A2A2A),
//////        modifier = Modifier.heightIn(min = 36.dp)
//////    ) {
//////        Row(
//////            modifier = Modifier
//////                .clickable(enabled = enabled, onClick = onClick)
//////                .padding(horizontal = 10.dp, vertical = 8.dp),
//////            verticalAlignment = Alignment.CenterVertically
//////        ) {
//////            if (icon != null) {
//////                Box(Modifier.size(18.dp)) { icon() }
//////                Spacer(Modifier.width(8.dp))
//////            }
//////            Text(text, color = Color.White)
//////        }
//////    }
//////}
//////
//////@Composable
//////private fun CanvasItemsLayer(
//////    items: List<CanvasItem>,
//////    selectedIds: Set<String>,
//////    ensureKeyboardFocus: () -> Unit,
//////    onClickItem: (String) -> Unit,
//////    onBeginDragItem: (String) -> Unit,
//////    onDragItem: (String, Offset) -> Unit,
//////    onEndDragItem: () -> Unit
//////) {
//////    val density = LocalDensity.current
//////
//////    Box(
//////        Modifier
//////            .fillMaxSize()
//////            .clickable(
//////                interactionSource = remember { MutableInteractionSource() },
//////                indication = null
//////            ) { ensureKeyboardFocus() }
//////    ) {
//////        for (item in items) {
//////            val isSelected = item.id in selectedIds
//////            val wDp = with(density) { item.wPx.toDp() }
//////            val hDp = with(density) { item.hPx.toDp() }
//////
//////            Box(
//////                Modifier
//////                    .offset { IntOffset(item.xPx.roundToInt(), item.yPx.roundToInt()) }
//////                    .size(wDp, hDp)
//////                    .background(item.color)
//////                    .border(if (isSelected) 2.dp else 0.dp, Color.Yellow)
//////                    .clickable(
//////                        interactionSource = remember { MutableInteractionSource() },
//////                        indication = null
//////                    ) { onClickItem(item.id) }
//////                    .pointerInput(item.id) {
//////                        detectDragGestures(
//////                            onDragStart = { onBeginDragItem(item.id) },
//////                            onDrag = { change, dragAmount ->
//////                                change.consume()
//////                                onDragItem(item.id, Offset(dragAmount.x, dragAmount.y))
//////                            },
//////                            onDragEnd = { onEndDragItem() },
//////                            onDragCancel = { onEndDragItem() }
//////                        )
//////                    }
//////                    .padding(8.dp)
//////            ) {
//////                DisableSelection {
//////                    Column {
//////                        Text(item.id, color = Color.White)
//////                        Text(
//////                            text = item.groupId?.let { "Group: $it" } ?: "Ungrouped",
//////                            color = Color(0xFFDDDDDD)
//////                        )
//////                    }
//////                }
//////            }
//////        }
//////    }
//////}
//////
//////private infix fun <T> Set<T>.xor(other: Set<T>): Set<T> {
//////    val out = this.toMutableSet()
//////    for (v in other) {
//////        if (!out.add(v)) out.remove(v)
//////    }
//////    return out
//////}
////
////
////
////
////package com.dragfeedback.demo
////
////import androidx.compose.foundation.background
////import androidx.compose.foundation.border
////import androidx.compose.foundation.clickable
////import androidx.compose.foundation.focusable
////import androidx.compose.foundation.gestures.Orientation
////import androidx.compose.foundation.gestures.detectDragGestures
////import androidx.compose.foundation.gestures.draggable
////import androidx.compose.foundation.gestures.rememberDraggableState
////import androidx.compose.foundation.gestures.scrollBy
////import androidx.compose.foundation.interaction.MutableInteractionSource
////import androidx.compose.foundation.layout.*
////import androidx.compose.foundation.rememberScrollState
////import androidx.compose.foundation.text.selection.DisableSelection
////import androidx.compose.foundation.verticalScroll
////import androidx.compose.material.Checkbox
////import androidx.compose.material.Text
////import androidx.compose.material.icons.Icons
////import androidx.compose.material.icons.filled.CallMerge
////import androidx.compose.material.icons.filled.CallSplit
////import androidx.compose.material.icons.filled.Clear
////import androidx.compose.material.icons.filled.ContentCopy
////import androidx.compose.material.icons.filled.ContentPaste
////import androidx.compose.material.icons.filled.Delete
////import androidx.compose.material.icons.filled.Redo
////import androidx.compose.material.icons.filled.Undo
////import androidx.compose.material.Icon
////import androidx.compose.runtime.*
////import androidx.compose.ui.Alignment
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.focus.FocusRequester
////import androidx.compose.ui.focus.focusRequester
////import androidx.compose.ui.geometry.Offset
////import androidx.compose.ui.geometry.Rect
////import androidx.compose.ui.graphics.Color
////import androidx.compose.ui.input.key.*
//////import androidx.compose.ui.input.pointer.consume
////import androidx.compose.ui.input.pointer.pointerInput
////import androidx.compose.ui.platform.LocalDensity
////import androidx.compose.ui.unit.IntOffset
////import androidx.compose.ui.unit.dp
////import androidx.compose.ui.window.Window
////import androidx.compose.ui.window.application
////import com.dragfeedback.core.DragHighlightBox
//////import com.drawFeedback.demo.OverlayAction
//////import com.drawFeedback.demo.OverlayStyle
//////import com.drawFeedback.demo.SelectionOverlay
////import kotlinx.coroutines.launch
////import kotlin.math.roundToInt
////
////data class CanvasItem(
////    val id: String,
////    val xPx: Float,
////    val yPx: Float,
////    val wPx: Float,
////    val hPx: Float,
////    val color: Color,
////    val groupId: String? = null
////) {
////    fun rect(): Rect = Rect(xPx, yPx, xPx + wPx, yPx + hPx)
////    fun movedBy(delta: Offset): CanvasItem = copy(xPx = xPx + delta.x, yPx = yPx + delta.y)
////}
////
////data class EditorSnapshot(
////    val items: List<CanvasItem>,
////    val groups: Map<String, Set<String>>,
////    val selectedIds: Set<String>,
////    val clipboard: List<CanvasItem>,
////    val copyCounter: Int,
////    val groupCounter: Int
////)
////
////fun main() = application {
////    Window(onCloseRequest = ::exitApplication, title = "Editor Demo") {
////        DemoScreen()
////    }
////}
////
////@Composable
////fun DemoScreen() {
////    // keyboard focus
////    val focusRequester = remember { FocusRequester() }
////    LaunchedEffect(Unit) { focusRequester.requestFocus() }
////    fun ensureKeyboardFocus() = focusRequester.requestFocus()
////
////    var selectionEnabled by remember { mutableStateOf(true) }
////    var shiftDown by remember { mutableStateOf(false) }
////    var ctrlDown by remember { mutableStateOf(false) }
////
////    val items = remember {
////        mutableStateListOf(
////            CanvasItem("A", 40f, 40f, 140f, 70f, Color(0xFF3B82F6)),
////            CanvasItem("B", 220f, 90f, 160f, 90f, Color(0xFF22C55E)),
////            CanvasItem("C", 120f, 220f, 200f, 80f, Color(0xFFF97316)),
////            CanvasItem("D", 360f, 210f, 140f, 120f, Color(0xFFA855F7))
////        )
////    }
////
////    var selectedIds by remember { mutableStateOf(setOf<String>()) }
////    var clipboard by remember { mutableStateOf<List<CanvasItem>>(emptyList()) }
////    val groups = remember { mutableStateMapOf<String, MutableSet<String>>() }
////
////    var copyCounter by remember { mutableStateOf(1) }
////    var groupCounter by remember { mutableStateOf(1) }
////    fun newCopyId(): String = "Copy${copyCounter++}"
////    fun newGroupId(): String = "G${groupCounter++}"
////
////    val undoStack = remember { mutableStateListOf<EditorSnapshot>() }
////    val redoStack = remember { mutableStateListOf<EditorSnapshot>() }
////
////    fun snapshot(): EditorSnapshot =
////        EditorSnapshot(
////            items = items.toList(),
////            groups = groups.mapValues { it.value.toSet() },
////            selectedIds = selectedIds.toSet(),
////            clipboard = clipboard.map { it.copy() },
////            copyCounter = copyCounter,
////            groupCounter = groupCounter
////        )
////
////    fun restore(s: EditorSnapshot) {
////        items.clear(); items.addAll(s.items)
////        groups.clear()
////        for ((gid, set) in s.groups) groups[gid] = set.toMutableSet()
////        selectedIds = s.selectedIds.toSet()
////        clipboard = s.clipboard.map { it.copy() }
////        copyCounter = s.copyCounter
////        groupCounter = s.groupCounter
////    }
////
////    fun pushUndoPoint() { undoStack.add(snapshot()); redoStack.clear() }
////    fun undo() { if (undoStack.isNotEmpty()) { val prev = undoStack.removeLast(); redoStack.add(snapshot()); restore(prev) } }
////    fun redo() { if (redoStack.isNotEmpty()) { val next = redoStack.removeLast(); undoStack.add(snapshot()); restore(next) } }
////
////    fun recomputeGroupsAfterItemChange() {
////        val existing = items.map { it.id }.toSet()
////        for ((_, set) in groups) set.removeIf { it !in existing }
////        val empty = groups.filterValues { it.isEmpty() }.keys.toList()
////        empty.forEach { groups.remove(it) }
////    }
////
////    fun clearSelection() { selectedIds = emptySet() }
////
////    fun clickSelect(id: String) {
////        selectedIds =
////            if (shiftDown || ctrlDown) {
////                if (id in selectedIds) selectedIds - id else selectedIds + id
////            } else setOf(id)
////    }
////
////    fun selectByRect(selectionRect: Rect) {
////        val hit = items.filter { it.rect().overlaps(selectionRect) }.map { it.id }.toSet()
////        selectedIds = if (shiftDown || ctrlDown) selectedIds xor hit else hit
////    }
////
////    fun deleteSelected() {
////        if (selectedIds.isEmpty()) return
////        pushUndoPoint()
////        items.removeAll { it.id in selectedIds }
////        clearSelection()
////        recomputeGroupsAfterItemChange()
////    }
////
////    fun copySelected() { clipboard = items.filter { it.id in selectedIds }.map { it.copy() } }
////
////    fun pasteClipboard() {
////        if (clipboard.isEmpty()) return
////        pushUndoPoint()
////        val pasted = clipboard.map { t ->
////            t.copy(id = newCopyId(), xPx = t.xPx + 20f, yPx = t.yPx + 20f, groupId = null)
////        }
////        items.addAll(pasted)
////        recomputeGroupsAfterItemChange()
////        selectedIds = pasted.map { it.id }.toSet()
////    }
////
////    fun groupSelected() {
////        if (selectedIds.size < 2) return
////        pushUndoPoint()
////        for ((_, set) in groups) set.removeAll(selectedIds)
////
////        val gid = newGroupId()
////        groups[gid] = selectedIds.toMutableSet()
////
////        val updated = items.map { it2 -> if (it2.id in selectedIds) it2.copy(groupId = gid) else it2 }
////        items.clear(); items.addAll(updated)
////        recomputeGroupsAfterItemChange()
////    }
////
////    fun ungroupSelected() {
////        val sel = items.filter { it.id in selectedIds }
////        val gid = sel.mapNotNull { it.groupId }.distinct().singleOrNull() ?: return
////        val groupIds = groups[gid]?.toSet() ?: return
////        if (selectedIds != groupIds) return
////
////        pushUndoPoint()
////        groups.remove(gid)
////
////        val updated = items.map { it2 -> if (it2.groupId == gid) it2.copy(groupId = null) else it2 }
////        items.clear(); items.addAll(updated)
////        recomputeGroupsAfterItemChange()
////    }
////
////    fun moveItems(ids: Set<String>, delta: Offset) {
////        if (ids.isEmpty()) return
////        val updated = items.map { it2 -> if (it2.id in ids) it2.movedBy(delta) else it2 }
////        items.clear(); items.addAll(updated)
////    }
////
////    var moveUndoArmed by remember { mutableStateOf(false) }
////    fun beginMoveUndoIfNeeded() { if (!moveUndoArmed) { pushUndoPoint(); moveUndoArmed = true } }
////    fun endMove() { moveUndoArmed = false }
////
////    // Overlay show/hide + position
////    var overlayVisible by remember { mutableStateOf(false) }
////    LaunchedEffect(selectedIds) { overlayVisible = selectedIds.isNotEmpty() }
////
////    // Start position (pixels) - you can change initial placement
////    var overlayPosPx by remember { mutableStateOf(Offset(40f, 40f)) }
////
////    // Overlay styling customization example
////    val overlayStyle = remember {
////        OverlayStyle(
////            background = Color(0xFF1F2937),
////            borderColor = Color(0xFF374151),
////            chipColor = Color(0xFF334155),
////            chipDisabledColor = Color(0xFF223044),
////            closeButtonGap = 8.dp
////        )
////    }
////
////    val keyHandler = Modifier.onPreviewKeyEvent { e ->
////        if (e.type == KeyEventType.KeyDown || e.type == KeyEventType.KeyUp) {
////            shiftDown = e.isShiftPressed
////            ctrlDown = e.isCtrlPressed
////        }
////        if (e.type == KeyEventType.KeyDown) {
////            when {
////                e.isCtrlPressed && e.key == Key.Z -> { undo(); true }
////                e.isCtrlPressed && e.key == Key.Y -> { redo(); true }
////                e.isCtrlPressed && e.key == Key.C -> { copySelected(); true }
////                e.isCtrlPressed && e.key == Key.V -> { pasteClipboard(); true }
////                e.isCtrlPressed && e.key == Key.G && e.isShiftPressed -> { ungroupSelected(); true }
////                e.isCtrlPressed && e.key == Key.G -> { groupSelected(); true }
////                e.key == Key.Delete -> { deleteSelected(); true }
////                else -> false
////            }
////        } else false
////    }
////
////    val scrollState = rememberScrollState()
////    val scope = rememberCoroutineScope()
////    val dragScroll = rememberDraggableState { delta -> scope.launch { scrollState.scrollBy(-delta) } }
////
////    Box(
////        Modifier
////            .fillMaxSize()
////            .focusRequester(focusRequester)
////            .focusable()
////            .then(keyHandler)
////    ) {
////        Column(
////            Modifier
////                .fillMaxSize()
////                .draggable(state = dragScroll, orientation = Orientation.Vertical)
////                .verticalScroll(scrollState)
////                .padding(16.dp)
////        ) {
////            Row(verticalAlignment = Alignment.CenterVertically) {
////                Checkbox(checked = selectionEnabled, onCheckedChange = { selectionEnabled = it })
////                Spacer(Modifier.width(8.dp))
////                Text(if (selectionEnabled) "Selection ON" else "Selection OFF")
////                Spacer(Modifier.width(16.dp))
////                Text("Drag the overlay to move it")
////            }
////
////            Spacer(Modifier.height(12.dp))
////
////            DragHighlightBox(
////                enabled = selectionEnabled,
////                onSelectionEnd = { rect ->
////                    ensureKeyboardFocus()
////                    selectByRect(rect)
////                },
////                modifier = Modifier
////                    .fillMaxWidth()
////                    .height(420.dp)
////                    .background(Color(0xFF202020))
////                    .border(1.dp, Color(0xFF444444))
////            ) {
////                CanvasItemsLayer(
////                    items = items,
////                    selectedIds = selectedIds,
////                    ensureKeyboardFocus = { ensureKeyboardFocus() },
////                    onClickItem = { id ->
////                        ensureKeyboardFocus()
////                        clickSelect(id)
////                    },
////                    onBeginDragItem = { id ->
////                        ensureKeyboardFocus()
////                        if (id !in selectedIds) clickSelect(id)
////                        beginMoveUndoIfNeeded()
////                    },
////                    onDragItem = { id, delta ->
////                        val moveSet = if (id in selectedIds) selectedIds else setOf(id)
////                        moveItems(moveSet, delta)
////                    },
////                    onEndDragItem = { endMove() }
////                )
////            }
////
////            Spacer(Modifier.height(600.dp))
////        }
////
////        // Overlay actions
////        val actions = listOf(
////            OverlayAction(
////                text = "Undo",
////                enabled = undoStack.isNotEmpty(),
////                icon = { Icon(Icons.Filled.Undo, null, tint = Color.White) },
////                onClick = { ensureKeyboardFocus(); undo() }
////            ),
////            OverlayAction(
////                text = "Redo",
////                enabled = redoStack.isNotEmpty(),
////                icon = { Icon(Icons.Filled.Redo, null, tint = Color.White) },
////                onClick = { ensureKeyboardFocus(); redo() }
////            ),
////            OverlayAction(
////                text = "Copy",
////                enabled = selectedIds.isNotEmpty(),
////                icon = { Icon(Icons.Filled.ContentCopy, null, tint = Color.White) },
////                onClick = { ensureKeyboardFocus(); copySelected() }
////            ),
////            OverlayAction(
////                text = "Paste",
////                enabled = clipboard.isNotEmpty(),
////                icon = { Icon(Icons.Filled.ContentPaste, null, tint = Color.White) },
////                onClick = { ensureKeyboardFocus(); pasteClipboard() }
////            ),
////            OverlayAction(
////                text = "Delete",
////                enabled = selectedIds.isNotEmpty(),
////                icon = { Icon(Icons.Filled.Delete, null, tint = Color.White) },
////                onClick = { ensureKeyboardFocus(); deleteSelected() }
////            ),
////            OverlayAction(
////                text = "Group",
////                enabled = selectedIds.size >= 2,
////                icon = { Icon(Icons.Filled.CallMerge, null, tint = Color.White) },
////                onClick = { ensureKeyboardFocus(); groupSelected() }
////            ),
////            OverlayAction(
////                text = "Ungroup",
////                enabled = true,
////                icon = { Icon(Icons.Filled.CallSplit, null, tint = Color.White) },
////                onClick = { ensureKeyboardFocus(); ungroupSelected() }
////            ),
////            OverlayAction(
////                text = "Clear",
////                enabled = selectedIds.isNotEmpty(),
////                icon = { Icon(Icons.Filled.Clear, null, tint = Color.White) },
////                onClick = { ensureKeyboardFocus(); clearSelection() }
////            )
////        )
////
////        if (overlayVisible && selectedIds.isNotEmpty()) {
////            SelectionOverlay(
////                selectedCount = selectedIds.size,
////                actions = actions,
////                style = overlayStyle,
////                positionPx = overlayPosPx,
////                onPositionChangePx = { overlayPosPx = it }, // ✅ drag-to-move
////                onClose = {
////                    ensureKeyboardFocus()
////                    overlayVisible = false
////                    clearSelection()
////                }
////            )
////        }
////    }
////}
////
////@Composable
////private fun CanvasItemsLayer(
////    items: List<CanvasItem>,
////    selectedIds: Set<String>,
////    ensureKeyboardFocus: () -> Unit,
////    onClickItem: (String) -> Unit,
////    onBeginDragItem: (String) -> Unit,
////    onDragItem: (String, Offset) -> Unit,
////    onEndDragItem: () -> Unit
////) {
////    val density = LocalDensity.current
////
////    Box(
////        Modifier
////            .fillMaxSize()
////            .clickable(
////                interactionSource = remember { MutableInteractionSource() },
////                indication = null
////            ) { ensureKeyboardFocus() }
////    ) {
////        for (item in items) {
////            val isSelected = item.id in selectedIds
////            val wDp = with(density) { item.wPx.toDp() }
////            val hDp = with(density) { item.hPx.toDp() }
////
////            Box(
////                Modifier
////                    .offset { IntOffset(item.xPx.roundToInt(), item.yPx.roundToInt()) }
////                    .size(wDp, hDp)
////                    .background(item.color)
////                    .border(if (isSelected) 2.dp else 0.dp, Color.Yellow)
////                    .clickable(
////                        interactionSource = remember { MutableInteractionSource() },
////                        indication = null
////                    ) { onClickItem(item.id) }
////                    .pointerInput(item.id) {
////                        detectDragGestures(
////                            onDragStart = { onBeginDragItem(item.id) },
////                            onDrag = { change, dragAmount ->
////                                change.consume()
////                                onDragItem(item.id, Offset(dragAmount.x, dragAmount.y))
////                            },
////                            onDragEnd = { onEndDragItem() },
////                            onDragCancel = { onEndDragItem() }
////                        )
////                    }
////                    .padding(8.dp)
////            ) {
////                DisableSelection {
////                    Column {
////                        Text(item.id, color = Color.White)
////                        Text(
////                            text = item.groupId?.let { "Group: $it" } ?: "Ungrouped",
////                            color = Color(0xFFDDDDDD)
////                        )
////                    }
////                }
////            }
////        }
////    }
////}
////
////private infix fun <T> Set<T>.xor(other: Set<T>): Set<T> {
////    val out = this.toMutableSet()
////    for (v in other) {
////        if (!out.add(v)) out.remove(v)
////    }
////    return out
////}
//
//
//package com.dragfeedback.demo
//
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.animation.fadeIn
//import androidx.compose.animation.fadeOut
//import androidx.compose.animation.scaleIn
//import androidx.compose.animation.scaleOut
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.focusable
//import androidx.compose.foundation.gestures.Orientation
//import androidx.compose.foundation.gestures.detectDragGestures
//import androidx.compose.foundation.gestures.draggable
//import androidx.compose.foundation.gestures.rememberDraggableState
//import androidx.compose.foundation.gestures.scrollBy
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.text.selection.DisableSelection
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.Checkbox
//import androidx.compose.material.Icon
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.CallMerge
//import androidx.compose.material.icons.filled.CallSplit
//import androidx.compose.material.icons.filled.Clear
//import androidx.compose.material.icons.filled.ColorLens
//import androidx.compose.material.icons.filled.ContentCopy
//import androidx.compose.material.icons.filled.ContentPaste
//import androidx.compose.material.icons.filled.Delete
//import androidx.compose.material.icons.filled.Redo
//import androidx.compose.material.icons.filled.Undo
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.focus.FocusRequester
//import androidx.compose.ui.focus.focusRequester
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.geometry.Rect
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.input.key.*
////import androidx.compose.ui.input.pointer.consume
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.platform.LocalDensity
//import androidx.compose.ui.unit.IntOffset
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.window.Window
//import androidx.compose.ui.window.application
//import com.dragfeedback.core.DragHighlightBox
//import kotlinx.coroutines.launch
//import kotlin.math.roundToInt
//
//data class CanvasItem(
//    val id: String,
//    val xPx: Float,
//    val yPx: Float,
//    val wPx: Float,
//    val hPx: Float,
//    val color: Color,
//    val groupId: String? = null
//) {
//    fun rect(): Rect = Rect(xPx, yPx, xPx + wPx, yPx + hPx)
//    fun movedBy(delta: Offset): CanvasItem = copy(xPx = xPx + delta.x, yPx = yPx + delta.y)
//}
//
//data class EditorSnapshot(
//    val items: List<CanvasItem>,
//    val groups: Map<String, Set<String>>,
//    val selectedIds: Set<String>,
//    val clipboard: List<CanvasItem>,
//    val copyCounter: Int,
//    val groupCounter: Int
//)
//
//fun main() = application {
//    Window(onCloseRequest = ::exitApplication, title = "Editor Demo") {
//        DemoScreen()
//    }
//}
//
//@Composable
//fun DemoScreen() {
//    // keyboard focus (so shortcuts work immediately)
//    val focusRequester = remember { FocusRequester() }
//    LaunchedEffect(Unit) { focusRequester.requestFocus() }
//    fun ensureKeyboardFocus() = focusRequester.requestFocus()
//
//    var selectionEnabled by remember { mutableStateOf(true) }
//    var shiftDown by remember { mutableStateOf(false) }
//    var ctrlDown by remember { mutableStateOf(false) }
//
//    val items = remember {
//        mutableStateListOf(
//            CanvasItem("A", 40f, 40f, 140f, 70f, Color(0xFF3B82F6)),
//            CanvasItem("B", 220f, 90f, 160f, 90f, Color(0xFF22C55E)),
//            CanvasItem("C", 120f, 220f, 200f, 80f, Color(0xFFF97316)),
//            CanvasItem("D", 360f, 210f, 140f, 120f, Color(0xFFA855F7))
//        )
//    }
//
//    var selectedIds by remember { mutableStateOf(setOf<String>()) }
//    var clipboard by remember { mutableStateOf<List<CanvasItem>>(emptyList()) }
//    val groups = remember { mutableStateMapOf<String, MutableSet<String>>() }
//
//    var copyCounter by remember { mutableStateOf(1) }
//    var groupCounter by remember { mutableStateOf(1) }
//    fun newCopyId(): String = "Copy${copyCounter++}"
//    fun newGroupId(): String = "G${groupCounter++}"
//
//    val undoStack = remember { mutableStateListOf<EditorSnapshot>() }
//    val redoStack = remember { mutableStateListOf<EditorSnapshot>() }
//
//    fun snapshot(): EditorSnapshot =
//        EditorSnapshot(
//            items = items.toList(),
//            groups = groups.mapValues { it.value.toSet() },
//            selectedIds = selectedIds.toSet(),
//            clipboard = clipboard.map { it.copy() },
//            copyCounter = copyCounter,
//            groupCounter = groupCounter
//        )
//
//    fun restore(s: EditorSnapshot) {
//        items.clear(); items.addAll(s.items)
//        groups.clear()
//        for ((gid, set) in s.groups) groups[gid] = set.toMutableSet()
//        selectedIds = s.selectedIds.toSet()
//        clipboard = s.clipboard.map { it.copy() }
//        copyCounter = s.copyCounter
//        groupCounter = s.groupCounter
//    }
//
//    fun pushUndoPoint() { undoStack.add(snapshot()); redoStack.clear() }
//    fun undo() { if (undoStack.isNotEmpty()) { val prev = undoStack.removeLast(); redoStack.add(snapshot()); restore(prev) } }
//    fun redo() { if (redoStack.isNotEmpty()) { val next = redoStack.removeLast(); undoStack.add(snapshot()); restore(next) } }
//
//    fun recomputeGroupsAfterItemChange() {
//        val existing = items.map { it.id }.toSet()
//        for ((_, set) in groups) set.removeIf { it !in existing }
//        val empty = groups.filterValues { it.isEmpty() }.keys.toList()
//        empty.forEach { groups.remove(it) }
//    }
//
//    fun clearSelection() { selectedIds = emptySet() }
//
//    fun clickSelect(id: String) {
//        selectedIds =
//            if (shiftDown || ctrlDown) {
//                if (id in selectedIds) selectedIds - id else selectedIds + id
//            } else setOf(id)
//    }
//
//    fun selectByRect(selectionRect: Rect) {
//        val hit = items.filter { it.rect().overlaps(selectionRect) }.map { it.id }.toSet()
//        selectedIds = if (shiftDown || ctrlDown) (selectedIds xor hit) else hit
//    }
//
//    fun deleteSelected() {
//        if (selectedIds.isEmpty()) return
//        pushUndoPoint()
//        items.removeAll { it.id in selectedIds }
//        clearSelection()
//        recomputeGroupsAfterItemChange()
//    }
//
//    fun copySelected() { clipboard = items.filter { it.id in selectedIds }.map { it.copy() } }
//
//    fun pasteClipboard() {
//        if (clipboard.isEmpty()) return
//        pushUndoPoint()
//        val pasted = clipboard.map { t ->
//            t.copy(id = newCopyId(), xPx = t.xPx + 20f, yPx = t.yPx + 20f, groupId = null)
//        }
//        items.addAll(pasted)
//        recomputeGroupsAfterItemChange()
//        selectedIds = pasted.map { it.id }.toSet()
//    }
//
//    fun groupSelected() {
//        if (selectedIds.size < 2) return
//        pushUndoPoint()
//        for ((_, set) in groups) set.removeAll(selectedIds)
//
//        val gid = newGroupId()
//        groups[gid] = selectedIds.toMutableSet()
//
//        val updated = items.map { it2 -> if (it2.id in selectedIds) it2.copy(groupId = gid) else it2 }
//        items.clear(); items.addAll(updated)
//        recomputeGroupsAfterItemChange()
//    }
//
//    fun ungroupSelected() {
//        val sel = items.filter { it.id in selectedIds }
//        val gid = sel.mapNotNull { it.groupId }.distinct().singleOrNull() ?: return
//        val groupIds = groups[gid]?.toSet() ?: return
//        if (selectedIds != groupIds) return
//
//        pushUndoPoint()
//        groups.remove(gid)
//
//        val updated = items.map { it2 -> if (it2.groupId == gid) it2.copy(groupId = null) else it2 }
//        items.clear(); items.addAll(updated)
//        recomputeGroupsAfterItemChange()
//    }
//
//    fun moveItems(ids: Set<String>, delta: Offset) {
//        if (ids.isEmpty()) return
//        val updated = items.map { it2 -> if (it2.id in ids) it2.movedBy(delta) else it2 }
//        items.clear(); items.addAll(updated)
//    }
//
//    var moveUndoArmed by remember { mutableStateOf(false) }
//    fun beginMoveUndoIfNeeded() { if (!moveUndoArmed) { pushUndoPoint(); moveUndoArmed = true } }
//    fun endMove() { moveUndoArmed = false }
//
//    // Overlay show/hide + position
//    var overlayVisible by remember { mutableStateOf(false) }
//    LaunchedEffect(selectedIds) { overlayVisible = selectedIds.isNotEmpty() }
//    var overlayPosPx by remember { mutableStateOf(Offset(40f, 40f)) }
//
//    // Theme toggle
//    var lightTheme by remember { mutableStateOf(false) }
//    val overlayStyle = remember(lightTheme) {
//        if (!lightTheme) {
//            OverlayStyle(
//                background = Color(0xFF1F2937),
//                baseBorderColor = Color(0xFF374151),
//                //borderColor = Color(0xFF66AFFF),
//                chipColor = Color(0xFF334155),
//                chipDisabledColor = Color(0xFF223044),
//                closeButtonGap = 8.dp
//            )
//        } else {
//            OverlayStyle(
//                background = Color(0xFFF5F5F5),
//                baseBorderColor = Color(0xFFCCCCCC),
//                //borderColor = Color(0xFF3B82F6),
//                titleColor = Color(0xFF111111),
//                chipColor = Color(0xFFE9E9E9),
//                chipDisabledColor = Color(0xFFDADADA),
//                chipTextColor = Color(0xFF111111),
//                closeButtonGap = 8.dp
//            )
//        }
//    }
//
//    // Keyboard shortcuts
//    val keyHandler = Modifier.onPreviewKeyEvent { e ->
//        if (e.type == KeyEventType.KeyDown || e.type == KeyEventType.KeyUp) {
//            shiftDown = e.isShiftPressed
//            ctrlDown = e.isCtrlPressed
//        }
//        if (e.type == KeyEventType.KeyDown) {
//            when {
//                e.isCtrlPressed && e.key == Key.Z -> { undo(); true }
//                e.isCtrlPressed && e.key == Key.Y -> { redo(); true }
//                e.isCtrlPressed && e.key == Key.C -> { copySelected(); true }
//                e.isCtrlPressed && e.key == Key.V -> { pasteClipboard(); true }
//                e.isCtrlPressed && e.key == Key.G && e.isShiftPressed -> { ungroupSelected(); true }
//                e.isCtrlPressed && e.key == Key.G -> { groupSelected(); true }
//                e.key == Key.Delete -> { deleteSelected(); true }
//                else -> false
//            }
//        } else false
//    }
//
//    // Parent drag-scroll
//    val scrollState = rememberScrollState()
//    val scope = rememberCoroutineScope()
//    val dragScroll = rememberDraggableState { delta -> scope.launch { scrollState.scrollBy(-delta) } }
//
//    Box(
//        Modifier
//            .fillMaxSize()
//            .focusRequester(focusRequester)
//            .focusable()
//            .then(keyHandler)
//    ) {
//        Column(
//            Modifier
//                .fillMaxSize()
//                .draggable(state = dragScroll, orientation = Orientation.Vertical)
//                .verticalScroll(scrollState)
//                .padding(16.dp)
//        ) {
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Checkbox(checked = selectionEnabled, onCheckedChange = { selectionEnabled = it })
//                Spacer(Modifier.width(8.dp))
//                Text(if (selectionEnabled) "Selection ON" else "Selection OFF")
//                Spacer(Modifier.width(16.dp))
//                Text("Drag the overlay to move it • Theme button toggles overlay style")
//            }
//
//            Spacer(Modifier.height(12.dp))
//
//            DragHighlightBox(
//                enabled = selectionEnabled,
//                onSelectionEnd = { rect ->
//                    ensureKeyboardFocus()
//                    selectByRect(rect)
//                },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(420.dp)
//                    .background(Color(0xFF202020))
//                    .border(1.dp, Color(0xFF444444))
//            ) {
//                CanvasItemsLayer(
//                    items = items,
//                    selectedIds = selectedIds,
//                    ensureKeyboardFocus = { ensureKeyboardFocus() },
//                    onClickItem = { id ->
//                        ensureKeyboardFocus()
//                        clickSelect(id)
//                    },
//                    onBeginDragItem = { id ->
//                        ensureKeyboardFocus()
//                        if (id !in selectedIds) clickSelect(id)
//                        beginMoveUndoIfNeeded()
//                    },
//                    onDragItem = { id, delta ->
//                        val moveSet = if (id in selectedIds) selectedIds else setOf(id)
//                        moveItems(moveSet, delta)
//                    },
//                    onEndDragItem = { endMove() }
//                )
//            }
//
//            Spacer(Modifier.height(600.dp))
//        }
//
//        // Overlay actions, including Theme
//        val actions = listOf(
//            OverlayAction(
//                text = "Undo",
//                enabled = undoStack.isNotEmpty(),
//                icon = { Icon(Icons.Filled.Undo, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); undo() }
//            ),
//            OverlayAction(
//                text = "Redo",
//                enabled = redoStack.isNotEmpty(),
//                icon = { Icon(Icons.Filled.Redo, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); redo() }
//            ),
//            OverlayAction(
//                text = "Copy",
//                enabled = selectedIds.isNotEmpty(),
//                icon = { Icon(Icons.Filled.ContentCopy, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); copySelected() }
//            ),
//            OverlayAction(
//                text = "Paste",
//                enabled = clipboard.isNotEmpty(),
//                icon = { Icon(Icons.Filled.ContentPaste, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); pasteClipboard() }
//            ),
//            OverlayAction(
//                text = "Delete",
//                enabled = selectedIds.isNotEmpty(),
//                icon = { Icon(Icons.Filled.Delete, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); deleteSelected() }
//            ),
//            OverlayAction(
//                text = "Group",
//                enabled = selectedIds.size >= 2,
//                icon = { Icon(Icons.Filled.CallMerge, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); groupSelected() }
//            ),
//            OverlayAction(
//                text = "Ungroup",
//                enabled = true,
//                icon = { Icon(Icons.Filled.CallSplit, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); ungroupSelected() }
//            ),
//            OverlayAction(
//                text = "Clear",
//                enabled = selectedIds.isNotEmpty(),
//                icon = { Icon(Icons.Filled.Clear, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); clearSelection() }
//            ),
//            OverlayAction(
//                text = "Theme",
//                enabled = true,
//                icon = { Icon(Icons.Filled.ColorLens, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); lightTheme = !lightTheme }
//            )
//        )
//
//        // Animated show/hide (fade + scale)
//        AnimatedVisibility(
//            visible = overlayVisible && selectedIds.isNotEmpty(),
//            enter = fadeIn() + scaleIn(initialScale = 0.96f),
//            exit = fadeOut() + scaleOut(targetScale = 0.96f)
//        ) {
//            SelectionOverlay(
//                selectedCount = selectedIds.size,
//                actions = actions,
//                style = overlayStyle,
//                positionPx = overlayPosPx,
//                onPositionChangePx = { overlayPosPx = it },
//                onClose = {
//                    ensureKeyboardFocus()
//                    overlayVisible = false
//                    clearSelection()
//                }
//            )
//        }
//    }
//}
//
//@Composable
//private fun CanvasItemsLayer(
//    items: List<CanvasItem>,
//    selectedIds: Set<String>,
//    ensureKeyboardFocus: () -> Unit,
//    onClickItem: (String) -> Unit,
//    onBeginDragItem: (String) -> Unit,
//    onDragItem: (String, Offset) -> Unit,
//    onEndDragItem: () -> Unit
//) {
//    val density = LocalDensity.current
//
//    Box(
//        Modifier
//            .fillMaxSize()
//            .clickable(
//                interactionSource = remember { MutableInteractionSource() },
//                indication = null
//            ) { ensureKeyboardFocus() }
//    ) {
//        for (item in items) {
//            val isSelected = item.id in selectedIds
//            val wDp = with(density) { item.wPx.toDp() }
//            val hDp = with(density) { item.hPx.toDp() }
//
//            Box(
//                Modifier
//                    .offset { IntOffset(item.xPx.roundToInt(), item.yPx.roundToInt()) }
//                    .size(wDp, hDp)
//                    .background(item.color)
//                    .border(if (isSelected) 2.dp else 0.dp, Color.Yellow)
//                    .clickable(
//                        interactionSource = remember { MutableInteractionSource() },
//                        indication = null
//                    ) { onClickItem(item.id) }
//                    .pointerInput(item.id) {
//                        detectDragGestures(
//                            onDragStart = { onBeginDragItem(item.id) },
//                            onDrag = { change, dragAmount ->
//                                change.consume()
//                                onDragItem(item.id, Offset(dragAmount.x, dragAmount.y))
//                            },
//                            onDragEnd = { onEndDragItem() },
//                            onDragCancel = { onEndDragItem() }
//                        )
//                    }
//                    .padding(8.dp)
//            ) {
//                DisableSelection {
//                    Column {
//                        Text(item.id, color = Color.White)
//                        Text(
//                            text = item.groupId?.let { "Group: $it" } ?: "Ungrouped",
//                            color = Color(0xFFDDDDDD)
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//
//private infix fun <T> Set<T>.xor(other: Set<T>): Set<T> {
//    val out = this.toMutableSet()
//    for (v in other) {
//        if (!out.add(v)) out.remove(v)
//    }
//    return out
//}



//
//package com.dragfeedback.demo
//
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.animation.fadeIn
//import androidx.compose.animation.fadeOut
//import androidx.compose.animation.scaleIn
//import androidx.compose.animation.scaleOut
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.focusable
//import androidx.compose.foundation.gestures.Orientation
//import androidx.compose.foundation.gestures.detectDragGestures
//import androidx.compose.foundation.gestures.draggable
//import androidx.compose.foundation.gestures.rememberDraggableState
//import androidx.compose.foundation.gestures.scrollBy
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.text.selection.DisableSelection
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.Checkbox
//import androidx.compose.material.Icon
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.CallMerge
//import androidx.compose.material.icons.filled.CallSplit
//import androidx.compose.material.icons.filled.Clear
//import androidx.compose.material.icons.filled.ColorLens
//import androidx.compose.material.icons.filled.ContentCopy
//import androidx.compose.material.icons.filled.ContentPaste
//import androidx.compose.material.icons.filled.Delete
//import androidx.compose.material.icons.filled.Redo
//import androidx.compose.material.icons.filled.Undo
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.focus.FocusRequester
//import androidx.compose.ui.focus.focusRequester
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.geometry.Rect
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.input.key.*
//
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.platform.LocalDensity
//import androidx.compose.ui.unit.IntOffset
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.window.Window
//import androidx.compose.ui.window.application
//import com.dragfeedback.core.DragHighlightBox
//import kotlinx.coroutines.launch
//import kotlin.math.roundToInt
//
//data class CanvasItem(
//    val id: String,
//    val xPx: Float,
//    val yPx: Float,
//    val wPx: Float,
//    val hPx: Float,
//    val color: Color,
//    val groupId: String? = null
//) {
//    fun rect(): Rect = Rect(xPx, yPx, xPx + wPx, yPx + hPx)
//    fun movedBy(delta: Offset): CanvasItem = copy(xPx = xPx + delta.x, yPx = yPx + delta.y)
//}
//
//data class EditorSnapshot(
//    val items: List<CanvasItem>,
//    val groups: Map<String, Set<String>>,
//    val selectedIds: Set<String>,
//    val clipboard: List<CanvasItem>,
//    val copyCounter: Int,
//    val groupCounter: Int
//)
//
//fun main() = application {
//    Window(onCloseRequest = ::exitApplication, title = "Editor Demo") {
//        DemoScreen()
//    }
//}
//
//@Composable
//fun DemoScreen() {
//    val focusRequester = remember { FocusRequester() }
//    LaunchedEffect(Unit) { focusRequester.requestFocus() }
//    fun ensureKeyboardFocus() = focusRequester.requestFocus()
//
//    var selectionEnabled by remember { mutableStateOf(true) }
//    var shiftDown by remember { mutableStateOf(false) }
//    var ctrlDown by remember { mutableStateOf(false) }
//
//    val items = remember {
//        mutableStateListOf(
//            CanvasItem("A", 40f, 40f, 140f, 70f, Color(0xFF3B82F6)),
//            CanvasItem("B", 220f, 90f, 160f, 90f, Color(0xFF22C55E)),
//            CanvasItem("C", 120f, 220f, 200f, 80f, Color(0xFFF97316)),
//            CanvasItem("D", 360f, 210f, 140f, 120f, Color(0xFFA855F7))
//        )
//    }
//
//    var selectedIds by remember { mutableStateOf(setOf<String>()) }
//    var clipboard by remember { mutableStateOf<List<CanvasItem>>(emptyList()) }
//    val groups = remember { mutableStateMapOf<String, MutableSet<String>>() }
//
//    var copyCounter by remember { mutableStateOf(1) }
//    var groupCounter by remember { mutableStateOf(1) }
//    fun newCopyId(): String = "Copy${copyCounter++}"
//    fun newGroupId(): String = "G${groupCounter++}"
//
//    val undoStack = remember { mutableStateListOf<EditorSnapshot>() }
//    val redoStack = remember { mutableStateListOf<EditorSnapshot>() }
//
//    fun snapshot(): EditorSnapshot =
//        EditorSnapshot(
//            items = items.toList(),
//            groups = groups.mapValues { it.value.toSet() },
//            selectedIds = selectedIds.toSet(),
//            clipboard = clipboard.map { it.copy() },
//            copyCounter = copyCounter,
//            groupCounter = groupCounter
//        )
//
//    fun restore(s: EditorSnapshot) {
//        items.clear(); items.addAll(s.items)
//        groups.clear()
//        for ((gid, set) in s.groups) groups[gid] = set.toMutableSet()
//        selectedIds = s.selectedIds.toSet()
//        clipboard = s.clipboard.map { it.copy() }
//        copyCounter = s.copyCounter
//        groupCounter = s.groupCounter
//    }
//
//    fun pushUndoPoint() { undoStack.add(snapshot()); redoStack.clear() }
//    fun undo() { if (undoStack.isNotEmpty()) { val prev = undoStack.removeLast(); redoStack.add(snapshot()); restore(prev) } }
//    fun redo() { if (redoStack.isNotEmpty()) { val next = redoStack.removeLast(); undoStack.add(snapshot()); restore(next) } }
//
//    fun recomputeGroupsAfterItemChange() {
//        val existing = items.map { it.id }.toSet()
//        for ((_, set) in groups) set.removeIf { it !in existing }
//        val empty = groups.filterValues { it.isEmpty() }.keys.toList()
//        empty.forEach { groups.remove(it) }
//    }
//
//    fun clearSelection() { selectedIds = emptySet() }
//
//    fun clickSelect(id: String) {
//        selectedIds =
//            if (shiftDown || ctrlDown) {
//                if (id in selectedIds) selectedIds - id else selectedIds + id
//            } else setOf(id)
//    }
//
//    fun selectByRect(selectionRect: Rect) {
//        val hit = items.filter { it.rect().overlaps(selectionRect) }.map { it.id }.toSet()
//        selectedIds = if (shiftDown || ctrlDown) (selectedIds xor hit) else hit
//    }
//
//    fun deleteSelected() {
//        if (selectedIds.isEmpty()) return
//        pushUndoPoint()
//        items.removeAll { it.id in selectedIds }
//        clearSelection()
//        recomputeGroupsAfterItemChange()
//    }
//
//    fun copySelected() { clipboard = items.filter { it.id in selectedIds }.map { it.copy() } }
//
//    fun pasteClipboard() {
//        if (clipboard.isEmpty()) return
//        pushUndoPoint()
//        val pasted = clipboard.map { t ->
//            t.copy(id = newCopyId(), xPx = t.xPx + 20f, yPx = t.yPx + 20f, groupId = null)
//        }
//        items.addAll(pasted)
//        recomputeGroupsAfterItemChange()
//        selectedIds = pasted.map { it.id }.toSet()
//    }
//
//    fun groupSelected() {
//        if (selectedIds.size < 2) return
//        pushUndoPoint()
//        for ((_, set) in groups) set.removeAll(selectedIds)
//
//        val gid = newGroupId()
//        groups[gid] = selectedIds.toMutableSet()
//
//        val updated = items.map { it2 -> if (it2.id in selectedIds) it2.copy(groupId = gid) else it2 }
//        items.clear(); items.addAll(updated)
//        recomputeGroupsAfterItemChange()
//    }
//
//    fun ungroupSelected() {
//        val sel = items.filter { it.id in selectedIds }
//        val gid = sel.mapNotNull { it.groupId }.distinct().singleOrNull() ?: return
//        val groupIds = groups[gid]?.toSet() ?: return
//        if (selectedIds != groupIds) return
//
//        pushUndoPoint()
//        groups.remove(gid)
//
//        val updated = items.map { it2 -> if (it2.groupId == gid) it2.copy(groupId = null) else it2 }
//        items.clear(); items.addAll(updated)
//        recomputeGroupsAfterItemChange()
//    }
//
//    fun moveItems(ids: Set<String>, delta: Offset) {
//        if (ids.isEmpty()) return
//        val updated = items.map { it2 -> if (it2.id in ids) it2.movedBy(delta) else it2 }
//        items.clear(); items.addAll(updated)
//    }
//
//    var moveUndoArmed by remember { mutableStateOf(false) }
//    fun beginMoveUndoIfNeeded() { if (!moveUndoArmed) { pushUndoPoint(); moveUndoArmed = true } }
//    fun endMove() { moveUndoArmed = false }
//
//    // Overlay state
//    var overlayPosPx by remember { mutableStateOf(Offset(40f, 40f)) }
//    var lightTheme by remember { mutableStateOf(false) }
//
//    val overlayStyle = remember(lightTheme) {
//        if (!lightTheme) {
//            OverlayStyle(
//                background = Color(0xFF1F2937),
//                baseBorderColor = Color(0xFF374151),
//                pulseBorderColor = Color(0xFF66AFFF),
//                chipColor = Color(0xFF334155),
//                chipDisabledColor = Color(0xFF223044),
//                closeButtonGap = 8.dp
//            )
//        } else {
//            OverlayStyle(
//                background = Color(0xFFF5F5F5),
//                baseBorderColor = Color(0xFFCCCCCC),
//                pulseBorderColor = Color(0xFF3B82F6),
//                titleColor = Color(0xFF111111),
//                chipColor = Color(0xFFE9E9E9),
//                chipDisabledColor = Color(0xFFDADADA),
//                chipTextColor = Color(0xFF111111),
//                closeButtonGap = 8.dp
//            )
//        }
//    }
//
//    val keyHandler = Modifier.onPreviewKeyEvent { e ->
//        if (e.type == KeyEventType.KeyDown || e.type == KeyEventType.KeyUp) {
//            shiftDown = e.isShiftPressed
//            ctrlDown = e.isCtrlPressed
//        }
//        if (e.type == KeyEventType.KeyDown) {
//            when {
//                e.isCtrlPressed && e.key == Key.Z -> { undo(); true }
//                e.isCtrlPressed && e.key == Key.Y -> { redo(); true }
//                e.isCtrlPressed && e.key == Key.C -> { copySelected(); true }
//                e.isCtrlPressed && e.key == Key.V -> { pasteClipboard(); true }
//                e.isCtrlPressed && e.key == Key.G && e.isShiftPressed -> { ungroupSelected(); true }
//                e.isCtrlPressed && e.key == Key.G -> { groupSelected(); true }
//                e.key == Key.Delete -> { deleteSelected(); true }
//                else -> false
//            }
//        } else false
//    }
//
//    val scrollState = rememberScrollState()
//    val scope = rememberCoroutineScope()
//    val dragScroll = rememberDraggableState { delta -> scope.launch { scrollState.scrollBy(-delta) } }
//
//    Box(
//        Modifier
//            .fillMaxSize()
//            .focusRequester(focusRequester)
//            .focusable()
//            .then(keyHandler)
//    ) {
//        Column(
//            Modifier
//                .fillMaxSize()
//                .draggable(state = dragScroll, orientation = Orientation.Vertical)
//                .verticalScroll(scrollState)
//                .padding(16.dp)
//        ) {
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Checkbox(checked = selectionEnabled, onCheckedChange = { selectionEnabled = it })
//                Spacer(Modifier.width(8.dp))
//                Text(if (selectionEnabled) "Selection ON" else "Selection OFF")
//            }
//
//            Spacer(Modifier.height(12.dp))
//
//            DragHighlightBox(
//                enabled = selectionEnabled,
//                onSelectionEnd = { rect ->
//                    ensureKeyboardFocus()
//                    selectByRect(rect)
//                },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(420.dp)
//                    .background(Color(0xFF202020))
//                    .border(1.dp, Color(0xFF444444))
//            ) {
//                CanvasItemsLayer(
//                    items = items,
//                    selectedIds = selectedIds,
//                    ensureKeyboardFocus = { ensureKeyboardFocus() },
//                    onClickItem = { id ->
//                        ensureKeyboardFocus()
//                        clickSelect(id)
//                    },
//                    onBeginDragItem = { id ->
//                        ensureKeyboardFocus()
//                        if (id !in selectedIds) clickSelect(id)
//                        beginMoveUndoIfNeeded()
//                    },
//                    onDragItem = { id, delta ->
//                        val moveSet = if (id in selectedIds) selectedIds else setOf(id)
//                        moveItems(moveSet, delta)
//                    },
//                    onEndDragItem = { endMove() }
//                )
//            }
//
//            Spacer(Modifier.height(600.dp))
//        }
//
//        val overlayVisible = selectedIds.isNotEmpty()
//
//        val actions = listOf(
//            OverlayAction(
//                text = "Undo",
//                enabled = undoStack.isNotEmpty(),
//                icon = { Icon(Icons.Filled.Undo, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); undo() }
//            ),
//            OverlayAction(
//                text = "Redo",
//                enabled = redoStack.isNotEmpty(),
//                icon = { Icon(Icons.Filled.Redo, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); redo() }
//            ),
//            OverlayAction(
//                text = "Copy",
//                enabled = selectedIds.isNotEmpty(),
//                icon = { Icon(Icons.Filled.ContentCopy, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); copySelected() }
//            ),
//            OverlayAction(
//                text = "Paste",
//                enabled = clipboard.isNotEmpty(),
//                icon = { Icon(Icons.Filled.ContentPaste, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); pasteClipboard() }
//            ),
//            OverlayAction(
//                text = "Delete",
//                enabled = selectedIds.isNotEmpty(),
//                icon = { Icon(Icons.Filled.Delete, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); deleteSelected() }
//            ),
//            OverlayAction(
//                text = "Group",
//                enabled = selectedIds.size >= 2,
//                icon = { Icon(Icons.Filled.CallMerge, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); groupSelected() }
//            ),
//            OverlayAction(
//                text = "Ungroup",
//                enabled = true,
//                icon = { Icon(Icons.Filled.CallSplit, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); ungroupSelected() }
//            ),
//            OverlayAction(
//                text = "Clear",
//                enabled = selectedIds.isNotEmpty(),
//                icon = { Icon(Icons.Filled.Clear, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); clearSelection() }
//            ),
//            OverlayAction(
//                text = "Theme",
//                enabled = true,
//                icon = { Icon(Icons.Filled.ColorLens, null, tint = Color.White) },
//                onClick = { ensureKeyboardFocus(); lightTheme = !lightTheme }
//            )
//        )
//
//        AnimatedVisibility(
//            visible = overlayVisible,
//            enter = fadeIn() + scaleIn(initialScale = 0.96f),
//            exit = fadeOut() + scaleOut(targetScale = 0.96f)
//        ) {
//            SelectionOverlay(
//                selectedCount = selectedIds.size,
//                actions = actions,
//                style = overlayStyle,
//                positionPx = overlayPosPx,
//                onPositionChangePx = { overlayPosPx = it },
//                onClose = {
//                    ensureKeyboardFocus()
//                    clearSelection()
//                }
//            )
//        }
//    }
//}
//
//@Composable
//private fun CanvasItemsLayer(
//    items: List<CanvasItem>,
//    selectedIds: Set<String>,
//    ensureKeyboardFocus: () -> Unit,
//    onClickItem: (String) -> Unit,
//    onBeginDragItem: (String) -> Unit,
//    onDragItem: (String, Offset) -> Unit,
//    onEndDragItem: () -> Unit
//) {
//    val density = LocalDensity.current
//
//    Box(
//        Modifier
//            .fillMaxSize()
//            .clickable(
//                interactionSource = remember { MutableInteractionSource() },
//                indication = null
//            ) { ensureKeyboardFocus() }
//    ) {
//        for (item in items) {
//            val isSelected = item.id in selectedIds
//            val wDp = with(density) { item.wPx.toDp() }
//            val hDp = with(density) { item.hPx.toDp() }
//
//            Box(
//                Modifier
//                    .offset { IntOffset(item.xPx.roundToInt(), item.yPx.roundToInt()) }
//                    .size(wDp, hDp)
//                    .background(item.color)
//                    .border(if (isSelected) 2.dp else 0.dp, Color.Yellow)
//                    .clickable(
//                        interactionSource = remember { MutableInteractionSource() },
//                        indication = null
//                    ) { onClickItem(item.id) }
//                    .pointerInput(item.id) {
//                        detectDragGestures(
//                            onDragStart = { onBeginDragItem(item.id) },
//                            onDrag = { change, dragAmount ->
//                                change.consume()
//                                onDragItem(item.id, Offset(dragAmount.x, dragAmount.y))
//                            },
//                            onDragEnd = { onEndDragItem() },
//                            onDragCancel = { onEndDragItem() }
//                        )
//                    }
//                    .padding(8.dp)
//            ) {
//                DisableSelection {
//                    Column {
//                        Text(item.id, color = Color.White)
//                        Text(
//                            text = item.groupId?.let { "Group: $it" } ?: "Ungrouped",
//                            color = Color(0xFFDDDDDD)
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//
//private infix fun <T> Set<T>.xor(other: Set<T>): Set<T> {
//    val out = this.toMutableSet()
//    for (v in other) {
//        if (!out.add(v)) out.remove(v)
//    }
//    return out
//}



//
//package com.dragfeedback.demo
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.focusable
//import androidx.compose.foundation.gestures.Orientation
//import androidx.compose.foundation.gestures.detectDragGestures
//import androidx.compose.foundation.gestures.draggable
//import androidx.compose.foundation.gestures.rememberDraggableState
//import androidx.compose.foundation.gestures.scrollBy
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.text.selection.DisableSelection
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.Checkbox
//import androidx.compose.material.Icon
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.CallMerge
//import androidx.compose.material.icons.filled.CallSplit
//import androidx.compose.material.icons.filled.Clear
//import androidx.compose.material.icons.filled.ColorLens
//import androidx.compose.material.icons.filled.ContentCopy
//import androidx.compose.material.icons.filled.ContentPaste
//import androidx.compose.material.icons.filled.Delete
//import androidx.compose.material.icons.filled.Redo
//import androidx.compose.material.icons.filled.Undo
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.focus.FocusRequester
//import androidx.compose.ui.focus.focusRequester
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.geometry.Rect
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.input.key.*
//
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.layout.onGloballyPositioned
//import androidx.compose.ui.platform.LocalDensity
//import androidx.compose.ui.unit.IntOffset
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.window.Window
//import androidx.compose.ui.window.application
//import com.dragfeedback.core.DragHighlightBox
//import kotlinx.coroutines.launch
//import kotlin.math.roundToInt
//
//data class CanvasItem(
//    val id: String,
//    val xPx: Float,
//    val yPx: Float,
//    val wPx: Float,
//    val hPx: Float,
//    val color: Color,
//    val groupId: String? = null
//) {
//    fun rect(): Rect = Rect(xPx, yPx, xPx + wPx, yPx + hPx)
//    fun movedBy(delta: Offset): CanvasItem = copy(xPx = xPx + delta.x, yPx = yPx + delta.y)
//}
//
//data class EditorSnapshot(
//    val items: List<CanvasItem>,
//    val groups: Map<String, Set<String>>,
//    val selectedIds: Set<String>,
//    val clipboard: List<CanvasItem>,
//    val copyCounter: Int,
//    val groupCounter: Int
//)
//
//fun main() = application {
//    Window(onCloseRequest = ::exitApplication, title = "Editor Demo") {
//        DemoScreen()
//    }
//}
//
//@Composable
//fun DemoScreen() {
//    val focusRequester = remember { FocusRequester() }
//    LaunchedEffect(Unit) { focusRequester.requestFocus() }
//    fun ensureKeyboardFocus() = focusRequester.requestFocus()
//
//    var windowSizePx by remember { mutableStateOf(IntSizePx(0, 0)) }
//
//    var selectionEnabled by remember { mutableStateOf(true) }
//    var shiftDown by remember { mutableStateOf(false) }
//    var ctrlDown by remember { mutableStateOf(false) }
//
//    val items = remember {
//        mutableStateListOf(
//            CanvasItem("A", 40f, 40f, 140f, 70f, Color(0xFF3B82F6)),
//            CanvasItem("B", 220f, 90f, 160f, 90f, Color(0xFF22C55E)),
//            CanvasItem("C", 120f, 220f, 200f, 80f, Color(0xFFF97316)),
//            CanvasItem("D", 360f, 210f, 140f, 120f, Color(0xFFA855F7))
//        )
//    }
//
//    var selectedIds by remember { mutableStateOf(setOf<String>()) }
//    var clipboard by remember { mutableStateOf<List<CanvasItem>>(emptyList()) }
//    val groups = remember { mutableStateMapOf<String, MutableSet<String>>() }
//
//    var copyCounter by remember { mutableStateOf(1) }
//    var groupCounter by remember { mutableStateOf(1) }
//    fun newCopyId(): String = "Copy${copyCounter++}"
//    fun newGroupId(): String = "G${groupCounter++}"
//
//    val undoStack = remember { mutableStateListOf<EditorSnapshot>() }
//    val redoStack = remember { mutableStateListOf<EditorSnapshot>() }
//
//    fun snapshot(): EditorSnapshot =
//        EditorSnapshot(
//            items = items.toList(),
//            groups = groups.mapValues { it.value.toSet() },
//            selectedIds = selectedIds.toSet(),
//            clipboard = clipboard.map { it.copy() },
//            copyCounter = copyCounter,
//            groupCounter = groupCounter
//        )
//
//    fun restore(s: EditorSnapshot) {
//        items.clear(); items.addAll(s.items)
//        groups.clear()
//        for ((gid, set) in s.groups) groups[gid] = set.toMutableSet()
//        selectedIds = s.selectedIds.toSet()
//        clipboard = s.clipboard.map { it.copy() }
//        copyCounter = s.copyCounter
//        groupCounter = s.groupCounter
//    }
//
//    fun pushUndoPoint() { undoStack.add(snapshot()); redoStack.clear() }
//    fun undo() { if (undoStack.isNotEmpty()) { val prev = undoStack.removeLast(); redoStack.add(snapshot()); restore(prev) } }
//    fun redo() { if (redoStack.isNotEmpty()) { val next = redoStack.removeLast(); undoStack.add(snapshot()); restore(next) } }
//
//    fun recomputeGroupsAfterItemChange() {
//        val existing = items.map { it.id }.toSet()
//        for ((_, set) in groups) set.removeIf { it !in existing }
//        val empty = groups.filterValues { it.isEmpty() }.keys.toList()
//        empty.forEach { groups.remove(it) }
//    }
//
//    fun clearSelection() { selectedIds = emptySet() }
//
//    fun clickSelect(id: String) {
//        selectedIds =
//            if (shiftDown || ctrlDown) {
//                if (id in selectedIds) selectedIds - id else selectedIds + id
//            } else setOf(id)
//    }
//
//    fun selectByRect(selectionRect: Rect) {
//        val hit = items.filter { it.rect().overlaps(selectionRect) }.map { it.id }.toSet()
//        selectedIds = if (shiftDown || ctrlDown) (selectedIds xor hit) else hit
//    }
//
//    fun deleteSelected() {
//        if (selectedIds.isEmpty()) return
//        pushUndoPoint()
//        items.removeAll { it.id in selectedIds }
//        clearSelection()
//        recomputeGroupsAfterItemChange()
//    }
//
//    fun copySelected() { clipboard = items.filter { it.id in selectedIds }.map { it.copy() } }
//
//    fun pasteClipboard() {
//        if (clipboard.isEmpty()) return
//        pushUndoPoint()
//        val pasted = clipboard.map { t ->
//            t.copy(id = newCopyId(), xPx = t.xPx + 20f, yPx = t.yPx + 20f, groupId = null)
//        }
//        items.addAll(pasted)
//        recomputeGroupsAfterItemChange()
//        selectedIds = pasted.map { it.id }.toSet()
//    }
//
//    fun groupSelected() {
//        if (selectedIds.size < 2) return
//        pushUndoPoint()
//        for ((_, set) in groups) set.removeAll(selectedIds)
//
//        val gid = newGroupId()
//        groups[gid] = selectedIds.toMutableSet()
//
//        val updated = items.map { it2 -> if (it2.id in selectedIds) it2.copy(groupId = gid) else it2 }
//        items.clear(); items.addAll(updated)
//        recomputeGroupsAfterItemChange()
//    }
//
//    fun ungroupSelected() {
//        val sel = items.filter { it.id in selectedIds }
//        val gid = sel.mapNotNull { it.groupId }.distinct().singleOrNull() ?: return
//        val groupIds = groups[gid]?.toSet() ?: return
//        if (selectedIds != groupIds) return
//
//        pushUndoPoint()
//        groups.remove(gid)
//
//        val updated = items.map { it2 -> if (it2.groupId == gid) it2.copy(groupId = null) else it2 }
//        items.clear(); items.addAll(updated)
//        recomputeGroupsAfterItemChange()
//    }
//
//    fun moveItems(ids: Set<String>, delta: Offset) {
//        if (ids.isEmpty()) return
//        val updated = items.map { it2 -> if (it2.id in ids) it2.movedBy(delta) else it2 }
//        items.clear(); items.addAll(updated)
//    }
//
//    var moveUndoArmed by remember { mutableStateOf(false) }
//    fun beginMoveUndoIfNeeded() { if (!moveUndoArmed) { pushUndoPoint(); moveUndoArmed = true } }
//    fun endMove() { moveUndoArmed = false }
//
//    var overlayPosPx by remember { mutableStateOf(Offset(40f, 80f)) }
//    var lightTheme by remember { mutableStateOf(false) }
//
//    val overlayStyle = remember(lightTheme) {
//        if (!lightTheme) {
//            OverlayStyle(
//                background = Color(0xFF1F2937),
//                borderColor = Color(0xFF374151),
//                chipColor = Color(0xFF334155),
//                chipDisabledColor = Color(0xFF223044)
//            )
//        } else {
//            OverlayStyle(
//                background = Color(0xFFF5F5F5),
//                borderColor = Color(0xFFCCCCCC),
//                titleColor = Color(0xFF111111),
//                chipColor = Color(0xFFE9E9E9),
//                chipDisabledColor = Color(0xFFDADADA),
//                chipTextColor = Color(0xFF111111)
//            )
//        }
//    }
//
//    val keyHandler = Modifier.onPreviewKeyEvent { e ->
//        if (e.type == KeyEventType.KeyDown || e.type == KeyEventType.KeyUp) {
//            shiftDown = e.isShiftPressed
//            ctrlDown = e.isCtrlPressed
//        }
//        if (e.type == KeyEventType.KeyDown) {
//            when {
//                e.isCtrlPressed && e.key == Key.Z -> { undo(); true }
//                e.isCtrlPressed && e.key == Key.Y -> { redo(); true }
//                e.isCtrlPressed && e.key == Key.C -> { copySelected(); true }
//                e.isCtrlPressed && e.key == Key.V -> { pasteClipboard(); true }
//                e.isCtrlPressed && e.key == Key.G && e.isShiftPressed -> { ungroupSelected(); true }
//                e.isCtrlPressed && e.key == Key.G -> { groupSelected(); true }
//                e.key == Key.Delete -> { deleteSelected(); true }
//                else -> false
//            }
//        } else false
//    }
//
//    val scrollState = rememberScrollState()
//    val scope = rememberCoroutineScope()
//    val dragScroll = rememberDraggableState { delta -> scope.launch { scrollState.scrollBy(-delta) } }
//
//    val density = LocalDensity.current
//    val closeGapPx = with(density) { 10.dp.toPx() }
//    val closeSizePx = with(density) { 30.dp.toPx() }
//
//    Box(
//        Modifier
//            .fillMaxSize()
//            .onGloballyPositioned { coords ->
//                windowSizePx = IntSizePx(coords.size.width, coords.size.height)
//            }
//            .focusRequester(focusRequester)
//            .focusable()
//            .then(keyHandler)
//    ) {
//        Column(
//            Modifier
//                .fillMaxSize()
//                .draggable(state = dragScroll, orientation = Orientation.Vertical)
//                .verticalScroll(scrollState)
//                .padding(16.dp)
//        ) {
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Checkbox(checked = selectionEnabled, onCheckedChange = { selectionEnabled = it })
//                Spacer(Modifier.width(8.dp))
//                Text(if (selectionEnabled) "Selection ON" else "Selection OFF")
//            }
//
//            Spacer(Modifier.height(12.dp))
//
//            DragHighlightBox(
//                enabled = selectionEnabled,
//                onSelectionEnd = { rect ->
//                    ensureKeyboardFocus()
//                    selectByRect(rect)
//                },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(420.dp)
//                    .background(Color(0xFF202020))
//                    .border(1.dp, Color(0xFF444444))
//            ) {
//                CanvasItemsLayer(
//                    items = items,
//                    selectedIds = selectedIds,
//                    ensureKeyboardFocus = { ensureKeyboardFocus() },
//                    onClickItem = { id ->
//                        ensureKeyboardFocus()
//                        clickSelect(id)
//                    },
//                    onBeginDragItem = { id ->
//                        ensureKeyboardFocus()
//                        if (id !in selectedIds) clickSelect(id)
//                        beginMoveUndoIfNeeded()
//                    },
//                    onDragItem = { id, delta ->
//                        val moveSet = if (id in selectedIds) selectedIds else setOf(id)
//                        moveItems(moveSet, delta)
//                    },
//                    onEndDragItem = { endMove() }
//                )
//            }
//
//            Spacer(Modifier.height(600.dp))
//        }
//
//        if (selectedIds.isNotEmpty()) {
//            val actions = listOf(
//                OverlayAction("Undo", undoStack.isNotEmpty(), icon = { Icon(Icons.Filled.Undo, null, tint = Color.White) }) { ensureKeyboardFocus(); undo() },
//                OverlayAction("Redo", redoStack.isNotEmpty(), icon = { Icon(Icons.Filled.Redo, null, tint = Color.White) }) { ensureKeyboardFocus(); redo() },
//                OverlayAction("Copy", true, icon = { Icon(Icons.Filled.ContentCopy, null, tint = Color.White) }) { ensureKeyboardFocus(); copySelected() },
//                OverlayAction("Paste", clipboard.isNotEmpty(), icon = { Icon(Icons.Filled.ContentPaste, null, tint = Color.White) }) { ensureKeyboardFocus(); pasteClipboard() },
//                OverlayAction("Delete", true, icon = { Icon(Icons.Filled.Delete, null, tint = Color.White) }) { ensureKeyboardFocus(); deleteSelected() },
//                OverlayAction("Group", selectedIds.size >= 2, icon = { Icon(Icons.Filled.CallMerge, null, tint = Color.White) }) { ensureKeyboardFocus(); groupSelected() },
//                OverlayAction("Ungroup", true, icon = { Icon(Icons.Filled.CallSplit, null, tint = Color.White) }) { ensureKeyboardFocus(); ungroupSelected() },
//                OverlayAction("Clear", true, icon = { Icon(Icons.Filled.Clear, null, tint = Color.White) }) { ensureKeyboardFocus(); clearSelection() },
//                OverlayAction("Theme", true, icon = { Icon(Icons.Filled.ColorLens, null, tint = Color.White) }) { ensureKeyboardFocus(); lightTheme = !lightTheme }
//            )
//
//            SelectionOverlay(
//                selectedCount = selectedIds.size,
//                actions = actions,
//                style = overlayStyle,
//                closeButtonGapPx = closeGapPx,
//                closeButtonSizePx = closeSizePx,
//                windowSizePx = windowSizePx,
//                positionPx = overlayPosPx,
//                onPositionChangePx = { overlayPosPx = it },
//                onClose = {
//                    ensureKeyboardFocus()
//                    clearSelection()
//                }
//            )
//        }
//    }
//}
//
//@Composable
//private fun CanvasItemsLayer(
//    items: List<CanvasItem>,
//    selectedIds: Set<String>,
//    ensureKeyboardFocus: () -> Unit,
//    onClickItem: (String) -> Unit,
//    onBeginDragItem: (String) -> Unit,
//    onDragItem: (String, Offset) -> Unit,
//    onEndDragItem: () -> Unit
//) {
//    val density = LocalDensity.current
//
//    Box(
//        Modifier
//            .fillMaxSize()
//            .clickable(
//                interactionSource = remember { MutableInteractionSource() },
//                indication = null
//            ) { ensureKeyboardFocus() }
//    ) {
//        for (item in items) {
//            val isSelected = item.id in selectedIds
//            val wDp = with(density) { item.wPx.toDp() }
//            val hDp = with(density) { item.hPx.toDp() }
//
//            Box(
//                Modifier
//                    .offset { IntOffset(item.xPx.roundToInt(), item.yPx.roundToInt()) }
//                    .size(wDp, hDp)
//                    .background(item.color)
//                    .border(if (isSelected) 2.dp else 0.dp, Color.Yellow)
//                    .clickable(
//                        interactionSource = remember { MutableInteractionSource() },
//                        indication = null
//                    ) { onClickItem(item.id) }
//                    .pointerInput(item.id) {
//                        detectDragGestures(
//                            onDragStart = { onBeginDragItem(item.id) },
//                            onDrag = { change, dragAmount ->
//                                change.consume()
//                                onDragItem(item.id, Offset(dragAmount.x, dragAmount.y))
//                            },
//                            onDragEnd = { onEndDragItem() },
//                            onDragCancel = { onEndDragItem() }
//                        )
//                    }
//                    .padding(8.dp)
//            ) {
//                DisableSelection {
//                    Column {
//                        Text(item.id, color = Color.White)
//                        Text(
//                            text = item.groupId?.let { "Group: $it" } ?: "Ungrouped",
//                            color = Color(0xFFDDDDDD)
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//
//private infix fun <T> Set<T>.xor(other: Set<T>): Set<T> {
//    val out = this.toMutableSet()
//    for (v in other) {
//        if (!out.add(v)) out.remove(v)
//    }
//    return out
//}



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

    // ✅ Reliable window size: constraints update on resize
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

