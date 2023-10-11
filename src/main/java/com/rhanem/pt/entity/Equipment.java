package com.rhanem.pt.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("equipment")
public class Equipment extends Listing {

    private int numberOfHours;
    private String power;
    private double weightInTonnes;
    private String arrowSize;
    private String dipperSize;


    @ManyToOne
    private Brand brand;
    private String quickCouplerType;
    private String model;

    @ManyToOne
    private Country country;
    private String roofTiles;

    // TODO link it with listing state enum
    private String state;
    private String arrowType;
    private int yearOfConstruction;
    private BigDecimal price;
    private boolean priceOnRequest;

    private LocalDate customsClearanceDate;
    private boolean negotiable;
    private double capacityTank;
    private String cylinder;
    private boolean withGuarantee;
    private int timeOfGuarantee;
}
