# csriseup-api

Backend for [CSRiseUp project](https://github.com/MichelleLucero/csriseup).

### Endpoints

## Auth

| Request Type | URL                 | Functionality   | Access |
| ------------ | ------------------- | --------------- | ------ |
| POST         | /auth/user/register | Register a User | Public |
| POST         | /auth/user/login    | Logs in a User  | Public |

## Jobs

| Request Type | URL              | Functionality          | Access  |
| ------------ | ---------------- | ---------------------- | ------- |
| POST         | api/jobs/{jobId} | Create a job           | Private |
| GET          | api/jobs/{jobId} | Get a _specific_ job   | Private |
| PUT          | api/jobs/{jobId} | Update an existing job | Private |
| DELETE       | api/jobs/{jobId} | Delete an existing job | Private |
| GET          | api/jobs         | Get _all_ jobs         | Private |

## Positions

| Request Type | URL           | Functionality     | Access |
| ------------ | ------------- | ----------------- | ------ |
| POST         | api/positions | Create a position | Public |
| GET          | api/positions | Get all positions | Public |

## Statuses

| Request Type | URL          | Functionality    | Access |
| ------------ | ------------ | ---------------- | ------ |
| POST         | api/statuses | Create a status  | Public |
| GET          | api/statuses | Get all statuses | Public |

## Companies

| Request Type | URL           | Functionality     | Access |
| ------------ | ------------- | ----------------- | ------ |
| POST         | api/companies | Create a company  | Public |
| GET          | api/companies | Get all companies | Public |
