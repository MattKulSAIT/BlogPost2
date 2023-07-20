package com.BlogDemo.BlogDemo2.Repository;

import com.BlogDemo.BlogDemo2.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, String>{
    @Query("SELECT i FROM Item i WHERE i.ownersName = ?1")
    Optional<ArrayList<Item>> getYourItems(String yourName);

    @Query("SELECT i FROM Item i WHERE i.itemName = ?1")
    Optional<Item> findByItemName(String itemName);
}