package util;

import model.Appliance;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * enum used in
 * @see ApplianceFactory createAppliances
 * to define field datatype
 */
enum FieldType {
    INT("INT"), DOUBLE("DOUBLE"), JAVALANGSTRING("JAVALANGSTRING");

    FieldType(String s) {
    }
}

public class ApplianceFactory {

    /**
     * @param appliance - type of object, which instances has to be created
     * @param typedAppliances - list of stringified data of objects of appliance type
     * @return List<Appliance> appliances - List of objects created in factory stored as superclass
     */
    public static List<Appliance> createAppliances(Appliance appliance, List<String> typedAppliances){
        List<Appliance> appliances = new ArrayList<>();
        typedAppliances.forEach(s -> {
            try {
                Appliance newAppliance = appliance.getClass().newInstance();
                Class<? extends Appliance> applianceClass = newAppliance.getClass();
                Field[] applianceFields = applianceClass.getDeclaredFields();

                for (Field field: applianceFields) {    //run through all fields and set data
                    field.setAccessible(true);
                    String fieldType = field.getType().getName().toUpperCase().replace(".", "");    //get name of field as string
                    FieldType emptyFieldType = FieldType.valueOf(fieldType);    //convert it to enum to be able to compare it in switch-case
                    try {
                        switch (emptyFieldType) {
                            case INT -> {
                                String data = getParameterPattern(field.getName())
                                                .matcher(s)
                                                .results()
                                                .map(matchResult -> matchResult.group(1))
                                                .collect(Collectors.joining("")
                                                );
                                field.setInt(newAppliance, Integer.parseInt(data));
                            }
                            case DOUBLE -> {
                                String data = getParameterPattern(field.getName())
                                        .matcher(s)
                                        .results()
                                        .map(matchResult -> matchResult.group(1))
                                        .collect(Collectors.joining(""));
                                field.setDouble(newAppliance, Double.parseDouble(data));
                            }
                            case JAVALANGSTRING -> {
                                String data = getParameterPattern(field.getName())
                                        .matcher(s)
                                        .results()
                                        .map(matchResult -> matchResult.group(1))
                                        .collect(Collectors.joining(""));
                                field.set(newAppliance, data);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Exception in ApplianceFactory.getAppliancesOfDefinedType. Invalid datatype");
                    }
                }
                appliances.add(newAppliance);
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
        return appliances;
    }

    /**
     * @param parameterName - name of object field (the same as in XML doc)
     * @return compiled pattern
     */
    public static Pattern getParameterPattern(String parameterName) {
        return Pattern.compile("<%s>(.*?)</%s>".formatted(parameterName, parameterName));
    }
}


