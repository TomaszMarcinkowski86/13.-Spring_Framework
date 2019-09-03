package pl.sad.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.sad.spring.bean.Knight;
import pl.sad.spring.bean.quest.Quest;


public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class );
//
//      Knight knight = context.getBean("InternKnight1", Knight.class);
//        knight.embarkQuest();
//
//       Knight knight2 = context.getBean("InternKnight2", Knight.class);
//        knight2.embarkQuest();
//
//        Knight knight3 = context.getBean("SeniorKnight1", Knight.class);
//        knight3.embarkQuest();
//        Knight knight4 = context.getBean("SeniorKnight2", Knight.class);
//        knight4.embarkQuest();

        Quest questOne = context.getBean("questOne", Quest.class);
        questOne.doQuest();

        Knight newInternKnight = context.getBean("newInternKnight", Knight.class);
        newInternKnight.embarkQuest();
    }
}
