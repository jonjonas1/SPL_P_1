package virtualKey;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VirtualKeys {
	private String studentName;
	private int lockerNumber;
//	private String fileName;
	Scanner sc = new Scanner(System.in);

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String name) {
		this.studentName = name;
	}

	public int getLockerNumber() {
		return lockerNumber;
	}

	public void setLockerNumber(int number) {
		this.lockerNumber = number;
	}

	public void mainMenuOptions() {
		System.out.println("=================== MAIN OPTIONS ===============================");
		System.out.println("Welcome to our school locker department, Please select from options:");
		System.out.println("Option 1 => To see students files in the directory:");
		System.out.println("Option 2 => To create student file and locker assigment directory:");
		System.out.println("Option 3 => To Read student files");
		System.out.println("Option 4 => To Search a File in Directory if exist ");
		System.out.println("Option 5 => Delete students file from download directory:");
		System.out.println("Option 6 => To End The Program:");
		System.out.println("================================================================");
	}
	
	public void goToMainOptions() {
		System.out.println("\nOption 0 => For main options please enter 0");
		int n = sc.nextInt();
		while(n!=0) {
			goToMainOptions();
			break;
		}
		if(n==0) 
			mainMenuOptions();
	}
	public void createStudentFileInfo(String fileName, String content) {
		File file = new File(System.getProperty("user.home") + "\\Downloads\\" + fileName + ".txt");
		try {
			if (file.createNewFile()) {
				System.out.println("file created successful");
			} else {
				System.out.println("Duplicate file Not Created");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// == Write inside the file ==
		try {
			FileWriter wr = new FileWriter(file);
			wr.write(content);
			wr.close();
			System.out.println("Student and locker has been created, Please check Downloads folder");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Print all files from Download folder on console
	public void getAllFilesOnConsole() {
		File dir = new File(System.getProperty("user.home") + "\\Downloads");
		File[] files = dir.listFiles();
		System.out.println(dir.getAbsolutePath());
		for (File file : files) {
			System.out.print(file.getName() + " \n");
		}
	}

	public void deleteStudentfile(String deleteName) {
		File file = new File(System.getProperty("user.home") + "\\Downloads\\" + deleteName + ".txt");
		if (file.delete()) {
			System.out.println("File deleted successfully from downloads folder");
		} else {
			System.out.println("Enterd file: " + "\"" + deleteName + "\"" + " does not exist in the folder");
		}
	}

	public void createStudentWithLocker(String studentNames) {
		int[] lockers = { 1, 2, 3, 4, 5 };
		boolean checkArray = false;
		int assignedLockerNumber = 0;

		setStudentName(studentNames);
		String studentName = getStudentName();
		System.out.println("Hello " + studentName);

		// User selects valid locker number, else keeps looping until valid number
		// selected
		do {
			System.out.println("We have lockers available: " + Arrays.toString(lockers));
			System.out.println("Please enter valid locker number:");
			assignedLockerNumber = sc.nextInt();
			for (int i = 0; i < lockers.length; i++) {
				if (lockers[i] == assignedLockerNumber) {
					checkArray = true;
				}
			}
		} while (checkArray == false);
		System.out.println("Your locker number is: " + assignedLockerNumber);

		// reduce lockers by assigned number, store in new ArrayList
		List<Integer> remainingLockers = new ArrayList<>();
		for (int i = 0; i < lockers.length; i++) {
			if (lockers[i] != assignedLockerNumber) {
				remainingLockers.add(lockers[i]);
			}
		}
		System.out.println("Remaining Lockers are: " + remainingLockers);

		// Create a file in downloads folder with Student information
		String contentInformation = studentName + "\n" + "Your locker number: " + assignedLockerNumber;
		createStudentFileInfo(studentName, contentInformation);

	}

	public void readCreatedFile(String readFile) {
		List<String> lines = new ArrayList<String>();
		try {
			lines = Files
					.readAllLines(Paths.get(System.getProperty("user.home") + "\\Downloads\\" + readFile + ".txt"));
			for (String line : lines) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public boolean isfileExistInDirectory(String searchFile) {
		File file = new File(System.getProperty("user.home") + "\\Downloads\\" + searchFile + ".txt");
		if(file.exists()) {
			System.out.println(searchFile+" exist in directory");
		} else { 
			System.out.println(searchFile+" does not exist in directory");
			return true;
		}	
		return false;
	}
}
