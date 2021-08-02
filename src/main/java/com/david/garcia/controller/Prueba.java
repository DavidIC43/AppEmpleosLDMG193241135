package com.david.garcia.controller;

import java.util.Scanner;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int suma,no1,no2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingresa primer numero");
		no1 = sc.nextInt();
		System.out.println("Ingresa segundo numero");
		no2 = sc.nextInt();
		
		suma = no1 + no2;
		System.out.println("La suma es \n" + suma);

	}

}
