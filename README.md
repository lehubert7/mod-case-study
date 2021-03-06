# mod-case-study

Business Requirement(Mentor On Demand)
Build  a  software  system  which  lets  users  search  for  a  Mentor  for  a  specific  Technical Course,  User can search, select, propose & finalize a Mentor of his Choice, post which Training gets started. Along with   B2C,   B2B   functionality   also   need   to   be   supported,   for   which   Users   can   be   Corporate Organizations  seeking  Technical  Courses,  which  are  offered  by  various  Vendor  Organizations(which may have  pool of Trainers). Payment processing, E-mail interaction is within scope of the Project.
Project  can  be  divided  into  two  Phases  1  and  2.  Phase  1  comprises  Retail  Use  Cases(B2C)  and Corporate related Use Cases(B2B).

Retail Use cases
Below are the different roles, which need to be supported by above Software System.
#1. User(Retail)
#2. Mentor(Retail)
#3. Admin
Below are the Use Cases which need to be supported by each of above Roles

User(Retail)Use Cases.
User should  be  able  to  Signup. Email ID can  be  used  as  username,  which need  to  be  confirmed by User to complete Signup process.
User should be able to Sign in.
User  can  search for  Mentors for  a  specific  Time  and  Technology(mandatory), even without  signing in.
Search results need to list Mentors having expertise in specific Technology, who are available in that specific time(Mentor's Calendar can be checked to display search results)
A search result has to display Name of Mentor, years of experience, no. of trainings delivered in total and in specific technology, Fee charged (including commission).
After  viewing  Mentor's  Profile/History/Rating, User  can select a  specific  Trainer from  above  Search Results and should be possible to send Proposal, to the Mentor.
Once the User Proposes, Propose request is received by a specific Mentor. A Mentor can Confirm or Reject a Proposal. Proposal Confirmation or Rejection need to be sent to User.
User  can Finalize a  Confirmed  Proposal response, after  which user  need  to  make payment,  for Training Course.
Payment  is  collected  in  advance  from  User. But  Mentor  will  be  paid  in  4  slots,  as  the  Training Progress reaches 25%, 50%, 75% and 100% Actual progress need to be updated by User.
Should be possible to Rate any Mentor, of the Trainings which are in Progress
User should be able to view list of Current Trainings in Progress.
Trainings in any of below states are considered to be in Progress.
a. Proposed.
b. Confirmed Proposals
c. Trainings started, and not completed
User should be able to view List of Trainings already availed and Completed.

Mentor Use Cases
Mentor need to Sign Up to provide Mentoring service through the Portal
During  Sign Up  process  Mentor  need  to provide  time zone/working  timings,  list  of  technologies, facilities provided -material, examples/cloud labs, email/mobile number verification, Linkedin URL, mentor profile, number of years of experience. Email id can be used as Mentor’s username.
View History of Mentor -Trainings delivered, ratings, etc...
Payment  will  be  fixed  based  on Technology/Complexity,  etc...  and  based  on  Trainers  experience, proposal
Trainer will be paid in 4 slots, based on progress
Payment will get accumulated based on Progress, which can be withdrawn by Trainer.
E-Mail  Notifications  need  to  be  automatically  sent  to  User  and  Mentor, during  appropriate  Use Cases.

Admin Use Cases
Admin can add/remove List of Technologies
Block or Unblock User or Mentor
Admin should be able to search the Payments made, and display reports
Admin  should  be  able  to edit parameters such  as  Payment  Commission  percentage(which  will  be deducted from the payments done by User).
Contact details should be confidential, and should not be shared with each other

Database Tables
Below are list of Database Tables.
Table Name      Purpose
Users           Stores list of User, Mentor, Admin –usernames and login credentials
Technologies    Store list of all Technologies, whose Trainings are supported by Portal
Trainings       Stores details of each Training in progress or completed
MentorSkills    Stores skills of Mentor
MentorCalendar  Stores Calendar slots of a Trainer
Payments        Stores payments released to Trainer, based on Training Progress

Full Stack Technologies
The technologies included in Full Stack are not limited to following but may consist of:
•UI Layer (HTML5, CSS3, Bootstrap4, JavaScript, Jquery, Angular 4/6)
•Middleware Restful API (Spring Boot Restful& MicroServices, JAX-RS, Spring MVC)
•Database Persistence ( Hibernate)
•Database layer (MySQL, MongoDB)
•Ancillary skills (GIT, Jenkins(CI/CD), Docker, Maven) etc.

To complete this case study, you should be comfortable with basic single page web application concepts including REST and CRUD. You may use angular-cli to create your template project. All web pages need to be responsive.
Ref 1:https://cli.angular.io/
Ref 2: https://github.com/angular/angular-cli

Spring Microservices Tools to be used
As already specified under Full Stack Technologies Microservice Architecture need to be followed.  Ensure that the Application is divided into multiple Microservices, along with database/tables each Microservice Manages. Below Spring Microservices Tools need to be used
•Zuul API Gateway
•Eureka Service Registry & Discovery
•Ribbon Client side Load Balancer
•Feign Client
•Hystrix Circuit Breaker & Fault Tolerant Tool(optional


Technical Spec –Solution Development Environment
Front End Layer
Framework(s)/SDK/Libraries  Version
Angular with TypeScript     4/6
Bootstrap                   3.0 or above
CSS                         3
HTML                        5
JavaScript                  1.8 or above
JQuery                      1.3

Middle Tier Layer
Technology        Framework(s)/SDK/Libraries    Version
Java Stack        Spring Boot                   1.5 or above
                  Spring MVC                    4.0 or above
                  JDK                           1.7 or above
                  Maven                         3.x or above

Database & Integration Layer
Technology        Framework(s)/SDK/Libraries      Version
Java Stack        Hibernate                       4.0 or above
                  JAX-RS Jersey/ Spring Restful
                  MySQL                           5.7.19
MongoDB           MongoDB                         3.4
                  NoSQL

Ancillary Layer
Technology                        Framework(s)/SDK/Libraries    Version
Source Code Management Tool       GIT                           2.14.2
Build Tool/JAVA Stack             Maven                         3.x
Testing Tool/JAVA Stack           JUnit/Mockito                 4.x
Testing Tool/JAVA Stack           Spring Test                   4.x
Controllers can be  tested using Postman Tool

Security
Name                  Version
Spring Boot Security
JWT


Other Design constraints
Below are other Design constraints to be considered
•Integrate with any SMTP Server, to send Emails in appropriate Use cases
•Integrate with any Payment Gateway to process Payments

Assessment Deliverables
1.For Front End –zipped Angular application
2.For Backend -Packaged code files (Source code and WAR).
3.For SCM* –Project Code should be present in active GIT repository, and GIT repo url also need to be shared.(*SCM –Source Code Management)
4.Few Steps on how to run the solution.
5.Screen shots of web pages and running application
6.Test code need to be included

Important Instructions
1.Adhere to the design specifications mentioned in the case study.
2.Please  make  sure  that  your  code  does  not  have  any  compilation  errors  while  submitting your case study solution.
3.The  final  solution  should  be  a  zipped  code  having  solution.  Solution  code  will  be  used  to perform Static code evaluation.
4.Implement the code using best design standards/family Design Patterns.
5.Use Internationalization for all the labels and messages in Rest API Development.
6.Do not use System out statements or console.log for logging in Rest API and Front End respectively. Use appropriate logging methods for logging statements/variable/return values.
7.If you are using Spring Restful or Jersey JAX-RS to develop Rest API, then use Maven to build the project and create WAR file.
8.Write web service which takes input and return required details from database.
9.Use JSON format to transfer the results
