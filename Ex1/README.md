# Exercise 1

## E1.1
- Using google maps api to reverse geocode to address.
- Running E1.1.html to use it.

## E1.2
- I used Jersey framework to build RESTful Web service that receive 2 geocode from user and return distance between them.
- You can import project and run it on tomcat 7.0 server.
	- Using API: localhost:8080/distancecalc/webapi/calc/origin="<GEOCODE1>"&destination="<GEOCODE2>"
	- Replace <GEOCODE1>, <GEOCODE2> with 2 geocode (format: latitude,longitude) which you want to know distance between them.
	- Example: http://localhost:8080/distancecalc/webapi/calc/origin=55.930385,-3.118425&destination=50.087692,14.421150
