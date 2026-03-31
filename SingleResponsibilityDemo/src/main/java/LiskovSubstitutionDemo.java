

class Bird {
    //    public void fly() {
//        System.out.println(" Bird is Flying");
//    }
    public void eat() {
        System.out.println(" Bird is Eating");
    }

}

interface Flyable {
    void fly();
}

class Sparrow extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println(" Sparrow is Flying");
    }
}

class Penguin extends Bird {
    public void swim() {
        System.out.println(" Penguin can swim is Flying");
    }
}

public class LiskovSubstitutionDemo {
    public static void main(String[] args) {
        Bird b1 = new Sparrow();
        Bird b2 = new Penguin();

        b1.eat();
        b2.eat();

        Flyable f1=new Sparrow();
        f1.fly();

        Penguin p= new Penguin();
        p.swim();
    }
}