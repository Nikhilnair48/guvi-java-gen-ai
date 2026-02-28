## HTTP Verbs

- **GET** - retrieve an existing resource  
  - Used to fetch data from the server  
  - Example: get an event, user, or list of bookings

- **POST** - create a new resource  
  - Common example: create a new `event` or `user`

- **PUT** - replace an existing resource  
  - Complete replacement of the resource  
  - Example: send the full updated version of a document

- **PATCH** - partially update an existing resource  
  - Used when only some fields need to change  
  - Example: if a document has 100+ fields, but one service only needs to update 5

- **DELETE** - remove an existing resource  
  - Example: delete an event or user

- **OPTIONS** - check what operations are supported on a resource  
  - Often used to discover allowed HTTP methods  
  - Commonly appears in CORS-related flows

## References

- [MDN Web Docs - HTTP request methods](https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Methods)
- [MDN Web Docs - POST](https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Methods/POST)
- [MDN Web Docs - PUT](https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Methods/PUT)
- [MDN Web Docs - PATCH](https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Methods/PATCH)
- [MDN Web Docs - DELETE](https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Methods/DELETE)
- [MDN Web Docs - OPTIONS](https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Methods/OPTIONS)