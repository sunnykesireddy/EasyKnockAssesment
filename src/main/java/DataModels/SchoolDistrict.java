package DataModels;

import java.util.List;

public class SchoolDistrict {

    public int SchooldDistrictId;
    public List<School> schools;
    public int districtId;

    public SchoolDistrict(int schooldDistrictId, int _schoolDistrictId)
    {
        this.SchooldDistrictId = schooldDistrictId;
        this.districtId = _schoolDistrictId;
    }



}
