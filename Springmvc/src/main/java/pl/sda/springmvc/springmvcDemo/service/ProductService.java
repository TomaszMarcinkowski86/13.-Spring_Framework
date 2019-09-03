package pl.sda.springmvc.springmvcDemo.service;

import pl.sda.springmvc.springmvcDemo.dto.NewProductDTO;
import pl.sda.springmvc.springmvcDemo.dto.ProductDTO;
import pl.sda.springmvc.springmvcDemo.exception.NotFoundProductException;

import java.util.List;

public interface ProductService {

    void addProduct(NewProductDTO newProduct);
    List<ProductDTO> getProducts();
    void remove(long idProduct);
    ProductDTO getProductById(long idProduct)
            throws NotFoundProductException;
}
