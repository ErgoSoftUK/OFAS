package uk.co.ergosoft.radiostack.rest;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import uk.co.ergosoft.radiostack.routes.RouteHandler;
import uk.co.ergosoft.radiostack.routes.RouteManager;

import java.io.IOException;

public class RequestHandler implements HttpHandler {
    private RouteManager routeManager;

    public RequestHandler(RouteManager r) { routeManager = r; }

    @Override
    public void handle(HttpExchange t) throws IOException {
        String method = t.getRequestMethod();
        String path = t.getRequestURI().getPath();
        RouteHandler handler = routeManager.find(method+"-"+path);
        handler.handleRequest(t);
    }
}
