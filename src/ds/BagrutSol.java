package ds;

public class BagrutSol {
    // badrut 2019, q 6
    public static boolean order(BinNode<Range> tr)
    {
        if(tr==null)
            return true;
        if(tr.hasLeft())
        {
            Range r=tr.getValue();
            Range rL= (Range) tr.getLeft().getValue();
            if(r.getLow()!=rL.getLow() )
                return false;
            if(r.getHigh()<rL.getHigh())
                return false;
        }
        if(tr.hasRight())
        {
            Range r=tr.getValue();
            Range rR= (Range) tr.getRight().getValue();
            if(r.getHigh()!=rR.getHigh() )
                return false;
            if(r.getLow()>rR.getLow())
                return false;
        }
        if(tr.hasLeft() && tr.hasRight())
        {
            Range rL= (Range) tr.getLeft().getValue();
            Range rR= (Range) tr.getRight().getValue();
            if(!(rL.getHigh()<rR.getLow()))//==>   rL.getHigh()>=rR.getLow())
                return  false;
        }
      return  order(tr.getLeft()) && order(tr.getRight()) ;
    }

    // q7 bagrut 2022
    public static String eraseFirst(String str) {
        // Check if the string is null or empty to prevent errors
        if (str == null || str.isEmpty()) {
            return str;
        }
        // substring(1) returns the string starting from the index 1 to the end
        return str.substring(1);
    }
    public static boolean wordFromRoot(BinNode<Character> tr,String str)
    {
        if(str.length()==0) return  true;
        if(tr==null) return false;
        if(tr.getValue()!=str.charAt(0))
            return false;
        else///tr.getValue()==str.charAt(0)
        return wordFromRoot(tr.getLeft(),eraseFirst(str)) || wordFromRoot(tr.getRight(),eraseFirst(str));
    }



    /// the word found entire the route (path)
    public  static  boolean wordFromRoot2(BinNode<Character> tr,String str)
    {
        return wordFromRoot_help(tr,str,0);
    }

    /// the word found entire the route (path)
    public  static  boolean wordFromRoot_help(BinNode<Character> tr,String str,int count )
    {
        if(str.length()==0)
            return true;
        if (tr == null)//
            return false;
        if(count==0)
        {    // the start of the word
            if(tr.getValue()==str.charAt(0))
            {
                return wordFromRoot_help(tr.getLeft(),eraseFirst(str),1)
                        || wordFromRoot_help(tr.getRight(),eraseFirst(str),1);
            }
            else
            {
                return wordFromRoot_help(tr.getLeft(),str,0)
                        || wordFromRoot_help(tr.getRight(),str,0);
            }
        }
        else {
             if(tr.getValue()!=str.charAt(0))
                     return  false;
             else
             {
                 return wordFromRoot_help(tr.getLeft(),eraseFirst(str),1)
                         || wordFromRoot_help(tr.getRight(),eraseFirst(str),1);
             }
        }

    }

    //sol q1.1 bagrut 2025 special
    // מקבלת רשימה ומשספר ומחזירה מספר המופעים של המספר ברשימה
    public static int countVlaue(Node<Integer>lst,int x)
    {
        if(lst==null)
            return 0;
        int count=0;//   عدد ظهولا القيمة في القائمة
        Node<Integer> p=lst;//مؤشر لاول السلسلة
        while(p!=null)
        {
            if(p.getValue()==x)
                count++;
            p=p.getNext();
        }
        return count;
    }

    public static Node<Integer> createUnion(Node<Integer> lst1, Node<Integer> lst2)
    {
            Node<Integer> lst3=new Node<>(lst1.getValue());//=null;   //اضافة في اول القائمة
            //اضافة قيم القائمة 2 للقائمة 3 بدون تكرار
            Node<Integer> p=lst1;
            while (p!=null)
            {
                //المعالجة
                int count=countVlaue(lst3,p.getValue());
                if(count==0)//ان لم تكن القيمة موجودة
                {
                    lst3=new Node<>(p.getValue(),lst3);//اضافة لاول القائمة
                }
                p=p.getNext();//الانتقال للعقدة التالية
            }
        //اضافة قيم القائمة 2 للقائمة 3 بدون تكرار
         p=lst2;
        while (p!=null)
        {
            //المعالجة
            int count=countVlaue(lst3,p.getValue());
            if(count==0)//ان لم تكن القيمة موجودة
            {
                lst3=new Node<>(p.getValue(),lst3);//اضافة لاول القائمة
            }
            p=p.getNext();//الانتقال للعقدة التالية
        }
        return lst3;
    }

