
package cafetime;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.joda.time.Interval;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 *
 * @author walid
 */
public class CafeTime {
private int starthr;
private int startmin;
private double priceunit;
private double price;
private double time;

    public double getTime() {
          Properties prop = new Properties(); 
    	try {
               //load a properties file
    		prop.load(new FileInputStream("cafetime.properties"));
 
        return Double.parseDouble(prop.getProperty("time"));

    	} catch (IOException ex) {
    		ex.printStackTrace();
                return 0;
        }
    }

    public void setTime(String time) {
Properties prop = new Properties(); 
    	try {
    		//set the properties value
      prop.setProperty("time", time);
       
    		//save properties to project root folder
    		prop.store(new FileOutputStream("cafetime.properties"), null);
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }    }

    public CafeTime(int starthr, int startmin, double priceunit) {
        this.starthr = starthr;
        this.startmin = startmin;
        this.priceunit = priceunit;
    }

    public CafeTime() {
    }
    
    public double elapsedTime(int starthr,int startmin) throws ParseException{
      String start = starthr+":"+startmin;
Date dNow = new Date( );
SimpleDateFormat ft = new SimpleDateFormat("HH:mm");
Date date1 = ft.parse(start);
String end = ft.format(dNow);
Date date2=ft.parse(end);
long diff = date2.getTime() - date1.getTime(); 
time=diff/60000;
        return time;
    }
public int priceCalc(double time, double priceunit){
    price=time*priceunit;    
    return (int) price;
}
   
    }
