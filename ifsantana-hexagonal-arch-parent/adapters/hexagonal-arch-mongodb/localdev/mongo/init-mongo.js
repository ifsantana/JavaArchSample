db = db.getSiblingDB('test')
db.users.drop();
db.users.insert(
    [
        { "_id": 1, "email":  "admin@admin.com"}
    ]
);