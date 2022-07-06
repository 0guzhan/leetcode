package com.acargil.leetcode.blind75.array;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;

public class ContainsDuplicate {

  public static void main(String[] args) {
    ContainsDuplicate containsDuplicate = new ContainsDuplicate();
    ContainsDuplicate.Solution solution = containsDuplicate.new Solution();
    boolean contains = solution.containsDuplicate(new int[]{1, 2, 3, 1});
    Assertions.assertTrue(contains, "expected=true, actual=false");
    contains = solution.containsDuplicate(new int[]{1, 2, 3, 4});
    Assertions.assertFalse(contains, "expected=false, actual=true");
  }

  class Solution {

    static final int PRIME_FACTOR = 9973;

    public boolean containsDuplicate(int[] nums) {
      boolean[] bloemFilter = new boolean[PRIME_FACTOR];
      Set<Integer> found = new HashSet<>();
      for (int num : nums) {
        int bloemFilterIndex = num % PRIME_FACTOR;
        if (bloemFilterIndex < 0) {
          bloemFilterIndex = bloemFilterIndex + PRIME_FACTOR;
        }
        //bloemFilterIndex = bloemFilterIndex < 0 ? bloemFilterIndex + PRIME_FACTOR : bloemFilterIndex;
        if (!bloemFilter[bloemFilterIndex]) {
          bloemFilter[bloemFilterIndex] = true;
          found.add(num);
        } else if (!found.contains(num)) {
          found.add(num);
        } else {
          return true;
        }
      }
      return false;
    }
  }
}
