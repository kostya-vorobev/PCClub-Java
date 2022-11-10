package com.libr;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.lang.*;
import java.util.Vector;


public class Client implements IBase, Cloneable, Comparator<Client>
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

	public void FscanfClient(Scanner scanner) throws MyException
	{
		String line = scanner.nextLine();
		//System.out.printf(line);
		String[] words = line.split(" ;");
		if(words.length != 2) throw new MyException("Файл был поврежден");
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
		}catch(final IOException | MyException ex){
             
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
		}catch (IOException | MyException e) {
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

	public static void FscanfFile(Vector client, String fileName) throws FileNotFoundException
	{
		Client clientBuffer = new Client();
		try{
			File f = new File(fileName);
			if (f.isFile()) {
				Lib lib = new Lib();
				if (lib.CountFillFile(fileName)>0) {
					Scanner scanner = new Scanner(f);
					while (scanner.hasNextLine()) {
						clientBuffer.FscanfClient(scanner);
						client.add(clientBuffer.clone());
					}
					scanner.close();
				}
				else Lib.PrintfNullS();

			}
		}catch(final IOException | MyException ex){

			System.out.println(ex.getMessage());
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public int compare(Client lhs, Client rhs) {
		return -lhs.clientId+rhs.clientId;
	}

	public void InitClient(int id, String fio) {
		this.clientId = id;
		this.fio = new String(fio);
		return;
	}

	@Override
	public String toString() {
		return "Client{" +
				"clientId=" + clientId +
				", fio='" + fio + '\'' +
				'}';
	}
};

