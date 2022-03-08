DROP TABLE IF EXISTS reward, review, reservation, hotel, address, user_authority, "user", authority;

CREATE TABLE authority
(
    authority_name varchar(100) PRIMARY KEY
);

CREATE TABLE "user"
(
    user_id serial PRIMARY KEY,
    username varchar(100) NOT NULL UNIQUE,
    password_hash varchar(200) NOT NULL
);

CREATE TABLE user_authority
(
    user_id int NOT NULL,
    authority_name varchar(100) NOT NULL,

    CONSTRAINT pk_user_authorities PRIMARY KEY (user_id, authority_name),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES "user" (user_id),
    CONSTRAINT fk_authority_name FOREIGN KEY (authority_name) REFERENCES authority (authority_name)
);

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
    address_id int NOT NULL,
    name varchar(100) NOT NULL,
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
    user_id int NOT NULL,
    hotel_id int NOT NULL,
    author varchar(100),
    title varchar(100) NOT NULL,
    description text,
    stars int NOT NULL,

    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES "user" (user_id),
    CONSTRAINT fk_hotel_id FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id),
    CONSTRAINT chk_stars_in_range CHECK (stars >= 1 AND stars <= 5)
);

CREATE TABLE reservation
(
    reservation_id serial PRIMARY KEY,
    fullname varchar(100),
    hotel_id int NOT NULL,
    user_id int NOT NULL,
    check_in_date DATE NOT NULL,
    check_out_date DATE NOT NULL,
    guests INT NOT NULL,

    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES "user" (user_id),
    CONSTRAINT fk_hotel_id FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id),
    CONSTRAINT chk_check_in_prior_to_check_out CHECK (check_in_date < check_out_date),
    CONSTRAINT chk_check_in_future CHECK (check_in_date >= CURRENT_DATE),
    CONSTRAINT chk_guests_is_positive CHECK (guests > 0)
);


CREATE TABLE reward
(
    reward_id serial PRIMARY KEY,
    user_id int UNIQUE NOT NULL,
    points int NOT NULL DEFAULT (0),

    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES "user" (user_id),
    CONSTRAINT chk_points_gte_zero CHECK (points >= 0)
);


INSERT INTO authority (authority_name) VALUES ('ROLE_USER'), ('ROLE_ADMIN');

INSERT INTO "user" (username, password_hash)
VALUES  ('user', ''),
        ('admin', '');

INSERT INTO user_authority (user_id, authority_name)
VALUES  ((SELECT user_id FROM "user" WHERE username = 'user'), 'ROLE_USER'),
        ((SELECT user_id FROM "user" WHERE username = 'admin'), 'ROLE_ADMIN');


INSERT INTO address (address, address2, city, state, zip)
VALUES  ('1111 W 10th St', '', 'Cleveland', 'Ohio', '44113');

INSERT INTO hotel (address_id, name, rooms_available, cost_per_night)
VALUES  ((SELECT address_id FROM address WHERE address = '1111 W 10th St'), 'Aloft Cleveland', 48, 274);


-- Reviews
INSERT INTO review (user_id, hotel_id, title, description, author, stars)
VALUES  ((SELECT user_id FROM "user" WHERE username = 'user'),
         (SELECT hotel_id FROM hotel WHERE name = 'Aloft Cleveland'),
         'What a great hotel!', 'I thought this was a really great hotel and would stay again!', 'John Smith', 4),

        ((SELECT user_id FROM "user" WHERE username = 'admin'),
                 (SELECT hotel_id FROM hotel WHERE name = 'Aloft Cleveland'),
                 'Peaceful night sleep', 'I had a really good night sleep and would stay again', 'Kerry Gold', 3);


