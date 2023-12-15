package com.techelevator.logger;

import java.io.*;

public class Logger implements Closeable{
    private File logFile;
    private PrintWriter logWriter;

    public Logger(String pathName) {
        logFile = new File(pathName);
        //if logFile doesn't exist, open it to write
        if(!logFile.exists()){
            try{
                logWriter = new PrintWriter(logFile);
//                logWriter = writer;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            try{
                logWriter = new PrintWriter(new FileOutputStream(logFile, true));
//                logWriter = writer;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }


    public void write(String message){
        logWriter.println(message);
        logWriter.flush(); //send the bytes right now!!
    }


    @Override
    public void close() throws IOException {
        logWriter.close();
    }
}
