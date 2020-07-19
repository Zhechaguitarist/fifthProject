package com.fifthProject.fifthProject.repository;

import com.fifthProject.fifthProject.entity.Shop;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@AllArgsConstructor
public class ShopRepositoryImpl implements ShopRepository {

    JdbcTemplate jdbcTemplate;

    @Override
    public Long create(Shop shop) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            final PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO shops (name, address, create_time, seller_id) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            int idx = 0;
            ps.setString(++idx, shop.getName());
            ps.setString(++idx, shop.getAddress());
            ps.setObject(++idx, OffsetDateTime.now());
            ps.setLong(++idx, shop.getSellerId());
            return ps;
        }, keyHolder);
        return (Long) Objects.requireNonNull(keyHolder.getKeys()).get("id");
    }

    @Override
    public List<Shop> read() {
        return jdbcTemplate.query("SELECT * FROM shops", rs -> {
            List<Shop> shops = new ArrayList<>();
            while (rs.next()) {
                shops.add(extractShop(rs));
            }
            return shops;
        });
    }

    @Override
    public boolean update(Shop shop) {
        return jdbcTemplate.update(
                "UPDATE shops SET name = ?, address = ?, seller_id = ? WHERE id = ?",
                ps -> {
                    int idx = 0;
                    ps.setString(++idx, shop.getName());
                    ps.setString(++idx, shop.getAddress());
                    ps.setLong(++idx, shop.getSellerId());
                    ps.setLong(++idx, shop.getId());
                }) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return jdbcTemplate.update("DELETE FROM shops WHERE id = ?", ps -> {
            int idx = 0;
            ps.setLong(++idx, id);
        }) > 0;
    }

    private Shop extractShop(ResultSet rs) throws SQLException {
        Shop shop = new Shop();
        shop.setName(rs.getString("name"));
        shop.setAddress(rs.getString("address"));
        shop.setSellerId(rs.getLong("seller_id"));
        return shop;
    }
}
