package com.katas;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ArrayRotationTest {
    
    private final ArrayRotation arrayRotation = new ArrayRotation();
    
    @Test
    void shouldRotateArrayByThreeSteps() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        arrayRotation.rotate(nums, 3);
        assertThat(nums).containsExactly(5, 6, 7, 1, 2, 3, 4);
    }
    
    @Test
    void shouldRotateArrayByTwoSteps() {
        int[] nums = {-1, -100, 3, 99};
        arrayRotation.rotate(nums, 2);
        assertThat(nums).containsExactly(3, 99, -1, -100);
    }
    
    @Test
    void shouldHandleRotationLargerThanArrayLength() {
        int[] nums = {1, 2, 3};
        arrayRotation.rotate(nums, 4); // 4 % 3 = 1, so rotate by 1
        assertThat(nums).containsExactly(3, 1, 2);
    }
    
    @Test
    void shouldHandleZeroRotation() {
        int[] nums = {1, 2, 3, 4};
        int[] original = nums.clone();
        arrayRotation.rotate(nums, 0);
        assertThat(nums).containsExactly(original);
    }
    
    @Test
    void shouldHandleSingleElementArray() {
        int[] nums = {1};
        arrayRotation.rotate(nums, 1);
        assertThat(nums).containsExactly(1);
    }
    
    @Test
    void shouldRotateWithExtraSpace() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] result = arrayRotation.rotateWithExtraSpace(nums, 3);
        assertThat(result).containsExactly(5, 6, 7, 1, 2, 3, 4);
        // Original array should remain unchanged
        assertThat(nums).containsExactly(1, 2, 3, 4, 5, 6, 7);
    }
    
    @Test
    void shouldRotateInPlace() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        arrayRotation.rotateInPlace(nums, 3);
        assertThat(nums).containsExactly(5, 6, 7, 1, 2, 3, 4);
    }
}
