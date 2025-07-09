class Solution {
    public int splitArray(int[] nums, int k) {
        // ans banate hai yanni range dekhte hai 
        // low ke liye sbse bda element and 2 hisse
        // kyuki kam se kam sum to wahi hoga 
        int low=getMax(nums);
        // high me sbse bda aarray dedete hai 
        int high=getSum(nums);

        // ab hum mid ko apna ans banayege and k ko uske pass layege ya k ko usse nikalege
        int mid=(low+high)/2;
        int ans=mid;
        while(low<=high){
            if(isPossible(mid,nums,k)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
            mid=(low+high)/2;
        }
        return ans;
    }

    public boolean isPossible(int mid,int nums[],int k){
        int min=1;
        int currentSum=0;
        for(int i : nums){
            if(currentSum + i <= mid){
                currentSum += i;
            }else{
                currentSum = i;
                min++;
            }
        }
        return min <= k;
    }

    public int getMax(int[] nums){
        int max = nums[0];
        for(int i : nums){
            if(i > max){
                max = i;
            }
        }
        return max;
    }

    public int getSum(int[] nums){
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        return sum;
    }
}
