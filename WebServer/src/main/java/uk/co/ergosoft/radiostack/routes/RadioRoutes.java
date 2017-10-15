package uk.co.ergosoft.radiostack.routes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import uk.co.ergosoft.radiostack.models.*;

import java.io.IOException;
import java.io.OutputStream;

public class RadioRoutes {
    public static void radio(HttpExchange t) throws IOException {
        sendJsonResponse(t, new Radio().setSkin("b737"));
    }

    public static void com1(HttpExchange t) throws IOException {
        sendJsonResponse(t, new Com_1());
    }

    public static void com2(HttpExchange t) throws IOException {
        sendJsonResponse(t, new Com_2());
    }

    public static void nav1(HttpExchange t) throws IOException {
        sendJsonResponse(t, new Nav_1());
    }

    public static void nav2(HttpExchange t) throws IOException {
        sendJsonResponse(t, new Nav_2());
    }

    public static void adf(HttpExchange t) throws IOException {
        sendJsonResponse(t, new Adf());
    }

    private static void sendJsonResponse(HttpExchange t, Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String response = mapper.writeValueAsString(object);
            sendResponse(t,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendResponse(HttpExchange t, String response) throws IOException {
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
