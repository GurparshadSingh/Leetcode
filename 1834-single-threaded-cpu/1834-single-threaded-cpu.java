class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] arr = new int[n][3];

        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] != b[0])
                        return a[0] - b[0];

                    return a[1] - b[1];
                });
        int[] ans = new int[arr.length];
        long time = 0;
        int i = 0;
        int k = 0;
        while (!pq.isEmpty() || i < n) {
            if (pq.isEmpty()) {
                time = Math.max(time, arr[i][0]);
            }

            while (i < n && arr[i][0] <= time) {
                pq.offer(new int[] { arr[i][1], arr[i][2] });
                i++;
            }

            int[] task = pq.poll();
            ans[k++] = task[1];
            time += task[0];
        }
        return ans;
    }
}