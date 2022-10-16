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
		PC pc = new PC(1,  "�������");
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
				System.out.flush(); 
				System.out.printf("	����������� ������ ����� �������� ������������� �����\n\n");
				System.out.printf("	1 - ���� ������\n");
				System.out.printf("	2 - ����� ������\n");
				System.out.printf("	6 - �����\n");
				
				switch (scanner.nextInt()) {
				case 1: { 
					System.out.flush(); 
					System.out.printf("	���� ������\n\n");
					System.out.printf("	1 - ���� ������ � ����������\n");
					System.out.printf("	2 - ���� ������ � ��������\n");
					System.out.printf("	3 - ���� ������ �� �������\n");
					System.out.printf("	4 - ���� ������ � �����������\n");
					System.out.printf("	5 - ���� ������ ���� ������\n");
					System.out.printf("	6 - �����\n");
					switch (scanner.nextInt()) {
					case 1: { //���� ������
						manager.FprintfManager("Manager.txt", "\n");
						break;
					}
					case 2: { //���� ������
						client.FprintfClient("Client.txt", "\n");
						break;
					}
					case 3: { //���� ������
						service.FprintfService("Service.txt", "\n");
						break;
					}
					case 4: { //���� ������
						pc.FprintfPC("PC.txt", "\n");
						break;
					}
					case 5: { //���� ������
						objOrderTable.FprintfOrderTable("OrderTable.txt");
						break;
					}
					case 6: //�����
						break;
					default:
						System.out.printf("\n�� �������, ��� �� ������ �������\n");
						break;
					}
					break;
				}
				case 2: {
					System.out.printf("	����� ������\n\n");
					System.out.printf("	1 - ����� ������ � ����������\n");
					System.out.printf("	2 - ����� ������ � ��������\n");
					System.out.printf("	3 - ����� ������ �� �������\n");
					System.out.printf("	4 - ����� ������ � �����������\n");
					System.out.printf("	5 - ����� ������ ���� ������\n");
					System.out.printf("	6 - �����\n");
					switch (scanner.nextInt()) {
					case 1: { //���� ������
						manager.PrintfFromFileManager("Manager.txt");
						break;
					}
					case 2: { //���� ������
						client.PrintfFromFileClient("Client.txt");
						break;
					}
					case 3: { //���� ������
						service.PrintfFromFileService("Service.txt");
						break;
					}
					case 4: { //���� ������
						pc.PrintfFromFilePC("PC.txt");
						break;
					}
					case 5: { //���� ������
						objOrderTable.PrintfFromFileOrderTable("OrderTable.txt");
	
						break;
					}
					case 6: //�����
						break;
					default:
						System.out.printf("\n�� �������, ��� �� ������ �������\n");
						
						break;
					}
				}
				case 6: //�����
					flag = 1;
				}
			} while (flag != 1);
			// ����� ����������
			
			// ����� ����������
			System.out.printf("��� ���������� ����� ���� ������� 6\n ��� ���������� ����� ������� ����� �������... \n");
			int scan = scanner.nextInt();
		} while (scanner.nextInt() != 6);
		Runtime.getRuntime().exec("pause");
		return;
	}
		
}
