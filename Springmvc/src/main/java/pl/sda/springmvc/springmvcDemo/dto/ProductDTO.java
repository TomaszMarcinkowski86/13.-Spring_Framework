package pl.sda.springmvc.springmvcDemo.dto;


import lombok.*;
import pl.sda.springmvc.springmvcDemo.entity.ProductEntity;

import java.math.BigDecimal;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private long id;
    private String name;
    private BigDecimal price;

    public  ProductDTO (ProductEntity productEntity){
        this.id= productEntity.getId();
        this.name= productEntity.getName();
        this.price= productEntity.getPrice();

    }
}
