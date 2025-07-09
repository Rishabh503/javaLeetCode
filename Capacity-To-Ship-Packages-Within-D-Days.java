class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = getMaxSingle(weights);
        int high = getSum(weights);
        int result = high;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canShip(weights, mid, days)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public boolean canShip(int[] arr, int capacity, int days) {
        int d = 1;
        int dayCapacity = 0;

        for (int i = 0; i < arr.length; i++) {
            if (dayCapacity + arr[i] <= capacity) {
                dayCapacity += arr[i];
            } else {
                d++;
                dayCapacity = arr[i]; 
            }
        }

        return d <= days;
    }

    public int getMaxSingle(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }

    public int getSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}
