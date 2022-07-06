package com.acargil.leetcode.blind75.array;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public class TwoSum {

  public static void main(String[] args) {
    TwoSum twoSum = new TwoSum();
    Solution solution = twoSum.new Solution();
    int[] pair = solution.twoSum(new int[]{12, 24, 0, 17, 11, 15, -2}, 9);
    Assertions.assertNotNull(pair);
    Assertions.assertTrue((pair[0] == 4 && pair[1] == 6) || (pair[0] == 6 && pair[1] == 4));
  }

  class Solution {

    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> found = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        int other = target - num;
        if (found.containsKey(other)) {
          return new int[]{found.get(other), i};
        } else {
          found.put(num, i);
        }
      }
      return new int[]{};
    }
  }


}
