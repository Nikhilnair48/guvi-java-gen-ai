# JWT Overview

## Basic Authentication
- Requires us to pass the username/password
- Include roles in the request?

## What's JWT?

- JSON Web Token
- Secure token used for authentication
- Used in client-server interaction. Usually with REST APIs
- API remains stateless
- Expires after a set time

## JWT Flow

Login flow:
1. Client sends email & password to `POST /auth/login`
2. `AuthController` receives the request
3. `AuthService` check whether the user exists
4. `AuthService` verify the password using `BCrypt` (class: `BCryptPasswordEncoder`)
5. `AuthService` asking `JwtUtil` to generate a token
6. `JwtUtil` returns the token to the `AuthService`
7. `AuthService` returns `LoginResponse` DTO

Authenticated flow:
- Client will send the token in the `Authorization` header w/ token
    - Eg: POST /subcriptions
- `JwtAuthFilter` reads the header on protected incoming requests
- The filter will need to validate and parse the token. Depends on JwtUtil.
- If valid, the filter create an authenticated object and stores it in the Spring Security
- The request reaches the controller as an authenticated request

## JJWT Library

### `Jwts`

Main entry point provided by the library:
    - build a token (Jwts.builder())
    - parse a token (Jwts.parser())

### Claims

A `Claims` object represents the payload inside the token. Include things like:
- subject, which is the user ID
- custom role
- issued at
- expiration time

### SecretKey (javax.crypto)

The key object that's used to sign and verify the token.

### Keys.hmacShaKeyFor(...) (JJWT)

A helper method that converts raw bytes into a `SecretKey` object that's expected by the JWT library.

### HMAC

A signing approach used to prove that the token came from the server and wasn't modified later.

#### Connection between HMAC & HTTP Request

A token generated using this approach must be passed in the HTTP Request's header

### `JwtException`

An exeption that's throws when token parsing or verfication fails.

## JwtUtil

### Constructor

@Value - 


## `JwtAuthFilter`

A filter is a class that will run during the request processing before the request reaches the controller.

