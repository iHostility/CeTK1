import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать!\n" +
                "Работа программы гарантируется только для частных сетей\n" +
                "Доступные диапазоны:\n" +
                "A 10.0.0.0\t10.0.0.0 - 10.255.255.255\n" +
                "B 172.16.0.0 - 172.31.0.0\t172.16.0.0 - 172.31.255.255\n" +
                "C 192.168.0.0\t192.168.0.0 - 192.168.255.255");
        //1 - Считывание
        try {
            new ReadInput().read();
        } catch (Exception e) {
            System.out.println("Сорян");
        }
        //2 - Обработка
        ArrayList<String> output = Processing.output(ReadInput.getIpAddressStart(), ReadInput.getIpAddressFinish());
        output.remove(0); //Проще убрать первое лишнее вхождение, чем возиться с последними
        //3 - Результат
        for (String anOutput : output) System.out.println(anOutput);
    }
}
