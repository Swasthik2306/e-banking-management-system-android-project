package ajiet.ise.dept.horizonbank;

public class accdetaills {
    private  String accountnumber,accountbalance,email;

    public accdetaills()
    {

    }

    public accdetaills(String accountnumber, String accountbalance, String email) {
        this.accountnumber = accountnumber;
        this.accountbalance = accountbalance;
        this.email = email;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getAccountbalance() {
        return accountbalance;
    }

    public void setAccountbalance(String accountbalance) {
        this.accountbalance = accountbalance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
