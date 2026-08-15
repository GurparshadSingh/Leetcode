class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    return b[1] - a[1];
                });

        // Map -> PQ
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new int[] { entry.getKey(), entry.getValue() });
        }

        StringBuilder ans = new StringBuilder();
        Queue<int[]> q = new LinkedList<>();

        while (!pq.isEmpty()) {
            int curr[] = pq.poll();

            char ch = (char) curr[0];
            int freq = curr[1];

            ans.append(ch);
            freq--;

            // Put it into cooldown queue
            q.offer(new int[] { ch, freq });

            if (q.size() >= 2) {
                int front[] = q.poll();
                if (front[1] > 0) {
                    pq.offer(front);
                }
            }
        }
        if (ans.length() != s.length()) {
            return "";
        }
        return ans.toString();
    }
}