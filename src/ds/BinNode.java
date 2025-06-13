package ds;

public class BinNode<T>{
    private  T value;
    private BinNode left,right;

    public BinNode(T value) {
        this.value = value;
    }

    public BinNode( BinNode left,T value ,BinNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinNode getLeft() {
        return left;
    }

    public void setLeft(BinNode left) {
        this.left = left;
    }

    public BinNode getRight() {
        return right;
    }

    public void setRight(BinNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return value.toString() ;
    }
    public boolean hasLeft()
    {
        return  left!=null;
    }
    public boolean hasRight()
    {
        return  right!=null;
    }
}
