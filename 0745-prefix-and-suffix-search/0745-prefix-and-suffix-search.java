class WordFilter {
    class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        ArrayList<Integer> indexes = new ArrayList<>();

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    Node prefixRoot = new Node();
    Node suffixRoot = new Node();

    public void insertSuffix(String word, int index) {
        Node curr = suffixRoot;
        for (int i = word.length() - 1; i >= 0; i--) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
            curr.indexes.add(index);
        }
        curr.eow = true;
    }

    // public void createTreeSuffix(String[] words) {
    //     for (int i = words.length - 1; i >= 0; i--) {
    //         insertSuffix(words[i]);
    //     }
    // }

    //------------------------------------------------------

    public ArrayList<Integer> searchSuffix(String sb) {
        Node curr = suffixRoot;
        for (int i = sb.length() - 1; i >= 0; i--) {
            int idx = sb.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return new ArrayList<>();
            }
            curr = curr.children[idx];
        }
        return curr.indexes;
    }

    public void insertPrefix(String word,int index) {
        Node curr = prefixRoot;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
            curr.indexes.add(index);
        }
        curr.eow = true;
    }

    // public void createTreePrefix(String[] words) {
    //     for (int i = 0; i < words.length; i++) {
    //         insertPrefix(words[i]);
    //     }
    // }

    public ArrayList<Integer> searchPrefix(String sb) {
        Node curr = prefixRoot;
        for (int i = 0; i < sb.length(); i++) {
            int idx = sb.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return new ArrayList<>();
            }
            curr = curr.children[idx];
        }
        return curr.indexes;
    }

    

    public WordFilter(String[] words) {
        
        for (int i = 0; i < words.length; i++) {
            insertPrefix(words[i], i);
            insertSuffix(words[i], i);
        }
    }

    public int f(String pref, String suff) {

        ArrayList<Integer> prefixList = searchPrefix(pref);
        ArrayList<Integer> suffixList = searchSuffix(suff);
        int i = prefixList.size() - 1;
        int j = suffixList.size() - 1;

        // Both lists are already sorted by index
        while (i >= 0 && j >= 0) {

            if (prefixList.get(i).equals(suffixList.get(j))) {
                return prefixList.get(i);
            }

            if (prefixList.get(i) > suffixList.get(j)) {
                i--;
            } else {
                j--;
            }
        }

        return -1;
    }


}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */