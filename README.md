# jpa rest experiments - exposing jpa entities as rest resources with minimal code

## Synopsis

* The combination of entity relational mapping (ORM) with complete relationships, and the auto-generation of rest endpoints from CRUD repositories, allows for a very powerful and flexible textbook implementation of a REST API with minimal code.
* Since it's self documenting, and can be tested directly from the swagger docs. There is no need to hardcode Dto models or map to them.
* The generic search endpoint allows for searching on any entity field, the relational mapping pulls in joined entities, providing a complete response body.

## Overview

* swagger rest api documentation available at http://localhost:8080/docs
* swagger docs replace the need for postman, with the added benefit of being able to test the api directly from the docs
* All CRUD REST endpoints are auto-generated by spring-boot-starter-data-rest
* search-generic-criteria-controller exposes a generic search endpoint for all entities

## Deployment Heroku

* Windows local db sync: $env:PGUSER = "postgres"; $env:PGPASSWORD = "xxxx"; heroku pg:push dvdrental xxxx --app jpa-rest-experiments
* Linked to github repo, auto-deploy on push to master

## Play with the API through the swagger docs

[demo deployment](https://jpa-rest-experiments-84648631255c.herokuapp.com/docs)
