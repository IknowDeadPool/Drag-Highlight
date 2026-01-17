//package com.drawFeedback.demo
//
//
////import androidx.compose.foundation.ExperimentalLayoutApi
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.gestures.detectDragGestures
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.FlowRow
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Close
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.Immutable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.graphics.Color
////import androidx.compose.ui.input.pointer.consume
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.IntOffset
//import androidx.compose.ui.unit.dp
//import kotlin.math.roundToInt
//
//@Immutable
//data class OverlayStyle(
//    val background: Color = Color(0xFF2B2B2B),
//    val borderColor: Color = Color(0xFF444444),
//    val borderWidth: Dp = 1.dp,
//    val contentPadding: Dp = 10.dp,
//    val cornerRadius: Dp = 10.dp,
//    val titleColor: Color = Color.White,
//    val chipColor: Color = Color(0xFF3A3A3A),
//    val chipDisabledColor: Color = Color(0xFF2A2A2A),
//    val chipTextColor: Color = Color.White,
//    val closeButtonGap: Dp = 6.dp,     // gap between panel and outside close button
//    val closeButtonSize: Dp = 30.dp
//)
//
//data class OverlayAction(
//    val text: String,
//    val enabled: Boolean = true,
//    val icon: (@Composable () -> Unit)? = null,
//    val onClick: () -> Unit
//)
//
///**
// * Draggable overlay panel.
// *
// * - positionPx: current position in pixels (caller owns the state)
// * - onPositionChangePx: called with updated position after drag
// * - close button is OUTSIDE the panel at top-right with a gap
// */
//@OptIn(ExperimentalLayoutApi::class)
//@Composable
//fun SelectionOverlay(
//    modifier: Modifier = Modifier,
//    selectedCount: Int,
//    actions: List<OverlayAction>,
//    style: OverlayStyle = OverlayStyle(),
//    positionPx: Offset,
//    onPositionChangePx: (Offset) -> Unit,
//    onClose: () -> Unit
//) {
//    // Root at requested position (in pixels)
//    Box(
//        modifier = modifier
//            .offset { IntOffset(positionPx.x.roundToInt(), positionPx.y.roundToInt()) }
//    ) {
//        // Panel + drag handle (we let the whole panel be draggable)
//        Column(
//            Modifier
//                .clip(RoundedCornerShape(style.cornerRadius))
//                .background(style.background)
//                .border(style.borderWidth, style.borderColor, RoundedCornerShape(style.cornerRadius))
//                .padding(style.contentPadding)
//                .wrapContentHeight()
//                .widthIn(min = 260.dp)
//                .pointerInput(Unit) {
//                    detectDragGestures(
//                        onDrag = { change, dragAmount ->
//                            change.consume()
//                            onPositionChangePx(positionPx + Offset(dragAmount.x, dragAmount.y))
//                        }
//                    )
//                }
//        ) {
//            Text(
//                text = "Selected: $selectedCount",
//                color = style.titleColor
//            )
//
//            Spacer(Modifier.height(8.dp))
//
//            FlowRow(
//                horizontalArrangement = Arrangement.spacedBy(8.dp),
//                verticalArrangement = Arrangement.spacedBy(8.dp),
//                maxItemsInEachRow = 4
//            ) {
//                actions.forEach { a ->
//                    OverlayChip(
//                        icon = a.icon,
//                        text = a.text,
//                        enabled = a.enabled,
//                        style = style,
//                        onClick = a.onClick
//                    )
//                }
//            }
//        }
//
//        // Close button OUTSIDE top-right with a small gap
//        Box(
//            Modifier
//                .align(Alignment.TopEnd)
//                .offset(x = style.closeButtonGap, y = (-style.closeButtonGap))
//        ) {
//            Surface(
//                shape = RoundedCornerShape(999.dp),
//                color = Color(0xFF3A3A3A),
//                elevation = 6.dp,
//                modifier = Modifier.size(style.closeButtonSize)
//            ) {
//                IconButton(onClick = onClose) {
//                    Icon(Icons.Filled.Close, contentDescription = "Close", tint = Color.White)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//private fun OverlayChip(
//    icon: (@Composable () -> Unit)?,
//    text: String,
//    enabled: Boolean,
//    style: OverlayStyle,
//    onClick: () -> Unit
//) {
//    Surface(
//        shape = RoundedCornerShape(8.dp),
//        color = if (enabled) style.chipColor else style.chipDisabledColor,
//        modifier = Modifier.heightIn(min = 36.dp)
//    ) {
//        Row(
//            modifier = Modifier
//                .clickable(
//                    enabled = enabled,
//                    interactionSource = MutableInteractionSource(),
//                    indication = null,
//                    onClick = onClick
//                )
//                .padding(horizontal = 10.dp, vertical = 8.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            if (icon != null) {
//                Box(Modifier.size(18.dp)) { icon() }
//                Spacer(Modifier.width(8.dp))
//            }
//            Text(text, color = style.chipTextColor)
//        }
//    }
//}

