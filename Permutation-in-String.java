class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
           map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        int i=0;
        int j=0;
        int ws=s1.length();
        while(j<s2.length()){
            char ch=s2.charAt(j);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            if(j-i+1>ws){
                char chi=s2.charAt(i);
                map2.put(chi, map2.get(chi) - 1);
                if (map2.get(chi) == 0) map2.remove(chi);
                i++;
            }

            if(j-i+1==ws && map1.equals(map2)) return true;
            j++;

        }


    return false;
    }
}