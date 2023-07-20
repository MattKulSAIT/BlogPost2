package com.BlogDemo.BlogDemo2.api;

import com.BlogDemo.BlogDemo2.Model.Item;
import com.BlogDemo.BlogDemo2.Model.User;
import com.BlogDemo.BlogDemo2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/ListManager")
@RestController
public class BlogDemoController {

    @Autowired
    UserService userService = new UserService();

    @GetMapping(path = "{yourName}")
    public ArrayList<Item> getItemList(@PathVariable String yourName) {
        return userService.getItems(yourName);
    }

    @PostMapping(path = "{item}/{yourName}")
    public String addItem(@PathVariable String item, @PathVariable String yourName){
        userService.addItem(item, yourName);
        return "Item added to your List";
    }

    @DeleteMapping(path = "{item}/{yourName}")
    public String removeItem(@PathVariable String item, @PathVariable String yourName){
        return userService.removeItem(item, yourName);
    }
}
