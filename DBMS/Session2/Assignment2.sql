# inserting sample data in tables
INSERT INTO user(ID, FirstName, LastName, Role)
VALUES  ('1', 'Abhishek', 'Tyagi', 'SHOPPER'),
        ('2', 'Akshat', 'Gupta', 'ADMIN'),
        ('3', 'Hemendra', 'Singh', 'SHOPPER');

INSERT INTO address(ID, Street, Area, District, State, Pincode, Country, UserID)
VALUES  ('1', 'Vivek Vihar', 'Sodala', 'Jaipur', 'Rajasthan', '302019', 'India', '2'),
        ('2', 'Shyam Nagar', 'Govind Vihar', 'Jaipur', 'Rajasthan', '302019', 'India', '3'),
        ('3', 'Ram Nagar', 'Bajrang Colony', 'Jaipur', 'Rajasthan', '302019', 'India', '1');

INSERT INTO category(ID, Title, ParentID)
VALUES  ('1', 'Electronics', '1'),
        ('2', 'Home Appliances', '1'),
        ('3', 'Mobile Phones', '1'),
        ('4', 'Smart Phones', '3'),
        ('5', 'Feature Phones', '3'),
        ('6', 'Washing Machines', '2');

INSERT INTO product(ID, Title, Description, Status, Price, Stock, CategoryID)
VALUES  ('1', 'Vivo V2 Pro', 'Best camera phone you can find', 'ACTIVE', 9000, 100, '4'),
        ('2', 'Samsung Washing Machine', 'Fully automatic', 'ACTIVE', 20000, 70, '6'),
        ('3', 'Jio Phone', 'All in one', 'INACTIVE', 1500, 10, '5'),
        ('4', 'Bajaj Fan', 'Trusted by all', 'ACTIVE', 1700, 1000, '2');

INSERT INTO image(ID, Title, ProductID)
VALUES  ('1', 'Vivo V2 Pro', '1'),
        ('2', 'Bajaj Fan', '4'),
        ('3', NULL, '1');

INSERT INTO orders(ID, UserID)
VALUES  ('1', '1'),
        ('2', '3');

INSERT INTO order_detail(ID, OrderID, ProductID, ProductQuantity, ProductPrice, Status)
VALUES  ('1', '1', '4', 2, 1700, 'SHIPPED'),
        ('2', '1', '1', 1, 9000, 'RETURNED'),
        ('3', '2', '2', 1, 20000, 'CANCELLED'),
        ('4', '1', '2', 1, 20000, 'SHIPPED');

# Display Id, Title, Category Title, Price of the products which are Active
# and recently added products should be at top.
SELECT product.ID, product.Title, category.Title AS 'Category Title', Price
FROM product 
JOIN category ON product.CategoryID = category.ID
WHERE Status = 'ACTIVE' ORDER BY TimeAdded DESC;

# Display the list of products which don't have any images.
SELECT ID, Title, Description
FROM product 
WHERE ID NOT IN (SELECT ProductId FROM image);

# Display all Id, Title and Parent Category Title for all the Categories
# listed, sorted by Parent Category Title and then Category Title.
# (If Category is top category then Parent Category Title,
# column should display “Top Category” as value).
SELECT c1.ID, c1.Title AS 'Category Title', CASE WHEN c1.ID = c2.ParentId THEN 'Top Category' ELSE c2.Title END AS 'Parent Category Title'
FROM category c1 JOIN category c2 ON c1.ParentID = c2.ID 
ORDER BY `Parent Category Title`,`Category Title`;

# Display Id, Title, Parent Category Title of all the leaf Categories
# (categories which are not parent of any other category)
SELECT c1.ID, c1.Title, c2.Title AS 'Parent Category Title'
FROM category c1 
JOIN category c2 ON c1.ParentId = c2.ID
WHERE c1.ID NOT IN (SELECT ParentID FROM category);

# Display Product Title, Price & Description which falls into 
# particular category Title (i.e. “Mobile”)
SELECT product.Title AS 'Product Title', Price, Description
FROM product
JOIN category ON product.CategoryID = category.ID
WHERE category.Title = 'Smart Phones';

# Display the list of Products whose Quantity on hand (Inventory) is under 50.
SELECT ID, Title, Description
FROM product
WHERE Stock < 50;
