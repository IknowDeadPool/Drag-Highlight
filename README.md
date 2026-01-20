# Drag Highlight box

A lightweight Jetpack Compose utility that enables drag-based selection by drawing a selection rectangle and consuming drag gestures to prevent parent scroll or drag conflicts.

Designed as a **low-level primitive**, this library helps you build selection-based UX such as editors, canvases, dashboards, and boards — without enforcing any opinionated UI or behavior.

---

##  Features

- Draws a visual selection rectangle while dragging
- Consumes drag gestures to avoid parent scroll interference
- Optional hit-testing to start selection only on empty space
- Fully customizable selection style (colors, stroke width)
- Works with Jetpack Compose and Compose Multiplatform
- Small, focused API — no editor logic included

---

## Installation

>  Published to Maven Central.  

```kotlin
implementation("io.github.iknowdeadpool:dragfeedback-core:0.1.0") 
```

```kotlin
#  Quick Start
DragHighlightBox(
    enabled = true,
    onSelectionEnd = { rect ->
        // Handle selection rectangle
    }
) {
    // Your composable content
}
```

# Customization

You can customize how the selection rectangle looks using DragFeedbackStyle:
```kotlin
DragHighlightBox(
    style = DragFeedbackStyle(
        fillColor = Color(0x3388BFFF),
        strokeColor = Color(0xFF66AFFF),
        strokeWidthPx = 2f
    ),
    onSelectionEnd = { rect -> }
) {
    CanvasContent()
}
```

# Hit Testing

To prevent selection from starting when the user drags an item (instead of empty space), use canStartSelection:
```kotlin
DragHighlightBox(
    canStartSelection = { downOffset ->
        items.none { it.bounds.contains(downOffset) }
    },
    onSelectionEnd = { rect -> }
) {
    CanvasContent()
}
```


# Demo

A desktop demo application is included in the repository to showcase integration patterns and usage.
The demo is not part of the published library.

# Contributions
Issues and feature requests are welcome.
Please open an issue before submitting large changes.
