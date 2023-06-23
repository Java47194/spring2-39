package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
 //스프링 컨테이너에 등록된 모든 빈 조회

    AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);
                                                                                  //구성 정보 활용

    @Test
    @DisplayName("모든 빈 조회")
    void findALl(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);

            System.out.println("name =" +beanDefinitionName +"obcect ="+bean);
        }


    }

    @Test
    @DisplayName("애플리케이션 빈 조회")
    void findApplicatin(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition= ac.getBeanDefinition(beanDefinitionName);

            System.out.println("값1 : "+BeanDefinition.ROLE_APPLICATION);
            System.out.println("값2 : "+beanDefinition.getRole());
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name =" +beanDefinitionName +"obcect ="+bean);
            }
        }

    }
}
