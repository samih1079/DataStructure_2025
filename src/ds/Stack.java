package ds;

public class Stack<T> {
    private Node<T> top; // 定义一个指向栈顶元素的引用

    // 定义一个节点类，用于存储栈中的元素
    private class Node<T> {
        private T data; // 节点中存储的数据
        private Node<T> next; // 指向下一个节点的引用
    }

    // 向栈中添加元素
    public void push(T data) {
        Node<T> node = new Node<>();
        node.data = data;
        node.next = top;
        top = node;
    }

    // 从栈中删除元素
    public T pop() {
        if (top == null) {
            System.out.println("ds.Stack is empty!");
            return null;
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return top == null;
    }

    // 返回栈顶元素
    public T top() {
        if (top == null) {
            System.out.println("ds.Stack is empty!");
            return null;
        }
        return top.data;
    }

    // 返回栈的大小
    public int size() {
        int count = 0;
        Node<T> node = top;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" [");
        Node<T> temp = top;
        while (temp != null) {
            sb.append(temp.data + ", ");
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
