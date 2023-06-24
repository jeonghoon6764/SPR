package hello.core.singleton;

public class StatefulService {

    //private int price; // save state

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        //this.price = price; // <- this will make problem

        return price;
    }

    //public int getPrice() {
    //    return price;
    //}
}
