class Solution {
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

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder ans = new StringBuilder();
        for (String s : dictionary) {
            insert(s);
        }

        String[] words = sentence.split(" ");

        for (String word : words) {
            Node curr = root;
            String replacement = word;

            for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                break;
            }
            curr = curr.children[idx];
            if(curr.eow==true){
                replacement= word.substring(0,i+1);
                break;
                }
            }  
            if(ans.length()>0){
                ans.append(" ");
            } 
            ans.append(replacement);
        }
        return ans.toString();
    }
}