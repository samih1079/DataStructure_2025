package deplo1_15_4_2025;


import ds.BinNode;
import ds.Node;
import ds.Queue;

public class Q1
{
    public static void main(String[] args) {
        Node< Integer > lst = createRandomLinkedList(5);
        //printList(lst);
        Sod2(lst);
       //printList(lst);
    }
    public static void Sod(Node< Integer > lst)
    {
        Node< Integer > p = lst;
        while (lst.getNext() != null)
        {
            lst.setValue(lst.getNext().getValue());
            p = lst;
            lst=lst.getNext();
        }
        p.setNext(null);
    }

    public static void Sod2(Node<Integer> lst)
    {
        if (lst!=null && lst.getNext()!=null&& lst.getNext().getNext()==null) {
            lst.setValue(lst.getNext().getValue());
            lst.setNext(null);
            printList(lst);
        }
        else {
            lst.setValue(lst.getNext().getValue());
            printList(lst);
            Sod2(lst.getNext());
        }
    }
public static Node<Integer> createRandomLinkedList(int numberOfNodes) {
    if (numberOfNodes <= 0) {
        return null;
    }
    Node<Integer> head = new Node<>(generateRandomNumber());
    Node<Integer> current = head;
    for (int i = 1; i < numberOfNodes; i++) {
        Node<Integer> newNode = new Node<>(generateRandomNumber());
        current.setNext(newNode);
        current = newNode;
    }
    return head;
}

private static int generateRandomNumber() {
    return (int) (Math.random() * 100); // Generates a random number between 0 and 99
}
public static void printList(Node<Integer> lst) {
    Node<Integer> current = lst;
    System.out.print("lst:->");
    while (current != null) {
           System.out.print(current.getValue() + "->");

        current = current.getNext();
    }
    System.out.println();
}
    public static class Product {
        private int name;
        private double price;
        private int count;

        public Product(int name, double price, int count) {
            this.name = name;
            this.price = price;
            this.count = count;
        }

        public int getName() {
            return name;
        }

        public void setName(int name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static class Sala {
        private String code; // رمز السالة
        private Node<Product> products; // قائمة المنتجات
        private double total; // المجموع الكلي

        public Sala(String code) {
            this.code = code;
            this.products = null;
            this.total = 0;
        }

        // إضافة منتج إلى القائمة
        public void addProduct(Product pr) {
            // إذا كانت قائمة المنتجات فارغة، أضف المنتج كأول عنصر
            if (products == null) {
                products = new Node<>(pr);
            } else {
                Node<Product> p = products;
                boolean isAdded = false;
                // التنقل عبر كل العناصر في القائمة
                while (p != null) {
                    // إذا كان المنتج موجود بالفعل، قم بتحديث الكمية
                    if (p.getValue().getName() == pr.getName()) {
                        p.getValue().setCount(p.getValue().getCount() + pr.getCount());
                        isAdded = true;
                    }
                    p = p.getNext();
                }
                // إذا لم يتم إضافة المنتج في الدورة، أضف كعنصر جديد
                if (!isAdded) {
                    products = new Node<>(pr, products);
                }
            }
            // تحديث الإجمالي بإضافة تكلفة المنتج
            total += pr.getPrice() * pr.getCount();
        }
        public double getTotal() {
            return total;
        }

        public String getCode() {
            return code;
        }
    }

public static String maxPriceSalaCode(Queue<Sala> q) {
    if (q == null || q.isEmpty()) {
        return null;
    }

    Queue<Sala> q2 = new Queue<>();
    Sala maxSala = q.head();

    while (!q.isEmpty()) {

        Sala sala = q.remove();
        if ( sala.getTotal() > maxSala.getTotal()) {
            maxSala = sala;
        }
        q2.insert(sala);
    }

    // Restore the original queue
    while (!q2.isEmpty()) {
        q.insert(q2.remove());
    }

    return  maxSala.getCode();
}
    public static Integer tail(Queue<Integer> queue) {
        // إرجاع القيمة الأخيرة من الطابور
        // إذا كان الدور فارغا، إرجاع القيمة null
        if (queue == null || queue.isEmpty()) {
            return null;
        }

        // إضافة عناصر الدور إلىلدور آخر
        Queue<Integer> q2 = new Queue<>();
        Integer last = null;

        while (!queue.isEmpty()) {
            last = queue.remove();
            q2.insert(last);
        }

        // إعادة بناء الدور الأصلي
        while (!q2.isEmpty()) {
            queue.insert(q2.remove());
        }

        return last;
    }
    public static boolean isBSTQueue(BinNode<Queue<Integer>> tr) {
        if (tr == null) {
            return true;
        }
//        if (tr.getLeft() != null) {
//            if (tr.getLeft().getValue().isEmpty() ||
//                    (tr.getValue().head() <= tr.getLeft().getValue().head() ||
//                            tail(tr.getValue())<= tail(tr.getLeft().getValue()) {
//                return false;
//            }
//        }
//        if (tr.getRight() != null) {
//            if (tr.getRight().getValue().isEmpty() ||
//                    tr.getValue().head() >= tr.getRight().getValue().head() ||
//                    tail(tr.getValue()) >= tail(tr.getRight().getValue()) {
//                return false;
//            }
//        }
        return isBSTQueue(tr.getLeft()) && isBSTQueue(tr.getRight());
    }
}
