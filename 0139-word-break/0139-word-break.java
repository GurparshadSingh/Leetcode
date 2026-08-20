class Solution {
    Boolean[] memo;

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

    public void addWord(String word) {
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

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    public boolean wordBreak(String word) {
        if (word.length() == 0) {
            return true;
        }
        if (memo[word.length()] != null) {
            return memo[word.length()];
        }
        for (int i = 1; i <= word.length(); i++) {
            if (search(word.substring(0, i)) && wordBreak(word.substring(i))) {
                memo[word.length()] = true;
                return true;
            }
        }
        memo[word.length()] = false;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Node();
        memo = new Boolean[s.length() + 1];
        for (int i = 0; i < wordDict.size(); i++) {
            addWord(wordDict.get(i));
        }
        return wordBreak(s);

    }
}