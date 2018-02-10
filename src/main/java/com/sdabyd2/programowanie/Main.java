package com.sdabyd2.programowanie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdabyd2.programowanie.Model.Item;
import com.sdabyd2.programowanie.Model.Order;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException{


        Item item = new Item("mleko","3","TESCO");
        Item item1 = new Item("baton","4","TESCO");
        Item item2 = new Item("gruszki","5","TESCO");


        List<Item> itemList = Arrays.asList(item, item1, item2);

        Order order = new Order(itemList, 1);

        ObjectMapper mapper = new ObjectMapper();
        File fileName = new File ("order.json");
        fileName.createNewFile();
        mapper.writeValue(fileName, order);

        Order readOrders = mapper.readValue(new File("order.json"), Order.class);


        for(Item items: readOrders.getItemList()){
            System.out.println(items.getName());
        }
    }
}
