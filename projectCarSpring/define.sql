
    alter table sospensioni 
       drop 
       foreign key FKp81l2gwpkps0dq2omjybjornc;

    alter table sospensioni 
       drop 
       foreign key FKj5iaauschqqpvblqdqy6fo5dr;

    alter table veicolo 
       drop 
       foreign key FK86sw4w41kfvddcal21jbtrsoo;

    alter table veicolo 
       drop 
       foreign key FKb6e1fhaddjtdd7pprcw8t7v5t;

    alter table veicolo 
       drop 
       foreign key FKg0gifxaj166l67dfuaix6gx65;

    alter table veicolo 
       drop 
       foreign key FK676kcray54mxm3vae0yb7bv4b;

    alter table veicolo 
       drop 
       foreign key FKmn53er470bboe9wtbwhsk2owp;

    alter table veicolo 
       drop 
       foreign key FK8pusl64ot3mrlrusuai4gsc41;

    drop table if exists bici;

    drop table if exists colore;

    drop table if exists macchina;

    drop table if exists moto;

    drop table if exists sospensioni;

    drop table if exists tipo_alimentazione;

    drop table if exists tipo_veicolo;

    drop table if exists tipo_ammortizzatore;

    drop table if exists veicolo;

    create table bici (
        id integer not null,
        pieghevole bit,
        tipo_uso varchar(50),
        primary key (id)
    ) engine=InnoDB;

    create table colore (
        code integer not null,
        descrizione varchar(255),
        primary key (code)
    ) engine=InnoDB;

    create table macchina (
        id integer not null,
        numero_porte integer,
        numerotarga varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table moto (
        cc integer,
        id integer not null auto_increment,
        targa varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table sospensioni (
        bici_id integer not null,
        sospensioni integer not null
    ) engine=InnoDB;

    create table tipo_alimentazione (
        code varchar(255) not null,
        descrizione varchar(255),
        primary key (code)
    ) engine=InnoDB;

    create table tipo_veicolo (
        descrizione varchar(255),
        id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table tipo_ammortizzatore (
        id integer not null,
        descrizione varchar(50),
        primary key (id)
    ) engine=InnoDB;

    create table veicolo (
        colore integer,
        id integer not null auto_increment,
        id_bici integer,
        id_macchina integer,
        id_moto integer,
        marca integer,
        n_posti integer,
        numero_ruote integer,
        tipo_alimentazione varchar(255),
        tipo_veicolo varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table macchina 
       add constraint UK_8qt2agh5mmct1jlokcni769ou unique (numerotarga);

    alter table moto 
       add constraint UK_2i3efrjuh6fy8isx13wtioxpr unique (targa);

    alter table veicolo 
       add constraint UK_5bymgy200kk69dmnfiysdf7lf unique (id_bici);

    alter table veicolo 
       add constraint UK_13ks038o7h9c9x4qi5bchu0wj unique (id_macchina);

    alter table veicolo 
       add constraint UK_89l9dmjnynoafgwaj6p2do24b unique (id_moto);

    alter table sospensioni 
       add constraint FKp81l2gwpkps0dq2omjybjornc 
       foreign key (sospensioni) 
       references tipo_ammortizzatore (id);

    alter table sospensioni 
       add constraint FKj5iaauschqqpvblqdqy6fo5dr 
       foreign key (bici_id) 
       references bici (id);

    alter table veicolo 
       add constraint FK86sw4w41kfvddcal21jbtrsoo 
       foreign key (id_bici) 
       references bici (id);

    alter table veicolo 
       add constraint FKb6e1fhaddjtdd7pprcw8t7v5t 
       foreign key (colore) 
       references colore (code);

    alter table veicolo 
       add constraint FKg0gifxaj166l67dfuaix6gx65 
       foreign key (id_macchina) 
       references macchina (id);

    alter table veicolo 
       add constraint FK676kcray54mxm3vae0yb7bv4b 
       foreign key (id_moto) 
       references moto (id);

    alter table veicolo 
       add constraint FKmn53er470bboe9wtbwhsk2owp 
       foreign key (tipo_alimentazione) 
       references tipo_alimentazione (code);

    alter table veicolo 
       add constraint FK8pusl64ot3mrlrusuai4gsc41 
       foreign key (tipo_veicolo) 
       references tipo_veicolo (id);
