class MinStack {
    Node top = null;

    public void push(int x) {
        if (top == null) {//栈顶为空设置新元素为栈顶
            top = new Node(x);
            top.min = x;
        } else {//
            Node temp = new Node(x);//申请新结点
            temp.next = top;//交换栈顶
            top = temp;
            top.min = Math.min(top.next.min, x);//插入时实时比出最小元素
        }
    }

    public void pop() {
        top = top.next;//设置下一个元素为结点
        return;
    }

    public int top() {
        return top == null ? 0 : top.val;
    }

    public int getMin() {
        return top == null ? 0 : top.min;
    }
}

class Node {//定义Stack数据结构
    int val;
    int min;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}