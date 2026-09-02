//leetcode 155

class MinStack {
public:
    Stack<pair<int, int> st;

    MinStack() {
        
    }
    
    void push(int value) {
        int minval = value;
        minval = min(value, getMin());
        st.push(value, minval);
    }
    
    void pop() {
        
    }
    
    int top() {
        
    }
    
    int getMin() {
        
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(value);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */