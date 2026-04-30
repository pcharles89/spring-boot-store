INSERT INTO categories (name)
VALUES ('Produce'),
       ('Dairy'),
       ('Meat'),
       ('Bakery'),
       ('Pantry');

INSERT INTO products (name, price, category_id, description)
VALUES
-- Produce
('Bananas (1 lb)', 0.59, 1, 'Fresh yellow bananas sold by the pound, perfect for snacking or smoothies.'),
('Organic Avocados (each)', 1.99, 1, 'Ripe organic avocados, great for guacamole or toast.'),

-- Dairy
('Whole Milk (1 Gallon)', 3.79, 2, 'Fresh whole milk, rich and creamy, sourced from local farms.'),
('Large Eggs (12 count)', 2.99, 2, 'Grade A large eggs, ideal for breakfast and baking.'),

-- Meat
('Chicken Breast (1 lb)', 5.49, 3, 'Boneless, skinless chicken breast, high in protein and versatile.'),
('Ground Beef 80/20 (1 lb)', 6.29, 3, 'Fresh ground beef with 80/20 lean-to-fat ratio, perfect for burgers.'),

-- Bakery
('Sliced White Bread', 2.49, 4, 'Soft sliced white bread, great for sandwiches and toast.'),
('Chocolate Chip Cookies (12 pack)', 4.99, 4, 'Freshly baked chocolate chip cookies with a soft center.'),

-- Pantry
('Spaghetti Pasta (16 oz)', 1.49, 5, 'Classic durum wheat spaghetti, perfect for pasta dishes.'),
('Peanut Butter (16 oz)', 3.29, 5, 'Creamy peanut butter made from roasted peanuts, no artificial preservatives.');