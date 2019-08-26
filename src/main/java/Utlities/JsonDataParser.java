package Utlities;

import DataModels.HouseAddress;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonDataParser implements IParser {
    public List<HouseAddress> parseData(String data) {

        List<HouseAddress> cityList = null;
        try{

            Gson gson = new Gson();
            Type cityListType = new TypeToken<ArrayList<HouseAddress>>(){}.getType();
            cityList = gson.fromJson(data, cityListType);
        }
        catch ( JsonParseException ex)
        {
            System.out.println();
        }

        return cityList;
    }
}
