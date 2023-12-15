# Week 2 Review

### Step One: Implement the `Item` class

#### Instance variables

| Attribute       | Data Type | Get | Set | Description                                          |
|-----------------|-----------|-----|-----|------------------------------------------------------|
| itemName        | String    | X   | X   | Name of the item.                                    |
| itemPrice       | double    | X   | X   | Price of the item.                                   |
| itemDescription | String    | X   | X   | The submitter's name for the assignment.             |
| category        | String    | X   | X   | "M" for Miscellenous, "F" for Food, "C" for Clothing |
| sku             | String    | X   | X   | unique identifier for the item                       |

#### Constructor

The `Item` class has 2 constructors. One accepts 4 arguments: `String itemName`, `double itemPrice`, `String itemDescription` and `String category`. Use these parameters to set the instance variables of the class.
The second constructor is a no-argument constructor.

### Step Two: Implement the `Inventory` class

#### Constructor

Use the default constructor for the `Inventory` class. 

#### Methods

Create a method called `buildInventory` that accepts no arguments and returns a `Map<String,Item>`.
 - Instantiate `Item` objects and set their state.
 - Instantiate a new `Map<String,Item>`
 - add items to the map where sku is the key and item is the value.
 - The method returns the map.

### Step Three: Implement the `StoreApp` class


#### Methods

Create the main() method. In the main method create a instance of `Inventory` and `buildInventory()`. Greet the user and print out all the items in the inventory. 
Ask the user to select items they would like to purchase. Print the total cost and items purchased.
