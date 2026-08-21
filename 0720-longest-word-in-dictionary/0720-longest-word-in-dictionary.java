class Solution {
    static String ans = "";

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    Node root = new Node();

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
    }

    public void help(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');
            if (root.children[i] != null && root.children[i].eow == true) {
                temp.append(ch);
                if (ans.length() < temp.length()) {
                    ans = temp.toString();
                }
                help(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public String longestWord(String[] words) {
        ans = "";
        for (String word : words) {
            insert(word);
        }
        help(root, new StringBuilder());
        return ans;
    }
}