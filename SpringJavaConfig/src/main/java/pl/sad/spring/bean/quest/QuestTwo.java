package pl.sad.spring.bean.quest;

import org.springframework.stereotype.Component;

@Component
public class QuestTwo implements Quest {


    @Override
    public void doQuest() {
        System.out.println("quest 2 ");
    }
}
