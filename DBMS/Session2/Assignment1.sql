# creating database
CREATE DATABASE storefront;

# selecting database
USE storefront;

# creating all tables
CREATE TABLE user(
    ID VARCHAR(10) PRIMARY KEY,
    FirstName VARCHAR(20),
    LastName VARCHAR(20),
    Role ENUM('SHOPPER', 'ADMIN')
);

CREATE TABLE address(
    ID VARCHAR(10) PRIMARY KEY,
    Street VARCHAR(50),
    Area VARCHAR(50),
    District VARCHAR(50),
    State VARCHAR(50),
    Pincode VARCHAR(10),
    Country VARCHAR(50),
    UserID VARCHAR(10),
    FOREIGN KEY (UserID)
        REFERENCES user (ID)
        ON DELETE CASCADE
);

CREATE TABLE category(
    ID VARCHAR(10) PRIMARY KEY,
    Title VARCHAR(20),
    ParentID VARCHAR(20),
    FOREIGN KEY (ParentID)
        REFERENCES category (ID)
        ON DELETE CASCADE
);

CREATE TABLE product(
    ID VARCHAR(10) PRIMARY KEY,
    Title VARCHAR(50),
    Description VARCHAR(100),
    Status ENUM('ACTIVE', 'INACTIVE'),
    Price DOUBLE,
    Stock INT,
    TimeAdded TIMESTAMP DEFAULT NOW(),
    CategoryID VARCHAR(10),
    FOREIGN KEY (CategoryID)
        REFERENCES category (ID)
        ON DELETE CASCADE
);

CREATE TABLE image(
    ID VARCHAR(10) PRIMARY KEY,
    Title VARCHAR(20),
    ProductID VARCHAR(10),
    FOREIGN KEY (ProductID)
        REFERENCES product (ID)
        ON DELETE CASCADE
);

CREATE TABLE orders(
    ID VARCHAR(10) PRIMARY KEY,
    OrderTime TIMESTAMP DEFAULT NOW(),
    UserID VARCHAR(10),
    FOREIGN KEY (UserID)
        REFERENCES user (ID)
        ON DELETE CASCADE
);

CREATE TABLE order_detail(
    ID VARCHAR(10) PRIMARY KEY,
    OrderID VARCHAR(10),
    ProductID VARCHAR(10),
    ProductPrice DOUBLE,
    ProductQuantity INT,
    Status ENUM('PLACED', 'SHIPPED', 'CANCELLED', 'RETURNED'),
    FOREIGN KEY (OrderID)
        REFERENCES orders (ID)
        ON DELETE CASCADE,
    FOREIGN KEY (ProductID)
        REFERENCES product (ID)
        ON DELETE CASCADE
);

# command to display all the table names
SHOW TABLES;

# command to remove Product table
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE product;
SET FOREIGN_KEY_CHECKS=1;

# create the Product table again
CREATE TABLE product(
    ID VARCHAR(10) PRIMARY KEY,
    Title VARCHAR(50),
    Description VARCHAR(100),
    Status ENUM('ACTIVE', 'INACTIVE'),
    Price DOUBLE,
    Stock INT,
    TimeAdded TIMESTAMP DEFAULT NOW(),
    CategoryID VARCHAR(10),
    FOREIGN KEY (CategoryID)
        REFERENCES category (ID)
        ON DELETE CASCADE
);
