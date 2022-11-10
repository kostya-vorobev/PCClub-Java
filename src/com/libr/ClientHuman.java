package com.libr;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

import com.libr.Client;
import com.libr.Account;

public class ClientHuman extends Client implements Cloneable
{

    protected int gender;
    protected int age;
    private int sizeLine;
    protected Account<String> acc;

public ClientHuman()
{
    super();
	this.gender = 0;
	this.age = 0;
	this.sizeLine = 44;
}

public ClientHuman clone() throws CloneNotSupportedException {
	ClientHuman obj = (ClientHuman)super.clone();
	return obj;
}

public ClientHuman(int id, String name, int gender, int age, String acc)
{
    super(id, name);
	this.gender = gender;
	this.age = age;
	this.sizeLine = 44;
	this.acc = new Account<String>(acc);
}

public String GetAcc() {
	return acc.GetId();
}
public void SetAcc(String acc) {
	this.acc = new Account<String>(acc);
}

public void ScanfClient() throws FileNotFoundException{
	super.ScanfClient();
	do {
		this.gender = Lib.Get_int("Введите пол клиента \n 1 - муж.\n 2 - жен\n: ");
	} while (this.gender < 1 || this.gender > 2);
	do {
		this.age = Lib.Get_int("Введите возрвст клиента: ");
	} while (this.age <= 0);

}

public void SetAge(int age)
{
	this.age = age;
}

public void SetGender(int gender)
{
	this.gender = gender;
}

public void PrintfClient()
{
	if (this.clientId != 0) {
        System.out.printf("|%-3d", this.clientId);
        System.out.printf("|%-25s|", this.fio.toString());
        System.out.printf("|%-3s|", this.gender);
        System.out.printf("|%-7s|", this.age);
        System.out.printf("\n");
	}
	else {
        Lib.PrintfLine(this.sizeLine);
        System.out.println("|          NOT FOUND           |\n");
        Lib.PrintfLine(this.sizeLine);
	}
	return;

}

public void PrintTitle() {

    Lib.PrintfLine(this.sizeLine);
    System.out.println("| № |           ФИО           |Пол|Возраст|");
    Lib.PrintfLine(this.sizeLine);
}


	@Override
	public String toString() {
		return "ClientHuman{" +
				"gender=" + gender +
				", age=" + age +
				", sizeLine=" + sizeLine +
				", acc=" + acc.toString() +
				", clientId=" + clientId +
				", fio='" + fio + '\'' +
				'}';
	}

	@Override
	public Comparator<Client> reversed() {
		return super.reversed();
	}
}