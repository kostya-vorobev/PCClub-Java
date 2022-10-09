package com.libr;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

import com.libr.Lib;

public class Manager{
	private int managerId;
	private StringBuffer fio = new StringBuffer();
	private StringBuffer adress = new StringBuffer();
	private int salary;

	public Manager()
	{

	}
	public Manager(int id, String fio, String adress, int salary)
	{
	this.managerId = id;
	if(this.fio.length()>0){
	this.fio.delete(0, this.fio.length());
	this.fio.insert(0, fio);
	}
	else{
		this.fio.insert(0, fio);
	}
	if(this.adress.length()>0){
		this.adress.delete(0, this.adress.length());
		this.adress.insert(0, adress);
	}
	else{
		this.adress.insert(0, adress);
	}
	this.salary = salary;
}

public void CopyManager(Manager objManager)
{
	this.managerId = objManager.managerId;
	this.fio.delete(0, this.fio.length());
	this.fio.insert(0, objManager.fio);
	this.adress.delete(0, this.adress.length());
	this.adress.insert(0, objManager.fio);
	this.salary = objManager.salary;
}

public int GetIDManager()
{
	return this.managerId;
}

public String GetFIOManager()
{
	return this.fio.toString();
}

public String GetAdress()
{
	return this.adress.toString();
}

public int GetSalary()
{
	return this.salary;
}

public void SetIDManager(int id)
{
	this.managerId = id;
}

public void SetFIOManager(String fio)
{
	this.fio.delete(0, this.fio.length());
	this.fio.insert(0, fio);
}

public void SetAdress(String Adress)
{
	this.adress.delete(0, this.adress.length());
	this.adress.insert(0, Adress);
}
public void SetSalary(int Salary)
{
	this.salary = Salary;
}

public void FprintfManager(String fileName, String endString)
{
	File f = new File(fileName);

		if (!f.isFile()) {
			try{
			if (f.createNewFile())
				System.out.println("File created");
			else
				System.out.println("File already exists");
				return;
			}
			catch(final IOException ex){
             
				System.out.println(ex.getMessage());
			} 

		}
		if (f.isFile() && this.managerId != 0) {
			try(FileWriter fileWriter = new FileWriter(fileName,true);)
        {
			
			fileWriter.write(this.managerId + " ;");
			fileWriter.write(this.fio + " ;");
			fileWriter.write(this.adress + " ;");
			fileWriter.write(this.salary + " \n");
			fileWriter.flush();
		}
		catch(final IOException ex){
             
            System.out.println(ex.getMessage());
		} 
	}

}

public void ScanfManager() throws FileNotFoundException
{
	this.managerId = Lib.CountFillFile("Manager.txt");
	do {
		Lib.InputString(this.fio, "Введите ФИО мененджера: ", 49);
		System.out.println(this.fio);
	} while (!Lib.IsName(this.fio));

	do {
		Lib.InputString(this.adress, "Введите адрес мененджера: ", 49);
		System.out.println(this.adress);
	} while (!Lib.IsWord(this.adress));
	do {
		this.salary = Lib.Get_int("Введите ставку мененджера: ");
	} while (this.salary <= 1);
}

public void FscanfManager(Scanner scanner)
{
	String line = scanner.nextLine();
	//System.out.System.out.printf(line);
	String[] words = line.split(" ;");
	this.managerId = Integer.parseInt(words[0]);
	this.fio.delete(0, this.fio.length());
	this.fio.insert(0, words[1]);
	this.adress.delete(0, this.adress.length());
	this.adress.insert(0, words[2]);
	this.salary = Integer.parseInt(words[3].trim());

}

public void SearchManager() throws FileNotFoundException
{
	int searchId = 0;
	do {
		searchId = Lib.Get_int("Введите id менеджера: ");
		//searchId = 1;
		File findInFile = new File("Manager.txt");
		Scanner scanner = new Scanner(findInFile);
		while (scanner.hasNextLine())
		{
			this.FscanfManager(scanner);
			if (this.managerId == searchId)
			{
				return;
			}
		}
		scanner.close();
	} while (this.managerId != searchId);
};

public void PrintfManager()//вывод всех записей
{
	if (this.managerId != 0) {
		System.out.printf("|%-3d", this.managerId);
		System.out.printf("|%-25s", this.fio);
		System.out.printf("|%-25s", this.adress);
		System.out.printf("|%-10d|", this.salary);
		System.out.printf("\n");
	}
	else {
		Lib.PrintfLine(68);
		System.out.println("|                            NOT FOUND                            |\n");
		Lib.PrintfLine(68);
	}
	return;

}

public void PrintfFromFileManager(String fileName) throws FileNotFoundException
{
	File f = new File(fileName);

	if (f.isFile()) {
		Lib lib = new Lib();
		if (lib.CountFillFile(fileName)>0) {
			Scanner scanner = new Scanner(f);
			PrintfTitleManager();
			while (scanner.hasNextLine()) {
				this.FscanfManager(scanner);
				this.PrintfManager();
			}
			Lib.PrintfLine(68);
			scanner.close();
		}
		else Lib.PrintfNullS();
		
	}
}

public void PrintfTitleManager() {
	Lib.PrintfLine(68);
	System.out.printf("| № |           ФИО           |          Адрес          |  Ставка  |\n");
	Lib.PrintfLine(68);
}

public boolean SearchManager(String find)
{
	String id = Integer.toString(this.managerId);
	if (id.contains(find)) return true;
	if (this.fio.indexOf(find) != -1) return true;
	if (this.adress.indexOf(find) != -1) return true;
	String salary = Integer.toString(this.salary);
	if (salary.contains(find)) return true;
	return false;
}

void FscanfManagerOT(String id, String fio, String adress, String salary)
{
	this.managerId = Integer.parseInt(id.trim());
	this.fio.delete(0, this.fio.length());
	this.fio.insert(0, fio);
	this.adress.delete(0, this.adress.length());
	this.adress.insert(0, fio);
	this.salary = Integer.parseInt(salary.trim());
	return;
}

}
