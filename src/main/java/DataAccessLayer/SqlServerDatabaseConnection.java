package DataAccessLayer;

import DataModels.*;

import java.sql.*;

public class  SqlServerDatabaseConnection  implements IDbConnection{

    private String connectionUrl = "jdbc:sqlserver://MININT-MAMKBP0:1433;databaseName=EasyKnockTest;integratedSecurity=true";

    public void insertRecords( String sql) {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            String SQL = "SELECT TOP 10 * FROM Faculty";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
            }
            con.close();
        }
        catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertSchool(School school) {

        try{

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            String sqlQuery = " INSERT INTO School (SchoolId, SchoolName, Grade, DistrictId)"
                    + " VALUES(?, ?, ?, ?)";
            PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
            prepStmt.setInt(1, school.SchoolId);
            prepStmt.setString(2, school.schoolName);
            prepStmt.setString(3, school.schoolGrade);
            prepStmt.setInt(4, school.schoolDistrictId);
            prepStmt.executeUpdate();
            prepStmt.close();
            con.close();

        }
        catch ( Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public void insertFaculty(Faculty faculty) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            String sqlQuery = " INSERT INTO Faculty (FacultyId, name, role, startDate)"
                    + " VALUES(?, ?, ?, ?)";
            PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
            prepStmt.setInt(1, faculty.FacultyId);
            prepStmt.setString(2, faculty.name);
            prepStmt.setString(3, faculty.role);
            prepStmt.setDate(4, java.sql.Date.valueOf(faculty.startDate));
            prepStmt.executeUpdate();
            prepStmt.close();
            con.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void insertHouse(HouseAddress houseAddress) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            String sqlQuery = " INSERT INTO HouseAddress (ZipCode, City, HAddress,MedianHouseValue,SchoolDistrictId)"
                    + " VALUES(?, ?, ?, ?,?)";
            PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
            prepStmt.setString(1, houseAddress.zip);
            prepStmt.setString(2, houseAddress.city);
            prepStmt.setString(3, houseAddress.address);
            prepStmt.setBigDecimal(4,houseAddress.medianHouseValue);
            prepStmt.setInt(5,houseAddress.schoolDistrict.districtId);
            prepStmt.executeUpdate();
            prepStmt.close();
            con.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void insertSchoolDistrict(SchoolDistrict schoolDistrict) {

        try{


            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            String sqlQuery = " INSERT INTO SchoolDistrict (Id, DistrictId)"
                    + " VALUES(?, ?)";
            PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
            prepStmt.setInt(1, schoolDistrict.SchooldDistrictId);
            prepStmt.setInt(2,schoolDistrict.districtId);
            prepStmt.executeUpdate();
            prepStmt.close();
            con.close();


        }
        catch (Exception e)
        {
            System.out.println("---");
            System.out.println(e.getMessage());
            System.out.println("---");
        }

    }

    public void insertCity(City city) {

        try{

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            String sqlQuery = " INSERT INTO City (ID, City)"
                    + " VALUES(?, ?)";
            PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
            prepStmt.setInt(1, city.cityId);
            prepStmt.setString(2, city.cityName);
            prepStmt.executeUpdate();
            prepStmt.close();
            con.close();


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public void insertSchoolDistrictInCity(SchoolDistrictInCity schoolDistrictInCity) {

        try{

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            String sqlQuery = " INSERT INTO SchoolDistrictsInCity (CityId, SchoolDistrictId)"
                    + " VALUES(?, ?)";
            PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
            prepStmt.setInt(1, schoolDistrictInCity.CityId);
            prepStmt.setInt(2, schoolDistrictInCity.schoolDistrictId);
            prepStmt.executeUpdate();
            prepStmt.close();
            con.close();


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public void insertSchoolsInDistrict(SchoolsInDistrict schoolsInDistrict) {

        try{

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            String sqlQuery = " INSERT INTO FacultySchool (FacultyId, SchoolId)"
                    + " VALUES(?, ?)";
            PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
            prepStmt.setInt(1, schoolsInDistrict.districtId);
            prepStmt.setInt(2, schoolsInDistrict.schoolId);
            prepStmt.executeUpdate();
            prepStmt.close();
            con.close();


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public void insertFacultyInSchool(FacultiesInSchool facultiesInSchool) {

        try{

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            String sqlQuery = " INSERT INTO FacultySchool (FacultyId, SchoolId)"
                    + " VALUES(?, ?)";
            PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
            prepStmt.setInt(1, facultiesInSchool.FacultyId);
            prepStmt.setInt(2, facultiesInSchool.SchoolId);
            prepStmt.executeUpdate();
            prepStmt.close();
            con.close();


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
