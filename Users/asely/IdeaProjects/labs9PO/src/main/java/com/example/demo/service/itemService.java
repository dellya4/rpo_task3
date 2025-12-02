package com.example.demo.service;

import com.example.demo.dto.ItemDto;

import java.util.List;

public interface itemService {
    List<ItemDto> getItems();
    ItemDto addItem(ItemDto dto);
    ItemDto getItem(Long id);
    ItemDto updateItem(Long id, ItemDto dto);
    boolean deleteItem(Long id);
}
