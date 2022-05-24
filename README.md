Talking Clock System 

- It is a simple Springboot application to convert Time to Words. 
- It converts current time and custom time. 
- Can be easily accessible from Swagger. 
- Global exception handler is present. 
- Test cases are added as well.

Swagger URL - http://localhost:6001/talkingclock/swagger-ui.html#

To convert current time to word -
 CURL - curl -X GET "http://localhost:6001/talkingclock/api/clock/currentTime" -H "accept: */*"
 Request URL - http://localhost:6001/talkingclock/api/clock/currentTime
 
 
 To convert custom time to word -
 CURL - curl -X GET "http://localhost:6001/talkingclock/api/clock/customTime?hour=20&minutes=32" -H "accept: */*"
 Request URL - http://localhost:6001/talkingclock/api/clock/customTime?hour=20&minutes=32
 
 P.S. The custom URL comprises of values which can be changed. 