    public static Node<Integer> createUnoion2(Node<Integer> lst1, Node<Integer> lst2)
    {
        //اضافة في نهاية القائمة
        //الزامي بناء اول عقدة (ممكن اعطاء قيمة مؤقة وحذف العقدة في النهاية)
        Node<Integer> lst3=new Node<>(lst1.getValue());
        Node<Integer> last=lst3;//مؤشر للعقدة الاخيرة (التي سنضيف بعده)
        Node<Integer> p=lst1;
        while (p!=null)
        {
            //المعالجة
            int count=countVlaue(lst3,p.getValue());
            if(count==0)
            {
                last.setNext(new Node<>(p.getValue()));//اضافة بعد العقدة الاخيرة
                last=last.getNext();// حتلنت المؤشر لياشر على العقدة الاخيرة
            }
            p=p.getNext();
        }
        p=lst2;
        while (p!=null)
        {
            //المعالجة
            int count=countVlaue(lst3,p.getValue());
            if(count==0)
            {
                last.setNext(new Node<>(p.getValue()));//اضافة بعد العقدة الاخيرة
                last=last.getNext();// حتلنت المؤشر لياشر على العقدة الاخيرة
            }
            p=p.getNext();
        }
        return lst3;
    }
    //sol q1.2 bagrut 2025 special
    public static Node<Integer> intsersection(Node<Integer> lst1, Node<Integer> lst2)
    {
        Node<Integer> lst3=null;
        Node<Integer> p=lst1;
        while (p!=null)
        {
            //المعالجة.
            int count=countVlaue(lst2,p.getValue());
            if(count>0)//قيمة من القائمة 1 موجودة في القائمة 2
            {
                lst3=new Node<>(p.getValue(),lst3);//اضافة في اول القائمة
            }
            p=p.getNext();//الانتقال للعقدة التالية
        }

        return lst3;
    }
    //sol q2.1 bagrut 2025 special
    // help method that create copy of the original q
    // تتلقى دورا وتعيد نسخة عنه
    public static  Queue<Integer>  copyQ(Queue<Integer> q)
    {
        Queue<Integer> q1=new Queue<>();
        Queue<Integer> qCopy=new Queue<>();
        //move vlaues to q1 and qCopy
        while (!q.isEmpty())
        {
            q1.insert(q.head());
            qCopy.insert(q.head());
            q.remove();
//            int x= q.remove();
//            q1.insert(x);
//            qcopy.insert(x);
        }
        //return the original values to original q:   q1-->q
        while (!q1.isEmpty())
            q.insert(q1.remove());
        return qCopy;
    }
    public static  boolean isMConnect(Queue<Integer> q1, Queue<Integer> q2, int M)
    {
        // make copy of the both queue
        //to keep the original q1, q1
        Queue<Integer> q1C=copyQ(q1);
        Queue<Integer> q2C=copyQ(q2);
        Stack<Integer> sq1=new Stack<>();
        Stack<Integer> sMq2=new Stack<>();
        //move values q1c ro sq1
        while (!q1C.isEmpty())
            sq1.push(q1C.remove());
        //move first M values from q2c to sMq2
        for(int i=1;i<=M;i++)
            sMq2.push(q2C.remove());

        while (!sMq2.isEmpty())  // for(int i=1;i<=M;i++)
        {
            if(sq1.pop()!=sMq2.pop())
                return false;
            // طريقة 2
//            if(sq1.top()!=sMq2.top())
//                  return false;
//            sq1.pop();
//            sMq2.pop();
        }
        return true;
    }

    // sol q2.2 bagrut 2025 special
    // help  method: Queue size
    public static int sizeQ(Queue<Integer> q)
    {
        Queue<Integer> q2=copyQ(q);
        int count=0;
        while (q2.isEmpty()==false)
        {
            count++;
            q2.remove();
        }
        return count;
    }
    public static  int maxConnect(Queue<Integer> q1, Queue<Integer> q2)
    {
        int max=0;
        int size=sizeQ(q1);
        for(int M=1;M<=size;M++)//==>O(n)
        {
            if(isMConnect(q1,q2,M))//O(n)       =====>O(n)*O(n)=O(n^2)
                max=M;
        }
        return max;

    }

    public static void  reverse(Queue<Integer> q)
    {
        int x=0;
        if(!q.isEmpty())
            x=q.remove();
        reverse(q);
        q.insert(x);
    }



}
