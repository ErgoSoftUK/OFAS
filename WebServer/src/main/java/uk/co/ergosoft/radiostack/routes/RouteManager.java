package uk.co.ergosoft.radiostack.routes;

import java.util.HashMap;
import java.util.Map;

public class RouteManager {
    private Map<String, RouteHandler> routes = new HashMap<>();

    public RouteManager get(String route, RouteHandler handler) {
        routes.put("GET-"+route, handler);
        return this;
    }

    public RouteHandler find(String route) {
        RouteHandler handler = routes.get(route);

        if (handler == null)
            handler = CoreRoutes::fallback;

        return handler;
    }
}
