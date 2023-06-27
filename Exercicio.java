import java.util.Arrays;

public class Exercicio {
    public static void main(String[] args){
        Double vetor[] = {1.2,-2.7,Math.sqrt(3),-5.21,6.03,0.0,7.5,-8.2,10.9,130.0};
        System.out.println(maiorEMenor(vetor));
        maiorSomaDo(vetor);
        usandoDoisFors(vetor);
        usandoTresFors(vetor);
        crescente(vetor);
        decrescente(vetor);
        
    }
    //Metodo para descobrir o Maior e o Menor numero de um vetor:
    static String maiorEMenor(Double[] numero){
        if(numero.length == 0){
            return "Não há maior nem menor numeros em um vetor vazio";
        }else{
            Double maiorSalvo = new Double(numero[0]);
            Double menorSalvo = new Double(numero[0]);
            for(int atual = 1; atual<numero.length; atual++){
                if(maiorSalvo<numero[atual]){       //Se o numero atual for maior que o salvo:
                    maiorSalvo = numero[atual];     //o numero atual é salvo em maiorSalvo, pois queremos o maior numero possivel
                }
                if(menorSalvo>numero[atual]){       //Se o numero atual for menor que o salvo:
                    menorSalvo = numero[atual];     //o numero atual é salvo em menorSalvo, pois queremos o menor numero possivel
                }
            }
            return "O maior e o menor numero são: "+maiorSalvo+" e "+menorSalvo; //retornando os valores
        }
    }
    //Metodo para achar a maior soma consecutiva de um vetor:
    static void maiorSomaDo(Double[] x){
        if(x.length>0){
            Double soma = Double.valueOf(x[0]);      //Soma consecutiva atual
            Double resposta = Double.valueOf(x[0]);  //Soma consecutiva resposta
            int novoInicio =0;   //indice inicial do subvetor atual
            int inicio =0;       //indice inicial do subvetor resposta
            int fim =0;          //indice final do subvetor resposta

            for(int i=1;i<x.length;i++){    //começando do segundo elemento pois o primeiro ja foi considerado nas variaveis acima.
                if(soma<0){                                 //Soma negativa significa que esse subvetor chegou ao seu fim. (Essa é a soma até o indice anterior)
                    soma =0.0;                                  //reiniciando a soma para adicionar os numeros do novo subvetor.
                    novoInicio = i;                             //vamos criar um novo inicio, a partir do numero atual.
                }
                soma = soma+x[i];                                  //acrescentando à soma o número atual.
                if(soma.compareTo(resposta)>0){                    //se a soma atual for maior que a resposta:
                    resposta = soma;                                  //A soma atual é salva como resposta.
                    inicio = novoInicio;                              //o incio e o fim do subvetor atual são salvos.
                    fim =i;           
                }
            }
            System.out.printf("Resposta 1: %.2f \n",resposta);
            subVetor(x, inicio, fim);
        }else{
            System.out.println("Não há maior soma se não houver numeros");
        }
    }
    //Usando dois fors para achar a soma:
    static void usandoDoisFors(Double[] x){
        if(x.length>0){
            Double resposta= Double.valueOf(x[0]);
            int inicio=0;
            int fim =0;
            for(int i=0;i<x.length;i++){         //indice inico de cada subvetor
                Double soma=0.0;                        //Reiniciaremos a soma sempre que houver um novo inicio
                for(int i2 =i;i2<x.length;i2++){        //incice final de cada subvetor
                    soma = soma+x[i2];                  //A soma acrescenta o numero final atual
                    if(soma.compareTo(resposta)>0){     //Se a soma atual for maior que a resposta: 
                        inicio =i;                                       //O inicio e o fim são salvos
                        fim=i2;                        
                        resposta =soma;                                  //A soma atual é salva como resposta
                    }
                }
            }
            System.out.printf("Resposta 2: %.2f \n",resposta);
            subVetor(x, inicio, fim);
        }
    }
    //Usando tres fors para achar a soma:
    static void usandoTresFors(Double[] x){
        if(x.length>0){
            Double resposta = Double.valueOf(x[0]);
            int fim=0;
            int inicio=0;
            for(int i = 0;i<x.length;i++){         //indice inicial de cada subvetor
                for(int i2=i;i2<x.length;i2++){    //indice final de cada subvetor, que começa sempre no inicial
                    Double soma =0.0;
                    for(int i3=i;i3<=i2;i3++){         
                        soma = soma+x[i3];            //Adicionando à soma todos os elementos entre o inicio e o fim
                    } 
                    if(soma.compareTo(resposta)>0){              //Se a soma total for maior que a resposta:
                        resposta = soma;                                    //A soma atual é salva como resposta
                        fim = i2;                                           //Os indices do inicio e fim são salvos
                        inicio = i;
                    }
                }
            }
            System.out.printf("Resposta 3: %.2f\n",resposta);
            subVetor(x, inicio, fim);
        }
    }
    //Metodo que ordena um vetor em ordem crescente:
    static void crescente(Double[] x){
        for(int i1=0;i1<x.length-1;i1++){    
            for(int i=1;i<x.length-i1;i++){  
                if(x[i-1]>x[i]){             //Se o anterior for maior que o atual:
                    double z = x[i-1];          
                    x[i-1] = x[i];           //Trocamos os dois de posição
                    x[i] =z;
                }
            }
        }
        System.out.println("Em ordem crescente: ");
        subVetor(x,0,x.length-1);
    }
    //Metodo que ordena um vetor em ordem decrescente:
    static void decrescente(Double[] x){
        for(int i1=0;i1<x.length-1;i1++){
            for(int i=1;i<x.length-i1;i++){
                if(x[i-1]<x[i]){             //Se o anterior for menor que o atual:
                    double z = x[i-1];       
                    x[i-1] = x[i];           //Trocamos os dois de posição
                    x[i] =z;
                }
            }
        }
        System.out.println("Em ordem decrescente: ");
        subVetor(x,0,x.length-1);
    }
    //Printando um subvetor partindo do elemento no indice inicio até o elemento no indice fim
    static void subVetor(Double[] x,int inicio, int fim){ 
            for(int i=inicio;i<=fim;i++){ 
                System.out.printf("%.2f ",x[i]);
            }
            System.out.println();
    }
}
