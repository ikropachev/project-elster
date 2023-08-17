INSERT INTO order_info (order_id, customer_id, salesperson_id, create_dtm) VALUES (6,'CUST-004', 'SPERSON-001', current_timestamp - interval '1 day');
INSERT INTO order_info (order_id, customer_id, salesperson_id, create_dtm) VALUES (5,'CUST-001', 'SPERSON-001', current_timestamp - interval '2 day');
INSERT INTO order_info (order_id, customer_id, salesperson_id, create_dtm) VALUES (4,'CUST-002', 'SPERSON-001', current_timestamp - interval '2 day');
INSERT INTO order_info (order_id, customer_id, salesperson_id, create_dtm) VALUES (3,'CUST-003', 'SPERSON-002', current_timestamp - interval '3 days');
INSERT INTO order_info (order_id, customer_id, salesperson_id, create_dtm) VALUES (2,'CUST-001', 'SPERSON-002', current_timestamp - interval '5 days');
INSERT INTO order_info (order_id, customer_id, salesperson_id, create_dtm) VALUES (1,'CUST-001', 'SPERSON-002', current_timestamp - interval '6 days');

INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price) values (1, 1, 1, 3, 49.99);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price) values (2, 1, 2, 1, 24.99);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price) values (3, 2, 2, 1, 24.99);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price) values (4, 2, 3, 2, 19.99);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price) values (5, 3, 1, 1, 49.99);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price) values (6, 4, 1, 3, 47.99);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price) values (7, 4, 3, 2, 24.50);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price) values (8, 5, 1, 1, 49.99);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price) values (9, 5, 2, 3, 24.99);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price) values (10, 6, 1, 1, 48.99);

INSERT INTO customer (customer_id, cust_name, street, city, itn, updated_dtm) VALUES ('CUST-001', 'Jonesy', 'E 187th Street', 'New York', '0000000001', current_timestamp - interval '6 days');
INSERT INTO customer (customer_id, cust_name, street, city, itn, updated_dtm) VALUES ('CUST-001', 'Jones', 'E 187th Street', 'New York', '0000000002', current_timestamp - interval '5 days');
INSERT INTO customer (customer_id, cust_name, street, city, itn, updated_dtm) VALUES ('CUST-001', 'Jones', 'W 82nd Street', 'New York', '0000000003', current_timestamp - interval '1 day');
INSERT INTO customer (customer_id, cust_name, street, city, itn, updated_dtm) VALUES ('CUST-002', 'Doe', 'Poland St NW', 'Atlanta', '0000000004', current_timestamp - interval '2 day');
INSERT INTO customer (customer_id, cust_name, street, city, itn, updated_dtm) VALUES ('CUST-003', 'Smith', 'Sotelo Ave', 'San Francisco', '0000000005', current_timestamp - interval '6 days');
INSERT INTO customer (customer_id, cust_name, street, city, itn, updated_dtm) VALUES ('CUST-003', 'Smith', 'Main Street', 'Baltimore', '0000000006', current_timestamp - interval '3 days');
INSERT INTO customer (customer_id, cust_name, street, city, itn, updated_dtm) VALUES ('CUST-004', 'Parker', 'Race street', 'Denver', '0000000007', current_timestamp - interval '1 day');

INSERT INTO product (product_id, product_name, supplier_id, producttype_id, updated_dtm) VALUES (1, 'Vacuum cleaner', 1, 1, current_timestamp - interval '6 days');
INSERT INTO product (product_id, product_name, supplier_id, producttype_id, updated_dtm) VALUES (2, 'Cleaner bags', 201, 2, current_timestamp - interval '6 days');
INSERT INTO product (product_id, product_name, supplier_id, producttype_id, updated_dtm) VALUES (3, 'Oven mittens', 380, 3, current_timestamp - interval '6 days');

INSERT INTO product (product_id, product_name, supplier_id, producttype_id, updated_dtm) VALUES (1, 'Vacuum cleaner', 1, 4, current_timestamp - interval '3 days');
INSERT INTO product (product_id, product_name, supplier_id, producttype_id, updated_dtm) VALUES (1, 'Vacuum cleaner', 1, 1, current_timestamp - interval '1 day');

INSERT INTO salesperson (salesperson_id, salesperson_name, updated_dtm) VALUES ('SPERSON-001', 'John Smith', current_timestamp - interval '3 days');
INSERT INTO salesperson (salesperson_id, salesperson_name, updated_dtm) VALUES ('SPERSON-002', 'Jack London', current_timestamp - interval '3 days');