package com.main;
import java.io.*;
import com.libr.*;
import com.libr.Service;


class PCClub {

	public static void main(String[] args) throws FileNotFoundException
	{
		Lib lib = new Lib();
		String path1 = "OrderTable.txt";
		int count = lib.CountFillFile(path1);
		System.out.println(count);
		PC pc = new PC(1,  "Виталик");
		Service service = new Service(1, "123", 1);
		Client client = new Client(1, "123");
		Manager manager = new Manager(1, "123", "123", 2100);
		//OrderTable orderTable = new OrderTable(1, pc, "12:00", "13:00", service, client, 125, manager);
		OrderTable orderTable = new OrderTable();
		/*orderTable.ScanfOrderTable();
		orderTable.PrintfOrderTable();*/
		orderTable.PrintfFromFileOrderTable("OrderTable.txt");

		/*Service service = new Service(lib.CountFillFile("Service.txt"), "Виталик", 12);
		service.PrintfService();
		service.ScanfService();
		System.out.println(service.GetName());
		service.FprintfService("Service.txt", "");
		service.PrintfFromFileService("Service.txt");
		service.SearchService();
		service.PrintfService();*/
		return;
	}
		
}
