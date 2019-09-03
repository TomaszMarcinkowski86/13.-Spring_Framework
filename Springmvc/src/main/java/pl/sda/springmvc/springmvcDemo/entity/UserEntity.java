package pl.sda.springmvc.springmvcDemo.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "User_")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String login;
    private String password;

    @OneToMany(mappedBy = "user")
    List<OrderEntity> orders;

    @ManyToMany
    private Set<RoleEntity> roles = new HashSet<>();

}
