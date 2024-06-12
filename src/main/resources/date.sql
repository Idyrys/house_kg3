insert into transaction_types(name,active) values('Продажа',true);
insert into transaction_types(name,active) values('Аренда',true);

insert into property_types(name,active) values('Квартира',true);
insert into property_types(name,active) values('Дом',true);
insert into property_types(name,active) values('Комната',true);

insert into number_of_rooms(number,active) values(1,true);
insert into number_of_rooms(number,active) values(2,true);
insert into number_of_rooms(number,active) values(3,true);
insert into number_of_rooms(number,active) values(4,true);
insert into number_of_rooms(number,active) values(5,true);
insert into number_of_rooms(number,active) values(6,true);

insert into serieses(name,active) values('102',true);
insert into serieses(name,active) values('103',true);
insert into serieses(name,active) values('104',true);

insert into type_of_structures(name,active) values('Кирпич',true);
insert into type_of_structures(name,active) values('Монолит',true);
insert into type_of_structures(name,active) values('Панельный',true);

insert into heatinges(name,active) values('Центральное',true);
insert into heatinges(name,active) values('На газе',true);
insert into heatinges(name,active) values('Электрическое',true);

insert into conditions(name,active) values('Евроремонт',true);
insert into conditions(name,active) values('Хорошее',true);
insert into conditions(name,active) values('Среднее',true);

insert into mortgages_or_installment_plans(name,active) values('Есть',true);
insert into mortgages_or_installment_plans(name,active) values('Нет',true);

insert into possibility_of_exchanges(name,active) values('Рассмотрю варианты',true);
insert into possibility_of_exchanges(name,active) values('С доплатой покупателя',true);
insert into possibility_of_exchanges(name,active) values('Ключ на ключ',true);
insert into possibility_of_exchanges(name,active) values('С доплатой продавца',true);

insert into currencies (name,active) values('Доллары',true);
insert into currencies (name,active) values('Сомы',true);

insert into price_types (name,active) values('За всё',true);
insert into price_types (name,active) values('За квадратный метр',true);

insert into location_types(name,active) values('Страна',true);
insert into location_types(name,active) values('Регион',true);
insert into location_types(name,active) values(' Населенный пункт',true);
insert into location_types(name,active) values('Район',true);

insert into locations (active,name,id_locations,id_location_type) values(true,'Кыргызстан',null,1);

insert into locations (active,name,id_locations,id_location_type) values(true,'Чуйская область',1,2);
insert into locations (active,name,id_locations,id_location_type) values(true,'Ошская область',1,2);

insert into locations (active,name,id_locations,id_location_type) values(true,'Бишкек',2,3);
insert into locations (active,name,id_locations,id_location_type) values(true,'Ош',3,3);

insert into locations (active,name,id_locations,id_location_type) values(true,'Политех',4,4);
insert into locations (active,name,id_locations,id_location_type) values(true,'Араван',5,4);
insert into locations (active,name,id_locations,id_location_type) values(true,'Джал',4,4);
insert into locations (active,name,id_locations,id_location_type) values(true,'Аламединский',4,4);
insert into locations (active,name,id_locations,id_location_type) values(true,'Ноокат',5,4);

insert into exchange_rate(active,course,end_date,name,start_date) values(true,87.96,'2024-06-20 23:59:59','$', CURRENT_TIMESTAMP);
insert into exchange_rate(active,course,end_date,name,start_date) values(true,85.96,'2024-06-10 11:50:59','$', '2024-06-01 15:52:57');

