package com.libr;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.lang.*;

import com.libr.IBase;



public class Client implements IBase, Cloneable
{
	protected int clientId;
	protected String fio = new String();
		
	public Client()
	{

	}

	public Client(int id,  String fio)
	{
		this.clientId = id;
		this.fio = new String(fio);
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public void CopyClient(Client objClient)
	{
		this.clientId = objClient.clientId;
		this.fio = new String(objClient.fio);
	}

	public int GetIDClient()
	{
		return this.clientId;
	}

	public String GetFio()
	{
		return this.fio.toString();
	}

	public void SetIDClient(int id)
	{
		this.clientId = id;
	}

	public void SetFio(String fio)
	{
		this.fio = new String(fio);
	}

	public void FscanfClient(Scanner scanner)
	{
		String line = scanner.nextLine();
		//System.out.printf(line);
		String[] words = line.split(" ;");
		this.clientId = Integer.parseInt(words[0]);
		this.fio = new String(words[1]);
	}


	public void PrintTitle() {
		Lib.PrintfLine(32);
		System.out.println("| № |           ФИО           |");
		Lib.PrintfLine(32);
	}

	public void PrintfFromFileClient( String fileName) throws FileNotFoundException
	{
		try{
			File f = new File(fileName);

			if (f.isFile()) {
				Lib lib = new Lib();
				if (lib.CountFillFile(fileName)>0) {
					Scanner scanner = new Scanner(f);
					PrintTitle();
					while (scanner.hasNextLine()) {
						this.FscanfClient(scanner);
						this.PrintfClient();
					}
					Lib.PrintfLine(32);
					scanner.close();
				}
				else Lib.PrintfNullS();
				
			}
		}catch(final IOException ex){
             
            System.out.println(ex.getMessage());
		} 
	}

	public void PrintfClient()
	{
		if (this.clientId != 0) {
			System.out.printf("|%-3d", this.clientId);
			System.out.printf("|%-25s|", this.fio.toString());
			System.out.printf("\n");
		}
		else {
			Lib.PrintfLine(32);
			System.out.println("|          NOT FOUND           |\n");
			Lib.PrintfLine(32);
		}
		return;
	}

	public void FprintfClient( String fileName,  String endString)
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
		if (f.isFile() && this.clientId != 0) {
			try(FileWriter fileWriter = new FileWriter(fileName,true);)
        {
			
			fileWriter.write(this.clientId + " ;");
			fileWriter.write(this.fio + " \n");
			fileWriter.flush();
		}
		catch(final IOException ex){
             
            System.out.println(ex.getMessage());
		} 
	}
}

	public void ScanfClient() throws FileNotFoundException
	{
		try{
		this.clientId = Lib.CountFillFile("Client.txt");
		do {
			Lib.InputString(this.fio, "Введите ФИО клиента: ");
			System.out.println(this.fio);
		} while (!Lib.IsName(this.fio));
		}catch (IOException e) {
            System.out.println(e.getMessage());
		}

	}

	public void SearchClient() throws FileNotFoundException
	{
		try{
			int searchId = 0;
			do {
				searchId = Lib.Get_int("Введите id клиента: ");
				//searchId = 1;
				File findInFile = new File("Client.txt");
				Scanner scanner = new Scanner(findInFile);
				while (scanner.hasNextLine())
				{
					this.FscanfClient(scanner);
					if (this.clientId == searchId)
					{
						return;
					}
				}
				scanner.close();
			} while (this.clientId != searchId);
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	};



	public boolean SearchClient( String find)
	{
		String ch = Integer.toString(this.clientId);
		if (ch.indexOf(find) != -1) return true;
		if (this.fio.indexOf(find)!=-1) return true;
		return false;
	}



	public void FscanfClientOT(String id, String fio)
	{
		this.clientId = Integer.parseInt(id.trim());
		this.fio = new String(fio);
		return;
	}


};

