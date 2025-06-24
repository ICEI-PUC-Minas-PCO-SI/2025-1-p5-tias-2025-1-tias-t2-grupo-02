
# API Endpoints Documentation

## User Endpoints

### GET ALL USERS
- **URL:** `http://localhost:8080/api/users`
- **METHOD:** `GET`
- **BODY:** 
  None

### POST USER
- **URL:** `http://localhost:8080/api/users`
- **METHOD:** `POST`
- **BODY:**
  ```json
  {
    "name": "user name",
    "cpf": "user cpf",
    "email": "user email"
  }
  ```

### GET USER BY ID
- **URL:** `http://localhost:8080/api/users/{id}`
- **METHOD:** `GET`
- **BODY:**
  None

### PUT USER
- **URL:** `http://localhost:8080/api/users/{id}`
- **METHOD:** `PUT`
- **BODY:**
  ```json
  {
    "name": "new user name",
    "cpf": "new user cpf",
    "email": "new user email"
  }
  ```

### DELETE USER
- **URL:** `http://localhost:8080/api/users/{id}`
- **METHOD:** `DELETE`
- **BODY:**
  None

## Patient Endpoints

### GET ALL PATIENTS
- **URL:** `http://localhost:8080/api/patients`
- **METHOD:** `GET`
- **BODY:** 
  None

### POST PATIENT
- **URL:** `http://localhost:8080/api/patients`
- **METHOD:** `POST`
- **BODY:**
  ```json
  {
    "name": "patient name",
    "cpf": "patient cpf",
    "rg": "patient rg",
    "birthdate": "yyyy-MM-dd",
    "cep": "cep",
    "address": "address",
    "bloodType": "blood type",
    "plano": "plan",
    "carteirinha": "carteirinha",
    "conditions": "conditions"
  }
  ```

### GET PATIENT BY ID
- **URL:** `http://localhost:8080/api/patients/{id}`
- **METHOD:** `GET`
- **BODY:**
  None

### PUT PATIENT
- **URL:** `http://localhost:8080/api/patients/{id}`
- **METHOD:** `PUT`
- **BODY:**
  ```json
  {
    "name": "updated patient name",
    "cpf": "updated patient cpf",
    "rg": "updated patient rg",
    "birthdate": "yyyy-MM-dd",
    "cep": "updated cep",
    "address": "updated address",
    "bloodType": "updated blood type",
    "plano": "updated plan",
    "carteirinha": "updated carteirinha",
    "conditions": "updated conditions"
  }
  ```

### DELETE PATIENT
- **URL:** `http://localhost:8080/api/patients/{id}`
- **METHOD:** `DELETE`
- **BODY:**
  None

## Contact Endpoints

### GET ALL CONTACTS
- **URL:** `http://localhost:8080/api/contacts`
- **METHOD:** `GET`
- **BODY:**
  None

### POST CONTACT
- **URL:** `http://localhost:8080/api/contacts`
- **METHOD:** `POST`
- **BODY:**
  ```json
  {
    "phone": "contact phone",
    "email": "contact email",
    "address": "contact address"
  }
  ```

### GET CONTACT BY ID
- **URL:** `http://localhost:8080/api/contacts/{id}`
- **METHOD:** `GET`
- **BODY:**
  None

### PUT CONTACT
- **URL:** `http://localhost:8080/api/contacts/{id}`
- **METHOD:** `PUT`
- **BODY:**
  ```json
  {
    "phone": "updated phone",
    "email": "updated email",
    "address": "updated address"
  }
  ```

### DELETE CONTACT
- **URL:** `http://localhost:8080/api/contacts/{id}`
- **METHOD:** `DELETE`
- **BODY:**
  None

## Login Endpoints

### AUTHENTICATE LOGIN
- **URL:** `http://localhost:8080/api/login/authenticate`
- **METHOD:** `POST`
- **BODY:**
  ```json
  {
	"email": "teste@example.com",
	"password": "12345"
  }
  ```

## Medication Endpoints

### GET ALL MEDICATIONS
- **URL:** `http://localhost:8080/api/medications`
- **METHOD:** `GET`
- **BODY:**
  None

### POST MEDICATION
- **URL:** `http://localhost:8080/api/medications`
- **METHOD:** `POST`
- **BODY:**
  ```json
  {
    "name": "medication name",
    "status": "critico",
    "patientId": "patientId"
  }
  ```

### GET MEDICATION BY ID
- **URL:** `http://localhost:8080/api/medications/{id}`
- **METHOD:** `GET`
- **BODY:**
  None

### PUT MEDICATION
- **URL:** `http://localhost:8080/api/medications/{id}`
- **METHOD:** `PUT`
- **BODY:**
  ```json
  {
    "name": "updated medication name",
    "status": "ok",
    "patientId": "updated patientId"
  }
  ```

### DELETE MEDICATION
- **URL:** `http://localhost:8080/api/medications/{id}`
- **METHOD:** `DELETE`
- **BODY:**
  None

## Document Endpoints

### GET ALL DOCUMENTS
- **URL:** `http://localhost:8080/api/documents`
- **METHOD:** `GET`
- **BODY:**
  None

### POST DOCUMENT
- **URL:** `http://localhost:8080/api/documents`
- **METHOD:** `POST`
- **BODY:**
  ```json
  {
    "title": "document title",
    "content": "document content",
    "patientId": "patientId"
  }
  ```

### GET DOCUMENT BY ID
- **URL:** `http://localhost:8080/api/documents/{id}`
- **METHOD:** `GET`
- **BODY:**
  None

### PUT DOCUMENT
- **URL:** `http://localhost:8080/api/documents/{id}`
- **METHOD:** `PUT`
- **BODY:**
  ```json
  {
    "title": "updated document title",
    "content": "updated document content",
    "patientId": "updated patientId"
  }
  ```

### DELETE DOCUMENT
- **URL:** `http://localhost:8080/api/documents/{id}`
- **METHOD:** `DELETE`
- **BODY:**
  None
