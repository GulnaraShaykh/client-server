import java.io.*; // Импорт классов для ввода-вывода
import java.net.*; // Импорт классов для работы с сетью

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "localhost"; // Адрес сервера
        int port = 8080; // Порт, на котором работает сервер
        try (Socket socket = new Socket(host, port)) { // Создаем сокет для подключения к серверу
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Поток вывода к серверу
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Поток ввода от сервера
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)); // Чтение с консоли

            System.out.println("Enter a string to send to the server:"); // Приглашение к вводу строки
            String userInput = stdIn.readLine(); // Чтение строки с консоли

            out.println(userInput); // Отправка строки серверу
            System.out.println("Server says: " + in.readLine()); // Вывод ответа от сервера
        } catch (UnknownHostException e) { // Обработка исключения неизвестного хоста
            System.err.println("Don't know about host " + host);
            System.exit(1); // Выход из программы с ошибкой
        } catch (IOException e) { // Обработка исключений ввода-вывода
            System.err.println("Couldn't get I/O for the connection to " + host);
            System.exit(1); // Выход из программы с ошибкой
        }
    }
}
