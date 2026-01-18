
package com.dragfeedback.core
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke

import androidx.compose.ui.input.pointer.pointerInput
import kotlin.math.max
import kotlin.math.min

@Immutable
data class DragFeedbackStyle(
    val fillColor: Color = Color(0x3388BFFF),
    val strokeColor: Color = Color(0xFF66AFFF),
    val strokeWidthPx: Float = 2f
)

/**
 * Draws a selection rectangle while dragging and CONSUMES the drag,
 * so parent scroll/drag doesn't happen.
 *
 * Use [canStartSelection] to only allow selection when dragging starts on empty space.
 *
 * @param onSelectionEnd Called with the selection [Rect] when drag ends.
 */
@Composable
fun DragHighlightBox(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: DragFeedbackStyle = DragFeedbackStyle(),
    canStartSelection: ((Offset) -> Boolean)? = null,
    onSelectionEnd: ((Rect) -> Unit)? = null,
    content: @Composable () -> Unit
) {
    var dragging by remember { mutableStateOf(false) }
    var start by remember { mutableStateOf(Offset.Zero) }
    var current by remember { mutableStateOf(Offset.Zero) }

    val finalModifier =
        if (enabled) {
            modifier.pointerInput(enabled, canStartSelection) {
                detectDragGestures(
                    onDragStart = { down ->
                        val ok = canStartSelection?.invoke(down) ?: true
                        if (!ok) {
                            dragging = false
                            return@detectDragGestures
                        }
                        dragging = true
                        start = down
                        current = down
                    },
                    onDrag = { change, dragAmount ->
                        if (!dragging) return@detectDragGestures
                        change.consume()
                        current = current + Offset(dragAmount.x, dragAmount.y)
                    },
                    onDragEnd = {
                        if (!dragging) return@detectDragGestures
                        val rect = toRect(start, current)
                        dragging = false
                        onSelectionEnd?.invoke(rect)
                    },
                    onDragCancel = { dragging = false }
                )
            }
        } else {
            modifier
        }

    Box(finalModifier) {
        content()

        if (enabled && dragging) {
            val rect = toRect(start, current)
            Canvas(Modifier.fillMaxSize()) {
                drawRect(style.fillColor, rect.topLeft, rect.size)
                drawRect(
                    color = style.strokeColor,
                    topLeft = rect.topLeft,
                    size = rect.size,
                    style = Stroke(style.strokeWidthPx)
                )
            }
        }
    }
}

private fun toRect(a: Offset, b: Offset): Rect {
    val left = min(a.x, b.x)
    val top = min(a.y, b.y)
    val right = max(a.x, b.x)
    val bottom = max(a.y, b.y)
    return Rect(left, top, right, bottom)
}

