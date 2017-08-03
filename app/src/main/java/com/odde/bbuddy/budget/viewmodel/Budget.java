package com.odde.bbuddy.budget.viewmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Budget {

    private String month;
    private int amount;
}
