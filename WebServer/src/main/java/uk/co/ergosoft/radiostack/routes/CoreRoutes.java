package uk.co.ergosoft.radiostack.routes;

import com.sun.net.httpserver.HttpExchange;
import uk.co.ergosoft.radiostack.utils.ResourceManager;

import java.io.IOException;
import java.io.OutputStream;

public class CoreRoutes {
    public static void fallback(HttpExchange t) throws IOException {
        String path=t.getRequestURI().getPath();
        if (path.endsWith("/"))
            path += "index.html";

        System.out.println("Fallback [" + path + "]");

        byte[] response = ResourceManager.getResourceBytes(path.substring(1));

        if (response == null)
            CoreRoutes.notFound(t);
        else {
            t.sendResponseHeaders(200, response.length);
            OutputStream os = t.getResponseBody();
            os.write(response);
            os.close();
        }
    }

    public static void notFound(HttpExchange t) throws IOException {
        String response = "Not Found";

        t.sendResponseHeaders(404, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
