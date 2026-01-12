package data_structures.stack

/**
 * A generic Stack implementation based on the LIFO (Last In, First Out) principle.
 *
 * In a Stack data structure:
 * - The last element added is the first one to be removed.
 * - All operations occur at a single end, commonly referred to as the "top" of the stack.
 *
 * This implementation internally uses a [MutableList] to store elements.
 *
 * ------------------------------------------------------------
 * Why not use java.util.Stack?
 *
 * Java provides java.util.Stack, it is considered a legacy class due to unnecessary synchronization and poor design.
 * In Kotlin, stack behavior is typically implemented using ArrayDeque or MutableList.
 * ------------------------------------------------------------
 *
 * Common use cases:
 * - Function call management (call stack)
 * - Undo / Redo operations
 * - Expression evaluation
 * - Depth First Search (DFS)
 * - Backtracking algorithms
 *
 * Time Complexity:
 * - push(): O(1)
 * - pop(): O(1)
 * - peek(): O(1)
 *
 * Space Complexity:
 * - O(n), where n is the number of elements stored in the stack
 *
 * @param T the type of elements stored in the stack
 */
class Stack<T> {
    private val elements = mutableListOf<T>()

    fun push(item: T){
        elements.add(item)
    }

    fun pop(): T {
        if (elements.isEmpty()) {
            throw NoSuchElementException("Stack is empty")
        }
        return elements.removeLast()
    }

    //Returns the top element without removing it.
    fun peek(): T {
        if (elements.isEmpty()) {
            throw NoSuchElementException("Stack is empty")
        }
        return elements.last()
    }

    fun isEmpty(): Boolean = elements.isEmpty()

    fun size(): Int = elements.size

    fun printStack(){
        println(elements)
    }
}

fun main(){
   val stack = Stack<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)

    stack.printStack()

    stack.pop()
    stack.printStack()
    println(stack.peek())
}