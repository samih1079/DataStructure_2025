package deplom_15052025;

import ds.Node;

import static deplo1_15_4_2025.Q1.printList;

public class D2_Q1 {
// دالة لاسترجاع العنصر الأخير من القائمة
    public static Node<Integer> getLast(Node<Integer> L)
    {
        if (L == null)
            return null;
        Node<Integer> p = L;
        while (p.getNext() != null)
        {
            p = p.getNext();
        }
        return p;
    }


    public static Node<Integer> getPrev(Node<Integer> L, Node<Integer> p)
    {
        if (p == L)
            return null;
        Node<Integer> q = L;
        while (q.getNext() != p)
        {
            q = q.getNext();
        }
        return q;
    }
    public static void swap(Node<Integer> p, Node<Integer> q)
    {
        int temp = p.getValue();
        p.setValue(q.getValue());
        q.setValue(temp);
    }
    public static void mystery1(Node< Integer > L, int x)
    {
        Node< Integer > p1 = L;
        Node< Integer > p2 = getLast(L);
        mystery2(L, p1, p2, x);
    }
    public static void mystery2(Node< Integer > L, Node< Integer > p1, Node< Integer > p2 , int x) {
        if (p1 != p2) {
            System.out.println(p1);
            if (p1.getValue() < x)
            {
                mystery2(L, p1.getNext(), p2, x);
            }
            else if (p2.getValue() > x)
                mystery2(L, p1, getPrev(L, p2), x);
            else {
                System.out.println(p1+" "+p2);
                swap(p1, p2);
                mystery2(L, p1, p2, x);
            }
        }
    }
    public static void main(String[] args) {
//        Node< Integer > lst = createRandomLinkedList(5);
        Node<Integer> lst = new Node<>(7);
        lst.setNext(new Node<>(2));
        lst.getNext().setNext(new Node<>(9));
        lst.getNext().getNext().setNext(new Node<>(5));
        lst.getNext().getNext().getNext().setNext(new Node<>(24));
        lst.getNext().getNext().getNext().getNext().setNext(new Node<>(8));
        lst.getNext().getNext().getNext().getNext().getNext().setNext(new Node<>(18));
        lst.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node<>(3));
        lst.getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node<>(14));
        lst.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node<>(4));
        Node<Integer> lst2 = new Node<>(1);
        lst2.setNext(new Node<>(8));
        lst2.getNext().setNext(new Node<>(25));
        lst2.getNext().getNext().setNext(new Node<>(9));
        lst2.getNext().getNext().getNext().setNext(new Node<>(3));
        lst2.getNext().getNext().getNext().getNext().setNext(new Node<>(21));
        lst2.getNext().getNext().getNext().getNext().getNext().setNext(new Node<>(10));
        printList(lst2);
        mystery1(lst2, 8);
        printList(lst2);
    }
}
