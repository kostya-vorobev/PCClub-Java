package com.libr;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

import com.libr.Lib;
public class PC{

	private int pcId;
	private StringBuffer typePC = new StringBuffer();

	public PC(int id, String typePC)
	{
		this.pcId = id;
		if(this.typePC.length()>0){
			this.typePC.delete(0, this.typePC.length());
			this.typePC.insert(0, typePC);
			}
			else{
				this.typePC.insert(0, typePC);
			}
	}

	public void CopyPC(PC objPC)
	{
		this.pcId = objPC.pcId;
		this.typePC.delete(0, this.typePC.length());
		this.typePC.insert(0, objPC.typePC);
	}

	public int GetidPC()
	{
		return this.pcId;
	}

	public String GetTypePC()
	{
		return this.typePC.toString();
	}

	public void SetidPC(int id)
	{
		this.pcId = id;
	}

	public void SetTypePC(String newTypePC[])
	{
		this.typePC.delete(0, this.typePC.length());
		this.typePC.insert(0, newTypePC);
	}

	public void FprintfPC(String fileName, String endString)
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
		if (f.isFile() && this.pcId != 0) {
			try(FileWriter fileWriter = new FileWriter(fileName,true);)
        {
			
			fileWriter.write(this.pcId + " ;");
			fileWriter.write(this.typePC + " \n");
			fileWriter.flush();
		}
		catch(final IOException ex){
             
            System.out.println(ex.getMessage());
		} 
	}

	}

	public void ScanfPC() throws FileNotFoundException
	{

		this.pcId = Lib.CountFillFile("Manager.txt");
		do {
			Lib.InputString(this.typePC, "Введите тип ПК: ", 49);
			System.out.println(this.typePC);
		} while (!Lib.IsWord(this.typePC));
	}

	public void FscanfPC(Scanner scanner) 
	{
		String line = scanner.nextLine();
		//System.out.System.out.printf(line);
		String[] words = line.split(" ;");
		this.pcId = Integer.parseInt(words[0]);
		this.typePC.delete(0, this.typePC.length());
		this.typePC.insert(0, words[1]);

	}

	public void PrintfPC()//вывод всех записей
	{
		if (this.pcId != 0) {
			System.out.printf("|%-3d", this.pcId);
			System.out.printf("|%-25s", this.typePC);
			System.out.printf("\n");
		}
		else {
			Lib.PrintfLine(68);
			System.out.println("|          NOT FOUND          |\n");
			Lib.PrintfLine(68);
		}
		return;
	}

	public void PrintfFromFilePC(String fileName) throws FileNotFoundException
	{
		File f = new File(fileName);

	if (f.isFile()) {
		Lib lib = new Lib();
		if (lib.CountFillFile(fileName)>0) {
			Scanner scanner = new Scanner(f);
			PrintfTitlePC();
			while (scanner.hasNextLine()) {
				this.FscanfPC(scanner);
				this.PrintfPC();
			}
			Lib.PrintfLine(32);
			scanner.close();
		}
		else Lib.PrintfNullS();
		
		}
	}


	public void SearchPC() throws FileNotFoundException
	{
		int searchId = 0;
		do {
			searchId = Lib.Get_int("Введите id ПК: ");
			//searchId = 1;
			File findInFile = new File("PC.txt");
			Scanner scanner = new Scanner(findInFile);
			while (scanner.hasNextLine())
			{
				this.FscanfPC(scanner);
				if (this.pcId == searchId)
				{
					return;
				}
			}
			scanner.close();
		} while (this.pcId != searchId);
	}

	public boolean SearchPC(String find)
	{
		String id = Integer.toString(this.pcId);
		if (id.contains(find)) return true;
		if (this.typePC.indexOf(find) != -1) return true;
		return false;
	}

	public void PrintfTitlePC() {
		Lib.PrintfLine(32);
		System.out.printf("| № |        Платформа        |\n");
		Lib.PrintfLine(32);
	}

	public void FscanfPCOT(String id, String typePC)
	{
		this.pcId = Integer.parseInt(id.trim());
		this.typePC.delete(0, this.typePC.length());
		this.typePC.insert(0, typePC);
		return;
	}
	
}