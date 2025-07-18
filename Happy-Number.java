class Solution {
    public boolean isHappy(int n) {
       HashSet<Integer> set=new HashSet<>();
        int ans=square(n);
        while(ans!=1){
            if(set.contains(ans)) return false;
            set.add(ans);
            ans=square(ans);
        }
        return true;
    }
   public int square(int n){
    int sum = 0;
    while(n > 0){
        int digit = n % 10;
        sum += digit * digit;
        n = n / 10;
    }
    return sum;
}

}