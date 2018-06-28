package com.company;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Biya\\Desktop\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        (driver).findElement(By.id("email")).sendKeys("becoolgirma@yahoo.com");

        driver.findElement(By.id("pass")).sendKeys("samson");

        driver.findElement(By.id("loginbutton")).click();

        String count = driver.findElement(By.id("fbNotificationsJewel")).getText();

        System.out.println("Your have " + count +"Notifications");
//        try{
//                Thread.sleep(5000);
//
//        }catch(Exception e){
//
//        }

        driver.close();

    }
}

