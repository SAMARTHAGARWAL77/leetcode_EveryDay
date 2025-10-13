class Solution {
    public List<String> removeAnagrams(String[] words) {
    List<String> res = new ArrayList<>();
    res.add(words[0]);
    for(int i = 1;i < words.length; i++)
    {
        String curr = words[i];
        String prev = res.get(res.size() - 1);
        if(!isAnagram(curr, prev))
        {
            res.add(curr);
        }
    }
    return res;        
    }
    private boolean isAnagram(String curr, String prev)
    {
        char []a = curr.toCharArray();
        char []b = prev.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }
}