//
//package com.dragfeedback.demo
//
//import androidx.compose.animation.core.FastOutSlowInEasing
//import androidx.compose.animation.core.RepeatMode
//import androidx.compose.animation.core.animateFloat
//import androidx.compose.animation.core.infiniteRepeatable
//import androidx.compose.animation.core.rememberInfiniteTransition
//import androidx.compose.animation.core.tween
////import androidx.compose.foundation.ExperimentalLayoutApi
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.gestures.detectDragGestures
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.FlowRow
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Icon
//import androidx.compose.material.IconButton
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Close
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.Immutable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.input.pointer.PointerIcon
////import androidx.compose.ui.input.pointer.consume
//import androidx.compose.ui.input.pointer.pointerHoverIcon
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.IntOffset
//import androidx.compose.ui.unit.dp
//import java.awt.Cursor
//import kotlin.math.roundToInt
//
//@Immutable
//data class OverlayStyle(
//    val background: Color = Color(0xFF2B2B2B),
//    val baseBorderColor: Color = Color(0xFF444444),
//    val pulseBorderColor: Color = Color(0xFF66AFFF),
//    val borderWidth: Dp = 1.dp,
//    val contentPadding: Dp = 10.dp,
//    val cornerRadius: Dp = 10.dp,
//    val titleColor: Color = Color.White,
//    val chipColor: Color = Color(0xFF3A3A3A),
//    val chipDisabledColor: Color = Color(0xFF2A2A2A),
//    val chipTextColor: Color = Color.White,
//    val closeButtonGap: Dp = 28.dp,
//    val closeButtonSize: Dp = 30.dp
//)
//
//data class OverlayAction(
//    val text: String,
//    val enabled: Boolean = true,
//    val icon: (@Composable () -> Unit)? = null,
//    val onClick: () -> Unit
//)
//
//private val HandPointerIcon = PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR))
//private fun Modifier.handCursor() = this.pointerHoverIcon(HandPointerIcon)
//
///**
// * Draggable overlay panel with pulsing border and close button outside top-right.
// * positionPx is in pixels (caller owns it).
// */
//@OptIn(ExperimentalLayoutApi::class)
//@Composable
//fun SelectionOverlay(
//    modifier: Modifier = Modifier,
//    selectedCount: Int,
//    actions: List<OverlayAction>,
//    style: OverlayStyle = OverlayStyle(),
//    positionPx: Offset,
//    onPositionChangePx: (Offset) -> Unit,
//    onClose: () -> Unit
//) {
//    // Pulse for border alpha ("piping" glow)
//    val infinite = rememberInfiniteTransition()
//    val pulseAlpha by infinite.animateFloat(
//        initialValue = 0.25f,
//        targetValue = 0.95f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(900, easing = FastOutSlowInEasing),
//            repeatMode = RepeatMode.Reverse
//        )
//    )
//
//    val shape = RoundedCornerShape(style.cornerRadius)
//    val pulsingBorder = style.pulseBorderColor.copy(alpha = pulseAlpha)
//
//    Box(
//        modifier = modifier
//            .offset { IntOffset(positionPx.x.roundToInt(), positionPx.y.roundToInt()) }
//    ) {
//        // Panel (drag anywhere on it)
//        Column(
//            Modifier
//                .handCursor()
//                .clip(shape)
//                .background(style.background)
//                .border(style.borderWidth, style.baseBorderColor, shape)
//                .border(style.borderWidth, pulsingBorder, shape)
//                .padding(style.contentPadding)
//                .wrapContentHeight()
//                .widthIn(min = 260.dp)
//                .pointerInput(positionPx) {
//                    // Correct drag logic: capture start + accumulate
//                    var startPos = Offset.Zero
//                    var acc = Offset.Zero
//                    detectDragGestures(
//                        onDragStart = {
//                            startPos = positionPx
//                            acc = Offset.Zero
//                        },
//                        onDrag = { change, dragAmount ->
//                            change.consume()
//                            acc += Offset(dragAmount.x, dragAmount.y)
//                            onPositionChangePx(startPos + acc)
//                        }
//                    )
//                }
//        ) {
//            Text("Selected: $selectedCount", color = style.titleColor)
//            Spacer(Modifier.height(8.dp))
//
//            FlowRow(
//                horizontalArrangement = Arrangement.spacedBy(8.dp),
//                verticalArrangement = Arrangement.spacedBy(8.dp),
//                maxItemsInEachRow = 4
//            ) {
//                actions.forEach { a ->
//                    OverlayChip(
//                        icon = a.icon,
//                        text = a.text,
//                        enabled = a.enabled,
//                        style = style,
//                        onClick = a.onClick
//                    )
//                }
//            }
//        }
//
//        // Close button OUTSIDE top-right corner with a gap
//        Box(
//            Modifier
//                .align(Alignment.TopEnd)
//                .offset(x = style.closeButtonGap, y = (-style.closeButtonGap))
//                .handCursor()
//        ) {
//            Surface(
//                shape = RoundedCornerShape(999.dp),
//                color = Color(0xFF3A3A3A),
//                elevation = 8.dp,
//                modifier = Modifier.size(style.closeButtonSize)
//            ) {
//                IconButton(onClick = onClose) {
//                    Icon(Icons.Filled.Close, contentDescription = "Close", tint = Color.White)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//private fun OverlayChip(
//    icon: (@Composable () -> Unit)?,
//    text: String,
//    enabled: Boolean,
//    style: OverlayStyle,
//    onClick: () -> Unit
//) {
//    Surface(
//        shape = RoundedCornerShape(8.dp),
//        color = if (enabled) style.chipColor else style.chipDisabledColor,
//        elevation = 4.dp,
//        modifier = Modifier
//            .heightIn(min = 36.dp)
//            .handCursor()
//    ) {
//        Row(
//            modifier = Modifier
//                .clickable(
//                    enabled = enabled,
//                    interactionSource = remember { MutableInteractionSource() },
//                    indication = null,
//                    onClick = onClick
//                )
//                .padding(horizontal = 10.dp, vertical = 8.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            if (icon != null) {
//                Box(Modifier.size(18.dp)) { icon() }
//                Spacer(Modifier.width(8.dp))
//            }
//            Text(text, color = style.chipTextColor)
//        }
//    }
//}

