package algorithms.easy

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 *
 * Output: 1
 *
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2] 1 1 2 2 4
 *
 * Output: 4
 *
 * */

// O(n log n) Space: O(1)
fun singleNumber(nums: IntArray): Int {
    nums.sort()

    var i = 0
    while (i < nums.size - 1) {
        if (nums[i] == nums[i + 1]) {
            i += 2
        } else {
            return nums[i]
        }
    }
    return nums.last()
}


/**
 *
 * If the two inputs are the same at the XOR bit level, it returns 0; if they are different, it returns 1.
 * for example: 0 xor 0 = 0 , 1 xor 0 = 1
 *
 * for example binary numbers:
 * 101 (5)
 * 010 (2)
 * --- XOR
 * 111 = 7 (2^2 + 2^1 + 2^0)
 *
 * another example:
 *
 * 110 (6)
 * 010 (2)
 * ------
 * 100 = 4
 *
 * or:
 *
 * 110 (6)
 * 110 (6)
 * ------
 * 000 = 0
 *
 * As a result, numbers that are the same after the XOR operation cancel each other out.
 * This solution knows as Bit Manipulation
 * */

// O(n) Space: O(1)
fun singleNumberXor(nums: IntArray): Int {
    var result = 0

    for (num in nums) {
        result = result xor num
    }
    return result
}

fun main() {
    println("singleNumber with sorting")
    println(singleNumber(intArrayOf(4,1,2,1,2)))

    println("singleNumber with XOR")
    println(singleNumberXor(intArrayOf(4,1,2,1,2)))

}