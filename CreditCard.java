/**
 * CreditCard class
 * 
 * @author Aayusha Shrestha
 * @version 2023/02/27
 */
public class CreditCard extends BankCard
{
    //declaring CreditCard's attributes
    private int cvcNumber,gracePeriod;
    private double creditLimit,interestRate;
    private String expirationDate;
    private boolean isGranted;
    
    /** CreditCard constructor **/
    public CreditCard(int cardID,String clientName,String issuerBank,String bankAccount,
                    int balanceAmount,int cvcNumber,double interestRate,String expirationDate)
    {
        super(balanceAmount,cardID,bankAccount,issuerBank);
        super.setClientName(clientName);
        this.cvcNumber = cvcNumber;
        this.interestRate = interestRate;
        this.expirationDate = expirationDate;
        this.isGranted = false; 
    }

    /** Returns cvcNumber **/
    public int getCvcNumber()
    {
        return this.cvcNumber;
    }

    /** Returns creditLimit **/
    public double getCreditLimit()
    {
        return this.creditLimit;
    }

    /** Returns interestRate **/
    public double getInterestRate()
    {
        return this.interestRate;
    }

    /** Returns expirationDate **/
    public String getExpirationDate()
    {
        return this.expirationDate;
    }

    /** Returns gracePeriod **/
    public int getGracePeriod()
    {
        return this.gracePeriod;
    }

    /** Returns isGranted **/
    public boolean getIsGranted()
    {
        return this.isGranted;
    }

    /**
     * Sets creditLimit
     * 
     * @param creditLimit, gracePeriod
     */
    public void setCreditLimit(double creditLimit,int gracePeriod)
    {
        //grants credit if credit limit is less than or equal to 2.5 times the balance amount
        if(creditLimit <= 2.5 * getBalanceAmount()) {
            this.creditLimit = creditLimit;
            this.gracePeriod = gracePeriod;
            this.isGranted = true;
        }
        //prints if credit limit is greater than 2.5 times the balance amount
        else {
            System.out.println("Credit cannot be granted.");
        }
    }

    /** cancelCreditCard method **/
    public void cancelCreditCard()
    {
        //removes client's credit card
        this.cvcNumber = 0;
        this.creditLimit = 0;
        this.gracePeriod = 0;
        this.isGranted = false;
    }

    /** Display method **/
    public void display()
    {
        //prints bank card and credit card's details except credit limit and grace period
        super.display();
        System.out.println("CVC Number: " + this.cvcNumber);
        System.out.println("Interest Rate: " + this.interestRate+"%");
        System.out.println("Expiration Date: " + this.expirationDate);
        //prints credit limit and grace period if credit is granted
        if(this.isGranted == true) {
            System.out.println("Credit Limit: Rs " + this.creditLimit);
            System.out.println("Grace Period: " + this.gracePeriod+" days");
        }
    }
}
