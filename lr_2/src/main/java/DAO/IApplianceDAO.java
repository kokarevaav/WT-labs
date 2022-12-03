package DAO;

import model.Appliance;

import java.util.List;

public interface IApplianceDAO {

    Appliance findMostExpensive();

    List<Appliance> findAllAppliancesByType(String type);
}
