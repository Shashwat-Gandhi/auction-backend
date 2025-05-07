# auction-backend
Backend for auction platform written in Java, Springboot

Run the seed.sql file to create the necessary table in the database named "auction"

APIs
# Ping
GET /
    Ping the server to check if it is running

# Users
POST /users/register
    To register a new user

POST /users/login
    To login a user

PUT /users/:username
    To update details of a user

DELETE /users/:username
    To delete a user

# auctions
POST /auctions/create
    To create an auction

PUT /auctions/:auction_id
    To update auction details

DELETE /auctions/:auction_id
    To delete an auction


# auction_items
POST /auctions_item/:item_id/:auction_id
    To place an item to an auction

DELETE /auctions_item/:item_id/:auction_id
    To delete an item from an auction


# items
POST /items/create
    To upload an item to DB to later put in auction