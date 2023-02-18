INSERT INTO customer_details (customer_id, customer_name, address, mobilenumber, email_id) VALUES 
    (1, 'John Doe', '123 Main St', 1234567890, 'johndoe@example.com'),
    (2, 'Jane Smith', '456 Park Ave', 2345678901, 'janesmith@example.com'),
    (3, 'Bob Johnson', '789 Elm St', 3456789012, 'bobjohnson@example.com');

INSERT INTO product_suppplier (product_supplier_id, product_supplier_name, location, contact_no, email_id) VALUES 
    (1, 'Supplier A', '123 Main St', 1234567890, 'suppliera@example.com'),
    (2, 'Supplier B', '456 Park Ave', 2345678901, 'supplierb@example.com'),
    (3, 'Supplier C', '789 Elm St', 3456789012, 'supplierc@example.com'),
    (4, 'Supplier D', '999 5th Ave', 4567890123, 'supplierd@example.com');

INSERT INTO product_items (product_id, product_name, price, quantity, product_supplier_id) VALUES 
    (1, 'Product A', 10, 10, 1),
    (2, 'Product B', 15, 15, 1),
    (3, 'Product C', 20, 20, 2),
    (4, 'Product D', 25, 25, 3),
    (5, 'Product E', 30, 30, 3),
    (6, 'Product F', 35, 35, 4);

INSERT INTO cart_details (cart_id, quantity, customer_cart_fk , product_cart_fk) VALUES 
    (1, 3, 1,1),
    (2, 2, 2,2),
    (3, 4, 3,3);



INSERT INTO order_details (order_id, status, delivery_address, cart_id, customer_order_fk, productsup_fk) VALUES 
    (1, 'pending', '123 Main St', 1, 1, 1),
    (2, 'shipped', '456 Park Ave', 2, 2, 2),
    (3, 'delivered', '789 Elm St', 3, 3, 3);

INSERT INTO payment_details (payment_id, payment_date, payment_type, payment_status, payment_cart_fk, payment_order_fk) VALUES 
    (1, '2022-01-01', 'credit card', 'completed', 1, 1),
    (2, '2022-01-02', 'paypal', 'completed', 2, 2),
    (3, '2022-01-03', 'debit card', 'failed', 3, 3);


