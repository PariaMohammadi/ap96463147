package downloadmanager;

import java.util.Scanner;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.net.URL;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


class downloadedNumber {
	int downloadedNumber;
	downloadedNumber () {
		downloadedNumber = 0;
	}
} 

public class Downloadmanager {
	
	public static String findDomain(String inp) {
		if (! inp.substring(0, 4).contentEquals("http")) {
			inp = "http://" + inp;
		}
		int domainStartLocation = inp.indexOf("://"); // http or https

//		String domain = inp.substring(0, domainStartLocation+3);
		String domain = "";
		for (int i = domainStartLocation+3; i < inp.length(); i++) {
			domain += inp.charAt(i);
			if (inp.charAt(i) == '/') {
				break;
			}
			
		}
		return domain;
	}
	public static void downloadWebPage(String webpage, String savingPath, int n) 
    { 
        try { 
            // Create URL object 
            URL url = new URL(webpage); 
            BufferedReader readr = new BufferedReader(new InputStreamReader(url.openStream())); 
  
            // Enter filename in which you want to download 
            String fileName = Integer.toString(n);
            fileName.hashCode();
            fileName += ".html";
            BufferedWriter writer = new BufferedWriter(new FileWriter(savingPath + fileName));
            
            // read each line from stream till end 
            String line; 
            while ((line = readr.readLine()) != null) { 
                writer.write(line); 
            } 
            readr.close(); 
            writer.close(); 
        } 
        // Exceptions 
        catch (MalformedURLException mue) { 
            System.out.println("File Number " + n + ": Malformed URL Exception raised"); 
        } 
        catch (IOException ie) { 
            System.out.println("File Number " + n + ": IOException raised"); 
        } 
    }
	public static Queue<String> getFirstPageLinks(String url, String domain, Queue<String> allLinks) {
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);
		List<WebElement> allPageLinks = driver.findElements(By.tagName("a"));
		for (int i = 0; i < allPageLinks.size(); i++) {
			String tempURL = allPageLinks.get(i).getAttribute("href");
			if (tempURL != null) {
				if (domain.equals(findDomain(tempURL))) {
					allLinks.add(tempURL);
				}
			}
		}
		driver.close();
		return allLinks;
	}
	public static Queue<String> findLinks(String url, String domain, Queue<String> links, int terminatorNumber, downloadedNumber downloadedLinks, String savingPath) {
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);
		List<WebElement> allPageLinks = driver.findElements(By.tagName("a"));
		for (int i = 0; i < allPageLinks.size(); i++) {
			String tempURL = allPageLinks.get(i).getAttribute("href");
			if (tempURL != null) {
				if (domain.equals(findDomain(tempURL))) {							// Check Domains
					if (downloadedLinks.downloadedNumber < terminatorNumber) {		// Check Third Parameter Condition
						if (!links.contains(tempURL)) {								// Check if Queue Already Has the Node
							links.add(tempURL);
							downloadedLinks.downloadedNumber++;
							downloadWebPage(tempURL, savingPath, downloadedLinks.downloadedNumber);
							if (downloadedLinks.downloadedNumber % 10 == 0) {
								System.out.println(links.size() + "/" + downloadedLinks.downloadedNumber + " (Total Links in Queue / Total Downloaded Links)");
							}
						}
					}
					else {
						System.out.println("Done:\n" + links.size() + "/" + downloadedLinks.downloadedNumber + " (Total Links in Queue / Total Downloaded Links)");
						break;
					}
				}
			}
		}
		driver.close();
		return links;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Get URL
		System.out.print("Please Enter the Url: ");
    	String url = input.next();
    	
    	// Get Saving Path
    	System.out.print("Please Enter the Saving Path (WITHOUT SPACE): ");
    	String savingPath = input.next();
    	
    	// Get Terminator Number
    	System.out.print("How Many URLs You Want? ");
    	int terminatorNumber = input.nextInt();
    	
    	// Get Threads Number
    	int threadsNumber = 1;
    	System.out.print("Do You Want To Use Multitheading?(y/n) ");
    	String usingMultithreading;
		while(true) {
			usingMultithreading = input.next();
			if (usingMultithreading.equals("y")) {
	    		System.out.print("How Many Threads You Want? ");
	    		threadsNumber = input.nextInt();
	    		break;
	    	}
	    	else if (usingMultithreading.equals("n")) {
	    		break;
	    	}
	    	else {
	    		System.out.print("Invalid Input, Please Enter Again: ");
	    	}
		}

		
		// Find Base URL
		String domain = findDomain(url);
		System.out.println("domain: " + domain);
		if (domain.equals("Invalid URL")) {
			System.out.println("Invalid URL");
			System.exit(0);
		}
		
		
		// Start Process
		Queue<String> allLinks = new LinkedList<String>(); 
		allLinks = getFirstPageLinks(url, domain, allLinks);
		System.out.println(allLinks.size());
		
		downloadedNumber downloadedLinks = new downloadedNumber();
		while ( (! allLinks.isEmpty()) && (downloadedLinks.downloadedNumber < terminatorNumber) ) {
			String newURL = allLinks.remove();
			allLinks = findLinks(newURL, domain, allLinks, terminatorNumber, downloadedLinks, savingPath);
		}
		System.out.println(downloadedLinks.downloadedNumber);
		
		
		// Write All Addresses in File
		try {    
	           FileWriter fw = new FileWriter("allDownloadedLinks.txt");
	           for (String linkAddress : allLinks) {
	        	   fw.write(linkAddress + "\n");
	           }
	           fw.close();
		}
		catch(Exception e){
			System.out.println(e);
		}


		input.close();
	}
	
}
	
