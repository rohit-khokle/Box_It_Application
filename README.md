# Box-It Web-Application
## Project Brief

Box-It web application is a food delivery system that covers complete cycle of purchasing meals online. The web-app also takes restaurant, staff as well as menu management into account. The web-app is based on an enterprise eco-system, wherein an enterprise contains many restaurants and each restaurant has its own staff. Customer can place multiple orders from their choice of restaurant. The aim of the web-app is to make the enterprise management easy and order placement seamless. 

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



## Roles Tasks Performed	
* Customer Account 
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


### Home Page
![ScreenShot](https://github.com/rohit-khokle/Box_It_Application/blob/main/box-it-snaps/1.png)

---
### Customer Screens
![ScreenShot](https://github.com/rohit-khokle/Box_It_Application/blob/main/box-it-snaps/2.png)

---

![ScreenShot](https://github.com/rohit-khokle/Box_It_Application/blob/main/box-it-snaps/3.png)

---

### Admin 

![ScreenShot](https://github.com/rohit-khokle/Box_It_Application/blob/main/box-it-snaps/4.png)

---


![ScreenShot](https://github.com/rohit-khokle/Box_It_Application/blob/main/box-it-snaps/5.png)

---

![ScreenShot](https://github.com/rohit-khokle/Box_It_Application/blob/main/box-it-snaps/6.png)

---

![ScreenShot](https://github.com/rohit-khokle/Box_It_Application/blob/main/box-it-snaps/7.png)

---

![ScreenShot](https://github.com/rohit-khokle/Box_It_Application/blob/main/box-it-snaps/8.png)

---

![ScreenShot](https://github.com/rohit-khokle/Box_It_Application/blob/main/box-it-snaps/9.png)


## Manager, Chef and Delivery Dashboards
---

![ScreenShot](https://github.com/rohit-khokle/Box_It_Application/blob/main/box-it-snaps/11.png)

---

![ScreenShot](https://github.com/rohit-khokle/Box_It_Application/blob/main/box-it-snaps/10.png)

---

![ScreenShot](https://github.com/rohit-khokle/Box_It_Application/blob/main/box-it-snaps/12.png)

---

![ScreenShot](https://github.com/rohit-khokle/Box_It_Application/blob/main/box-it-snaps/13.png)

---

![ScreenShot](https://github.com/rohit-khokle/Box_It_Application/blob/main/box-it-snaps/14.png)

---

![ScreenShot](https://github.com/rohit-khokle/Box_It_Application/blob/main/box-it-snaps/15.png)

---

![ScreenShot](https://github.com/rohit-khokle/Box_It_Application/blob/main/box-it-snaps/16.png)

---

![ScreenShot](https://github.com/rohit-khokle/Box_It_Application/blob/main/box-it-snaps/17.png)

---


## License
[MIT](https://choosealicense.com/licenses/mit/)
