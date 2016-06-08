package uk.fttek.exception.manager.api;

import java.util.Date;

public class LogExceptionBuilder {

    public static LogExceptionBuilder newBuilder () {
        return new LogExceptionBuilder();
    }

    private String environment;
    private String stackTrace;
    private Date date;
    private String level;

    private LogExceptionBuilder() {
    }

    public LogExceptionBuilder withEnvironment(String environment) {
        this.environment = environment;
        return this;
    }

    public LogExceptionBuilder withStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
        return this;
    }

    public LogExceptionBuilder withDate(Date date) {
        this.date = date;
        return this;
    }

    public LogExceptionBuilder withLevel(String level) {
        this.level = level;
        return this;
    }

    public LogException build () {
        return new LogException(environment, stackTrace, date, level);
    }
}
