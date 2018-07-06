# Passport Management System
A simple Java based application for automation of passport application and issuing procedures.

## Prerequisites
Must have Oracle Java SE installed and configured in the machine. In order to store and retrieve data, MySQL was used. So grab the MySQL driver for Java too. Can use any IDE (eg. NetBeans) to run the software, or can build the executable .jar file yourself from the sources.
The software is hardcoded with the default credentials for MySQL - username is `root` and password is `root`, and assumes MySQL runs at port 3306 by default.

The following tables need to be present in the MySQL database `passportsystem`:
<p align="center"><img src="http://i65.tinypic.com/2eelnnn.png"/></p>

## Using the software
There are two kinds of users - ones who apply for the passport and the admin who issues the passports. New admins can only be added manually using CRUD queries from terminal (functionality not provided in the application).

This is the login screen.
<p align="center"><img src ="http://i67.tinypic.com/14w80wi.png"/>&nbsp&nbsp&nbsp&nbsp<img src="http://i66.tinypic.com/34pcors.png"/></p>

From here, the screens diverge for applicant and the admin users. The following are their respective main screens:
<p align="center"><img src ="http://i65.tinypic.com/2lc72f6.png"/><br><em>Applicant Main Screen</em><br>
<img src="http://i63.tinypic.com/21kim3a.png"/><br><em>Passport Admin Main Screen</em></p>

### Workflow for the applicant
The new applicant will have to first create a new application, furnishing the details requested in the **_Create new application_** screen.
<p align="center"><img src ="http://i64.tinypic.com/nxnkhg.png"/></p>

Once the application is filled completely, the user can click the **Submit** button and get their unique application ID. This application ID must be noted as it will be their reference from here on out.
<p align="center"><img src ="http://i66.tinypic.com/fbapnt.png"/></p>

Once the application is created, the user has to pay for the processing of their application and issue of passport. This can be done using the **_Make Payment_** screen.
<p align="center"><img src ="http://i63.tinypic.com/1fk0hj.png"/></p>

Once the credentials are entered successfully, amount is deducted from the account, and payment status is updated for the application.
<p align="center"><img src ="http://i64.tinypic.com/2mnkdue.png"/></p>

Once payment is successfull, the admin can process the application for manual checks and verification of details. Till the verfication is done, the user has to wait.

The user can check the current status of their application from the **_Check Status_** screen.
<p align="center"><img src ="http://i66.tinypic.com/2evdj7c.png"/>&nbsp&nbsp&nbsp&nbsp<img src ="http://i63.tinypic.com/25recz8.png"/></p>

Once the admin has verified the details, and has authorised the issuing of the passport, they can set the status of the passport to *generated*. The user can then use their unique application ID to generate their passport from the **_Check Status_** screen.
<p align="center"><img src ="http://i68.tinypic.com/2dbtc29.png"/></p>

<p align="center"><img src ="http://i63.tinypic.com/ei5lw1.png"/><br><em>Generated Passport</em></p>

### Workflow for the admin
From the **_Main_** screen, the admin can select any one of the currently pending applications for verification, by entering the application ID into the field and pressing the *Get Application* button.
<p align="center"><img src ="http://i66.tinypic.com/20aoqs1.png"/></p>

From here, the admin can choose to either generate the passport for the application or cancel the application, based on the details entered by the applicant.
<p align="center"><img src ="http://i68.tinypic.com/2a9sk5l.png"/></p>

If the application is approved, then its status is changed to _generated_, and the user will be able to view the generated passport from their **_Check Status_** screen.
