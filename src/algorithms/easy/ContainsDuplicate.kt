package algorithms.easy

/**
 *
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 *
 * Output: true
 *
 * Explanation:
 *
 * The element 1 occurs at the indices 0 and 3.
 * */

// O(n)
fun containsDuplicate(nums: IntArray): Boolean {
    val tempHashSet = hashSetOf<Int>()
    nums.forEach {
        tempHashSet.add(it)
    }

    return tempHashSet.size != nums.size
}

// O(n log n)
fun containsDuplicateWithSorting(nums: IntArray): Boolean {
    nums.sort()
    for (i in 0 until nums.size - 1) {
        if (nums[i] == nums[i + 1]) {
            return true
        }
    }
    return false
}


fun main() {
    println("With Set")
    println(containsDuplicate(intArrayOf(1,2,3,1)))
    println(containsDuplicate(intArrayOf(2,3,1)))
    println(containsDuplicate(intArrayOf(2,3,1,1)))
    println(containsDuplicate(intArrayOf(2,2,3,1,1)))

    println("With Sorting")
    println(containsDuplicateWithSorting(intArrayOf(1,2,3,1)))
    println(containsDuplicateWithSorting(intArrayOf(2,3,1)))
    println(containsDuplicateWithSorting(intArrayOf(2,3,1,1)))
    println(containsDuplicateWithSorting(intArrayOf(2,14,18,22,22)))
}