package com.sparta.springtest.entity;

import com.sparta.springtest.dto.ItemRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "item")
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private int price;

    private String username;

    public Item(ItemRequestDto requestDto) {
        this.id = requestDto.getId();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.price = requestDto.getPrice();
        this.username = requestDto.getUsername();
    }

    public void update(ItemRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.price = requestDto.getPrice();
        this.content = requestDto.getContent();
    }
}
