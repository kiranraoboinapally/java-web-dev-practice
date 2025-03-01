interface Bank {
    void deposit(int amount);
    void withdraw(int amount);
    void checkBalance();
    void loans();
    void insurance();
}

class sbi implements Bank
{
    int balance = 0;
    public void deposit(int amount)
    {
        balance += amount;
        System.out.println("Amount deposited: " + amount);
    }
    public void withdraw(int amount)
    {
        if(balance >= amount)
        {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        }
        else
        {
            System.out.println("Insufficient balance");
        }
    }
    public void checkBalance()
    {
        System.out.println("Balance: " + balance);
    }
    public void loans()
    {
        System.out.println("Loans available");
    }
    public void insurance()
    {
        System.out.println("Insurance available");
    }
}