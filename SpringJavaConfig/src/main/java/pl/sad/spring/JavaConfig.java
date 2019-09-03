package pl.sad.spring;

import lombok.ToString;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ToString
@Configuration
@ComponentScan("pl.sad.spring")
public class JavaConfig {

//    @Bean
//    public Quest questOne(){
//        return new QuestOne();
//    }
//    @Bean
//    public Quest questTwo(){
//        return new QuestTwo();
//    }
//    @Bean
//    public Quest questThree(){
//        return new QuestThree();
//    }
//
//    @Bean(name = "InternKnight1") // normalnie jak nie ma teo name to bean nazywa się jak metoda czyli getKnight
//    public Knight someIntern1(@Qualifier("questOne") Quest quest) {
//        return new InternKnight(" Jonh", quest);
//    }
//
//    @Bean(name = "InternKnight2")
//    public Knight someIntern2(@Qualifier("questThree") Quest quest) {
//        return new InternKnight(" Tom", quest);
//    }
//
//    @Bean(name="SeniorKnight1")
//    public Knight someSenior(List<Quest> quests){
//        return new SeniorKnight(" Don Kichot", quests);
//    }
//
//    @Bean(name="SeniorKnight2")
//    public Knight someSenior2(@Qualifier("questOne") Quest questOne,
//                              @Qualifier("questThree") Quest questThree ){
//        List<Quest> quests1 = Arrays.asList(questOne,questThree);
//        return new SeniorKnight(" Don Amigos", quests1);
//    }


}

