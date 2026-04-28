package ds;

public class BinNodeUtils {
    public static void main(String[] args) {
        BinNode<Integer> tr=new BinNode<>(
                new BinNode<>(3),
                1,
                new BinNode<>(4)
        );
        tr.getRight().setLeft(new BinNode<>(5));

        System.out.println("sum tree1 is:"+sumTree(tr));
        System.out.println("sum tree2 is:"+sumTree2(tr));

    }

    public static  int size(BinNode<Integer> root) {

        if (root == null) {
            return 0;
        }
             return 1 + size(root.getLeft()) + size(root.getRight());

    }
    public static  int count0(BinNode<Integer> root,int baqi) {
        if (root == null) {
            return 0;
        }
        if(root.getValue()%3==baqi)
            return 1 + count0(root.getLeft(),baqi) + count0(root.getRight(),baqi);
        else
            return count0(root.getLeft(),baqi) + count0(root.getRight(),baqi);
    }
    public static <T> boolean isLeaf(BinNode<T> node) {
        if (node == null) {
            return false;
        }
        return !node.hasLeft() && !node.hasRight();
    }

    public static <T> int height(BinNode<T> root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    public static <T> boolean exists(BinNode<T> root, T value) {
        if (root == null) {
            return false;
        }
        if (root.getValue().equals(value)) {
            return true;
        }
        return exists(root.getLeft(), value) || exists(root.getRight(), value);
    }

    public static <T> void printInorder(BinNode<T> root) {
        if (root != null) {
            printInorder(root.getLeft());
            System.out.print(root.getValue() + " ");
            printInorder(root.getRight());
        }
    }

    public static <T> void printPreorder(BinNode<T> root) {
        if (root != null) {
            System.out.print(root.getValue() + " ");
            printPreorder(root.getLeft());
            printPreorder(root.getRight());
        }
    }

    public static <T> void printPostorder(BinNode<T> root) {
        if (root != null) {
            printPostorder(root.getLeft());
            printPostorder(root.getRight());
            System.out.print(root.getValue() + " ");
        }
    }

    //
    public static int countLeaves(BinNode<?> root) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root)) {
            return 1;
        }
        return countLeaves(root.getLeft()) + countLeaves(root.getRight());
    }

    public static int sumTree(BinNode<Integer> root) {

        if (root == null) {
            return 0;
        }
        return root.getValue()+sumTree(root.getLeft()) + sumTree(root.getRight());
    }

//جمع قيم الشجرة بواسطة جماع كبارامتر
    public static int sumTree2(BinNode<Integer> root) {

        int sm=sumTree2Help(root,0);
        return  sm;
    }

    private static int sumTree2Help(BinNode<Integer> root, int sum) {
        if (root == null)
            return sum;
        sum+=root.getValue();
        sum=sumTree2Help(root.getLeft(),sum);
        sum=sumTree2Help(root.getRight(),sum);
        return sum;
    }

    //
    public static boolean isExists(BinNode<Integer> tr, int x) {
        if (tr == null) {
            return false;
        }
        if (tr.getValue() == x) {
            return true;
        }
        return isExists(tr.getLeft(), x) || isExists(tr.getRight(), x);
    }

    public static double maxValue(BinNode<Double> tr)
    {
        double x = tr.getValue();
        double L = x, R = x;
        if (!tr.hasLeft() && !tr.hasRight())
            return tr.getValue();
        if (tr.hasLeft())//if(tr.getLeft()!=null)
            L = maxValue(tr.getLeft());
        if (tr.hasRight())//if(tr.getRight()!=null)
            R = maxValue(tr.getRight());
        return Math.max(x, Math.max(L, R));
    }

    public static double minValue(BinNode<Double> tr)
    {
        double x = tr.getValue();
        double L = x, R = x;
        if (!tr.hasLeft() && !tr.hasRight())
            return tr.getValue();
        if (tr.hasLeft())//if(tr.getLeft()!=null)
            L = minValue(tr.getLeft());
        if (tr.hasRight())//if(tr.getRight()!=null)
            R = minValue(tr.getRight());
        return Math.min(x, Math.max(L, R));
    }

  
    public static Queue<Integer> leavesToQ(BinNode<Integer> tr)
    {
        Queue<Integer> q = new Queue<>();
        leavesToQHelp(tr, q);
        return q;
    }
    private static void leavesToQHelp(BinNode<Integer> tree, Queue<Integer> qu)
    {
        if (tree != null)
        {
            if (tree.getLeft() == null && tree.getRight() == null)
                qu.insert(tree.getValue());
            else
            {
                leavesToQHelp(tree.getLeft(),qu);
                leavesToQHelp(tree.getRight(),qu);
            }
        }
    }

    public static  Queue<Point> treeToQ(BinNode<Point> t)
    {
       Queue<Point> q =new Queue();//دور فارغ
        treeToQtHelp(t,q);//
        return q;

    }
