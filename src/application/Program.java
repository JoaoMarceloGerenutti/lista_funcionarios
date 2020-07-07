package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Integer id;
		String nome;
		Double salario;
		
		System.out.print("Quantos funcionarios vão ser registrados? ");
		int quantidadeFuncionario = sc.nextInt();
		
		List<Employee> lista = new ArrayList<>();
		
		for (int i=1; i<=quantidadeFuncionario; i++) {
			
			System.out.println("Funcionario #" + i);
			
			System.out.print("Id: ");
			id = sc.nextInt();
			while (hasId(lista, id)) {
				System.out.print("Id ja em uso. Tente novamente: ");
				id = sc.nextInt();
			}
			
			System.out.print("Nome: ");
			sc.nextLine();
			nome = sc.nextLine();
			
			System.out.print("Salario: ");
			salario = sc.nextDouble();
			
			lista.add(new Employee(id, nome, salario));
			System.out.println();
		}
		
		System.out.print("Digite o id do funcionario que ganhara um aumento: ");
		int idAumento = sc.nextInt();
		Employee fun = lista.stream().filter(filtro -> filtro.getId() == idAumento).findFirst().orElse(null);
		
		if (fun == null) {
			System.out.println("Esse ID não existe!");
		} else {
			System.out.print("Entre com a porcentagem do aumento: ");
			double porcentagem = sc.nextDouble();
			fun.aumentarSalario(porcentagem);
		}
		System.out.println();
		
		System.out.println("Lista de funcionarios: ");
		for (Employee listaFinal : lista) {
			System.out.print(listaFinal);
		}
		sc.close();
	}
	
	public static boolean hasId(List<Employee> lista, int idAumento) {
		Employee fun = lista.stream().filter(filtro -> filtro.getId() == idAumento).findFirst().orElse(null);
		return fun != null;
	}


}
