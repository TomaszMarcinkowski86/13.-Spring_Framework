package pl.sda.springmvc.springmvcDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.springmvcDemo.component.ShopCart;
import pl.sda.springmvc.springmvcDemo.exception.NotFoundProductException;

import java.security.Principal;

@Controller
@RequestMapping("/shopcart")
public class ShopCartController {

    private final ShopCart shopCart;


//    @Autowired
    ShopCartController(ShopCart shopCart) {
        this.shopCart = shopCart;

    }

    @RequestMapping
    public ModelAndView getShopCartPage() {
        ModelAndView mnv = new ModelAndView("shopcart");
        mnv.addObject("products", shopCart.getProducts());
        return mnv;
    }

    @RequestMapping("/addproduct/{idProduct}")
    public ModelAndView addProductToShopCart(@PathVariable long idProduct) throws NotFoundProductException {
        shopCart.addProduct(idProduct);
        return new ModelAndView("redirect:/shopcart");
    }
    @RequestMapping("/placeorder")
    public ModelAndView placeOrder(Principal principal) throws NotFoundProductException {
        shopCart.placeOrder(principal.getName());
        return new ModelAndView("redirect:/shopcart");
    }


}
