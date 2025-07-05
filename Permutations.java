class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ll=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();

        Print(nums,ans,0);
        return ans;
    }
    public static void Print(int nums[],List<List<Integer>> ans,int idx){
        if(idx==nums.length){
            List<Integer> ll=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ll.add(nums[i]);
            }
            ans.add(new ArrayList<>(ll));
            return;
        }
        
        for(int i=idx;i<nums.length;i++){
            swap(nums,i,idx);
            Print(nums,ans,idx+1);
            swap(nums,i,idx);
        }
        
    }
    public static void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}