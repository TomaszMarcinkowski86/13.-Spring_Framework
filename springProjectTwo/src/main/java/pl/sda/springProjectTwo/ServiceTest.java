package pl.sda.springProjectTwo;

import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.springProjectTwo.model.Bid;
import pl.sda.springProjectTwo.model.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sound.midi.Soundbank;

@Service
public class ServiceTest {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void persist(){
        Item item =new Item();
        em.persist(item);
        Bid bid1 = new Bid ("SB1");
        em.persist(bid1);
        Bid bid2 = new Bid ("SB2");
        em.persist(bid2);
        Bid bid3 = new Bid ("SB3");
        em.persist(bid3);
        item.getBids().add(bid1);
        item.getBids().add(bid2);
        item.getBids().add(bid3);
    }

    @Transactional
    public void delete(){
        System.out.println("-----DELETE--------");
        Item item= em.find(Item.class, 1L);
        Bid bid= em.find(Bid.class, 1L);
        System.out.println("-------TEST--------");
        item.getBids().remove(bid);
    }

    @Transactional
    public void updateCollection(){
        System.out.println("-----UPDATE COLLECTION--------");
        Item item= em.find(Item.class, 1L);
        Bid bid= new Bid();
        em.persist(bid);
        item.getBids().add(bid);
    }
}
