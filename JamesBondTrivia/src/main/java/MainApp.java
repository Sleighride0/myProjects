import java.util.Scanner;

public class MainApp {
    private Questions questions = new Questions();


    public void run(){
        questions.getStartUpMessage();

        questions.getQuestion1();
        questions.getQuestion2();
        questions.getQuestion3();
        questions.getQuestion4();
        questions.getQuestion5();

     //   System.out.println(questions.getScore());











    }



    public static void main(String[] args) {
        MainApp quizApp = new MainApp();
        quizApp.run();

    }
}