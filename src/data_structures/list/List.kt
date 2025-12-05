package data_structures.list



/**
 * Represents a Kotlin `List` (specifically `MutableList` / `ArrayList`) and explains how it behaves in memory.
 *
 * ## General Features
 * - `List` is read‑only; `MutableList` allows adding/removing elements.
 * - Backed by Java’s **ArrayList**, which internally uses a **dynamic array**.
 * - Can grow or shrink as needed.
 * - Supports index‑based access.
 *
 * ## Memory Structure
 * - Stored entirely in **heap memory (RAM)**.
 * - Internally maintains a **contiguous array of references** — similar to Kotlin/Java Arrays.
 * - Objects themselves (`String`, `Int`, custom classes, etc.) can reside anywhere in heap memory; the list only stores **references**.
 *
 * ### Dynamic Resizing
 * When adding elements exceeds the current capacity:
 * - A **new, larger contiguous memory block** is allocated.
 * - All element references are **copied** into the new block.
 * - Old array memory becomes eligible for garbage collection.
 *
 * This is why lists feel “infinite,” but they’re not — they grow by allocating larger blocks when needed.
 *
 * ### Performance Characteristics
 * - Index access: **O(1)** (direct address calculation).
 * - Append (`add` at end): **Amortized O(1)** — because resizing does *not* happen every time.
 * - Insert/remove in the middle: **O(n)** — requires shifting elements.
 *
 * ## Example
 * Demonstrates basic operations on a mutable list.
 */

fun main() {
    val list = mutableListOf("A", 1, "C")
    list.add("D")
    list.removeAt(1)
    println(list)
}
