package DataModels;

public class SchoolDistrictInCity {

    public int CityId;
    public int schoolDistrictId;

    public SchoolDistrictInCity( int cityId, int schoolDistrictId)
    {
        this.CityId = cityId;
        this.schoolDistrictId = schoolDistrictId;
    }
    @Override
    public boolean equals(Object other)
    {

        if(other == null)
            return false;
        SchoolDistrictInCity ot = (SchoolDistrictInCity) other;
        if( ot.schoolDistrictId == this.schoolDistrictId && ot.CityId == this.CityId)
            return true;
        return false;
    }
}
