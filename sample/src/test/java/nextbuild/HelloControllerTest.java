package nextbuild;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloControllerTest {

    private static EmbeddedServer server;

    private static HttpClient client;

    @BeforeClass
    public static void setupServer() {
        server = ApplicationContext.run(EmbeddedServer.class);
        client = server.getApplicationContext().createBean(HttpClient.class, server.getURL());
    }

    @AfterClass
    public static void stopServer() {
        if (client != null) { client.stop(); }
        if (server != null) { server.stop(); }
    }

    @Test
    public void helloShouldReturnMessage() {
        String response = client.toBlocking().retrieve("/hello");
        assertTrue(response.startsWith("Hello NextBuild."));
    }
    
    @Test
    public void helloReactiveShouldReturnMessage() {
        String response = client.toBlocking().retrieve("/hello");
        assertTrue(response.startsWith("Hello NextBuild."));
    }
    
    @Test
    public void helloMessageShouldReturnMessage() {
        Message response = client.toBlocking().retrieve(HttpRequest.GET("/hello-message"), Message.class);
        assertEquals("Check message content", "Hello NextBuild!", response.getText());
    }
}
