import java.util.ArrayList;
import java.util.Arrays;

class Processing {

    static ArrayList<String> output(String begin, String end) {
        ArrayList<String> result = new ArrayList<>();

        String[] startIP = begin.split("\\.");
        String[] endIP = end.split("\\.");
        int[] intsOfStart = new int[4];
        int[] intsOfEnd = new int[4];

        for (int i = 0; i < 4; i++) {
            intsOfStart[i] = Integer.parseInt(startIP[i]);
            intsOfEnd[i] = Integer.parseInt(endIP[i]);
        }

        int line = 256;

        switch (intsOfStart[0]) {
            case (192): {
                while (!Arrays.equals(intsOfStart, intsOfEnd)) {
                    result.add(intsOfStart[0] + "." + intsOfStart[1] + "." + intsOfStart[2] + "." + intsOfStart[3]);
                    intsOfStart[3]++;
                    if (intsOfStart[3] == line) {
                        intsOfStart[2]++;
                        intsOfStart[3] = 0;
                    }
                }
                break;
            }

            case (172): {
                while (!Arrays.equals(intsOfStart, intsOfEnd)) {
                    result.add(intsOfStart[0] + "." + intsOfStart[1] + "." + intsOfStart[2] + "." + intsOfStart[3]);
                    intsOfStart[3]++;
                    if (intsOfStart[3] == line) {
                        intsOfStart[2]++;
                        intsOfStart[3] = 0;
                    }
                    if (intsOfStart[2] == line) {
                        intsOfStart[1]++;
                        intsOfStart[2] = 0;
                    }
                }
                break;
            }

            case (10): {
                while (!Arrays.equals(intsOfStart, intsOfEnd)) {
                    result.add(intsOfStart[0] + "." + intsOfStart[1] + "." + intsOfStart[2] + "." + intsOfStart[3]);
                    intsOfStart[3]++;
                    if (intsOfStart[3] == line) {
                        intsOfStart[2]++;
                        intsOfStart[3] = 0;
                    }
                    if (intsOfStart[2] == line) {
                        intsOfStart[1]++;
                        intsOfStart[2] = 0;
                    }

                }
                break;
            }

            default: {
                result.add("Доступный диапазон не существует");
                break;
            }
        }

        return result;
    }
}
