CREATE TABLE vehicle (
    id SERIAL PRIMARY KEY,
    brand VARCHAR(50) NOT NULL,
    year_manufacture INTEGER NOT NULL,
    description VARCHAR(256) NOT NULL,
    sold BOOLEAN NOT NULL,
    creation_date DATE NOT NULL,
    modification_date DATE NOT NULL
);


insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Chevrolet', 2016, 'Cruze', false, clock_timestamp(), clock_timestamp());

insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Ford', 2003, 'Ford ka', true, clock_timestamp(), clock_timestamp());

insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Volkswagen', 1980, 'Fusca', false, clock_timestamp(), clock_timestamp());

insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Fiat', 2015, 'Argo', false, clock_timestamp(), clock_timestamp());

insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Ferrari', 2020, 'Portofino', true, clock_timestamp(), clock_timestamp());

insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Porsche', 2020, 'Cayenne', true, clock_timestamp(), clock_timestamp());

insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Chevrolet', 2016, 'Cruze', false, clock_timestamp(), clock_timestamp());

insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Ford', 2003, 'Ford ka', true, clock_timestamp(), clock_timestamp());

insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Volkswagen', 1980, 'Fusca', false, clock_timestamp(), clock_timestamp());

insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Fiat', 2015, 'Argo', false, clock_timestamp(), clock_timestamp());

insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Ferrari', 2020, 'Portofino', false, clock_timestamp(), clock_timestamp());

insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Porsche', 2020, 'Cayenne', true, clock_timestamp(), clock_timestamp());

insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Chevrolet', 2016, 'Cruze', true, clock_timestamp(), clock_timestamp());

insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Ford', 2003, 'Ford ka', true, clock_timestamp(), clock_timestamp());

insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Volkswagen', 1980, 'Fusca', false, clock_timestamp(), clock_timestamp());

insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Fiat', 2015, 'Argo', false, clock_timestamp(), clock_timestamp());

insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Ferrari', 2020, 'Portofino', true, clock_timestamp(), clock_timestamp());

insert into vehicle (brand, year_manufacture, description, sold, creation_date, modification_date) values ('Porsche', 2020, 'Cayenne', false, clock_timestamp(), clock_timestamp());