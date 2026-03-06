1class Solution {
2    public boolean checkOnesSegment(String s) {
3        int countz=0;
4        for(int i=1;i<s.length();i++){
5            if(s.charAt(i)=='0' ){
6                countz++;
7            }else if(s.charAt(i)=='1' && countz>0) return false;
8        }
9        return true;
10    }
11}