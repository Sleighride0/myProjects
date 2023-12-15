package com.techelevator;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.view.Menu;




public class QuizCLI {


    private Menu menu = new Menu();

    public QuizCLI(DataSource datasource) {
        //pass dataSource to Daos.
    }

    public void run() {

        while(true) {
            String userChoice = menu.getSelectionFromMainMenu();

            if (userChoice.equals("1")) {
                //show all students
            } else if(userChoice.equals("2")){
                //show random question
            } else if(userChoice.equals("3")){
                //show random student assigned to student
            }
            else if (userChoice.equalsIgnoreCase("Q")) {
                System.exit(0);
            }
        }

    }

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/quiz");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("postgres1");

        QuizCLI application = new QuizCLI(dataSource);
        application.run();
    }
}
