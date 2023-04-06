package Driver;


import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
public class Runscript
{
  public static void main(String args[])
    throws ParserConfigurationException, IOException, SAXException, InterruptedException
    {
    try{
    	Driver.scriptDriverMethod(".\\src\\main\\java\\Driver\\Training.xls","Conrol_Sheet");
    	
    }
    catch(Exception e){
	   e.printStackTrace();
  }
   }
  }