import java.util.logging.Level;

import com.gargoylesoftware.htmlunit.html.*;//to access html forms and elements 
import com.gargoylesoftware.htmlunit.WebClient;

public class Crawler {
	
	public static void main(String[] args) {
		
		//this line just to stop the warning that are coming from
		//htmlunit which is unnecessary
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); 
		
		try {
			
			WebClient webClient = new WebClient();
			//our website link "education gate"
			HtmlPage Homepage = webClient.getPage("https://edugate.ksu.edu.sa/ksu/ui/home.faces");
	        
			//here we will get the input elements in the website
			DomElement Username = Homepage.getElementById("loginForm:username");
			DomElement Password = Homepage.getElementById("loginForm:password");
			HtmlSelect Usertype = (HtmlSelect) Homepage.getElementById("loginForm:userType");
			HtmlOption StudentOption = Usertype.getOptionByValue("1");
			DomElement loginButton = Homepage.getElementById("loginForm:loginButton");
			
			//set the username, password and select "Student" option
			Usertype.setSelectedAttribute(StudentOption, true);
	        Username.setAttribute("value", "000000000");//replace with your username
	        Password.setAttribute("value", "000000000");//replace with your password
	        
	        //the website have problem with login so i needed to set the href manually for login button
	        loginButton.setAttribute("href", "javascript:userTypeSelect();");
	        
	        //here we perform the login command in the website
	        HtmlPage Studentpage = loginButton.click();
			
	        //we create student object to crawl student info from the website and show them
	        Student student = new Student(Studentpage);
			student.ShowInfo();
			
		}catch (Exception e) {
			e.printStackTrace();
		
		}
	}

}
