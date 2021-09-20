package io.packagecloud;

import java.io.File;
import java.io.File.write;
import java.io.FileOutputStream;
import java.io.FileOutputStream.write;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static void fsAccessAntipattern() {
        try {
            String curDirectory = System.getProperty("user.curDirectory");
            File dir = new File("tmp/test");
            dir.mkdir();
            File tmp = new File(dir, "tmp.txt");
            tmp.createNewFile();
            FileOutputStream fout = new FileOutputStream(tmp, true);
            fout.write(65);
            fout.close();
        } catch (Exception ex) {
            System.out.println( "My bad!" );
        } finally {
            System.out.println( "It happens" );
        }
    }
}
