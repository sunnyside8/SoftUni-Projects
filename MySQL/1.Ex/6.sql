CREATE TABLE people (
`id`INT PRIMARY KEY AUTO_INCREMENT,
 `name` VARCHAR(200) NOT NULL, 
 `picture` BLOB,
 `height` FLOAT(5,2), 
 `weight` FLOAT(5,2), 
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT
);

INSERT INTO `people` (`name`,`picture`,`height`,`weight`,`gender`,`birthdate`,`biography`)
VALUES 
("Sunny",LOAD_FILE('C:\\Users\\Sunny\\Pictures\\Happy-Edition-3D_Chocolate-with-coffee')
,1.67,47.56,"F","1995-07-08",
"Lorem Ipsum is simply dummy text of the printing and typesetting industry.
 Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer 
 took a galley of type and scrambled it to make a type specimen book. "),
 ("Djuli",null,1.77,50.56,"F","1993-07-08",
"Lorem Ipsum is simply dummy text of the printing and typesetting industry.
 Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer 
 took a galley of type and scrambled it to make a type specimen book. "),
 ("Deni",null,1.57,40.56,"F","1995-08-08",
"Lorem Ipsum is simply dummy text of the printing and typesetting industry.
 Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer 
 took a galley of type and scrambled it to make a type specimen book. "),
 ("Teddy",null,1.60,48.56,"F","1989-12-14",
"Lorem Ipsum is simply dummy text of the printing and typesetting industry.
 Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer 
 took a galley of type and scrambled it to make a type specimen book. "),
  ("Penny",null,1.80,55.56,"F","2000-08-08",
"Lorem Ipsum is simply dummy text of the printing and typesetting industry.
 Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer 
 took a galley of type and scrambled it to make a type specimen book. ");