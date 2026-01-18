

package com.dragfeedback.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon

import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import java.awt.Cursor
import kotlin.math.roundToInt

@Immutable
data class IntSizePx(val w: Int, val h: Int)

@Immutable
data class OverlayStyle(
    val background: Color = Color(0xFF2B2B2B),
    val borderColor: Color = Color(0xFF444444),
    val borderWidth: Dp = 1.dp,
    val contentPadding: Dp = 10.dp,
    val cornerRadius: Dp = 10.dp,
    val titleColor: Color = Color.White,
    val dragHandleColor: Color = Color(0xFF1F1F1F),
    val chipColor: Color = Color(0xFF3A3A3A),
    val chipDisabledColor: Color = Color(0xFF2A2A2A),
    val chipTextColor: Color = Color.White,
    val maxWidth: Dp = 560.dp,
    val closeButtonBg: Color = Color(0xFF3A3A3A)
)

data class OverlayAction(
    val text: String,
    val enabled: Boolean = true,
    val icon: (@Composable () -> Unit)? = null,
    val onClick: () -> Unit
)

private val HandPointerIcon = PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR))
private fun Modifier.handCursor() = this.pointerHoverIcon(HandPointerIcon)

@Composable
fun SelectionOverlay(
    modifier: Modifier = Modifier,
    selectedCount: Int,
    actions: List<OverlayAction>,
    style: OverlayStyle = OverlayStyle(),

    closeButtonGapPx: Float,
    closeButtonSizePx: Float,

    windowSizePx: IntSizePx,
    positionPx: Offset,
    onPositionChangePx: (Offset) -> Unit,
    onClose: () -> Unit
) {
    var overlaySizePx by remember { mutableStateOf(IntSizePx(0, 0)) }


    val latestPosition by rememberUpdatedState(positionPx)
    val latestWindow by rememberUpdatedState(windowSizePx)
    val latestOverlaySize by rememberUpdatedState(overlaySizePx)

    val shape = RoundedCornerShape(style.cornerRadius)

    fun clamp(pos: Offset): Offset {
        val w = latestWindow.w.toFloat()
        val h = latestWindow.h.toFloat()
        val ow = latestOverlaySize.w.toFloat()
        val oh = latestOverlaySize.h.toFloat()

        val extraRight = closeButtonGapPx + closeButtonSizePx
        val extraTop = closeButtonGapPx + closeButtonSizePx

        val maxX = (w - ow - extraRight).coerceAtLeast(0f)
        val maxY = (h - oh).coerceAtLeast(0f)

        val minX = 0f
        val minY = if (maxY >= extraTop) extraTop else 0f

        return Offset(
            x = pos.x.coerceIn(minX, maxX),
            y = pos.y.coerceIn(minY, maxY)
        )
    }

    val clampedPos = clamp(positionPx)

    Box(
        modifier = modifier
            .zIndex(999f)
            .offset { IntOffset(clampedPos.x.roundToInt(), clampedPos.y.roundToInt()) }
            .onGloballyPositioned { coords ->
                overlaySizePx = IntSizePx(coords.size.width, coords.size.height)
            }
    ) {
        Column(
            Modifier
                .clip(shape)
                .background(style.background)
                .border(style.borderWidth, style.borderColor, shape)
                .wrapContentWidth()
                .wrapContentHeight()
                .widthIn(min = 260.dp, max = style.maxWidth)
        ) {

            Row(
                Modifier
                    .wrapContentWidth()
                    .background(style.dragHandleColor)
                    .padding(horizontal = 10.dp, vertical = 8.dp)
                    .handCursor()
                    .pointerInput(Unit) {
                        var startPos = Offset.Zero
                        detectDragGestures(
                            onDragStart = {
                                startPos = clamp(latestPosition)
                            },
                            onDrag = { change, dragAmount ->
                                change.consume()
                                val next = startPos + Offset(dragAmount.x, dragAmount.y)
                                val clamped = clamp(next)
                                onPositionChangePx(clamped)
                                // update anchor so dragging is smooth even with clamping
                                startPos = clamped
                            }
                        )
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Selected: $selectedCount", color = style.titleColor)
                Spacer(Modifier.width(10.dp))
                Text("Drag", color = style.titleColor.copy(alpha = 0.7f))
            }

            Column(Modifier.padding(style.contentPadding)) {
                // simple wrap: 1..4 per row based on measured width
                val perRow = remember(overlaySizePx.w, actions.size) {
                    if (overlaySizePx.w == 0) 4 else (overlaySizePx.w / 160).coerceIn(1, 4)
                }

                actions.chunked(perRow).forEachIndexed { idx, rowActions ->
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        rowActions.forEach { a ->
                            OverlayChip(a, style)
                        }
                    }
                    if (idx != actions.lastIndex / perRow) Spacer(Modifier.height(8.dp))
                }
            }
        }

        // X outside top-right (clamp keeps it visible)
        Box(
            Modifier
                .align(Alignment.TopEnd)
                .offset {
                    IntOffset(
                        x = closeButtonGapPx.roundToInt(),
                        y = (-closeButtonGapPx).roundToInt()
                    )
                }
                .handCursor()
        ) {
            Surface(
                shape = RoundedCornerShape(999.dp),
                color = style.closeButtonBg,
                elevation = 8.dp,
                modifier = Modifier.size(30.dp)
            ) {
                IconButton(onClick = onClose) {
                    Icon(Icons.Filled.Close, contentDescription = "Close", tint = Color.White)
                }
            }
        }
    }
}

@Composable
private fun OverlayChip(a: OverlayAction, style: OverlayStyle) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = if (a.enabled) style.chipColor else style.chipDisabledColor,
        elevation = 4.dp,
        modifier = Modifier.wrapContentWidth().heightIn(min = 36.dp)
    ) {
        Row(
            modifier = Modifier
                .clickable(
                    enabled = a.enabled,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = a.onClick
                )
                .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (a.icon != null) {
                Box(Modifier.size(18.dp)) { a.icon.invoke() }
                Spacer(Modifier.width(8.dp))
            }
            Text(a.text, color = style.chipTextColor)
        }
    }
}