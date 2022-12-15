package e2e.stepDefinitions;

import e2e.pages.AccountPage;

public class PageInitializer {

    public static AccountPage accountPage;


    public static void initializePageObjects(){

        accountPage = new AccountPage();

    }
}
