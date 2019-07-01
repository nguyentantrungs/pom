package testProperties;

public class web {

    //Chromedriver
    public static String chromeDriver = "D:\\\\\\\\Chromedriver\\\\\\\\chromedriver.exe";

    //General
    public static String nextButton = "//button[contains(text(),'Next')]";
    public static String deselectAllButton = "//span[contains(text(),'Deselect All')]";
    public static String loadingScreen ="//div[@id='select-recipients-page']/parent::div/parent::div/div[@class='loadable-backdrop'][contains(@style,'display: none')]";
    public static String loadingSpinningIcon ="//span[@class='fa fa-refresh pull-right link-btn fa-spin']";
    public static String searchButton = "//div[@class='search-box']/a[contains(text(),'Search')]";
    public static String searchTextField = "//input[@class='m-wrap span5 ng-pristine ng-valid']";


    //Login page
    public static String loginUsername = "//input[@id='UserName']";
    public static String loginPassword = "//input[@id='Password']";
    public static String loginButton = "//input[@value='Login']";

    //Dashboard
    public static String sendMessageOnDashboard = "//a[@class='btn send-action btn-critical ng-scope']";
    public static String loadingIconOnDashboard = "//span[@class='ng-isolate-scope'][contains(@style,'display: none')]";


    //Send Message - Select Group
    public static String masterGroupCheckbox = "//tbody/tr[3]/td/span/input[1]";

    //Send Message - Select Contact
    public static String searchedContact = "//input[@type='checkbox']";

    //Send Message - Send
    public static String sendMessage = "//button/span[contains(text(),'Send Message')]";
    public static String loadingScreenSendMessage = "//*[@id='compose-message-page']";
    public static String messageSubject= "//input[@dynamic-name='message_subject_en-US']";
    public static String messageBody = "//textarea[@class='span12 m-wrap message-body single ng-pristine ng-valid']";

}
