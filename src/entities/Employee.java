package entities;

public class Employee {

	private Integer id;
	private String nome;
	private Double salario;
	
	public Employee(Integer id, String nome, Double salario) {
		this.id = id;
		this.nome = nome;
		aumentarSalario(salario);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public Double getSalario() {
		return salario;
	}
	
	public void aumentarSalario(double porcentagem) {
		salario += salario * porcentagem / 100.0;
	}
	
	@Override
	public String toString() {
		return id
			+ ", "
			+ nome
			+ ", $"
			+ String.format("%.2f%n", salario);
	}
	
}
