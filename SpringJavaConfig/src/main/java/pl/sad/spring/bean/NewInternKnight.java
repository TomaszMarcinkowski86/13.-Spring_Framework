package pl.sad.spring.bean;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.sad.spring.bean.quest.Quest;

@Component
@ToString
public class NewInternKnight implements Knight{

    private Quest quest;

    @Autowired
    public NewInternKnight( @Qualifier("questTwo") Quest quest) {
        this.quest = quest;
    }

    @Override
    public void embarkQuest() {
        System.out.println("I'm doing ...");
        quest.doQuest();

    }
}
