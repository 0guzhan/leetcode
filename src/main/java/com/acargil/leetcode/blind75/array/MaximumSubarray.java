package com.acargil.leetcode.blind75.array;

import org.junit.jupiter.api.Assertions;

public class MaximumSubarray {

  public static void main(String[] args) {
    Solution solution = new MaximumSubarray().new Solution();
    int result = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    Assertions.assertEquals(6, result);
    result = solution.maxSubArray(new int[]{-2, -1});
    Assertions.assertEquals(-1, result);
    result = solution.maxSubArray(new int[]{-1});
    Assertions.assertEquals(-1, result);
  }

  public class Solution {

    public int maxSubArray(int[] nums) {
      int sum = 0;
      int maxSum = Integer.MIN_VALUE;
      for (int num : nums) {
        if (sum < 0 && num > sum) {
          sum = num;
        } else {
          sum += num;
        }
        if (sum > maxSum) {
          maxSum = sum;
        }
      }
      return maxSum;
    }
  }
}
