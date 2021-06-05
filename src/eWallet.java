package src;

public class eWallet {
    protected String eWalletID;
    protected User user;
    protected float currentBal;

    /**
     * Default Constructor
     */
    eWallet(){
        user = null;
        eWalletID = RandomStrGen.gen();
        currentBal = 1000;
    }

    /**
     * Parametrized Constructor
     * @param User user to be set as eWallet's user
     */
    eWallet(User user){
        this.user = user;
        eWalletID = RandomStrGen.gen();
        currentBal = 1000;
    }

    /**
     * @param String eWalletID to be set as User's eWalletID
     */
    public void seteWalletID(String eWalletID) {
        this.eWalletID = eWalletID;
    }

    /**
     * @return String eWalletID
     */
    public String geteWalletID() {
        return eWalletID;
    }

    /**
     * @param User user to be set as eWallet's user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return User user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param float currentBal to be set as eWallet's currentBal
     */
    public void setCurrentBal(float currentBal) {
        this.currentBal = currentBal;
    }

    /**
     * @return float currentBal
     */
    public float getCurrentBal() {
        return currentBal;
    }

    /**
     * @return String returnVal which is eWallet's info
     */
    public String getInfo(){
        String returnVal
                = "eWallet ID: " + eWalletID + "\n"
                + "Current Balance" + currentBal + "\n";
        return returnVal;
    }

    /**
     * @param int amount which is payment amount
     * @param eWallet wallet which is playground owner's eWalletID
     */
    public void payReservation(int amount, eWallet wallet){
        this.currentBal -= amount;
        wallet.currentBal += amount;
    }
}

