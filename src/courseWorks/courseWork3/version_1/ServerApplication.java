package courseWorks.courseWork3.version_1;

import courseWorks.courseWork3.Message;
import courseWorks.courseWork3.ReadWrite;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArraySet;

public class ServerApplication implements Runnable {
    private int port;
    private boolean runnig;
    private CopyOnWriteArraySet<ReadWrite> connections;

    public ServerApplication(InetSocketAddress remote){
        this.port = remote.getPort();
        this.runnig = true;
        this.connections = new CopyOnWriteArraySet<>();
    }

    @Override
    public void run(){
        try (ServerSocket server = new ServerSocket(port)){
            System.out.println("Сервер запущен на порту: " + port);

            while (runnig) {
                Socket client = server.accept();
                System.out.println("Установлено соединение с клиентом: " + client.getInetAddress());

                ReadWrite readWrite = new ReadWrite(client);
                connections.add(readWrite);

                // Обработка соединения клиент-сервер в отдельном потоке
                Thread clientThread = new Thread(() -> {
                    while (runnig) {
                        try {
                            Message message = readWrite.readMessage();
                            System.out.println("Получено сообщение от клиента: " + message.getText());

                            // Рассылка сообщений всем активным соединениям
                            connections.forEach(con -> {
                                try {
                                    con.writeMessage(message);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                        } catch (IOException e) {
                            System.out.println("Ошибка чтения сообщения от клиента: " + e.getMessage());
                            break;
                        }
                    }

                    connections.remove(readWrite);
                    System.out.println("Соединение с клиентом разорвано: " + client.getInetAddress());
                });

                clientThread.start();
            }

        } catch (IOException e) {
            System.out.println("Ошибка при работе сервера: " + e.getMessage());
        }
    }

}
