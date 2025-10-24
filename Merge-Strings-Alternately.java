class Solution {
    public String mergeAlternately(String word1, String word2) {
        int w1=0;
        int w2=0;
        int e1=word1.length();
        int e2=word2.length();
        String ans="";
        int i=0;
        while(w1<e1 && w2<e2){
            if(i%2==0){
                ans=ans+word1.charAt(w1);
                w1++;
            }else{
                 ans=ans+word2.charAt(w2);
                w2++;
            }
            i++;
        }
      if(w2<=e2-1){
        ans+=word2.substring(w2);
      }
      if(w1<=e1-1){
        ans+=word1.substring(w1);
      }
        return ans;
    }
}