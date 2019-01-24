# garbage-collectors-authorization-server

### Run Server locally

You can run it from Maven directly using the Spring Boot Maven plugin :

```sh
git clone https://github.com/davide-belfiori/garbage-collectors-authorization-server.git
cd ./garbage-collectors-authorization-server
mvn spring-boot:run
```

### Database configuration

By default this appliaction uses an in-memory database which gets populated at startup with data.
You can switch to a different one by setting connection parameters inside ```application-production.properties```, and changing
the active profile to ```spring.profiles.active=production``` inside ```application.properties```

### Obtain Token

Once the server has started, send an http POST request to http://localhost:8082/oauth/token in oreder to get a new JWT token, passing client and user credential as the example below :

#### Request Authorization:
<img width="1042" src = https://github.com/davide-belfiori/garbage-collectors-authorization-server/blob/master/sample_images/token_request_authorization_sample.PNG>

#### Request Body:
<img width="1042" src = https://github.com/davide-belfiori/garbage-collectors-authorization-server/blob/master/sample_images/token_request_body_sample.PNG >

#### Response:
```
{
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NDgzNDI1OTgsInVzZXJfbmFtZSI6ImdhcmJhZ2UiLCJhdXRob3JpdGllcyI6WyJSRUdJU1RSQVRPIl0sImp0aSI6ImVmOTI4NzhiLWQ3NDctNDkyNS1iMjkwLTY1NzBkNzM4ZTg0ZCIsImNsaWVudF9pZCI6InRlc3RfdXNlciIsInNjb3BlIjpbInRlc3QiXX0.3QC4zAVGPGm4OpuwpLaYBzvO_vPc6TIay3I2OtZTn9g",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJnYXJiYWdlIiwic2NvcGUiOlsidGVzdCJdLCJhdGkiOiJlZjkyODc4Yi1kNzQ3LTQ5MjUtYjI5MC02NTcwZDczOGU4NGQiLCJleHAiOjE1NTA5MzQ0OTgsImF1dGhvcml0aWVzIjpbIlJFR0lTVFJBVE8iXSwianRpIjoiNTI0NmY3OTQtZTM1Mi00MWZhLWI0MmMtNTE0ZGFjNDhiMjg0IiwiY2xpZW50X2lkIjoidGVzdF91c2VyIn0.2kCAcFrmHiQseteoevUYD3LaH56lN4vLs17UD-adu9k",
    "expires_in": 99,
    "scope": "test",
    "jti": "ef92878b-d747-4925-b290-6570d738e84d"
}
```
