package pl.sda.spring_xml.factoryMethod;

import lombok.ToString;

@ToString
public class Pizza {

    private String name;

    private Pizza(String name) {
        this.name = name;
    }

    public static Pizza getPizza() {
        return new Pizza("Włoska");
    }

}
