package com.yet.spring.loggers;
import com.yet.spring.beans.Event;
import org.apache.commons.io.FileUtils;
import sun.nio.cs.UTF_32;

import java.io.File;
import java.io.IOException;


public class FileEventLogger implements EventLogger{
    public String fileName;
    public File file;
    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event){
        File file = new File(fileName);
        try {
            FileUtils.writeStringToFile(file, event.toString(), true);
        }catch (IOException e){
            System.out.println("EventID: "+event.getId()+"\nОшибка записи в файл: "+fileName+"\nВозможно у вас нет соответствующих прав!\n");
        }
    }

    private void accessCheckFile() throws IOException{
        this.file = new File(this.fileName);
    }
}
