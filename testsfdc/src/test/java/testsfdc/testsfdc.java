package testsfdc;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testsfdc extends ReusableMethods {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		initializeDriver();
		CreateReport();
		
		
	  
		//driver.manage().window().maximize();
		
		//Thread.sleep(3000);
	/*	LoginErrMsg_1();
		//Thread.sleep(3000);
		LoginToSfdc_2();
		Thread.sleep(3000);
		
		check_RememberMe();
		Thread.sleep(3000);
		testforgotPassword();
		Thread.sleep(3000);
		forgotPassword4B();
		Thread.sleep(3000);
		TC_05();
		Thread.sleep(3000);
		TC_06();
		Thread.sleep(3000);
		TC_07();
		Thread.sleep(3000);
		TC_08();
		Thread.sleep(3000);
		TC_09();
		Thread.sleep(3000);
		TC_10();
		
		Thread.sleep(3000);
		TC_11();
		//Thread.sleep(3000);
		TC_12();
		Thread.sleep(3000);
		TC_13();
		Thread.sleep(3000);
		TC_14();
		Thread.sleep(3000);
		TC_15();
		Thread.sleep(3000);
		TC_16();
		TC_17();
		TC_18();*/
		TC_19();
		CloseBrowser();
		CloseReport();
		
		
	}
		
		public static void LoginErrMsg_1() throws InterruptedException{
		
			logger = report.startTest("Login Error Messsage");
			 OpenUrl("https://login.salesforce.com");
			Thread.sleep(6000);
			
			WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			EnterText(username, "kikkeri.rachana@gmail.com", "Username");
		//username.sendKeys("kikkeri.rachana@gmail.com");
		logger.log(LogStatus.PASS, "Found the username field");
	    WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
	    password.clear();
	    
	    WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
	    loginbtn.click();
	    Thread.sleep(3000);
	    WebElement errmsg = driver.findElement(By.xpath("//*[@id=\"error\"]"));
	    String errormsg = "Please enter your password.";
	    	if(errmsg.getText().equals(errormsg)) {
	    		logger.log(LogStatus.PASS, "Error message is displayed");
	    		System.out.println("error msg displayed, test case pass");
	    	}
	    	else
	    	{
	    		logger.log(LogStatus.ERROR, "Error message displayed is not right");
	    		System.out.println("Error msg not displayed. test case fail");
	    	}
	    	
				
	}
		
		public static void LoginToSfdc_2() throws InterruptedException
		{
			
			logger = report.startTest("Login to sfdc - TC2");
			 OpenUrl("https://login.salesforce.com");
			 Thread.sleep(3000);
			WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			EnterText(username, "kikkeri.rachana@gmail.com", "Username");

			//username.sendKeys("Kikkeri.rachana@gmail.com");
			logger.log(LogStatus.INFO,"Able to get the text field");
			WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			EnterText(password, "rkikkeri13$", "password");

			//password.sendKeys("rkikkeri13$");
			
			
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
			loginBtn.click();
			
			String ValidateTitle ="Home Page ~ Salesforce - Developer Edition";
			WebElement ActualTitle = driver.findElement(By.xpath("/html/head/title"));
			System.out.println(ActualTitle.getText());
			
			
		}
		
		public static void check_RememberMe() throws InterruptedException
		{
			
			logger = report.startTest("Check - remember me - TC3");
			OpenUrl("https://login.salesforce.com");
			WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			EnterText(username, "kikkeri.rachana@gmail.com", "Username");

			
			//username.sendKeys("kikkeri.rachana@gmail.com");
			WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			EnterText(password, "rkikkeri13$", "password");

			
			//password.sendKeys("rkikkeri13$");
			WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"rememberUn\"]"));
			logger.log(LogStatus.INFO,"Able to get the text field");
			checkbox.click();
			WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
			loginBtn.click();
			Thread.sleep(3000);
			WebElement loggedinUserName = driver.findElement(By.xpath("//*[@id=\"userNavButton\"]"));
			loggedinUserName.click();
			Thread.sleep(3000);
			WebElement logoutBtn = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
			logoutBtn.click();
			Thread.sleep(3000);
			WebElement username1 = driver.findElement(By.xpath("//*[@id=\"idcard-identity\"]"));
			//System.out.println(username.getText());
			
			if((username1.getText()).equals("kikkeri.rachana@gmail.com"))
			{
				logger.log(LogStatus.PASS, "USername saved in the textbox");
				System.out.println("Username is saved, Test case pass");
				
			}
			else
			{
				logger.log(LogStatus.ERROR, "Username not saved");
				System.out.println("Username is not saved, Test case fail");
		    }
			
		}
		
		public static void testforgotPassword()
		{
			logger=report.startTest("Testing forgot password");
			logger.log(LogStatus.INFO, "Url successfully opened");
			WebElement forgotpass = driver.findElement(By.xpath("//*[@id=\"forgot_password_link\"]"));
			if((forgotpass.getText()).equals("Forgot Your Password?"))
			{
				logger.log(LogStatus.PASS, "Forgot your password displayed");
				
			}
			else {
				logger.log(LogStatus.FAIL, "forgot your password not displayed");
			}
			forgotpass.click();
			WebElement usernameforpasswordrecovery = driver.findElement(By.xpath("//*[@id=\"un\"]"));
			EnterText(usernameforpasswordrecovery, "kikkeri.rachana@gmail.com", "Username");
			WebElement continueforgotpass = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
			Click(continueforgotpass,"Continuebtn");
			WebElement header = driver.findElement(By.xpath("//*[@id=\"header\"]"));
			if((header.getText().equals("Check Your Email")))
			{
				logger.log(LogStatus.PASS, "the page with check your email is displayed");
				System.out.println("yes");
			}
			else {
				logger.log(LogStatus.FAIL, "check your email not displayed");
			}
			WebElement returnToLogin = driver.findElement(By.xpath("//*[@id=\"forgotPassForm\"]/a"));
			Click(returnToLogin,"Return to login");
			
		}
		
		public static void forgotPassword4B() throws InterruptedException
		{
			logger = report.startTest("Testing forgot password 4B");
			
			OpenUrl("https://login.salesforce.com");
			logger.log(LogStatus.PASS, "Able to open the url");
			Thread.sleep(3000);
			
			 WebElement crossmarkclick = driver.findElement(By.xpath("//*[@id=\"clear_link\"]/img"));
			 Click(crossmarkclick,"Click cross mark");
			 Thread.sleep(3000);
			
			WebElement usernameforforgotpassword = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			
			Thread.sleep(3000);
			EnterText(usernameforforgotpassword, "123", "usernameforforgotpassword");
			WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			EnterText(password,"1234","password");
			WebElement clickBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
			Click(clickBtn,"Click button");
			WebElement textdisplayed = driver.findElement(By.xpath("//*[@id=\"error\"]"));
			System.out.println(textdisplayed.getText());
			
			if((textdisplayed.getText().equals("Please check your username and password. If you still can't log in, contact your Salesforce administrator.")))
			{
				logger.log(LogStatus.PASS, "Displayed error message");
				System.out.println("yes");
			}
			else
			{
				logger.log(LogStatus.ERROR, "Error message not displayed");
			}
		
			
			}
		 public static void TC_05() throws InterruptedException
		 {
		 
	     logger= report.startTest("Starting test case TC_05");
	     OpenUrl("https://login.salesforce.com");
	     WebElement crossmarkclick = driver.findElement(By.xpath("//*[@id=\"clear_link\"]/img"));
		 Click(crossmarkclick,"Click cross mark");
		 Thread.sleep(3000);
		 WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		 logger.log(LogStatus.PASS, "user name element field is found");
		 EnterText(username,"kikkeri.rachana@gmail.com","username");
		 WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		 logger.log(LogStatus.PASS, "password field is found");
		 EnterText(password,"rkikkeri13$","Password");
		 WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
		 logger.log(LogStatus.PASS, "Login button is found");
		 Click(loginBtn,"Login  Button");
		 WebElement userdropdown = driver.findElement(By.xpath("//*[@id=\"userNav\"]"));
		 Click(userdropdown,"User drop down");
		 logger.log(LogStatus.PASS,"All the user items are found");
		 WebElement myprofile = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[1]"));
		 if((myprofile.getText()).equals("My Profile"))
		 {
			 logger.log(LogStatus.PASS, "My profile exists");
			 System.out.println("yes");
		 }
		 else
		 {
			 logger.log(LogStatus.ERROR, "My profile does not display");
		 }
		
		 
		 }
		
	 public static void TC_06() throws InterruptedException
		 {
			 logger=report.startTest("Starting testcase TC_06");
			 OpenUrl("https://login.salesforce.com");
			 WebElement editlist = driver.findElement(By.xpath("//*[@id=\"edit\"]"));
			 Click(editlist,"Edit list");
			 logger.log(LogStatus.PASS, "Edit list button found");
			 Thread.sleep(3000);
			 WebElement crossmark = driver.findElement(By.xpath("//*[@id=\"edit-00D6g000007OXSP0056g000004INzJ\"]/a/img"));
			 Click(crossmark,"Cross mark");
			 logger.log(LogStatus.PASS,"cross mark found");
			 Thread.sleep(3000);
			 WebElement savechange = driver.findElement(By.xpath("//*[@id=\"hint_save_edit\"]"));
			 Click(savechange,"save change");
			 logger.log(LogStatus.PASS, "save change found");
			 Thread.sleep(3000);
			 WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			 logger.log(LogStatus.PASS, "Got the username field");
			 EnterText(username,"kikkeri.rachana@gmail.com","username");
			 WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			 logger.log(LogStatus.PASS, "password field is found");
			 EnterText(password,"rkikkeri13$","Password");
			 WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
			 Click(loginBtn,"Login Button");
			 Thread.sleep(3000);
			 WebElement userdropdown = driver.findElement(By.xpath("//*[@id=\"userNavButton\"]"));
			 userdropdown.click();
			 Thread.sleep(3000);
			 WebElement myprofile = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[1]"));
			 myprofile.click();
			
			 Thread.sleep(3000);
			 WebElement title = driver.findElement(By.xpath("/html/head/title"));
		
			 System.out.println(title.getText());
			 WebElement editprofile = driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img"));
			 Click(editprofile,"Edit profile");
			 Thread.sleep(3000);
			 
			 WebElement frameeditinfo = driver.findElement(By.xpath("//*[@id=\"contactInfoContentId\"]"));
			 driver.switchTo().frame(frameeditinfo);
			 WebElement about = driver.findElement(By.xpath("//*[@id=\"aboutTab\"]/a"));
			 Click(about,"About");
			 Thread.sleep(3000);
			 
			 WebElement lastname = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
			 lastname.clear();
			 EnterText(lastname,"Vikram","last name");
			 WebElement saveall = driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]"));
			 Click(saveall,"Save all");
			 WebElement Displayname = driver.findElement(By.xpath("//*[@id=\"tailBreadcrumbNode\"]"));
			 if((Displayname.getText()).equals("Rachana Vikram "))
			 {
				System.out.println(Displayname.getText());
				 logger.log(LogStatus.PASS, "Successfully changed the name");
			 }
			 
			 else
			 {
				 logger.log(LogStatus.ERROR, "Error changing the name");
			 }
			 WebElement postlink = driver.findElement(By.xpath("//*[@id=\"publisherAttachTextPost\"]/span[1]"));
			 Click(postlink,"Post Link");
			 WebElement entertext = driver.findElement(By.xpath("//*[@id=\"cke_39_contents\"]/iframe"));
			 driver.switchTo().frame(entertext);
			 Thread.sleep(3000);
			 WebElement textbody = driver.findElement(By.xpath("/html/body"));
			 Thread.sleep(3000);
			 EnterText(textbody,"dszfd","Enter text");
			 Thread.sleep(3000);
     		 driver.switchTo().defaultContent();
			 WebElement shareBtn = driver.findElement(By.xpath("//*[@id=\"publishersharebutton\"]"));
			 Thread.sleep(3000);
			 Click(shareBtn,"Share button");
			 Thread.sleep(3000);
			 WebElement filelink = driver.findElement(By.xpath("//*[@id=\"publisherAttachContentPost\"]/span[1]"));
			 Click(filelink,"File link");
			 WebElement uploadFile = driver.findElement(By.xpath("//*[@id=\"chatterUploadFileAction\"]"));
			 Click(uploadFile,"Upload file from computer");
			 WebElement choosefile = driver.findElement(By.xpath("//*[@id=\"chatterFile\"]"));
			
			 choosefile.sendKeys("C:\\Users\\kikke\\OneDrive\\Desktop\\transcripts.pdf");
			 Thread.sleep(3000);
			 Click(shareBtn,"Share button");
			 Thread.sleep(3000);
			
			/* WebElement deletephoto = driver.findElement(By.xpath("//*[@id=\"deletePhoto\"]"));
			 Actions actions1 = new Actions(driver);
			 actions1.moveToElement(deletephoto).click().build().perform();
			 Thread.sleep(3000);*/
			
			
			 WebElement frameuploadphoto = driver.findElement(By.xpath("//*[@id=\"displayBadge\"]"));
			 Thread.sleep(3000);
			
			 Actions actions = new Actions(driver);
			 actions.moveToElement(frameuploadphoto).click().build().perform();
			 Thread.sleep(3000);
			 WebElement frameupload = driver.findElement(By.xpath("//*[@id=\"uploadPhotoContentId\"]"));
			 driver.switchTo().frame(frameupload);
			
			 Thread.sleep(3000);
			
			
			 Thread.sleep(3000);
			 WebElement choosephoto = driver.findElement(By.xpath("//*[@id=\"j_id0:uploadFileForm:uploadInputFile\"]"));
			 EnterText(choosephoto,"C:\\Users\\kikke\\OneDrive\\Pictures\\Saved Pictures\\nature.jpg","choose photo");
			 Thread.sleep(3000);
			 WebElement save = driver.findElement(By.xpath("//*[@id=\"j_id0:uploadFileForm:uploadBtn\"]"));
			 Click(save,"Save");
			 Thread.sleep(3000);
			 WebElement savephotoaftercropping = driver.findElement(By.xpath("//*[@id=\"j_id0:j_id7:save\"]"));
			 Thread.sleep(3000);
			 Click(savephotoaftercropping,"Save photo after cropping"); 
			
			 
		 }
	     
	    public static void TC_07() throws InterruptedException
	    {
	    	
	    	logger = report.startTest("Starting test case TC_07");
	    	OpenUrl("https://login.salesforce.com");
	    //	 WebElement editlist = driver.findElement(By.xpath("//*[@id=\"edit\"]"));
		//	 Click(editlist,"Edit list");
			 logger.log(LogStatus.PASS, "Edit list button found");
			 Thread.sleep(3000);
			// WebElement crossmark = driver.findElement(By.xpath("//*[@id=\"edit-00D6g000007OXSP0056g000004INzJ\"]/a/img"));
			 //Click(crossmark,"Cross mark");
			 logger.log(LogStatus.PASS,"cross mark found");
			 Thread.sleep(3000);
		//	 WebElement savechange = driver.findElement(By.xpath("//*[@id=\"hint_save_edit\"]"));
		//	 Click(savechange,"save change");
			 logger.log(LogStatus.PASS, "save change found");
			 Thread.sleep(3000);
	    	 WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			 logger.log(LogStatus.PASS, "Got the username field");
			 EnterText(username,"kikkeri.rachana@gmail.com","username");
			 WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			 EnterText(password,"rkikkeri13$","Password");
			 logger.log(LogStatus.PASS, "password field is found");
			 WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
			 Click(loginBtn,"Login Button");
			 Thread.sleep(3000);
			 WebElement userdropdown = driver.findElement(By.xpath("//*[@id=\"userNavButton\"]"));
			 userdropdown.click();
			 Thread.sleep(3000);
			 WebElement mysettings = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
			 Click(mysettings,"My settings");
			 Thread.sleep(3000);
			 WebElement personallink = driver.findElement(By.xpath("//*[@id=\"PersonalInfo\"]/a"));
			 Click(personallink,"Personal Link");
			 Thread.sleep(3000);
			 WebElement loginhistory = driver.findElement(By.xpath("//*[@id=\"LoginHistory_font\"]"));
			 Click(loginhistory,"Login History");
			 Thread.sleep(3000);
			 WebElement downloadloginhistory = driver.findElement(By.xpath("//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a"));
			 Click(downloadloginhistory,"Download login history link");
			 Thread.sleep(3000);
			 isFileDownloaded_Extension("C:\\Users\\kikke\\Downloads\\","csv");
			 Thread.sleep(3000);
			 WebElement displaylayout = driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout\"]/a"));
			 Click(displaylayout,"Display & layout");
			 Thread.sleep(3000);
			 WebElement customizetabs = driver.findElement(By.xpath("//*[@id=\"CustomizeTabs_font\"]"));
			 Click(customizetabs,"Customize my tabs");
			 Thread.sleep(3000);
			 WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"p4\"]"));
			 Click(dropdown,"Drop down");
			 Thread.sleep(3000);
			 dropdown.sendKeys("Salesforce Chatter");
			 Thread.sleep(3000);
			 WebElement reports = driver.findElement(By.xpath("//*[@id=\"duel_select_0\"]/option[43]"));
			 reports.click();
			 WebElement add = driver.findElement(By.xpath("//*[@id=\"duel_select_0_right\"]/img"));
			 Thread.sleep(3000);
			 add.click();
			 Thread.sleep(6000);
			 
			 WebElement email = driver.findElement(By.xpath("//*[@id=\"EmailSetup\"]/a"));
			 Click(email, "email");
			 WebElement myemailsettings= driver.findElement(By.xpath("//*[@id=\"EmailSettings_font\"]"));
			 Click(myemailsettings,"my email settings");
			 WebElement save = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
			 Click(save,"save");
			 Thread.sleep(3000);
			 WebElement message = driver.findElement(By.xpath("//*[@id=\"meSaveCompleteMessage\"]"));
			 System.out.println(message.getText());
			 logger.log(LogStatus.PASS, "My settings successuflly saved");
			 WebElement calendar = driver.findElement(By.xpath("//*[@id=\"CalendarAndReminders_font\"]"));
			 Click(calendar,"Calender");
			 Thread.sleep(3000);
			 WebElement activity = driver.findElement(By.xpath("//*[@id=\"Reminders_font\"]"));
			 Click(activity,"Activity");
			 Thread.sleep(3000);
			 WebElement openreminder = driver.findElement(By.xpath("//*[@id=\"testbtn\"]"));
			 Click(openreminder,"Open reminder");
			 Thread.sleep(3000);
	    	
	    }
	    public static boolean isFileDownloaded_Extension(String dirPath, String extension) {
	        boolean flag = false;
	        File dir = new File("C:\\Users\\kikke\\Downloads\\");
	        File[] files = dir.listFiles();
	        if(files == null || files.length==0) {
	         flag = false;
	        }
	        for(int i=1; i<files.length; i++) {
	         if(files[i].getName().contains(".csv")) {
	          flag = true;
	          System.out.println(flag);
	         }
	        }
	        return flag;
	       }
	 public static void TC_08() throws InterruptedException {

	    	logger = report.startTest("Starting test case TC_08");
	    	OpenUrl("https://login.salesforce.com");
	   
			 logger.log(LogStatus.PASS, "Edit list button found");
			 Thread.sleep(3000);
			
			 logger.log(LogStatus.PASS,"cross mark found");
			 Thread.sleep(3000);
		
			 logger.log(LogStatus.PASS, "save change found");
			 Thread.sleep(3000);
	    	 WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			 logger.log(LogStatus.PASS, "Got the username field");
			 EnterText(username,"kikkeri.rachana@gmail.com","username");
			 WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			 EnterText(password,"rkikkeri13$","Password");
			 logger.log(LogStatus.PASS, "password field is found");
			 WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
			 Click(loginBtn,"Login Button");
			 Thread.sleep(3000);
			 WebElement userdropdown = driver.findElement(By.xpath("//*[@id=\"userNavButton\"]"));
			 userdropdown.click();
			 Thread.sleep(3000);
			 WebElement developerconsole = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[3]"));
			 Click(developerconsole,"Developer console");
			 Thread.sleep(3000);
			 driver.getWindowHandle();
			  driver.close();
			  Thread.sleep(3000);
			 
		 
	 }
	 
	 public static void TC_09() throws InterruptedException
	 {
		   
		    logger = report.startTest(" TC9");
			OpenUrl("https://login.salesforce.com");
			WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			EnterText(username, "kikkeri.rachana@gmail.com", "Username");
		
			WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			EnterText(password, "rkikkeri13$", "password");
			logger.log(LogStatus.INFO,"Able to get the text field");
			
			WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
			loginBtn.click();
			Thread.sleep(3000);
			WebElement loggedinUserName = driver.findElement(By.xpath("//*[@id=\"userNavButton\"]"));
			loggedinUserName.click();
			Thread.sleep(3000);
			WebElement logoutBtn = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
			logoutBtn.click();
			Thread.sleep(3000);
		 
	 }
		 
	    public static void TC_10() throws InterruptedException
	    {
	    	    logger = report.startTest("TC10");
				OpenUrl("https://login.salesforce.com");
				WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
				EnterText(username, "kikkeri.rachana@gmail.com", "Username");
			
				WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
				EnterText(password, "rkikkeri13$", "password");
				logger.log(LogStatus.INFO,"Able to get the text field");
				
				WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
				loginBtn.click();
				Thread.sleep(3000);
				
				WebElement plusBtn = driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
				Click(plusBtn,"Plus button");
				Thread.sleep(3000);
				WebElement accountslink = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[1]/td[1]/a"));
				Click(accountslink,"Accounts");
				Thread.sleep(3000);
				WebElement newBtn = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
				Click(newBtn, "New");
				Thread.sleep(3000);
				WebElement acctname = driver.findElement(By.xpath("//*[@id=\"acc2\"]"));
				EnterText(acctname,"Rachana","acct name");
				Thread.sleep(3000);
				WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"acc6\"]"));
				EnterText(dropdown,"Technology Partner", "Drop down");
				Thread.sleep(3000);
				WebElement priority = driver.findElement(By.xpath("//*[@id=\"00N6g00000NI629\"]"));
				EnterText(priority,"High","Priority");
				Thread.sleep(3000);
				WebElement save = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
				Click(save, "Save");
				Thread.sleep(3000);
				
	    	
	    }
	    public static void TC_11() throws InterruptedException
	    {
	    	logger = report.startTest("TC11");
			OpenUrl("https://login.salesforce.com");
			WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			EnterText(username, "kikkeri.rachana@gmail.com", "Username");
		
			WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			EnterText(password, "rkikkeri13$", "password");
			logger.log(LogStatus.INFO,"Able to get the text field");
			
			WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
			loginBtn.click();
			Thread.sleep(3000);
			
			WebElement plusBtn = driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
			Click(plusBtn,"Plus button");
			Thread.sleep(3000);
			WebElement accountslink = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[1]/td[1]/a"));
			Click(accountslink,"Accounts");
			Thread.sleep(3000);	
			WebElement newview = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a"));
			Click(newview,"New view");
			Thread.sleep(3000);
			WebElement viewname = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
			EnterText(viewname,"RachanaV","View name");
			Thread.sleep(3000);
			WebElement save = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
			Click(save,"save");
			Thread.sleep(3000);
			
	    }
	    
	    public static void TC_12() throws InterruptedException
	    {
	    	logger = report.startTest("TC12");
			OpenUrl("https://login.salesforce.com");
			WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			EnterText(username, "kikkeri.rachana@gmail.com", "Username");
		
			WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			EnterText(password, "rkikkeri13$", "password");
			logger.log(LogStatus.INFO,"Able to get the text field");
			
			WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
			loginBtn.click();
			Thread.sleep(3000);
			
			WebElement plusBtn = driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
			Click(plusBtn,"Plus button");
			Thread.sleep(3000);
			WebElement accountslink = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[1]/td[1]/a"));
			Click(accountslink,"Accounts");
			Thread.sleep(3000);	
			WebElement editview = driver.findElement(By.xpath("//*[@id=\"fcf\"]"));
			Thread.sleep(3000);
			EnterText(editview,"Rachana","Edit view");
			Thread.sleep(6000);
			WebElement EditBtn = driver.findElement(By.xpath("//*[@id=\"00B6g00000BfJy9_filterLinks\"]/a[1]"));
			Click(EditBtn,"Edit button");
			Thread.sleep(3000);
			WebElement editviewname = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
			EnterText(editviewname,"Rachanavvv","Edit view name");
			Thread.sleep(3000);
			WebElement Accountnamefield = driver.findElement(By.xpath("//*[@id=\"fcol1\"]"));
			EnterText(Accountnamefield,"Account Name","Accountnamefield");
			Thread.sleep(3000);
			WebElement operatorcontains = driver.findElement(By.xpath("//*[@id=\"fop1\"]"));
			EnterText(operatorcontains,"contains","Operator contains");
			Thread.sleep(3000);
			WebElement value = driver.findElement(By.xpath("//*[@id=\"fval1\"]"));
			EnterText(value,"a","Value");
			Thread.sleep(3000);
			WebElement saveBtn = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
			Click(saveBtn,"Save button");
			Thread.sleep(3000);
			String[] exp = {"Rachanavvv"}; 
			/*WebElement dropdown = driver.findElement(By.xpath("//*[@id=\\\"fcf\\\"]"));  
			        Select select = new Select(dropdown);  

			        List<WebElement> options = select.getOptions();  
			        for(WebElement we:options)  
			        {  
			         for (int i=0; i<exp.length; i++){
			             if (we.getText().equals(exp[i])){
			             System.out.println("Matched");
			             } 
			           }
			         }  */
			
	    }
	    
	    public static void TC_13() throws InterruptedException
	    {
	    	logger = report.startTest("TC13");
			OpenUrl("https://login.salesforce.com");
			WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			EnterText(username, "kikkeri.rachana@gmail.com", "Username");
		
			WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			EnterText(password, "rkikkeri13$", "password");
			logger.log(LogStatus.INFO,"Able to get the text field");
			
			WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
			loginBtn.click();
			Thread.sleep(3000);
			
			WebElement plusBtn = driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
			Click(plusBtn,"Plus button");
			Thread.sleep(3000);
			WebElement accountslink = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[1]/td[1]/a"));
			Click(accountslink,"Accounts");
			Thread.sleep(3000);	
			WebElement mergeaccounts = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span"));
			Thread.sleep(3000);
			Click(mergeaccounts,"Merge accounts");
			Thread.sleep(3000);
			WebElement textarea = driver.findElement(By.xpath("//*[@id=\"srch\"]"));
			Thread.sleep(3000);
		    EnterText(textarea,"Burlington Textiles Corp of America","Merge accounts");
		    Thread.sleep(3000);
		    WebElement findaccounts = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/input[2]"));
		    Thread.sleep(3000);
		    Click(findaccounts,"Find accounts");
		    Thread.sleep(3000);
		    WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"cid0\"]"));
		    Click(checkbox,"Check box");
		    Thread.sleep(3000);
		    WebElement nextBtn = driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[1]/div/input[1]"));
		    Click(nextBtn,"Next button");
		    Thread.sleep(3000);
		    
	    }
	    public static void TC_14() throws InterruptedException
	    {
	    	logger = report.startTest("TC14");
			OpenUrl("https://login.salesforce.com");
			WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			EnterText(username, "kikkeri.rachana@gmail.com", "Username");
		
			WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			EnterText(password, "rkikkeri13$", "password");
			logger.log(LogStatus.INFO,"Able to get the text field");
			
			WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
			loginBtn.click();
			Thread.sleep(3000);
			
			WebElement plusBtn = driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
			Click(plusBtn,"Plus button");
			Thread.sleep(3000);
			WebElement accountslink = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[1]/td[1]/a"));
			Click(accountslink,"Accounts");
			Thread.sleep(3000);	
			WebElement reports = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div/div[2]/div/a"));
			Click(reports,"Reports");
			WebElement newreport = driver.findElement(By.xpath("//*[@id=\"ext-gen5\"]/input[1]"));
			Click(newreport,"New report");
			WebElement createBtn = driver.findElement(By.xpath("//*[@id=\"thePage:rtForm:createButton\"]"));
			Click(createBtn,"Create buttom");
			WebElement startdate = driver.findElement(By.xpath("//*[@id=\"ext-comp-1042\"]"));
			EnterText(startdate,"2/19/2020", "Start date");
			WebElement enddate = driver.findElement(By.xpath("//*[@id=\"ext-comp-1045\"]"));
			EnterText(enddate,"2/19/2020","End date");
			WebElement saveBtn = driver.findElement(By.xpath("//*[@id=\"ext-gen49\"]"));
			Click(saveBtn,"Save");
			Thread.sleep(3000);
			WebElement reportname = driver.findElement(By.xpath("//*[@id=\"saveReportDlg_reportNameField\"]"));
			EnterText(reportname,"Rachana","Report name");
			WebElement fieldspace = driver.findElement(By.xpath("//*[@id=\"ext-comp-1066\"]"));
			Click(fieldspace,"Field space");
			Thread.sleep(6000);
			WebElement saverunreport = driver.findElement(By.xpath("//*[@id=\"ext-gen280\"]"));
			Click(saverunreport,"Save and run report");
			Thread.sleep(6000);
	    	
	    }
	    
	    public static void TC_15() throws InterruptedException
	    {
	    	logger = report.startTest("TC15");
			OpenUrl("https://login.salesforce.com");
			WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			EnterText(username, "kikkeri.rachana@gmail.com", "Username");
		
			WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			EnterText(password, "rkikkeri13$", "password");
			logger.log(LogStatus.INFO,"Able to get the text field");
			
			WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
			loginBtn.click();
			Thread.sleep(3000);
			
			WebElement plusBtn = driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
			Click(plusBtn,"Plus button");
			Thread.sleep(3000);
			WebElement opportunities = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[11]/td[2]/a"));
			Click(opportunities,"Opportunities");
			Thread.sleep(3000);
			String[] exp = {"All Opportunities", "Closing Next Month", "Closing This Month", "My Opportunities", "New Last Week", "New This Week", "Opportunity Pipeline", "Private", "Recently Viewed Opportunities", "Won"}; 
			WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"fcf\"]"));  
			        Select select = new Select(dropdown);  

			        List<WebElement> options = select.getOptions();  
			        for(WebElement we:options)  
			        {  
			         for (int i=0; i<exp.length; i++){
			             if (we.getText().equals(exp[i])){
			             System.out.println("Matched");
			             logger.log(LogStatus.PASS, "All the dropdown content found");
			             } 
			           }
			         }  
			
			
	    }
	    public static void TC_16() throws InterruptedException
	    {
	    	logger = report.startTest("TC16");
			OpenUrl("https://login.salesforce.com");
			WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			EnterText(username, "kikkeri.rachana@gmail.com", "Username");
		
			WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			EnterText(password, "rkikkeri13$", "password");
			logger.log(LogStatus.INFO,"Able to get the text field");
			
			WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
			loginBtn.click();
			Thread.sleep(3000);
			
			WebElement plusBtn = driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
			Click(plusBtn,"Plus button");
			Thread.sleep(3000);
			WebElement opportunities = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[11]/td[2]/a"));
			Click(opportunities,"Opportunities");
			Thread.sleep(3000);
			WebElement newBtn = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
			Click(newBtn,"New Button");
			Thread.sleep(3000);
	    	WebElement opportunity = driver.findElement(By.xpath("//*[@id=\"opp3\"]"));
	    	EnterText(opportunity,"Rachana","Opportunity text box");
	    	WebElement accntname = driver.findElement(By.xpath("//*[@id=\"opp4\"]"));
	    	EnterText(accntname,"Dickenson plc","Account name");
	    	Thread.sleep(3000);
	    	WebElement closingdate = driver.findElement(By.xpath("//*[@id=\"opp9\"]"));
	    	EnterText(closingdate,"2/19/2020","Closing Date");
	    	Thread.sleep(3000);
	    	WebElement stage= driver.findElement(By.xpath("//*[@id=\"opp11\"]"));
	    	EnterText(stage,"Prospecting","Stage");
	    	WebElement probability = driver.findElement(By.xpath("//*[@id=\"opp12\"]"));
	    	  probability.clear();
	    	 
	    	EnterText(probability,"10","Probability");
	    	WebElement pri = driver.findElement(By.xpath("//*[@id=\"opp17\"]"));
	    	EnterText(pri,"rachana","Primary campaign source");
	    	WebElement saveBtn= driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
	    	Click(saveBtn,"Save");
	    	Thread.sleep(6000);
	    	
	    	
	    }
	     public static void TC_17() throws InterruptedException
	     {
	    	 
	    	    logger = report.startTest("TC17");
				OpenUrl("https://login.salesforce.com");
				WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
				EnterText(username, "kikkeri.rachana@gmail.com", "Username");
			
				WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
				EnterText(password, "rkikkeri13$", "password");
				logger.log(LogStatus.INFO,"Able to get the text field");
				
				WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
				loginBtn.click();
				Thread.sleep(3000);
				
				WebElement plusBtn = driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
				Click(plusBtn,"Plus button");
				Thread.sleep(3000);
				WebElement opportunities = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[11]/td[2]/a"));
				Click(opportunities,"Opportunities");
				Thread.sleep(3000);
				WebElement opppipe = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a"));
				Click(opppipe,"Opportunity pipeline");
				Thread.sleep(6000);
				
				
				
	     }
	     public static void TC_18() throws InterruptedException
	     {
	    	 logger = report.startTest("TC18");
				OpenUrl("https://login.salesforce.com");
				WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
				EnterText(username, "kikkeri.rachana@gmail.com", "Username");
			
				WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
				EnterText(password, "rkikkeri13$", "password");
				logger.log(LogStatus.INFO,"Able to get the text field");
				
				WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
				loginBtn.click();
				Thread.sleep(3000);
				
				WebElement plusBtn = driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
				Click(plusBtn,"Plus button");
				Thread.sleep(3000);
				WebElement opportunities = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[11]/td[2]/a"));
				Click(opportunities,"Opportunities");
				Thread.sleep(3000);
				WebElement stuck = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a"));
				Click(stuck,"Stuck opportunitities");
				Thread.sleep(6000);
	    	 
	     }
	     public static void TC_19() throws InterruptedException
	     {
	    	    logger = report.startTest("TC19");
				OpenUrl("https://login.salesforce.com");
				WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
				EnterText(username, "kikkeri.rachana@gmail.com", "Username");
			
				WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
				EnterText(password, "rkikkeri13$", "password");
				logger.log(LogStatus.INFO,"Able to get the text field");
				
				WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
				loginBtn.click();
				Thread.sleep(3000);
				
				WebElement plusBtn = driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
				Click(plusBtn,"Plus button");
				Thread.sleep(3000);
				WebElement opportunities = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[11]/td[2]/a"));
				Click(opportunities,"Opportunities");
				Thread.sleep(3000);
				WebElement interval = driver.findElement(By.xpath("//*[@id=\"quarter_q\"]"));
				EnterText(interval,"Current FY","Interval");
				WebElement include =driver.findElement(By.xpath("//*[@id=\"open\"]"));
				EnterText(include,"Open Opportunities","inlcude");
				WebElement runreport = driver.findElement(By.xpath("//*[@id=\"lead_summary\"]/table/tbody/tr[3]/td/input"));
				Click(runreport,"Run report");
				Thread.sleep(6000);
				//Edit the acct name acc456
				
	     }
	 
		}
		
		

