# Equipment-Tracker

This project is undertaken to develop equipment tracker REST-service in educational purposes.

## Goals

1. Develop two endpoints:
   - One with a computed field.
   - Another with data from multiple tables.
   - Ensure that endpoints return only the specified data fields.

## Endpoints

1. CRUD operations for each table.

2. To retrieve the total cost of equipment of a specified type:
   - The equipment type is passed as a parameter.

3. To retrieve information about equipment and its current user:
   - The equipment ID is passed as a parameter.

## Schema Description

### Tables

1. Equipment:
   - ID
   - Name
   - Type
   - Description
   - Acquisition Date
   - Cost
   - Status
   - Image


2. Users:
   - ID
   - Name
   - Position
   - Department
   - Contact Information


3. Usage History:
   - ID
   - Equipment ID
   - User ID
   - Start Date
   - End Date
   - Reason
   - Comments

### Table Relationships

- Relationship between Equipment and Usage History: One-to-many.
- Relationship between Users and Usage History: One-to-many.
