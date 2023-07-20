package com.BlogDemo.BlogDemo2.services;

import com.BlogDemo.BlogDemo2.Model.Item;
import com.BlogDemo.BlogDemo2.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    public UserService(){
    }

    @Autowired
    private ItemRepository itemRepository;

    /**
     * Method to get all the items in the list
     * @return Arraylist Object with all your items
     */
    public ArrayList<Item> getItems(String yourName) {
        Optional<ArrayList<Item>> optionalItems = itemRepository.getYourItems(yourName);
        return optionalItems.orElse(new ArrayList<>());
    }

    /**
     * Method to add a new Item to the list
     * @param itemName the name of the Item to add
     */
    public void addItem(String itemName, String yourName){
        Item i = new Item();
        i.setItemName(itemName);
        i.setOwnersName(yourName);
        itemRepository.save(i);
    }

    /**
     * Method to remove Item
     * @param itemName the name of the Item to remove
     */
    public String removeItem(String itemName, String yourName) {
        Optional<Item> optionalItem = itemRepository.findByItemName(itemName);
        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            if(item.getOwnersName().equals(yourName)) {
                itemRepository.delete(item);
                return "Item was Removed";
            }
            else{
                return "Item Not Yours";
            }
        } else {
            return "Item doesn't exist";
        }
    }
}
