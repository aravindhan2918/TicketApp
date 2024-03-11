Endpoints:

API 1: To post the ticket details

POST: http://localhost:8080/tickets/purchase

Example Input:

{
"departureFrom": "London",
"destination": "France",
"firstName": "shiyamala",
"lastName": "Thiyagarajan",
"pricePaid": 5.0,
"seatSection": "A"
}

Example Output:

Ticket purchased successfully, Ticket No: 1

API 2: To retrieve all ticket details

GET: http://localhost:8080/tickets/allTicketsdetails

Example output:

[
{
"id": 1,
"departureFrom": "London",
"destination": "London",
"firstName": "Aravindhan",
"lastName": "Thiyagarajan",
"pricePaid": 5.0,
"seatSection": "B"
},
{
"id": 2,
"departureFrom": "London",
"destination": "France",
"firstName": "shiyamala",
"lastName": "Thiyagarajan",
"pricePaid": 5.0,
"seatSection": "A"
}
]

API 3: To retrieve the receipt detail

GET: http://localhost:8080/tickets/receipt/1

Example Output

{
"id": 1,
"departureFrom": "London",
"destination": "London",
"firstName": "Aravindhan",
"lastName": "Thiyagarajan",
"pricePaid": 5.0,
"seatSection": "B"
}

API 4: To get the user details based on the seat section

GET: http://localhost:8080/tickets/users/A

Example output:


{
"id": 2,
"departureFrom": "London",
"destination": "France",
"firstName": "shiyamala",
"lastName": "Thiyagarajan",
"pricePaid": 5.0,
"seatSection": "A"
}

API 5: To delete a user

DELETE: http://localhost:8080/tickets/delete/2

Example output:

Ticket removed successfully.

API 6: To update a existing user.

PUT: http://localhost:8080/tickets/update/seat/1

Sample Input:

{
"departureFrom": "London",
"destination": "London",
"firstName": "Aravindhan",
"lastName": "Thiyagarajan",
"pricePaid": 5.0,
"seatSection": "A"
}