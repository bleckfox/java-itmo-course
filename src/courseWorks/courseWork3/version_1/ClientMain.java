package courseWorks.courseWork3.version_1;

import java.net.InetSocketAddress;

public class ClientMain {
    public static void main(String[] args) {
        InetSocketAddress remote = new InetSocketAddress("127.0.0.1", 2222);

        ClientApplication client = new ClientApplication(remote);
        client.run();
    }
}
