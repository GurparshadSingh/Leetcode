class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            char curr = senate.charAt(i);
            if (curr == 'R') {
                q1.offer(i);
            } else {
                q2.offer(i);
            }
        }
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int r = q1.poll();
            int d = q2.poll();

            if (r < d) {
                // q2.poll();
                q1.offer(r + senate.length());
            } else {
                // q1.poll();
                q2.offer(d + senate.length());
            }
        }
        return q1.isEmpty() ? "Dire" : "Radiant";
    }
}