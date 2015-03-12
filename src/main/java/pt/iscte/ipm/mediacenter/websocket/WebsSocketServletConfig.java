package pt.iscte.ipm.mediacenter.websocket;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import pt.iscte.ipm.mediacenter.websocket.WebSocketHandler;

public class WebsSocketServletConfig extends WebSocketServlet{

    @Override
    public void configure(WebSocketServletFactory webSocketServletFactory) {
        webSocketServletFactory.register(WebSocketHandler.class);
    }
}
