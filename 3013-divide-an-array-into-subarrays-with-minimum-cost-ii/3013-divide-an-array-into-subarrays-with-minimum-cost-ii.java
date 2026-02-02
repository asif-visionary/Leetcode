import java.util.*;

class Solution {
    // Stores the smallest (k-1) elements in the current window
    private TreeSet<int[]> small = new TreeSet<>((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
    // Stores the remaining elements in the current window
    private TreeSet<int[]> large = new TreeSet<>((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
    private long currentSmallSum = 0;

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        int m = k - 1; // Number of starting indices we need to pick (excluding nums[0])
        
        // Reset state for multiple test cases
        small.clear();
        large.clear();
        currentSmallSum = 0;

        // 1. Initialize the first window: indices [1, dist + 1]
        for (int i = 1; i <= dist + 1; i++) {
            add(new int[]{nums[i], i}, m);
        }

        long minCost = nums[0] + currentSmallSum;

        // 2. Slide the window from index 1 to n-1
        // The window spans from 'i - dist' to 'i'. 
        // We remove the element that is now outside: nums[i - dist]
        for (int i = dist + 2; i < n; i++) {
            remove(new int[]{nums[i - dist - 1], i - dist - 1}, m);
            add(new int[]{nums[i], i}, m);
            minCost = Math.min(minCost, nums[0] + currentSmallSum);
        }

        return minCost;
    }

    private void add(int[] val, int m) {
        small.add(val);
        currentSmallSum += val[0];
        
        // If small exceeds capacity m, move the largest to large
        if (small.size() > m) {
            int[] top = small.pollLast();
            currentSmallSum -= top[0];
            large.add(top);
        }
    }

    private void remove(int[] val, int m) {
        if (small.contains(val)) {
            small.remove(val);
            currentSmallSum -= val[0];
            // Refill small from large to keep it at size m if possible
            if (!large.isEmpty()) {
                int[] nextSmallest = large.pollFirst();
                currentSmallSum += nextSmallest[0];
                small.add(nextSmallest);
            }
        } else {
            large.remove(val);
        }
    }
}