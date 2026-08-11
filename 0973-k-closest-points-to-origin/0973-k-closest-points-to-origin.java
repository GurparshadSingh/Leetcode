class Solution {
    class Point {
        int x, y;
        int dis;

        Point(int x,int y) {
            this.x=x;
            this.y=y;
            this.dis=x*x +y*y;
        }
    }

        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<Point> pq = new PriorityQueue<>(
                    (a, b) -> {
                        return a.dis - b.dis;
                    });

            for (int i = 0; i < points.length; i++) {
                pq.offer(new Point(points[i][0], points[i][1]));
            }

            int[][] ans = new int[k][2];

            int i = 0;
            while (!pq.isEmpty() && i < k) {
                Point p = pq.poll();
                ans[i][0] = p.x;
                ans[i][1] = p.y;
                i++;
            }
            return ans;
        }
}