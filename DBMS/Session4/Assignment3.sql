# Identify the columns require indexing in order, product, category tables and create indexes.

# Already present indexes:
-- orders    - ID, UserID
-- product   - ID, CategoryID
-- category  - ID, ParentID

# Creating Indexes:

# category
ALTER TABLE category
ADD INDEX Title (Title);

# orders
ALTER TABLE orders
ADD INDEX OrderTime (OrderTime);

# product
ALTER TABLE product
ADD INDEX Title (Title);

ALTER TABLE product
ADD INDEX Price (Price);

ALTER TABLE product
ADD INDEX TimeAdded (TimeAdded);

ALTER TABLE product
ADD INDEX Status (Status);