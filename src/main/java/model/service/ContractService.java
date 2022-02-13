package model.service;

import java.util.Calendar;
import java.util.Date;
import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

    private OnlinePayamentService onlinePayamentService;

    public ContractService(OnlinePayamentService onlinePayamentService) {
        this.onlinePayamentService = onlinePayamentService;
    }

    public void processContract(Contract contract, int months) {
        double basicQuota = contract.getTotalValue() / months;
        for (int i = 1; i <= months; i++) {
            double updateQuota = basicQuota + onlinePayamentService.interest(basicQuota, i);
            double fullQuota = updateQuota + onlinePayamentService.payamenteFee(updateQuota);
            Date duodate = addMonths(contract.getData(), i);
            contract.getInstallment().add(new Installment(duodate, fullQuota));
            
        }

    }

    private Date addMonths(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, n);
        return  calendar.getTime();

    }

}
