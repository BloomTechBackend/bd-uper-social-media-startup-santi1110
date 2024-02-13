import java.util.Arrays;

public class SocialMediaApp {

    private Account[] accounts;

    /**
     * Build at least 3 accounts and load them into the accounts array.
     * Make up your own information about the accounts, but make each one unique.
     * Make sure each account also has some messages, and use some varying amounts of messages.
     */
    public void loadDemoAccounts() {
        // TODO: Finish this method.


        //Account account1 = new Account();
        LoginInfo loginInfo1 = new LoginInfo("sam234","!dfgdfg");
        Address address1= new Address("45 Main street","Amsterdam",StateEnum.Arkansas,"2343");
        AccountDetails accountDetails1 = new AccountDetails("Samantha",loginInfo1,address1);
        TimeStamp firstmessage1TimeStamp = new TimeStamp(MonthEnum.May, 14,12, 00);
        Message firstMessage1 = new Message(firstmessage1TimeStamp, "I wwent to play something");
        TimeStamp secondmessage1TimeStamp = new TimeStamp(MonthEnum.June, 1,12, 00);
        Message secondMessage1 = new Message(secondmessage1TimeStamp, "I have a birthdy");
        TimeStamp thirdmessage1TimeStamp = new TimeStamp(MonthEnum.June, 11,5, 00);
        Message thirdMessage1 = new Message(thirdmessage1TimeStamp, "I wwnt to swim");
        Message[] messages1 = {firstMessage1, secondMessage1, thirdMessage1};

//        LoginInfo loginInfo2 = new LoginInfo("sam234","!dfgdfg");
//        Address address2= new Address("4523 Main street","Amsterdam",StateEnum.Arkansas,"2343");
//        AccountDetails accountDetails2 = new AccountDetails("Samantha",loginInfo2,address2);
//        TimeStamp firstmessage2TimeStamp = new TimeStamp(MonthEnum.May, 14,12, 00);
//        Message firstMessage2 = new Message(firstmessage2TimeStamp, "I wwent to play something");
//        TimeStamp secondmessage2TimeStamp = new TimeStamp(MonthEnum.June, 1,12, 00);
//        Message secondMessage2 = new Message(firstmessage2TimeStamp, "I have a birthdy");
//        TimeStamp thirdtmessage2TimeStamp = new TimeStamp(MonthEnum.June, 11,5, 00);
//        Message thirdMessage2 = new Message(firstmessage2TimeStamp, "I wwnt to swim");
//        Message[] messages2 = {firstMessage2, secondMessage2, thirdMessage2};


        Account account1 = new Account(accountDetails1,messages1);

        accounts = new Account[]{account1,account1,account1};
    }

    /**
     * Simulates an account posting a new message.
     * The account should have an extra message when this method is over.
     * @param account the account which is posting a message
     * @param time the timestamp of when the message occurred
     * @param text the text of the message
     */
    public void postMessage(Account account, TimeStamp time, String text) {
        // TODO: Finish this method.


        Message message = new Message(time,text);
        account.addMessage(message);
    }

    /**
     * Print all the usernames. They should be alphabetized.
     * This should work with any number of accounts.
     */
    public void printUserNames() {
        System.out.println("Usernames:");
        // TODO: Finish this method.
        for (Account account:accounts){
            System.out.println(account.getDetails().getLoginInfo().getUsername());
        }


        String [] names = new String[accounts.length];
        for (int i = 0; i < names.length; i++){
            names[i] = accounts[i].getDetails().getLoginInfo().getUsername();
        }
      Arrays.sort(names);
//        for (String name :names){
//            System.out.println(name);
//        }
        System.out.println(Arrays.toString(names));
    }

    /**
     * Print the number of accounts in each state. Don't print states without accounts.
     * This method should work with any number of accounts.
     * Example result:
     * Alabama: 2
     * Arizona: 5
     * California: 17
     * ...
     */
    public void printStateCounts() {


        int [] tallies = new int[50];
        for (Account account:accounts){
            StateEnum accountState = account.getDetails().getAddress().getState();
            tallies[accountState.ordinal()]++;
            StateEnum [] statesNames = StateEnum.values();

        for (int i=0; i <tallies.length; i++){
            if(tallies[i]>0){
                System.out.println(statesNames[i] );
            }
        }
        }
        System.out.println("Accounts per State:");
        // TODO: Finish this method.
    }

    public static void main(String[] args) {
        SocialMediaApp app = new SocialMediaApp();

        app.loadDemoAccounts();

        System.out.println("Testing a Message Being Added");
        System.out.println("First Account Before Adding a new Message:");
        System.out.println(app.accounts[0]);
        System.out.println("First Account After Adding a new Message:");
        app.postMessage(app.accounts[0], new TimeStamp(MonthEnum.March, 30, 10, 05), "Going through a guided lecture");
        System.out.println(app.accounts[0]);


        System.out.println();
        app.printUserNames();

        System.out.println();
        app.printStateCounts();
    }

}
