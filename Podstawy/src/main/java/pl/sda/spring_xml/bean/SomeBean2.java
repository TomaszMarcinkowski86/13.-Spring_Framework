package pl.sda.spring_xml.bean;

import lombok.ToString;

@ToString
public class SomeBean2 {

    private String name;
    private int age;

    public SomeBean2() {
    }

    public SomeBean2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
