package com.testtask.test_rest.service;

import com.testtask.test_rest.model.Colleague;

import java.util.List;

public interface ColleagueService {
    /**
     * Create new colleague
     *
     * @param colleague
     */
    Long createColleague(Colleague colleague);

    /**
     * Update colleague
     *
     * @param colleague
     */
    void updateColleague(Colleague colleague);

    /**
     * Remove colleague
     *
     * @param colleagueId
     */
    void removeColleague(Long colleagueId);

    /**
     * Read colleague
     *
     * @param colleagueId
     */
    void readColleague(Long colleagueId);

    /**
     * Read all colleagues
     */
    List<Colleague> readAllColleagues();

}

