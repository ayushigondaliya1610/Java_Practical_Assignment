package servlet;

import jakarta.annotation.Resource;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.Topic;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/send")
public class SendMessageServlet extends HttpServlet {

    @Resource(lookup = "jms/myTopic")
    private Topic topic;

    @Resource(lookup = "jms/myConnectionFactory")
    private ConnectionFactory factory;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (JMSContext context = factory.createContext()) {

            String message = "Hello from Servlet!";
            context.createProducer().send(topic, message);

            System.out.println("Message Sent: " + message);
        }

        response.getWriter().println("Message sent to Topic");
    }
}