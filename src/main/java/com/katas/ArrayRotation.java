package com.katas;

/**
 * Array Rotation Kata
 * 
 * Problem Description:
 * Given an array and a number k, rotate the array to the right by k steps.
 * 
 * Examples:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * 
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -2^31 <= nums[i] <= 2^31 - 1
 * - 0 <= k <= 10^5
 * - Try to come up with as many solutions as you can
 * - Could you do it in-place with O(1) extra space?
 */
public class ArrayRotation {
    
    /**
     * Rotates the array to the right by k steps.
     * @param nums the array to rotate
     * @param k the number of steps to rotate
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;
        
        k = k % nums.length; // Handle k larger than array length
        if (k == 0) return;
        
        // Use array reversal technique for in-place rotation
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    /**
     * Alternative implementation using extra space.
     * @param nums the array to rotate
     * @param k the number of steps to rotate
     * @return new rotated array
     */
    public int[] rotateWithExtraSpace(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return nums.clone();
        
        k = k % nums.length;
        int[] result = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }
        
        return result;
    }
    
    /**
     * In-place rotation using array reversal technique.
     * @param nums the array to rotate
     * @param k the number of steps to rotate
     */
    public void rotateInPlace(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;
        
        k = k % nums.length;
        if (k == 0) return;
        
        // Same as the main rotate method - reversal technique
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
}
