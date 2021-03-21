# Create a view displaying the order information 
# (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
# with latest ordered items should be displayed first for last 60 days.

 -- TABLE `storefront`.`user` ADD COLUMN `Email` VARCHAR(45) NULL  AFTER `Role` ;

 -- UPDATE `storefront`.`user` SET `Email`='abhishek.tyagi@metacube.com' WHERE `ID`='1';
 -- UPDATE `storefront`.`user` SET `Email`='akshat.jhalani@metacube.com' WHERE `ID`='2';
 -- UPDATE `storefront`.`user` SET `Email`='hemendra.singh@metacube.com' WHERE `ID`='3';
 -- UPDATE `storefront`.`user` SET `Email`='pragyansh.pant@metacube.com' WHERE `ID`='4';
CREATE VIEW Information AS 
    SELECT 
        product.ID AS 'ProductID',
        product.Title AS 'Title',
        product.Price,
        CONCAT(FirstName, ' ', Lastname) as 'Shopper\'s Name',
        user.Email,
        DATE(orders.OrderTime) as 'Order Date',
        order_detail.Status
FROM 
    user 
        JOIN 
    orders ON orders.UserID = user.ID 
        JOIN 
    order_detail ON orders.ID = order_detail.OrderID 
        JOIN
    product ON order_detail.ProductID = product.ID
WHERE 
    DATEDIFF(NOW(), orders.OrderTime) <= 60 
ORDER BY orders.OrderTime DESC;

# Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT 
    *
FROM
    Information
WHERE
    Status = 'SHIPPED';

# Use the above view to display the top 5 most selling products.
SELECT 
    `ProductID`, Title, COUNT(*) AS 'Sale Count'
FROM
    Information
GROUP BY `ProductID`
ORDER BY `Sale Count` DESC
LIMIT 5;