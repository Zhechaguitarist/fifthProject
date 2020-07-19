package com.fifthProject.fifthProject.repository;

import com.fifthProject.fifthProject.entity.Shop;

import java.util.List;

public interface ShopRepository {

    Long create(Shop shop);

    List<Shop> read();

    boolean update(Shop shop);

    boolean delete(Long id);
}
