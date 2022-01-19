package Problems.StringAndArrayManipulation;

import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * You can return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer comp = target - nums[i];
            if (map.containsKey(comp)) {
                return (new int[] { i, map.get(comp) });
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

    public void run() {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(twoSum(nums, target)[0]);
        System.out.println(twoSum(nums, target)[1]);
    }
}
