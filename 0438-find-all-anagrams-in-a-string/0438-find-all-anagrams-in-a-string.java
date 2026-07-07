class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        HashMap<Character, Integer> tarmap = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            tarmap.put(p.charAt(i), tarmap.getOrDefault(p.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = 0;

        while (j < s.length()) {
            window.put(s.charAt(j), window.getOrDefault(s.charAt(j), 0) + 1);

            if (j - i + 1 == p.length()) {
                if (window.equals(tarmap)) {
                    list.add(i);
                }

                window.put(s.charAt(i), window.get(s.charAt(i)) - 1);
                if (window.get(s.charAt(i)) == 0) {
                    window.remove(s.charAt(i));
                }
                i++;
            }
            j++;
        }
        return list;
    }
}