package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;
		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int raccoonsStartingInWoods = 3;
		int raccoonsLeftForDinner = 2;
		int raccoonsRemainingInWoods = raccoonsStartingInWoods - raccoonsLeftForDinner;

        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int flowerTotal = 5;
		int beeTotal = 3;
		int differenceBetweenFlowersAndBees = flowerTotal - beeTotal;

        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int lonelyPigeonEating = 1;
		int anotherPigeonJoins = 1;
		int totalPigeonsEating = lonelyPigeonEating + anotherPigeonJoins;

        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int owlsOnTheFence = 3;
		int owlsJoinOnFence = 2;
		int totalOwlsOnFence = owlsOnTheFence + owlsJoinOnFence;

        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int beaversWorkingAtHome = 2;
		int beaverLeftToSwim = 1;
		int beaversStillWorking = beaversWorkingAtHome - beaverLeftToSwim;

        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int toucansOnTreeLimb = 2;
		int toucanJoinsTree = 1;
		int totalToucansOnTreeLimb = toucansOnTreeLimb + toucanJoinsTree;

        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int totalSquirrels = 4;
		int totalNuts = 2;
		int differenceBetweenTotalSquirrelsAndTotalNuts = totalSquirrels - totalNuts;

        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double quarter = .25;
		double dime = .10;
		double nickel = .05;
		double moneyFound = quarter + dime + (2* nickel);

        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int brierClassMuffins = 18;
		int mcadamsClassMuffins = 20;
		int flanneryClassMuffins = 17;
		int totalMuffins = brierClassMuffins + mcadamsClassMuffins + flanneryClassMuffins;

        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double yoyoPurchase = 0.24;
		double whistlePurchase = 0.14;
		double totalMoneySpent = yoyoPurchase + whistlePurchase;

        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispies Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int largeMarshmallows = 8;
		int miniMarshmallows = 10;
		int totalMarshmallows = largeMarshmallows + miniMarshmallows;


        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int snowInInchesAtMrsHiltHouse = 29;
		int snowInInchesAtBrecknockSchool = 17;
		int snowDifferenceInInches = snowInInchesAtMrsHiltHouse - snowInInchesAtBrecknockSchool;

        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2.50 on a pencil
        case. How much money does she have left?
        */
		double mrsHiltStartingMoney = 10.0;
		double toyTruckCost = 3.0;
		double pencilCaseCost = 2.50;
		double mrsHiltRemainingMoney = mrsHiltStartingMoney - toyTruckCost - pencilCaseCost;


        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int joshMarbleTotal = 16;
		int lostMarbles = 7;
		int joshRemainingMarbles = joshMarbleTotal - lostMarbles;

        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int meganCurrentSeashells = 19;
		int desiredTotalOfSeaShells = 25;
		int numberOfSeashellsNeededToMatchDesiredAmount = desiredTotalOfSeaShells - meganCurrentSeashells;


        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int totalBalloons = 17;
		int numberOfRedBalloons = 8;
		int numberOfGreenBalloons = totalBalloons - numberOfRedBalloons;


        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int currentBooksOnShelf = 38;
		int numberOfBooksMartaAdds = 10;
		int newTotalNumberOfBooks = currentBooksOnShelf + numberOfBooksMartaAdds;

        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int numberOfLegsOnBee = 6;
		int numberOfBees = 8;
		int totalNumberOfLegs = numberOfLegsOnBee * numberOfBees;

        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double iceCreamConeCost = 0.99;
		int numberOfCones = 2;
		double totalCostofAllCones = iceCreamConeCost * numberOfCones;

        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int currentAmountOfRocks = 64;
		int totalNumberOfRocksToCompleteGarden = 125;
		int numberOfRocksNeededToCompleteGarden = totalNumberOfRocksToCompleteGarden - currentAmountOfRocks;

        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int startingMarblesAmount = 38;
		int numberOfLostMarbles = 15;
		int numberOfMarblesLeft = startingMarblesAmount - numberOfLostMarbles;

        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int totalDistanceToConcertInMiles = 78;
		int milesDrivenBeforeStoppingForGas = 32;
		int remainingMilesLeftToConcert = totalDistanceToConcertInMiles - milesDrivenBeforeStoppingForGas;

        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */
		int morningShovelingTimeInMinutes = 90;
		int afternoonShovelingTimeInMinutes = 45;
		int totalShovelingTimeInMinutes = morningShovelingTimeInMinutes + afternoonShovelingTimeInMinutes;

        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		int totalAmountOfHotDogs = 6;
		double costPerHotDog = 0.50;
		double totalCostOfHotDogs = totalAmountOfHotDogs * costPerHotDog;

        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int mrsHiltsAmountOfMoneyInPennies = 50;
		int costPerPencilInPennies = 7;
		int numberOfPencilsMrsHiltCanBuy = mrsHiltsAmountOfMoneyInPennies / costPerPencilInPennies;

        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int totalButterflies = 33;
		int totalOrangeButterflies = 20;
		int totalRedButterflies = totalButterflies - totalOrangeButterflies;

        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double katesMoneyInDollars = 1.00;
		double candyCost = 0.54;
		double changeGiven = katesMoneyInDollars -candyCost;

        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int treesInMarksYard = 13;
		int treesPlanted = 12;
		int newTotalTreesInMarksYard = treesInMarksYard + treesPlanted;

        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int numberOfDays = 2;
		int numberOfHoursPerDay = 24;
		int numberOfHoursUntilJoySeesHerGrandma = numberOfDays * numberOfHoursPerDay;

        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int numberOfCousins = 4;
		int gumGivenPerCousin = 5;
		int totalGumNeeded = numberOfCousins * gumGivenPerCousin;

        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double dansMoneyInDollars = 3.00;
		double candyBarCostInDollars = 1.00;
		double dansMoneyTotalAfterPurchase = dansMoneyInDollars - candyBarCostInDollars;

        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int boatsInTheLake = 5;
		int numberOfPeoplePerBoat = 3;
		int totalNumberOfPeopleOnLake = boatsInTheLake * numberOfPeoplePerBoat;

        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int ellenNumberOfLegos = 380;
		int legosLost = 57;
		int ellenNewTotalOfLegos = ellenNumberOfLegos - legosLost;

        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int currentMuffinTotal = 35;
		int desiredTotalOfMuffins = 83;
		int muffinsLeftToBake = desiredTotalOfMuffins - currentMuffinTotal;

        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int willyCrayonTotal = 1400;
		int lucyCrayonTotal = 290;
		int howManyMoreCrayonsWillyHas = willyCrayonTotal - lucyCrayonTotal;

        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stickersPerPage = 10;
		int totalPages = 22;
		int totalStickersPerPage = stickersPerPage * totalPages;

        /* Exercise 39
        39. There are 100 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		double totalCupcakes = 100.0;
		int countOfChildren = 8;
		double countOfCupcakesPerChild = totalCupcakes / countOfChildren;

        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies, how many
        cookies will not be placed in a jar?
        */
		int totalCookies = 47;
		int totalCookiesPerJar = 6;
		int numberOfRemainingCookies = totalCookies % totalCookiesPerJar;

        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received an equal number of croissants,
        how many will be left with Marian?
        */
		int totalCroissants = 59;
		int numberOfNeighbors = 8;
		int numberOfCroissantsRemaining = totalCroissants % numberOfNeighbors;

        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int totalOatmealCookies = 276;
		int cookiesPerTray = 12;
		int numberOfTrays = totalOatmealCookies / cookiesPerTray;

        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int totalPretzels = 480;
		int servingSizeOfPretzels = 12;
		int totalServingsMade = totalPretzels / servingSizeOfPretzels;

        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int totalLemonCupcakes = 53;
		int cupcakesLeftAtHome = 2;
		int lemonCupcakesPerBox = 3;
		int totalCupcakesBoxes = (totalLemonCupcakes - cupcakesLeftAtHome) / lemonCupcakesPerBox;

        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int carrotsForBreakfast = 74;
		int peopleEatingBreakfast = 12;
		int remainingCarrotsAfterBreakfast = carrotsForBreakfast % peopleEatingBreakfast;

        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int teddyBearsOnShelves = 98;
		int maxTeddyBearsPerShelf = 7;
		int filledShelves = teddyBearsOnShelves / maxTeddyBearsPerShelf;

        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int totalPictures = 480;
		int maxPicturesPerAlbum = 20;
		int totalAlbumsNeeded = totalPictures / maxPicturesPerAlbum;

        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int totalTradingCards = 94;
		int maxCardsPerBox = 8;
		int boxesFilled = totalTradingCards / maxCardsPerBox;
		int cardsInUnfilledBox = totalTradingCards % maxCardsPerBox;

        /* Exercise 49
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int totalBooks = 210;
		int totalShelves = 10;
		int totalBooksPerShelf = totalBooks / totalShelves;

        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		double croissantsBaked = 17;
		int numberOfGuests = 7;
		double croissantsPerGuest = croissantsBaked / numberOfGuests;

	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a standard room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 standard rooms?
	    Hint: Calculate the rate at which each painter can complete a room (rooms / hour), combine those rates, 
	    and then divide the total number of rooms to be painted by the combined rate.
	    */
     	double billHoursToPaintRoom = 2.15;
		 double jillHoursToPaintRoom = 1.90;
		 int room = 1;
		 double billPaintSpeedPerHour = room / billHoursToPaintRoom;
		double jillPaintSpeedPerHour = room / jillHoursToPaintRoom;
		double billAndJillCombinedSpeedPerHour = billPaintSpeedPerHour + jillPaintSpeedPerHour;
		double billAndJillTimeToPaintFiveRooms = (room * 5) / billAndJillCombinedSpeedPerHour;


	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */
		String firstName = "Grace";
		String lastName = "Hopper";
		String middleInitial = "B";
		String fullName = lastName +", "+ firstName + " " + middleInitial + ".";

	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */
		double totalTravelDistanceInMiles = 800;
		double distanceAlreadyTravelledInMiles = 537;
		int distanceTravelledPercent = (int) ((distanceAlreadyTravelledInMiles / totalTravelDistanceInMiles) * 100);
	}

}