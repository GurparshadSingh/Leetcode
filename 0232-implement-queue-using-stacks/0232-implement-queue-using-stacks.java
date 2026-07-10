class MyQueue {
    Stack<Integer> st;
    Stack<Integer> help;

    public MyQueue() {
        st = new Stack<>();
        help = new Stack<>();
    }

    public void push(int x) {
        st.push(x);
    }

    public int pop() {
        if (help.isEmpty()) {
            while (!st.isEmpty()) {
                help.push(st.pop());
            }
 
        }
        return help.pop();
    }

    public int peek() {
        if (help.isEmpty()) {
            while (!st.isEmpty()) {
                help.push(st.pop());
            }
        
        }
        return help.peek();
    }

    public boolean empty() {
        return st.isEmpty()&& help.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */