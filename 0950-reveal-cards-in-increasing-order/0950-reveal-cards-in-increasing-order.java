class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int n = deck.length;
        int ans[] = new int[n];

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            q.offer(i);
        }

        for (int each : deck) {
            int idx = q.poll();
            ans[idx] = each;
            if (!q.isEmpty()) {
                q.offer(q.poll());
            }

        }
        return ans;

    }
}