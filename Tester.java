
/**
 * Tester Class for Accounts()
 * 
 * @author Drew Howell
 * @version 1.0.0
 */
public class Tester
{
    public static void main(String args[])
    {
        Account myGuy = new Account("Joe", "testguy123@email.com", "Password", "");
        myGuy.addFriend(new Account("Sammy", "sammy123@email.com", "password123", ""));
        
    }
}
