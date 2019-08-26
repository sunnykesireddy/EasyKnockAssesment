package Utlities;

import DataModels.HouseAddress;

import java.util.List;

public interface IParser {
    List<HouseAddress> parseData(String data);
}
