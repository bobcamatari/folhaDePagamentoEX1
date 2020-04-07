package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.Departamento;
import entidade.HoraContrato;
import entidade.Trabalhador;
import entidadeEnum.LevelTrabalhador;


public class Programa {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		SimpleDateFormat sdf2 = new SimpleDateFormat ("MM/yyyy");
		Trabalhador trabalhador;
		
		System.out.print("Departamento: ");
		String departamento = sc.nextLine();
		System.out.println("Dados do trabalhador");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base salarial: R$");
		double salarioBase = sc.nextDouble();
		trabalhador = new Trabalhador (nome, LevelTrabalhador.valueOf(level),salarioBase, new Departamento(departamento));

		
		System.out.print("Quantos contratos esse trabalhador ira ter?: ");
		int x = sc.nextInt();
		for (int i =1; i<=x; i++) {
			System.out.println("Entre com os dados do contrato #"+i);
			System.out.print("Data (DD/MM/YYYY): ");
			Date cData = sdf.parse(sc.next());
			System.out.print("Valor por hora: R$");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração (Hrs): ");
			int hora = sc.nextInt();
			HoraContrato contrato = new HoraContrato (cData, valorPorHora, hora);
			trabalhador.adicionarContrato(contrato);
			
		}
		
		
		
		System.out.println();
		System.out.print("Digite o mês e o ano a ser calculado o salario (MM/YYYY): ");
		//String mesEano = sc.next();
		//int mes = Integer.parseInt(mesEano.substring(0,2));
		//int ano = Integer.parseInt(mesEano.substring(3));
		Date cDate2 = sdf2.parse(sc.next());
		System.out.println("Nome: "+ trabalhador.getNome());
		System.out.println("Departamento: "+ trabalhador.getDepartamento().getNome());
		//System.out.println("Valor do salario do periodo "+mesEano+": R$"+ String.format("%.2f",trabalhador.entrada(ano, mes)));		
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(cDate2);
		int mes = 1+ cal.get(Calendar.MONTH);
		int ano = cal.get(Calendar.YEAR);
		
		System.out.println(mes +", "+ ano);
		
		System.out.println("Valor do salario do periodo "+sdf2.format(cDate2)+": R$"+ String.format("%.2f", trabalhador.entrada(ano, mes)));
		
		
		sc.close();		

	}	

}
