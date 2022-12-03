package model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Speakers extends Appliance{

    private int powerConsumption;
    private int numberOfSpeakers;
    private String frequencyRange;
    private int cordLength;
    private double price;
}
