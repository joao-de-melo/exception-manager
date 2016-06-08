package uk.fttek.exception.manager.log4j;

import com.google.common.base.Optional;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;
import uk.fttek.exception.manager.api.LogException;
import uk.fttek.exception.manager.api.LogExceptionBuilder;
import uk.fttek.exception.manager.logger.StackTraceGenerator;

import java.util.Date;

public class ExceptionManagerLogExceptionGenerator {
    private final StackTraceGenerator stackTraceGenerator;

    public ExceptionManagerLogExceptionGenerator(StackTraceGenerator stackTraceGenerator) {
        this.stackTraceGenerator = stackTraceGenerator;
    }

    public Optional<LogException> generate (LoggingEvent event, String environment) {
        if (hasException(event)) {
            return Optional.of(LogExceptionBuilder.newBuilder()
                    .withEnvironment(environment)
                    .withStackTrace(stackTraceGenerator.generate(throwable(event)))
                    .withDate(new Date())
                    .withLevel(event.getLevel().toString())
                    .build());
        } else {
            return Optional.absent();
        }
    }
    private Throwable throwable(final LoggingEvent loggingEvent) {
        ThrowableInformation throwableInfo = loggingEvent.getThrowableInformation();
        if (throwableInfo != null)
            return throwableInfo.getThrowable();

        Object message = loggingEvent.getMessage();
        if (message instanceof Throwable)
            return (Throwable) message;

        return null;
    }

    private boolean hasException(LoggingEvent event) {
        return throwable(event) != null;
    }
}
