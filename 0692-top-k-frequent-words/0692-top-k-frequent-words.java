import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.getValue() == b.getValue()){
                        return a.getKey().compareTo(b.getKey());
                    }
                        return b.getValue() - a.getValue();
                });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        List<String> ans = new ArrayList<>();
        for (int j = 0; j < k; j++) {
            ans.add(pq.poll().getKey());
        }
        return ans;
    }
}