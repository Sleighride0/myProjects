package com.techelevator.filereader;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogFileWriter {
    private String logFileName;

    public LogFileWriter(String logFileName){
        this.logFileName = logFileName;
    }

    public static void errorLog(String message){
        LogFileWriter toLog = new LogFileWriter("Errorlog.txt");
        toLog.writeLog(toLog.outputFormat("Error: " + message));
        System.err.println("Error: " + message);;
    }
    public String outputFormat(String action, double balanceBefore, double balanceAfter){
        LocalDateTime myDateObj = LocalDateTime.now();
        String formattedDate = myDateObj.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        return String.format("%s %s: $%.2f $%.2f", formattedDate, action, balanceBefore, balanceAfter);
    }

    public String outputFormat(String action){
        LocalDateTime myDateObj = LocalDateTime.now();
        String formattedDate = myDateObj.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        return String.format("%s Event: %s", formattedDate, action);
    }

    public boolean writeLog(String str) {
        try(PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(this.logFileName, true)))){
            print.println(str);
        }catch(IOException io){
            System.out.println("Error: " + io);
            return false;
        }
        return true;
    }
}

/**
 * This would be a GREAT place to have a public method that could take a formatted String and log it out to a file.
 */
//The audit entry should include the date and time, action taken, the
//customer’s balance before that action and and new customer balance
//after the action was completed