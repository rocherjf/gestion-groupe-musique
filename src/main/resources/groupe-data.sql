

INSERT INTO GROUPE(id,nom, pays, biographie) VALUES (1,'Violet Cold', 'Azerbaïdjan', 'TBD');
INSERT INTO GROUPE(id,nom, pays, biographie) VALUES (2,'Rise Of The NortStar', 'France', 'TBD');
INSERT INTO GROUPE(id,nom, pays, biographie) VALUES (3,'The Great Old Ones', 'France', 'TBD');



INSERT INTO ALBUM (nom, id_artiste, annee, genre, description, url_Image) VALUES ('Anomie',1,'2017','Blackgaze','One-man Azerbaijani musical project','http://e.snmc.io/lk/f/x/1ef89033dc26d0fb42030026da984092/6369357.jpg');
INSERT INTO ALBUM (nom, id_artiste, annee, genre, description, url_Image) VALUES ('Welcame',2,'2014','Beatdown Hardcore','A bunch of angry French boys who love Manga and Music decide to form a band to create some of the most in-your-face, over-the-top Metal ever made.','http://e.snmc.io/lk/f/l/8829cc5e5f544c428214f599ee960832/5486303.jpg');

INSERT INTO ALBUM (nom, id_artiste, annee, genre, description, url_Image) VALUES ('EOD: A Tale of Dark Legacy',3,'2017','Atmospheric Black Metal','Mythologie lovecraftienne','http://e.snmc.io/lk/f/x/7cac413c08a368236f21699d55ce8924/6546136.jpg');
INSERT INTO ALBUM (nom, id_artiste, annee, genre, description, url_Image) VALUES ('Cosmicism',3,'2019','Atmospheric Black Metal','Mythologie lovecraftienne','http://e.snmc.io/i/600/w/dc532edb8dc18906bbedbbe6bc151eb7/7786287/the-great-old-ones-cosmicism-Cover-Art.jpg');
INSERT INTO ALBUM (nom, id_artiste, annee, genre, description, url_Image) VALUES ('TEKELI-LI',3,'2014','Atmospheric Black Metal','Mythologie lovecraftienne','http://e.snmc.io/i/600/w/e6d9635c0e18049438cf471fecfad992/5119520/the-great-old-ones-tekeli-li-Cover-Art.jpg');
INSERT INTO ALBUM (nom, id_artiste, annee, genre, description, url_Image) VALUES ('Al Azif',3,'2012','Atmospheric Black Metal','Mythologie lovecraftienne','http://e.snmc.io/i/600/w/7aac574cbc8623ac71b046d991dd0abc/4065132/the-great-old-ones-al-azif-Cover-Art.jpg');


INSERT INTO CONCERT (ville, nom_de_la_Salle, id_artiste,date) VALUES ('Bordeaux','Rock School Barbey',2, TO_TIMESTAMP('12-05-2019 19:00:00', 'DD-MM-YYYY HH24:MI:SS'));
INSERT INTO CONCERT (ville, nom_de_la_Salle, id_artiste,date) VALUES ('Paris','Zénith de Paris',2, TO_TIMESTAMP('18-08-2019 19:00:00', 'DD-MM-YYYY HH24:MI:SS'));
INSERT INTO CONCERT (ville, nom_de_la_Salle, id_artiste,date) VALUES ('Bordeaux','BT59',3, TO_TIMESTAMP('14-03-2019 19:00:00', 'DD-MM-YYYY HH24:MI:SS'));
