
    alter table abbonamento 
       drop 
       foreign key FK3qnqujr27axv6tltxcx1xnnni;

    alter table certificato 
       drop 
       foreign key FKsuihul2520ft4fjxi4niuuc91;

    drop table if exists abbonamento;

    drop table if exists certificato;

    drop table if exists socio;

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table socio (
        id integer not null auto_increment,
        codice_fiscale varchar(17) not null,
        cognome varchar(50),
        nome varchar(50),
        primary key (id)
    ) engine=InnoDB;

    alter table certificato 
       add constraint UK_harywyc6xemupkqme0y5s5ael unique (socio_id);

    alter table socio 
       add constraint UK_tox6grm7ohkl1mrr70yb2fyan unique (codice_fiscale);

    alter table abbonamento 
       add constraint FK3qnqujr27axv6tltxcx1xnnni 
       foreign key (id_socio) 
       references socio (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    alter table abbonamento 
       drop 
       foreign key FK3qnqujr27axv6tltxcx1xnnni;

    alter table certificato 
       drop 
       foreign key FKsuihul2520ft4fjxi4niuuc91;

    drop table if exists abbonamento;

    drop table if exists certificato;

    drop table if exists socio;

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table socio (
        id integer not null auto_increment,
        codice_fiscale varchar(17) not null,
        cognome varchar(50),
        nome varchar(50),
        primary key (id)
    ) engine=InnoDB;

    alter table certificato 
       add constraint UK_harywyc6xemupkqme0y5s5ael unique (socio_id);

    alter table socio 
       add constraint UK_tox6grm7ohkl1mrr70yb2fyan unique (codice_fiscale);

    alter table abbonamento 
       add constraint FK3qnqujr27axv6tltxcx1xnnni 
       foreign key (id_socio) 
       references socio (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    alter table abbonamento 
       drop 
       foreign key FK3qnqujr27axv6tltxcx1xnnni;

    alter table certificato 
       drop 
       foreign key FKsuihul2520ft4fjxi4niuuc91;

    drop table if exists abbonamento;

    drop table if exists certificato;

    drop table if exists socio;

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table socio (
        id integer not null auto_increment,
        codice_fiscale varchar(17) not null,
        cognome varchar(50),
        nome varchar(50),
        primary key (id)
    ) engine=InnoDB;

    alter table certificato 
       add constraint UK_harywyc6xemupkqme0y5s5ael unique (socio_id);

    alter table socio 
       add constraint UK_tox6grm7ohkl1mrr70yb2fyan unique (codice_fiscale);

    alter table abbonamento 
       add constraint FK3qnqujr27axv6tltxcx1xnnni 
       foreign key (id_socio) 
       references socio (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    alter table abbonamento 
       drop 
       foreign key FK3qnqujr27axv6tltxcx1xnnni;

    alter table certificato 
       drop 
       foreign key FKsuihul2520ft4fjxi4niuuc91;

    drop table if exists abbonamento;

    drop table if exists certificato;

    drop table if exists socio;

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table socio (
        id integer not null auto_increment,
        codice_fiscale varchar(17) not null,
        cognome varchar(50),
        nome varchar(50),
        primary key (id)
    ) engine=InnoDB;

    alter table certificato 
       add constraint UK_harywyc6xemupkqme0y5s5ael unique (socio_id);

    alter table socio 
       add constraint UK_tox6grm7ohkl1mrr70yb2fyan unique (codice_fiscale);

    alter table abbonamento 
       add constraint FK3qnqujr27axv6tltxcx1xnnni 
       foreign key (id_socio) 
       references socio (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);
