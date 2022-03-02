INSERT INTO Products (product_id, name, description) VALUES
(1, 'Kelloggs Froot Loops', 'Delicious frooty flava');

INSERT INTO shopproducts (shop_product_id, quantity, price, discount, product_id) VALUES
(1, 10, 15, 2, 1);

INSERT INTO Categories (category_id, name) VALUES (1, 'Food');

INSERT INTO Product_Category (product_id, category_id) VALUES
(1, 1);