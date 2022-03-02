
INSERT INTO products (product_id, name, description) VALUES
(default, 'Frooty Loops', 'Delicious frooty flava');

INSERT INTO shopproducts (shop_product_id, product_id, quantity, price, discount) VALUES
(default, 1, 10, 15, 2);

INSERT INTO Categories (category_id, name) VALUES (default, 'Food');

INSERT INTO product_category (product_id, category_id) VALUES
(1, 1);

--INSERT INTO shop () VALUES ();