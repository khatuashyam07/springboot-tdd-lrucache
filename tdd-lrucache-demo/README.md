# tdd-lrucache-demo

Endpoint 1 -- addtocache

POST /cache/addtocache HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache


{"key": "key1", "value": "value1"}


Endpoint 2 -- getcache

GET /cache/getcache/keys/key2 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache



Endpoint 3 -- getallcache

GET /cache/getallcache HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache