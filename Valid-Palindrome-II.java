class Solution {
    // public boolean validPalindrome(String s) {
    //     // int count=1;
    //     // int i=0;
    //     // int j=s.length()-1;
    //     // while(i<j){
    //     //     if(s.charAt(i)!=s.charAt(j) && count!=1){
    //     //         return false;
    //     //     }else if(s.charAt(i)!=s.charAt(j)){
    //     //         count--;
    //     //         if(s.charAt(i+1)==s.charAt(j)){
    //     //             i++;
    //     //             continue;
    //     //         }else{

    //     //             j--;continue;
    //     //         }
    //     //     }
    //     //     i++;j--;
    //     // }
    //     // return true;
    // }
    public boolean validPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return valid(s,i+1,j) || valid(s,i,j-1);
            }
            i++;j--;
        }
        return true;
    }
    public boolean valid(String s,int i , int j){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
}