package com.acargil.leetcode.blind75.array;

import org.junit.jupiter.api.Assertions;

public class FindMin {

  public static void main(String[] args) {
    FindMin.Solution solution = new FindMin().new Solution();
    int result = solution.findMin(new int[]{3, 4, 5, 1, 2});
    Assertions.assertEquals(1, result, "3,4,5,1,2");
    result = solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
    Assertions.assertEquals(0, result, "4,5,6,7,0,1,2");
    result = solution.findMin(new int[]{11, 13, 15, 17});
    Assertions.assertEquals(11, result, "11,13,15,17");
  }

  class Solution {

    public int findMin(int[] nums) {
      int start = 0, end = nums.length;
      while (start < end) {
        int mid = (end + start) / 2;
        if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
          return nums[mid + 1];
        } else if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
          return nums[mid];
        }
        if (nums[start] > nums[mid]) {
          end = mid;
        } else if (nums[mid] > nums[end - 1]) {
          start = mid;
        } else {
          break;
        }
      }
      return nums[0];
    }
  }
}
