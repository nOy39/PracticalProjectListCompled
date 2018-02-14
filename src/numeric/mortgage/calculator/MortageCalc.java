package numeric.mortgage.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MortageCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        int year = 0;
        double procent = 0;
        try {
            System.out.print("Enter summ: ");
            sum = Double.parseDouble(sc.nextLine());
            System.out.print("Enter period in year: ");
            year = Integer.parseInt(sc.nextLine());
            System.out.print("Enter procent: ");
            procent = Double.parseDouble(sc.nextLine());
        }   catch (Exception ex) {
            System.err.print("Error Input");
        }
        diffPayment(sum,year,procent);
        annuPayment(sum,year,procent);
    }

    private static void diffPayment(double sum, int year, double procent) {
        List<DiffPayment> paymentList = new ArrayList<>();
            int i=0;
            double activeCreidit = sum;
            double allCredit = 0, allProcent = 0, allCheck = 0;
            do {
                double sumMainCredit = sum/(year*12);
                double activeProcent = (activeCreidit * (procent/12))/100;
                double activePayments = sumMainCredit+activeProcent;
                sumMainCredit = Math.rint(100.00*sumMainCredit)/100.00;
                activeProcent = Math.rint(100.00*activeProcent)/100.00;
                activePayments = Math.rint(100.00*activePayments)/100.00;
                paymentList.add(new DiffPayment(activeCreidit,activeProcent,sumMainCredit,activePayments));
                activeCreidit -= sumMainCredit;
                activeCreidit = Math.rint(100.00*activeCreidit)/100.00;
                System.out.println(paymentList.get(i));
                allCredit+=sum;
                allProcent+=activeProcent;
                allCheck+=activePayments;
                i++;
            } while (activeCreidit>=1);

        System.out.println("Procent: { "+allProcent+" } Credit: { "+sum+" } Check: { "+allCheck+" }");
    }

    private static void annuPayment(double sum, int year, double procent) {
        double activeCredit = sum;
        double i = (procent/(year*12)/100);
        double period = year*12;

        double k = (i * Math.pow((1+i),period))/((Math.pow((1+i),period)-1));
        double a = sum*k;
        System.out.println(a);
    }
}
