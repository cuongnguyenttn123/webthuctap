drop database dbthuctapcongnhan;

create database dbthuctapcongnhan CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci';
use dbthuctapcongnhan;

CREATE TABLE `dbthuctapcongnhan`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(255) NULL,
  `enabled` INT(1) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC));
  
CREATE TABLE `dbthuctapcongnhan`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `dbthuctapcongnhan`.`users_roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user` INT NULL,
  `role` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `_idx` (`user` ASC),
  INDEX `dfdf_idx` (`role` ASC),
  CONSTRAINT `user`
    FOREIGN KEY (`user`)
    REFERENCES `dbthuctapcongnhan`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `role`
    FOREIGN KEY (`role`)
    REFERENCES `dbthuctapcongnhan`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    INSERT INTO `users` VALUES (1,'cuongnguyen','$2a$04$GYGsaJj9l6kH2GikK6QVzO0v3sOCxt3vdkiA2/tcoSw8erI85ZYDG',1),(2,'nhutran','$2a$04$GYGsaJj9l6kH2GikK6QVzO0v3sOCxt3vdkiA2/tcoSw8erI85ZYDG',1);
    
    INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
INSERT INTO `users_roles` VALUES (1,1,1),(2,1,2),(4,2,2);

create table baihoc(
idbaihoc integer auto_increment,
tenbaihoc nvarchar(255),
chuthich nvarchar(255),
iduser integer,
level nvarchar(50),
primary key(idbaihoc),
constraint FK_iduser_idbaihoc foreign key(iduser) references users(id)
);

create table tuvung(
idtuvung integer auto_increment,
tentuvung nvarchar(255),
kanji nvarchar(255),
phienam nvarchar(255),
nghia nvarchar(255),
idbaihoc integer,
primary key(idtuvung),
constraint FK_idtuvung_idbaihoc foreign key(idbaihoc) references baihoc(idbaihoc)
);
create table nguphap(
idnguphap integer auto_increment,
tennguphap varchar(50),
url varchar(255),
noidung text,
idbaihoc integer,
primary key(idnguphap),
constraint FK_idnguphap_idbaihoc foreign key(idbaihoc) references baihoc(idbaihoc)
);

create table baiviet(
idbaiviet integer auto_increment,
tenbaiviet nvarchar(255),
noidung text,
iduser integer,
hinhanh nvarchar(255),
chuthich nvarchar(255),
primary key(idbaiviet),
constraint FK_iduser_idbaiviet foreign key(iduser) references users(id)
);

