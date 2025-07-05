class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
             Arrays.sort(nums);
        Subsets(nums, ll, ans, 0);
        return ans;
    }

    public void Subsets(int nums[],List<Integer> ll,List<List<Integer>> ans,int idx){
        if(idx==nums.length){
            ans.add(new ArrayList<>(ll));
            return;
        }
        // 2 choice 
        // take 
        ll.add(nums[idx]);
        Subsets(nums,ll,ans,idx+1);
         // skip
        ll.remove(ll.size() - 1);  
        while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
            idx++;
        }
        Subsets(nums, ll, ans, idx + 1);
         }
    }
