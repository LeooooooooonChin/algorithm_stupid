// 解法一 95ms
class MyQueue {
    Stack<Integer> a;
    Stack<Integer> b;
    /** Initialize your data structure here. */
    public MyQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        a.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(b.empty()){
            while(!a.empty()){
                b.push(a.pop());
            }
        }
        return b.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(b.empty()){
            while(!a.empty()){
                b.push(a.pop());
            }
        }
        return b.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (b.empty() && a.empty());
    }
}
// 解法二 64ms
class MyQueue {
    Stack<Integer> in = null;
    Stack<Integer> out = null; 
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    public void push(int x) {
        in.push(x);
    }
    public int pop() {
        peek();
        return out.pop();
    }
    public int peek() {//不空的时候，直接查询返回即可
        if(out.isEmpty())//空的时候，再倒换stack
            while(!in.isEmpty())
                out.push(in.pop());
        return out.peek();
    }
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
// 解法三 92ms
class MyQueue {
    Stack<Integer> a = null;
    Stack<Integer> b = null; 
    public MyQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }
    public void push(int x) {
        a.push(x);
    }
    public int pop() {
        peek();
        return b.pop();
    }
    // 查看集合不为空的时候，直接返回元素
    public int peek() {
        // 查看集合为空的时候，把插入集合的元素放入查看集合
        if(b.isEmpty())
            while(!a.isEmpty())
                b.push(a.pop());
        return b.peek();
    }
    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
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