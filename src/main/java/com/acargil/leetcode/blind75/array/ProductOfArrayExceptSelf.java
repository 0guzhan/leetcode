package com.acargil.leetcode.blind75.array;

import org.junit.jupiter.api.Assertions;

public class ProductOfArrayExceptSelf {

  public static void main(String[] args) {
    ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
    ProductOfArrayExceptSelf.Solution solution = productOfArrayExceptSelf.new Solution();
    int[] result = solution.productExceptSelf(new int[]{1, 2, 3, 4});
    Assertions.assertArrayEquals(result, new int[]{24, 12, 8, 6});
    result = solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3});
    Assertions.assertArrayEquals(result, new int[]{0, 0, 9, 0, 0});
  }

  class Solution {

    public int[] productExceptSelf(int[] nums) {
      int product = 1;
      int indexOfZero = -1;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
          if (indexOfZero == -1) {
            indexOfZero = i;
          } else {
            // return array of zeroes when there are multiple zeroes
            return new int[nums.length];
          }
        } else {
          product = product * nums[i];
        }
      }

      for (int i = 0; i < nums.length; i++) {
        if (indexOfZero != -1) {
          if (i == indexOfZero) {
            nums[i] = product;
          } else {
            nums[i] = 0;
          }
        } else {
          nums[i] = product / nums[i];
        }
      }
      return nums;
    }
  }
}
