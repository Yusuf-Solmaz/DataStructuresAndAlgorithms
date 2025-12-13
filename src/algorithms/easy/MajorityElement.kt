package algorithms.easy

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * */

// Time: O(n) Space: O(n)
fun majorityElement(nums: IntArray): Int {

    val temp = HashMap<Int,Int>()
    var maxCount = 0
    var result = 0

    nums.forEach { num ->
        temp[num] = temp.getOrDefault(num, 0) + 1
    }

    temp.forEach { (key, count) ->
        if (count > maxCount) {
            maxCount = count
            result = key
        }
    }
    return result
}

/**
 * Boyer–Moore Majority Vote Algorithm
 *
 * This algorithm finds the majority element (the element that appears more than n/2 times)
 * in O(n) time and O(1) extra space.
 *
 * The idea is based on a voting mechanism:
 * - Maintain a candidate and a counter.
 * - When the counter reaches zero, choose the current element as the new candidate.
 * - Increment the counter if the current element matches the candidate,
 *   otherwise decrement it.
 *
 * Since the majority element appears more than all other elements combined,
 * it will remain as the final candidate after all cancellations.
 *
 * Note: This solution assumes that a majority element always exists.
 */
// Time: O(n) Space: O(1)
fun majorityElementByBoyerMoore(nums: IntArray): Int {
    var candidate = 0
    var count = 0

    for (num in nums) {
        if (count == 0) {
            candidate = num
        }
        count += if (num == candidate) 1 else -1
    }
    return candidate
}


fun main(){
    println(majorityElement(intArrayOf(2,2,1,1,1,2,2,1,1)))
    println(majorityElementByBoyerMoore(intArrayOf(2,2,1,1,1,2,2,1,1)))
}