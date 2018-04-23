
package file_loader_url.util;

import com.sun.org.apache.bcel.internal.generic.LSTORE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kiran
 */
public class FileHelper {
    
    public static String readToEnd(String filename) throws IOException{
        BufferedReader reader=new BufferedReader(new FileReader(filename));
        String line="";
       
        StringBuilder content=new StringBuilder();
        while((line=reader.readLine())!=null){
           // System.out.println(line);
       // String content=""; content+=line; //-- don't use this, it cause takes more memory space
              content.append(line).append("\r\n");
        
        }
        reader.close();
        return content.toString();
    }
    
    public static List<String> readLines(String filename) throws IOException{
        List<String> lines=new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(filename));
        String line="";
        while((line=reader.readLine())!=null){
            lines.add(line);
        }
        return lines;
                
        
    }
   
    public static void write(String fileName, String content) throws IOException{
        FileWriter writer=new FileWriter(fileName);
        writer.write(content);
        writer.write(content);
        writer.close();
    }
}
