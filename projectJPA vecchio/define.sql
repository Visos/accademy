
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

    create table certificato_medico (
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
        messagio varchar(255),
        primary key (code, lang)
    ) engine=InnoDB;

    create table socio (
        id integer not null auto_increment,
        codice_fiscale varchar(17) not null,
        cognome varchar(50),
        nome varchar(50),
        primary key (id)
    ) engine=InnoDB;

    create table utente (
        id integer not null auto_increment,
        role tinyint check (role between 0 and 1),
        password varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table certificato_medico 
       add constraint UK_fh7x211m11apxus0ygp7io1of unique (socio_id);

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

    alter table certificato_medico 
       add constraint FKr17u6bpruq0epjt5g760mbe7c 
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

    create table certificato_medico (
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
        messagio varchar(255),
        primary key (code, lang)
    ) engine=InnoDB;

    create table persone (
        cognome varchar(255),
        color varchar(255),
        email varchar(255),
        id varchar(255) not null auto_increment,
        nome varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table socio (
        id integer not null auto_increment,
        codice_fiscale varchar(17) not null,
        cognome varchar(50),
        nome varchar(50),
        primary key (id)
    ) engine=InnoDB;

    create table utente (
        id integer not null auto_increment,
        role tinyint check (role between 0 and 1),
        password varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table certificato_medico 
       add constraint UK_fh7x211m11apxus0ygp7io1of unique (socio_id);

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

    alter table certificato_medico 
       add constraint FKr17u6bpruq0epjt5g760mbe7c 
       foreign key (socio_id) 
       references socio (id);
