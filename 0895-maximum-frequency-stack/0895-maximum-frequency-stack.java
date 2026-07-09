class FreqStack {

    HashMap<Integer, Integer> freq; // value -> frequency
    HashMap<Integer, Stack<Integer>> group; // frequency -> stack
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq=0;
    }

    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        int f = freq.get(val);

        // Update maximum frequency
        maxFreq = Math.max(maxFreq, f);

        //create stack if not present for curr freq
        group.putIfAbsent(f,new Stack<>());
        group.get(f).push(val);
    }

    public int pop() {
        //pop from max freq wala stack in group wala map of stacks se
        int val = group.get(maxFreq).pop();

        //update map kyuki km ki na value humne pop krke
        freq.put(val,freq.get(val)-1);

        //if curr maxFreq wali value khtm hojaye toh maxFreq-- krdo
        if (group.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */