package com.libr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.Scanner;

public class Lib {
	
	public static int sizeString = 49;

	public static int CountFillFile(String path) throws FileNotFoundException
	{
		int count = 1;
		File f = new File(path);
		Scanner scanner = new Scanner(f);
		while(scanner.hasNextLine())
		{
			scanner.nextLine();
			count++;
		}
		scanner.close();
		return count;

	}

	public static void PrintfLine(int count) {
		for (int i = 0; i < count; i++)
			System.out.printf("-");
		System.out.printf("\n");
	}

	public static void PrintfNullS() {
		PrintfLine(20);
		//PrintfUPS();
		PrintfLine(20);
		System.out.println("|������� �� �������|\n");
		PrintfLine(20);
	}

	public static void InputString(StringBuffer path,  String msg, int size)//���� �������
	{
		Scanner input = new Scanner(System.in, "cp866");
		do {
			System.out.println(msg);
			path.delete(0, path.length());
			path.insert(0, input.nextLine());
			System.out.println(path);

			if (path.length() < 2 || path.length() > sizeString)
				System.out.println("������ �����, ���������� ��� ���...\n"); // ������� ��������� �� ������
		} while (path.length() < 2|| path.length() > sizeString);
		return;
	}

	public static boolean IsName(StringBuffer path) {
		int flag = 0;
		for (int i = 0; i < path.length(); i++)
		{
			if (path.charAt(i) == ' ') flag = 1;
			if (path.charAt(i) != '.' && path.charAt(i) != ' ')
				if (!(path.charAt(i) < '�' || path.charAt(i) > '�')) {}
				else if ((path.charAt(i) < '�' || path.charAt(i) > '�')) {
					System.out.println("������ �����, ���������� ��� ���...\n"); // ������� ��������� �� ������
					return false;
				}
		}
		if (flag == 0) return false;
		return true;
	}

	public static boolean isNumeric(String string) { 
		int intValue; 
		
		if(string == null || string.equals("")) { 
		System.out.println("������ �����, ���������� ��� ���...\n"); 
		return false; 
		} 
		
		try { 
		intValue = Integer.parseInt(string); 
		return true; 
		} catch (NumberFormatException e) { 
		System.out.println("������ �����, ���������� ��� ���...\n"); 
		} 
		return false; 
	}

	//������� ����� �����
	public static int Get_int(String msg) {
		 // ������ ��� ������
		int n = -1; 
		Scanner input2 = new Scanner(System.in);
			boolean run = true;
			while (run) {
				System.out.print(msg);
				String inputText = input2.next();
				if (inputText.equals("exit"))
					System.exit(-1);
				try {
					n = Integer.parseInt(inputText);
					run = false;
				}catch (NumberFormatException e){
					System.out.println("������: " + e.getLocalizedMessage());
				
			}
			}
		return n; // ���������� ���������� ����� �����
	}

	public static boolean IsWord(StringBuffer path) {
		for (int i = 0; i < path.length(); i++)
		{
			if (path.charAt(i) != ' '&& path.charAt(i) != ' ')
			if (!(path.charAt(i) < '�' || path.charAt(i) > '�')) {}
				else if ((path.charAt(i) < '�' || path.charAt(i) > '�')) {
					System.out.println("������ �����, ���������� ��� ���...\n"); // ������� ��������� �� ������
					return false;
				}
		}
		return true;
	}

	

	/*
	void trim(String path)
	{
		// ������� ������� � ���� � ������ ������:
		int i = 0, j;
		while ((s[i] == ' ') || (s[i] == '\t'))
		{
			i++;
		}
		if (i > 0)
		{
			for (j = 0; j < strlen(path); j++)
			{
				s[j] = s[j + i];
			}
			s[j] = '\0';
		}

		// ������� ������� � ���� � ����� ������:
		i = strlen(path) - 1;
		while ((s[i] == ' ') || (s[i] == '\t'))
		{
			i--;
		}
		if (i < (strlen(path) - 1))
		{
			s[i + 1] = '\0';
		}
	}

	



	


	

	bool IsWord(String path) {
		for (int i = 0; i < strlen(path); i++)
		{
			if (s[i] != '.' && s[i] != ' ')
				if (!(s[i] < '�' || s[i] > '�')) {}
				else if ((s[i] < '�' || s[i] > '�')) {
					System.out.println("������ �����, ���������� ��� ���...\n"); // ������� ��������� �� ������
					return false;
				}
		}
		return true;
	}

	bool IsFillFile(String path)
	{
		File f = new File(path);
		f = fopen(s, "r");
		int i = 0;
		while (!feof(f))
		{
			fscanf(f, "%[^\n]%c");
			i++;
		}
		if (i == 0) {
			//System.out.println("���� ������\n");
			fclose(f);
			return false;
		}
		fclose(f);
		return true;
	}




	*/
}