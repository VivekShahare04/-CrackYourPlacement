class Solution {
    public String simplifyPath(String path) {
        // int n = path.length();
        // if(path.length()==0 && path.charAt(0)=='/'){
        //     return "/";
        // }
        // int count=0;
        // Stack<Character> st = new Stack<>();
        // st.push('/');
        // while(!st.isEmpty()||n!=0){
        //     for(char c:path.toCharArray()){
        //         if(st.peek()!='/'){
        //             st.push(c);
        //         }else if(st.peek()=='/'){
        //             while(!st.isEmpty() &&st.peek()=='/'){
        //                 st.pop();
        //             }
        //             st.push('/');
        //         }else if(st.peek()=='/' && n==0){
        //             st.pop();
        //         }else if(c=='.'){
        //             count++;
        //             st.push(c);
        //             if(count==2|| count==1){
        //                 while(count!=0){
        //                     st.pop();
        //                 }
        //             }
        //         }else{
        //             st.push(c);
        //         }
        //     }
        //     n--;
        // }
        // StringBuilder sb = new StringBuilder();
        // while(!st.isEmpty()){
        //     sb.append(st.pop());
        // }
        
        // return sb.reverse().toString();

        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                // Ignore empty or current directory
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Go to parent dir
                }
            } else {
                stack.push(part); // Valid dir or file name
            }
        }

        // Build canonical path
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append('/').append(dir);
        }

        // If stack was empty, return root "/"
        return sb.length() == 0 ? "/" : sb.toString();
    }
}