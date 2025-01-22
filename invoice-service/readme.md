### Step one

Create a REST api that creates PDF invoice when called with some purchase data parameters.

The goal is to build REST service with:

* plain Java

* embedded Tomcat

* self-written dependency injection framework

* fake PDF generation

```json
{
  "id": 1,
  "user_id": "john_matrix",
  "amount": 50,
  "pdf_url": "https://invoice-service.com/invoice-john_matrix-1.pdf"
}
```