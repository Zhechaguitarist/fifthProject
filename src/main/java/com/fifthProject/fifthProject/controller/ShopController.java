package com.fifthProject.fifthProject.controller;

import com.fifthProject.fifthProject.entity.Shop;
import com.fifthProject.fifthProject.service.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shops")
@AllArgsConstructor
public class ShopController {

    ShopService shopService;

    @PostMapping("create")
    public Long create(@RequestBody Shop shop) {
        return shopService.create(shop);
    }

    @GetMapping("list/read")
    public List<Shop> read() {
        return shopService.read();
    }

    @PutMapping("update")
    public boolean update(@RequestBody Shop shop) {
        return shopService.update(shop);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return shopService.delete(id);
    }
}
