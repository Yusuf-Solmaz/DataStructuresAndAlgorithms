package data_structures.depth_first_search

/**
 *
 * This file demonstrates the concept of Depth First Search (DFS)
 * using both recursive and iterative approaches in Kotlin.
 *
 * DFS is a graph/tree traversal algorithm that explores as deep as possible
 * along each branch before backtracking.
 *
 * Core Characteristics:
 * - Uses Stack (explicit or implicit)
 * - Follows LIFO (Last In, First Out)
 * - Suitable for backtracking problems
 *
 * Time Complexity:
 * - O(V + E) where V = number of vertices, E = number of edges
 *
 * Space Complexity:
 * - O(V) due to stack / recursion depth
 */

/**
 * Represents a simple graph using an adjacency list.
 *
 * Example graph:
 * 0 -> 1, 2
 * 1 -> 3
 * 2 -> 4
 * 3 -> []
 * 4 -> []
 */
class Graph(private val size: Int) {

    private val adjacencyList: Array<MutableList<Int>> =
        Array(size) { mutableListOf() }

    /**
     * Adds a directed edge from source to destination.
     *
     * @param from The starting vertex
     * @param to The destination vertex
     */
    fun addEdge(from: Int, to: Int) {
        adjacencyList[from].add(to)
    }

    /**
     * Performs Depth First Search using recursion.
     *
     * This implementation relies on the JVM call stack.
     *
     * @param start The starting vertex
     */
    fun dfsRecursive(start: Int) {
        val visited = BooleanArray(size)
        dfsHelper(start, visited)
    }

    /**
     * Helper function for recursive DFS.
     *
     * @param node Current vertex
     * @param visited Keeps track of visited vertices
     */
    private fun dfsHelper(node: Int, visited: BooleanArray) {
        visited[node] = true
        println("Visited (recursive): $node")

        for (neighbor in adjacencyList[node]) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited)
            }
        }
    }

    /**
     * Performs Depth First Search using an explicit Stack.
     *
     * This is the iterative (non-recursive) version of DFS.
     *
     * @param start The starting vertex
     */
    fun dfsIterative(start: Int) {
        val visited = BooleanArray(size)
        val stack = mutableListOf<Int>()

        stack.add(start)

        while (stack.isNotEmpty()) {
            val node = stack.removeLast()

            if (!visited[node]) {
                visited[node] = true
                println("Visited (iterative): $node")

                // Push neighbors to stack
                // Reverse order is often used to mimic recursive DFS
                for (neighbor in adjacencyList[node].reversed()) {
                    if (!visited[neighbor]) {
                        stack.add(neighbor)
                    }
                }
            }
        }
    }
}

fun main() {
    val graph = Graph(5)

    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 3)
    graph.addEdge(2, 4)

    println("=== Recursive DFS ===")
    graph.dfsRecursive(0)

    println("\n=== Iterative DFS ===")
    graph.dfsIterative(0)
}
