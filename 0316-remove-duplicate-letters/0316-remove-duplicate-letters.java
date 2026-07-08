class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        boolean[] vis = new boolean[26];
        int[] lastOcc = new int[26];

        for(int i = 0;i<s.length();i++){
            char curr = s.charAt(i);
            lastOcc[curr-'a'] = i;
        }

        for(int i = 0;i<s.length();i++){
            char curr = s.charAt(i);
            if(vis[curr-'a']){
                continue;
            }
            while(!st.isEmpty() && st.peek()>curr && lastOcc[st.peek() - 'a'] > i){
                
                vis[st.pop() - 'a'] = false;
            }
            st.push(curr);
            vis[curr - 'a'] = true;
        }
       StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}