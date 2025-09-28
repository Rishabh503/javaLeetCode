class Solution {
    public int maxNumberOfBalloons(String str) {
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,Integer> ballonMap=new HashMap<>();
        ballonMap.put('b',1);ballonMap.put('a',1);ballonMap.put('l',2);
        ballonMap.put('o',2);ballonMap.put('n',1);
        for(int i=0;i<str.length();i++){
          if(ballonMap.containsKey(str.charAt(i))) {
             map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
             }
        }
        if(map.size()!=5) return 0;
         int valid = Integer.MAX_VALUE;
        for(int i=0;i<str.length();i++){
            if(ballonMap.containsKey(str.charAt(i))){
                char ch=str.charAt(i);
                valid=Math.min(valid,map.get(ch)/ballonMap.get(ch));
             }
        }
        return valid;
    }
}