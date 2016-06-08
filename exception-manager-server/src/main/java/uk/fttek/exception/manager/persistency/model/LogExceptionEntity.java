package uk.fttek.exception.manager.persistency.model;

import org.springframework.data.annotation.Id;
import uk.fttek.exception.manager.api.LogException;

import java.util.Date;

public class LogExceptionEntity {
    public static LogExceptionEntity fromLogException (LogException dto) {
        return new LogExceptionEntity(
                dto.getEnvironment(),
                dto.getLevel(),
                dto.getStackTrace(),
                dto.getDate()
        );
    }

    @Id
    private String id;
    private String environment;
    private String level;
    private String stackTrace;
    private Date date;

    public LogExceptionEntity() {
    }

    public LogExceptionEntity(String environment, String level, String stackTrace, Date date) {
        this.environment = environment;
        this.level = level;
        this.stackTrace = stackTrace;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getLevel() {
        return level;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public Date getDate() {
        return date;
    }
}
