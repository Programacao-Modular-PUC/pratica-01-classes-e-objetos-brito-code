import java.util.Scanner;
import java.util.Calendar;


class Data {
    public int dia;
    public int mes;
    public int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
}

class Pessoa {
    private String nome;
    private String sobrenome;
    private double altura;
    private double peso;
    private double imc;
    private Data dataNascimento; 

    public Pessoa(String nome, String sobrenome, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.altura = altura;
        this.peso = peso;
    }
 
    public String getNome() { return nome; }
    public String getSobrenome() { return sobrenome; }
    public double getAltura() { return altura; }
    public double getPeso() { return peso; }
    public double getImc() { return imc; }
    public void setDataNascimento(Data d) { this.dataNascimento = d; }
    public Data getDataNascimento() { return dataNascimento; }

    public void calculaIMC() {
        this.imc = this.peso / (this.altura * this.altura);
    }

    public int calculaIdade(Data nascimento) {
        Calendar hoje = Calendar.getInstance(); // 
        int idade = hoje.get(Calendar.YEAR) - nascimento.ano;
        if (hoje.get(Calendar.MONTH) + 1 < nascimento.mes || 
           (hoje.get(Calendar.MONTH) + 1 == nascimento.mes && hoje.get(Calendar.DAY_OF_MONTH) < nascimento.dia)) {
            idade--;
        }
        return idade;
    }

    public String informaObesidade() {
        if (this.imc < 18.5) return "Abaixo do peso";
        if (this.imc <= 24.9) return "Peso normal";
        if (this.imc <= 29.9) return "Sobrepeso";
        if (this.imc <= 34.9) return "Obesidade grau 1";
        if (this.imc <= 39.9) return "Obesidade grau 2";
        return "Obesidade grau 3";
    }

    public String getNomeReferencia() {
        return this.sobrenome + ", " + this.nome.toUpperCase();
    }
}

public class ExercicioParte02 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Pessoa[] pessoas = new Pessoa[10]; 
        int totalCadastrado = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("\n--- Cadastro " + (i + 1) + " ---");
            System.out.print("Nome: ");
            String nome = leitor.nextLine();
            System.out.print("Sobrenome: ");
            String sobrenome = leitor.nextLine();

            
            if (i > 0) {
                String nomeAtual = (nome + sobrenome).replace(" ", "");
                String nomeAnterior = (pessoas[i-1].getNome() + pessoas[i-1].getSobrenome()).replace(" ", "");
                if (nomeAtual.equalsIgnoreCase(nomeAnterior)) {
                    System.out.println("Parada: Nome igual ao anterior.");
                    break;
                }
            }

            System.out.print("Peso: ");
            double peso = Double.parseDouble(leitor.nextLine());
            System.out.print("Altura: ");
            double altura = Double.parseDouble(leitor.nextLine());
            
            System.out.print("Data de Nascimento (dd/mm/aaaa): ");
            String[] dataPartes = leitor.nextLine().split("/");
            Data dNasc = new Data(
                Integer.parseInt(dataPartes[0]), 
                Integer.parseInt(dataPartes[1]), 
                Integer.parseInt(dataPartes[2])
            );

            pessoas[i] = new Pessoa(nome, sobrenome, altura, peso);
            pessoas[i].setDataNascimento(dNasc);
            pessoas[i].calculaIMC();
            totalCadastrado++;
        }

        for (int i = 0; i < totalCadastrado; i++) {
            System.out.println("\nCadastro " + (i + 1) + ":");
            System.out.println("Nome completo: " + pessoas[i].getNome() + " " + pessoas[i].getSobrenome());
            System.out.println("Nome de referência: " + pessoas[i].getNomeReferencia());
            System.out.println("Idade: " + pessoas[i].calculaIdade(pessoas[i].getDataNascimento()));
            System.out.println("Peso: " + pessoas[i].getPeso());
            System.out.println("Altura: " + pessoas[i].getAltura());
            System.out.printf("IMC: %.2f\n", pessoas[i].getImc());
            System.out.println("Classificação: " + pessoas[i].informaObesidade());
        }
        leitor.close();
    }
}