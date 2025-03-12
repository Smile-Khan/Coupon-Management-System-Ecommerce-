# Coupon-Management-System-Ecommerce-

A RESTful API built using Spring Boot for managing and applying discount coupons for an e-commerce platform. This system supports various types of coupons such as:

✅ Cart-wise Coupons - Discounts applied to the entire cart total if conditions are met.✅ Product-wise Coupons - Discounts applied to specific products.✅ BxGy Coupons - "Buy X, Get Y" offers with repetition limits.

🚀 Features

Create, Read, Update, and Delete (CRUD) operations for coupons

Apply coupon logic to determine applicable discounts

Proper validation and exception handling for a smooth user experience

Clear and meaningful error responses

🛠️ Technologies Used

Java 21

Spring Boot

Maven

Postman for testing

H2 Database (for in-memory testing)

📋 Setup Instructions

Clone the Repository git clone <repository_link> cd coupon-management-system

Build the Project mvn clean install

Run the Application mvn spring-boot:run

Postman Collection (For Testing) Import the provided Postman collection to easily test the API endpoints.

🔥 API Endpoints

Create a Coupon
POST /coupons

{ "type": "CART", "discount": 15.0, "threshold": 100.0, "repetitionLimit": 2, "buyProducts": [1, 2], "getProducts": [3, 4] }

Get All Coupons
GET /coupons

Get a Coupon by ID
GET /coupons/{id}

Update a Coupon
PUT /coupons/{id} { "type": "PRODUCT", "discount": 20.0, "threshold": 200.0 }

Delete a Coupon
DELETE /coupons/{id}

Get Applicable Coupons for a Cart
POST /coupons/applicable-coupons

{ "cartTotal": 300.0, "productIds": [1, 2, 3] }

🧪 Testing Instructions

Start the application.

Open Postman and use the provided endpoints.

Ensure proper inputs for each request body.

🔍 Future Improvements

Implement token-based authentication for security.

Add a frontend UI for a more user-friendly experience.

Integrate caching mechanisms for improved performance.

📧 Contact

For any queries, feel free to reach out via GitHub or LinkedIn. 😊
