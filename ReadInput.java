import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadInput {
    private String ipAddressStart;
    private String ipAddressFinish;
    private Checks check = new Checks();


    public void read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        boolean isValidInput;
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
        }
        while (!line.equalsIgnoreCase("q") ^ check.ipRangeCheck(line) && isValidInput);
        if (line.equalsIgnoreCase("q")) check.isExit(line);

        reader.close();
    }


    public String getIpAddressStart() {
        return ipAddressStart;
    }

    public String getIpAddressFinish() {
        return ipAddressFinish;
    }
}
