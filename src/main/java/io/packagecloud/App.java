package io.packagecloud;

import org.jboss.logging.Logger;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
@Stateful 
public class App 
{
      
    public static void main( String[] args ) throws Exception {
        final Logger LOGGER = Logger.getLogger(App.class);
        LOGGER.error("Configuration file not found.");

        List<String> bookShelf = new ArrayList<String>();
        bookShelf.add("Test Book Name");

    }

}
