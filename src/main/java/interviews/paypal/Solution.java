package interviews.paypal;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*
 * Create TransactionException, DigitalWallet, and DigitalWalletTransaction classes here.
 */
class TransactionException extends Exception
{
    private static final long serialVersionUID = 123L;
    private String errorCode;
    private String errorMessage;

    public TransactionException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return errorMessage;
    }
}
class DigitalWallet
{
    String walletId, username, userAccessCode;
    int walletBalance;

    public DigitalWallet(String walletId, String username, String userAccessCode) {
        this.walletId = walletId;
        this.username = username;
        this.userAccessCode = userAccessCode;
    }

    public DigitalWallet(String walletId, String userName) {
        this.walletId = walletId;
        this.username = userName;
        this.userAccessCode = "";
    }

    public String getWalletId()
    {
        return walletId;
    }

    public String getUsername() {
        return username;
    }

    public String getUserAccessCode() {
        return userAccessCode;
    }

    public int getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(int walletBalance) {
        this.walletBalance = walletBalance;
    }

}

class DigitalWalletTransaction
{
    void addMoney(DigitalWallet wallet, int amount) throws TransactionException {

        if(wallet.getUserAccessCode().isEmpty())
        {
            throw new TransactionException("USER_NOT_AUTHORIZED","User not authorized");
        }
        if (amount <= 0) {
            throw new TransactionException("INVALID_AMOUNT","Amount should be greater than zero");
        } else {
            wallet.setWalletBalance(wallet.getWalletBalance() + amount);
        }
    }
    void payMoney(DigitalWallet wallet, int amount) throws TransactionException
    {
        if(wallet.getUserAccessCode().isEmpty())
        {
            throw new TransactionException("USER_NOT_AUTHORIZED","User not authorized");
        }
        if( amount > wallet.getWalletBalance() )
        {
            throw new TransactionException("INSUFFICIENT_BALANCE","Insufficient balance");
        }
        else
        {
            wallet.setWalletBalance(wallet.getWalletBalance() - amount);
        }
    }


}
public class Solution {
    private static final Scanner INPUT_READER = new Scanner(System.in);
    private static final DigitalWalletTransaction DIGITAL_WALLET_TRANSACTION = new DigitalWalletTransaction();

    private static final Map<String, DigitalWallet> DIGITAL_WALLETS = new HashMap<>();

    public static void main(String[] args) {
        int numberOfWallets = Integer.parseInt(INPUT_READER.nextLine());
        while (numberOfWallets-- > 0) {
            String[] wallet = INPUT_READER.nextLine().split(" ");
            DigitalWallet digitalWallet;

            if (wallet.length == 2) {
                digitalWallet = new DigitalWallet(wallet[0], wallet[1]);
            } else {
                digitalWallet = new DigitalWallet(wallet[0], wallet[1], wallet[2]);
            }

            DIGITAL_WALLETS.put(wallet[0], digitalWallet);
        }

        int numberOfTransactions = Integer.parseInt(INPUT_READER.nextLine());
        while (numberOfTransactions-- > 0) {
            String[] transaction = INPUT_READER.nextLine().split(" ");
            DigitalWallet digitalWallet = DIGITAL_WALLETS.get(transaction[0]);

            if (transaction[1].equals("add")) {
                try {
                    DIGITAL_WALLET_TRANSACTION.addMoney(digitalWallet, Integer.parseInt(transaction[2]));
                    System.out.println("Wallet successfully credited.");
                } catch (TransactionException ex) {
                    System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                }
            } else {
                try {
                    DIGITAL_WALLET_TRANSACTION.payMoney(digitalWallet, Integer.parseInt(transaction[2]));
                    System.out.println("Wallet successfully debited.");
                } catch (TransactionException ex) {
                    System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                }
            }
        }

        System.out.println();

        DIGITAL_WALLETS.keySet()
                .stream()
                .sorted()
                .map((digitalWalletId) -> DIGITAL_WALLETS.get(digitalWalletId))
                .forEachOrdered((digitalWallet) -> {
                    System.out.println(digitalWallet.getWalletId()
                            + " " + digitalWallet.getUsername()
                            + " " + digitalWallet.getWalletBalance());
                });
    }
}