//package com.dragfeedback.demo
//
//import androidx.compose.animation.core.FastOutSlowInEasing
//import androidx.compose.animation.core.RepeatMode
//import androidx.compose.animation.core.animateFloat
//import androidx.compose.animation.core.infiniteRepeatable
//import androidx.compose.animation.core.rememberInfiniteTransition
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.gestures.detectDragGestures
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Icon
//import androidx.compose.material.IconButton
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Close
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.Immutable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.input.pointer.PointerIcon
//import androidx.compose.ui.input.pointer.PointerInputChange
//import androidx.compose.ui.input.pointer.pointerHoverIcon
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.IntOffset
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.zIndex
//import java.awt.Cursor
//import kotlin.math.roundToInt
//
//@Immutable
//data class OverlayStyle(
//    val background: Color = Color(0xFF2B2B2B),
//    val baseBorderColor: Color = Color(0xFF444444),
//    val pulseBorderColor: Color = Color(0xFF66AFFF),
//    val borderWidth: Dp = 1.dp,
//    val contentPadding: Dp = 10.dp,
//    val cornerRadius: Dp = 10.dp,
//    val titleColor: Color = Color.White,
//    val dragHandleColor: Color = Color(0xFF1F1F1F),
//
//    val chipColor: Color = Color(0xFF3A3A3A),
//    val chipDisabledColor: Color = Color(0xFF2A2A2A),
//    val chipTextColor: Color = Color.White,
//
//    val closeButtonGap: Dp = 16.dp,
//    val closeButtonSize: Dp = 30.dp
//)
//
//data class OverlayAction(
//    val text: String,
//    val enabled: Boolean = true,
//    val icon: (@Composable () -> Unit)? = null,
//    val onClick: () -> Unit
//)
//
//private val HandPointerIcon = PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR))
//private fun Modifier.handCursor() = this.pointerHoverIcon(HandPointerIcon)
//
//// Works across versions where consume() extension may not resolve
//private fun PointerInputChange.safeConsume() {
//    try {
//        this.consume()
//    } catch (_: Throwable) {
//        // ignore; on older versions this may not exist
//    }
//}
//
//@Composable
//fun SelectionOverlay(
//    modifier: Modifier = Modifier,
//    selectedCount: Int,
//    actions: List<OverlayAction>,
//    style: OverlayStyle = OverlayStyle(),
//    positionPx: Offset,
//    onPositionChangePx: (Offset) -> Unit,
//    onClose: () -> Unit
//) {
//    val infinite = rememberInfiniteTransition()
//    val pulseAlpha by infinite.animateFloat(
//        initialValue = 0.25f,
//        targetValue = 0.95f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(900, easing = FastOutSlowInEasing),
//            repeatMode = RepeatMode.Reverse
//        )
//    )
//
//    val shape = RoundedCornerShape(style.cornerRadius)
//    val pulsingBorder = style.pulseBorderColor.copy(alpha = pulseAlpha)
//
//    Box(
//        modifier = modifier
//            .zIndex(999f)
//            .offset { IntOffset(positionPx.x.roundToInt(), positionPx.y.roundToInt()) }
//    ) {
//        Column(
//            Modifier
//                .clip(shape)
//                .background(style.background)
//                .border(style.borderWidth, style.baseBorderColor, shape)
//                .border(style.borderWidth, pulsingBorder, shape)
//                .wrapContentHeight()
//                .widthIn(min = 260.dp)
//        ) {
//            // DRAG HANDLE (drag only from here)
//            Row(
//                Modifier
//                    .fillMaxWidth()
//                    .background(style.dragHandleColor)
//                    .padding(horizontal = 10.dp, vertical = 8.dp)
//                    .handCursor()
//                    .pointerInput(positionPx) {
//                        var startPos = Offset.Zero
//                        var acc = Offset.Zero
//                        detectDragGestures(
//                            onDragStart = {
//                                startPos = positionPx
//                                acc = Offset.Zero
//                            },
//                            onDrag = { change, dragAmount ->
//                                change.safeConsume()
//                                acc += Offset(dragAmount.x, dragAmount.y)
//                                onPositionChangePx(startPos + acc)
//                            }
//                        )
//                    },
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text("Selected: $selectedCount", color = style.titleColor, modifier = Modifier.weight(1f))
//                Text("Drag here", color = style.titleColor.copy(alpha = 0.7f))
//            }
//
//            // Buttons row(s) without FlowRow
//            Column(Modifier.padding(style.contentPadding)) {
//                // Put up to 4 buttons per row
//                val chunked = actions.chunked(4)
//                chunked.forEach { rowActions ->
//                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//                        rowActions.forEach { a ->
//                            OverlayChip(
//                                icon = a.icon,
//                                text = a.text,
//                                enabled = a.enabled,
//                                style = style,
//                                onClick = a.onClick
//                            )
//                        }
//                    }
//                    Spacer(Modifier.height(8.dp))
//                }
//            }
//        }
//
//        // Close button outside top-right
//        Box(
//            Modifier
//                .align(Alignment.TopEnd)
//                .offset(x = style.closeButtonGap, y = (-style.closeButtonGap))
//                .handCursor()
//        ) {
//            Surface(
//                shape = RoundedCornerShape(999.dp),
//                color = Color(0xFF3A3A3A),
//                elevation = 8.dp,
//                modifier = Modifier.size(style.closeButtonSize)
//            ) {
//                IconButton(onClick = onClose) {
//                    Icon(Icons.Filled.Close, contentDescription = "Close", tint = Color.White)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//private fun OverlayChip(
//    icon: (@Composable () -> Unit)?,
//    text: String,
//    enabled: Boolean,
//    style: OverlayStyle,
//    onClick: () -> Unit
//) {
//    Surface(
//        shape = RoundedCornerShape(8.dp),
//        color = if (enabled) style.chipColor else style.chipDisabledColor,
//        elevation = 4.dp,
//        modifier = Modifier
//            .heightIn(min = 36.dp)
//            .handCursor()
//    ) {
//        Row(
//            modifier = Modifier
//                .clickable(
//                    enabled = enabled,
//                    interactionSource = remember { MutableInteractionSource() },
//                    indication = null,
//                    onClick = onClick
//                )
//                .padding(horizontal = 10.dp, vertical = 8.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            if (icon != null) {
//                Box(Modifier.size(18.dp)) { icon() }
//                Spacer(Modifier.width(8.dp))
//            }
//            Text(text, color = style.chipTextColor)
//        }
//    }
//}


