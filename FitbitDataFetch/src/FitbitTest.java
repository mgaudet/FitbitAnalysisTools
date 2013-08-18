import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.claygregory.jfitbit.*;

public class FitbitTest {

    public static void main(String args[]) throws ParseException,
           FitbitAuthenticationException, FileNotFoundException,
           UnsupportedEncodingException { 

        String Username = "your_fitbit_email@email.ca";
        String Password = "Yes, your password, in plaintext"; 

        String start_date = "April 04, 2012";
        String end_date   = "August 16, 2013";

        Date startDate = new SimpleDateFormat("MMMM d, yyyy",
                Locale.ENGLISH).parse(start_date);
        Date endDate   = new SimpleDateFormat("MMMM d, yyyy",
                Locale.ENGLISH).parse(end_date);

        // Output File creation    
        PrintWriter printer = new PrintWriter("FitbitData","UTF-8");

        //Date formatter --- this is the R POSIXlt date format for ease
        SimpleDateFormat x = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        FitbitQuery fbQuery = FitbitQuery.create()
                                       .minimumTimestamp( startDate )
                                       .maximumTimestamp( endDate )
                                       .resolution( FitbitResolution.INTRADAY );
        Fitbit fb = new Fitbit(Username, Password);

        for ( StepCount step_count : fb.stepCount( fbQuery ) ) { 
            Date d = step_count.getTimestampAsDate();
            String formatted_date = x.format(d);
            printer.println(   formatted_date + "," + step_count.getSteps()); 
        }
        printer.close();
        System.out.println("Done"); 
    }

}
