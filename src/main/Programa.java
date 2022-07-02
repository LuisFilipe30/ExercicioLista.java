package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Funcionario;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List <Funcionario> funcionario = new ArrayList <> ();
		
		System.out.print("Quantos funcionários serão registrados? ");
		int n = sc.nextInt();
		System.out.println();
		
		for(int i=0; i<n; i++) {
			System.out.println("Funcionário #" + i+1 + ":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salário: ");
			double salario = sc.nextDouble();
			System.out.println();
			
			funcionario.add(new Funcionario(id, nome, salario));
		}
		
		System.out.print("Digite o id do funcionário que recerá aumento salarial: ");
		int id = sc.nextInt();
		Funcionario emp = funcionario.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(emp == null) {
			System.out.println("Esse id não existe!");
		}
		else {
			System.out.print("Digite a porcentagem do aumento: ");
			double porcentagem = sc.nextDouble();
			emp.aumentoSalarial(porcentagem);
		}
		
		System.out.println();
		System.out.println("Lista de funcionários:");
		for(Funcionario x : funcionario) {
			System.out.println(x);
		}
		
		
		
		
		sc.close();
	}

}
