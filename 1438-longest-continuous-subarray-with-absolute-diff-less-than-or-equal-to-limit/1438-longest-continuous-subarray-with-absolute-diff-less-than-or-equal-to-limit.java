class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            //maintain maxDeque
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            //maintain minDeque
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            //curr window bn gyi uske min and max mil gye ab invalid hai toh move left kyuki aur badhane se faida nhi ab
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                 // Remove right element if it is the maximum
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}