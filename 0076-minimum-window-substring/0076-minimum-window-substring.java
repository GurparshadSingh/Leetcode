class Solution {
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> target = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        }
        int have = 0;
        int need = target.size();

        int minLen = Integer.MAX_VALUE;
        String ans = "";

        int l = 0;
        int r = 0;
        while (r < s.length()) {
            if (target.containsKey(s.charAt(r))) {
                window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0) + 1);
                if (window.get(s.charAt(r)).equals(target.get(s.charAt(r)))) {
                    have++;
                }
            }

            while (have == need) {
                int currLen = r - l + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    ans = s.substring(l, r + 1);
                }

                char ch = s.charAt(l);
                if (target.containsKey(ch)) {
                    window.put(ch, window.get(ch) - 1);

                    if (window.get(ch) < target.get(ch)) {
                        have--;
                    }
                }

                l++;
            }
            r++;
        }
        return ans;
    }
}