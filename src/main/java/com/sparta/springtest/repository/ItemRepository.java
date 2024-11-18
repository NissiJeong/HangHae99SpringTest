package com.sparta.springtest.repository;

import com.sparta.springtest.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
