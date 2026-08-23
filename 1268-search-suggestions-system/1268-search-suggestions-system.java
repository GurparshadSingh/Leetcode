class Solution {
    class Node {
        Node children[] = new Node[26];
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

    public ArrayList<String> search(String word) {
        Node curr = root;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return list;
            }
            curr = curr.children[idx];
        }
        helper(curr, word, list);
        return list;
    }

    public void helper(Node curr, String word, ArrayList<String> list) {
        if (curr.eow == true) {
            list.add(word);
        }

        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                char ch = (char) (i + 'a');
                helper(curr.children[i], word + ch, list);
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new Node();
        for (String word : products) {
            insert(word);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {

            String prefix = searchWord.substring(0, i);

            ArrayList<String> list = search(prefix);

            // list mein se smallest 3
            List<String> temp = new ArrayList<>();

            for (int j = 0; j < Math.min(3, list.size()); j++) {
                temp.add(list.get(j));
            }
            ans.add(temp);
        }
        return ans;

    }
}