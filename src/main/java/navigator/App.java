package navigator;



import navigator.service.Navigator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */

public class App 
{
    private static final Logger LOGGER = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
        Navigator navigator = new Navigator();
        System.out.println("asd");

        navigator.showDistance("Batumi A","Batumi F");
    }
}
