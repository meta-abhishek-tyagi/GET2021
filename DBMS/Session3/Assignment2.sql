# Display the list of products (Id, Title, Count of Categories)
# which fall in more than one Categories.
# (recursion needed here)
SELECT 
    Product.ID as 'ProductID', product.Title
FROM
    category
        JOIN
    product ON product.CategoryID = category.ID
WHERE
    category.ID != Category.ParentID;

# Display Count of products as per below price range:
# (0 - 100, 101 - 500, Above 500)
SELECT 
    `Price Range`, COUNT(ID) as 'Count'
FROM
    (SELECT 
        ID,
            CASE
                WHEN Price BETWEEN 0 AND 5000 THEN '0 - 5000'
                WHEN Price BETWEEN 5001 AND 10000 THEN '5001 - 10000'
                WHEN Price > 10000 THEN '> 10000'
            END AS `Price Range`
    FROM
        product) a
GROUP BY `Price Range`;

# Display the Categories along with number of products under each category.
# (recursion needed here)
SELECT 
    category.ID,
    category.Title as 'Category Title',
    COUNT(Product.ID) AS 'Number of Products'
FROM
    category
        JOIN
    product ON product.CAtegoryID = category.ID
GROUP BY category.ID;