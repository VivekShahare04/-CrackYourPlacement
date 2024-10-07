class Solution {
    public int evalRPN(String[] tokens) {
         Stack<Integer> st = new Stack<>();
        
        for (String token : tokens) {
            // Check if the token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int v1 = st.pop();  // The second operand (as it was pushed later)
                int v2 = st.pop();  // The first operand
                switch (token) {
                    case "+":
                        st.push(v2 + v1);
                        break;
                    case "-":
                        st.push(v2 - v1);
                        break;
                    case "*":
                        st.push(v2 * v1);
                        break;
                    case "/":
                        st.push(v2 / v1);  // Assuming v2 / v1 as integer division
                        break;
                }
            } else {
                // If it's not an operator, it's a number, so push it onto the stack
                st.push(Integer.parseInt(token));
            }
        }
        
        // The result of the evaluation will be the only element left in the stack
        return st.pop();
    }
}