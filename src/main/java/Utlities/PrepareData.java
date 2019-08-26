package Utlities;

import DataAccessLayer.IDbConnection;
import DataAccessLayer.SqlServerDatabaseConnection;
import DataModels.*;

import java.util.*;

public class PrepareData {


    public void prepareDataToSave(List<HouseAddress> houseAddressList) {
        int uniqueCities = 0, uniqueSchoolDistricts = 0, uniqueSchools = 0, uniqueFaculties = 0;
        Map<String, City> cities = new HashMap<String, City>();
        Map<String, SchoolDistrict> schoolDistricts = new HashMap<String, SchoolDistrict>();
        Map<String, School> schools = new HashMap<String, School>();
        Map<String, Faculty> facultyDict = new HashMap<String, Faculty>();

        List<SchoolDistrictInCity> schoolDistrictInCities = new ArrayList<SchoolDistrictInCity>();
        List<FacultiesInSchool> facultiesInSchools = new ArrayList<FacultiesInSchool>();
        List<SchoolsInDistrict> schoolsInDistricts = new ArrayList<SchoolsInDistrict>();


        try{

            for (HouseAddress address : houseAddressList) {

                if (!cities.containsKey(address.city)) {
                    uniqueCities++;
                    City city = new City(uniqueCities, address.city);
                    cities.put(address.city, city);
                }

                String uniqueDistrictKey = address.city + String.valueOf(address.schoolDistrict.districtId);
                if (!schoolDistricts.containsKey(uniqueDistrictKey)) {
                    uniqueSchoolDistricts++;
                    schoolDistricts.put(uniqueDistrictKey, new SchoolDistrict(uniqueSchoolDistricts, address.schoolDistrict.districtId));
                    address.schoolDistrict.SchooldDistrictId = uniqueSchoolDistricts;

                }

                City ct = cities.get(address.city);
                SchoolDistrict t = schoolDistricts.get(uniqueDistrictKey);
                SchoolDistrictInCity sct = new SchoolDistrictInCity(ct.cityId, t.SchooldDistrictId);
                if (!schoolDistrictInCities.contains(sct))
                    schoolDistrictInCities.add(sct);

                for (School school : address.schoolDistrict.schools) {
                    String skey = school.schoolName + uniqueDistrictKey;

                    if (!schools.containsKey(skey)) {
                        uniqueSchools++;
                        school.SchoolId = uniqueSchools;
                        schools.put(skey, school);
                    }
                    SchoolDistrict dst = schoolDistricts.get(uniqueDistrictKey);
                    SchoolsInDistrict sc = new SchoolsInDistrict(dst.SchooldDistrictId, uniqueSchools);
                    school.schoolDistrictId = dst.SchooldDistrictId;
                    if (!schoolsInDistricts.contains(sc))
                        schoolsInDistricts.add(sc);
                    for (Faculty faculty : school.faculty) {

                        String fKey = faculty.name + skey;

                        if (!facultyDict.containsKey(fKey)) {
                            uniqueFaculties++;
                            faculty.FacultyId = uniqueFaculties;
                            facultyDict.put(fKey, faculty);


                        }
                        FacultiesInSchool fc = new FacultiesInSchool(faculty.FacultyId, school.SchoolId);
                        if (!facultiesInSchools.contains(fc))
                            facultiesInSchools.add(fc);
                    }
                }

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }


        IDbConnection connection = new SqlServerDatabaseConnection();

        for (String key : cities.keySet()) {

            connection.insertCity(cities.get(key));
        }

        for (String key : schoolDistricts.keySet()) {

            connection.insertSchoolDistrict(schoolDistricts.get(key));
        }

        for (String key : schools.keySet()) {
            connection.insertSchool(schools.get(key));
        }

        for (String key : facultyDict.keySet()) {
            connection.insertFaculty(facultyDict.get(key));
        }

        for (SchoolDistrictInCity c : schoolDistrictInCities) {
            connection.insertSchoolDistrictInCity(c);
        }

        for (FacultiesInSchool fc : facultiesInSchools)
            connection.insertFacultyInSchool(fc);


        for(HouseAddress h : houseAddressList)
        {
            connection.insertHouse(h);
        }


        facultiesInSchools.clear();
        schoolDistrictInCities.clear();
        schoolsInDistricts.clear();
    }


}
