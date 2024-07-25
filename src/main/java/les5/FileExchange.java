package les5;

import com.google.common.base.Strings;

import java.io.*;
import java.util.ArrayList;

public class FileExchange {

    public static void main(String[] args) throws IOException{
        System.out.println(makeString("src/main/resources/test2.txt"));
        writeFile("src/main/resources/test2.txt", 'a');
    }

    public static String makeString(String path) throws IOException {
        String string;
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(path))) {
            return new String(stream.readAllBytes());
        }
    }

    public static void writeFile (String path, char exchangeChar) throws IOException {
         String string = makeString(path);
         string =  string.replaceAll(String.valueOf(exchangeChar), "");
         try (FileWriter writer = new FileWriter(path)){
             writer.write(string);
         }
    }
}
