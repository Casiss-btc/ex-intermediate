package com.example.exintermediate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.exintermediate.domain.Team;

@Repository
public class TeamRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;
    private static final RowMapper<Team> TEAM_ROW_MAPPER
     = new BeanPropertyRowMapper<>(Team.class);
     public List<Team> findAll() {
        String sql = "SELECT * FROM teams ORDER BY id";
        List<Team> teams = template.query(sql, TEAM_ROW_MAPPER);
        return teams;
     }
     public Team load(Integer id) {
        String sql = "SELECT * FROM teams WHERE id = :id";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
        return team;
     }
}
