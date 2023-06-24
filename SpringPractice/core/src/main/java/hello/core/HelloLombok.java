package hello.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class HelloLombok {

    //Lombok makes setter, getter Automatically. (Even constructor, toString)

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        String name = helloLombok.getName();
    }

}
