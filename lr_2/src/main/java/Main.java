
import DAO.ApplianceDAOImpl;
import DAO.IApplianceDAO;
import util.DBLoader;

public class Main {

    public Main(IApplianceDAO applianceDAO) {
        this.applianceDAO = applianceDAO;
    }

    private final IApplianceDAO applianceDAO;

    public static void main(String[] args){
        Main main = new Main(new ApplianceDAOImpl(DBLoader.loadAllFromDB()));
        main.applianceDAO.findAllAppliancesByType("Laptop")
                .forEach(appliance -> System.out.println("appliance = " + appliance));
        System.out.println(main.applianceDAO.findMostExpensive());
    }
}
