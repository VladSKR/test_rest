package com.testtask.test_rest.service.impl;

import com.testtask.test_rest.dao.ColleagueDao;
import com.testtask.test_rest.model.Colleague;
import com.testtask.test_rest.service.ColleagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ColleagueServiceImpl implements ColleagueService {

    private static final AtomicLong COLLEAGUE_ID_HOLDER = new AtomicLong();
    private final ColleagueDao colleagueDao;

    @Autowired
    ColleagueServiceImpl(ColleagueDao colleagueDao) {
        this.colleagueDao = colleagueDao;
    }

    /**
     * Create new colleague
     *
     * @param colleague
     */
    @Override
    public Long createColleague(Colleague colleague) {

        Long colleagueId = colleagueDao.createColleague(colleague);
        return colleagueId;
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
        return colleagueDao.readAllColleagues();
    }
}
