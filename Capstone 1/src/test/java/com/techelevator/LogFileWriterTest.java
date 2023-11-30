package com.techelevator;
import com.techelevator.filereader.LogFileWriter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LogFileWriterTest {
    private LogFileWriter newlog = new LogFileWriter("Test1");
    private Path tempLogPath;
    private LogFileWriter logFileWriter;

    @Before
    public void setUp() throws IOException {
        tempLogPath = Files.createTempFile("testLogFile", ".txt");
        logFileWriter = new LogFileWriter(tempLogPath.toString());
    }

    @After
    public void tearDown() throws IOException {
        Files.deleteIfExists(tempLogPath);
    }


    @Test
    public void LogFileWriter_test_output_format_return_String_date_time_action_before_after_transaction(){
        LocalDateTime myDateObj = LocalDateTime.now();
        String formattedDate = myDateObj.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        String store = this.newlog.outputFormat("test2", 2.0, 2.0);
        Assert.assertEquals(formattedDate +" test2: $2.00 $2.00", store);
    }

    @Test
    public void LogFileWriter_test_log_file_to_txt(){
        LogFileWriter testLog = new LogFileWriter("TestFile");
        boolean wasWriteable = testLog.writeLog("test");
        Assert.assertTrue(wasWriteable);
    }

    @Test
    public void LogFileWriter_test_log_file_to_txt_with_no_string(){
        LogFileWriter testLog = new LogFileWriter("TestFile");
        boolean wasWriteable = testLog.writeLog("");
        Assert.assertTrue(wasWriteable);
    }

}
