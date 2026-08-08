class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: nums){
            minHeap.offer(num);
        }
        int curr = 0;
        while(k>0){
            curr = minHeap.poll();
            k-=1;
        }
        return curr;
    }
}