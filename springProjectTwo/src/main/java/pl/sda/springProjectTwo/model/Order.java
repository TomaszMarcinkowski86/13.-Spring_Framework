package pl.sda.springProjectTwo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ORDER_")
@Setter
@Getter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany(mappedBy = "orders")
    List<Product> products = new ArrayList<>();

    private LocalDateTime creationTime = LocalDateTime.now();

    public Order(User user) {
        this.user = user;
    }
}