//
//package com.dragfeedback.demo
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.gestures.detectDragGestures
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Icon
//import androidx.compose.material.IconButton
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Close
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.input.pointer.PointerIcon
//
//import androidx.compose.ui.input.pointer.pointerHoverIcon
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.layout.onGloballyPositioned
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.IntOffset
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.zIndex
//import java.awt.Cursor
//import kotlin.math.roundToInt
//
//@Immutable
//data class IntSizePx(val w: Int, val h: Int)
//
//@Immutable
//data class OverlayStyle(
//    val background: Color = Color(0xFF2B2B2B),
//    val borderColor: Color = Color(0xFF444444),
//    val borderWidth: Dp = 1.dp,
//    val contentPadding: Dp = 10.dp,
//    val cornerRadius: Dp = 10.dp,
//    val titleColor: Color = Color.White,
//    val dragHandleColor: Color = Color(0xFF1F1F1F),
//
//    val chipColor: Color = Color(0xFF3A3A3A),
//    val chipDisabledColor: Color = Color(0xFF2A2A2A),
//    val chipTextColor: Color = Color.White,
//
//    // wrap behavior
//    val maxWidth: Dp = 520.dp,
//
//    val closeButtonBg: Color = Color(0xFF3A3A3A),
//)
//
//data class OverlayAction(
//    val text: String,
//    val enabled: Boolean = true,
//    val icon: (@Composable () -> Unit)? = null,
//    val onClick: () -> Unit
//)
//
//private val HandPointerIcon = PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR))
//private fun Modifier.handCursor() = this.pointerHoverIcon(HandPointerIcon)
//
//@Composable
//fun SelectionOverlay(
//    modifier: Modifier = Modifier,
//    selectedCount: Int,
//    actions: List<OverlayAction>,
//    style: OverlayStyle = OverlayStyle(),
//
//    // provided by Demo using LocalDensity
//    closeButtonGapPx: Float,
//    closeButtonSizePx: Float,
//
//    windowSizePx: IntSizePx,
//    positionPx: Offset,
//    onPositionChangePx: (Offset) -> Unit,
//    onClose: () -> Unit
//) {
//    var overlaySizePx by remember { mutableStateOf(IntSizePx(0, 0)) }
//
//    val shape = RoundedCornerShape(style.cornerRadius)
//
//    fun clamp(pos: Offset): Offset {
//        // extra space because X is outside on top-right
//        val extraRight = closeButtonGapPx + closeButtonSizePx
//        val extraTop = closeButtonGapPx + closeButtonSizePx
//
//        val maxX =
//            (windowSizePx.w.toFloat() - overlaySizePx.w.toFloat() - extraRight).coerceAtLeast(0f)
//        val maxY =
//            (windowSizePx.h.toFloat() - overlaySizePx.h.toFloat()).coerceAtLeast(0f)
//
//        val x = pos.x.coerceIn(0f, maxX)
//        val y = pos.y.coerceIn(extraTop, maxY)
//        return Offset(x, y)
//    }
//
//    val clampedPos = clamp(positionPx)
//
//    Box(
//        modifier = modifier
//            .zIndex(999f)
//            .offset { IntOffset(clampedPos.x.roundToInt(), clampedPos.y.roundToInt()) }
//            .onGloballyPositioned { coords ->
//                overlaySizePx = IntSizePx(coords.size.width, coords.size.height)
//            }
//    ) {
//        Column(
//            Modifier
//                .clip(shape)
//                .background(style.background)
//                .border(style.borderWidth, style.borderColor, shape)
//                // ✅ KEY: overlay should NOT fill the window
//                .wrapContentHeight()
//                .wrapContentWidth()
//                .widthIn(min = 260.dp, max = style.maxWidth)
//        ) {
//            // ✅ Drag handle (NO fillMaxWidth => prevents stretching)
//            Row(
//                Modifier
//                    .wrapContentWidth()
//                    .background(style.dragHandleColor)
//                    .padding(horizontal = 10.dp, vertical = 8.dp)
//                    .handCursor()
//                    .pointerInput(clampedPos, windowSizePx, overlaySizePx) {
//                        var startPos = Offset.Zero
//                        var acc = Offset.Zero
//                        detectDragGestures(
//                            onDragStart = {
//                                startPos = clampedPos
//                                acc = Offset.Zero
//                            },
//                            onDrag = { change, dragAmount ->
//                                change.consume()
//                                acc += Offset(dragAmount.x, dragAmount.y)
//                                onPositionChangePx(clamp(startPos + acc))
//                            }
//                        )
//                    },
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text("Selected: $selectedCount", color = style.titleColor)
//                Spacer(Modifier.width(10.dp))
//                Text("Drag", color = style.titleColor.copy(alpha = 0.7f))
//            }
//
//            // ✅ Flex-like wrapping: compute how many buttons fit per row
//            Column(
//                Modifier
//                    .padding(style.contentPadding)
//                    .wrapContentWidth()
//            ) {
//                val perRow = remember(actions.size, overlaySizePx.w) {
//                    // Simple heuristic: ~140px per chip (icon+text+padding).
//                    // As window shrinks, overlay max width shrinks, so perRow goes down.
//                    // Clamp between 1..4.
//                    val approx = (overlaySizePx.w / 140).coerceIn(1, 4)
//                    if (overlaySizePx.w == 0) 4 else approx
//                }
//
//                actions.chunked(perRow).forEachIndexed { idx, rowActions ->
//                    Row(
//                        modifier = Modifier.wrapContentWidth(),
//                        horizontalArrangement = Arrangement.spacedBy(8.dp),
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        rowActions.forEach { a ->
//                            OverlayChip(
//                                icon = a.icon,
//                                text = a.text,
//                                enabled = a.enabled,
//                                style = style,
//                                onClick = a.onClick
//                            )
//                        }
//                    }
//                    if (idx != actions.lastIndex / perRow) Spacer(Modifier.height(8.dp))
//                }
//            }
//        }
//
//        // ✅ X button outside top-right; clamping keeps it visible
//        Box(
//            Modifier
//                .align(Alignment.TopEnd)
//                .offset {
//                    IntOffset(
//                        x = closeButtonGapPx.roundToInt(),
//                        y = (-closeButtonGapPx).roundToInt()
//                    )
//                }
//                .handCursor()
//        ) {
//            Surface(
//                shape = RoundedCornerShape(999.dp),
//                color = style.closeButtonBg,
//                elevation = 8.dp,
//                modifier = Modifier.size(30.dp)
//            ) {
//                IconButton(onClick = onClose) {
//                    Icon(Icons.Filled.Close, contentDescription = "Close", tint = Color.White)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//private fun OverlayChip(
//    icon: (@Composable () -> Unit)?,
//    text: String,
//    enabled: Boolean,
//    style: OverlayStyle,
//    onClick: () -> Unit
//) {
//    Surface(
//        shape = RoundedCornerShape(8.dp),
//        color = if (enabled) style.chipColor else style.chipDisabledColor,
//        elevation = 4.dp,
//        modifier = Modifier
//            .wrapContentWidth()      // ✅ don’t stretch
//            .heightIn(min = 36.dp)
//            .handCursor()
//    ) {
//        Row(
//            modifier = Modifier
//                .clickable(
//                    enabled = enabled,
//                    interactionSource = remember { MutableInteractionSource() },
//                    indication = null,
//                    onClick = onClick
//                )
//                .padding(horizontal = 10.dp, vertical = 8.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            if (icon != null) {
//                Box(Modifier.size(18.dp)) { icon() }
//                Spacer(Modifier.width(8.dp))
//            }
//            Text(text, color = style.chipTextColor)
//        }
//    }
//}


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





