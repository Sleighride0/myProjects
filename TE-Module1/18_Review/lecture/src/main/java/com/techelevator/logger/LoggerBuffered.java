package com.techelevator.logger;

import java.io.*;

public class LoggerBuffered {

    private File logFile;
    private BufferedWriter buffedLogWriter;

    public LoggerBuffered(String pathName) {
        logFile = new File(pathName);

    }


    public void write(String message) throws IOException {
        if(logFile.length() > 0){
            try(FileWriter writer = new FileWriter(logFile, true);BufferedWriter bufferedWriter = new BufferedWriter(writer) ){
                buffedLogWriter = bufferedWriter;
                buffedLogWriter.newLine();
                buffedLogWriter.append(message);

//                logWriter = writer;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try(PrintWriter writer = new PrintWriter(logFile);BufferedWriter bufferedWriter = new BufferedWriter(writer) ){
                buffedLogWriter = bufferedWriter;
                buffedLogWriter.write(message);
//                logWriter = writer;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
