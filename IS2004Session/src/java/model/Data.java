package model;
public class Data {
    private double n1, n2, rs;
    private String op;

    public Data(double n1, double n2, String op, double rs) {
        this.n1 = n1;
        this.n2 = n2;
        this.rs = rs;
        this.op = op;
    }

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double getRs() {
        return rs;
    }

    public void setRs(double rs) {
        this.rs = rs;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
    
    
}
