# Display Recent 50 Orders placed (Id, Order Date, Order Total).
SELECT 
    orders.ID AS 'OrderID',
    DATE(OrderTime) AS 'Order Date',
    SUM(ProductPrice*ProductQuantity) AS Total
FROM
    orders
        JOIN
    order_detail ON orders.ID = order_detail.OrderID
GROUP BY orders.ID
ORDER BY `Order Date` DESC
LIMIT 50;

# Display 10 most expensive Orders.
SELECT 
    orders.ID AS 'OrderID',
    SUM(ProductPrice*ProductQuantity) AS Total,
    UserID
FROM
    orders
        JOIN
    order_detail ON orders.ID = order_detail.OrderID
GROUP BY orders.ID
ORDER BY Total DESC
LIMIT 10;

# Display all the Orders which are placed more than 10 days ago,
# and one or more items from those orders are still not shipped.
-- insert into orders(ID, OrderTime, UserID)
-- values  ('3', '2021-03-04 17:29:14', '3');
-- 
-- insert into order_detail(ID, OrderID, ProductID, ProductQuantity, ProductPrice, Status)
-- values  ('5', '3', '1', 2, 9000, 'PLACED');
SELECT 
    orders.ID AS 'OrderID',
    DATE(OrderTime) AS 'Order Date',
    UserID
FROM
    orders
WHERE
    DATEDIFF(NOW(), OrderTime) > 10 AND ID IN (SELECT DISTINCT
        OrderID
    FROM
        order_detail
    WHERE
        status = 'PLACED');

# Display list of shoppers which haven't ordered anything since last month.
-- insert into user
-- values ('4', 'Pragyansh', 'Pant', 'SHOPPER');

-- insert into orders(ID, OrderTime, UserID)
-- values  ('4', '2021-02-01 13:54:47', '4');
 
-- insert into order_detail(ID, OrderID, ProductID, ProductQuantity, ProductPrice, Status)
-- values  ('6', '4', '1', 1, 9000, 'SHIPPED');
SELECT 
    UserID,
    FirstName,
    LastName,
    DATEDIFF(NOW(), OrderTime) AS 'Days Since Inactive'
FROM
    orders
        JOIN
    user ON orders.UserID = user.ID
WHERE
    DATEDIFF(NOW(), OrderTime) >= 30 AND user.Role = 'SHOPPER';

# Display list of shopper along with orders placed by them in last 15 days.
SELECT 
    UserID,
    FirstName,
    LastName,
    orders.ID AS 'OrderID',
    ProductID,
    Title,
    ProductPrice,
    DATE(OrderTime) AS 'Order Date'
FROM
    user
        JOIN
    orders ON user.ID = orders.UserID
        JOIN
    order_detail ON order_detail.OrderID = orders.ID
        JOIN
    product ON order_detail.ProductID = product.ID
WHERE
    DATEDIFF(NOW(), OrderTime) <= 15;

# Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1))
SELECT 
     OrderID, ProductID, Title, order_detail.Status
FROM
    order_detail
        JOIN
    product ON order_detail.ProductID = product.ID
WHERE
    order_detail.Status = 'SHIPPED' AND OrderID = '1';

# Display list of order items along with order placed date 
# which fall between Rs. 1000 to Rs. 10000 price.
SELECT 
    ProductID, Title, ProductPrice, DATE(OrderTime) AS 'Order Date'
FROM
    product
        JOIN
    order_detail ON order_detail.ProductID = product.ID
        JOIN
    orders ON orders.ID = order_detail.OrderID
WHERE
    ProductPrice BETWEEN 1000 AND 10000;