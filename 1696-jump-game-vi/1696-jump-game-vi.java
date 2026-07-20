class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;

        int score[] = new int[n];
        score[0] = nums[0];

        Deque<Integer> dq = new ArrayDeque<>();
         dq.offerLast(0);

        for(int i = 1;i<n;i++){
            while(!dq.isEmpty() && dq.peekFirst()<i-k){
                dq.pollFirst();
            }

            score[i] = score[dq.peekFirst()]+nums[i];

            while(!dq.isEmpty() && score[dq.peekLast()]<=score[i]){
                dq.pollLast();
            }

             dq.offerLast(i);
        }
        return score[n-1];
    }
}