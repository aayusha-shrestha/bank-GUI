/**
 * BankGUI class.
 *
 * @author Aayusha Shrestha
 * @version 2023/04/14
 */
import java.util.ArrayList;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class BankGUI implements ActionListener
{
    private JFrame mainFrame,frameDebit,frameCredit,frameWithdraw,frameSetCredit,frameCancelCredit;

    private JPanel mainPnl,pnlDebit,pnlCredit,pnlWithdraw,pnlSetCredit,pnlCancelCredit;

    private JLabel lblTitle,
    lblDebitCard,lblCardIDDebit,lblClientNameDebit,lblIssuerBankDebit,lblBankAccDebit,lblBalanceAmountDebit,lblPIN,
    lblWithdraw,lblIdChkWithdraw,lblWithdrawalAmount,lblPINCheck,lblWithdrawalDate,
    lblCreditCard,lblCardIDCredit,lblClientNameCredit,lblIssuerBankCredit,lblBankAccCredit,lblBalanceAmountCredit,lblCVCnum,
    lblInterestRate,lblExpirationDate,
    lblSetCredit,lblIdChkSetCredit,lblCreditLimit,lblGracePeriod,
    lblCancelCredit,lblIdChkCancelCredit;

    private JTextField txtCardIDDebit,txtClientNameDebit,txtIssuerBankDebit,txtBankAccDebit,txtBalanceAmountDebit,
    txtIdChkWithdraw,txtWithdrawalAmount,
    txtCardIDCredit,txtClientNameCredit,txtIssuerBankCredit,txtBankAccCredit,txtBalanceAmountCredit,txtCVCnum,txtInterestRate,
    txtIdChkSetCredit,txtCreditLimit,txtGracePeriod,txtIdChkCancelCredit;
    
    private JPasswordField pwfPIN,pwfPINCheck;

    private JComboBox cmbDayDebit,cmbMonthDebit,cmbYearDebit,cmbDayCredit,cmbMonthCredit,cmbYearCredit;

    private JButton btnDebitCard,btnCreditCard,btnAddDebit,btnGoToWithdraw,btnDisplayDebit,btnClrDebit,btnGoBackDebit,
    btnDetWithdraw,btnWithdraw,btnClrWithdraw,btnDisplayWithdraw,btnGoBackWithdraw,
    btnAddCredit,btnGoToSetCredit,btnGoToCancelCredit,btnDisplayCredit,btnClrCredit,btnGoBackCredit,
    btnDetSetCredit,btnSetCreditLimit,btnDisplaySetCredit,btnClrSetCredit,btnGoBackSetCredit,
    btnDetCancelCredit,btnCancelCredit,btnDisplayCancelCredit,btnClrCancelCredit,btnGoBackCancelCredit;
    
    private Font newFont;
    
    private Color colorBg,colorBtn,colorBtnGoBack;

    private String[]day,month,year;

    private ArrayList <BankCard> alBankCard;
    
    private String border;
    
    private DebitCard objDebit;
    
    private CreditCard objCredit;

    public BankGUI()
    {
        alBankCard = new ArrayList<BankCard>();
        
        day = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23",
            "24","25","26","27","28","29","30"};
        month = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
        year = new String[]{"2023","2024","2025","2026","2027"};
        
        border = "-".repeat(39);
        
        newFont = new Font("Tahoma",Font.PLAIN,16);
        colorBg = new Color(235,235,211);
        colorBtn = new Color(8,61,119);
        colorBtnGoBack = new Color(140,140,140);
        
        /** main frame **/
        
        mainFrame = new JFrame("BANK");
        mainPnl = new JPanel();
        mainPnl.setLayout(null);
        mainPnl.setBackground(new Color(220,220,220));
        mainFrame.add(mainPnl);

        lblTitle = new JLabel("PLEASE SELECT THE CARD AS PER YOUR REQUIREMENT.");
        btnDebitCard = new JButton("DEBIT CARD");
        btnCreditCard = new JButton("CREDIT CARD");

        lblTitle.setBounds(38,57,440,20);
        btnDebitCard.setBounds(34,136,237,142);
        btnCreditCard.setBounds(215,321,237,142);

        lblTitle.setFont(newFont);
        btnDebitCard.setFont(newFont);
        btnCreditCard.setFont(newFont);

        btnDebitCard.setBackground(Color.blue);
        btnCreditCard.setBackground(Color.orange);
        btnDebitCard.setForeground(Color.white);

        mainPnl.add(lblTitle);
        mainPnl.add(btnDebitCard);
        mainPnl.add(btnCreditCard);

        btnDebitCard.addActionListener(this);
        btnCreditCard.addActionListener(this);

        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setSize(500,537);
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null); //centers the window

        /** debit card frame **/

        frameDebit = new JFrame("Debit Card");
        pnlDebit = new JPanel();
        pnlDebit.setLayout(null);
        pnlDebit.setBackground(colorBg);
        frameDebit.add(pnlDebit);

        lblDebitCard = new JLabel("DEBIT ACCOUNT FORM");
        lblCardIDDebit = new JLabel("Card ID:");
        txtCardIDDebit = new JTextField();
        lblClientNameDebit = new JLabel("Client Name:");
        txtClientNameDebit= new JTextField();
        lblIssuerBankDebit = new JLabel("Issuer Bank:");
        txtIssuerBankDebit = new JTextField();
        lblBankAccDebit = new JLabel("Bank Account:");
        txtBankAccDebit = new JTextField();
        lblBalanceAmountDebit = new JLabel("Balance Amount:");
        txtBalanceAmountDebit = new JTextField();
        lblPIN = new JLabel("PIN Number:");
        pwfPIN = new JPasswordField();
        btnAddDebit = new JButton("Add"); 
        btnGoToWithdraw = new JButton("Withdraw"); 
        btnDisplayDebit = new JButton("Display");
        btnClrDebit = new JButton("Clear");
        btnGoBackDebit = new JButton("Go Back");

        lblDebitCard.setFont(newFont);
        lblCardIDDebit.setFont(newFont);
        txtCardIDDebit.setFont(newFont);
        lblClientNameDebit.setFont(newFont);
        txtClientNameDebit.setFont(newFont);
        lblIssuerBankDebit.setFont(newFont);
        txtIssuerBankDebit.setFont(newFont);
        lblBankAccDebit.setFont(newFont);
        txtBankAccDebit.setFont(newFont);
        lblBalanceAmountDebit.setFont(newFont);
        txtBalanceAmountDebit.setFont(newFont);
        lblPIN.setFont(newFont);
        pwfPIN.setFont(newFont);
        btnAddDebit.setFont(newFont);
        btnGoToWithdraw.setFont(newFont);
        btnDisplayDebit.setFont(newFont);
        btnClrDebit.setFont(newFont);
        btnGoBackDebit.setFont(newFont);

        btnAddDebit.setBackground(colorBtn);
        btnAddDebit.setForeground(Color.white);
        btnGoToWithdraw.setBackground(colorBtn);
        btnGoToWithdraw.setForeground(Color.white);
        btnDisplayDebit.setBackground(colorBtn);
        btnDisplayDebit.setForeground(Color.white);
        btnClrDebit.setBackground(colorBtn);
        btnClrDebit.setForeground(Color.white);
        btnGoBackDebit.setBackground(colorBtnGoBack);
        btnGoBackDebit.setForeground(Color.white);

        lblDebitCard.setBounds(261,36,195,22);
        lblCardIDDebit.setBounds(73,98,72,22);
        txtCardIDDebit.setBounds(73,130,159,22);
        lblClientNameDebit.setBounds(457,98,141,22);
        txtClientNameDebit.setBounds(457,130,159,22);
        lblIssuerBankDebit.setBounds(73,179,89,22);
        txtIssuerBankDebit.setBounds(73,211,159,22);
        lblBankAccDebit.setBounds(457,179,102,22);
        txtBankAccDebit.setBounds(457,211,159,22);
        lblBalanceAmountDebit.setBounds(73,260,134,22);
        txtBalanceAmountDebit.setBounds(73,292,159,22);
        lblPIN.setBounds(73,341,120,22);
        pwfPIN.setBounds(73,373,159,22);
        btnAddDebit.setBounds(499,261,118,29);
        btnGoToWithdraw.setBounds(499,397,118,29);
        btnDisplayDebit.setBounds(73,458,118,29);
        btnClrDebit.setBounds(286,458,118,29);
        btnGoBackDebit.setBounds(499,458,118,29);

        pnlDebit.add(lblDebitCard);
        pnlDebit.add(lblCardIDDebit);
        pnlDebit.add(txtCardIDDebit);
        pnlDebit.add(lblClientNameDebit);
        pnlDebit.add(txtClientNameDebit);
        pnlDebit.add(lblIssuerBankDebit);
        pnlDebit.add(txtIssuerBankDebit);
        pnlDebit.add(lblBankAccDebit);
        pnlDebit.add(txtBankAccDebit);
        pnlDebit.add(lblBalanceAmountDebit);
        pnlDebit.add(txtBalanceAmountDebit);
        pnlDebit.add(lblPIN);
        pnlDebit.add(pwfPIN);
        pnlDebit.add(btnAddDebit);
        pnlDebit.add(btnGoToWithdraw);
        pnlDebit.add(btnDisplayDebit);
        pnlDebit.add(btnClrDebit);
        pnlDebit.add(btnGoBackDebit);

        btnAddDebit.addActionListener(this);
        btnGoToWithdraw.addActionListener(this);
        btnDisplayDebit.addActionListener(this);
        btnClrDebit.addActionListener(this);
        btnGoBackDebit.addActionListener(this);

        frameDebit.setResizable(false);
        frameDebit.setSize(710,560);
        frameDebit.setDefaultCloseOperation(frameDebit.EXIT_ON_CLOSE);
        frameDebit.setLocationRelativeTo(null);
        
        /** withdraw frame **/
        
        frameWithdraw = new JFrame("Withdraw");
        pnlWithdraw = new JPanel();
        pnlWithdraw.setLayout(null);
        pnlWithdraw.setBackground(colorBg);
        frameWithdraw.add(pnlWithdraw);
        
        lblWithdraw = new JLabel("CASH WITHDRAWAL");
        lblIdChkWithdraw = new JLabel("Card ID:");
        txtIdChkWithdraw = new JTextField();
        lblPINCheck = new JLabel("PIN Number:");
        pwfPINCheck = new JPasswordField();
        lblWithdrawalAmount = new JLabel("Withdrawal Amount:");
        txtWithdrawalAmount = new JTextField();
        lblWithdrawalDate = new JLabel("Withdrawal Date:");
        cmbDayDebit = new JComboBox(day);
        cmbMonthDebit = new JComboBox(month);
        cmbYearDebit = new JComboBox(year);
        btnDetWithdraw = new JButton("Get Details");
        btnWithdraw = new JButton("Withdraw"); 
        btnDisplayWithdraw = new JButton("Display");
        btnClrWithdraw = new JButton("Clear");
        btnGoBackWithdraw = new JButton("Go Back");
        
        lblWithdraw.setFont(newFont);
        lblIdChkWithdraw.setFont(newFont);
        txtIdChkWithdraw.setFont(newFont);
        lblPINCheck.setFont(newFont);
        pwfPINCheck.setFont(newFont);
        lblWithdrawalAmount.setFont(newFont);
        txtWithdrawalAmount.setFont(newFont);
        lblWithdrawalDate.setFont(newFont);
        cmbDayDebit.setFont(newFont);
        cmbMonthDebit.setFont(newFont);
        cmbYearDebit.setFont(newFont);
        btnDetWithdraw.setFont(newFont);
        btnWithdraw.setFont(newFont);
        btnDisplayWithdraw.setFont(newFont);
        btnClrWithdraw.setFont(newFont);
        btnGoBackWithdraw.setFont(newFont);
        
        btnDetWithdraw.setBackground(colorBtn);
        btnDetWithdraw.setForeground(Color.white);
        btnWithdraw.setBackground(colorBtn);
        btnWithdraw.setForeground(Color.white);
        btnDisplayWithdraw.setBackground(colorBtn);
        btnDisplayWithdraw.setForeground(Color.white);
        btnClrWithdraw.setBackground(colorBtn);
        btnClrWithdraw.setForeground(Color.white);
        btnGoBackWithdraw.setBackground(colorBtnGoBack);
        btnGoBackWithdraw.setForeground(Color.white);
        
        lblWithdraw.setBounds(278,35,159,22);
        lblIdChkWithdraw.setBounds(73,92,72,22);
        txtIdChkWithdraw.setBounds(73,124,159,22);
        lblPINCheck.setBounds(73,212,120,22);
        pwfPINCheck.setBounds(73,243,159,22);
        lblWithdrawalAmount.setBounds(73,292,170,22);
        txtWithdrawalAmount.setBounds(73,323,159,22);
        lblWithdrawalDate.setBounds(73,379,142,22);
        cmbDayDebit.setBounds(230,379,74,23);
        cmbMonthDebit.setBounds(320,379,105,23);
        cmbYearDebit.setBounds(441,379,79,23);
        btnDetWithdraw.setBounds(73,160,114,29);
        btnWithdraw.setBounds(516,431,118,29);
        btnDisplayWithdraw.setBounds(73,491,118,29);
        btnClrWithdraw.setBounds(286,491,118,29);
        btnGoBackWithdraw.setBounds(516,489,118,29);
        
        pnlWithdraw.add(lblWithdraw);
        pnlWithdraw.add(lblIdChkWithdraw);
        pnlWithdraw.add(txtIdChkWithdraw);
        pnlWithdraw.add(lblPINCheck);
        pnlWithdraw.add(pwfPINCheck);
        pnlWithdraw.add(lblWithdrawalAmount);
        pnlWithdraw.add(txtWithdrawalAmount);
        pnlWithdraw.add(lblWithdrawalDate);
        pnlWithdraw.add(cmbDayDebit);
        pnlWithdraw.add(cmbMonthDebit);
        pnlWithdraw.add(cmbYearDebit);
        pnlWithdraw.add(btnDetWithdraw);
        pnlWithdraw.add(btnWithdraw);
        pnlWithdraw.add(btnDisplayWithdraw);
        pnlWithdraw.add(btnClrWithdraw);
        pnlWithdraw.add(btnGoBackWithdraw);
        
        btnDetWithdraw.addActionListener(this);
        btnWithdraw.addActionListener(this);
        btnDisplayWithdraw.addActionListener(this);
        btnClrWithdraw.addActionListener(this);
        btnGoBackWithdraw.addActionListener(this);
        
        frameWithdraw.setResizable(false);
        frameWithdraw.setSize(710,600);
        frameWithdraw.setDefaultCloseOperation(frameDebit.EXIT_ON_CLOSE);
        frameWithdraw.setLocationRelativeTo(null);

        /** credit card frame **/

        frameCredit = new JFrame("Credit Card");
        pnlCredit = new JPanel();
        pnlCredit.setLayout(null);
        pnlCredit.setBackground(colorBg);
        frameCredit.add(pnlCredit);

        lblCreditCard = new JLabel("CREDIT ACCOUNT FORM");
        lblCardIDCredit = new JLabel("Card ID:");
        txtCardIDCredit = new JTextField();
        lblClientNameCredit = new JLabel("Client Name:");
        txtClientNameCredit = new JTextField();
        lblIssuerBankCredit = new JLabel("Issuer Bank:");
        txtIssuerBankCredit = new JTextField();
        lblBankAccCredit = new JLabel("Bank Account:");
        txtBankAccCredit = new JTextField();
        lblBalanceAmountCredit = new JLabel("Balance Amount:");
        txtBalanceAmountCredit = new JTextField();
        lblCVCnum = new JLabel("CVC Number:");
        txtCVCnum = new JTextField();
        lblInterestRate = new JLabel("Interest Rate:");
        txtInterestRate= new JTextField();
        lblExpirationDate = new JLabel("Expiration Date:");
        cmbDayCredit = new JComboBox(day);
        cmbMonthCredit = new JComboBox(month);
        cmbYearCredit = new JComboBox(year);
        btnAddCredit = new JButton("Add");
        btnGoToSetCredit = new JButton("Set Credit");
        btnGoToCancelCredit = new JButton("Cancel Credit");
        btnDisplayCredit = new JButton("Display");
        btnClrCredit = new JButton("Clear");
        btnGoBackCredit = new JButton("Go Back");
        
        btnAddCredit.setBackground(colorBtn);
        btnAddCredit.setForeground(Color.white);
        btnGoToSetCredit.setBackground(colorBtn);
        btnGoToSetCredit.setForeground(Color.white);
        btnGoToCancelCredit.setBackground(colorBtn);
        btnGoToCancelCredit.setForeground(Color.white);
        btnDisplayCredit.setBackground(colorBtn);
        btnDisplayCredit.setForeground(Color.white);
        btnClrCredit.setBackground(colorBtn);
        btnClrCredit.setForeground(Color.white);
        btnGoBackCredit.setBackground(colorBtnGoBack);
        btnGoBackCredit.setForeground(Color.white);
        
        lblCreditCard.setFont(newFont);
        lblCardIDCredit.setFont(newFont);
        txtCardIDCredit.setFont(newFont);
        lblClientNameCredit.setFont(newFont);
        txtClientNameCredit.setFont(newFont);
        lblIssuerBankCredit.setFont(newFont);
        txtIssuerBankCredit.setFont(newFont);
        lblBankAccCredit.setFont(newFont);
        txtBankAccCredit.setFont(newFont);
        lblBalanceAmountCredit.setFont(newFont);
        txtBalanceAmountCredit.setFont(newFont);
        lblCVCnum.setFont(newFont);
        txtCVCnum.setFont(newFont);
        lblInterestRate.setFont(newFont);
        txtInterestRate.setFont(newFont);
        lblExpirationDate.setFont(newFont);
        cmbDayCredit.setFont(newFont);
        cmbMonthCredit.setFont(newFont);
        cmbYearCredit.setFont(newFont);
        btnAddCredit.setFont(newFont);
        btnGoToSetCredit.setFont(newFont);
        btnGoToCancelCredit.setFont(newFont);
        btnDisplayCredit.setFont(newFont);
        btnClrCredit.setFont(newFont);
        btnGoBackCredit.setFont(newFont);
        
        lblCreditCard.setBounds(247,36,200,22);
        lblCardIDCredit.setBounds(83,108,72,22); 
        txtCardIDCredit.setBounds(83,140,159,22);
        lblClientNameCredit.setBounds(467,108,120,22);
        txtClientNameCredit.setBounds(467,140,159,22);
        lblIssuerBankCredit.setBounds(83,189,89,22);
        txtIssuerBankCredit.setBounds(83,221,159,22);
        lblBankAccCredit.setBounds(467,189,102,22);
        txtBankAccCredit.setBounds(467,221,159,22);
        lblBalanceAmountCredit.setBounds(83,270,141,22);
        txtBalanceAmountCredit.setBounds(83,302,159,22);
        lblCVCnum.setBounds(83,351,97,22);
        txtCVCnum.setBounds(83,383,159,22);
        lblInterestRate.setBounds(466,270,130,22);
        txtInterestRate.setBounds(466,302,159,22);
        lblExpirationDate.setBounds(83,439,130,22);
        cmbDayCredit.setBounds(243,436,74,23);
        cmbMonthCredit.setBounds(333,436,105,23);
        cmbYearCredit.setBounds(454,436,79,23);
        btnAddCredit.setBounds(507,492,118,29);
        btnGoToSetCredit.setBounds(83,541,118,29);
        btnGoToCancelCredit.setBounds(296,541,150,29);
        btnDisplayCredit.setBounds(83,590,118,29);
        btnClrCredit.setBounds(296,590,118,29);
        btnGoBackCredit.setBounds(509,590,118,29);

        pnlCredit.add(lblCreditCard);
        pnlCredit.add(lblCardIDCredit);
        pnlCredit.add(txtCardIDCredit);
        pnlCredit.add(lblClientNameCredit);
        pnlCredit.add(txtClientNameCredit);
        pnlCredit.add(lblIssuerBankCredit);
        pnlCredit.add(txtIssuerBankCredit);
        pnlCredit.add(lblBankAccCredit);
        pnlCredit.add(txtBankAccCredit);
        pnlCredit.add(lblBalanceAmountCredit);
        pnlCredit.add(txtBalanceAmountCredit);
        pnlCredit.add(lblCVCnum);
        pnlCredit.add(txtCVCnum);
        pnlCredit.add(lblInterestRate);
        pnlCredit.add(txtInterestRate);
        pnlCredit.add(lblExpirationDate);
        pnlCredit.add(cmbDayCredit);
        pnlCredit.add(cmbMonthCredit);
        pnlCredit.add(cmbYearCredit);
        pnlCredit.add(btnAddCredit);
        pnlCredit.add(btnGoToSetCredit);
        pnlCredit.add(btnGoToCancelCredit);
        pnlCredit.add(btnDisplayCredit);
        pnlCredit.add(btnClrCredit);
        pnlCredit.add(btnGoBackCredit);

        btnAddCredit.addActionListener(this);
        btnGoToSetCredit.addActionListener(this);
        btnGoToCancelCredit.addActionListener(this);
        btnDisplayCredit.addActionListener(this);
        btnClrCredit.addActionListener(this);
        btnGoBackCredit.addActionListener(this);

        frameCredit.setResizable(false);
        frameCredit.setSize(720,690);
        frameCredit.setDefaultCloseOperation(frameCredit.EXIT_ON_CLOSE);
        frameCredit.setLocationRelativeTo(null);
        
        /** set credit limit frame **/
        
        frameSetCredit = new JFrame("Set Credit Limit");
        pnlSetCredit = new JPanel();
        pnlSetCredit.setLayout(null);
        pnlSetCredit.setBackground(colorBg);
        frameSetCredit.add(pnlSetCredit);
        
        lblSetCredit = new JLabel("SET CREDIT LIMIT");
        lblIdChkSetCredit = new JLabel("Card ID:");
        txtIdChkSetCredit = new JTextField();
        lblCreditLimit = new JLabel("Credit Limit:");
        txtCreditLimit = new JTextField();
        lblGracePeriod = new JLabel("Grace Period:");
        txtGracePeriod = new JTextField();
        btnDetSetCredit = new JButton("Get Details");
        btnSetCreditLimit = new JButton("Set Credit Limit");
        btnDisplaySetCredit = new JButton("Display");
        btnClrSetCredit = new JButton("Clear");
        btnGoBackSetCredit = new JButton("Go Back");
        
        btnDetSetCredit.setBackground(colorBtn);
        btnDetSetCredit.setForeground(Color.white);
        btnSetCreditLimit.setBackground(colorBtn);
        btnSetCreditLimit.setForeground(Color.white);
        btnDisplaySetCredit.setBackground(colorBtn);
        btnDisplaySetCredit.setForeground(Color.white);
        btnClrSetCredit.setBackground(colorBtn);
        btnClrSetCredit.setForeground(Color.white);
        btnGoBackSetCredit.setBackground(colorBtnGoBack);
        btnGoBackSetCredit.setForeground(Color.white);
        
        lblSetCredit.setFont(newFont);
        lblIdChkSetCredit.setFont(newFont);
        txtIdChkSetCredit.setFont(newFont);
        lblCreditLimit.setFont(newFont);
        txtCreditLimit.setFont(newFont);
        lblGracePeriod.setFont(newFont);
        txtGracePeriod.setFont(newFont);
        btnDetSetCredit.setFont(newFont);
        btnSetCreditLimit.setFont(newFont);
        btnDisplaySetCredit.setFont(newFont);
        btnClrSetCredit.setFont(newFont);
        btnGoBackSetCredit.setFont(newFont);
        
        lblSetCredit.setBounds(228,36,140,22);
        lblIdChkSetCredit.setBounds(68,84,72,22);
        txtIdChkSetCredit.setBounds(68,116,159,22);
        lblCreditLimit.setBounds(68,204,109,22);
        txtCreditLimit.setBounds(68,236,159,22);
        lblGracePeriod.setBounds(68,285,118,22);
        txtGracePeriod.setBounds(68,317,159,22);
        btnDetSetCredit.setBounds(68,152,114,29);
        btnSetCreditLimit.setBounds(68,369,147,29);
        btnDisplaySetCredit.setBounds(68,439,118,29);
        btnClrSetCredit.setBounds(246,439,118,29);
        btnGoBackSetCredit.setBounds(410,439,118,29);
        
        pnlSetCredit.add(lblSetCredit);
        pnlSetCredit.add(lblIdChkSetCredit);
        pnlSetCredit.add(txtIdChkSetCredit);
        pnlSetCredit.add(lblCreditLimit);
        pnlSetCredit.add(txtCreditLimit);
        pnlSetCredit.add(lblGracePeriod);
        pnlSetCredit.add(txtGracePeriod);
        pnlSetCredit.add(btnDetSetCredit);
        pnlSetCredit.add(btnSetCreditLimit);
        pnlSetCredit.add(btnDisplaySetCredit);
        pnlSetCredit.add(btnClrSetCredit);
        pnlSetCredit.add(btnGoBackSetCredit);
        
        btnDetSetCredit.addActionListener(this);
        btnSetCreditLimit.addActionListener(this);
        btnDisplaySetCredit.addActionListener(this);
        btnClrSetCredit.addActionListener(this);
        btnGoBackSetCredit.addActionListener(this);
        
        frameSetCredit.setResizable(false);
        frameSetCredit.setSize(605,540);
        frameSetCredit.setDefaultCloseOperation(frameCredit.EXIT_ON_CLOSE);
        frameSetCredit.setLocationRelativeTo(null);
        
        /** cancel credit card frame **/
        
        frameCancelCredit = new JFrame("Cancel Credit Card");
        pnlCancelCredit = new JPanel();
        pnlCancelCredit.setLayout(null);
        pnlCancelCredit.setBackground(colorBg);
        frameCancelCredit.add(pnlCancelCredit);
        
        lblCancelCredit = new JLabel("CANCEL CREDIT CARD");
        lblIdChkCancelCredit = new JLabel("Card ID:");
        txtIdChkCancelCredit = new JTextField();
        btnDetCancelCredit = new JButton("Get Details");
        btnCancelCredit = new JButton("Cancel Credit");
        btnDisplayCancelCredit = new JButton("Display");
        btnClrCancelCredit = new JButton("Clear");
        btnGoBackCancelCredit = new JButton("Go Back");
        
        btnDetCancelCredit.setBackground(colorBtn);
        btnDetCancelCredit.setForeground(Color.white);
        btnCancelCredit.setBackground(colorBtn);
        btnCancelCredit.setForeground(Color.white);
        btnDisplayCancelCredit.setBackground(colorBtn);
        btnDisplayCancelCredit.setForeground(Color.white);
        btnClrCancelCredit.setBackground(colorBtn);
        btnClrCancelCredit.setForeground(Color.white);
        btnGoBackCancelCredit.setBackground(colorBtnGoBack);
        btnGoBackCancelCredit.setForeground(Color.white);
        
        lblCancelCredit.setFont(newFont);
        lblIdChkCancelCredit.setFont(newFont);
        txtIdChkCancelCredit.setFont(newFont);
        btnDetCancelCredit.setFont(newFont);
        btnCancelCredit.setFont(newFont);
        btnDisplayCancelCredit.setFont(newFont);
        btnClrCancelCredit.setFont(newFont);
        btnGoBackCancelCredit.setFont(newFont);
        
        lblCancelCredit.setBounds(216,36,178,22);
        lblIdChkCancelCredit.setBounds(65,108,72,22);
        txtIdChkCancelCredit.setBounds(65,140,159,22);
        btnDetCancelCredit.setBounds(65,185,114,29);
        btnCancelCredit.setBounds(65,243,143,29);
        btnDisplayCancelCredit.setBounds(65,313,118,29);
        btnClrCancelCredit.setBounds(243,313,118,29);
        btnGoBackCancelCredit.setBounds(407,313,143,29);
        
        pnlCancelCredit.add(lblCancelCredit);
        pnlCancelCredit.add(lblIdChkCancelCredit);
        pnlCancelCredit.add(txtIdChkCancelCredit);
        pnlCancelCredit.add(btnDetCancelCredit);
        pnlCancelCredit.add(btnCancelCredit);
        pnlCancelCredit.add(btnDisplayCancelCredit);
        pnlCancelCredit.add(btnClrCancelCredit);
        pnlCancelCredit.add(btnGoBackCancelCredit);
        
        btnDetCancelCredit.addActionListener(this);
        btnCancelCredit.addActionListener(this);
        btnDisplayCancelCredit.addActionListener(this);
        btnClrCancelCredit.addActionListener(this);
        btnGoBackCancelCredit.addActionListener(this);
        
        frameCancelCredit.setResizable(false);
        frameCancelCredit.setSize(600,420);
        frameCancelCredit.setDefaultCloseOperation(frameCredit.EXIT_ON_CLOSE);
        frameCancelCredit.setLocationRelativeTo(null);
    }
    
    public static void main (String[]args)
    {
        new BankGUI();
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == btnDebitCard) {
            mainFrame.setVisible(false);
            frameDebit.setVisible(true);
        }
        else if(event.getSource() == btnCreditCard) {
            mainFrame.setVisible(false);
            frameCredit.setVisible(true);
        }
        else if(event.getSource() == btnAddDebit) {
            this.addDebit();
        }
        else if(event.getSource() == btnGoToWithdraw) {
            frameDebit.setVisible(false);
            frameWithdraw.setVisible(true);
        }
        else if(event.getSource() == btnDisplayDebit || event.getSource() == btnDisplayWithdraw) {
            this.displayDebit();
        }
        else if(event.getSource() == btnClrDebit) {
            this.clrDebitAdd();
        }
        else if(event.getSource() == btnGoBackDebit || event.getSource() == btnGoBackCredit) {
            frameDebit.setVisible(false);
            frameCredit.setVisible(false);
            mainFrame.setVisible(true);
        }
        else if(event.getSource() == btnDetWithdraw) {
            this.detWithdraw();
        }
        else if(event.getSource() == btnWithdraw) {
            this.withdraw();
        }
        else if(event.getSource() == btnClrWithdraw) {
            this.clrDebitWithdraw();
        }
        else if(event.getSource() == btnGoBackWithdraw) {
            frameWithdraw.setVisible(false);
            frameDebit.setVisible(true);
        }
        else if(event.getSource() == btnAddCredit) {
            this.addCredit();
        }
        else if(event.getSource() == btnGoToSetCredit) {
            frameCredit.setVisible(false);
            frameSetCredit.setVisible(true);
        }
        else if(event.getSource() == btnGoToCancelCredit) {
            frameCredit.setVisible(false);
            frameCancelCredit.setVisible(true);
        }
        else if(event.getSource() == btnDisplayCredit || event.getSource() == btnDisplaySetCredit || event.getSource() == btnDisplayCancelCredit) {
            this.displayCredit();
        }
        else if(event.getSource() == btnClrCredit) {
            this.clrCreditAdd();
        }
        else if(event.getSource() == btnDetSetCredit) {
            this.detSetCredit();
        }
        else if(event.getSource() == btnSetCreditLimit) {
            this.setCredit();
        }
        else if(event.getSource() == btnClrSetCredit) {
            this.clrCreditSet();
        }
        else if(event.getSource() == btnGoBackSetCredit) {
            frameSetCredit.setVisible(false);
            frameCredit.setVisible(true);
        }
        else if(event.getSource() == btnDetCancelCredit) {
            this.detCancelCredit();
        }
        else if(event.getSource() == btnCancelCredit) {
            this.cancelCredit();
        }
        else if(event.getSource() == btnClrCancelCredit) {
            this.clrCreditCancel();
        }
        else if(event.getSource() == btnGoBackCancelCredit) {
            frameCancelCredit.setVisible(false);
            frameCredit.setVisible(true);
        }
    }
    
    /** Debit Card Methods **/
    /**
     * Checks if card ID exists in Debit objects
     * 
     * @param cardID
     * @return chk
     */
    public boolean flagDebitID(int cardID) 
    {
        boolean chk = true;
        for(BankCard bank:alBankCard)
            if(bank instanceof DebitCard) {
                if (cardID ==  bank.getCardID()) {
                    chk = false;
                    break;
                }
            }
        return chk;
    }
    
    /** Adds Debit Card objects **/
    public void addDebit()
    {
        try{
            int cardID = Integer.parseInt(txtCardIDDebit.getText());
            String clientName = txtClientNameDebit.getText();
            String issuerBank = txtIssuerBankDebit.getText();
            String bankAccount = txtBankAccDebit.getText();
            int balanceAmount = Integer.parseInt(txtBalanceAmountDebit.getText());
            int pinNumber = Integer.parseInt(pwfPIN.getText());
        
            if (this.flagDebitID(cardID) == true) {
                JOptionPane.showMessageDialog(frameDebit,"Card ID: " + cardID + "\n" + "Client Name: " +
                clientName + "\n" + "Issuer Bank: " + issuerBank + "\n" + "Bank Account: " + bankAccount +
                "\n" + "Balance Amount: " + balanceAmount + "\n" + "PIN Number: " + pinNumber,
                "Add Debit Details", JOptionPane.INFORMATION_MESSAGE);
                objDebit = new DebitCard(balanceAmount,cardID,bankAccount,
                issuerBank,clientName,pinNumber);

                alBankCard.add(objDebit);

                JOptionPane.showMessageDialog(frameDebit,"Debit Details Added","Add Debit",
                JOptionPane.INFORMATION_MESSAGE);
                this.clrDebitAdd();
            }
            else {
                JOptionPane.showMessageDialog(frameDebit,"Card ID already exists.",
                "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(frameDebit,"Enter valid input.",
                "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    /** Displays input card ID's details during withdrawal **/
    public void detWithdraw() 
    {
        try {
            int cardID = Integer.parseInt(txtIdChkWithdraw.getText()); 
            if (this.flagDebitID(cardID) == false) {
                for(BankCard bank:alBankCard)
                    if(bank instanceof DebitCard) {
                        objDebit = (DebitCard)bank;
                        if (cardID == bank.getCardID()) {
                            JOptionPane.showMessageDialog(frameDebit,"Card ID: " + bank.getCardID() + "\n" + "Client Name: " + 
                            bank.getClientName() + "\n" + "Issuer Bank: " + bank.getIssuerBank() + "\n" + "Bank Account: " + 
                            bank.getBankAccount() + "\n" +"Balance Amount: Rs " + bank.getBalanceAmount() + "\n" + "PIN Number: " + 
                            objDebit.getPinNumber() + "\n" + "Withdrawal Amount: Rs " + objDebit.getWithdrawalAmount()
                            + "\n" + "Withdrawal Date: " + objDebit.getDateOfWithdrawal());
                        }
                    }
            }
            else {
                JOptionPane.showMessageDialog(frameDebit,"Card ID does not exist.", 
                "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(frameDebit,"Enter valid input.",
            "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /** Withdraws from Debit Card **/
    public void withdraw()
    {
        try {
            int cardID = Integer.parseInt(txtIdChkWithdraw.getText());
            int withdrawalAmount = Integer.parseInt(txtWithdrawalAmount.getText());
            String dayWithdraw = String.valueOf(cmbDayDebit.getSelectedItem());
            String monthWithdraw = String.valueOf(cmbMonthDebit.getSelectedItem());
            String yearWithdraw = String.valueOf(cmbYearDebit.getSelectedItem());
            String dateOfWithdrawal = dayWithdraw + " " + monthWithdraw + " " + yearWithdraw;
            int pinNumber = Integer.parseInt(pwfPINCheck.getText());
            
            if(this.flagDebitID(cardID) == false) {
                for(BankCard bank:alBankCard)
                    if(bank instanceof DebitCard) {
                        objDebit = (DebitCard)bank;
                        if (cardID == bank.getCardID()) {
                            if(pinNumber == objDebit.getPinNumber()) {
                                if(withdrawalAmount < bank.getBalanceAmount()) {
                                    JOptionPane.showMessageDialog(frameDebit,"Card ID: " + cardID + "\n" + "PIN Number: " +
                                    pinNumber + "\n" + "Withdrawal Amount: " + withdrawalAmount + "\n" + "Withdrawal Date: " + 
                                    dateOfWithdrawal,"Withdraw Details",JOptionPane.INFORMATION_MESSAGE);
                                    System.out.println(border);
                                    System.out.println("\t" + "  CASH RECEIPT");
                                    System.out.println(border);
                                    objDebit.withdraw(withdrawalAmount,dateOfWithdrawal,pinNumber);
                                    System.out.println(border);
                                    System.out.println("Thank you " + bank.getClientName() + " for using our service.");
                                    JOptionPane.showMessageDialog(frameDebit,"Money withdrawn.",
                                    "Withdraw",JOptionPane.INFORMATION_MESSAGE);
                                    this.clrDebitWithdraw();
                                }
                                else {
                                    JOptionPane.showMessageDialog(frameDebit,"Insufficient Balance.\n" + "Balance Amount: " + 
                                    bank.getBalanceAmount(), "Error",JOptionPane.ERROR_MESSAGE);
                                    txtWithdrawalAmount.setText("");
                                }
                            }
                            else if(pinNumber != objDebit.getPinNumber()){
                                JOptionPane.showMessageDialog(frameDebit,"Incorrect PIN.",
                                "Error",JOptionPane.ERROR_MESSAGE);
                                pwfPINCheck.setText("");
                            }
                        }
                    }
                }
            else {
                JOptionPane.showMessageDialog(frameDebit,"Card ID does not exist.", 
                "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(frameDebit,"Enter valid input.",
            "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    /** Displays debit details **/
    public void displayDebit()
    {
        System.out.println(border);
        System.out.println("\t" + "  DEBIT DETAILS");
        System.out.println(border);
        for(BankCard bank:alBankCard)
            if(bank instanceof DebitCard) {
                objDebit = (DebitCard)bank;
                System.out.println("Card ID: " + bank.getCardID() + "\n" + "Client Name: " + bank.getClientName() + "\n" + 
                "Issuer Bank: " + bank.getIssuerBank() + "\n" + "Bank Account: " + bank.getBankAccount() + "\n" +
                "Balance Amount: Rs " + bank.getBalanceAmount() + "\n" + "PIN Number: " + objDebit.getPinNumber() + "\n" + 
                "Withdrawal Amount: Rs " + objDebit.getWithdrawalAmount() + "\n" + 
                "Date of Withdrawal: " + objDebit.getDateOfWithdrawal());
                System.out.println(border);
            }
    }
    
    /** Clears text fields **/
    public void clrDebitAdd()
    {
        txtCardIDDebit.setText("");
        txtClientNameDebit.setText("");
        txtIssuerBankDebit.setText("");
        txtBankAccDebit.setText("");
        txtBalanceAmountDebit.setText("");
        pwfPIN.setText("");
    }

    /** Clears text fields **/
    public void clrDebitWithdraw()
    {
        txtIdChkWithdraw.setText("");
        txtWithdrawalAmount.setText("");
        pwfPINCheck.setText("");
    }
    
    /** Credit Card Methods **/
    /**
     * Checks if card ID exists in Credit objects
     * 
     * @param cardID
     * @return chk
     */
    public boolean flagCreditID(int cardID) {
        boolean chk = true;
        for(BankCard bank:alBankCard)
            if(bank instanceof CreditCard) {
                if (cardID ==  bank.getCardID()) {
                    chk = false;
                    break;
                }
            }
        return chk;
    }
    
    /** Adds Credit Card objects **/
    public void addCredit()
    {
        try{
            int cardID = Integer.parseInt(txtCardIDCredit.getText());
            String clientName = txtClientNameCredit.getText();
            String issuerBank = txtIssuerBankCredit.getText();
            String bankAccount= txtBankAccCredit.getText();
            int balanceAmount = Integer.parseInt(txtBalanceAmountCredit.getText());
            int cvcNumber = Integer.parseInt(txtCVCnum.getText());
            double interestRate = Double.parseDouble(txtInterestRate.getText());
            String dayExpiration = String.valueOf(cmbDayCredit.getSelectedItem());
            String monthExpiration = String.valueOf(cmbMonthCredit.getSelectedItem());
            String yearExpiration = String.valueOf(cmbYearCredit.getSelectedItem());
            String expirationDate = dayExpiration + " " + monthExpiration + " " + yearExpiration;
            
            if (this.flagCreditID(cardID) == true) {
                JOptionPane.showMessageDialog(frameCredit,"Card ID: " + cardID + "\n" + "Client Name: " +
                clientName + "\n" + "Issuer Bank: " + issuerBank + "\n" + "Bank Account: " + bankAccount +
                "\n" + "Balance Amount: " + balanceAmount + "\n" + "CVC Number: " + cvcNumber + "\n" + 
                "Interest Rate: " + interestRate + "\n" + "Expiration Date: " + expirationDate,
                "Add Credit Details", JOptionPane.INFORMATION_MESSAGE);
                objCredit = new CreditCard(cardID,clientName,
                issuerBank,bankAccount,balanceAmount,cvcNumber,interestRate,expirationDate);

                alBankCard.add(objCredit);

                JOptionPane.showMessageDialog(frameCredit,"Credit Details Added.","Add Credit",
                JOptionPane.INFORMATION_MESSAGE);
                this.clrCreditAdd();
            }
            else {
                JOptionPane.showMessageDialog(frameCredit,"Card ID already exists.",
                "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(frameCredit,"Enter valid input.",
                "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /** Displays input card ID's details while setting credit limit **/
    public void detSetCredit()
    {
        try {
            int cardID = Integer.parseInt(txtIdChkSetCredit.getText()); 
            if (this.flagCreditID(cardID) == false) {
                for(BankCard bank:alBankCard)
                    if(bank instanceof CreditCard) {
                        objCredit = (CreditCard)bank;
                        if (cardID == bank.getCardID()) {
                            JOptionPane.showMessageDialog(frameCredit,"Card ID: " + bank.getCardID() + "\n" + "Client Name: " + 
                            bank.getClientName() + "\n" + "Issuer Bank: " + bank.getIssuerBank() + "\n" + "Bank Account: " + 
                            bank.getBankAccount() + "\n" +"Balance Amount: Rs " + bank.getBalanceAmount() + "\n" + "CVC Number: " + 
                            objCredit.getCvcNumber()+ "\n" + "Interest Rate: " + objCredit.getInterestRate() + "\n" + 
                            "Expiration Date: " + objCredit.getExpirationDate() + "\n" + "Credit Limit: Rs " + 
                            objCredit.getCreditLimit() + "\n" + "Grace Period: " + objCredit.getGracePeriod() + 
                            " days");
                        }
                    }
            }
            else {
                JOptionPane.showMessageDialog(frameCredit,"Card ID does not exist.", 
                "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(frameCredit,"Enter valid input.",
            "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /** Sets the credit limit **/
    public void setCredit()
    {
        try {
            int cardID = Integer.parseInt(txtIdChkSetCredit.getText());
            double creditLimit = Double.parseDouble(txtCreditLimit.getText());
            int gracePeriod = Integer.parseInt(txtGracePeriod.getText());
            
            if(this.flagCreditID(cardID) == false) {
                for(BankCard bank:alBankCard)
                if(bank instanceof CreditCard) {
                    objCredit = (CreditCard)bank;
                    if (cardID == bank.getCardID()) {
                        if (creditLimit <= 2.5 * bank.getBalanceAmount()) {
                            JOptionPane.showMessageDialog(frameCredit,"Card ID: " + cardID + "\n" + "Credit Limit: " +
                                creditLimit + "\n" + "Grace Period: " + gracePeriod,"Set Credit Limit Details",
                                JOptionPane.INFORMATION_MESSAGE);
                            objCredit.setCreditLimit(creditLimit,gracePeriod);
                            JOptionPane.showMessageDialog(frameCredit,"Credit Limit has been set.",
                            "Set Credit Limit",JOptionPane.INFORMATION_MESSAGE);
                            this.clrCreditSet();
                        }
                        else {
                            JOptionPane.showMessageDialog(frameCredit,"Credit cannot be granted.",
                            "Error",JOptionPane.ERROR_MESSAGE);
                            txtCreditLimit.setText("");
                        }
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(frameCredit,"Card ID does not exist.",
                "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(frameCredit,"Enter valid input.",
            "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /** Displays credit details **/
    public void displayCredit()
    {
        System.out.println(border);
        System.out.println("\t" + "  CREDIT DETAILS");
        System.out.println(border);
        for(BankCard bank:alBankCard)
            if(bank instanceof CreditCard) {
                objCredit = (CreditCard)bank;
                System.out.println("Card ID: " + bank.getCardID() + "\n" + "Client Name: " + bank.getClientName() + "\n" + 
                "Issuer Bank: " + bank.getIssuerBank() + "\n" + "Bank Account: " + bank.getBankAccount() + "\n" + 
                "Balance Amount: Rs " + bank.getBalanceAmount() + "\n" + "CVC Number: " + objCredit.getCvcNumber() + "\n" +
                "Interest Rate: " + objCredit.getInterestRate() +"%" + "\n" + "Expiration Date: " + 
                objCredit.getExpirationDate() + "\n" + "Credit Limit: Rs " + objCredit.getCreditLimit() + "\n" + 
                "Grace Period: " + objCredit.getGracePeriod() + " days");
                System.out.println(border);
            }
    }
    
    /** Clears text fields **/
    public void clrCreditAdd()
    {
        txtCardIDCredit.setText("");
        txtClientNameCredit.setText("");
        txtIssuerBankCredit.setText("");
        txtBankAccCredit.setText("");
        txtBalanceAmountCredit.setText("");
        txtCVCnum.setText("");
        txtInterestRate.setText("");
    }
    
    /** Clears text fields **/
    public void clrCreditSet()
    {
        txtIdChkSetCredit.setText("");
        txtCreditLimit.setText("");
        txtGracePeriod.setText("");
    }
    
    /** Displays input card ID's details while removing credit card **/
    public void detCancelCredit() {
        try {
            int cardID = Integer.parseInt(txtIdChkCancelCredit.getText());
            if (this.flagCreditID(cardID) == false) {
                for(BankCard bank:alBankCard)
                    if(bank instanceof CreditCard) {
                        objCredit = (CreditCard)bank;
                        if (cardID == bank.getCardID()) {
                            JOptionPane.showMessageDialog(frameCredit,"Card ID: " + bank.getCardID() + "\n" + "Client Name: " + 
                            bank.getClientName() + "\n" + "Issuer Bank: " + bank.getIssuerBank() + "\n" + "Bank Account: " + 
                            bank.getBankAccount() + "\n" +"Balance Amount: Rs " + bank.getBalanceAmount() + "\n" + "CVC Number: " + 
                            objCredit.getCvcNumber()+ "\n" + "Interest Rate: " + objCredit.getInterestRate() + 
                            "\n" + "Expiration Date: " + objCredit.getExpirationDate() + "\n" + "Credit Limit: " + 
                            objCredit.getCreditLimit() + "\n" + "Grace Period: " + objCredit.getGracePeriod());
                        }
                    }
            }
            else {
                JOptionPane.showMessageDialog(frameCredit,"Card ID does not exist.", 
                "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(frameCredit,"Enter valid input.",
            "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /** Cancels credit card **/
    public void cancelCredit()
    {
        try {
            int cardID = Integer.parseInt(txtIdChkCancelCredit.getText());
            if(this.flagCreditID(cardID) == false) {
                for(BankCard bank:alBankCard)
                if(bank instanceof CreditCard) {
                    objCredit = (CreditCard)bank;
                    if(cardID == bank.getCardID()) {
                        objCredit.cancelCreditCard();
                        JOptionPane.showMessageDialog(frameCredit,"Credit Card has been cancelled successfully.",
                        "Cancel Credit",JOptionPane.INFORMATION_MESSAGE);
                        this.clrCreditCancel();
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(frameCredit,"Card ID does not exist.",
                "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (NumberFormatException event) {
            JOptionPane.showMessageDialog(frameCredit,"Enter valid input.",
            "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /** Clears text fields **/
    public void clrCreditCancel() 
    {
        txtIdChkCancelCredit.setText("");
    }
}