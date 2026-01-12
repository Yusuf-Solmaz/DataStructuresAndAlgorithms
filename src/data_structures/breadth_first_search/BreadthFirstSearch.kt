package data_structures.breadth_first_search

/**
 * This file demonstrates the concept of Breadth First Search (BFS)
 * using an iterative, queue-based approach in Kotlin.
 *
 * BFS is a graph/tree traversal algorithm that explores nodes
 * level by level, visiting all neighbors of a node before moving
 * to the next depth level.
 *
 * Core Characteristics:
 * - Uses Queue (FIFO: First In, First Out)
 * - Traverses level by level
 * - Ideal for shortest path problems in unweighted graphs
 *
 * Time Complexity:
 * - O(V + E) where V = number of vertices, E = number of edges
 *
 * Space Complexity:
 * - O(V) due to queue and visited array
 */

/**
 * Represents a simple directed graph using an adjacency list.
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
     * Adds a directed edge from one vertex to another.
     *
     * @param from The source vertex
     * @param to The destination vertex
     */
    fun addEdge(from: Int, to: Int) {
        adjacencyList[from].add(to)
    }

    /**
     * Performs Breadth First Search (BFS) starting from a given node.
     *
     * This implementation uses a Queue to ensure FIFO behavior.
     *
     * @param start The starting vertex
     */
    fun bfs(start: Int) {
        val visited = BooleanArray(size)
        val queue: ArrayDeque<Int> = ArrayDeque()

        visited[start] = true
        queue.add(start)

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            println("Visited (BFS): $node")

            for (neighbor in adjacencyList[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true
                    queue.add(neighbor)
                }
            }
        }
    }

    /**
     * Performs Breadth First Search (BFS) and prints nodes level by level.
     *
     * This variation is useful for understanding layer-based traversal.
     *
     * @param start The starting vertex
     */
    fun bfsByLevel(start: Int) {
        val visited = BooleanArray(size)
        val queue: ArrayDeque<Int> = ArrayDeque()

        visited[start] = true
        queue.add(start)

        var level = 0

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            println("Level $level:")

            repeat(levelSize) {
                val node = queue.removeFirst()
                print("$node ")

                for (neighbor in adjacencyList[node]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true
                        queue.add(neighbor)
                    }
                }
            }

            println()
            level++
        }
    }
}

fun main() {
    val graph = Graph(5)

    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 3)
    graph.addEdge(2, 4)

    println("=== BFS Traversal ===")
    graph.bfs(0)

    println("\n=== BFS Level Order Traversal ===")
    graph.bfsByLevel(0)
}
