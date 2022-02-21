/*
        Name,   Address,                                 Address Type,  Tax Amount,     Biography
        Walt    410 Scott Drive Pittsburgh, PA 15237      Primary            3.0        Instructor at Tech Elevator
        Oliver  410 Scott Drive Pittsburgh, PA 15237      Primary            3.0        Cat that interrupts class
        Oliver  412 Scott Drive Pittsburgh, PA 15237      Secondary          3.0        Cat that interrupts class
        Taylor   55 House Road New York, New York 10001   Primary            4.0        Aspiring comedian
		
		
		1NF
		
			Name,		House #,        Street,         City,		State,		Zip,	Address Type,  Tax Amount,     Biography
			Walt    	410 			Scott Drive 	Pittsburgh 	 PA 	  15237      Primary            3.0        Instructor at Tech Elevator
       	 	Oliver  	410 			Scott Drive 	Pittsburgh   PA 	  15237      Primary            3.0        Cat that interrupts class
        	Oliver  	412 			Scott Drive 	Pittsburgh   PA 	  15237      Secondary          3.0        Cat that interrupts class
        	Taylor   	 55 			House Road 		New York 	 NY 	  10001   	 Primary            4.0        Aspiring comedian
		 
		
		2NF
		Person ID,		Name,		Biography
		
		Address ID, 	House #,        Street,         City,		State,		Zip,	Tax Amount
		01				410 			Scott Drive 	Pittsburgh 	 PA 	  15237			3.0
		02				412 			Scott Drive 	Pittsburgh   PA 	  15237			3.0
		03				55 				House Road 		New York 	 NY 	  10001			4.0
		
		Person ID,		Address ID,		Address Type
		
		
		3NF 
		Person ID,		Name,		Biography
		
		Address ID, 	House #,        Street,         City,		State,		Zip
		01				410 			Scott Drive 	Pittsburgh 	 PA 	  15237
		02				412 			Scott Drive 	Pittsburgh   PA 	  15237
		
		Person ID,		Address ID,		Address Type
		
		State,	Tax Amount
		PA		  3.0
		NY		  4.0
		
		purchase_product
		Purchase ID, Price
		
		Product ID, Name
		
		Product ID, Purchase ID, Quantity
		
	

Britt 

customer
 customer_id PK
 last_name
 first_name
 phone_id FK
 address_id FK

phone
 phone_id PK
 phone_number CHK (format is correct)

address
 address_id PK
 house #
 street
 city
 state
 country
 zip
 
artist
 artist_id PK
 artist_name 

painting
 painting_id PK
 artist_id FK
 title
 
purchase
 purchase_id PK
 customer_id FK
 purchase_date NOT NULL

painting_purchase
 painting_id
 purchase_id
 price NOT NULL, CHECK (price > 0)
			

Robert

similar to above, with phone and address together


Scott

similar to above except
customer with multiple addresses, multiple phone numbers

customer_address
 customer_id (PK)
 address_id (PK)

customer_phone
 customer_id (PK)
 phone_id (PK)


Nikolay

customer
 customer_id
 customer_name
 address_1
 address_2
 city
 state
 zip
 phone

piece
 piece_id
 title
 artist_id

sale
 sale_id
 purchase_date
 sale_price
 piece_id
 
artist
 artist_id
 artist_name

*/









/*
customer
 customer_id PK
 last_name
 first_name
 phone_id FK
 address_id FK
 
phone
 phone_id PK
 phone_number CHK (format is correct)

address
 address_id PK
 house #
 street
 city
 state
 country
 zip
 
 artist
 artist_id PK
 artist_name 

painting
 painting_id PK
 artist_id FK
 title
 
purchase
 purchase_id PK
 customer_id FK
 purchase_date NOT NULL

painting_purchase
 painting_id PK, FK
 purchase_id PK, FK
 price NOT NULL, CHECK (price > 0)
			
 
 */
 
DROP TABLE painting_purchase, purchase, customer, address, phone, painting, artist;
 
CREATE TABLE artist
(
	artist_id SERIAL PRIMARY KEY,
	artist_name VARCHAR(100)
);

CREATE TABLE painting
(
	painting_id SERIAL PRIMARY KEY,
	artist_id INTEGER REFERENCES artist (artist_id),
	title VARCHAR(500) 
);
 
CREATE TABLE phone
(
	phone_id SERIAL,
	phone_number VARCHAR(10),
	
	CONSTRAINT pk_phone_id PRIMARY KEY (phone_id)
);

CREATE TABLE address
(
	address_id SERIAL,
	house_number VARCHAR(10),
	
	CONSTRAINT pk_address_id PRIMARY KEY (address_id)
);

CREATE TABLE customer
(
	customer_id SERIAL,
	last_name VARCHAR(50),
	first_name VARCHAR(50),
	phone_id INTEGER,
	address_id INTEGER,
	
	CONSTRAINT pk_customer_id PRIMARY KEY (customer_id),
	CONSTRAINT fk_phone_id FOREIGN KEY (phone_id) REFERENCES phone (phone_id),
	CONSTRAINT fk_address_id FOREIGN KEY (address_id) REFERENCES address (address_id)
);

CREATE TABLE purchase
(
	purchase_id SERIAL PRIMARY KEY,
	customer_id INTEGER REFERENCES customer (customer_id),
	purchase_date DATE NOT NULL
);

CREATE TABLE painting_purchase
(
	painting_id INTEGER,
	purchase_id INTEGER,
	price DECIMAL(10, 2) NOT NULL,
	
	CONSTRAINT pk_painting_id_purchase_id PRIMARY KEY (painting_id, purchase_id),
	CONSTRAINT fk_painting_id FOREIGN KEY (painting_id) REFERENCES painting (painting_id),
	CONSTRAINT fk_purchase_id FOREIGN KEY (purchase_id) REFERENCES purchase (purchase_id),
	CONSTRAINT chk_price CHECK (price > 0)
);







