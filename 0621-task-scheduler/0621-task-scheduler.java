class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Collections.reverseOrder());

        pq.addAll(map.values());

        int count = 0;
        int cycle = n + 1;
        while (!pq.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int used = 0;
            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    int freq = pq.poll();
                    freq--;
                    if (freq > 0) {
                        temp.add(freq);
                    }
                    used++;
                }
            }
            // Tasks become available again
            for (int freq : temp) {
                pq.offer(freq);
            }
            if (!pq.isEmpty()) {
                count += cycle;
            } else {
                count += used;
            }

        }
        return count;
    }
}