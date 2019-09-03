package pl.sda.spring_xml.factory;

import lombok.ToString;

@ToString
public class PizzaFactory {
    public OtherPizza getInstance(){
        return new OtherPizza();
    }
}
