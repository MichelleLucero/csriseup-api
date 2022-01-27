# csriseup-api

Backend for [CSRiseUp project](https://github.com/MichelleLucero/csriseup).

### Endpoints

## Auth

| Request Type | URL            | Functionality   | Access |
| ------------ | -------------- | --------------- | ------ |
| POST         | /auth/register | Register a User | Public |
| POST         | /auth/login    | Logs in a User  | Public |
| GET          | /auth/users    | Gets all Users  | Public |

## Jobs

| Request Type | URL              | Functionality          | Access  |
| ------------ | ---------------- | ---------------------- | ------- |
| POST         | api/jobs/{jobId} | Create a job           | Private |
| GET          | api/jobs/{jobId} | Get a _specific_ job   | Private |
| PUT          | api/jobs/{jobId} | Update an existing job | Private |
| DELETE       | api/jobs/{jobId} | Delete an existing job | Private |
| GET          | api/jobs         | Get _all_ jobs         | Private |
