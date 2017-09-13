package array;

import java.util.Scanner;

public class AutoSizeArray {

    Array array;

    AutoSizeArray() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int begin = 0;
        int end = 0;
        int size = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                end = i;
                size++;
                begin = end + 1;
            } else if (i == str.length() - 1) {
                end = i + 1;
                size++;
            }
        }
        begin = 0;
        end = 0;
        array = new Array(size);
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                end = i;
                array.setElement(Double.parseDouble(str.substring(begin, end)), j);
                j++;
                begin = end + 1;
            } else if (i == str.length() - 1) {
                end = i + 1;
                array.setElement(Double.parseDouble(str.substring(begin, end)), j);
                j++;
            }
        }
    }

    public static void main(String[] args) {
        AutoSizeArray asArray = new AutoSizeArray();
        asArray.array.show();
    }
}
