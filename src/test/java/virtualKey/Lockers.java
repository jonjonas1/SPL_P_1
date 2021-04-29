package virtualKey;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lockers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VirtualKeys key = new VirtualKeys();
		int selectedOption = 0;
		System.out.println("**********************************");
		System.out.println("This is School Admin Locker Creation Portal version# 1.0.1");
		System.out.println("** App Developed by Senior Dev Olin Juraev, April 2021 **");
		System.out.println("** ojuraev10@gmail.com **\n");
		
		
		key.mainMenuOptions();
		while (selectedOption != 6) {
			try {
				selectedOption = sc.nextInt();
				sc.nextLine(); // Consume newline left-over
				
				if (selectedOption == 1) {
					key.getAllFilesOnConsole();
					key.goToMainOptions();
					continue;
				}
				if(selectedOption ==2) {
					System.out.println("Please enter student's first and last name: ");
					String studentName = sc.nextLine();
					key.createStudentWithLocker(studentName);
					key.goToMainOptions();
					continue;
				}
				if(selectedOption == 3) {
					System.out.print("Please enter student name to read on console: ");
					String name = sc.nextLine();
					key.readCreatedFile(name);
					key.goToMainOptions();
					continue;
				}
				if(selectedOption==4) {
					System.out.print("Please enter file name to search: ");
					String fileName = sc.nextLine();
					key.isfileExistInDirectory(fileName);
					key.goToMainOptions();
					continue;
				}
				if (selectedOption == 5) {
					System.out.println("Enter file name to DELETE");
					String name = sc.nextLine();
					key.deleteStudentfile(name);
					key.goToMainOptions();
					continue;
				}
				if(selectedOption==6) {
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}
			
		}

		System.out.println("Program Ended");
		sc.close();
	}

}
