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

##  Installation

>  Publishing to Maven Central is planned.  
> For now, you can depend on the library via source or GitHub packages.

(Once published, usage will look like:)

```kotlin
implementation("me.BalajiVellaluru:dragfeedback-core:0.1.0")
