package ds.StackTraining;

import ds.Queue;
import ds.Stack;

public class Ex1 {
    public static int stackSize(Stack<Integer> st) {
        int count = 0;
        Stack<Integer> temp = new Stack<>();
        while (!st.isEmpty()) {
            temp.push(st.pop());
            count++;
        }
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return count;
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(34);
        st.push(45);
        st.push(53);
        st.push(32);
        st.push(56);
        System.out.println("the stack: " + st);
        int count = 0;
        while (!st.isEmpty()) {
            st.pop();
            count++;
        }
        System.out.println("Number of elements: " + count);
        System.out.println("the stack: " + st);
        ///---------
        int[] numbers = {34, 45, 53, 32, 56};
        Queue<Integer> q = new Queue<>();
        for (int num : numbers) {
            if (num % 2 == 0) {
                q.insert(num);
            }
        }
        System.out.println("Queue of even numbers: " + q);
        ///
        int maxValue = Integer.MIN_VALUE;
        Queue<Integer> temp = new Queue<>();
        while (!q.isEmpty()) {
            int value = q.remove();
            temp.insert(value);
            if (value > maxValue) {
                maxValue = value;
            }
        }
        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
        System.out.println("Max value of the queue: " + maxValue);
    }
    
}
