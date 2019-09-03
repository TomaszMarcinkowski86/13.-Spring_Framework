package pl.sda.spring_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.sda.spring_xml.bean.BeanListMy;
import pl.sda.spring_xml.bean.SomeBean2;
import pl.sda.spring_xml.bean.SomeBean3;
import pl.sda.spring_xml.factory.OtherPizza;
import pl.sda.spring_xml.factoryMethod.Pizza;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml" );


//        Object someBean = context.getBean("someBean");
//        System.out.println(someBean);
//        SomeBean someBean2 = context.getBean("someBean2", SomeBean.class);
//        System.out.println(someBean2);
//        SomeBean someBean3 = context.getBean("someBean3", SomeBean.class);
//        System.out.println(someBean3);
//        SomeBean2 someBean4 = context.getBean("someBean4", SomeBean2.class);
//        System.out.println(someBean4);

//        SomeBean someBean = context.getBean("someBean", SomeBean.class);
//        SomeBean someBean2 = context.getBean("someBean", SomeBean.class);
//        SomeBean someBean3 = context.getBean("someBean", SomeBean.class);
//        System.out.println(someBean);
//        System.out.println(someBean2);
//        System.out.println(someBean3);
//        System.out.println();
//
//        // to pokazuje ze bean jest Singletonem - jeden obietk - jak go zmienimy zmieniamy wszędzie.
//        someBean.setName("spring");
//
//        System.out.println(someBean);
//        System.out.println(someBean2);
//        System.out.println(someBean3);
//
//        System.out.println();

        SomeBean3 someBeanThree = context.getBean("someBean3", SomeBean3.class);
        SomeBean3 someBeanThree2 = context.getBean("someBean3", SomeBean3.class);
        System.out.println(someBeanThree);
        System.out.println(someBeanThree2);
        System.out.println();

        SomeBean2 someBeanOld = context.getBean("someBeanOld", SomeBean2.class);
        SomeBean2 someBeanOld2 = context.getBean("someBeanOld2", SomeBean2.class);
        SomeBean2 someBean4 = context.getBean("someBean4", SomeBean2.class);
        System.out.println(someBeanOld);
        System.out.println(someBeanOld2);
        System.out.println(someBean4);
        System.out.println();

        BeanListMy beanListMy =context.getBean("beanListMy", BeanListMy.class);
        System.out.println(beanListMy);


        LocalDate localDate =context.getBean("localDate", LocalDate.class);
        System.out.println(localDate);

        Pizza pizza = context.getBean("myPizza",Pizza.class);
        System.out.println(pizza);

        OtherPizza pizza1 = context.getBean("otherPizza", OtherPizza.class);
        System.out.println(pizza1);

    }
}

