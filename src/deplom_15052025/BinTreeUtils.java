package deplom_15052025;

import ds.BinNode;
import ds.Queue;

public class BinTreeUtils
{
    // دالة لايجاد ارتفاع الشجرة
    public static int height(BinNode<Integer> tr){
        if(tr == null) return 0;
        return 1 + Math.max(height(tr.getLeft()), height(tr.getRight()));
    }

    // دالة لايجاد عدد العناصر في الشجرة
    public static int size(BinNode<Integer> tr){
        if(tr == null) return 0;
        return 1 + size(tr.getLeft()) + size(tr.getRight());
    }

    // دالة لايجاد مجموع الشجرة
    public static int sum(BinNode<Integer> tr){
        if(tr == null) return 0;
        return tr.getValue() + sum(tr.getLeft()) + sum(tr.getRight());
    }

    // دالة لايجاد مجموع قيم بمستوى معين في الشجرة
    public static int sumAtLevel(BinNode<Integer> tr, int level){
        if(tr == null || level < 0) return 0;
        if(level == 0) return tr.getValue();
        return sumAtLevel(tr.getLeft(), level-1) + sumAtLevel(tr.getRight(), level-1);
    }

// دالة لإرجاع الطابور بعد الترتيب الوسطي
public static Queue<Integer> inorderToQueue(BinNode<Integer> tr) {
    Queue<Integer> queue = new Queue<>();
    inorderToQueueHelper(tr, queue);
    return queue;
}

private static void inorderToQueueHelper(BinNode<Integer> tr, Queue<Integer> queue) {
    if (tr == null) {
        return;
    }
    inorderToQueueHelper(tr.getLeft(), queue);
    queue.insert(tr.getValue());
    inorderToQueueHelper(tr.getRight(), queue);
}

    // دالة لنسخ الشجرة
    public static BinNode<Integer> copyTree(BinNode<Integer> tr){
        if(tr == null) return null;
        BinNode<Integer> newNode = new BinNode<>(tr.getValue());
        newNode.setLeft(copyTree(tr.getLeft()));
        newNode.setRight(copyTree(tr.getRight()));
        return newNode;
    }

}
