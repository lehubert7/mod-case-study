insert into usertype(type) values('ADMIN');
insert into usertype(type) values('MENTOR');
insert into usertype(type) values('SCHOLAR');
commit;

insert into users(id, name, email, password, usertype, location) 
	values(1, 'Admin User', 'admin@xmail.com', 'password', 'ADMIN', 'Bangalore');
insert into users(id, name, email, password, usertype, location) 
	values(2, 'Spring Mentor', 'springmentor@xmail.com', 'password', 'MENTOR', 'Gurgaon');
insert into users(id, name, email, password, usertype, location) 
	values(3, 'Java Scholar', 'javascholar@xmail.com', 'password', 'SCHOLAR', 'Noida');
insert into users(id, name, email, password, usertype, location) 
	values(4, 'Java Mentor ', 'javamentor@xmail.com', 'password', 'MENTOR', 'Chennai');
insert into users(id, name, email, password, usertype, location) 
	values(5, 'React Mentor', 'reactmentor@xmail.com', 'password', 'MENTOR', 'Hyderabad');
insert into users(id, name, email, password, usertype, location) 
	values(6, 'React Scholar', 'reactscholar@xmail.com', 'password', 'SCHOLAR', 'Bangalore');
insert into users(id, name, email, password, usertype, location) 
	values(7, 'Spring Scholar', 'springscholar@xmail.com', 'password', 'SCHOLAR', 'Kolkata');
commit;

insert into technologies(id, name, duration, cost) values(1, 'React Programming', 9, 3000);
insert into technologies(id, name, duration, cost) values(2, 'Java 8 Programming', 5, 2000);
insert into technologies(id, name, duration, cost) values(3, 'Spring MVC Programming', 12, 5000);
commit;

insert into mentorskillstatus(status) values('pending');
insert into mentorskillstatus(status) values('approved');
commit;

insert into mentorskills(mentor, technology, experience, status) values(2, 3, 3, 'approved');
insert into mentorskills(mentor, technology, experience, status) values(4, 2, 1, 'approved');
insert into mentorskills(mentor, technology, experience, status) values(5, 1, 2, 'approved');
insert into mentorskills(mentor, technology, experience, status) values(2, 2, 5, 'pending');
insert into mentorskills(mentor, technology, experience, status) values(2, 1, 2, 'approved');
commit;

insert into trainingstatus(status) values('proposed');
insert into trainingstatus(status) values('confirmed');
insert into trainingstatus(status) values('inprogress');
insert into trainingstatus(status) values('completed');
commit;

insert into trainings (id, scholar, mentor, technology, startdate, enddate, progress, status) 
	values(1, 3, 4, 2, to_date('06-02-2020','DD-MM-YYYY'), to_date('06-20-2020','DD-MM-YYYY'), 100, 'completed');
insert into trainings (id, scholar, mentor, technology, startdate, enddate, progress, status) 
	values(2, 3, 2, 3, to_date('06-02-2020','DD-MM-YYYY'), to_date('06-20-2020','DD-MM-YYYY'), 75, 'inprogress');
insert into trainings (id, scholar, mentor, technology, startdate, enddate, progress, status) 
	values(3, 3, 5, 1, to_date('06-02-2020','DD-MM-YYYY'), to_date('06-20-2020','DD-MM-YYYY'), 40, 'inprogress');
insert into trainings (id, scholar, mentor, technology, startdate, enddate, progress, status) 
	values(4, 3, 4, 2, to_date('06-02-2020','DD-MM-YYYY'), to_date('06-20-2020','DD-MM-YYYY'), 0, 'confirmed');
insert into trainings (id, scholar, mentor, technology, startdate, enddate, progress, status) 
	values(5, 6, 2, 3, to_date('06-02-2020','DD-MM-YYYY'), to_date('06-20-2020','DD-MM-YYYY'), 50, 'inprogress');
insert into trainings (id, scholar, mentor, technology, startdate, enddate, progress, status) 
	values(6, 6, 4, 2, to_date('06-02-2020','DD-MM-YYYY'), to_date('06-20-2020','DD-MM-YYYY'), 0, 'confirmed');
insert into trainings (id, scholar, mentor, technology, startdate, enddate, progress, status) 
	values(7, 7, 5, 1, to_date('06-02-2020','DD-MM-YYYY'), to_date('06-20-2020','DD-MM-YYYY'), 100, 'completed');
insert into trainings (id, scholar, mentor, technology, startdate, enddate, progress, status) 
	values(8, 7, 2, 3, to_date('06-02-2020','DD-MM-YYYY'), to_date('06-20-2020','DD-MM-YYYY'), 0, 'proposed');
commit;

insert into mentorcalendar(mentor, training, startdate, enddate, status) 
	values(4, 1, to_date('06-02-2020','DD-MM-YYYY'), to_date('22-02-2020','DD-MM-YYYY'), 'completed');
insert into mentorcalendar(mentor, training, startdate, enddate, status) 
	values(2, 2, to_date('06-02-2020','DD-MM-YYYY'), to_date('22-02-2020','DD-MM-YYYY'), 'inprogress');
insert into mentorcalendar(mentor, training, startdate, enddate, status) 
	values(5, 3, to_date('06-02-2020','DD-MM-YYYY'), to_date('22-02-2020','DD-MM-YYYY'), 'inprogress');
insert into mentorcalendar(mentor, training, startdate, enddate, status) 
	values(4, 4, to_date('06-02-2020','DD-MM-YYYY'), to_date('22-02-2020','DD-MM-YYYY'), 'proposed');
insert into mentorcalendar(mentor, training, startdate, enddate, status) 
	values(2, 5, to_date('06-02-2020','DD-MM-YYYY'), to_date('22-02-2020','DD-MM-YYYY'), 'inprogress');
insert into mentorcalendar(mentor, training, startdate, enddate, status) 
	values(4, 6, to_date('06-02-2020','DD-MM-YYYY'), to_date('22-02-2020','DD-MM-YYYY'), 'confirmed');
insert into mentorcalendar(mentor, training, startdate, enddate, status) 
	values(5, 7, to_date('06-02-2020','DD-MM-YYYY'), to_date('22-02-2020','DD-MM-YYYY'), 'completed');
commit;

insert into payments(mentor, training, progress, amount) values(4, 1, 50, 1000);
insert into payments(mentor, training, progress, amount) values(5, 7, 50, 1500);
insert into payments(mentor, training, progress, amount) values(2, 2, 50, 2500);
insert into payments(mentor, training, progress, amount) values(2, 5, 50, 2500);
insert into payments(mentor, training, progress, amount) values(4, 1, 100, 1000);
insert into payments(mentor, training, progress, amount) values(5, 7, 100, 1500);
commit;