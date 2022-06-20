# CSOC-WEEK-3-Android-Flutter

## Assignment
This week, you'll be building todo application either by using Native Android or Flutter.

Having knowledge of the previous week is necessary since you would have gone through the basics of respective tracks.

Enable your TODO maker App to store and retrieve data to/from provided REST APIs. This means you will have the ability to have the same data on different devices on which your app is installed. We have created a backend server containing the API endpoints required for this application to function completely -  [https://todo-app-csoc.herokuapp.com/](https://todo-app-csoc.herokuapp.com/)

*The complete description of the API is mentioned at the end of this readme.*

## Tasks
As mentioned above you task is to build todo application and connect it to the APIs. 
In particular, you will have to implement authentication in your app and store seperate todos for each user. 
Your app should have these features :
- A Login and Register screen
- A button on the home screen that will allow the user to create a new todo which should be updated instantly on the home screen. 
- The home screen should also have a search bar to search for any todo in the list. On searching, only relevant todos should show up on the screen. 
- The user should also be able to delete and update any todo. (Home screen should update the list instantly after deleting/updating)
- **Bonus Task:** Add animation of any kind on any definite action or screen movements. It can be anything so use your imagination and creativity as you like :)

## Points
Here is the breakdown of the points related to each task.

|**Task**|**Points**  |
|--|--|
| Authentication | 20 |
|API Handling|20|
|Add task|20|
|Get tasks|20|
|Edit Task|20|
|Delete Task|20|
|Quality of Code|10|
|Design, Smoothness and Innovation|20|
|Bonus Task - Animation|50|
|**Total**|200|

## Judging
Judging would be done on the basis of your implementation and authenticity.

## Deadline
You'll have a week to complete this task. Hence, the deadline of this task is **26th June, 2022** 

## Submission Guidelines :

- Create your own repo and implement the above tasks
- Then, Fork this repository and clone it
- Make a new entry into submissions as explained in comments, i.e, add your github repo link and .apk file of your application
- Commit and Push the changes in respective readme (either  Android.md or Flutter.md)
- Make a Pull request and add your repo and apk link in PR template too.


## API Usage

### Auth System
All the requests made to the API (except the Login and Register endpoints) need an  **Authorization header**  with a valid token and the prefix  **Token**

`Authorization: Token <token>`

In order to obtain a valid token it's necessary to send a request  `POST /auth/login/`  with  **username**  and  **password**. To register a new user it's necessary to make a request  `POST /auth/register/`  with name, email, username and password.

### End Points

**Auth**

-   `POST /auth/login/`

	Takes the username and password as input, validates them and returns the **Token**, if the credentials are valid.

	Request Body (Sample):
	```
	{
	  "username": "string",
	  "password": "string"
	}
	```
	Response Body (Sample):
	```
	{
	  "token":  "string"
	}
	```
	Response Code: `200`

-   `POST /auth/register/`

	Register a user in Django by taking the name, email, username and password as input.

	Request Body (Sample):
	```
	{
	  "name": "string",
	  "email": "user@example.com",
	  "username": "string",
	  "password": "string"
	}
	```
	Response Body (Sample):
	```
	{
	  "token":  "string"
	}
	```
	Response Code: `200`

-   `POST /auth/profile/`

	Retrieve the id, name, email and username of the logged in user. Requires token in the Authorization header.

	Response Body (Sample):
	```
	{
	  "id":  1,
	  "name":  "string",
	  "email":  "user@example.com",
	  "username":  "string"
	}
	```
	Response Code: `200`


**Todo**

-   `GET /todo/`

	Get all the Todos of the logged in user. Requires token in the Authorization header.

	Response Body (Sample):
	```
	[
	  {
	    "id":  1,
	    "title":  "string"
	  },
	  {
	    "id":  2,
	    "title":  "string"
	  }
	]
	```
	Response Code: `200`

-   `POST /todo/create/`

	Create a Todo entry for the logged in user. Requires token in the Authorization header.

	Request Body (Sample):
	```
	{
	  "title": "string"
	}
	```
	Response Code: `200`

-   `GET /todo/{id}/`

	Get the Todo of the logged in user with given id. Requires token in the Authorization header.

	Response Body (Sample):
	```
	{
	  "id":  1,
	  "title":  "string"
	}
	```
	Response Code: `200`

-   `PUT /todo/{id}/`

	Change the title of the Todo with given id, and get the new title as response. Requires token in the Authorization header.

	Request Body (Sample):
	```
	{
	  "title": "string"
	}
	```
	Response Body (Sample):
	```
	{
	  "id":  1,
	  "title":  "string"
	}
	```

-   `PATCH /todo/{id}/`

	Change the title of the Todo with given id, and get the new title as response. Requires token in the Authorization header.

	Request Body (Sample):
	```
	{
	  "title": "string"
	}
	```
	Response Body (Sample):
	```
	{
	  "id":  1,
	  "title":  "string"
	}
	```

-   `DELETE /todo/{id}/`

	Delete the Todo with given id. Requires token in the Authorization header.

	Response Code: `204`

All the requests must be prefixed with the base URL of the API.
Example: for login the `POST` request must be sent to `https://todo-app-csoc.herokuapp.com/auth/login/` with the required details. **Make sure to append a slash at the end, otherwise you may encounter an error while making the `POST` request.**

### Documentation
Swagger generated docs: [https://todo-app-csoc.herokuapp.com/](https://todo-app-csoc.herokuapp.com/)\
ReDoc generated docs: [https://todo-app-csoc.herokuapp.com/redoc/](https://todo-app-csoc.herokuapp.com/redoc/)

### Testing the API

The API can be tested by going to the deployed URL: [https://todo-app-csoc.herokuapp.com/](https://todo-app-csoc.herokuapp.com/), clicking the "Try it out" button after selecting the endpoint and finally executing it along with the Response Body (if required).

For testing the endpoints which require **Token** in the Authorization header, you can click on the "Authorize" button, write the Authorization token as  `Token <token>` (which you have obtained from the `auth/login/` endpoint) and finally click on "Authorize". Thereafter, all the requests made to any endpoint will have the Token in the Authorization Header.
