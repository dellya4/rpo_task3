package com.example.demo.dto;

import com.example.demo.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ItemDto {
    Long id;
    String itemName;
    int itemPrice;
    int itemQuantity;
    Country manufacturer;
}
