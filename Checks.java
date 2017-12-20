public class Checks {
    boolean ipRangeCheck(String check) {
        final String[] list = check.split("\\.");

        if (list.length < 4) return false; //Проверка на целостность IP

        for (String s : list) { //Проверка на валидность IP
            int temp;
            try {
                temp = Integer.parseInt(s);
                if (temp < 0 || temp > 255) return false;
            } catch (Exception e) {
                return false;
            }
        }
        int one = Integer.parseInt(list[0]);
        int two = Integer.parseInt(list[1]);

        //Проверка на принадлежность к частным сетям
        boolean onePassed = (one == 10 ^ one == 172 ^ one == 192);
        boolean twoPassed1 = (one == 172 && (two > 15 && two < 32));
        boolean twoPassed2 = (one == 192 && two == 168);

        return (onePassed ^ twoPassed1 ^ twoPassed2);
    }

    boolean ipFinishOverStartCheck(String ipAddressStart, String ipAddressFinish) {
        final String[] start = ipAddressStart.split("\\.");
        final String[] finish = ipAddressFinish.split("\\.");
        for (int i = 0; i < 4; i++) {
            if (Integer.parseInt(finish[i]) < Integer.parseInt(start[i])) return false;
        }
        return true;
    }

    void isExit(String exit) {
        if (exit.equalsIgnoreCase("q")) {
            System.out.println("Пользователь завершил работу программы");
            System.exit(1);
        }
    }
}
