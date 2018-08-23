package com.microsoft;

/**
 * Created by Tian on 2017/8/10.
 */
public class NormalizePhoneNumber {
    public static void main(String[] args) {
        String[] numbers = {"yyyxxxzzzz", "yyy-xxx-zzzz"};
        NormalizePhoneNumber np = new NormalizePhoneNumber();
        np.convert(numbers);
    }

    public void convert(String[] numbers) {
        String norm = "";
        for (String num : numbers) {
            if (num.contains("-")) {
                norm = num.substring(4,7) + num.substring(0, 3) + num.substring(8);
            } else {
                norm = num.substring(3,6) + num.substring(0, 3) + num.substring(6);
            }
            System.out.println(norm);
        }
    }
}
