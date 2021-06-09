package src;

public class User {
    protected String userId;
    protected String name;
    protected int age;
    protected String email;
    protected String password;
    protected eWallet wallet;

    /**
     * default ctor
     */
    User(){
        userId = RandomStrGen.gen();
        name = "";
        age = 0;
        email = "";
        password = "";
        wallet = null;
    }

    /**
     * parameterized ctor
     * @param name
     * @param age
     * @param email
     * @param password
     * @param wallet
     */
    User(String name, int age, String email, String password, eWallet wallet) {
        this.userId = RandomStrGen.gen();
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.wallet = wallet;
    }

    /**
     * returns a info string of current object
     */
    public String getInfo() {
        String returnVal = 
            "Name: " + name + "\n" +
            "Age: " + age + "\n" +
            "Email: " + email + "\n" +
            //"password: " + password + "\n"+ 
            "-----Wallet info-----\n" + wallet.getInfo();
        
        return returnVal;
    }

    /**
     * gets name
     * @return user's name
     */
    public String getName() { return name; }
    /**
     * gets email
     * @return user's email
     */
    public String getEmail() { return email; }
    /**
     * gets age
     * @return user's age
     */
    public int getAge() { return age; }
    /**
     * gets wallet
     * @return user's wallet
     */
    public eWallet getWallet() { return wallet; }

    /**
     * sets user's name
     * @param name the new user name
     */
    public void setName(String name) { this.name = name; }
    /**
     * sets user's email
     * @param email the new user email
     */
    public void setEmail(String email) { this.email = email; }
    /**
     * sets age
     * @param age the new user Age
     */
    public void setAge(int age) { this.age = age; }
    /**
     * sets wallet
     * @param wallet the new user wallet
     */
    public void setWallet(eWallet wallet) { this.wallet = wallet; }

    public String getPass(){ return password; }
}