package numeric.mortgage.calculator;

public class DiffPayment {
    private double credit;
    private double procent;
    private double mainCredit;
    private double sumCheck;

    public DiffPayment(double credit, double procent, double mainCredit, double sumCheck) {
        this.credit = credit;
        this.procent = procent;
        this.mainCredit = mainCredit;
        this.sumCheck = sumCheck;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getProcent() {
        return procent;
    }

    public void setProcent(double procent) {
        this.procent = procent;
    }

    public double getMainCredit() {
        return mainCredit;
    }

    public void setMainCredit(double mainCredit) {
        this.mainCredit = mainCredit;
    }

    public double getSumCheck() {
        return sumCheck;
    }

    public void setSumCheck(double sumCheck) {
        this.sumCheck = sumCheck;
    }

    @Override
    public String toString() {
        return "DiffPayment{" +
                "credit=" + credit +
                ", procent=" + procent +
                ", mainCredit=" + mainCredit +
                ", sumCheck=" + sumCheck +
                '}';
    }
}
