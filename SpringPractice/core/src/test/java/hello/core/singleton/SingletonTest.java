package hello.core.singleton;

import hello.core.member.MemberService;
import hello.core.order.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {
    @Test
    @DisplayName("Pure DI Container without Spring")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // Search, make an object when it is called.

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        //check through sysout
        System.out.println(memberService1);
        System.out.println(memberService2);

        //memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("using the object that Singleton pattern is appied.")
    void singletonServiceTest() {
        SingletonService ss = SingletonService.getInstance();
        SingletonService ss2 = SingletonService.getInstance();

        assertThat(ss).isSameAs(ss2);
    }

    @Test
    @DisplayName("Spring Container and Singleton")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // Search, make an object when it is called.

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //check through sysout
        System.out.println(memberService1);
        System.out.println(memberService2);

        //memberService1 != memberService2
        assertThat(memberService1).isSameAs(memberService2);
    }
}
