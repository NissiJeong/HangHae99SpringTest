package com.sparta.springtest.dto;

import com.sparta.springtest.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemResponseDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public ItemResponseDto(Item item){
        this.id = item.getId();
        this.title = item.getTitle();
        this.content = item.getContent();
        this.price = item.getPrice();
        this.username = item.getUsername();
    }
}
