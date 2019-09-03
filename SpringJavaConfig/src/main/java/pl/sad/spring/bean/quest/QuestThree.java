package pl.sad.spring.bean.quest;


import org.springframework.stereotype.Component;

@Component
public class QuestThree implements Quest{


    @Override
    public void doQuest() {
        System.out.println("quest 3");
    }
}
