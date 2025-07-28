class Solution {
    public int characterReplacement(String s, int k) {
        // ek lee lelete he freq array fro all th euppercase chars
        int freq[]=new int[26];
        int maxf=0;int maxlen=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            // freq update 
            freq[ch-'A']++;
            maxf=Math.max(maxf,freq[ch-'A']);

            // now shrinking phase when 
            while(right-left+1-maxf>k){
                 freq[s.charAt(left)-'A']--;
                 left++;
            }
            maxlen=Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}