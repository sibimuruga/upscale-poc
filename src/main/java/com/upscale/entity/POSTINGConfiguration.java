package com.upscale.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class POSTINGConfiguration {

    @Column
    @Id
    private int id;

    @Column(name ="CLIENTNAME")
    private String clientName;

    @Column(name="POSTINGACCOUNTCONDITION")
    private String postingCondition;

    @Column(name="POSTINGACCOUNTVALUE")
    private String postingValue;

}
