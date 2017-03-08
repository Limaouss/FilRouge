/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de cr�ation :  3/7/2017 3:47:27 PM                      */
/*==============================================================*/


drop table if exists COMPETITION;

drop table if exists EQUIPE;

drop table if exists JOUER;

drop table if exists PHASE_FINALE;

drop table if exists POSSEDER;

drop table if exists POULE;

drop table if exists PRONOSTIQUER;

drop table if exists RENCONTRE;

drop table if exists ROLE;

drop table if exists USER;

/*==============================================================*/
/* Table : COMPETITION                                          */
/*==============================================================*/
create table COMPETITION
(
   ID_COMPETITION       int not null AUTO_INCREMENT,
   DATE_DEBUT           date,
   DATE_FIN             date,
   primary key (ID_COMPETITION)
);

/*==============================================================*/
/* Table : EQUIPE                                               */
/*==============================================================*/
create table EQUIPE
(
   ID_EQUIPE            int not null AUTO_INCREMENT,
   PAYS                 varchar(15),
   ID_POULE		int,
   primary key (ID_EQUIPE)
);

/*==============================================================*/
/* Table : JOUER                                                */
/*==============================================================*/
create table JOUER
(
   ID_EQUIPE            int not null,
   ID_RENCONTRE         int not null,
   primary key (ID_EQUIPE, ID_RENCONTRE)
);

/*==============================================================*/
/* Table : PHASE_FINALE                                         */
/*==============================================================*/
create table PHASE_FINALE
(
   ID_PHASE_FINALE       int not null AUTO_INCREMENT,
   ID_COMPETITION       int not null,
   TYPE                 varchar(10),
   primary key (ID_PHASE_FINALE)
);

/*==============================================================*/
/* Table : POSSEDER                                             */
/*==============================================================*/
create table POSSEDER
(
   ID_USER              int not null,
   ID_ROLE              int not null,
   primary key (ID_USER, ID_ROLE)
);

/*==============================================================*/
/* Table : POULE                                                */
/*==============================================================*/
create table POULE
(
   ID_POULE             int not null AUTO_INCREMENT,
   ID_COMPETITION       int not null,
   CODE                 char(1),
   primary key (ID_POULE)
);

/*==============================================================*/
/* Table : PRONOSTIQUER                                         */
/*==============================================================*/
create table PRONOSTIQUER
(
   ID_USER              int not null,
   ID_RENCONTRE         int not null,
   SCOREEQUIPEA         int not null,
   SCOREEQUIPEB         int not null,
   primary key (ID_USER, ID_RENCONTRE)
);

/*==============================================================*/
/* Table : RENCONTRE                                            */
/*==============================================================*/
create table RENCONTRE
(
   ID_RENCONTRE         int not null AUTO_INCREMENT,
   ID_PHASE_FINALE      int,
   ID_POULE             int,
   DATE                 date,
   SCOREEQUIPEA         int,
   SCOREEQUIPEB         int,
   primary key (ID_RENCONTRE)
);

/*==============================================================*/
/* Table : ROLE                                                 */
/*==============================================================*/
create table ROLE
(
   ID_ROLE              int not null AUTO_INCREMENT,
   TYPE                 varchar(10),
   primary key (ID_ROLE)
);

/*==============================================================*/
/* Table : USER                                                 */
/*==============================================================*/
create table USER
(
   ID_USER              int not null AUTO_INCREMENT,
   USERNAME             varchar(50),
   PASSWORD             varchar(50),
   POINTS               int,
   primary key (ID_USER)
);

alter table JOUER add constraint FK_JOUER foreign key (ID_EQUIPE)
      references EQUIPE (ID_EQUIPE) on delete restrict on update restrict;

alter table JOUER add constraint FK_JOUER2 foreign key (ID_RENCONTRE)
      references RENCONTRE (ID_RENCONTRE) on delete restrict on update restrict;

alter table PHASE_FINALE add constraint FK_CONCERNER2 foreign key (ID_COMPETITION)
      references COMPETITION (ID_COMPETITION) on delete restrict on update restrict;

alter table POSSEDER add constraint FK_POSSEDER foreign key (ID_USER)
      references USER (ID_USER) on delete restrict on update restrict;

alter table POSSEDER add constraint FK_POSSEDER2 foreign key (ID_ROLE)
      references ROLE (ID_ROLE) on delete restrict on update restrict;

alter table POULE add constraint FK_CONCERNER foreign key (ID_COMPETITION)
      references COMPETITION (ID_COMPETITION) on delete restrict on update restrict;

alter table PRONOSTIQUER add constraint FK_PRONOSTIQUER foreign key (ID_USER)
      references USER (ID_USER) on delete restrict on update restrict;

alter table PRONOSTIQUER add constraint FK_PRONOSTIQUER2 foreign key (ID_RENCONTRE)
      references RENCONTRE (ID_RENCONTRE) on delete restrict on update restrict;

alter table RENCONTRE add constraint FK_APPARTENIR_PHASE foreign key (ID_PHASE_FINALE)
      references PHASE_FINALE (ID_PHASE_FINALE) on delete restrict on update restrict;

alter table RENCONTRE add constraint FK_APPARTENIR_POULE foreign key (ID_POULE)
      references POULE (ID_POULE) on delete restrict on update restrict;

alter table EQUIPE add constraint FK_EQUIPE_POULE foreign key (ID_POULE)
      references POULE (ID_POULE) on delete restrict on update restrict;

