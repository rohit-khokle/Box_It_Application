# Box-It Web-Application
## Project Brief

Box-It web application is a food delivery system that covers complete cycle of purchasing meals online. The web-app also takes restaurant, staff as well as menu management into account. The web-app is based on an enterprise eco-system, wherein an enterprise contains many restaurants and each restaurant has its own staff. Customer can place multiple orders from their choice of restaurant. The aim of the web-app is to make the enterprise management easy and order place seamless. 

## Functionalities

1.	**Full Cart Functionality** - from order placement to delivery while maintaining the session of the cart. Contains one-to-many mapping for  Order-Cart_Items.

2.	**Quick Order check** – Customer can make an AJAX call to check the status of their order

3.	**Order history/Past Order** – Customer can check their order history, accepted and declined orders

4.	**Profile Management**- Customer can update their profile details and payment details

5.	**Password encryption** – B-crypt Password encryption for all profiles

6.	Configured **Spring Security** for authentication and authorization and role specific access

7.	**Staff management**- CRUD on staff with roles as Manager, Delivery, Chef

8.	**Menu Management**- Menu can be added and updated

9.	**Restaurant Management** - Restaurants can be added and updated

10.	**PDF report** on restaurants revenue using iText

11.	**Pagination** across all restaurant and staff tables

12.	Application deployed on **AWS ElasticBean and used RDS MySQL as Database**




## Tech stack

* Framework – Spring MVC (5.2.9) with Spring Security (5.4.1) with Java-based configuration
* Database – AWS RDS MySQL database. (Source code uploaded uses native MySQL database)
* ORM- Hibernate (5.4)
* Views, Styling and UI – JSPs with bootstrap and JSTL
* PDF report generation using Lowagie, iText
* Deployed on AWS ElasticBean



## Roles	Tasks Performed	Example account
* Customer	Account 
  Registration with Validation on fields (unique username constrains maintained)
	Password encryption on the account passwords	Same password
	Choose from range of restaurants, pagination on restaurants	 
	AJAX call on the latest order status check	 
	Order History with Current Order and Past Order 	 
	Cart Items with Order has One to Many mapping	 
	My Profile to add address, payment, and update password	 
	Extensive use of JSTL, Bootstrap to beautify the JSPs	 
	Full Cart Functionality, maintains the cart status throughout the session	 

* Admin Role 
  Admin	View Restaurant with pagination	
	Restaurant management with Add and Update Restaurant support, name uniqueness constrain maintained through validation	
	Staff Management with full CRUD support	 
	Menu Management with Add and Update	 
	View PDF Report on restaurants order status report	

* Manage Role –
  Manager (Restaurant Specific)	Assignment allocation and check each order status
	Order History for that specific restaurant, with all  delivered and declined orders	
	Manage Staff for staff and delivery roles accounts for that specific restaurant. CRUD support	 
	My Profile Update can update their profile- change password, name, address	 

* Chef Role –
  Chef	Dashboard - Chef workspace, view their workspace and pending tasks/orders	
	Work History on which orders they completed	chef_peter
	My Profile Update can update their profile- change password, name, address	 


* Delivery Executive Role –
  Delivery	Dashboard -Delivery workspace, view their workspace and pending tasks/orders	
	Work History on which orders they completed	
	My Profile Update can update their profile- change password, name, address	 



* Special Highlights 
  Spring Security
	Service Facade Design Pattern between Controllers and DAO
	Bcrypt Password Encryption
	Deployed on Cloud


### Home Screen
![ScreenShot](https://github.com/rohit-khokle/Medicare/blob/master/Medicare/snaps/1.PNG)



## Roles and Capabilities
* There are six employee roles and one patient role
* There are also admin roles to manage respective enterprises and one superuser.

### Hospital Enterprise 
* Doctor Assistant – (DA) role – Approves Doctor appointments
* Lab Assistant role – Receives Lab requests and updates Lab Reports
* Doctor role – Processes Patient consultations

### Insurance Enterprise
* Sales Agent role - Receives buy insurance requests from customers. Processes them and sends them for approval
* Claims Agent role – Receives claims request for processing (Patient consultations /Lab Test )
* Manager role – Receives approval requests for buying insurance and Claim requests)

### Customer
* Patient role – Can take doctor consultation and lab test appointments across the network

## Roles and Model Diagram

![ScreenShot](https://github.com/rohit-khokle/Medicare/blob/master/Medicare/snaps/Roles.png)

![ScreenShot](https://github.com/rohit-khokle/Medicare/blob/master/Medicare/snaps/model.png)


## Dashboards for the roles

### Admin
![ScreenShot](https://github.com/rohit-khokle/Medicare/blob/master/Medicare/snaps/admin_dashboard.PNG)

### Customer booking doctor's appointments
![ScreenShot](https://github.com/rohit-khokle/Medicare/blob/master/Medicare/snaps/customer_book_appointment.PNG)

### Customer buying insurance

![ScreenShot](https://github.com/rohit-khokle/Medicare/blob/master/Medicare/snaps/Customer_buy_insurance.PNG)

### Messaging service throughout the applications between roles across network

![ScreenShot](https://github.com/rohit-khokle/Medicare/blob/master/Medicare/snaps/customer_messaging.PNG)


### Doctor Dashboard

![ScreenShot](https://github.com/rohit-khokle/Medicare/blob/master/Medicare/snaps/doc_dashboards.PNG)


### Insurance Agent Dashboard

![ScreenShot](https://github.com/rohit-khokle/Medicare/blob/master/Medicare/snaps/claims_dashboard.PNG)




## License
[MIT](https://choosealicense.com/licenses/mit/)
