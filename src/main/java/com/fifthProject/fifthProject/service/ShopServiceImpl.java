package com.fifthProject.fifthProject.service;

import com.fifthProject.fifthProject.entity.Shop;
import com.fifthProject.fifthProject.repository.ShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService {

    ShopRepository shopRepository;

    @Override
    public Long create(Shop shop) {
        return shopRepository.create(shop);
    }

    @Override
    public List<Shop> read() {
        return shopRepository.read();
    }

    @Override
    public boolean update(Shop shop) {
        return shopRepository.update(shop);
    }

    @Override
    public boolean delete(Long id) {
        return shopRepository.delete(id);
    }
}
