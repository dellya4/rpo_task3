package com.example.demo.service;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Country;
import com.example.demo.entity.Item;
import com.example.demo.mapper.ItemMapper;
import com.example.demo.repository.countryRepository;
import com.example.demo.repository.itemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class itemServiceImpl implements itemService {
    private final itemRepository itemRepository;
    private final countryRepository countryRepository;

    private final ItemMapper itemMapper;

    @Override
    public List<ItemDto> getItems() {
        List<Item> items = itemRepository.findAll();
        return itemMapper.toDtoList(items);
    }

    @Override
    public ItemDto addItem(ItemDto dto) {
        Item i = itemMapper.toEntity(dto);

        if (dto.getManufacturer() != null && dto.getManufacturer().getId() != null) {
            Country c = countryRepository.findById(dto.getManufacturer().getId()).orElse(null);
            if (c == null) {
                return null;
            }
            i.setManufacturer(c);
        }

        itemRepository.save(i);
        return itemMapper.toDto(i);
    }


    @Override
    public ItemDto getItem(Long id) {
        Item item = itemRepository.findById(id).orElse(null);

        if (item == null) {
            return null;
        }

        return itemMapper.toDto(item);
    }

    @Override
    public ItemDto updateItem(Long id, ItemDto dto) {
        Item update = itemRepository.findById(id).orElse(null);
        if (update == null) {
            return null;
        }

        update.setName(dto.getItemName());
        update.setPrice(dto.getItemPrice());
        update.setQuantity(dto.getItemQuantity());

        if (dto.getManufacturer() != null && dto.getManufacturer().getId() != null) {
            Country c = countryRepository.findById(dto.getManufacturer().getId()).orElse(null);
            if (c == null) {
                return null;
            }
            update.setManufacturer(c);
        }

        itemRepository.save(update);
        return itemMapper.toDto(update);
    }


    @Override
    public boolean deleteItem(Long id) {
        ItemDto dto = getItem(id);
        if (dto == null) {
            return false;
        }
        itemRepository.deleteById(id);
        return true;
    }

}
