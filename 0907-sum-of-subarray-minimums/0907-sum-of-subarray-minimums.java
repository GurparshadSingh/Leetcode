class Solution {


    public int sumSubarrayMins(int[] arr) {
        
       Stack<Integer> stack = new Stack<>();
        int rs[]=new int[arr.length];
        for(int i = arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            rs[i]=stack.isEmpty()?arr.length:stack.peek();
            stack.push(i);
        }
        Stack<Integer> st = new Stack<>();
        int ls[]=new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            ls[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        long MOD = 1_000_000_007; 
        long res = 0;
        for (int i =0;i<arr.length;i++){
            res=(res  +  (long)arr[i]  *  (rs[i]-i)  *  (i-ls[i])   )%MOD;
        }
        return (int)res;
    }
}