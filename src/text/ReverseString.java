package text;


import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println("Expected output:");

        /*First*/
        firstReverse(text);
        
        /*Second*/
        secondReverse(text);
        
        /*Third*/
        thirdReverse(text);
    }

    private static void thirdReverse(String text) {
        StringBuilder stb = new StringBuilder();
        for (int i= text.length()-1;i>=0;i--) {
            stb.append(text.charAt(i));
        }
        System.out.println("4: \n"+stb);
    }

    private static void secondReverse(String text) {
        char[] arrrays = text.toCharArray();
        System.out.println("2:");
        for (int i=arrrays.length-1;i>=0;i--) {
            System.out.print(arrrays[i]);
        }
        System.out.println();
    }

    private static void firstReverse(String text) {
        StringBuffer sbf = new StringBuffer(text);
        System.out.println("1:\n"+sbf.reverse());
    }
}
