public class Checks {
    boolean ipRangeCheck(String check) {
        final String[] list = check.split("\\.");
        if (list.length < 4) return false; //Проверка на целостность IP
        for (String s : list) { //Проверка на валидность IP
            int temp;
            try {
                temp = Integer.parseInt(s);
                if (temp < 0 || temp > 239) return false;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    boolean ipFinishOverStartCheck(String ipAddressStart, String ipAddressFinish) {
        final String[] start = ipAddressStart.split("\\.");
        final String[] finish = ipAddressFinish.split("\\.");
        for (int i = 0; i < 4; i++) {
            if (Integer.parseInt(finish[i]) < Integer.parseInt(start[i])) return false;
        }
        return true;
    }

    boolean isExit(String exit){
        if (exit.equalsIgnoreCase("q")) {
            System.out.println("Пользователь завершил работу программы");
            System.exit(1);
        }
        return true;
    }
}
