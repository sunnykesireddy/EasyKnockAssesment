CREATE DATABASE EasyKnockTest;

USE EasyKnockTest;

CREATE TABLE City(
    ID int NOT NULL,
	City varchar(100) NULL,
	CREATEDDATE datetime NULL,
	 UPDATEDDATE datetime NULL
);


CREATE TABLE Faculty(

   FacultyId int NOT NULL PRIMARY KEY,
   Name varchar(50) NOT NULL,
   Role varchar(50) NOT NULL,
   StartDate DATETIME,
   CREATEDDATE DATETIME,
   UPDATEDTIME DATETIME
);

CREATE TABLE  SchoolDistrict(

    Id int  PRIMARY KEY,
	DistrictId INT NOT NULL,
	CREATEDDATE DATETIME,
	UPDATEDTIME DATETIME

);


CREATE TABLE  School(

	 SchoolId int NOT NULL  PRIMARY KEY,
	 SchoolName varchar(50) NOT NULL,
	 Grade char NOT NULL,
	 DistrictId int NOT NULL,
	 CREATEDDATE DATETIME,
     UPDATEDTIME DATETIME
	 FOREIGN KEY (DistrictId) REFERENCES SchoolDistrict(Id)
	);

	 
CREATE TABLE  FacultySchool
 (
    SchoolId int NOT NULL,
    FacultyId int NOT NULL,
    PRIMARY KEY(SchoolId, FacultyId),
    FOREIGN KEY (SchoolId) REFERENCES School(SchoolId),
    FOREIGN KEY (FacultyId) REFERENCES Faculty(FacultyId),
    CREATEDDATE DATETIME,
    UPDATEDDATE DATETIME
 );

CREATE TABLE  HouseAddress(

    ID int NOT NULL IDENTITY(1,1) PRIMARY KEY,
    ZipCode varchar(10)  NOT NULL,
	HAddress varchar(100) NOT NULL,
	MedianHouseValue decimal NOT NULL,
	SchoolDistrictId int NOT NULL,
	City varchar(100) NOT NULL,
	CreatedDate datetime,
	UpdatedDate datetime
);

CREATE TABLE  SchoolDistrictsInCity(

    CityId int NOT NULL,
	SchoolDistrictId int NOT NULL,
	Createddate datetime,
	Updateddate datetime
);