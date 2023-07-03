package hello.core;

import lombok.Data;

@Data
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setAge(17);
        helloLombok.setName("이용호");


        String name1 = helloLombok.getName();
        int age1 = helloLombok.getAge();

        System.out.println("age1 = " + age1);
        System.out.println("name1 = " + name1);
    }


}
