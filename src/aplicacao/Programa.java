package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.Departamento;
import entidade.Trabalhador;
import entidadeEnum.LevelTrabalhador;


public class Programa {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		Trabalhador trabalhador;
		
		System.out.print("Departamento: ");
		String departamento = sc.nextLine();
		System.out.println("Dados do trabalhador");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.println("Level: ");
		String level = sc.nextLine();
		System.out.print("Base salarial: ");
		double salarioBase = sc.nextDouble();
		trabalhador = new Trabalhador (nome, LevelTrabalhador.valueOf(level),salarioBase, new Departamento(departamento));

		
		System.out.print("Quantos contratos esse trabalhador ira ter?: ");
		int x = sc.nextInt();
		for (int i =1; i<=x; i++) {
			System.out.println("Entre com os dados do contrato #"+i);
			System.out.print("Data (DD/MM/YYYY): ");
			Date cDate = sdf.parse(sc.next());
			
		}
		
		
		
		
		
		
		
		sc.close();		

	}	

}
