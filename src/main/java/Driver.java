import DataAccessLayer.IDbConnection;
import DataAccessLayer.SqlServerDatabaseConnection;
import DataModels.HouseAddress;
import Utlities.*;

import java.util.List;

public class Driver {


    public static void main(String[] args)
    {

        String filePath = "sample_api_output.json";
        IDataReader dataReader = new FileDataReader();
        String data = dataReader.readData(filePath);
        System.out.println("Sucessfully read file");
        IParser parser = new JsonDataParser();
        List<HouseAddress> houses = parser.parseData(data);
        IDbConnection connection = new SqlServerDatabaseConnection();

        PrepareData p = new PrepareData();
        p.prepareDataToSave(houses);

        System.out.println(houses);
    }
}
