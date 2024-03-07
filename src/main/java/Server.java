import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) {

        int port = 8080; // Задаем порт для сервера
б
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port: " + port);
            while (true) { // Бесконечный цикл для принятия подключений
                Socket clientSocket = serverSocket.accept(); // Принимаем подключение клиента
                System.out.println("New connection accepted"); // Сообщение о новом подключении
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); // Поток вывода к клиенту
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // Поток ввода от клиента

                final String name = in.readLine(); // Чтение строки от клиента
                System.out.println("Received: " + name + " from port: " + clientSocket.getPort()); // Вывод полученной строки и порта клиента

                out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort())); // Ответ клиенту с его портом
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
