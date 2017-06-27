package sample;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Scrapbook implements Runnable {
		
	public Scrapbook(){
		
		Thread thread = new Thread(this);
		thread.start();	
	}
	
	public void run() {
		System.out.println("Started");
	}
	
	public static void main(String[] args) {
		Scrapbook scrap = new Scrapbook();
	}

}
