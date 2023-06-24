package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
        //to prevent new SingletonService();
    }

    public void logic() {
        System.out.println("Singleton Object Logic is called.");
    }


}
