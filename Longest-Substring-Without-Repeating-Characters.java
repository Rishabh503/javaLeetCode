class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        HashSet<Character> set=new HashSet<>();
        int i=0;
        int j=0;
        int maxi=1;
        while(j<s.length()){
            char ch=s.charAt(j);
            while(set.contains(ch)){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(ch);
            maxi=Math.max(maxi,j-i+1);
            j++;
        }
        return maxi;
    }
}