package data_structures.queue

/**
 * A generic Queue implementation based on the FIFO (First In, First Out) principle.
 *
 * In a Queue data structure:
 * - The first element added is the first one to be removed.
 * - Elements are added from the "rear" (enqueue) and removed from the "front" (dequeue).
 *
 * This implementation internally uses [ArrayDeque].
 *
 * ------------------------------------------------------------
 * MutableList vs ArrayDeque
 *
 * MutableList-based Queue:
 * - enqueue(): O(1)
 * - dequeue(): O(n)
 *   Because removeFirst() shifts all remaining elements to the left.
 * - Suitable for learning purposes but inefficient for large data sets.
 *
 * ArrayDeque-based Queue:
 * - enqueue(): O(1)
 * - dequeue(): O(1)
 * - Implemented as a resizable circular array.
 * - No element shifting occurs.
 * - Recommended and idiomatic approach in Kotlin.
 *
 * ------------------------------------------------------------
 * Why not use java.util.Queue or LinkedList?
 *
 * - java.util.Queue is an interface, not a concrete implementation.
 * - LinkedList introduces additional memory overhead due to node-based structure.
 * - Kotlin provides ArrayDeque as a modern, efficient alternative.
 *
 * ------------------------------------------------------------
 *
 * Common use cases:
 * - Task scheduling
 * - Producer / Consumer problems
 * - Breadth First Search (BFS)
 * - Message queues
 * - Request handling systems
 *
 * Time Complexity (ArrayDeque):
 * - enqueue(): O(1)
 * - dequeue(): O(1)
 * - peek(): O(1)
 *
 * Space Complexity:
 * - O(n), where n is the number of elements stored in the queue
 *
 * @param T the type of elements stored in the queue
 */
class Queue<T> {
    val queue = ArrayDeque<T>()

    fun enqueue(element: T){
        queue.add(element)
    }

    fun dequeue(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Queue is empty")
        }
        return queue.removeFirst()
    }

    //Returns the top element without removing it.
    fun peek(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Stack is empty")
        }
        return queue.last()
    }

    fun size(): Int = queue.size

    fun isEmpty(): Boolean{
        return queue.isEmpty()
    }

    fun printQueue(){
        print(queue)
    }
}

fun main(){
    val queue = Queue<Int>()
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    queue.enqueue(4)

    queue.printQueue()

    queue.dequeue()
    queue.dequeue()

    queue.printQueue()
}