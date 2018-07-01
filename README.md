# GraphQLDemo-Android
Apollo Android is a GraphQL compliant client library that generates Java models from standard GraphQL queries. These models give you a typesafe API to work with GraphQL servers. Apollo will help you keep your GraphQL query statements together, organized, and easy to access from Java.

# How to generate schema:
-  ```npm-install apollo-codegen``` (make sure, you have node and npm installed).
- ```apollo-codegen download-schema http://localhost:8080/graphql --output schema.json```

# Steps build:
- Set up all dependencies for android(https://github.com/apollographql/apollo-android).
- Copy .graphqls and schema.json in a android studio folder.
- Rebuild and now able to access ApolloClient.


https://github.com/sunilmishra/GraphQLDemo-Android/blob/master/appolo-studio.png
