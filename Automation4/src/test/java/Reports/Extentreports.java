package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extentreports {

	public static void main(String[] args) {
		ExtentHtmlReporter ehr= new ExtentHtmlReporter("extentreports.html");
		ExtentReports extent = new ExtentReports();
        extent.attachReporter(ehr);

	}

}
