New interface: 

UserRepository
    - derived query: find users by email; case insensitive


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailIgnoreCase(String email);
}


What's JWT?
JSON Web Token
Purpose: 
 - authenticate + authorize users at the server level
 - stateless

https://www.jwt.io/
https://www.epochconverter.com/

eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30

{
  "subject": "1234567890",
  "name": "John Doe",
  "admin": true,
  "iat": 1516239022 (epoch time)
}

Scenario:
    - User logged in 60 minutes ago
    - Send a new request at the 61st minute
        - No longer authenticated

Claims:
    - user identity 
    - role
Token expiry: how long the token stays valid

email: admin@ex.com
password: admin123

Implement POST /auth/login
    - AuthController
        - login
    - AuthService
        - login
Return a JWT that contains userId and role
    - JwtUtil -> utility class to 
        - generate tokens,
        - validate tokens,
        - extract values from the token
Use seeded demo users to log in and get tokens quickly

Implementation steps

1) Dependencies
2) Controller, Service, JwtUtil..
3) DTOs
4) Exceptions
5) Configuration -> application.props
