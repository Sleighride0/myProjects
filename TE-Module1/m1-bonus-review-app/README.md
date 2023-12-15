# Module 1 Bonus Material


### Postage Calculator

#### DeliveryDriver Interface

| Method                                       | Return Type | Description                                                                                                |
| -------------------------------------------- | ----------- | ---------------------------------------------------------------------------------------------------------- |
| `calculateRate(int distance, double weight)` | `double`    | calculateRate takes the distance being traveled (in miles) and the weight in ounces to calculate the rate. |

#### Postal Service

Create PostalService classes that implements the `DeliveryDriver` interface. The Postal Service deals with pounds and ounces.

The rate is calculated based on the following rate table:

```
|--------|-----------|-----------|-----------|
|        | 1st Class | 2nd Class | 3rd Class |
| Ounces | Per Mile  | Per Mile  | Per Mile  |
|--------|-----------|-----------|-----------|
| 0 - 2  |   0.035   |   0.0035  |   0.0020  |
| 3 - 8  |   0.040   |   0.0040  |   0.0022  |
| 9 - 15 |   0.047   |   0.0047  |   0.0024  |
| Pounds - be oz|           |           |           |
| 16 - 48  |   0.195   |   0.0195  |   0.0150  |
| 49 - 144  |   0.450   |   0.0450  |   0.0160  |
| 145+     |   0.500   |   0.0500  |   0.0170  |
|--------|-----------|-----------|-----------|

rate = per mile rate * distance
```

**HINT** Consider how multiple classes per delivery type (1st class, 2nd class, 3rd class) could help. How might your code be impacted if a new delivery type is added?

#### FexEd

Create a FexEd class that implements the `DeliveryDriver` interface.

FexEd charges a flat rate for all packages, but may apply extra charges based upon weight and distance.

    rate = 20.00
    If distance > 500 miles then rate = rate + 5.00
    If weight > 48 ounces then rate = rate + 3.00

#### SPU

Create SPU classes that implement the `DeliveryDriver` interface.

Each class will determine the rate based on the rate type, weight (in lbs), and distance.

    If "4-Day Ground" then rate = (weight * 0.0050) * distance.
    If "2-Day Business" then rate = (weight * 0.050) * distance.
    If "Next Day" then rate = (weight * 0.075) * distance.

#### PostageCalculator.java

Create a command line program named PostageCalculator. The application will accept the weight of the package, whether or not the weight is in pounds or ounces, and the distance the package will be travelling. The output will display the rates for all possible delivery methods based on the inputs provided by the customer.

You *should not* need to check the type of DeliveryDriver in the main method when displaying the output.

_Expected output_

```
Please enter the weight of the package? 15
(P)ounds or (O)unces? O
What distance will it be traveling? 340

Delivery Method                 $ cost
--------------------------------------
Postal Service (1st Class)      $15.98
Postal Service (2nd Class)      $1.60
Postal Service (3rd Class)      $0.82
FexEd                           $20.00
SPU (4-Day Ground)              $1.59
SPU (2-Day Business)            $15.94
SPU (Next Day)                  $23.91
```
