# spring-boot-backend-test

### User sign up -> http://localhost:8020/api/users/register

Request Body 

{
    "fullName":"John Doe",
    "email":"johndoe@qhala.com",
    "password": "qwerty"
}


### User login to get JWT auth token. -> POST http://localhost:8020/api/users/login

Request Body ]
{
    "email":"johndoe@qhala.com",
    "password": "qwerty"
}


### User adding books to the library -> POST http://localhost:8020/api/library/{userId}/books

@Request Body

{
    "author": "Ken Walibora",
    "ISBN": "TY2772JJDSE8",
    "title": "Kidagaa kimemuozea",
    "publisher": "Longhorn Publishers"
}

### User adding videos record -> POST http://localhost:8020/api/library/{userId}/videos
@Request Body

{
    "fileName":"african-geography",
    "fileType": ".mp4"
}

### Single user to view books records -> GET http://localhost:8020/api/library/books/{userId}

Response:
[
    {
        "id": 1,
        "author": "Ken Walibora",
        "ISBN": "TY2772JJDSE8",
        "title": "Kidagaa kimemuozea",
        "publisher": "Longhorn Publishers",
        "users": {
            "id": 1,
            "fullName": "John Doe",
            "email": "johndoe@qhala.com",
            "password": "$2a$10$OFfp80CB2671ZDJMRjfhlumXOoqqLttUMttYfXNM/qGmf4bjtv.si"
        }
    }
]




### Single user to view VIDEO records -> GET http://localhost:8020/api/library/videos/{userId}


@Response

[
    {
        "id": 1,
        "fileName": "african-geography",
        "fileType": ".mp4",
        "users": {
            "id": 1,
            "fullName": "John Doe",
            "email": "johndoe@qhala.com",
            "password": "$2a$10$OFfp80CB2671ZDJMRjfhlumXOoqqLttUMttYfXNM/qGmf4bjtv.si"
        }
    }
]


