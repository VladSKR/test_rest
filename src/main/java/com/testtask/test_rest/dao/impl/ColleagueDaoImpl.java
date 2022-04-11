package com.testtask.test_rest.dao.impl;

import com.testtask.test_rest.dao.ColleagueDao;
import com.testtask.test_rest.model.Colleague;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ColleagueDaoImpl implements ColleagueDao {

    private static final String SELECT_COLLEAGUES = "SELECT * FROM colleagues";
    private static final String SELECT_COLLEAGUE_BY_ID = "SELECT * FROM colleagues WHERE id = ?";
    private static final String ADD_COLLEAGUE = "INSERT INTO colleagues (id, firstname, fathersname, lastname, jobposition, dateofbirth, city) " +
            "VALUES (nextval('colleagues_id_seq'), :firstname, :fathersname, :lastname, :jobposition, :dateofbirth, :city)";

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;

    /**
     * Create new colleague
     *
     * @param colleague
     */
    @Override
    public Long createColleague(Colleague colleague) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("firstname", colleague.getFirstName())
                .addValue("lastname", colleague.getLastName())
                .addValue("fathersname", colleague.getFathersName())
                .addValue("jobposition", colleague.getJobPosition())
                .addValue("dateofbirth", colleague.getDateOfBirth())
                .addValue("city", colleague.getCity());

        namedParameterJdbcOperations.update(ADD_COLLEAGUE, params, keyHolder, new String[]{"id"});
        return keyHolder.getKey().longValue();
    }

    /**
     * Update colleague
     *
     * @param colleague
     */
    @Override
    public void updateColleague(Colleague colleague) {

    }

    /**
     * Remove colleague
     *
     * @param colleagueId
     */
    @Override
    public void removeColleague(Long colleagueId) {

    }

    /**
     * Read colleague
     *
     * @param colleagueId
     */
    @Override
    public void readColleague(Long colleagueId) {

    }

    /**
     * Read all colleagues
     */
    @Override
    public List<Colleague> readAllColleagues() {
        return namedParameterJdbcOperations.getJdbcOperations().query(SELECT_COLLEAGUES, new BeanPropertyRowMapper<>(Colleague.class));
    }
}
