package courseWorks.courseWork3.version_1;

import courseWorks.courseWork3.Commands.HelpCommand;
import courseWorks.courseWork3.Message;
import courseWorks.courseWork3.ReadWrite;

import java.io.*;
import java.net.Socket;
import java.net.InetSocketAddress;

public class ClientApplication implements Runnable {
    private InetSocketAddress remote;
    private boolean running;

    public ClientApplication(InetSocketAddress remote){
        this.remote = remote;
        this.running = true;
    }

    @Override
    public void run(){
        Socket socket = null;
        ReadWrite readWrite = null;
        BufferedReader reader = null;

        try {
            socket = new Socket(remote.getHostString(), remote.getPort());
            readWrite = new ReadWrite(socket);
            reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Подключен к серверу: " + remote.getHostString() + ":" + remote.getPort());

            // Effective final для использования в лямбда
            ReadWrite finalReadWrite = readWrite;
            BufferedReader finalReader = reader;

            // Поток для получения сообщений от сервера
            Thread receiveThread = new Thread(() -> {
                while (running){
                    try{
                        System.out.println("Сообщение от сервера: " + finalReadWrite.readMessage().getText());
                    } catch (IOException e) {
                        System.out.println("Ошибка чтения сообщения от сервера: " + e.getMessage());
                        running = false;
                    }
                }
            });

            // Поток для отправки сообщений на сервер
            Thread sendThread = new Thread(() -> {
                outerLoop:
                while (running){
                    try {
                        String input = finalReader.readLine();

                        switch (input.toLowerCase()){
                            case "help", "-h" -> {
                                new HelpCommand().execute();
                                continue;
                            }
                            case "send", "-s" -> System.out.println("send");
                            case "give", "-g" -> System.out.println("give");
                            case "all", "-a" -> System.out.println("all");
                            case "exit", "-e" -> {
                                System.out.println("Завершение работы!");
                                running = false;
                                break outerLoop;
                            }
                        }

                        finalReadWrite.writeMessage(new Message(input));

                    } catch (IOException e) {
                        System.out.println("Ошибка отправки сообщения на сервер: " + e.getMessage());
                        running = false;
                    }
                }
            });

            receiveThread.setDaemon(true);

            sendThread.start();
            receiveThread.start();

            // Необходимо ожидать поток отправителя (sendThread), иначе происходит разрыв соединения
            // в блоке finally и поток получателя (receiveThread) падает с ошибкой "Ошибка чтения сообщения от сервера: Socket closed"
            // если не ожидать ни один дочерний поток в основном, то -> socket, readWrite, reader будут закрыты
            // как только откроются
            // если ожидаем только поток отправителя, то соединение будет прервано только по инициативе клиента
            sendThread.join();

            System.out.println("Работа клиента завершена.");

        } catch (IOException e){
            System.out.println("Ошибка подключения к серверу: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Процесс клиента был прерван: " + e.getMessage());
        } finally {
            // Закрытие соединения и ресурсов
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Ошибка при закрытии сокета: " + e.getMessage());
                }
            }

            if (readWrite != null) {
                readWrite.close();
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Ошибка при закрытии BufferedReader: " + e.getMessage());
                }
            }
        }
    }
}
