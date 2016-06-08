package uk.fttek.exception.manager.logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import uk.fttek.exception.manager.api.LogException;

import java.io.IOException;

public class LogExceptionSender {
    private final ObjectMapper objectMapper;
    private final HttpClient client;

    public LogExceptionSender () {
        this.client = HttpClients.createDefault();
        this.objectMapper = new ObjectMapper();
    }
    public LogExceptionSender (HttpClient client, ObjectMapper objectMapper) {
        this.client = client;
        this.objectMapper = objectMapper;
    }

    public void send (String url, LogException logException) {
        try {
            String entity = objectMapper.writeValueAsString(logException);
            HttpPut request = new HttpPut(url);
            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(entity, ContentType.APPLICATION_JSON));
            client.execute(request);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
