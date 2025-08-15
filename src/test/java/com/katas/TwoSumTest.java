package com.katas;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTest {
    
    private final TwoSum twoSum = new TwoSum();
    
    @Test
    void shouldReturnIndicesForBasicCase() {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum.twoSum(nums, 9);
        assertThat(result).containsExactlyInAnyOrder(0, 1);
    }
    
    @Test
    void shouldReturnIndicesForSecondCase() {
        int[] nums = {3, 2, 4};
        int[] result = twoSum.twoSum(nums, 6);
        assertThat(result).containsExactlyInAnyOrder(1, 2);
    }
    
    @Test
    void shouldHandleDuplicateNumbers() {
        int[] nums = {3, 3};
        int[] result = twoSum.twoSum(nums, 6);
        assertThat(result).containsExactlyInAnyOrder(0, 1);
    }
    
    @Test
    void shouldHandleNegativeNumbers() {
        int[] nums = {-1, -2, -3, -4, -5};
        int[] result = twoSum.twoSum(nums, -8);
        assertThat(result).containsExactlyInAnyOrder(2, 4);
    }
    
    @Test
    void shouldHandleMixedPositiveAndNegative() {
        int[] nums = {-3, 4, 3, 90};
        int[] result = twoSum.twoSum(nums, 0);
        assertThat(result).containsExactlyInAnyOrder(0, 2);
    }
    
    @Test
    void shouldWorkWithBruteForceApproach() {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum.twoSumBruteForce(nums, 9);
        assertThat(result).containsExactlyInAnyOrder(0, 1);
    }
    
    @Test
    void shouldWorkWithOptimizedApproach() {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum.twoSumOptimized(nums, 9);
        assertThat(result).containsExactlyInAnyOrder(0, 1);
    }
    
    @Test
    void shouldHandleLargerArray() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = twoSum.twoSum(nums, 17);
        assertThat(result).containsExactlyInAnyOrder(6, 9); // 7 + 10 = 17
    }
}
