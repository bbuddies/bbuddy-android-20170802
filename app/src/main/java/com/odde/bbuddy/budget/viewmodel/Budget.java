package com.odde.bbuddy.budget.viewmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.odde.bbuddy.Utils;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Budget implements Serializable {
    private String month;
    private int amount;

    public Date getTimeString() {
        return Utils.parsingDateString(month);
    }
}
