package pl.sda.springmvc.springmvcDemo.dto;


import lombok.*;

import java.math.BigDecimal;

@Data
public class NewProductDTO {

    private String name;
    private BigDecimal price;
}
