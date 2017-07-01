package czaspracy;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {

	private ArrayList<Record> data;
	private int choice;
	private Scanner scanner;
	
	public Menu(ArrayList<Record> data){
		
		this.data = data;
	}
	
	public void start(){
		
		
		System.out.println("Wybierz opcję:\n\n"
				+ "1. Zestawienie per pracownik\n"
				+ "2. Zestawienie per projekt\n"
				+ "3. Pojedynczy pracownik - szczegóły\n"
				+ "4. Pracownik w projektach - udział %\n\n"
				+ "5. Wyjście z programu");
		
		scanner = new Scanner(System.in);
		try{
		choice = scanner.nextInt();
		}catch(Exception e){
			System.out.println("Wybierz poprawną opcję pomiędzy 1 a 5\n");
			this.start();
		}
		
		switch (choice){
		
		case 1:
			System.out.println("Wybrano opcję " + choice);
			this.option1();
			break;
		case 2:
			System.out.println("Wybrano opcję " + choice);
			this.option2();
			break;
		case 3:
			System.out.println("Wybrano opcję " + choice);
			this.option3();
			break;
		case 4:
			System.out.println("Wybrano opcję " + choice);
			this.option4();
			break;
		case 5:
			System.exit(0);
			break;
		default:
				System.out.println("Wybierz poprawną opcję pomiędzy 1 a 5\n");
				this.start();
				
		}
		
	}
	
	//zestawienie per pracownik
	private void option1(){
		
		System.out.println("Podaj rok:\n");
		String year = scanner.next();
		
		
		System.out.println(
				data.stream().collect(
			    Collectors.groupingBy(Record::getName, Collectors.summingDouble(Record::getTaskDuration))));
		
	
		
	}
	
	private void option2(){
		
		System.out.println("Podaj rok:\n");
		String year = scanner.next();
		
		System.out.println("Projekty:");
		for(Record record : data){
			System.out.println(record.getProject());
		}
		
	}
	
	private void option3(){
		
		System.out.println("Podaj imię i nazwisko pracownika:\n");
		String name = scanner.next();
		
		
		for(Record record : data){
			if(record.getName().equals(name))
			System.out.println(record.getProject());
		}
		
	}
	private void option4(){
		
		System.out.println("Podaj imię i nazwisko pracownika:\n");
		String name = scanner.next();
		
		
		for(Record record : data){
			if(record.getName().equals(name))
			System.out.println(record.getProject());
		}
		
	}
}




















