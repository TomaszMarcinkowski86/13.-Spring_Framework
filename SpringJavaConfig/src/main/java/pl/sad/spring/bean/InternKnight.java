package pl.sad.spring.bean;

import lombok.ToString;
import pl.sad.spring.bean.quest.Quest;

@ToString
public class InternKnight implements Knight {

    private  String name;
    private Quest quest;

    public InternKnight(String name, Quest quest) {
        this.name = name;
        this.quest = quest;
    }

    @Override
    public void embarkQuest() {
        System.out.println("I'm" + name+ " and I'm doing ...");
        quest.doQuest();

    }
}

