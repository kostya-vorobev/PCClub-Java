package com.libr;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

import com.libr.*;

public class OrderTable{

	private int orderTableId;
	private Manager manager = new Manager(0, "", "", 0);
	private PC pc = new PC(0, "");
	private Service service = new Service(0, "", 0);
	private Client client = new Client(0, "");
	private StringBuffer startTime = new StringBuffer();
	private StringBuffer finishTime = new StringBuffer();
	private int cost;
	
public OrderTable()
{
	
}
public OrderTable(int id, PC pcData, String startTime, String finishTime, Service servicesData, Client clientData, int cost, Manager managerData)
{
	this.orderTableId = id;
	this.pc.CopyPC(pcData);
	if(this.startTime.length()>0){
	this.startTime.delete(0, this.startTime.length());
	this.startTime.insert(0, startTime);
	}
	else{
		this.startTime.insert(0, startTime);
	}
	if(this.finishTime.length()>0){
		this.finishTime.delete(0, this.finishTime.length());
		this.finishTime.insert(0, finishTime);
	}
	else{
		this.finishTime.insert(0, finishTime);
	}
	this.service.CopyService(servicesData);
	this.client.CopyClient(clientData);
	this.cost = cost;
	this.manager.CopyManager(managerData);
}

public int GetIDOrderTable()
{
	return this.orderTableId;
}

public String GetStartTime()
{
	return this.startTime.toString();
}

public String GetFinishTime()
{
	return this.finishTime.toString();
}

public int GetCost()
{
	return this.cost;
}

public Service GetSevice()
{
	return this.service;
}

public PC GetPC()
{
	return this.pc;
}

public Client GetClient()
{
	return this.client;
}

public Manager GetManager()
{
	return this.manager;
}

public void SetService(Service service)
{
	this.service.CopyService(service);
}

public void SetClient(Client client)
{
	this.client.CopyClient(client);
}

public void SetManager(Manager manager)
{
	this.manager.CopyManager(manager);
}

public void SetPC(PC pc)
{
	this.pc.CopyPC(pc);
}

public void SetIDOrderTable(int id)
{
	this.orderTableId = id;
}

public void SetStartTime(String time)
{
	this.startTime.delete(0, this.startTime.length());
	this.startTime.insert(0, time);
}

public void SetFinishTime(String time)
{
	this.finishTime.delete(0, this.finishTime.length());
	this.finishTime.insert(0, time);
}

public void SetCost(int cost)
{
	this.cost = cost;
}

public void FprintfOrderTable(String fileName)
{
	File f = new File(fileName);

		if (!f.isFile()) {
			try{
			if (f.createNewFile())	System.out.println("File created");
			else {System.out.println("File already exists");
				return;}
			}
			catch(final IOException ex)	{System.out.println(ex.getMessage());};
		}
		if (f.isFile() && this.orderTableId != 0) {
			try(FileWriter fileWriter = new FileWriter(fileName,true);)
        {
			fileWriter.write(this.orderTableId + " ;");
			fileWriter.write(this.pc.GetidPC() + " ;");
			fileWriter.write(this.pc.GetTypePC() + " ;");
			fileWriter.write(this.startTime + " ;");
			fileWriter.write(this.finishTime + " ;");
			fileWriter.write(this.service.GetIDService() + " ;");
			fileWriter.write(this.service.GetName() + " ;");
			fileWriter.write(this.service.GetTariff() + " ;");
			fileWriter.write(this.client.GetIDClient() + " ;");
			fileWriter.write(this.client.GetFIOClient() + " ;");
			fileWriter.write(this.cost + " ;");
			fileWriter.write(this.manager.GetIDManager() + " ;");
			fileWriter.write(this.manager.GetFIOManager() + " ;");
			fileWriter.write(this.manager.GetAdress() + " ;");
			fileWriter.write(this.manager.GetSalary() + " \n");
			fileWriter.flush();
		}
		catch(final IOException ex) {System.out.println(ex.getMessage());};
	}
}

public void PrintfOrderTable()//РІС‹РІРѕРґ РІСЃРµС… Р·Р°РїРёСЃРµР№
{
	if (this.orderTableId != 0) {
		System.out.printf("|%-3d", this.orderTableId);
		System.out.printf("|%-25s", this.client.GetFIOClient());
		System.out.printf("|%-25s", this.pc.GetTypePC());
		System.out.printf("|%-12s", this.startTime);
		System.out.printf("|%-10s", this.finishTime);
		System.out.printf("|%-10d", this.cost);
		System.out.printf("|%-25s", this.service.GetName());
		System.out.printf("|%-25s|", this.manager.GetFIOManager());
		System.out.printf("\n");
	}
	else {
		Lib.PrintfLine(144);
		String msg = new String();
		msg = "NOT FOUND";
		System.out.printf("|%142s|\n", msg);
		Lib.PrintfLine(144);
	}
	return;

}

public void PrintfFromFileOrderTable(String fileName) throws FileNotFoundException
{
	File f = new File(fileName);

	if (f.isFile()) {
		Lib lib = new Lib();
		if (lib.CountFillFile(fileName)>0) {
			Scanner scanner = new Scanner(f);
			PrintfTitleOrderTable();
			while (scanner.hasNextLine()) {
				this.FscanfOrderTable(scanner);
				this.PrintfOrderTable();
			}
			Lib.PrintfLine(144);
			scanner.close();
		}
		else Lib.PrintfNullS();
		
	}
}

public void ScanfOrderTable() throws FileNotFoundException
 {

	this.orderTableId = Lib.CountFillFile("OrderTable.txt");
	this.pc.PrintfFromFilePC("PC.txt");
	if (Lib.CountFillFile("PC.txt") >= 1)
		this.pc.SearchPC();
	else {
		this.pc.ScanfPC();
		this.pc.FprintfPC("PC.txt", "\n");
	}
	Lib.InputString(this.startTime, "Введите время начала аренды: : ", 9);
	Lib.InputString(this.finishTime, "Введите время конца аренды: ", 9);
	this.service.PrintfFromFileService("Service.txt");
	if (Lib.CountFillFile("Service.txt") >= 1)
		this.service.SearchService();
	else {
		this.service.ScanfService();
		this.service.FprintfService("Service.txt", "\n");
	}

	this.client.PrintfFromFileClient("Client.txt");
	if (Lib.CountFillFile("Client.txt") >= 1)
		this.client.SearchClient();
	else {
		this.client.ScanfClient();
		this.client.FprintfClient("Client.txt", "\n");
	}
	do {
		this.cost = Lib.Get_int("Введите стоимость аренды: ");
	} while (this.cost <= 1);
	this.manager.PrintfFromFileManager("Manager.txt");
	if (Lib.CountFillFile("Manager.txt") >= 1)
	this.manager.SearchManager();
	else {
		this.manager.ScanfManager();
		this.manager.FprintfManager("Manager.txt", "\n");
	}
}

public void FscanfOrderTable(Scanner scanner)
{
	String line = scanner.nextLine();
	//System.out.System.out.printf(line);
	String[] words = line.split(" ;");
	this.orderTableId = Integer.parseInt(words[0]);
	this.pc.FscanfPCOT(words[1], words[2]);
	this.startTime.delete(0, this.startTime.length());
	this.startTime.insert(0, words[3]);
	this.finishTime.delete(0, this.finishTime.length());
	this.finishTime.insert(0, words[4]);
	this.service.FscanfServiceOT(words[5], words[6], words[7]);
	this.client.FscanfClientOT(words[8], words[9]);
	this.cost = Integer.parseInt(words[10].trim());
	this.manager.FscanfManagerOT(words[11], words[12], words[13], words[14]);
}

public void PrintfTitleOrderTable() {
	Lib.PrintfLine(144);
	String words[] = {" № ", "ФИО клиента", "Тип ПК", "Время взятия", "Время сдачи", "Стоимость", "Услуга", "ФИО менеджера"};
	System.out.printf("|%-3s|%-25s|%-25s|%-12s|%-10s|%-10s|%-25s|%-25s|\n", words[0], words[1], words[2], words[3], words[4], words[5], words[6], words[7] );
	Lib.PrintfLine(144);
}

public boolean SearchOrderTable(String find)
{
	String id = Integer.toString(this.orderTableId);
	if (id.contains(find)) return true;
	if (this.pc.SearchPC(find)) return true;
	if (this.startTime.indexOf(find) != -1) return true;
	if (this.finishTime.indexOf(find) != -1) return true;
	if (this.service.SearchService(find)) return true;
	if (this.client.SearchClient(find)) return true;
	String cost = Integer.toString(this.cost);
	if (cost.contains(find)) return true;
	if (this.manager.SearchManager(find)) return true;
	return false;
}

}