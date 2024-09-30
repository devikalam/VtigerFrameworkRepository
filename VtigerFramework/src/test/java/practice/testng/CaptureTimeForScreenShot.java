package practice.testng;

import java.util.Date;

import org.testng.annotations.Test;

public class CaptureTimeForScreenShot {
	@Test
	public void captureTimeStamp() {
		String time = new Date().toString().replaceAll(" ", "_").replaceAll(":", "_");
		System.out.println(time);
	}
	

}
