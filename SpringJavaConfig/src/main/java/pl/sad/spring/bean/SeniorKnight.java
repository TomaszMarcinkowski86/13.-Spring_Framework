package pl.sad.spring.bean;

import pl.sad.spring.bean.quest.Quest;

import java.util.List;

public class SeniorKnight implements Knight {

    private String name;
    private List<Quest> quests;

    public SeniorKnight(String name, List<Quest> quests) {
        this.quests = quests;
        this.name = name;
    }

    @Override
    public void embarkQuest() {

        System.out.println("I'm" + name + " and I'm doing .. ");
        quests.forEach(Quest::doQuest);
//      quests.forEach(q->q.doQuest()); jednoznaczne to u góry reference method

    }
}
