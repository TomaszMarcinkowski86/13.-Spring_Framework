package pl.sda.springmvc.springmvcDemo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
//@EqualsAndHashCode
@Builder
@Entity
@Table(name = "ORDER_")
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;

   private LocalDateTime creationTime = getCreationTime().now();

   @ManyToMany(mappedBy = "orders")
   private Set<ProductEntity> products = new HashSet<>();

   @ManyToOne(fetch = FetchType.LAZY)
   private UserEntity user;

}
