INSERT INTO order_info (order_id, customer_id, salesperson_id, updated_dtm)
VALUES (1, 'CUST-004', 'SPERSON-001', current_timestamp - 1);
INSERT INTO order_info (order_id, customer_id, salesperson_id, updated_dtm)
VALUES (2, 'CUST-001', 'SPERSON-001', current_timestamp - 1);
INSERT INTO order_info (order_id, customer_id, salesperson_id, updated_dtm)
VALUES (3, 'CUST-002', 'SPERSON-001', current_timestamp - 1);
INSERT INTO order_info (order_id, customer_id, salesperson_id, updated_dtm)
VALUES (4, 'CUST-003', 'SPERSON-002', current_timestamp);
INSERT INTO order_info (order_id, customer_id, salesperson_id, updated_dtm)
VALUES (5, 'CUST-001', 'SPERSON-002', current_timestamp);
INSERT INTO order_info (order_id, customer_id, salesperson_id, updated_dtm)
VALUES (6, 'CUST-001', 'SPERSON-002', current_timestamp);

INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price, updated_dtm)
values (1, 1, 1, 3, 49.99, current_timestamp - 1);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price, updated_dtm)
values (2, 1, 2, 1, 24.99, current_timestamp  - 1);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price, updated_dtm)
values (3, 2, 2, 1, 24.99, current_timestamp  - 1);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price, updated_dtm)
values (4, 2, 3, 2, 19.99, current_timestamp  - 1);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price, updated_dtm)
values (5, 3, 1, 1, 49.99, current_timestamp - 1);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price, updated_dtm)
values (6, 4, 1, 3, 47.99, current_timestamp);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price, updated_dtm)
values (7, 4, 3, 2, 24.50, current_timestamp);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price, updated_dtm)
values (8, 5, 1, 1, 49.99, current_timestamp);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price, updated_dtm)
values (9, 5, 2, 3, 24.99, current_timestamp);
INSERT INTO orderline (orderline_id, order_id, product_id, quantity, price, updated_dtm)
values (10, 6, 1, 1, 48.99, current_timestamp);

INSERT INTO customer (customer_id, cust_name, street, city, itn, updated_dtm)
VALUES ('CUST-001', 'Jonesy', 'E 187th Street', 'New York', '0000000001', current_timestamp - 1);
INSERT INTO customer (customer_id, cust_name, street, city, itn, updated_dtm)
VALUES ('CUST-002', 'Jones', 'E 187th Street', 'New York', '0000000002', current_timestamp - 1);
INSERT INTO customer (customer_id, cust_name, street, city, itn, updated_dtm)
VALUES ('CUST-003', 'Jones', 'W 82nd Street', 'New York', '0000000003', current_timestamp);
INSERT INTO customer (customer_id, cust_name, street, city, itn, updated_dtm)
VALUES ('CUST-004', 'Doe', 'Poland St NW', 'Atlanta', '0000000004', current_timestamp);

INSERT INTO product (product_id, product_name, updated_dtm)
VALUES (1, 'Vacuum cleaner', current_timestamp - 1);
INSERT INTO product (product_id, product_name, updated_dtm)
VALUES (2, 'Cleaner bags', current_timestamp);
INSERT INTO product (product_id, product_name, updated_dtm)
VALUES (3, 'Oven mittens', current_timestamp);

INSERT INTO salesperson (salesperson_id, salesperson_name, updated_dtm)
VALUES ('SPERSON-001', 'John Smith', current_timestamp - 1);
INSERT INTO salesperson (salesperson_id, salesperson_name, updated_dtm)
VALUES ('SPERSON-002', 'Jack London', current_timestamp);