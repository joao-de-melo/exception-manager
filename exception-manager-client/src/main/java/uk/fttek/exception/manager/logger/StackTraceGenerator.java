package uk.fttek.exception.manager.logger;

public class StackTraceGenerator {
    public String generate (Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        for (StackTraceElement stackTraceElement : throwable.getStackTrace()) {
            stringBuilder.append(stackTraceElement.toString());
        }
        return stringBuilder.toString();
    }
}
