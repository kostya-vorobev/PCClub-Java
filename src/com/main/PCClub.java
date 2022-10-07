package com.main;
import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import com.libr.*;
import com.libr.Service;


class PCClub {

	public static void main(String[] args) throws FileNotFoundException, java.io.IOException
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
				System.out.print("\033[H\033[2J");  
				System.out.flush(); 
				System.out.printf("	Программный модуль учета клиентов компьютерного клуба\n\n");
				System.out.printf("	1 - Ввод данных\n");
				System.out.printf("	2 - Вывод списка\n");
				System.out.printf("	6 - выход\n");
				
				switch (scanner.nextInt()) {
				case 1: {
					System.out.print("\033[H\033[2J");  
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
						System.out.print("\033[H\033[2J");
						manager.FprintfManager("Manager.txt", "\n");
						break;
					}
					case 2: { //Ввод данных
						System.out.print("\033[H\033[2J");
						client.FprintfClient("Client.txt", "\n");
						break;
					}
					case 3: { //Ввод данных
						System.out.print("\033[H\033[2J");
						service.FprintfService("Service.txt", "\n");
						break;
					}
					case 4: { //Ввод данных
						System.out.print("\033[H\033[2J");
						pc.FprintfPC("PC.txt", "\n");
						break;
					}
					case 5: { //Ввод данных
						objOrderTable.FprintfOrderTable("OrderTable.txt");
						System.out.print("\033[H\033[2J");
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
					System.out.print("\033[H\033[2J");//Главнео меню
					System.out.printf("	Вывод данных\n\n");
					System.out.printf("	1 - Вывод данных о менеджерах\n");
					System.out.printf("	2 - Вывод данных о клиентах\n");
					System.out.printf("	3 - Вывод данных об услугах\n");
					System.out.printf("	4 - Вывод данных о компьютерах\n");
					System.out.printf("	5 - Вывод данных дата центра\n");
					System.out.printf("	6 - выход\n");
					switch (scanner.nextInt()) {
					case 1: { //Ввод данных
						System.out.print("\033[H\033[2J");
						manager.PrintfFromFileManager("Manager.txt");
						break;
					}
					case 2: { //Ввод данных
						System.out.print("\033[H\033[2J");
						client.PrintfFromFileClient("Client.txt");
						break;
					}
					case 3: { //Ввод данных
						System.out.print("\033[H\033[2J");
						service.PrintfFromFileService("Service.txt");
						break;
					}
					case 4: { //Ввод данных
						System.out.print("\033[H\033[2J");
						pc.PrintfFromFilePC("PC.txt");
						break;
					}
					case 5: { //Ввод данных
						System.out.print("\033[H\033[2J");
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
			System.out.print("\033[H\033[2J");
			// вывод результата
			
			// вывод результата
			System.out.printf("Для завершения ввода слов нажмите 6\n Для повторного ввода нажмите любую клавишу... \n");
			int scan = scanner.nextInt();
		} while (scanner.nextInt() != 6);
		Runtime.getRuntime().exec("pause");
		return;
	}
		
}
