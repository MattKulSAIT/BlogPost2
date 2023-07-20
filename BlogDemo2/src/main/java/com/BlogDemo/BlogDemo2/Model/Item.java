package com.BlogDemo.BlogDemo2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Item {
    public Item(){

    }

    @Id
    private String itemName;
    private String ownersName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }
}
