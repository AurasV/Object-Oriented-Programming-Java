import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
public class Bank {
    private List<Loan> loans = new ArrayList<>();
    public void addLoan(Loan l){
        loans.add(l);
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
    
    public boolean remove(Loan l){
        return loans.remove(l);
    }

    public ArrayList<Loan> find(String name){
        ArrayList<Loan> found_loans = new ArrayList<>();
        for(Loan l : loans){
            if(l.getOwner().getName().equals(name)){
                found_loans.add(l);
            }
        }
        return found_loans;
    }

    public ArrayList<Loan> find(String name, double minAmount){
        ArrayList<Loan> found_loans = new ArrayList<>();
        for(Loan l : loans){
            if(l.getOwner().getName().equals(name) && l.getAmount() >= minAmount){
                found_loans.add(l);
            }
        }
        return found_loans;
    }

    public void printInFile(String fileName){
        try {
            FileWriter write_to_file = new FileWriter(fileName);
            for (Loan l : loans) {
                System.out.println("Wrote to file " + fileName + ": " + l.getId() + " " + l.getAmount());
                write_to_file.write(l.getId() + " " + l.getAmount() + "\n");
            }
            write_to_file.close();
        }
        catch (Exception e){
            System.out.println("Error while writing to file: " + e.getMessage());
        }
    }
}
