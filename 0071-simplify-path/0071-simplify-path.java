class Solution {
    public String simplifyPath(String path) {
        String arr[] = path.split("/");
        Stack<String> legacyStack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            String curr = arr[i];

            if (curr.equals("") || curr.equals(".")) {
                continue;
            } else if (curr.equals("..")) {
                if (!legacyStack.isEmpty()) {
                    legacyStack.pop();
                }
            } else {
                legacyStack.push(curr);
            }
        }

        Stack<String> stack = new Stack<>();
        while(!legacyStack.isEmpty()){
            stack.push(legacyStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append("/");
            sb.append(stack.pop());
        }
        return (sb.length()==0) ? "/"  : sb.toString();

    }
}