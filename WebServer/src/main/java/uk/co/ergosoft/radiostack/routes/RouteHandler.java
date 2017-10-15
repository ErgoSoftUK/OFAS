package uk.co.ergosoft.radiostack.routes;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public interface RouteHandler {
    void handleRequest(HttpExchange t) throws IOException;
}
