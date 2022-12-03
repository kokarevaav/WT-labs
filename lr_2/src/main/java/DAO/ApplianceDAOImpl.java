package DAO;

import model.*;

import java.util.HashMap;
import java.util.List;


public class ApplianceDAOImpl implements IApplianceDAO {

    public ApplianceDAOImpl(HashMap<String, List<Appliance>> appliances) {
        this.appliancesMap = appliances;
    }

    final HashMap<String, List<Appliance>> appliancesMap;

    @Override
    public Appliance findMostExpensive() {
        var ref = new Object() {
            double maxPrice = 0d;
            Appliance cheapestAppliance = null;
        };
        Appliance appliance = null;
        appliancesMap.forEach((key, value) -> value.forEach(item -> {
            if (item instanceof Oven oven){
                if (oven.getPrice() > ref.maxPrice) {
                    ref.maxPrice = oven.getPrice();
                    ref.cheapestAppliance = oven;
                }
            } else if (item instanceof Laptop laptop){
                if (laptop.getPrice() > ref.maxPrice) {
                    ref.maxPrice = laptop.getPrice();
                    ref.cheapestAppliance = laptop;
                }
            } else if (item instanceof Refrigerator refrigerator){
                if (refrigerator.getPrice() > ref.maxPrice) {
                    ref.maxPrice = refrigerator.getPrice();
                    ref.cheapestAppliance = refrigerator;
                }
            } else if (item instanceof TablePC tablePC){
                if (tablePC.getPrice() > ref.maxPrice) {
                    ref.maxPrice = tablePC.getPrice();
                    ref.cheapestAppliance = tablePC;
                }
            } else if (item instanceof Speakers speakers){
                if (speakers.getPrice() > ref.maxPrice) {
                    ref.maxPrice = speakers.getPrice();
                    ref.cheapestAppliance = speakers;
                }
            }
        }));

        return ref.cheapestAppliance;
    }

    @Override
    public List<Appliance> findAllAppliancesByType(String type) {
        return appliancesMap.get(type);
    }
}
