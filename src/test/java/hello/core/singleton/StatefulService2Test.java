package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;


class StatefulService2Test {

    @Test
    void statefulServiceSingleton2() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(testConfig2.class);
        StatefulService2 statefulService1 = ac.getBean(StatefulService2.class);
        StatefulService2 statefulService2 = ac.getBean(StatefulService2.class);


        int userA = statefulService1.order("userA", 10000);

        int userB = statefulService2.order("userB" , 20000);

        System.out.println("userA= " +userA);
        System.out.println("userB= " +userB);


        assertThat(userA).isEqualTo(10000);


    }

    static class testConfig2{
        @Bean
        public StatefulService2 statefulService2(){
            return new StatefulService2();
        }


    }


}