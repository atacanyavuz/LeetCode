class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        while (stack2.isEmpty() == false) {
            stack1.add(stack2.pop());
        }
        stack1.add(x);
        while (stack1.isEmpty() == false) {
            stack2.add(stack1.pop());
        }
    }
    
    public int pop() {
        return stack2.pop();
    }
    
    public int peek() {
        return stack2.peek();      
    }
    
    public boolean empty() {
        return stack2.isEmpty();
        
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