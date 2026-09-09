//leetcode 155

class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    double minval;// = Math.pow(2,-31);

    public MinStack() {
        minval = Math.pow(2,31);
    }
    
    public void push(int value) {
        stack.push(value);
        if(minval>value){
            minval=value;
        }
    }
    
    public void pop() {
        if(minval == stack.pop()){
            minval=Math.pow(2, 31);
            for(int a: stack){
                minval = (minval>a)? a: minval;
            }
        }

    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return (int)minval;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
