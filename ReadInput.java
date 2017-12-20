import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadInput {

    private static String ipAddressStart;
    private static String ipAddressFinish;
    private Checks check = new Checks();


    public void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        boolean isValidInput;
        boolean isEqals;
        System.out.println(
                "Введите стартовый IP-адрес или \"q\", чтобы выйти из программы и нажмите клавишу \"Enter\"");
        //Шаг 1
        do {
            line = reader.readLine();
            if (check.ipRangeCheck(line)) ipAddressStart = line;
            else System.out.println("Недопустимое стартовое значение диапазона.");
        }
        while (!line.equalsIgnoreCase("q") ^ check.ipRangeCheck(line));

        if (line.equalsIgnoreCase("q")) check.isExit(line);
        //Шаг 2
        do {
            line = reader.readLine();
            if (check.ipRangeCheck(line)) ipAddressFinish = line;
            else System.out.println("Недопустимое конечное значение диапазона.");
            isValidInput = check.ipFinishOverStartCheck(ipAddressStart, ipAddressFinish);
            isEqals = check.ipEqalsCheck(ipAddressStart, ipAddressFinish);
        }
        while (!line.equalsIgnoreCase("q") ^ check.ipRangeCheck(line) && isValidInput && !isEqals);
        if (line.equalsIgnoreCase("q")) check.isExit(line);

        reader.close();
    }


    public static String getIpAddressStart() {
        return ipAddressStart;
    }

    public static String getIpAddressFinish() {
        return ipAddressFinish;
    }
}
