package com.example.exintermediate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.exintermediate.domain.Hotel;

@Repository
public class HotelRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;
    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER
    = new BeanPropertyRowMapper<>(Hotel.class);
    public List<Hotel> findByPrice(Integer price) {
        String sql = "SELECT * FROM hotels WHERE price <= :price";
        SqlParameterSource param = new MapSqlParameterSource().addValue("price",price);
        List<Hotel> hotels = template.query(sql, param, HOTEL_ROW_MAPPER);
        return hotels;
    }
}
