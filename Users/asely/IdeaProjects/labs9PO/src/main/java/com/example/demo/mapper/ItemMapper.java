package com.example.demo.mapper;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Country;
import com.example.demo.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(source = "name", target = "itemName")
    @Mapping(source = "price", target = "itemPrice")
    @Mapping(source = "quantity", target = "itemQuantity")
    @Mapping(source = "manufacturer", target = "manufacturer")
    ItemDto toDto(Item item);

    @Mapping(source = "itemName", target = "name")
    @Mapping(source = "itemPrice", target = "price")
    @Mapping(source = "itemQuantity", target = "quantity")
    @Mapping(source = "manufacturer", target = "manufacturer")
    Item toEntity(ItemDto dto);

    List<ItemDto> toDtoList(List<Item> items);
    List<Item> toEntityList(List<ItemDto> dtoList);

}
