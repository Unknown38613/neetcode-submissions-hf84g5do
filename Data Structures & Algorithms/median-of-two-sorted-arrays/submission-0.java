class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to keep binary search range minimal
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2; // size of left partition

        int lo = 0, hi = m;
        while (lo <= hi) {
            int i = lo + (hi - lo) / 2; // cut in nums1
            int j = totalLeft - i;      // cut in nums2

            int L1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int R1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int L2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int R2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (L1 <= R2 && L2 <= R1) {
                // Correct partition found
                if (((m + n) % 2) == 1) {
                    return Math.max(L1, L2); // odd length
                } else {
                    int leftMax = Math.max(L1, L2);
                    int rightMin = Math.min(R1, R2);
                    return (leftMax + rightMin) / 2.0; // even length
                }
            } else if (L1 > R2) {
                // We have taken too many from nums1, move left
                hi = i - 1;
            } else {
                // We have taken too few from nums1, move right
                lo = i + 1;
            }
        }
        return -1.0;
    }
}