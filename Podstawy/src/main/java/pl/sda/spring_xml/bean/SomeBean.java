package pl.sda.spring_xml.bean;

import lombok.ToString;

@ToString  //ja tego nie będzie fajnie wdać scope z xml
public class SomeBean {


    private String name;

    public SomeBean() {
    }

    public SomeBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
