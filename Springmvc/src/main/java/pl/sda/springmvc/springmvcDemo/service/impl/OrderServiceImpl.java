package pl.sda.springmvc.springmvcDemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.springmvc.springmvcDemo.dto.OrderDTO;
import pl.sda.springmvc.springmvcDemo.entity.OrderEntity;
import pl.sda.springmvc.springmvcDemo.entity.ProductEntity;
import pl.sda.springmvc.springmvcDemo.entity.UserEntity;
import pl.sda.springmvc.springmvcDemo.mapper.ModelMapper;
import pl.sda.springmvc.springmvcDemo.repository.OrderRepository;
import pl.sda.springmvc.springmvcDemo.repository.ProductRepository;
import pl.sda.springmvc.springmvcDemo.repository.UserRepository;
import pl.sda.springmvc.springmvcDemo.service.OrderService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private  final UserRepository userRepository;

//    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void placeOrder(String login,List<Long> idProducts) {
        System.out.println(login);
        OrderEntity orderEntity = new OrderEntity();
        Optional<UserEntity> byLogin = userRepository.findByLogin(login);
        UserEntity user =byLogin.orElseThrow(()->new UsernameNotFoundException( "Not found user with login: "+ login));
        user.getOrders().add(orderEntity);
        orderEntity.setUser(user);
        List<ProductEntity> products = idProducts
                .stream()
                .map(id->productRepository.getOne(id))
                .collect(Collectors.toList());

       for (ProductEntity productEntity : products){
           productEntity.getOrders().add(orderEntity);
       }
        orderRepository.save(orderEntity);
    }

    @Override
    public List<OrderDTO> getOrdersByUserLogin(String userlogin) {
        List<OrderEntity> byUserLogin = orderRepository.findByUser_Login(userlogin);
        return byUserLogin
                .stream()
                .map(ModelMapper::map)
                .collect(Collectors.toList());
    }
}

