package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("called constructor, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //method for start service

    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    //method for when service is ended
    public void disconnect() {
        System.out.println("close " + url);
    }


    public void init() throws Exception {
        connect();
        call("initiate connection message");
    }


    public void close() throws Exception {
        disconnect();
    }
}
