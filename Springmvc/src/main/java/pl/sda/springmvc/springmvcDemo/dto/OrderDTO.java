package pl.sda.springmvc.springmvcDemo.dto;

import lombok.Data;
import pl.sda.springmvc.springmvcDemo.entity.OrderEntity;
import pl.sda.springmvc.springmvcDemo.mapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class OrderDTO {


    private Long id;
    private LocalDateTime creationTime;
    private List<ProductDTO> products = new ArrayList<>();
    public OrderDTO(OrderEntity orderEntity){
        this.id = orderEntity.getId();
        this.creationTime=orderEntity.getCreationTime();
        this.products=orderEntity
                .getProducts()
                .stream()
                .map(x-> ModelMapper.map(x))
                .collect(Collectors.toList());
    }

}
