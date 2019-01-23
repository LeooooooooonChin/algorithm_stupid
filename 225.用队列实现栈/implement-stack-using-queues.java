// 解法一 92ms
class MyStack {
    Deque<Integer> deque = new LinkedList<>();
    public MyStack() {

    }
    public void push(int x) {
        deque.offer(x);
    }
    public int pop() {
        return deque.pollLast();
    }
    public int top() {

        return deque.peekLast();
    }
    public boolean empty() {
        return deque.isEmpty();
    }
}
// 解法二 92ms
class MyStack {
    
    private Queue<Integer> in = new LinkedList<>();
    private Queue<Integer> out = new LinkedList<>();
    
    public MyStack() {

    }
    
    public void push(int x) {
        while(!out.isEmpty()){
            in.offer(out.poll());
        }
        out.offer(x);
        while(!in.isEmpty()){
            out.offer(in.poll());
        }
    }
    public int pop() {
        return out.poll();
    }
    public int top() {
        return out.peek();
    }
    public boolean empty() {
        return out.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */