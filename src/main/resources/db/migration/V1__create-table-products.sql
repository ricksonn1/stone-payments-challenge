create table products(

    id bigint not null auto_increment,
    title varchar(250),
    price integer not null,
    zipcode varchar(9) not null,
    seller varchar(250) not null,
    thumbnail_hd varchar(250) not null,
    date varchar(200) not null,

    primary key(id)
);