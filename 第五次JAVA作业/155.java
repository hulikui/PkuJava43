class MinStack {
    Node top = null;

    public void push(int x) {
        if (top == null) {//ջ��Ϊ��������Ԫ��Ϊջ��
            top = new Node(x);
            top.min = x;
        } else {//
            Node temp = new Node(x);//�����½��
            temp.next = top;//����ջ��
            top = temp;
            top.min = Math.min(top.next.min, x);//����ʱʵʱ�ȳ���СԪ��
        }
    }

    public void pop() {
        top = top.next;//������һ��Ԫ��Ϊ���
        return;
    }

    public int top() {
        return top == null ? 0 : top.val;
    }

    public int getMin() {
        return top == null ? 0 : top.min;
    }
}

class Node {//����Stack���ݽṹ
    int val;
    int min;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}