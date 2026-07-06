class Solution {
    public String decodeString(String s) {
        Stack<Integer> stackNumbers = new Stack<>();
        Stack<StringBuilder> stackStrings = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int currentNumber = 0;

        for (char ch : s.toCharArray()) {
                if(Character.isDigit(ch)){
                    currentNumber = currentNumber*10 + (ch-'0');
                }else if(ch=='['){
                    stackNumbers.push(currentNumber);
                    stackStrings.push(currentString);

                    currentNumber = 0;
                    currentString = new StringBuilder();
                }else if (Character.isLetter(ch)) {
                currentString.append(ch);
                }else if(ch==']'){
                    int repeat = stackNumbers.pop();
                    StringBuilder previous = stackStrings.pop();
                    for(int i = 0;i<repeat;i++){
                        previous.append(currentString);
                    }
                    currentString = previous;
                }

            }
            return currentString.toString();
    }
}