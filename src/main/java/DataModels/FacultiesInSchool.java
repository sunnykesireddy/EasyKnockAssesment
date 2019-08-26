package DataModels;

public class FacultiesInSchool {

    public int FacultyId;
    public int SchoolId;

    public FacultiesInSchool( int fid, int sid)
    {
        this.FacultyId = fid;
        this.SchoolId = sid;
    }

    @Override
    public boolean equals(Object other)
    {

        if(other == null)
            return false;
        FacultiesInSchool ot = (FacultiesInSchool)other;
        if( ot.SchoolId == this.SchoolId && ot.FacultyId == this.FacultyId)
            return true;
        return false;
    }
}
