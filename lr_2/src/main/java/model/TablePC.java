package model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TablePC extends Appliance {

    private double batteryCapacity;
    private int displayInches;
    private int memoryRom;
    private int flashMemoryCapacity;
    private String color;
    private double price;
}
