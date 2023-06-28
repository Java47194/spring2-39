package hello.core.singleton;


//무상태(stateless) 개발
public class StatefulService2 {



    public int order(String name, int price) {
        System.out.println("name = " + name + "  price = " + price);
        return price;
    }


}
