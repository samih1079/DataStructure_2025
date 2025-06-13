import ds.BinNode;
import ds.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        BinNode<Integer> tr=new BinNode(4);
        tr.setRight(new BinNode<Integer>(5));
        int[] a={3,4,5,6};
       // System.out.println(mystery(a,3));
       // System.out.println(binomial(4,2));

        Stack<Character> s=new Stack<>();
        s.push('a');
        s.push('b');
        s.push('c');
        s.push('a');
        s.push('e');
        s.push('a');
        s.push('k');
        System.out.println(s);
        System.out.println(what(s,'a'));
        System.out.println(s);
    }
    public static float mystery(int[] a, int k)
    {
        float x;
        if (k == 1)
            return (a[0]);
        x = mystery(a, k-1) * (k-1);
        return ((a[k-1] + x) / k);
    }
    public static int binomial(int n, int k)
    {
        if (k == 0)
            return 1;
        if (n == 0)
            return 0;
        System.out.println("n:"+n+" ,k:"+k);
        int t= binomial(n-1, k);
        int m= binomial(n-1, k-1);
        return t+m;
    }
    public static int what(Stack<Character> s)
    {
        return  what(s,s.top());
    }

    private static int what(Stack<Character> s, Character tp)
    {
        if(s.isEmpty())
            return 0;
        char x=s.pop();
        int res=what(s,tp);
        if(x!=tp) {
            s.push(x);
        }
        else
            res++;
        return res;
    }
}