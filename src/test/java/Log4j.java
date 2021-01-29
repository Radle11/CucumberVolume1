import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log4j {
        private static org.apache.log4j.Logger Logger = LogManager.getLogger(Log4j.class);
        public static void main(String... args){
            BasicConfigurator.configure();
            System.out.println("\nHello World\n");
            Logger.info("info message");
            Logger.debug("debug message");
            Logger.warn("warn message");
            Logger.fatal("fatal message");
            System.out.println("Complete");

        }
    }