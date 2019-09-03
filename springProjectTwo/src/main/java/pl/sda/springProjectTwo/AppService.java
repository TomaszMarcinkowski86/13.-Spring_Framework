package pl.sda.springProjectTwo;

import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.springProjectTwo.model.Order;
import pl.sda.springProjectTwo.model.Product;
import pl.sda.springProjectTwo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.SortedMap;

@Service
public class AppService {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void persist() {
        System.out.println("-------Persist User---------");
        User user1 = new User("Tomek", "Marcinkowski");
        User user2 = new User("Jonh", "Smith");
        User user3 = new User("Shrek", "Wilko");
        User user4 = new User("xxx", "Rozrabiaka");
        User user5 = new User("Neo", "Marix");
        em.persist(user1);
        em.persist(user2);
        em.persist(user3);
        em.persist(user4);
        em.persist(user5);
    }

    @Transactional
    public void addUserOrder(){
        System.out.println("-------Add user order-----------");
        User user = em.find(User.class, 3l);
        em.persist(user);
        Order order = new Order(user);
        em.persist(order);
        user.getOrders().add(order);
    }
    @Transactional
    public void manyToManyPersist(){
        Product product1 = new Product("Produkt1", BigDecimal.valueOf(100));
        Product product2 = new Product("Produkt2", BigDecimal.valueOf(200));
        Product product3 = new Product("Produkt3", BigDecimal.valueOf(120));
        Product product4 = new Product("Produkt4", BigDecimal.valueOf(111));
        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
        em.persist(product4);

        User user =em.find(User.class, 1L);
        Order order = new Order(user);
        order.getProducts().add(product1);
        order.getProducts().add(product2);
        order.getProducts().add(product3);
        order.getProducts().add(product4);

        em.persist(order);
    }

    @Transactional
    public void remove(){
        System.out.println("------------REMOVE MANY TO MANY-----------");
        Product product = em.find(Product.class, 2L);
        Order order =em.find(Order.class, 2L);
        System.out.println("FIND ORDER");
        product.getOrders().remove(order);

    }

    @Transactional
    public void update(){
        System.out.println("--------Updade Many To Many -----------");
        Order order = em.find(Order.class, 2L);
        Product product = new Product("Test1", BigDecimal.valueOf(123));
        em.persist(product);
        order.getProducts().add(product);
        product.getOrders().add(order);
    }

    public void deleteOneToMany(){
        User user = new User("test", "Test");
        em.persist(user);
        Order order1 = new Order(user);
        em.persist(order1);
        Order order2 = new Order(user);
        em.persist(order2);
        Order order3 = new Order(user);
        em.persist(order3);
        Order order4 = new Order(user);
        em.persist(order4);

        user.getOrders().add(order1);
        user.getOrders().add(order2);
        user.getOrders().add(order3);
        user.getOrders().add(order4);

        System.out.println("----TEST----------");
        Order remove = user.getOrders().remove(0);
        System.out.println("-------test--------");
        em.remove(remove);

    }
}

