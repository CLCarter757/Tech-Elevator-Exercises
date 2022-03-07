DROP TABLE IF EXISTS review, hotel, address;

CREATE TABLE address
(
    address_id serial PRIMARY KEY,
    address varchar(100) NOT NULL,
    address2 varchar(100),
    city varchar(100) NOT NULL,
    state varchar(100) NOT NULL,
    zip varchar(5) NOT NULL
);

CREATE TABLE hotel
(
    hotel_id serial PRIMARY KEY,
    name varchar(100) NOT NULL,
	address_id int NOT NULL,
    rooms_available int NOT NULL,
    cost_per_night numeric(6,2) NOT NULL,
    cover_image varchar(100),

    CONSTRAINT fk_address_id FOREIGN KEY (address_id) REFERENCES address (address_id),
    CONSTRAINT chk_cost_is_positive CHECK (cost_per_night > 0),
    CONSTRAINT chk_rooms_available_is_positive CHECK (rooms_available > 0)
);

CREATE TABLE review
(
    review_id serial PRIMARY KEY,
    hotel_id int NOT NULL,
    author varchar(100),
    title varchar(100) NOT NULL,
    description text,
    stars int NOT NULL,

    CONSTRAINT fk_hotel_id FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id),
    CONSTRAINT chk_stars_in_range CHECK(stars >=1 AND stars <=5)
);