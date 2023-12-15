# Week 3 Review


In order to practice applying polymorphism, your task is to create interface definitions and class implementations for the exercises defined below. In any of the cases, you may add attributes (i.e. properties) and other supporting methods to the classes in order to fully implement the interface.

**Notes for All Classes**
- X in the set column indicates it **should have a `set` accessor**.
- Nothing in the set column indicates the property is a [derived property][derived-properties].
- Readonly properties do not require a `set` accessor.

### Toll Booth Calculator

#### Vehicle Interface

| Method                        | Return Type |
| ----------------------------- | ----------- |
| `calculateToll(int distance)` | `double`    |

#### Car

Create a `Car` class that implements the `Vehicle` interface. Additionally it has the following attributes and constructors.

| Attribute   | Type    | Get | Set |
| ----------- | ------- | --- | --- |
| hasTrailer  | boolean | X   |     |

| Constructor               | Description                                                          |
| ------------------------- | -------------------------------------------------------------------- |
| `Car(boolean hasTrailer)` | Creates a new car indicating whether or not it is pulling a trailer. |

Tolls for cars are based upon distance.

    toll = distance * 0.020
    if pulling a trailer then toll = toll + 1.00

#### Truck

Create a `Truck` class that implements the `Vehicle` interface. Additionally it has the following attributes and constructors.

| Property      | Type | Get | Set |
| ------------- | ---- | --- | --- |
| numberOfAxles | int  | X   |     |

| Constructor                | Description                                           |
| -------------------------- | ----------------------------------------------------- |
| `Truck(int numberOfAxles)` | Creates a new truck indicating how many axles it has. |

Tolls for trucks are based upon the number of axles.

> | Axles | Per Mile |
> | ----- | -------- |
> | 4     | 0.040    |
> | 6     | 0.045    |
> | 8+    | 0.048    |
>
> toll = rate per mile \* distance

#### Tank

Create a `Tank` class that implements the `Vehicle` interface.

All military vehicles travel free on the toll roads.

    toll = 0

#### TollCalculator.java

Create a command line program named TollCalculator. The application will not accept any input.

Following the approach discussed in the lecture, create a `List<Vehicle>` that represents all of the vehicles that travel through a particular tollbooth. Using a random number for distance (10 to 240) calculate the tolls for each vehicle so that you can:

- Indicate each vehicle type, the distance traveled, and the calculated toll
- Indicate the sum of all miles traveled and total tollbooth revenue
- You should not need to check the type of Vehicle in the main method when displaying the output

_Expected output using **random** distances_

```
Vehicle            Distance Traveled      Toll $
------------------------------------------------
Car                100                    $2.00
Car (with trailer) 75                     $2.50
Tank               240                    $0.00
Truck (4 axels)    150                    $6.75
Truck (6 axels)    101                    $4.55
Truck (8 axels)    180                    $8.64

Total Miles Traveled: 846
Total Tollbooth Revenue: $24.44
```

