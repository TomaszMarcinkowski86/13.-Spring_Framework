package pl.sda.springmvc.springmvcDemo.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.springmvcDemo.dto.ProductDTO;
import pl.sda.springmvc.springmvcDemo.exception.NotFoundProductException;
import pl.sda.springmvc.springmvcDemo.service.ProductService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/products")
class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping
    public ModelAndView getProductsPage(){
        ModelAndView mnv = new ModelAndView("products");
        mnv.addObject("products", productService.getProducts());
        return mnv;
    }

    @RequestMapping("/{idProduct}")
    public ModelAndView getProductById(
            @PathVariable
                    long idProduct) throws NotFoundProductException {
        ModelAndView modelAndView = new ModelAndView("product");
        ProductDTO productDTO = productService.getProductById(idProduct);
        modelAndView.addObject("product", productDTO);
        return modelAndView;
    }
}