package courseWorks.courseWork3.version_1;

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
        try (Socket socket = new Socket(remote.getHostString(), remote.getPort());
             ReadWrite readWrite = new ReadWrite(socket);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Подключен к серверу: " + remote.getHostString() + ":" + remote.getPort());

            // Поток для получения сообщений от сервера
            Thread receiveThread = new Thread(() -> {
                while (running){
                    try{
                        System.out.println("Сообщение от сервера: " + readWrite.readMessage().getText());
                    } catch (IOException e) {
                        System.out.println("Ошибка чтения сообщения от сервера: " + e.getMessage());
                        running = false;
                    }
                }
            });

            // Поток для отправки сообщений на сервер
            Thread sendThread = new Thread(() -> {
                while (running){
                    try {
                        String input = reader.readLine();

                        if (input.equalsIgnoreCase("exit")){
                            running = false;
                            break;
                        }

                        readWrite.writeMessage(new Message(input));

                    } catch (IOException e) {
                        System.out.println("Ошибка отправки сообщения на сервер: " + e.getMessage());
                        running = false;
                    }
                }
            });

            receiveThread.start();
            sendThread.start();

            receiveThread.join();
            sendThread.join();

            System.out.println("Работа клиента завершена.");

        } catch (IOException e){
            System.out.println("Ошибка подключения к серверу: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Процесс клиента был прерван: " + e.getMessage());
        }
    }
}

//public class ClientApplication {
//    private static InetSocketAddress remote;
//
//    public ClientApplication(InetSocketAddress remote) { this.remote = remote; }
//
//    public static void main(String[] args) {
//        try (Socket socket = new Socket(remote.getHostString(), remote.getPort())) {
//            ReadWrite readWrite = new ReadWrite(socket);
//
//            // Создание потока для чтения ввода пользователя и отправки сообщений на сервер
//            Thread sendMessageThread = new Thread(() -> {
//
//                // Создание читателя для чтения ввода пользователя из консоли
//                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//                String input;
//
//                while (true){
//                    try {
//                        input = reader.readLine();
//
//                        if (input.equalsIgnoreCase("exit")){
//                            break;
//                        }
//                        // Отправка сообщения на сервер
//                        Message message = new Message(input);
//                        readWrite.writeMessage(message);
//
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                }
//            });
//
//            // Создание потока для приема сообщений от сервера и их вывода в консоль
//            Thread receiveMessageThread = new Thread(() -> {
//                try{
//                    while (true){
//                        // Чтение сообщения от сервера
//                        Message message = readWrite.readMessage();
//
//                        if (message != null){
//                            // Вывод полученного сообщения и времени его отправки
//                            System.out.println("Received: " + message.getText() + " Sent at: " + message.getSent());
//                        }
//                    }
//                } catch (IOException e){
//                    e.printStackTrace();
//                }
//            });
//
//            // Запуск потоков
//            sendMessageThread.start();
//            receiveMessageThread.start();
//
//            // Ожидание завершения программы
//            sendMessageThread.join();
//            receiveMessageThread.join();
//
//            readWrite.close();
//
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
