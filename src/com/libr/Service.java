package com.libr;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

import com.libr.Lib;

public class Service {

	private int serviceId;
	private StringBuffer name = new StringBuffer();
	private int tariff;

	public  Service(int id, String name, int tariff)
{
	this.serviceId = id;
	if(this.name.length()>0){
	this.name.delete(0, this.name.length());
	this.name.insert(0, name);
	}
	else{
		this.name.insert(0, name);
	}
	this.tariff = tariff;
}

public void CopyService(Service objService)
{
	this.serviceId = objService.serviceId;
	this.name.delete(0, this.name.length());
	this.name.insert(0, objService.name);
	this.tariff = objService.tariff;
}

public int GetIDService()
{
	return this.serviceId;
}

public String GetName()
{
	return this.name.toString();
}

public int GetTariff()
{
	return this.tariff;
}

public void SetIDService(int ID)
{
	this.serviceId = ID;
}

public void SetName(String newName[])
{
	this.name.delete(0, this.name.length());
	this.name.insert(0, newName);
}

public void SetTariff(int newTariff)
{
	this.tariff = newTariff;
}

public void FprintfService(String fileName, String endString)
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
		if (f.isFile() && this.serviceId != 0) {
			try(FileWriter fileWriter = new FileWriter(fileName,true);)
        {
			
			fileWriter.write(this.serviceId + " ;");
			fileWriter.write(this.name + " ;");
			fileWriter.write(this.tariff + " \n");
			fileWriter.flush();
		}
		catch(final IOException ex){
             
            System.out.println(ex.getMessage());
		} 
	}
}

public void ScanfService() throws FileNotFoundException {

	this.serviceId = Lib.CountFillFile("Service.txt");
	do {
		Lib.InputString(this.name, "Введите название услуги: ", 49);
		System.out.println(this.name);
	} while (!Lib.IsWord(this.name));
	do {
		this.tariff = Lib.Get_int("Введите стоимость услуги: ");
	} while (this.tariff <= 1);
}

public void FscanfService(Scanner scanner)
{
	String line = scanner.nextLine();
	//System.out.System.out.printf(line);
	String[] words = line.split(" ;");
	this.serviceId = Integer.parseInt(words[0]);
	this.name.delete(0, this.name.length());
	this.name.insert(0, words[1]);
	this.tariff = Integer.parseInt(words[2].trim());
}

public void PrintfService()//вывод всех записей
{
	if (this.serviceId != 0) {
		System.out.printf("|%-3d", this.serviceId);
		System.out.printf("|%-25s", this.name);
		System.out.printf("|%-10d|", this.tariff);
		System.out.printf("\n");
	}
	else {
		Lib.PrintfLine(42);
		System.out.println("|               NOT FOUND                |\n");
		Lib.PrintfLine(42);
	}
	return;
}

public void PrintfFromFileService(String fileName) throws FileNotFoundException
{
	File f = new File(fileName);

	if (f.isFile()) {
		Lib lib = new Lib();
		if (lib.CountFillFile(fileName)>0) {
			Scanner scanner = new Scanner(f);
			PrintfTitleService();
			while (scanner.hasNextLine()) {
				this.FscanfService(scanner);
				this.PrintfService();
			}
			Lib.PrintfLine(42);
			scanner.close();
		}
		else Lib.PrintfNullS();
		
	}

}

public void SearchService() throws FileNotFoundException
{
	int searchId = 0;
	do {
		searchId = Lib.Get_int("Введите id менеджера: ");
		//searchId = 1;
		File findInFile = new File("Service.txt");
		Scanner scanner = new Scanner(findInFile);
		while (scanner.hasNextLine())
		{
			this.FscanfService(scanner);
			if (this.serviceId == searchId)
			{
				return;
			}
		}
		scanner.close();
	} while (this.serviceId != searchId);

}

public boolean SearchService(String find)
{
	String id = Integer.toString(this.serviceId);
	if (id.contains(find)) return true;
	if (this.name.indexOf(find) != -1) return true;
	String tariff = Integer.toString(this.tariff);
	if (tariff.contains(find)) return true;
	return false;

}

public void PrintfTitleService() {
	Lib.PrintfLine(42);
	System.out.printf("| № |        Название         |  Тариф   |\n");
	Lib.PrintfLine(42);
}


public void FscanfServiceOT(String id, String name, String tariff)
{
	this.serviceId = Integer.parseInt(id.trim());
	this.name.delete(0, this.name.length());
	this.name.insert(0, name);
	this.tariff = Integer.parseInt(tariff.trim());
	return;
}

}