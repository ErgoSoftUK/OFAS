package uk.co.ergosoft.radiostack;

import java.net.InetSocketAddress;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightsim.fsuipc.FSADF;
import com.flightsim.fsuipc.fsuipc_wrapper;
import com.sun.net.httpserver.HttpServer;
import uk.co.ergosoft.radiostack.models.Adf;
import uk.co.ergosoft.radiostack.routes.RadioRoutes;
import uk.co.ergosoft.radiostack.rest.RequestHandler;
import uk.co.ergosoft.radiostack.routes.RouteManager;

public class RadioStack {
    static RouteManager routeManager = new RouteManager()
        .get("/api/radio", RadioRoutes::radio)
        .get("/api/com1", RadioRoutes::com1)
        .get("/api/com2", RadioRoutes::com2)
        .get("/api/nav1", RadioRoutes::nav1)
        .get("/api/nav2", RadioRoutes::nav2)
        .get("/api/adf", RadioRoutes::adf);

    public static void main(String[] args) throws Exception {
        System.out.println("Initilizing FSUIPC");
        int ret = 0;

        System.out.print("Connecting..");

        while(ret == 0) {
            System.out.print(".");
            ret = fsuipc_wrapper.Open(fsuipc_wrapper.SIM_ANY);
            if (ret == 0)
                Thread.sleep(1000);
        }
        System.out.println("Testing ADF");
        FSADF adf = new FSADF();
        System.out.println("freq " + adf.Freq());
        System.out.println("freq as string " + adf.FreqAsString());
        System.out.println("ID " +adf.Identity());
        System.out.println("Name " + adf.Name());

        System.out.println("connected");

        adfTest();

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new RequestHandler(routeManager));
        server.start();
    }

    private static void adfTest() {
        System.out.println("ADF Test");
        Adf adf = new Adf();
        System.out.println("Name" + adf.getName());

        try {
            ObjectMapper mapper = new ObjectMapper();
            String response = mapper.writeValueAsString(adf);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}