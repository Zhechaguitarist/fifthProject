package com.fifthProject.fifthProject.service;

import com.fifthProject.fifthProject.entity.Shop;

import java.util.List;

public interface ShopService {

    Long create(Shop shop);

    List<Shop> read();

    boolean update(Shop shop);

    boolean delete(Long id);
}
