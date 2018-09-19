insert into car_type (manufacturer,model) VALUES ('Ferrari', 'new');
insert into car_type (manufacturer,model) VALUES ('Audi', 'old');
insert into car (registration_plate, color,year,car_type_id) values ('AAA-000','red',2018,(select id FROM car_type where manufacturer = 'Ferrari'));
insert into car (registration_plate, color,year,car_type_id) values ('BBB-111','black',2011,(select id FROM car_type where manufacturer = 'Audi'));
insert into car (registration_plate, color,year,car_type_id) values ('CCC-222','grey',2012,(select id FROM car_type where manufacturer = 'Audi'));
insert into Rent (date_from, date_to, email, car_id) values (DATE '2018-09-14', DATE '2018-09-17', 'sara@gmail.com', 1)

