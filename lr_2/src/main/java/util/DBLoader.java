package util;

import model.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Class that loads XML database and parses in
 */
public class DBLoader {

    private static final String DB_FILEPATH = "./src/main/resources/appliances_db.xml";
    private static final Path path = Paths.get(DB_FILEPATH);

    /**
     * Method that loads db
     * @return HashMap (Key, Value) = (ApplianceType, List of appliances)
     */
    public static HashMap<String, List<Appliance>> loadAllFromDB(){
        String dbData = readDataFromFile();   //read xml DB to String
        HashMap<String, List<String>> dividedAppliances = mapStringByApplianceTypes(dbData);
        HashMap<String, List<Appliance>> appliancesMap = new HashMap<>();
        appliancesMap.put("Oven", ApplianceFactory.createAppliances(new Oven(), dividedAppliances.get("Oven")));
        appliancesMap.put("Laptop", ApplianceFactory.createAppliances(new Laptop(), dividedAppliances.get("Laptop")));
        appliancesMap.put("Refrigerator", ApplianceFactory.createAppliances(new Refrigerator(), dividedAppliances.get("Refrigerator")));
        appliancesMap.put("TablePC", ApplianceFactory.createAppliances(new TablePC(), dividedAppliances.get("TablePC")));
        appliancesMap.put("Speakers", ApplianceFactory.createAppliances(new Speakers(), dividedAppliances.get("Speakers")));
        return appliancesMap;
    }

    /**
     * @return String of data, read from XML
     */
    private static String readDataFromFile(){
        StringBuilder dbDataString = new StringBuilder();
        try(BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals("")){
                    continue;
                }
                dbDataString.append(line.trim());
            }
            return new String(dbDataString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param dbString - parameter with all DB data
     * @return HashMap where (Key, Value) = (Appliance type, Stringified appliance data)
     */
    private static HashMap<String, List<String>> mapStringByApplianceTypes(String dbString){
        HashMap<String, List<String>> dividedAppliances = new HashMap<>();

        List<String> fieldsList = getAppliancePattern(new Oven()).matcher(dbString)
                .results()
                .map(matchResult -> matchResult.group(1))
                .toList();
        dividedAppliances.put("Oven", fieldsList);

        fieldsList = getAppliancePattern(new Laptop()).matcher(dbString)
                .results()
                .map(matchResult -> matchResult.group(1))
                .toList();
        dividedAppliances.put("Laptop", fieldsList);

        fieldsList = getAppliancePattern(new Refrigerator()).matcher(dbString)
                .results()
                .map(matchResult -> matchResult.group(1))
                .toList();
        dividedAppliances.put("Refrigerator", fieldsList);

        fieldsList = getAppliancePattern(new TablePC()).matcher(dbString)
                .results()
                .map(matchResult -> matchResult.group(1))
                .toList();
        dividedAppliances.put("TablePC", fieldsList);

        fieldsList = getAppliancePattern(new Speakers()).matcher(dbString)
                .results()
                .map(matchResult -> matchResult.group(1))
                .toList();
        dividedAppliances.put("Speakers", fieldsList);
        return dividedAppliances;
    }

    private static Pattern getAppliancePattern(Object applianceClass) {
        String fullClassName = applianceClass.getClass().getName();
        String className = fullClassName.substring(fullClassName.indexOf(".") + 1);
        return Pattern.compile("<" + className + ">(.*?)</" + className + ">");
    }
}
