
package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;

public class Program {
    
    public static void main(String[] args) throws ParseException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter contract data");
        System.out.println("Number:");
        int number = sc.nextInt();
        System.out.println("Date (dd/MM/yyyy):");
        Date data = sdf.parse(sc.next());
        System.out.println("Contract value:");
        double totalValue = sc.nextDouble();
        Contract contract = new Contract(number, data, totalValue);
        System.out.println("Enter number of installments:");
        int n = sc.nextInt();
        ContractService cs = new ContractService(new PaypalService());
        cs.processContract(contract, n);
        System.out.println("Installments:");
        for(Installment it: contract.getInstallment()){
            System.out.println(it);            
        }        
        sc.close();
    }
    
}
