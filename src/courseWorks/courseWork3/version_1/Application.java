package courseWorks.courseWork3.version_1;

import java.net.InetSocketAddress;

public class Application {
    private static final String SERVER_HOST = "127.0.0.1";
    private static final int SERVER_PORT = 2222;

    public static void main(String[] args) {
        InetSocketAddress remote = new InetSocketAddress(SERVER_HOST, SERVER_PORT);

        Thread server = new Thread(new ServerApplication(remote));
        Thread client = new Thread(new ClientApplication(remote));

        server.start();
        client.start();

        try {
            // Ожидание завершения работы сервера и клиента
            server.join();
            client.join();
        } catch (InterruptedException e) {
            System.out.println("Процесс был прерван: " + e.getMessage());
        }
    }
}

