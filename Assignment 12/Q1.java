public class Q1 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();   

        String infoMessage = "Testing Info Level";
        String debugMessage = "Testing Debug Level";
        String warningMessage = "Testing Warning Level";
        String errorMessage = "Testing Error Level";
        String fatalMessage = "Testing Fatal Level";

        logger.log(Logger.LogLevel.INFO, infoMessage);
        logger.log(Logger.LogLevel.DEBUG, debugMessage);
        logger.log(Logger.LogLevel.WARNING, warningMessage);
        logger.log(Logger.LogLevel.ERROR, errorMessage);
        logger.log(Logger.LogLevel.FATAL, fatalMessage);
    }
}

class Logger {
    public enum LogLevel{
        INFO,
        DEBUG,
        WARNING,
        ERROR,
        FATAL
    }
    private static Logger logger = new Logger();

    private LogLevel logLevel = LogLevel.INFO;

    private Logger(){}

    public static Logger getLogger(){
        return logger;
    }

    public void setLogLevel(LogLevel logLevel){
        this.logLevel = logLevel;
    }

    public void log(LogLevel logLevel, String message){
        System.out.println(logLevel + ": " + message);
    }
}