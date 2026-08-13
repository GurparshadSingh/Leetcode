class Solution {
    static class Node {
        int val;
        int row;
        int col;

        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int currentMax = Integer.MIN_VALUE;

        // Put first element of every list into PQ
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            pq.offer(new Node(value, i, 0));
            currentMax = Math.max(currentMax, value);
        }
        int start = 0;
        int end = Integer.MAX_VALUE;
        while (pq.size() == nums.size()) {
            Node minNode = pq.poll();
            int currentMin = minNode.val;

            // Update answer
            if (currentMax - currentMin < end - start) {
                start = currentMin;
                end = currentMax;
            }

            if (minNode.col + 1 < nums.get(minNode.row).size()) {
                int next = nums.get(minNode.row).get(minNode.col + 1);
                pq.offer(new Node(next,
                        minNode.row,
                        minNode.col + 1));
                currentMax = Math.max(currentMax, next);
            } else {
                break;
            }
        }
        return new int[]{start,end};
    }
}