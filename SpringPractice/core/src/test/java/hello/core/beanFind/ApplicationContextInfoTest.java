package hello.core.beanFind;

import hello.core.order.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Print out all beans")
    void findAllBeans() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            Object bean = ac.getBean(beanDefinitionNames[i]);
            System.out.println("name = " + beanDefinitionNames[i] + " object = " + bean);
        }
    }

    @Test
    @DisplayName("Print out all application bean")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            BeanDefinition bd = ac.getBeanDefinition(beanDefinitionNames[i]);
            if (bd.getRole() == BeanDefinition.ROLE_APPLICATION) {
                //registered bean that for my application
                Object bean = ac.getBean(beanDefinitionNames[i]);
                System.out.println("name = " + beanDefinitionNames[i] + " object = " + bean);
            }
        }
    }

    @Test
    @DisplayName("Print out all Infrastructure bean")
    void findInfraBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            BeanDefinition bd = ac.getBeanDefinition(beanDefinitionNames[i]);
            if (bd.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                //registered bean that for my application
                Object bean = ac.getBean(beanDefinitionNames[i]);
                System.out.println("name = " + beanDefinitionNames[i] + " object = " + bean);
            }
        }
    }
}
