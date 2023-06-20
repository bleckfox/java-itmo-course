package courseWorks.courseWork3.version_1;

import courseWorks.courseWork3.Helper;

import java.net.InetSocketAddress;

public class ClientMain {
    public static void main(String[] args) {
        InetSocketAddress remote = new InetSocketAddress(Helper.getServerHost(), Helper.getServerPort());

        ClientApplication client = new ClientApplication(remote);
        client.run();
    }
}
