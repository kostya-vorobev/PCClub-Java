package com.libr;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Account<T>
{
    private T id;
    public Account(T id) { this.id = id; }
    public Account() { }
    public T GetId() {return id;}
};