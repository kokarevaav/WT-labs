package model.searchCriteria;

public class SearchCriteria {

    public static enum Oven{
        powerConsumption, weight, capacity, depth, height, width
    }

    public static enum Laptop{
        batteryCapacity , os, memoryRom, systemMemory, cpu, displayInches
    }

    public static enum Refrigerator{
        powerConsumption, weight, freezerCapacity, overallCapacity, height, width
    }

    public static enum VacuumCleaner{
        powerConsumption, filterType, bagType, wandType, motorSpeedRegulation, cleaningWidth
    }

    public static enum TabletPC{
        batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color
    }

    public static enum Speakers{
        powerConsumption, numberOfSpeakers, frequencyRange, cordLength
    }
}

