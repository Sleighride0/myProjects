import java.util.Scanner;

public class Questions {

    private int score = 0;
    private int incorrect = 0;
    private String answer2 = "";

    Scanner scanner = new Scanner(System.in);
    public void getStartUpMessage() {
        System.out.println("********************************");
        System.out.println("Welcome to the James Bond Quiz");
        System.out.println("********************************");
        System.out.println("You will be tested to see how well you know the James Bond movies.");
        System.out.println("Please enter your name: ");
        String userName = scanner.next();
        System.out.println("You will be rated by your accuracy at the end of the quiz.");
        System.out.println("Good luck, " + userName);
        System.out.println();
    }

    public void getQuestion1() {
        //question 1
        System.out.println("Question 1");
        System.out.println("How many actors have played James Bond?: ");
        System.out.println("[A] 5");
        System.out.println("[B] 6");
        System.out.println("[C] 7");
        System.out.println("Please enter A, B, or C: ");
        String answer1 = scanner.next();

        if (answer1.equalsIgnoreCase("B")) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Ouch! The answer is B: 6 Actors have played James Bond.");
        }
    }
    public void getQuestion2() {
        //question 2
        System.out.println("*******************");
        System.out.println("Question 2");
        System.out.println("What is James Bond's double-0 number?: ");
        System.out.println("[A] 003");
        System.out.println("[B] 004");
        System.out.println("[C] 006");
        System.out.println("[D] 007");
        System.out.println("Please enter A, B, C, or D: ");
        String answer2 = scanner.next();

        if (answer2.equalsIgnoreCase("D")) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Ouch! The answer is D: 007");
        }
    }
    public void getQuestion3() {
        //question 3
        System.out.println("*******************");
        System.out.println("Question 3");
        System.out.println("Who is Jame's Bond Boss?: ");
        System.out.println("[A] Q");
        System.out.println("[B] R");
        System.out.println("[C] M");
        System.out.println("[D] C");
        System.out.println("Please enter A, B, C, or D: ");
        answer2 = scanner.next();
        if (answer2.equalsIgnoreCase("C")) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Ouch! The answer is C: M");
            if (answer2.equalsIgnoreCase("A")) {
                System.out.println("Q is Bond's gadget supplier");
            }
        }
    }
    public void getQuestion4() {
        // question 4
        System.out.println("*******************");
        System.out.println("Question 4");
        System.out.println("What gun does James Bond carry in most movies?: ");
        System.out.println("[A] Beretta 418");
        System.out.println("[B] The Golden Gun");
        System.out.println("[C] 45 Colt Revolver");
        System.out.println("[D] Walther PPK");
        System.out.println("Please enter A, B, C, or D: ");
        answer2 = scanner.next();
        if (answer2.equalsIgnoreCase("D")) {
            System.out.println("Correct! His first gun however was a Beretta in Dr.No(1962).");
            score++;
        } else {
            System.out.println("Ouch! The answer is D: Walther PPK.");
            System.out.println("His first gun however was a Beretta in Dr.No(1962)");
        }
    }
    public void getQuestion5() {
        //question 5
        System.out.println("*******************");
        System.out.println("Question 5");
        System.out.println("How many Official James Bond movies are there?: ");
        System.out.println("[A] 25");
        System.out.println("[B] 20");
        System.out.println("[C] 21");
        System.out.println("[D] 18");
        System.out.println("Please enter A, B, C, or D: ");
        answer2 = scanner.next();
        if (answer2.equalsIgnoreCase("A")) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Ouch! The answer is D: Walther PPK.");
            System.out.println("His first gun however was a Beretta in Dr.No(1962)");
        }
    }
    public void getEndMessage(){
        System.out.println("********************************************************************");
        System.out.println("Congratulation! You answered " + score + " questions correctly!");
        System.out.println("Would you like to try again?");
        System.out.println("[Y] Yes");
        System.out.println("[N]  No");
        answer2 = scanner.next(){
            if (answer2.equalsIgnoreCase("Y")){

            }
    }

    public String getScore() {
        return "Your current score is " + score + "!";
    }

    public int getIncorrect() {
        return incorrect;
    }

    //placehoolder til i figure it out
//        Questions question3 = new Questions();
//        return question3;
        // store all questions.  Need to figure out how to randomize.  would I make a method to return each?
}


