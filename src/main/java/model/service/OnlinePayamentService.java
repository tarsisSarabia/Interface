package model.service;

public interface OnlinePayamentService {
    public double payamenteFee(double amount);
    public double interest(double amount, int months);
    
    
}
