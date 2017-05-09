public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        int sum = 0;
        String[] extraStr = bowlingCode.split("\\|\\|");    //split regulation game and extra game
        String[] perblockStr = new String[12];
        String[] temp = extraStr[0].split("\\|");    //split every block of regulation game
        for (int i = 0; i < 10; i++) {
            perblockStr[i] = temp[i];
        }
        switch (extraStr.length) {
            case 1 : perblockStr[10] = "0";perblockStr[11] = "0";break;
            case 2 : {
                perblockStr[10] = extraStr[1].charAt(0) + "0";
                switch (extraStr[1].length()) {
                    case 1 : perblockStr[11] = "00";break;
                    case 2 : perblockStr[11] = extraStr[1].charAt(1) + "0";break;
                }
                break;
            }
        }

        sum = 0;
        for (int i = 0; i < 10; i++) {
            if (perblockStr[i].charAt(0) == 'X') {
                sum += 10;
                if (perblockStr[i + 1].charAt(0) == 'X') {
                    sum += 10;
                    if (perblockStr[i + 2].charAt(0) == 'X') {
                        sum += 10;
                    }
                    else if (perblockStr[i + 2].charAt(0) != '-') {
                        sum += Integer.valueOf(perblockStr[i + 2].charAt(0)) - 48;
                    }
                }
                else if (perblockStr[i + 1].charAt(1) == '/') {
                    sum += 10;
                }
                else if (i == 9) {
                    for (int j = 0; j < perblockStr[i + 1].length(); j++) {
                        if (perblockStr[i + 1].charAt(j) != '-') {
                            sum += Integer.valueOf(perblockStr[i + 1].charAt(j)) - 48;
                        }
                    }
                    for (int j = 0; j < perblockStr[i + 2].length(); j++) {
                        if (perblockStr[i + 2].charAt(j) != '-') {
                            sum += Integer.valueOf(perblockStr[i + 2].charAt(j)) - 48;
                        }
                    }
                }
                else {
                    for (int j = 0; j < perblockStr[i + 1].length(); j++) {
                        if (perblockStr[i + 1].charAt(j) != '-') {
                            sum += Integer.valueOf(perblockStr[i + 1].charAt(j)) - 48;
                        }
                    }
                }
            }
            else if (perblockStr[i].charAt(1) == '/') {
                sum += 10;
                switch (perblockStr[i + 1].charAt(0)) {
                    case 'X' : sum += 10;break;
                    case '-' : sum += 0;break;
                    default : sum += Integer.valueOf(perblockStr[i + 1].charAt(0)) - 48;
                }
            }
            else {
                for (int j = 0; j < perblockStr[i].length(); j++) {
                    if (perblockStr[i].charAt(j) != '-') {
                        sum += Integer.valueOf(perblockStr[i].charAt(j)) - 48;
                    }
                }
            }
        }

        return sum;
    }

    public static void main (String[] args) {
        String[] str = new String[5];
        str[0] = "X|X|X|X|X|X|X|X|X|X||XX";
        str[1] = "9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||";
        str[2] = "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5";
        str[3] = "X|7/|9-|X|-8|8/|-6|X|X|X||81";
        str[4] = "13|7/|6-|X|-8|8/|-6|X|54|X||81";

        BowlingGame mygame = new BowlingGame();
        for (String x : str) {
            System.out.println(mygame.getBowlingScore(x));
        }
    }
}
