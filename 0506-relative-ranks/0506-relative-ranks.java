class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { i, score[i] });
        }

        int rank = 1;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int index = curr[0];

            if (rank == 1) {
                ans[index] = "Gold Medal";
            } else if (rank == 2) {
                ans[index] = "Silver Medal";
            } else if (rank == 3) {
                ans[index] = "Bronze Medal";
            } else {
                ans[index] = String.valueOf(rank);
            }

            rank++;
        }
        return ans;
    }
}