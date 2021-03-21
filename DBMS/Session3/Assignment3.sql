# Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT 
    user.ID AS 'UserID',
    FirstName,
    LastName,
    COUNT(orders.ID) AS 'Number of Orders'
FROM
    user
        JOIN
    orders ON orders.UserID = user.ID
WHERE
    DATEDIFF(NOW(), orders.OrderTime) <= 30
GROUP BY user.ID;

# Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT 
    user.ID AS 'UserID',
    FirstName,
    LastName,
    SUM(ProductQuantity * ProductPrice) AS 'Revenue'
FROM
    user
        JOIN
    orders ON user.ID = orders.UserID
        JOIN
    order_detail ON order_detail.OrderID = orders.ID
WHERE
    DATEDIFF(NOW(), orders.OrderTime) <= 30 AND order_detail.Status = 'SHIPPED'
GROUP BY user.ID
ORDER BY Revenue DESC
LIMIT 10;

# Display top 20 Products which are ordered most in last 60 days along with numbers.
SELECT 
    product.ID AS 'ProductID',
    Title,
    SUM(ProductQuantity) AS 'Number of Orders'
FROM
    orders
        JOIN
    order_detail ON order_detail.OrderID = orders.ID
        JOIN
    product ON order_detail.ProductID = product.ID
WHERE
    DATEDIFF(NOW(), orders.OrderTime) <= 60
GROUP BY product.ID
ORDER BY `Number of Orders` DESC
LIMIT 20;

# Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT 
    MONTHNAME(orders.OrderTime) as 'Month',
    SUM(ProductQuantity * ProductPrice) AS 'Monthly Sales Revenue'
FROM
    orders
        JOIN
    order_detail ON order_detail.OrderID = orders.ID
WHERE
    orders.OrderTime >= CURDATE() - INTERVAL 6 MONTH AND order_detail.Status = 'SHIPPED'
GROUP BY MONTH(orders.OrderTime);   

# Mark the products as Inactive which are not ordered in last 90 days.
SET SQL_SAFE_UPDATES=0;
UPDATE product 
SET product.Status = 'INACTIVE' 
WHERE 
    product.ID NOT IN 
    (
        SELECT product.ID 
        FROM( 
            SELECT product.ID
            FROM product JOIN order_detail 
            ON order_detail.ProductID = product.ID
            JOIN orders 
            ON order_detail.OrderId = orders.ID
            WHERE 
            DATEDIFF(NOW(), OrderTime) <= 90 )
        AS C
    );
SET SQL_SAFE_UPDATES=1;

# Given a category search keyword, display all the Products present in this category/categories. 
# (recursion needed here)
SELECT 
    product.ID AS 'ProductID', product.Title
FROM
    product
WHERE
    product.CategoryID IN (SELECT 
        category.ID
    FROM
        category
    WHERE
        category.parentID = (SELECT 
            category.ID
        FROM
            category
        WHERE
            category.Title = 'Mobile Phones'));

# Display top 10 Items which were cancelled most.
SELECT 
    product.ID,
    Title,
    SUM(ProductQuantity) AS 'Cancellation Count'
FROM
    order_detail
        JOIN
    product ON order_detail.ProductID = product.ID
WHERE
    order_detail.Status = 'CANCELLED'
GROUP BY product.ID
ORDER BY `Cancellation Count` DESC
LIMIT 10;