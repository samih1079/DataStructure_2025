package pitron2025_899271;

public class Q10_OOP {

    public class Animal {
        private String color;
        private int weight;

        public Animal(String color, int weight) {
            this.color = color;
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "My color is " + color + "! And I weigh " + weight + " kilos!";
        }
    }

// ---------------------------

    class Bird extends Animal {
        private boolean isFlying;

        public Bird(String color, int weight, boolean isFlying) {
            super(color, weight);
            this.isFlying = isFlying;
        }

        public void zoo() {
            System.out.println("Hello");
        }

        @Override
        public String toString() {
            return "I'm a bird! " + super.toString();
        }
    }

// ---------------------------

    class Parrot extends Bird {
        private boolean isTalking;

        public Parrot(String color, int weight, boolean isFlying, boolean isTalking) {
            super(color, weight, isFlying);
            this.isTalking = isTalking;
        }

        public void zoo() {
            System.out.println("Hello");
        }

        @Override
        public String toString() {
            return "I'm a parrot! My color is " + getColor() + "!";
        }
    }

// ---------------------------

    class Fish extends Animal {
        private String waterType; // sweet or salty

        public Fish(String color, int weight, String waterType) {
            super(color, weight);
            this.waterType = waterType;
        }

        // Inherits toString() from Animal
    }

// ---------------------------

    class Snake extends Animal {
        private int length;
        private boolean isVenomous;

        public Snake(String color, int weight, int length, boolean isVenomous) {
            super(color, weight);
            this.length = length;
            this.isVenomous = isVenomous;
        }

        @Override
        public String toString() {
            String venomText;
            if (isVenomous) {
                venomText = "I'm venomous, be careful! ";
            } else {
                venomText = "I'm not venomous! ";
            }
            return "I'm a snake! " + venomText + super.toString();
        }
    }

// ---------------------------

    public class Tester {
        public void main(String[] args) {
            Animal[] animals = new Animal[5];
            animals[0] = new Bird("white", 4, false);
            animals[1] = new Fish("blue", 3, "sweet water");
            animals[2] = new Parrot("brown", 12, true, true);
            animals[3] = new Snake("gray", 2, 6, true);
            animals[4] = new Snake("black", 3, 4, false);

            // Part (1): Print toString of each animal
            for (int i = 0; i < animals.length; i++) {
                System.out.println(animals[i]);
            }

            // Part (2): Run zoo method if available
            hello(animals);
        }

        public static void hello(Animal[] arr) {
            for (int i = 0; i < arr.length; i++) {
                Animal a = arr[i];

                if (a instanceof Bird) {
                    ((Bird) a).zoo();

                } else {
                    System.out.println("Cannot call zoo on " + a.getClass().getSimpleName() + " - method not defined.");
                }
            }
        }
    }

}
