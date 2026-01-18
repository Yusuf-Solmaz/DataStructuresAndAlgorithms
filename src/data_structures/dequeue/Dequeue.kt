package data_structures.dequeue

/**
 * A generic Deque (Double-Ended Queue) implementation.
 *
 * A Deque allows insertion and removal of elements from
 * both ends (front and rear).
 *
 * Supported operations:
 * - addFirst()  → insert at the front
 * - addLast()   → insert at the rear
 * - removeFirst() → remove from the front
 * - removeLast()  → remove from the rear
 *
 * This implementation internally uses [ArrayDeque],
 * which provides efficient O(1) operations for both ends.
 *
 * ------------------------------------------------------------
 * Why use Deque?
 *
 * Deque is more flexible than Stack or Queue:
 * - Stack  → LIFO only
 * - Queue  → FIFO only
 * - Deque  → Both FIFO and LIFO behavior
 *
 * ------------------------------------------------------------
 * Common use cases:
 * - Sliding window problems
 * - Undo / Redo systems
 * - Palindrome checking
 * - Implementing Stack or Queue behavior
 * - Cache mechanisms (LRU Cache)
 *
 * ------------------------------------------------------------
 * Time Complexity:
 * - addFirst(): O(1)
 * - addLast(): O(1)
 * - removeFirst(): O(1)
 * - removeLast(): O(1)
 * - peekFirst(): O(1)
 * - peekLast(): O(1)
 *
 * Space Complexity:
 * - O(n), where n is the number of elements stored in the deque
 *
 * @param T the type of elements stored in the deque
 */
class Deque<T> {

    private val deque = ArrayDeque<T>()

    // Inserts an element at the front of the deque
    fun addFirst(element: T) {
        deque.addFirst(element)
    }

    // Inserts an element at the end of the deque
    fun addLast(element: T) {
        deque.addLast(element)
    }

    // Removes and returns the front element
    fun removeFirst(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Deque is empty")
        }
        return deque.removeFirst()
    }

    // Removes and returns the last element
    fun removeLast(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Deque is empty")
        }
        return deque.removeLast()
    }

    // Returns the front element without removing it
    fun peekFirst(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Deque is empty")
        }
        return deque.first()
    }

    // Returns the last element without removing it
    fun peekLast(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Deque is empty")
        }
        return deque.last()
    }

    fun size(): Int = deque.size

    fun isEmpty(): Boolean = deque.isEmpty()

    fun printDeque() {
        println(deque)
    }
}

fun main() {
    val deque = Deque<Int>()

    deque.addFirst(2)
    deque.addFirst(1)
    deque.addLast(3)
    deque.addLast(4)

    deque.printDeque() // [1, 2, 3, 4]

    deque.removeFirst()
    deque.removeLast()

    deque.printDeque() // [2, 3]
}
