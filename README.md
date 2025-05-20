💳 Online Payment Gateway – Java Console Application

This is a simple Java-based console application that simulates an online payment gateway. It collects card details, validates them, and processes a payment based on predefined rules. 🛠️ Features

Accepts payment details from the user:
Card Number (16 digits)
CVV (3 digits)
Expiry Date (MM/YY)
Payment Amount
Validates payment details format
Processes payments up to ₹10,000
Displays success or failure messages
🧾 Validation Rules

Card Number must be 16 digits
CVV must be 3 digits
Expiry Date must be in MM/YY format
Amount must be greater than ₹100
Payments above ₹10,000 are rejected
📦 How It Works

The program uses two main classes:

PaymentDetails: Stores and validates the user’s payment information.
PaymentProcessor: Processes the payment if all validations pass.
