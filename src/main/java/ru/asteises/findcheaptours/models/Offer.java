package ru.asteises.findcheaptours.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Offer {

    private UUID uuid;
    private int nights;
    private String meals;
    private int fullPrice;
    private int nightPrice;

}
