package uk.fttek.exception.manager.log4j;

import com.google.common.base.Optional;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import uk.fttek.exception.manager.api.LogException;
import uk.fttek.exception.manager.logger.LogExceptionSender;
import uk.fttek.exception.manager.logger.StackTraceGenerator;

public class ExceptionManagerLoggerAppender extends AppenderSkeleton {
    private final ExceptionManagerLogExceptionGenerator generator = new ExceptionManagerLogExceptionGenerator(
            new StackTraceGenerator()
    );
    private final LogExceptionSender sender = new LogExceptionSender();

    private boolean enabled = false;
    private String environment = "test";
    private String url = "http://localhost:8080/rest/log";


    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public void setEnvironment(final String environment) {
        this.environment = environment;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    @Override
    protected void append(LoggingEvent event) {
        if (enabled) {
            Optional<LogException> logExceptionOptional = generator.generate(event, environment);
            if (logExceptionOptional.isPresent()) {
                sender.send(url, logExceptionOptional.get());
            }
        }
    }

    @Override
    public void activateOptions() {
        super.activateOptions();
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
