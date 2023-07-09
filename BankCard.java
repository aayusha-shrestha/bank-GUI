/**
 * BankCard class
 * 
 * @author Aayusha Shrestha
 * @version 2023/02/27
 */
public class BankCard
{
    //declaring BankCard's attributes
    private int cardID,balanceAmount;
    private String clientName,issuerBank,bankAccount;
    
    /** BankCard constructor **/
    public BankCard(int balanceAmount,int cardID,String bankAccount,String issuerBank)
    {
        this.clientName = "";
        this.balanceAmount = balanceAmount;
        this.cardID = cardID;
        this.bankAccount = bankAccount;
        this.issuerBank = issuerBank;
    }

    /** Returns cardID **/
    public int getCardID()
    {
        return this.cardID;
    }

    /** Returns clientName **/
    public String getClientName()
    {
        return this.clientName;
    }

    /** Returns issuer bank **/
    public String getIssuerBank()
    {
        return this.issuerBank;
    }

    /** Returns bankAccount **/
    public String getBankAccount()
    {
        return this.bankAccount;
    }

    /** Returns balanceAmount **/
    public int getBalanceAmount()
    {
        return this.balanceAmount;
    }

    /**
     * Sets clientName
     * 
     * @param clientName
     */
    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }

    /**
     * Sets balanceAmount
     * 
     * @param balanceAmount 
     */
    public void setBalanceAmount(int balanceAmount)
    {
        this.balanceAmount = balanceAmount;
    }

    /** Display method **/
    public void display()
    {
        //prints client name if assigned
        if(this.clientName.isEmpty()){
            System.out.println("Client name not assigned");
        }
        else {
            System.out.println("Client Name: " + this.clientName);
        }
        //prints rest of the bank card details
        System.out.println("Card ID: " + this.cardID);
        System.out.println("Issuer Bank: " + this.issuerBank);
        System.out.println("Bank Account: " + this.bankAccount);
        System.out.println("Balance Amount: Rs " + this.balanceAmount);
    }
}