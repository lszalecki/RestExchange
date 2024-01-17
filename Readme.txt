This is a simplified version. No spring security to secure endpoints.
There is only one table in the Postgres database (you could add the Address and Account tables, account_balance would be in the Account table and then create relationships between the Account, Address and Users tables).

There wasn't enough time for unit testing. I hope you will turn a blind eye in the quick test app.


#Requirements
PostgreSQL 16 and database RestExchange. Flyway automatically add the Users schema when application was start

In flyway.conf and application.properties files you must change password to postgres


#API
##Create new user ( email is not obligatory)

POST localhost:8080/users/
Content-Type: application/json
{
"name": "Lukasz",
"lastName": "Kowalski",
"email":"l.kowalski@gg.pl",
"accountBalance":170.79
}

#get info about user (user ID is required)
http://localhost:8080/info/USER_ID
#example:
http://localhost:8080/info/1

#exchange
#Exchange PLN to USD
http://localhost:8080/exchange/plnusd/46

#Exchange USD to PLN
http://localhost:8080/exchange/usdpln/46
