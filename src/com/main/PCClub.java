package com.main;
import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import com.libr.*;
import com.libr.Service;


class PCClub {


	public static void main(String[] args) throws FileNotFoundException, java.io.IOException
	{
        Client client=new Client(1,"Mike");
        ClientHuman clientHuman=new ClientHuman(1,"Mike", 1, 15, "1235");
		try{
        	Client clone = (Client) client.clone();
			client.PrintfClient();
			clone.PrintfClient();
			client.SetFio("Ivan");
			clone.SetIDClient(2);
			client.PrintfClient();
			clone.PrintfClient();
		} catch(CloneNotSupportedException e){
			e.printStackTrace();
		}

		try{
        	ClientHuman clone = (ClientHuman) clientHuman.clone();
			clientHuman.PrintfClient();
			clone.PrintfClient();
			clientHuman.SetFio("Ivan");
			clone.SetAcc("52434");
			clientHuman.PrintfClient();
			clone.PrintfClient();
		} catch(CloneNotSupportedException e){
			e.printStackTrace();
		}


		Lib lib = new Lib();
		String path1 = "OrderTable.txt";
		int count = lib.CountFillFile(path1);
		System.out.println(count);
		PC pc = new PC(1,  "Виталик");
		PC pc2[] = new PC[2];
		pc2[0] = new PC(2, "Андрей");
		pc2[1] = new PC(3, "Евгений");
		Service service = new Service(1, "123", 1);
		//Client client = new Client(1, "123");
		Manager manager = new Manager(1, "123", "123", 2100);
		//OrderTable orderTable = new OrderTable(1, pc, "12:00", "13:00", service, client, 125, manager);
		OrderTable objOrderTable = new OrderTable();
		int flag = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			do {
				Manager[] managerTest = new Manager[2];
				for (int i = 0; i < 2; i++)
				{
					String s = "123";
					managerTest[i] = new Manager(i+1, "123", s, i);
				}
				flag = 0;
				Client[] clientTest = new Client[2];
				for (int i = 0; i < 2; i++)
				{
					String s = "123";
					clientTest[i] = new Client(i, s);
				} 
				System.out.flush(); 
				System.out.printf("	Программный модуль учета клиентов компьютерного клуба\n\n");
				System.out.printf("	1 - Ввод данных\n");
				System.out.printf("	2 - Вывод списка\n");
				System.out.printf("	6 - выход\n");
				
				switch (scanner.nextInt()) {
				case 1: { 
					System.out.flush(); 
					System.out.printf("	Ввод данных\n\n");
					System.out.printf("	1 - ввод данных о менеджерах\n");
					System.out.printf("	2 - ввод данных о клиентах\n");
					System.out.printf("	3 - ввод данных об услугах\n");
					System.out.printf("	4 - ввод данных о компьютерах\n");
					System.out.printf("	5 - ввод данных дата центра\n");
					System.out.printf("	6 - выход\n");
					switch (scanner.nextInt()) {
					case 1: { //Ввод данных
						manager.FprintfManager("Manager.txt", "\n");
						break;
					}
					case 2: { //Ввод данных
						client.FprintfClient("Client.txt", "\n");
						break;
					}
					case 3: { //Ввод данных
						service.FprintfService("Service.txt", "\n");
						break;
					}
					case 4: { //Ввод данных
						pc.FprintfPC("PC.txt", "\n");
						break;
					}
					case 5: { //Ввод данных
						objOrderTable.FprintfOrderTable("OrderTable.txt");
						break;
					}
					case 6: //Выход
						break;
					default:
						System.out.printf("\nНе понимаю, что вы хотите сделать\n");
						break;
					}
					break;
				}
				case 2: {
					System.out.printf("	Вывод данных\n\n");
					System.out.printf("	1 - Вывод данных о менеджерах\n");
					System.out.printf("	2 - Вывод данных о клиентах\n");
					System.out.printf("	3 - Вывод данных об услугах\n");
					System.out.printf("	4 - Вывод данных о компьютерах\n");
					System.out.printf("	5 - Вывод данных дата центра\n");
					System.out.printf("	6 - выход\n");
					switch (scanner.nextInt()) {
					case 1: { //Ввод данных
						manager.PrintfFromFileManager("Manager.txt");
						break;
					}
					case 2: { //Ввод данных
						client.PrintfFromFileClient("Client.txt");
						break;
					}
					case 3: { //Ввод данных
						service.PrintfFromFileService("Service.txt");
						break;
					}
					case 4: { //Ввод данных
						pc.PrintfFromFilePC("PC.txt");
						break;
					}
					case 5: { //Ввод данных
						objOrderTable.PrintfFromFileOrderTable("OrderTable.txt");
	
						break;
					}
					case 6: //Выход
						break;
					default:
						System.out.printf("\nНе понимаю, что вы хотите сделать\n");
						
						break;
					}
				}
				case 6: //Выход
					flag = 1;
				}
			} while (flag != 1);
			// вывод результата
			
			// вывод результата
			System.out.printf("Для завершения ввода слов нажмите 6\n Для повторного ввода нажмите любую клавишу... \n");
			int scan = scanner.nextInt();
		} while (scanner.nextInt() != 6);
		Runtime.getRuntime().exec("pause");
		return;
	}
		
}
