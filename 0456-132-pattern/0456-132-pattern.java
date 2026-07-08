class Solution {
    public boolean find132pattern(int[] nums) {

        Stack<Integer> st = new Stack<>();

        int second = Integer.MIN_VALUE; // k (middle)

        for (int i = nums.length - 1; i >= 0; i--) {

            // nums[i] = i (small)
            if (nums[i] < second) {
                return true;
            }

            // find a bigger element and make popped values k
            while (!st.isEmpty() && nums[i] > st.peek()) {
                second = st.pop();
            }

            // nums[i] can be future j
            st.push(nums[i]);
        }

        return false;
    }
}