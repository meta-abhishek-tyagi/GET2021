# Consider a form where providing a Zip Code populates associated City and State.
# Create appropriate tables and relationships for the same.
CREATE TABLE City(
    ZipCode VARCHAR(10) PRIMARY KEY,
    Name VARCHAR(50)
);

CREATE TABLE State(
    Name VARCHAR(50),
    CityZipCode VARCHAR(50),
    FOREIGN KEY (CityZipCode)
        REFERENCES City (ZipCode)
);

INSERT INTO City(ZipCode, Name)
VALUES  ('302019', 'Udaipur'),
        ('302020', 'Jaipur'),
        ('302021', 'Raipur'),
        ('302022', 'Ahmedabad'),
        ('302023', 'Indore');


INSERT INTO State(Name, CityZipCode)
VALUES  ('Rajasthan', '302019'),
        ('Rajasthan', '302020'),
        ('Chhattisgarh', '302021'),
        ('Gujarat', '302022'),
        ('Madhya Pradesh', '302023');
        
# Write a SQL query for that returns a Resultset containing Zip Code, City Names and
# States ordered by State Name and City Name.
SELECT 
    ZipCode,
    City.Name AS 'City Name',
    State.Name AS 'State Name'
FROM
    City
        JOIN
    State ON City.ZipCode = State.CityZipCode
ORDER BY `State Name`,`City Name`;