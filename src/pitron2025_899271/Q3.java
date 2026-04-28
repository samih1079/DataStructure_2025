package pitron2025_899271;

import ds.BinNode;

public class Q3
{
    public static boolean isLeftK(BinNode<Integer> root, int k){
        if(!root.hasLeft() && !root.hasRight() && k >= 0) return true;
        if(k < 0) return false;
        boolean L=true,R=true;
        if(root.hasLeft())
            L= isLeftK(root.getLeft(), k-1);
        if(root.hasRight())
            R= isLeftK(root.getRight(), k);
        return L && R;
    }

}
