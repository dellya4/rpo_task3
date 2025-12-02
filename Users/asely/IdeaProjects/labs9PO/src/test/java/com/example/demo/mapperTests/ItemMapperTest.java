package com.example.demo.mapperTests;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import com.example.demo.mapper.ItemMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ItemMapperTest {

    @Autowired
    private ItemMapper itemMapper;

    @Test
    void convertEntityTest() {
        Item item = new Item();
        item.setId(1L);
        item.setName("White pineapple");
        item.setPrice(39);
        item.setQuantity(5);

        ItemDto dto = itemMapper.toDto(item);

        Assertions.assertNotNull(dto);

        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getItemName());
        Assertions.assertNotNull(dto.getItemPrice());
        Assertions.assertNotNull(dto.getItemQuantity());

        Assertions.assertEquals(item.getId(), dto.getId());
        Assertions.assertEquals(item.getName(), dto.getItemName());
        Assertions.assertEquals(item.getPrice(), dto.getItemPrice());
        Assertions.assertEquals(item.getQuantity(), dto.getItemQuantity());
    }

    @Test
    void convertDtoTest() {
        ItemDto dto = new ItemDto();
        dto.setId(1L);
        dto.setItemName("White pineapple");
        dto.setItemPrice(39);
        dto.setItemQuantity(5);

        Item item = itemMapper.toEntity(dto);

        Assertions.assertNotNull(item);

        Assertions.assertNotNull(item.getId());
        Assertions.assertNotNull(item.getName());
        Assertions.assertNotNull(item.getPrice());
        Assertions.assertNotNull(item.getQuantity());

        Assertions.assertEquals(item.getId(), dto.getId());
        Assertions.assertEquals(item.getName(), dto.getItemName());
        Assertions.assertEquals(item.getPrice(), dto.getItemPrice());
        Assertions.assertEquals(item.getQuantity(), dto.getItemQuantity());

    }

    @Test
    void convertEntityListTest() {
        List<Item> items = new ArrayList<>();

        Item i1 =  new Item();
        i1.setId(1L);
        i1.setName("White pineapple");
        i1.setPrice(39);
        i1.setQuantity(5);

        Item i2 =  new Item();
        i2.setId(2L);
        i2.setName("Black pineapple");
        i2.setPrice(39);
        i2.setQuantity(5);

        Item i3 =  new Item();
        i3.setId(3L);
        i3.setName("Orange pineapple");
        i3.setPrice(39);
        i3.setQuantity(5);

        items.add(i1);
        items.add(i2);
        items.add(i3);

        List<ItemDto> dtos = itemMapper.toDtoList(items);

        Assertions.assertNotNull(dtos);

        Assertions.assertNotEquals(0, dtos.size());

        Assertions.assertEquals(items.size(), dtos.size());

        for(int i=0; i<items.size(); i++) {
            Item item = items.get(i);
            ItemDto dto = dtos.get(i);

            Assertions.assertNotNull(dto);

            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getItemName());
            Assertions.assertNotNull(dto.getItemPrice());
            Assertions.assertNotNull(dto.getItemQuantity());

            Assertions.assertEquals(item.getId(), dto.getId());
            Assertions.assertEquals(item.getName(), dto.getItemName());
            Assertions.assertEquals(item.getPrice(), dto.getItemPrice());
            Assertions.assertEquals(item.getQuantity(), dto.getItemQuantity());
        }


    }
}