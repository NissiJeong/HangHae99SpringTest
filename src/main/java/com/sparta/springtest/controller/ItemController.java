package com.sparta.springtest.controller;

import com.sparta.springtest.dto.CommonResponseDto;
import com.sparta.springtest.dto.ItemRequestDto;
import com.sparta.springtest.dto.ItemResponseDto;
import com.sparta.springtest.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/post")
    public ItemResponseDto createItem(@RequestBody ItemRequestDto requestDto) {
        return itemService.createItem(requestDto);
    }

    @GetMapping("/post")
    public List<ItemResponseDto> getAllItems() {
        return itemService.getAllImems();
    }

    @PutMapping("/post/{id}")
    public ItemResponseDto updateItem(@PathVariable Long id, @RequestBody ItemRequestDto requestDto) {
        return itemService.updateItem(id, requestDto);
    }

    @DeleteMapping("/post/{id}")
    public CommonResponseDto deleteItem(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }
}
