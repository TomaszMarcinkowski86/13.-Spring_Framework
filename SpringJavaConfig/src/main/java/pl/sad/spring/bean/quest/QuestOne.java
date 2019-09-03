package pl.sad.spring.bean.quest;


import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class QuestOne implements Quest{

    @Override
    public void doQuest() {
        System.out.println("quest 1");
    }
}
