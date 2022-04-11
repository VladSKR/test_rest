package com.testtask.test_rest.model;

import java.sql.Timestamp;

public class Weather {

    private Long colleagueId;
    private Integer temperature;
    private String description;
    private Timestamp lastUpdateTime;
    private Boolean updateStatus;

    public Long getColleagueId() {
        return colleagueId;
    }

    public void setColleagueId(Long colleagueId) {
        this.colleagueId = colleagueId;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Boolean getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(Boolean updateStatus) {
        this.updateStatus = updateStatus;
    }


}
