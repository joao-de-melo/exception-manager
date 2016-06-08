package uk.fttek.exception.manager.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class LogException {
    public static final String ENVIRONMENT = "environment";
    public static final String STACK_TRACE = "stackTrace";
    public static final String DATE = "date";
    public static final String LEVEL = "level";

    @JsonProperty(ENVIRONMENT)
    private final String environment;

    @JsonProperty(DATE)
    private final Date date;

    @JsonProperty(LEVEL)
    private final String level;

    @JsonProperty(STACK_TRACE)
    private String stackTrace;

    @JsonCreator
    public LogException(@JsonProperty(ENVIRONMENT) String environment,
                        @JsonProperty(STACK_TRACE) String stackTrace,
                        @JsonProperty(DATE) Date date,
                        @JsonProperty(LEVEL) String level) {
        this.environment = environment;
        this.stackTrace = stackTrace;
        this.date = date;
        this.level = level;
    }

    public String getEnvironment() {
        return environment;
    }

    public Date getDate() {
        return date;
    }

    public String getLevel() {
        return level;
    }

    public String getStackTrace() {
        return stackTrace;
    }
}
