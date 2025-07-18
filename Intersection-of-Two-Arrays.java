class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> setOne=new HashSet<>();
        HashSet<Integer> resultSet=new HashSet<>();
        for(int i:nums1){
            setOne.add(i);
        }
        for(int i:nums2){
            if(setOne.contains(i)) resultSet.add(i);
        }
        int[] result = new int[resultSet.size()];
        int idx = 0;
        for (int num : resultSet) {
            result[idx++] = num;
        }
        return result;
    }
}