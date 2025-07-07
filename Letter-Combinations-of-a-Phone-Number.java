class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
 
        List<String> mainAns=new ArrayList<>();
       Print(map,digits,"",0,mainAns);
        return mainAns;

    }
    public static void Print(String chars[],String digits,String ans,int idx,List<String> mainAns){
        if(digits.length()==0){
            return ;
        }
        if(idx==digits.length()){
            mainAns.add(ans);
            return;
        }
        int digit=digits.charAt(idx)-'0';
        String letters=chars[digit];
        
        
        for(int i=0;i<letters.length();i++){
            char ch=letters.charAt(i);
            Print(chars,digits,ans+ch,idx+1,mainAns);
        }
        
    }
}