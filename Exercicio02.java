import java.util.Scanner;

class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double imc;


    public Pessoa(String nome, String sobrenome, int idade, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public double getImc() { return imc; }

    public void calculaIMC() {
        this.imc = this.peso / (this.altura * this.altura);
    }

    public String informaObesidade() {
        if (this.imc < 18.5) return "Abaixo do peso";
        if (this.imc <= 24.9) return "Peso normal"; 
        if (this.imc <= 29.9) return "Sobrepeso"; 
        if (this.imc <= 34.9) return "Obesidade grau 1"; 
        if (this.imc <= 39.9) return "Obesidade grau 2"; 
        return "Obesidade grau 3";
    }
}

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Nome:");
        String n = leitor.nextLine();
        System.out.println("Sobrenome:");
        String s = leitor.nextLine();
        System.out.println("Idade:");
        int i = leitor.nextInt();
        System.out.println("Altura (ex: 1,75):");
        double a = leitor.nextDouble();
        System.out.println("Peso (ex: 70,5):");
        double p = leitor.nextDouble();

        Pessoa pessoa = new Pessoa(n, s, i, a, p);
        pessoa.calculaIMC();

        System.out.println("\nResultado para: " + pessoa.getNome() + " " + pessoa.getSobrenome());
        System.out.printf("IMC: %.2f\n", pessoa.getImc());
        System.out.println("Classificação: " + pessoa.informaObesidade());

        leitor.close();
    }
}