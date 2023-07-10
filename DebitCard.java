/**
 * DebitCard class
 * 
 * @author Aayusha Shrestha
 * @version 2023/02/27
 */
public class DebitCard extends BankCard
{
    //declaring DebitCard's attributes
    private int pinNumber, withdrawalAmount;
    private String dateOfWithdrawal;
    private boolean hasWithdrawn;
    
    /** Debit card constructor **/
    public DebitCard(int balanceAmount,int cardID,String bankAccount,String issuerBank,String clientName, int pinNumber)
    {
        super(balanceAmount,cardID,bankAccount,issuerBank);
        super.setClientName(clientName);
        this.pinNumber = pinNumber;
        this.hasWithdrawn = false;
    }

    /** Returns pinNumber **/
    public int getPinNumber()
    {
        return this.pinNumber;
    }

    /** Returns withdrawalAmount **/
    public int getWithdrawalAmount()
    {
        return this.withdrawalAmount;
    }

    /** Returns dateOfWithdrawal **/
    public String getDateOfWithdrawal()
    {
        return this.dateOfWithdrawal;
    }

    /** Returns hasWithdrawn **/
    public boolean getHasWithdrawn()
    {
        return this.hasWithdrawn;
    }

    /**
     * Sets withdrawalAmount
     * 
     * @param withdrawalAmount
     */
    public void setWithdrawalAmount(int withdrawalAmount)
    {
        this.withdrawalAmount = withdrawalAmount;
    }

    /**
     * Withdraw method 
     * 
     * @param withdrawalAmount, dateOfWithdrawal, pinNumber
     */
    public void withdraw(int withdrawalAmount, String dateOfWithdrawal, int pinNumber)
    {
        int currentBalanceAmount = super.getBalanceAmount();
        //prints if PIN is incorrect
        if (pinNumber != this.pinNumber) {
            System.out.println("Incorrect pin number. Please retype the PIN number.");
        }
        //prints if withdrawal amount is less than balance amount
        else if (withdrawalAmount > currentBalanceAmount) {
            System.out.println("Insufficient balance.");
            System.out.println("Balance Amount: Rs " + currentBalanceAmount);
        } 
        //withdraws money then, deducts money from client account
        else if (pinNumber == this.pinNumber && withdrawalAmount <= currentBalanceAmount) {
            this.hasWithdrawn = true;
            this.setWithdrawalAmount(withdrawalAmount);
            this.dateOfWithdrawal = dateOfWithdrawal;
            int newBalanceAmount = currentBalanceAmount - withdrawalAmount;
            this.setBalanceAmount(newBalanceAmount);
            this.display();
        } 
        //prints if withdrawal amount is 0
        else {
            this.display();
        }
    }

    /** Display method **/
    public void display()
    {
        //prints if the client has withdrawn money
        if(this.hasWithdrawn == true) {
            System.out.println("Withdrawal Amount: Rs " + this.withdrawalAmount);
            System.out.println("Date of Withdrawal: " + this.dateOfWithdrawal); 
            System.out.println("PIN number: " + this.pinNumber);
        }
        //prints if the client has not withdrawn money
        else {
            System.out.println("Balance Amount: Rs " + super.getBalanceAmount());
        }
        super.display();
    }
}