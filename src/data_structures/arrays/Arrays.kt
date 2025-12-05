package data_structures.arrays

import java.math.BigDecimal

/**
 * Represents a Kotlin Array that can hold elements of different types.
 *
 * ## General Features of Array
 * - Arrays have a **fixed size**; it cannot grow or shrink after creation.
 * - Can hold **mixed types** if the inferred type is `Array<Any>` or explicitly declared so.
 * - Index-based access: elements can be read or assigned via `array[index]`.
 * - Provides utility functions such as:
 *   - `size` → returns number of elements
 *   - `get(index)` / `set(index, value)`
 *   - `forEach`, `map`, `filter`, `contains`, etc.
 *
 * ## Adding or Removing Items
 * - Arrays **do not support add/remove operations** directly.
 * - To add or remove items, convert to a mutable list:
 *   - `val list = myArray.toMutableList()`
 *   - `list.add(...)`
 *   - `list.removeAt(index)`
 *   - `val newArray = list.toTypedArray()`
 *
 * ## RAM / Memory Overview
 * - Arrays are stored in **heap memory (RAM)**.
 * - The array itself occupies:
 *   - A **contiguous block of memory** that holds references (pointers) to its elements.
 * - The actual objects (`String`, `Int`, `BigDecimal`) may reside in **different locations in heap memory**, but the array stores references to them.
 * - Because the size of an array is fixed, the JVM **cannot resize the allocated memory block**. Any size change requires creating a new array.
 * - Accessing an element via its index (`array[i]`) has **O(1) time complexity**, since the index is translated directly into a memory address.
 * - Modifying an element does not reallocate memory; only the reference stored at that index is replaced.
 *
 * ## Use Case
 * This array contains:
 * - A `String` ("Value")
 * - An `Int` (1)
 * - A `BigDecimal` (25)
 *
 * Since these types share no specific common interface, Kotlin infers the array as `Array<Any>`.
 */
fun main(){
    val myArray = arrayOf("Value",1,BigDecimal.valueOf(25))

    println(myArray[0])

    myArray.forEach {
        println(it)
    }
}