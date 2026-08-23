class Solution {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        String word = null;
    }

    Node root = new Node();
    List<String> ans = new ArrayList<>();

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {

            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
        curr.word = word;
    }

    public void dfs(char[][] board, int i, int j, Node curr) {

        // Boundary check
        if (i < 0 || i >= board.length ||
                j < 0 || j >= board[0].length) {
            return;
        }

        // Already visited
        if (board[i][j] == '#') {
            return;
        }

        char ch = board[i][j];
        int idx = ch - 'a';

        if (curr.children[idx] == null) {
            return;
        }
        curr = curr.children[idx];

        // Complete word found
        if (curr.eow) {

            ans.add(curr.word);

            // Prevent duplicate answer
            curr.eow = false;
        }

        // Mark current cell visited
        board[i][j] = '#';

        // 4 neighbours

        // UP
        dfs(board, i - 1, j, curr);

        // DOWN
        dfs(board, i + 1, j, curr);

        // LEFT
        dfs(board, i, j - 1, curr);

        // RIGHT
        dfs(board, i, j + 1, curr);

        board[i][j] = ch;
    }

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root);
            }
        }

        return ans;
    }
}