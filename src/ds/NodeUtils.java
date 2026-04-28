package ds;

import java.util.Scanner;

public class NodeUtils
{
    public static int size(Node<Integer> ch)
    {
        if (ch == null)
            return 0;
        return 1 + size(ch.getNext());
    }

    //دالة تتلقى عددا صحيحا n وت
    public static Node<Integer> buildList(int n)
    {
        Node<Integer> ch = null;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++)
        {
            System.out.print("Enter number " + (i+1) + ": ");
            int value = scanner.nextInt();
            ch = new Node<>(value, ch);
        }
        return ch;
    }

    public static void printList(Node<Integer> ch)
    {
        Node<Integer> p = ch;
        while (p != null)
        {
            System.out.print(p.getValue() + " ");
            p = p.getNext();
        }
        System.out.println();
    }

    public static Integer max(Node<Integer> ch)
    {
        if (ch == null)
            return null;
        Node<Integer> p = ch;
        Integer max = p.getValue();
        while (p != null)
        {
            if (p.getValue().compareTo(max) > 0)
                max = p.getValue();
            p = p.getNext();
        }
        return max;
    }

    public static Integer min(Node<Integer> ch)
    {
        if (ch == null)
            return null;
        Node<Integer> p = ch;
        Integer min = p.getValue();
        while (p != null)
        {
            if (p.getValue().compareTo(min) < 0)
                min = p.getValue();
            p = p.getNext();
        }
        return min;
    }

    public static Node<Integer> find(Node<Integer> ch, Integer value)
    {
        Node<Integer> p = ch;
        while (p != null)
        {
            if (p.getValue().equals(value))
                return p;
            p = p.getNext();
        }
        return null;
    }
}
