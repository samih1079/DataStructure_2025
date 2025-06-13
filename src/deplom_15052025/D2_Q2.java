package deplom_15052025;

import ds.BinNode;
import ds.Queue;

public class D2_Q2 {

    class Folder {
        private String name;
        private int size;

        public Folder(String name, int size) {
            this.name = name;
            this.size = size;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }

    public boolean isInfected2(BinNode<Folder> tr)
    {
        if (tr == null) {
            return true;
        }
        int leftSize = 0;
        if (tr.getLeft() != null)
            leftSize = tr.getLeft().getValue().getSize();
        int rightSize = 0;
        if (tr.getRight() != null)
            rightSize = tr.getRight().getValue().getSize();

        if (tr.getValue().getSize() != leftSize + rightSize)
            return false;
        return isInfected2(tr.getLeft()) && isInfected2(tr.getRight());
    }

public Queue<BinNode<Folder>> getInfectedTrees(Queue<BinNode<Folder>> qtr) {
    Queue<BinNode<Folder>> res = new Queue<>();
    while (!qtr.isEmpty()) {
        BinNode<Folder> tree = qtr.remove();
        if (!isInfected1(tree)) {
            res.insert(tree);
        }
    }
    return res;
}
    public boolean isInfected1(BinNode<Folder> tr)
    {
        if (tr == null) {
            return true;
        }
        if(tr.hasLeft() && tr.hasRight())
            if(tr.getValue().getSize() != tr.getLeft().getValue().getSize() + tr.getRight().getValue().getSize())
                return flase;
       if(tr.hasLeft())
            if(tr.getValue().getSize() != tr.getLeft().getValue().getSize())
                return flase;
       if(tr.hasRight())
            if(tr.getValue().getSize() != tr.getRight().getValue().getSize())
                return flase;
        return isInfected1(tr.getLeft()) && isInfected1(tr.getRight());
    }
}
