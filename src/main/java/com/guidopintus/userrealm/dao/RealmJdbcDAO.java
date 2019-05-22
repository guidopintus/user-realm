package com.guidopintus.userrealm.dao;

import com.guidopintus.userrealm.exception.DuplicateRealmNameException;
import com.guidopintus.userrealm.exception.InvalidRealmNameException;
import com.guidopintus.userrealm.exception.RealmNotFoundException;
import com.guidopintus.userrealm.model.RealmModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


@Repository
public class RealmJdbcDAO implements RealmDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Integer add(RealmModel realm) throws DuplicateRealmNameException, InvalidRealmNameException {

        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(realm);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "INSERT INTO realms (name,description,key) values (:name,:description,:key)";
        try {
            jdbcTemplate.update(query, parameterSource, keyHolder);
        } catch (DuplicateKeyException ex) {
            throw new DuplicateRealmNameException();
        }
        return keyHolder.getKey().intValue();
    }

    @Override
    public RealmModel get(Integer id) throws RealmNotFoundException {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
        String query = "SELECT id,name,description,key FROM realms";
        try {
            return jdbcTemplate.queryForObject(query, params, RealmModel.class);
        } catch (EmptyResultDataAccessException ex) {
            throw new RealmNotFoundException();
        }
    }
}
