package DataModels;

public class SchoolsInDistrict {

    public int districtId;
    public int schoolId;

    public SchoolsInDistrict( int dId, int sId)
    {
        this.districtId = dId;
        this.schoolId = sId;
    }

    @Override
    public boolean equals(Object other)
    {

        if(other == null)
            return false;
        SchoolsInDistrict ot = (SchoolsInDistrict)other;
        if( ot.schoolId == this.schoolId && ot.districtId == this.districtId)
            return true;
        return false;
    }
}
