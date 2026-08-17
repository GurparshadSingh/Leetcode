class Solution {
    public class MedianFinder {
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        HashMap<Integer, Integer> delayed = new HashMap<>();
        int leftSize = 0;
        int rightSize = 0;
        int k;

        MedianFinder(int k) {
            this.k = k;
        }

        public void addNum(int num) {
            if (left.isEmpty() || num <= left.peek()) {
                left.offer(num);
                leftSize++;
            } else {
                right.offer(num);
                rightSize++;
            }
            rebalance();
        }

        public void removeNum(int num) {

            // Mark as deleted
            delayed.put(
                    num,
                    delayed.getOrDefault(num, 0) + 1);

            // Decide which logical heap contains it
            if (num <= left.peek()) {

                leftSize--;

                // If it is currently at the top,
                // remove it immediately
                if (num == left.peek()) {
                    prune(left);
                }

            } else {

                rightSize--;

                if (!right.isEmpty() && num == right.peek()) {
                    prune(right);
                }
            }

            rebalance();
        }

        public void prune(PriorityQueue<Integer> pq) {

            while (!pq.isEmpty() && delayed.containsKey(pq.peek())) {

                int num = pq.poll();
                delayed.put(num, delayed.get(num) - 1);

                if (delayed.get(num) == 0) {
                    delayed.remove(num);
                }
            }
        }

        // MAINTAIN:
        // leftSize == rightSize
        // OR
        // leftSize = rightSize + 1
        public void rebalance() {

            if (leftSize > rightSize + 1) {

                right.offer(left.poll());

                leftSize--;
                rightSize++;

                prune(left);

            } else if (leftSize < rightSize) {

                left.offer(right.poll());

                rightSize--;
                leftSize++;

                prune(right);
            }
        }

        public double findMedian() {

            if (k % 2 == 1) {
                return left.peek();
            }

            return ((double) left.peek() + right.peek()) / 2.0;
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        MedianFinder mf = new MedianFinder(k);

        // First window
        for (int i = 0; i < k; i++) {
            mf.addNum(nums[i]);
        }

        double[] ans = new double[nums.length - k + 1];
        ans[0] = mf.findMedian();
        // Slide window
        for (int i = k; i < nums.length; i++) {

            // New element enters
            mf.addNum(nums[i]);

            // Old element leaves
            mf.removeNum(nums[i - k]);

            // Median
            ans[i - k + 1] = mf.findMedian();
        }
        return ans;
    }

}