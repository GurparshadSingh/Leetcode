class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b)->{
                return b.getValue() - a.getValue();
            }
        );

        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.offer(entry);
        }

        int ans[] = new int[k];
        for(int i = 0;i<ans.length;i++){
            ans[i]=pq.poll().getKey();
        }
        return ans;
    }
}