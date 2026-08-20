class WordDictionary {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    static Node root;

    public WordDictionary() {
        root = new Node();
    }

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
        return searchHelper(word, curr, 0);
    }

    public boolean searchHelper(String word, Node curr, int index) {
        if (index == word.length()) {
            return curr.eow;
        }

        char ch = word.charAt(index);

        if (ch != '.') {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            return searchHelper(word, curr.children[idx], index + 1);
        }

        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                if (searchHelper(word,curr.children[i],index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */