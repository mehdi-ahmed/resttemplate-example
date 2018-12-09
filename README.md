1. A Foosball Java API

Create a simple Java API fetching data from the endpoint https://officeleague.rocks/app/api/graphql.
It should be really simple but return Java objects instead of just JSON
Include tests & build script (preferably Gradle or Maven)

What we are looking for:
* Object-oriented structure and use of object-oriented principles.
* Use of pre-existing libraries like Jackson/Gson/...
* Code quality

Details about the endpoint:
* The endpoint is using GraphQL but it is not necessary to know anything about GraphQL for this exercise.
* It expects a POST request and returns a JSON object.
* For this exercise you can use as request body the content of the attached file "request-body.json"
* Example of usage using cUrl: curl -X POST -H "Content-Type: application/json" -d "@request-body.json" https://officeleague.rocks/app/api/graphql