//
    private static void treeToQtHelp(BinNode<Point> t, Queue<Point> q) {
        if(t!=null)
        {
            Point p=t.getValue();
            if(p.getX()==0 || p.getY()==0)
                q.insert(p);
            treeToQtHelp(t.getLeft(),q);
            treeToQtHelp(t.getRight(),q);
        }
    }

    private static Queue<Point> treeToQtHelp2(BinNode<Point> t, Queue<Point> q) {
        if(t==null)
           return q;
        else
        {
            Point p=t.getValue();
            if(p.getX()==0 || p.getY()==0)
                q.insert(p);
           q=treeToQtHelp2(t.getLeft(),q);
          q=treeToQtHelp2(t.getRight(),q);
          return q;
        }
    }

    //5.10 - 1
    public static int countZeros(BinNode<Point> tr)
    {

        if(tr==null)
            return 0;
        Point p=tr.getValue();
        if(p.getX()==0 || p.getY()==0)
            return 1+countZeros(tr.getLeft())+countZeros(tr.getRight());
        return countZeros(tr.getLeft())+countZeros(tr.getRight());
    }
    public static int countZeros2(BinNode<Point> tr)
    {
        int L=0,R=0;
        if(tr==null)
            return 0;
        L=countZeros2(tr.getLeft());
        R=countZeros2(tr.getRight());
        Point p=tr.getValue();
        if(p.getX()==0 || p.getY()==0)
            return 1+L+R;
        return L+R;
    }
    //sol q 2 hw 5.15
    public static boolean isBST(BinNode<Integer> tr)
    {
        if (tr == null) return true;
        //root value nust be bigger than the max of left tree values
        if (tr.hasLeft() && tr.getValue()< maxValue(tr.getLeft()))
            return false;
        if (tr.hasRight() && tr.getValue()> minValue(tr.getRight()))//check if flase
            return false;
        if (!tr.hasLeft() && !tr.hasRight())//is leaf?
            return true;
        return isBST(tr.getLeft()) && isBST(tr.getRight());
    }
    //check x value bigger than all tree values
    public static boolean isBiggerThanTree(BinNode<Integer> tr, int x)
    {
        if(tr==null) return  true;
        if(x<tr.getValue())
            return false;
        return isBiggerThanTree(tr.getLeft(),x) && isBiggerThanTree(tr.getRight(),x);
    }
    //check x value smaller than all tree values
    public static boolean isSmallerThanTree(BinNode<Integer> tr,int x)
    {
        if(tr==null) return  true;
        if(x>tr.getValue())
            return false;
        return isSmallerThanTree(tr.getLeft(),x) && isSmallerThanTree(tr.getRight(),x);
    }
    //sol2 q2 hw.5.15
    public static boolean isBST2(BinNode<Integer> tr)
    {
        if (tr == null) return true;
        int rValue= tr.getValue();
        if(!isBiggerThanTree(tr.getLeft(),rValue ) || !isSmallerThanTree(tr.getRight(),rValue))
            return false;
        return isBST2(tr.getLeft()) && isBST2(tr.getRight());
    }
    //sol2 q2 hw.5.15 without ! (not)
    public static boolean isBST3(BinNode<Integer> tr)
    {
        if (tr == null) return true;
        int rValue= tr.getValue();
        if(isBiggerThanTree(tr.getLeft(),rValue ) && isSmallerThanTree(tr.getRight(),rValue))
            return isBST3(tr.getLeft()) && isBST3(tr.getRight());
        return false;
    }

    //sol q3 hw 5.15
    //is found any tree
    //complexity O(n)
    public static boolean isFound(BinNode<Integer> tr,int x)
    {
        if(tr==null) return false;
        if(tr.getValue()==x)
            return true;
        return isFound(tr.getLeft(),x) || isFound(tr.getRight(),x);
    }
    //is found BST
    //complexity worst case: O(n). Averaged( Balanced tree) : O(log n) -->logn tree hight
    public static boolean isFoundInBST(BinNode<Integer> tr,int x)
    {
        if(tr==null) return false;
        if(tr.getValue()==x)
            return true;
        if(x<tr.getValue())
            return isFoundInBST(tr.getLeft(),x);
        else
            return isFoundInBST(tr.getRight(),x);
    }

}
