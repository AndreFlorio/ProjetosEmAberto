import java.util.Scanner;

public class Banco {
    private static int salario;
    private static int ContaCorrente;
    private static double rendimento;
    private static int meses;

    public Banco(int salario, int conta,double rendimento){
        Scanner scan = new Scanner(System.in);
        System.out.println("digite o tempo em meses: ");
        meses = scan.nextInt();
        System.out.println("Tempo escolhido em meses: "+meses);
        this.salario = salario;
        this.ContaCorrente = conta;
        rendimento = rendimento*0.01;
        this.rendimento = rendimento;
        System.out.printf("Ao final de %d ano você tem R$%d,00",(meses/12),Banco.calculadora());
    }
    public static int calculadora(){
        for(int i =0; i<meses;i++){
            ContaCorrente = (int) ((ContaCorrente*(1+rendimento))+salario);
        }
        String resposta = "";
        return ContaCorrente;
    }
}
