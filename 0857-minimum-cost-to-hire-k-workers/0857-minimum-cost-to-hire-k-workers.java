class Solution {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workers = new double[n][2];

        for (int i = 0; i < workers.length; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = quality[i];
        }

        
        Arrays.sort(workers, (a, b) ->
            Double.compare(a[0], b[0])
        );

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int sumQuality = 0;
        double ans = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int q = (int) workers[i][1];
            sumQuality += q;

            double currentRatio = workers[i][0];
            maxHeap.offer(q);

            if (maxHeap.size() > k) {
                sumQuality -= maxHeap.poll();
            }

            // Exactly k workers
            if (maxHeap.size() == k) {
                double cost = currentRatio * sumQuality;
                ans = Math.min(ans, cost);
            }
        }
        return ans;
    }
}