package pl.sda.spring_xml.bean;

import lombok.ToString;

@ToString
public class SomeBean3 {

    private SomeBean someBean;

    public SomeBean3() {
    }

    public SomeBean3(SomeBean someBean) {
        this.someBean = someBean;
    }

}
