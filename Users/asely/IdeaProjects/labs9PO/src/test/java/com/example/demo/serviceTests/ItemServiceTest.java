package com.example.demo.serviceTests;

import com.example.demo.dto.ItemDto;
import com.example.demo.service.itemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class ItemServiceTest {

    @Autowired
    private itemService itemService;

    @Test
    void getItemsTest() {
        List<ItemDto> dtos = itemService.getItems();

        Assertions.assertNotNull(dtos);

        Assertions.assertNotEquals(0, dtos.size());

        for (ItemDto dto : dtos) {
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getItemName());
            Assertions.assertNotNull(dto.getItemPrice());
            Assertions.assertNotNull(dto.getItemQuantity());
        }
    }

    @Test
    void getItemByIdTest() {
        Random random = new Random();
        int randomIndex  = random.nextInt(itemService.getItems().size());

        Long randomItem =  itemService.getItems().get(randomIndex).getId();

        ItemDto dto = itemService.getItem(randomItem);

        Assertions.assertNotNull(dto);

        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getItemName());
        Assertions.assertNotNull(dto.getItemPrice());
        Assertions.assertNotNull(dto.getItemQuantity());

        ItemDto errorItem = itemService.getItem(-1L);
        Assertions.assertNull(errorItem);
    }

    @Test
    void addItemTest() {
        ItemDto dto = new ItemDto();
        dto.setItemName("test");
        dto.setItemPrice(30);
        dto.setItemQuantity(10);

        ItemDto createdItem = itemService.addItem(dto);

        Assertions.assertNotNull(createdItem);

        Assertions.assertNotNull(createdItem.getId());
        Assertions.assertNotEquals(0L, createdItem.getId());

        Assertions.assertNotNull(createdItem.getItemName());
        Assertions.assertNotNull(createdItem.getItemPrice());
        Assertions.assertNotNull(createdItem.getItemQuantity());

        Assertions.assertEquals(createdItem.getItemName(), dto.getItemName());
        Assertions.assertEquals(createdItem.getItemPrice(), dto.getItemPrice());
        Assertions.assertEquals(createdItem.getItemQuantity(), dto.getItemQuantity());

        ItemDto check = itemService.getItem(createdItem.getId());

        Assertions.assertNotNull(check);
        Assertions.assertNotNull(check.getId());
        Assertions.assertNotNull(check.getItemName());
        Assertions.assertNotNull(check.getItemPrice());
        Assertions.assertNotNull(check.getItemQuantity());

        Assertions.assertEquals(createdItem.getId(), check.getId());
        Assertions.assertEquals(createdItem.getItemName(), check.getItemName());
        Assertions.assertEquals(createdItem.getItemPrice(), check.getItemPrice());
        Assertions.assertEquals(createdItem.getItemQuantity(), check.getItemQuantity());

    }

    @Test
    void updateItemTest() {
        Random random = new Random();
        int randomIndex  = random.nextInt(itemService.getItems().size());

        Long randomItem =  itemService.getItems().get(randomIndex).getId();

        ItemDto dto = new ItemDto();
        dto.setItemName("test2");
        dto.setItemPrice(40);
        dto.setItemQuantity(5);

        ItemDto updatedItem = itemService.addItem(dto);
        Assertions.assertNotNull(updatedItem);

        Assertions.assertNotNull(updatedItem.getId());
        Assertions.assertNotNull(updatedItem.getItemName());
        Assertions.assertNotNull(updatedItem.getItemPrice());
        Assertions.assertNotNull(updatedItem.getItemQuantity());

        Assertions.assertEquals(updatedItem.getId(), dto.getId());
        Assertions.assertEquals(updatedItem.getItemName(), dto.getItemName());
        Assertions.assertEquals(updatedItem.getItemPrice(), dto.getItemPrice());
        Assertions.assertEquals(updatedItem.getItemQuantity(), dto.getItemQuantity());

        ItemDto check = itemService.getItem(updatedItem.getId());

        Assertions.assertNotNull(check);
        Assertions.assertNotNull(check.getId());
        Assertions.assertNotNull(check.getItemName());
        Assertions.assertNotNull(check.getItemPrice());
        Assertions.assertNotNull(check.getItemQuantity());

        Assertions.assertEquals(updatedItem.getId(), check.getId());
        Assertions.assertEquals(updatedItem.getItemName(), check.getItemName());
        Assertions.assertEquals(updatedItem.getItemPrice(), check.getItemPrice());
        Assertions.assertEquals(updatedItem.getItemQuantity(), check.getItemQuantity());

        ItemDto errorItem = itemService.getItem(-1L);
        Assertions.assertNull(errorItem);
    }

    @Test
    void deleteItemTest() {
        Random random = new Random();
        int randomIndex  = random.nextInt(itemService.getItems().size());

        Long randomItem =  itemService.getItems().get(randomIndex).getId();

        boolean deleted = itemService.deleteItem(randomItem);
        Assertions.assertTrue(deleted);

        ItemDto check = itemService.getItem(randomItem);
        Assertions.assertNull(check);

        boolean errorDeleted = itemService.deleteItem(-1L);
        Assertions.assertFalse(errorDeleted);
    }

}
