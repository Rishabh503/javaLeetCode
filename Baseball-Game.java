import java.util.*;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("C")) {
                st.pop();
            } else if (operations[i].equals("D")) {
                st.push(2 * st.peek());
            } else if (operations[i].equals("+")) {
                int a = st.pop();
                int b = st.peek();
                st.push(a);
                st.push(a + b);
            } else {
                st.push(Integer.parseInt(operations[i]));
            }
        }

        int sum = 0;
        for (int val : st) sum += val;

        return sum;
    }
}
