package pl.sda.spring_xml.bean;

import lombok.ToString;

import java.util.List;

@ToString
public class BeanListMy {

    private List<String> titles;

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<String> getTitles() {
        return titles;
    }
}
