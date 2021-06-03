package src;

public class User {
    protected String userId;
    protected String name;
    protected int age;
    protected String email;
    protected String password;
    protected eWallet wallet;

    User(){
        userId = "";
        name = "";
        age = 0;
        email = "";
        password = "";
        wallet = null;
    }

    User(String name, int age, String email, String password, eWallet wallet) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.wallet = wallet;
    }

    public String getInfo() {
        String returnVal = 
            "Name: " + name + "\n" +
            "Age: " + age + "\n" +
            "Email: " + email + "\n" +
            "Wallet info--------------\n" + wallet.getInfo();
        
        return returnVal;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
    public eWallet getWallet() { return wallet; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setAge(int age) { this.age = age; }
    public void setWallet(eWallet wallet) { this.wallet = wallet; }
}