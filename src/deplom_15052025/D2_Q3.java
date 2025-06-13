package deplom_15052025;

import ds.Node;
import ds.Queue;

public class D2_Q3
{

    class Short{
        private int id;//
        private String url;//  ‏رابط الفيلم القصير‏
        private int seen;//‏عدد المشاهدات
        private int suitability;//‏   ‏درجة الملائمة للمشاهد من 0 حتى 10 بحيث أن 10 ملائم جدا ‏
//constructor / setters /getters
        private int suitability;//‏   ‏درجة الملائمة للمشاهد من 0 حتى 10 بحيث أن 10 ملائم جدا ‏

        public Short(int id, String url, int seen, int suitability)
        {
            this.id = id;
            this.url = url;
            this.seen = seen;
            this.suitability = suitability;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getSeen() {
            return seen;
        }

        public void setSeen(int seen) {
            this.seen = seen;
        }

        public int getSuitability() {
            return suitability;
        }

        public void setSuitability(int suitability) {
            this.suitability = suitability;
        }
    }
    class YTBAcount{
        private String email;
        private Queue<Short> shorts;
        private Node<Short> shortsList;
        public void addShort(Short s){
            if(shorts.isEmpty() ){
                shorts.insert(s);
            }else{
                Queue<Short> temp=new Queue<>();
                while(!shorts.isEmpty() && shorts.head().getSuitability()>=s.suitability){
                    temp.insert(shorts.remove());
                }
                temp.insert(s);
                while (!shorts.isEmpty())
                    temp.insert(shorts.remove());
                while(!temp.isEmpty()){
                    shorts.insert(temp.remove());
                }
            }
        }

        public Short removeFirstShort(){
            if(shorts.isEmpty()) return null;
            return shorts.remove();
        }
public void incSuitability(int shortId) {
    if (shorts.isEmpty()) {
        Queue<Short> temp = new Queue<>();
        Short target = null;

        // ابحث عن ال   مع رقم التعريف المحدد وأزلها
        while (!shorts.isEmpty()) {
            Short s = shorts.remove();
            if (s.getId() == shortId) {
                s.setSuitability(s.getSuitability() + 1); // تعديل درجة الملائمة
                target = s;// الفيلم الذي تم تعديله لا يرجع للدور
            } else {
                temp.insert(s);
            }
        }
        // استعادة الدور الأصلي
        while (!temp.isEmpty()) {
            shorts.insert(temp.remove());
        }
        // اضافة الفيلم الذي تم تعديله
        addShort(target);

    }
}
//        public void addShortToSortedList(Short s){
//            if(shortsList == null){
//                shortsList = new Node<>(s);
//            }else{
//                Node<Short> p = shortsList;
//                Node<Short> prev = null;
//                while(p != null && p.getValue().getSuitability() > s.getSuitability()){
//                    prev = p;
//                    p = p.getNext();
//                }
//                Node<Short> t = new Node<>(s, p);
//                if(prev == null){
//                    shortsList = t;
//                }else{
//                    prev.setNext(t);
//                }
//            }
//        }
        public YTBAcount(String url)
        {
            this.email = url;
            this.shorts = new Queue<>();
        }

        public String getUrl() {
            return email;
        }

        public Queue<Short> getShorts() {
            return shorts;
        }


}
