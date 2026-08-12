class Solution {
    class Pair {
        int val;
        int x;
        int y;

        Pair(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> {
                    return a.val - b.val;
                });

        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new Pair(matrix[i][0], i, 0));
        }
        ArrayList<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (curr.y < matrix[0].length-1) {
                pq.offer(new Pair(matrix[curr.x][curr.y + 1], curr.x, curr.y + 1));
            }

            ans.add(curr.val);
        }
        return ans.get(k - 1);
    }
}