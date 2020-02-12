drop table if exists usertype;
create table usertype (
	id int auto_increment not null,
    type varchar(255) not null,
    primary key(id),
    constraint ut_type unique (type)
);

drop table if exists users;
create table users (
	id int auto_increment not null,
    name varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    usertype varchar(255) not null,
    location varchar(255) not null,
    primary key(id),
    constraint ur_email unique (email),
    constraint ur_usertype
    foreign key (usertype)
    references usertype (type)
);

drop table if exists technologies;
create table technologies (
    id int auto_increment not null,
    name varchar(255) not null,
    duration int not null,
    cost int not null,
    primary key(id)
);

drop table if exists trainingstatus;
create table trainingstatus (
	id int auto_increment not null,
    status varchar(255) not null,
    primary key(id),
    constraint ts_status unique (status)
);

drop table if exists trainings;
create table trainings (
    id int auto_increment not null,
    scholar int not null,
    mentor int not null,
    technology int not null,
    startdate date not null,
    enddate date,
    progress int not null default 0,
    status varchar(255) not null default 'proposed',
    primary key(id),
    constraint tr_scholar
    foreign key (scholar)
    references users (id),
    constraint tr_mentor
    foreign key (mentor)
    references users (id),
    constraint tr_technology
    foreign key (technology)
    references technologies (id),
    constraint tr_status
    foreign key (status)
    references trainingstatus (status)
);

drop table if exists mentorskillstatus;
create table mentorskillstatus (
	id int auto_increment not null,
    status varchar(255) not null,
    primary key(id),
    constraint mss_status unique (status)
);

drop table if exists mentorskills;
create table mentorskills (
    id int auto_increment not null,
    mentor int not null,
    technology int not null,
    experience int not null,
    status varchar(255) not null default 'pending',
    primary key(id),
    constraint ms_mentor
    foreign key (mentor)
    references users (id),
    constraint ms_technology
    foreign key (technology)
    references technologies (id),
    constraint ms_status
    foreign key (status)
    references mentorskillstatus (status)
);

drop table if exists mentorcalendar;
create table mentorcalendar (
    id int auto_increment not null,
    mentor int not null,
    training int not null,
    startdate date not null,
    enddate date not null,
    status varchar(255) not null,
    primary key(id),
    constraint mc_mentor
    foreign key (mentor)
    references users (id),
    constraint mc_training
    foreign key (training)
    references trainings (id),
    constraint mc_status
    foreign key (status)
    references trainingstatus (status)
);

drop table if exists payments;
create table payments (
    id int auto_increment not null,
    mentor int not null,
    training int not null,
    progress int not null,
    amount int not null,
    primary key(id),
    constraint pm_mentor
    foreign key (mentor)
    references users (id),
    constraint pm_training
    foreign key (training)
    references trainings (id)
);





