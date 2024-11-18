package com.sparta.springtest.service;

import com.sparta.springtest.dto.CommonResponseDto;
import com.sparta.springtest.dto.ItemRequestDto;
import com.sparta.springtest.dto.ItemResponseDto;
import com.sparta.springtest.entity.Item;
import com.sparta.springtest.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemResponseDto createItem(ItemRequestDto requestDto) {
        Item item = itemRepository.save(new Item(requestDto));
        return new ItemResponseDto(item);
    }

    public List<ItemResponseDto> getAllImems() {
        return itemRepository.findAll().stream().map(ItemResponseDto::new).toList();
    }

    @Transactional
    public ItemResponseDto updateItem(Long id, ItemRequestDto requestDto) {
        Item item = itemRepository.findById(id).orElseThrow(() ->
                new NullPointerException("해당 아이템을 찾을 수 없습니다.")
        );

        item.update(requestDto);

        return new ItemResponseDto(item);
    }

    public CommonResponseDto deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() ->
                new NullPointerException("해당 아이템을 찾을 수 없습니다.")
        );

        itemRepository.delete(item);

        return new CommonResponseDto("삭제완료");
    }
}
