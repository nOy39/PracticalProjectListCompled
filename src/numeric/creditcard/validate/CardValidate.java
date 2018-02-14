package numeric.creditcard.validate;

import java.util.Scanner;

/**
 * Предположим у нас есть карта с номером 4408 0412 3456 7890
 из вышеуказонной таблици мы узнали,что это visa..., далее узнаем действительна она или нет, применим для проверки Luhn алгоритм:

 1) Умножаем каждую 2-ю цифру с права на 2.
 2) Результаты умножения должны быть меньше 10, поэтому там где значение больше 10 вычитаем 9.
 3) Складываем первые оригинальные цифры с результатом умножения вторых цифр на 2.
 Пример на номере 4408 0412 3456 7890

 ....4 ....4 ....0 .....8 ....0 .....4 ....1 .... 2 ....3 ......4 ....5 .......6 ....7 .......8 .....9 ........0
 4х2=8 ...0х2=0 ....0х2=0 ....1х2=2 ....3х2=6 ....5х2=10 ....7х2=14 ....9х2=18
 .................................................. .........................10-9=1 .....14-9=5 ....18-9=9
 8 + 4 + 0 + 8 + 0 + 4 + 2 + 2 + 6 + 4 + 1 + 6 + 5 + 8 + 9 + 0 = 67

 Мы получаем 67, которое не кратно 10, и поэтому мы заключаем, что номер 4408 0412 3456 7890 является Неверным номером кредитной карты.

 Другая карта,к примеру номер 4408 0412 3456 7893 проверяем её по Luhn алгоритму,так как показано выше.., мы получаем 70, делится на 10... 4417 1234 5678 9113 является действительный номер кредитной карты.
 */
public class CardValidate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cardnumber = sc.nextLine();

        char[] array = cardnumber.toCharArray();
        if (array[0]=='4') {
            System.out.println("Visa: ");
            cardValidate(array);
        }
        if (array[0]=='5') {
            System.out.println("MasterCard: ");
            cardValidate(array);
        }

        if (array[0]=='3') {
            System.out.println("AmericanExpress: ");
            cardValidate(array);
        } else {
            System.out.println("Unknown card type");
        }
    }

    private static void cardValidate(char[] array) {
        int sumValidate = 0;
        int mult;
        for (int i=0; i<=array.length-1;i++) {
            mult = 0;
            if (i%2==0) {
                mult = Character.getNumericValue(array[i])*2;
                if (mult>=10) {
                    mult -=9; }
                    sumValidate +=mult;
                } else {
                sumValidate += Character.getNumericValue(array[i]);
            }
        }

        if (sumValidate%10==0) System.out.println("Card Valid");
        else System.out.println("Not valid");
    }


}
