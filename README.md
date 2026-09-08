# System Administration and User Registration

## Project Overview

This project is a Java-based System Administration and User Registration
system. It is designed to manage user accounts and control access to
different parts of the system.

The registration section allows new users to create an account by entering
the required information. The system validates the information before
creating the account.

The administration section allows an authorised administrator to manage
registered users and their access.

## Main Features

### User Registration

- Allows new users to create an account.
- Collects the required user information.
- Validates user information.
- Stores registered user details.

### User Login

- Allows registered users to log into the system.
- Checks the username and password.
- Prevents unauthorised access.
- Provides access based on the user's role.

### System Administration

The administrator can:

- View registered users.
- Add users.
- Update user information.
- Delete user accounts.
- Manage user roles and access.

## User Roles

### Administrator

The administrator has additional permissions to manage users and
system-related functions.

### Registered User

A registered user can log into the system and access the functions
available to normal users.

## System Flow

1. The user opens the registration section.
2. The user enters their details.
3. The system validates the information.
4. The user's account is created.
5. The user logs in using their credentials.
6. The system checks the user's role.
7. The user receives access according to their role.
8. The administrator can manage registered users.

## Technologies Used

- Java
- Java Swing / JavaFX (depending on the interface used)
- Object-Oriented Programming (OOP)
- MySQL / SQL database (if used)
- JDBC (if the Java application connects to a database)

## Security

The system is designed to prevent unauthorised users from accessing
administrative functions.

User login details should be handled securely, and users should only
have access to functions allowed by their assigned role.

## Project Purpose

The purpose of this project is to create a simple Java application that
allows users to register and log in while giving administrators the
ability to manage user accounts.

The system demonstrates basic concepts of Java programming, user
authentication, database management and system administration.

## Author

Student Project

## Status

This project is developed for academic purposes.
