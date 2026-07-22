class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<List<Integer>, List<String>> map = new HashMap();
        for (String s : strs) {
            int[] countArr = new int[26];
            for (int i = 0; i < s.length(); i++) {
                countArr[s.charAt(i) - 'a']++;
            }
            List<Integer> count = Arrays.stream(countArr).boxed().collect(Collectors.toList());
            if (map.containsKey(count)) {
                map.get(count).add(s);
            } else {
                List<String> g = new ArrayList();
                g.add(s);
                map.put(count, g);
            }
        }
        List<List<String>> groups = new ArrayList<>(map.values());
        return groups;
    }
}
