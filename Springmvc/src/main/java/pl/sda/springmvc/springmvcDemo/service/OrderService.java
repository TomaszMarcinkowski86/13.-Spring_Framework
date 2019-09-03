package pl.sda.springmvc.springmvcDemo.service;

import pl.sda.springmvc.springmvcDemo.dto.OrderDTO;
import pl.sda.springmvc.springmvcDemo.exception.NotFoundProductException;

import java.util.List;

public interface OrderService {

    void placeOrder(String userName, List<Long> idProducts) throws NotFoundProductException;
            List<OrderDTO> getOrdersByUserLogin (String userlogin);
}
