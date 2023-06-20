package courseWorks.courseWork3.version_1;

import java.net.InetSocketAddress;

import courseWorks.courseWork3.Helper;

public class ServerMain {
    public static void main(String[] args) {
        InetSocketAddress remote = new InetSocketAddress(Helper.getServerHost(), Helper.getServerPort());

        ServerApplication server = new ServerApplication(remote);
        server.run();
    }
}
