package com.acargil.leetcode.blind75.array;

import org.junit.jupiter.api.Assertions;

public class MaximumProductSubarray {

  public static void main(String[] args) {
    Solution solution = new MaximumProductSubarray().new Solution();
    int result = solution.maxProduct(new int[]{2, 3, -2, 4});
    Assertions.assertEquals(6, result, "2, 3, -2, 4");
    result = solution.maxProduct(new int[]{-2, 0, -1});
    Assertions.assertEquals(0, result, "-2, 0, -1");
    result = solution.maxProduct(new int[]{2, 3, -2, 4, 2});
    Assertions.assertEquals(8, result);
    result = solution.maxProduct(new int[]{1, 2, 3, 4});
    Assertions.assertEquals(24, result);
    result = solution.maxProduct(new int[]{-1, 2, 3, 4});
    Assertions.assertEquals(24, result);
    result = solution.maxProduct(new int[]{-1, 2, 3, -4});
    Assertions.assertEquals(24, result);
    result = solution.maxProduct(new int[]{-1, 2, 0, 3, -4});
    Assertions.assertEquals(3, result);
  }

  public class Solution {

    public int maxProduct(int[] nums) {
      int maxProduct = Integer.MIN_VALUE;
      int product = 1;
      int firstNegativeIndex = -1;
      int lastNegativeIndex = -1;
      int negativeCount = 0;
      int startInclusive = 0;
      int endExclusive = 0;

      for (int i = 0; i < nums.length; i++) {
        maxProduct = Math.max(nums[i], maxProduct);

        if (nums[i] == 0) {
          if (endExclusive - startInclusive > 1) {
            if (negativeCount % 2 != 0) {
              product = maxProduct(nums, startInclusive, endExclusive, firstNegativeIndex,
                  lastNegativeIndex, product);
            }
            maxProduct = Math.max(product, maxProduct);
          }

          product = 1;
          startInclusive = i + 1;
          endExclusive = startInclusive;
          firstNegativeIndex = -1;
          lastNegativeIndex = -1;
          negativeCount = 0;
        } else if (nums[i] > 0) {
          product = product * nums[i];
          endExclusive++;
        } else {
          product = product * nums[i];
          endExclusive++;
          if (firstNegativeIndex == -1) {
            firstNegativeIndex = i;
          }
          lastNegativeIndex = i;
          negativeCount++;
        }
      }
      if (endExclusive - startInclusive > 1) {
        if (negativeCount % 2 != 0) {
          product = maxProduct(nums, startInclusive, endExclusive, firstNegativeIndex,
              lastNegativeIndex, product);
        }
        maxProduct = Math.max(product, maxProduct);
      }

      return maxProduct;
    }

    private int maxProduct(int[] nums, int startInclusive, int endExclusive,
        int firstNegativeIndex, int lastNegativeIndex, int product) {

      if (firstNegativeIndex == lastNegativeIndex) {
        if (startInclusive == firstNegativeIndex || endExclusive - 1 == firstNegativeIndex) {
          return product / nums[firstNegativeIndex];
        } else if ((firstNegativeIndex - startInclusive) < (endExclusive - firstNegativeIndex)) {
          int rightProduct = product;
          for (int i = startInclusive; i <= firstNegativeIndex; i++) {
            rightProduct = rightProduct / nums[i];
          }
          return Math.max(rightProduct, (product / rightProduct) / nums[firstNegativeIndex]);
        } else {
          int leftProduct = product;
          for (int i = endExclusive - 1; i >= firstNegativeIndex; i--) {
            leftProduct = leftProduct / nums[i];
          }
          return Math.max(leftProduct, (product / leftProduct) / nums[firstNegativeIndex]);
        }
      } else {
        int left = 1, right = 1;
        for (int i = endExclusive - 1; i >= lastNegativeIndex; i--) {
          right = right * nums[i];
        }
        int maxProduct1 = Math.max(product / right, right / nums[lastNegativeIndex]);
        for (int i = startInclusive; i <= firstNegativeIndex; i++) {
          left = left * nums[i];
        }
        int maxProduct2 = Math.max(product / left, left / nums[firstNegativeIndex]);
        return Math.max(maxProduct1, maxProduct2);
      }
    }
  }
}
