package pitron2025_899271;

import ds.Node;

public class Q1 {
    class Game {
        private String name;
        private int price;

        public Game(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    }

    class Strore {
        private Node<Game> lst;

        public Strore() {
            this.lst = null;
        }

        public int removeGamesByPrice(int price, int count) {
            Node<Game> current = lst;
            Node<Game> prev = null;
            int removed = count;
            while (current != null && count > 0) {
                if (current.getValue().getPrice() == price) {
                    if (prev == null) { // Removing head
                        lst = current.getNext();
                    } else {
                        prev.setNext(current.getNext());
                    }
                    count--;
                } else {
                    prev = current;
                }
                current = current.getNext();
            }
            return removed - count;
        }


        public int getCheapestPrice() {
            int minPrice = Integer.MAX_VALUE;
            Node<Game> current = lst;
            while (current != null) {
                if (current.getValue().getPrice() < minPrice) {
                    minPrice = current.getValue().getPrice();
                }
                current = current.getNext();
            }
            return minPrice;
        }

        public int removeCheapestGames(int num) {
            int sum = 0;
            while (num > 0) {
                int minPrice = getCheapestPrice();
                int removed = removeGamesByPrice(minPrice, num);
                sum += removed * minPrice;
                num -= removed;
            }
            return sum;
        }


//        public int removeCheapestGames(int num) {
//            int minPrice = Integer.MAX_VALUE;
//            Node<Game> current = lst;
//            while (current != null) {
//                if (current.getValue().getPrice() < minPrice) {
//                    minPrice = current.getValue().getPrice();
//                }
//                current = current.getNext();
//            }
//
//            int removedPrice = removeGamesByPrice(minPrice, num);
//            return removedPrice * minPrice;
//        }
    }

}
