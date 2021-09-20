package io.packagecloud;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory; 

/**
 * Hello world!
 *
 */
@Stateful 
public class App implements Job 
{
    private static final Logger LOG = Logger.getLogger(App.class);

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        System.out.println("Executing Job");
        LOG.info("Executing JOb");
    }
      
    public static void main( String[] args ) throws Exception {

        System.setProperty("webdriver.ie.driver","D:/Softwares/IEDriverServer_Win32_2.39.0/IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
        //System.setProperty("webdriver.chrome.driver","D:/Softwares/chromedriver_win_17.0.963.0/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();

        //WebDriver driver = new RemoteWebDriver(DesiredCapabilities.chrome());
        //driver.get("http://www.google.com");

        driver.get("http://google.com");



        String startDateStr = "2018-06-23 16:00:00.0";
        Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(startDateStr);
        System.out.println(startDate);
        JobDetail j = JobBuilder.newJob(QuartzScheduler.class).build();
        Trigger t = TriggerBuilder.newTrigger()
                .withIdentity("CroneTrigger")
                .startAt(startDate)
                .withSchedule(CronScheduleBuilder.cronSchedule("0 30 14 * * ?").withMisfireHandlingInstructionDoNothing()).build();
        Scheduler s = StdSchedulerFactory.getDefaultScheduler();
        s.start();
        s.scheduleJob(j, t);

    }

}
