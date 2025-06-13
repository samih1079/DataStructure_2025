package deplom_15052025;

import ds.Node;

public class NodeListUtils
{
    // دالة لطباعة عناصر القائمة
    public static void printList(Node<Integer> lst) {
        while (lst != null) {
            System.out.println(lst.getValue());
            lst = lst.getNext();
        }
    }

    // دالة للحصول على عدد العناصر في القائمة
    public static int size(Node<Integer> lst) {
        int count = 0;
        while (lst != null) {
            count++;
            lst = lst.getNext();
        }
        return count;
    }

    // دالة للحصول على العنصر الأول في القائمة
    public static int head(Node<Integer> lst) {
        return lst.getValue();
    }

    // دالة للحصول على العنصر الأخير في القائمة
    public static int tail(Node<Integer> lst) {
        while (lst.getNext() != null) {
            lst = lst.getNext();
        }
        return lst.getValue();
    }
    // دالة لتحويل القائمة إلى مصفوفة
    public static int[] listToArray(Node<Integer> lst) {
        int[] arr = new int[size(lst)];
        int i = 0;
        while (lst != null) {
            arr[i++] = lst.getValue();
            lst = lst.getNext();
        }
        return arr;
    }

    // دالة لتحويل المصفوفة إلى قائمة
    public static Node<Integer> arrayToList(int[] arr) {
        Node<Integer> lst = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            lst = new Node<>(arr[i], lst);
        }
        return lst;
    }
    // دالة لإضافة عنصر إلى نهاية القائمة
    public static Node<Integer> append(Node<Integer> lst, int value) {
        Node<Integer> newNode = new Node<>(value);
        if (lst == null) {
            return newNode;
        }
        Node<Integer> p = lst;
        while (p.getNext() != null) {
            p = p.getNext();
        }
        p.setNext(newNode);
        return lst;
    }
// دالة لإضافة عنصر إلى قائمة مرتبة
public static Node<Integer> addToSortedList(Node<Integer> lst, int x) {
    Node<Integer> t = new Node<>(x);
    if (lst == null || lst.getValue() >= x) {
        t.setNext(lst);
        return t;
    }
    Node<Integer> p = lst;
    while (p.getNext() != null && p.getNext().getValue() < x) {
        p = p.getNext();
    }
    t.setNext(p.getNext());
    p.setNext(t);
    return lst;
}
// دالة لحذف قيمة من القائمة
public static Node<Integer> deleteValue(Node<Integer> lst, int value) {
    if (lst == null) {
        return null;
    }
    if (lst.getValue() == value) {
        return lst.getNext();
    }
    Node<Integer> p = lst;
    while (p.getNext() != null && p.getNext().getValue() != value) {
        p = p.getNext();
    }
    if (p.getNext() != null) {
        p.setNext(p.getNext().getNext());
    }
    return lst;
}




}
