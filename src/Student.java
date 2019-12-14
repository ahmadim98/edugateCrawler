import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Student {
	
	//here are the main attribute the we grab from the website
	public String Name;
	public String ID;
	public String GPA;
	public String Major;
	public String RegisterationDate;
	public String CurrentFaculty;
	public String Campuslocation;
	public String StudentStatus;
	public String CurrentSemester;
	public String JoinSemester;
	public String Duration;
	public String Email;
	public String Phone;
	
	public Student(HtmlPage page) {
		//here we grab the elements using their id's
		this.Name = page.getElementById("studNameText").asText();
		this.ID = page.getElementById("studNo").asText();
		this.Major = page.getElementById("majorName").asText();
		this.RegisterationDate = page.getElementById("regSemesterDescTxt").asText();
		this.CurrentFaculty = page.getElementById("facNameText").asText();
		this.Campuslocation = page.getElementById("campusName").asText();
		
		//here we grab the elements by XPath, the reason we had to use the XPath 
		//cause these elements doesn't have id or name so i had to grab them by their XPath
		DomElement GPAField = page.getFirstByXPath("//*[@id=\"myForm\"]/div[1]/ul/li[4]");
		this.GPA = GPAField.asText().substring(19);
		
		DomElement StatusField = page.getFirstByXPath("//*[@id=\"myForm\"]/div[1]/ul/li[1]");
		this.StudentStatus = StatusField.asText().substring(15);
		
		DomElement CurrentSemField = page.getFirstByXPath("//*[@id=\"myForm\"]/div[1]/ul/li[2]");
		this.CurrentSemester = CurrentSemField.asText().substring(29);
		
		DomElement JoinField = page.getFirstByXPath("//*[@id=\"myForm\"]/div[1]/ul/li[3]");
		this.JoinSemester = JoinField.asText().substring(28);
		
		DomElement DurationField = page.getFirstByXPath("//*[@id=\"myForm\"]/div[2]/ul/li[1]");
		this.Duration = DurationField.asText().substring(44);
		
		DomElement EmailField = page.getFirstByXPath("//*[@id=\"myForm\"]/div[2]/ul/li[2]");
		this.Email = EmailField.asText().substring(21);
		
		DomElement PhoneField = page.getFirstByXPath("//*[@id=\"myForm\"]/div[2]/ul/li[3]");
		this.Phone = PhoneField.asText().substring(14);
	}
	
	//this function used to print the student info
	public void ShowInfo() {
		System.out.println("معلومات الطالب :-");
		System.out.println("اسم الطالب : "+this.Name);
		System.out.println("الرقم الجامعي : "+this.ID);
		System.out.println("الكلية : "+this.CurrentFaculty);
		System.out.println("التخصص : "+this.Major);
		System.out.println("تاريخ التسجيل : "+this.RegisterationDate);
		System.out.println("المقر : "+this.Campuslocation);
		System.out.println("حالة الطالب : "+this.StudentStatus);
		System.out.println("الفصل الحالي : "+this.CurrentSemester);
		System.out.println("فصل الالتحاق : "+this.JoinSemester);
		System.out.println("المعدل التراكمي : "+this.GPA);
		System.out.println("مدة الدراسة : "+this.Duration);
		System.out.println("البريد الالكتروني : "+this.Email);
		System.out.println("رقم الجوال : "+this.Phone);
	}

}
