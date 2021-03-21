# With respect to StoreFront application identify, apply and list the
# constraints you would apply on the columns for the tables created.

# address
ALTER TABLE Address
MODIFY Street VARCHAR(50) NOT NULL,
MODIFY Area VARCHAR(50) NOT NULL,
MODIFY District VARCHAR(50) NOT NULL,
MODIFY State VARCHAR(50) NOT NULL,
MODIFY Pincode VARCHAR(10) NOT NULL,
MODIFY Country VARCHAR(50) NOT NULL;

# category
ALTER TABLE category 
MODIFY Title VARCHAR(20) NOT NULL,
ADD UNIQUE (Title);

# user
ALTER TABLE user 
MODIFY FirstName VARCHAR(20) NOT NULL,
MODIFY LastName VARCHAR(20) NOT NULL,
MODIFY Email VARCHAR(50) NOT NULL,
ADD UNIQUE (Email);

# order_detail
ALTER TABLE order_detail 
MODIFY ProductQuantity INT NOT NULL,
MODIFY ProductPrice DOUBLE NOT NULL,
ADD CONSTRAINT VALCHECK CHECK ( ProductQuantity > 0 AND ProductPrice > 0);

# city
ALTER TABLE city
MODIFY Name VARCHAR(50) NOT NULL;

# state
ALTER TABLE state
MODIFY Name VARCHAR(50) NOT NULL;

# product
ALTER TABLE product 
MODIFY Title VARCHAR(50) NOT NULL,
MODIFY Price DOUBLE NOT NULL,
MODIFY Stock INT NOT NULL,
ADD CHECK ( Price > 0 AND Stock >= 0);
