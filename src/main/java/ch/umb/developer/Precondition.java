package ch.umb.developer;

import java.util.logging.Logger;
import java.awt.Desktop;
import java.net.URI;

import org.camunda.bpm.client.ExternalTaskClient;

public class Precondition {
    private final static Logger LOGGER = Logger.getLogger(Precondition.class.getName());

    public static void main(String[] args) {
        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000) // long polling timeout
                .build();

        // subscribe to an external task topic as specified in the process
        client.subscribe("CheckMaterialAndTool")
                .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
                .handler((externalTask, externalTaskService) -> {
                    // Put your business logic here
                    // Get a process variable
                    LOGGER.info("Materials and tools are checked...almost ready for work:)");

                    try {
                        Desktop.getDesktop().browse(new URI("https://remote101.blog/content/images/2020/02/home-office-working-remotely.jpg"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // Complete the task
                    externalTaskService.complete(externalTask);
                })
                .open();
    }
}