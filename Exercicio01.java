
class TrianguloRetangulo {
    public double c1; 
    public double c2; 
    public double h;  

    public double calculaHipotenusa() {
        this.h = Math.sqrt(Math.pow(c1, 2) + Math.pow(c2, 2));
        return this.h;
    }

    public double calculaArea() {
        return (c1 * c2) / 2;
    }
}


public class Exercicio01 {
    public static void main(String[] args) {
        java.util.Scanner leitor = new java.util.Scanner(System.in);
        TrianguloRetangulo tri = new TrianguloRetangulo();

        System.out.println("Digite o valor do cateto 1:");
        tri.c1 = leitor.nextDouble();

        System.out.println("Digite o valor do cateto 2:");
        tri.c2 = leitor.nextDouble();
        System.out.println("Hipotenusa: " + tri.calculaHipotenusa());
        System.out.println("Área: " + tri.calculaArea());

        leitor.close();
    }
}