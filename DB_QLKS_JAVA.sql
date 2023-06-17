use qlks;
insert into qlks.guest(guest_name,birth,CCCD,address,nationality,phone_number,vip) values
('Huỳnh Trần Nhât Nam','2002-10-5','321870937','TP.HCM','Việt Nam','0123456789','yes'),
('Trần Ngọc Linh','2006-10-10','123456789102','TP.HCM','Việt Nam','0123456789','no'),
('Nguyễn Phước Tự Tin','2002-10-10','123456789102','TP.HCM','Việt Nam','0123456789','yes'),
('Huỳnh Nam','2002-10-10','123456789102','TP.HCM','Việt Nam','0123456789','yes'),
('Trần Như Huỳnh','2002-10-10','123456789102','TP.HCM','Việt Nam','0123456789','no');

insert into qlks.room(room_number,room_type,vip,price,note,is_empty,image) values 
('101','single','true','1700000','phòng đôi thường','yes','phong_don.jpg'),
('102','couple','true','1500000','Phòng đôi thường','yes','phong-doi.jpg'),
('103','family','true','1700000','Phòng dành cho gia đình 4 người ','yes','phong-doi.jpg'),
('104','couple','true','1700000','phòng đôi thường','yes','phong-doi.jpg'),
('105','single','true','5000000','Phòng view biển','yes','phong_don.jpg'),
('106','couple','true','1700000','Phòng view biển vip','yes','phong-doi.jpg'),
('107','couple','true','3500000','Phòng tổng thống vip','yes','phong-doi.jpg');

insert into qlks.food_item(food_item_id,food_item_name,image,price) 
values('1','Gà rán','','500000'),
('2','lẩu dê','','1500000'),
('3','lẩu bò','','500000'),
('4','gỏi gà măng cụt','','200000'),
('5','Kem cuộn','','120000');

insert into qlks.service(service_id,service_name,price,note) 
values('1','Quầy bar','0','miễn phí'),
('2','Dịch vụ Spa','2500000',''),
('3','Fitness center','100000',''),
('4','Sân golf và sân tennis','200000','');

insert into qlks.section(section_id,section_name,section_manager_id)
values  ('1','letan','1'),
		('2','bao ve','2'),
        ('3','ve sinh','3'),
        ('4','nha bep','4');
        
insert into qlks.employee(maNV,CCCD,tennv,ngay_sinh,gioi_tinh,dia_chi,email,phone_number,luong,section_id)
values  ('1','9872587','Huỳnh Nam','10/04/2002','Nam','TP.HCM','N@gmail.com','012345678','25000','1'),
		('2','9872587','Như Huỳnh','10/04/2002','Nu','TP.HCM','N@gmail.com','012345678','25000','1'),
		('3','9872587','Tự Tin','10/04/2002','Nam','TP.HCM','N@gmail.com','012345678','200000','1'),
		('4','9872587','Văn Thành','10/04/2002','Nam','TP.HCM','N@gmail.com','012345678','200000','1');
		
INSERT INTO qlks.user (user_id,email,username,password) VALUES
(1,'ramesh@gmail.com','ramesh','$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em'),
(2,'admin@gmail.com','admin','$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu');

INSERT INTO qlks.role VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');

INSERT INTO qlks.user_role VALUES (2,1),(1,2);