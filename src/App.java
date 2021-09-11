import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.IOException;
public class App {
    public static Scanner arq;
        public static void main(String[] args) throws IOException {
            ArrayList <String> array1 = new ArrayList<String>();
            try {
              arq = new Scanner(new FileReader("prog.txt"));             
              while (arq.hasNextLine()){
            	  array1.add(arq.nextLine());
              }
            } catch (IOException e) {
                System.err.printf("Não foi possível abrir o arquivo: %s.\n",
                  e.getMessage());
            }
            int sz= array1.size();
            FileWriter arqSaida = new FileWriter("prog-check.txt");
            PrintWriter gravaArq = new PrintWriter(arqSaida);           
            Stack<Character> lista = new Stack<Character>();
            for(int x = 0; x < sz; x++){
                boolean tf = false;
                String array2 = array1.get(x).toString();                              
                System.out.println(array2);
                char chave1 = '{';
                char colchete1 = '[';
                char parenteses1 = '(';
                char maior = '>';
                char chave2 = '}';
                char colchete2 = ']';
                char parenteses2 = ')';
                char menor = '<';             
                for (int i = 0; i < array2.length(); i++){
                if (array2.charAt(i) == colchete1) {
                    lista.push(colchete1);
                }else if (array2.charAt(i) == chave1){
                    lista.push(chave1);
                }else if (array2.charAt(i) == menor){
                    lista.push(menor);
                }else if (array2.charAt(i) == parenteses1){
                    lista.push(parenteses1);
                }else if (array2.charAt(i) == colchete2){
                    if (lista.isEmpty()){
                        tf = true;
                        break;
                    }
                    if (lista.pop() != colchete1){
                        tf = true;
                        break;
                    }
                }else if (array2.charAt(i) == chave2){
                    if (lista.isEmpty()){
                        tf = true;
                        break;
                    }
                    if (lista.pop() != chave1){
                        tf = true;
                        break;
                    }              
                }else if (array2.charAt(i) == parenteses2){
                    if (lista.isEmpty()){
                        tf = true;
                        break;
                    }
                    if (lista.pop() != parenteses1){
                        tf = true;
                        break;
                    }
                }else if (array2.charAt(i) == maior){
                    if (lista.isEmpty()){
                        tf = true;
                        break;
                    }
                    if (lista.pop() != menor){
                        tf = true;
                        break;
                    }              
                }    
            }                          
            lista.clear();         
            if (tf == true){
            	array2 = array2 + " - Inválido";
            }
            else{
            	array2 = array2 + " - Válido";
            }
            try{
                gravaArq.println(array2);
            }
            catch(Exception e){
                System.err.printf("Não foi possível salvar o arquivo: %s.\n",
                  e.getMessage());
            }
        }
        arqSaida.close();
    }
}
