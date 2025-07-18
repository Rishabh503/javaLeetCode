class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> jewel=new HashSet<>();
        for(int i=0;i<jewels.length();i++){
            jewel.add(jewels.charAt(i));
        }
        int ans=0;
        for(int i=0;i<stones.length();i++){
            if(jewel.contains(stones.charAt(i))) ans++;
        }
        return ans;
    }
}