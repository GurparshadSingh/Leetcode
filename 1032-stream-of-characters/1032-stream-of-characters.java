class StreamChecker {
    class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    StringBuilder sb = new StringBuilder();
    Node root = new Node();

    public void insert(String word) {
        Node curr = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public void createTree(String[] words) {
        for (int i = words.length - 1; i >= 0; i--) {
            insert(words[i]);
        }
    }

    public StreamChecker(String[] words) {
        createTree(words);
    }

    public boolean query(char letter) {
        sb.append(letter);

        Node curr = root;
        for (int i = sb.length() - 1; i >= 0; i--) {
            int idx = sb.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
            if (curr.eow) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */