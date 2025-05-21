# An-Object-Oriented-Car-Dealership-System-Part-2
I've implemented a comprehensive Object-Oriented Car Dealership System with sales and leasing capabilities as required by the workshop project. Here's a summary of the major components:
Core Classes

Contract (Abstract):

Base class for all contracts with common fields and methods
Contains abstract methods for pricing calculations


SalesContract:

Extends Contract for vehicle sales
Includes sales tax, recording fee, processing fee based on vehicle price
Handles financing options with appropriate interest rates and terms


LeaseContract:

Extends Contract for vehicle leases
Calculates expected ending value (50% of price) and lease fee (7% of price)
Calculates monthly payments using 4% interest rate for 36 months


ContractFileManager:

Handles saving contracts to a file in the specified format
Appends new contracts to the existing contracts file


Vehicle:

Represents a vehicle in the dealership inventory
Contains properties like VIN, year, make, model, type, color, odometer, and price


Dealership:

Manages the inventory of vehicles
Provides methods to search for vehicles by various criteria
Allows adding and removing vehicles from inventory


DealershipFileManager:

Loads and saves dealership data to/from a file
Parses vehicle data from file format


UserInterface:

Handles user interaction through a menu-based system
Processes user input for all dealership operations
Implements the new sell/lease vehicle functionality



Key Features Implemented

Vehicle Sales Process:

Collects customer information
Asks if the vehicle will be financed
Calculates appropriate fees and monthly payments


Vehicle Lease Process:

Verifies the vehicle is not older than 3 years
Calculates expected ending value and lease fee
Determines monthly payments


Contract Persistence:

Saves contracts in the required format
Appends to the existing contracts file


Inventory Management:

Removes vehicles from inventory after sale/lease
Updates inventory file after transactions



The system is designed with proper object-oriented principles:

Inheritance (Contract as parent class, specialized contracts as child classes)
Encapsulation (private fields with getters/setters)
Abstraction (abstract methods for pricing calculations)
Proper separation of concerns (file management, user interface, business logic)

To use the system, run the DealershipApplication class, which will launch the user interface allowing you to interact with all the features of the dealership system.
