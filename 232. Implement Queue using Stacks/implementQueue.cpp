class MyQueue {
public:
    /** Initialize your data structure here. */
    stack<int> S1, S2;
    MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        S1.push(x);
        //S2.push()
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        while (!S1.empty()) {
            S2.push(S1.top());
            S1.pop();
        }
        int val = S2.top();
        S2.pop();
        
        while (!S2.empty()) {
            S1.push(S2.top());
            S2.pop();
        }
        return val;
    }
    
    /** Get the front element. */
    int peek() {
        while (!S1.empty()) {
            S2.push(S1.top());
            S1.pop();
        }
        int val = S2.top();
        
        while (!S2.empty()) {
            S1.push(S2.top());
            S2.pop();
        }
        return val;
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return S1.empty();
    }
};