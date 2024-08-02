
    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer not null auto_increment,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    ) engine=InnoDB;

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    ) engine=InnoDB;

    create table attivita (
        id integer not null auto_increment,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table certificato (
        id integer not null auto_increment,
        socio_id integer,
        tipo bit,
        data_certificato varchar(10),
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table `messaggi-international` (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
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

    alter table abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita (id);

    alter table abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento (id);

    alter table certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio (id);

    create table abbonamento (
        id integer generated by default as identity,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    );

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    );

    create table attivita (
        id integer generated by default as identity,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    );

    create table certificato (
        id integer generated by default as identity,
        socio_id integer unique,
        tipo boolean,
        data_certificato varchar(10),
        primary key (id)
    );

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    );

    create table "messaggi-international" (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
    );

    create table socio (
        id integer generated by default as identity,
        codice_fiscale varchar(17) not null unique,
        cognome varchar(50),
        nome varchar(50),
        primary key (id)
    );

    alter table if exists abbonamento 
       add constraint FK3qnqujr27axv6tltxcx1xnnni 
       foreign key (id_socio) 
       references socio;

    alter table if exists abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita;

    alter table if exists abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento;

    alter table if exists certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio;

    create table abbonamento (
        id integer generated by default as identity,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    );

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    );

    create table attivita (
        id integer generated by default as identity,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    );

    create table certificato (
        id integer generated by default as identity,
        socio_id integer unique,
        tipo boolean,
        data_certificato varchar(10),
        primary key (id)
    );

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    );

    create table "messaggi-international" (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
    );

    create table socio (
        id integer generated by default as identity,
        codice_fiscale varchar(17) not null unique,
        cognome varchar(50),
        nome varchar(50),
        primary key (id)
    );

    alter table if exists abbonamento 
       add constraint FK3qnqujr27axv6tltxcx1xnnni 
       foreign key (id_socio) 
       references socio;

    alter table if exists abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita;

    alter table if exists abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento;

    alter table if exists certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio;

    create table abbonamento (
        id integer generated by default as identity,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    );

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    );

    create table attivita (
        id integer generated by default as identity,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    );

    create table certificato (
        id integer generated by default as identity,
        socio_id integer unique,
        tipo boolean,
        data_certificato varchar(10),
        primary key (id)
    );

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    );

    create table "messaggi-international" (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
    );

    create table socio (
        id integer generated by default as identity,
        codice_fiscale varchar(17) not null unique,
        cognome varchar(50),
        nome varchar(50),
        primary key (id)
    );

    alter table if exists abbonamento 
       add constraint FK3qnqujr27axv6tltxcx1xnnni 
       foreign key (id_socio) 
       references socio;

    alter table if exists abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita;

    alter table if exists abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento;

    alter table if exists certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio;

    create table abbonamento (
        id integer generated by default as identity,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    );

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    );

    create table attivita (
        id integer generated by default as identity,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    );

    create table certificato (
        id integer generated by default as identity,
        socio_id integer unique,
        tipo boolean,
        data_certificato varchar(10),
        primary key (id)
    );

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    );

    create table "messaggi-international" (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
    );

    create table socio (
        id integer generated by default as identity,
        codice_fiscale varchar(17) not null unique,
        cognome varchar(50),
        nome varchar(50),
        primary key (id)
    );

    alter table if exists abbonamento 
       add constraint FK3qnqujr27axv6tltxcx1xnnni 
       foreign key (id_socio) 
       references socio;

    alter table if exists abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita;

    alter table if exists abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento;

    alter table if exists certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio;

    create table abbonamento (
        id integer generated by default as identity,
        id_socio integer,
        data_iscrizione varchar(10) not null,
        primary key (id)
    );

    create table abbonamento_attivita (
        abbonamento_id integer not null,
        attivita_id integer not null
    );

    create table attivita (
        id integer generated by default as identity,
        descrizione_attivita varchar(50) not null,
        primary key (id)
    );

    create table certificato (
        id integer generated by default as identity,
        socio_id integer unique,
        tipo boolean,
        data_certificato varchar(10),
        primary key (id)
    );

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    );

    create table "messaggi-international" (
        code varchar(255) not null,
        lang varchar(255) not null,
        messaggio varchar(255),
        primary key (code, lang)
    );

    create table socio (
        id integer generated by default as identity,
        codice_fiscale varchar(17) not null unique,
        cognome varchar(50),
        nome varchar(50),
        primary key (id)
    );

    alter table if exists abbonamento 
       add constraint FK3qnqujr27axv6tltxcx1xnnni 
       foreign key (id_socio) 
       references socio;

    alter table if exists abbonamento_attivita 
       add constraint FK853iwjge5sco7nac3v8pvs72v 
       foreign key (attivita_id) 
       references attivita;

    alter table if exists abbonamento_attivita 
       add constraint FK26msat1ym806xqp9vi69d8eba 
       foreign key (abbonamento_id) 
       references abbonamento;

    alter table if exists certificato 
       add constraint FKsuihul2520ft4fjxi4niuuc91 
       foreign key (socio_id) 
       references socio;
