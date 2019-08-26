package DataAccessLayer;

import DataModels.*;

public interface IDbConnection {

    void insertRecords(String sql);
    void insertSchool(School school);
    void insertFaculty(Faculty faculty);
    void insertHouse(HouseAddress houseAddress);
    void insertSchoolDistrict(SchoolDistrict schoolDistrict);
    void insertCity(City city);
    void insertSchoolDistrictInCity(SchoolDistrictInCity schoolDistrictInCity);
    void insertSchoolsInDistrict(SchoolsInDistrict schoolsInDistrict);
    void insertFacultyInSchool(FacultiesInSchool facultiesInSchool);
}
