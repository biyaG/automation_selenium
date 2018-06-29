package com.company;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;

import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Biya\\Desktop\\sele\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.reuters.com");

        //driver.get("file:///C:/Users/Nahom/Downloads/BBC%20-%20Homepage.html");

        Fetch fetcher = new Fetch();

        List<WebElement> headlines = driver.findElements(By.className("story-title"));

        for (WebElement i : headlines) {
            String headline = i.getText();
            fetcher.insertHeadlines(headline);
//            System.out.println(headline);


//            i.click();
//            String story = driver.findElement(By.className("story-body__inner")).findElement(By.tagName("p")).getText();
//            System.out.println(story);
        }

        List<WebElement> stories = driver.findElements(By.className("contributor"));

        for (WebElement j : stories) {
            String story = j.getText();
           // String story = j.findElement(By.tagName("p")).getText();

            fetcher.insertStory(story);

        }

//        System.out.println(grabber.getHeadlines().size());
//        System.out.println(grabber.getStories().size());

        fetcher.displaySite();



    }
}
class Fetch {

    private ArrayList<String> headlines = new ArrayList<String>();
    private ArrayList<String> storys = new ArrayList<String>();

    public Fetch(){

    }

    public void insertHeadlines(String headline){
        headlines.add(headline);

    }

    public void insertStory(String story){
        storys.add(story);
    }
    public List<String> getStories(){
        return this.storys;
    }

    public List<String> getHeadlines(){
        displaySite();
        return this.headlines;
    }

    public void displaySite(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("C:\\Users\\Biya\\Desktop\\News.html");
        int i = 0, j = 1;
        while (i < storys.size()){
            while (j < headlines.size()) {
//
                String singleHeadline = headlines.get(j);
                String singleStory = storys.get(i);
//            System.out.println(singleHeadline);
                WebElement divHeadlines = driver.findElement(By.id("headlines"));
                divHeadlines.sendKeys(singleHeadline);

                WebElement divStories = driver.findElement(By.id("details"));
                divStories.sendKeys(singleStory);

                WebElement addButton = driver.findElement(By.id("addBtn"));
                addButton.click();

                divHeadlines.clear();
                divStories.clear();

                j++;
                i++;
//            break;
            }
        }


    }
}
