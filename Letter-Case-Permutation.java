class Solution {
    public List<String> letterCasePermutation(String s) {
         List<String> mainAns=new ArrayList<>();
         Print3(s,"",0,mainAns);
         return mainAns;
    }
        public static void Print3(String s,String ans,int idx,List<String> mainAns){
        if(idx==s.length()){
            mainAns.add(ans);

            return;
        }
    
        char ch=s.charAt(idx);
        if(Character.isDigit(ch)){
            Print3(s,ans+ch,idx+1,mainAns);
        }else{
            Print3(s,ans+Character.toLowerCase(ch),idx+1,mainAns);
            Print3(s,ans+Character.toUpperCase(ch),idx+1,mainAns);
        }
        
    }

}