package com.fifthProject.fifthProject.repository;

import ch.qos.logback.core.db.dialect.DBUtil;
import com.fifthProject.fifthProject.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    JdbcTemplate jdbcTemplate;

    @Override
    public Long create(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            final PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO users (name, create_time) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            int idx = 0;
            ps.setString(++idx, user.getName());
            ps.setObject(++idx, OffsetDateTime.now());
            return ps;
        }, keyHolder);
        return (Long) Objects.requireNonNull(keyHolder.getKeys()).get("id");
    }

    @Override
    public List<User> read() {
        return jdbcTemplate.query("SELECT * FROM users", this::extractUser);
    }

    @Override
    public boolean update(User user) {
        return jdbcTemplate.update(
                "UPDATE users SET name = ? WHERE id = ?",
                ps -> {
                    int idx = 0;
                    ps.setString(++idx, user.getName());
                    ps.setLong(++idx, user.getId());
                }) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id = ?", ps -> {
            int idx = 0;
            ps.setLong(++idx, id);
        }) > 0;
    }


    private List<User> extractUser(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            users.add(user);
        }
        return users;
    }
}
