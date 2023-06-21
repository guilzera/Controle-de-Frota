import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ControleFrota {
    private ArrayList<Veiculo> veiculos;

    //metodo construtor
    public ControleFrota() {
        this.veiculos = new ArrayList<>();
    }

    //para cada objeto, ele cria a tela.
    public String[] leValores(String [] dadosEntrada) {
        String [] dadosSaida = new String[dadosEntrada.length];
        for (int i = 0; i < dadosEntrada.length; i++)
            dadosSaida[i] = JOptionPane.showInputDialog  ("Entre com " + dadosEntrada[i]+ ": ");

        return dadosSaida;
    }

    //metodo que le e retorna um novo carro
    public Carro leCarro (){

        String [] valores = new String [6]; //Array com 6 posições
        String [] nomeVal = {"Marca", "Modelo", "Ano", "Quilometragem", "Placa", "Porta"};
        valores = leValores (nomeVal);

        int ano = this.retornaInteiro(valores[2]);
        int porta = this.retornaInteiro(valores[5]);
        int quilometragem = this.retornaInteiro(valores[3]);

        Carro carro = new Carro(valores[0], valores[1], ano, quilometragem, valores[4], porta);
        return carro;
    }

    //metodo que le e retorna um novo onibus
    public Onibus leOnibus (){

        String [] valores = new String [6];
        String [] nomeVal = {"Marca", "Modelo", "Ano", "Quilometragem", "Placa", "Assento"};
        valores = leValores (nomeVal);

        int ano = this.retornaInteiro(valores[2]);
        int assento = this.retornaInteiro(valores[5]);
        int quilometragem = this.retornaInteiro(valores[3]);

        Onibus onibus = new Onibus (valores[0], valores[1], ano, quilometragem, valores[4], assento);
        return onibus;
    }

    //metodo que le e retorna um novo caminhao
    public Caminhao leCaminhao (){

        String [] valores = new String [6];
        String [] nomeVal = {"Marca", "Modelo", "Ano", "Quilometragem", "Placa", "CargaMaxima"};
        valores = leValores (nomeVal);

        int ano = this.retornaInteiro(valores[2]);
        int quilometragem = this.retornaInteiro(valores[3]);
        int cargaMaxima = this.retornaInteiro(valores[5]);

        Caminhao caminhao = new Caminhao (valores[0], valores[1], ano, quilometragem, valores[4], cargaMaxima);
        return caminhao;
    }

    //metodo que transforma um string para um inteiro
    private boolean intValido(String s) {
        try {
            Integer.parseInt(s); // metodo estatico, que tenta tranformar uma string em inteiro
            return true;
        } catch (NumberFormatException e) { // Nao conseguiu tranformar em inteiro e gera erro
            return false;
        }
    }

    // retorna um valor inteiro
    public int retornaInteiro(String entrada) {

        //Enquanto não for possivel converter o valor de entrada para inteiro, permanece no loop
        while (!this.intValido(entrada)) {
            entrada = JOptionPane.showInputDialog(null,
                    "Valor incorreto!\n\nDigite um numero inteiro."); // mensagem de dialogo
        }
        return Integer.parseInt(entrada);
    }
    public void salvaVeiculos (ArrayList<Veiculo> veiculos){
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream
                    (new FileOutputStream("D:\\PUC\\1°Semestre\\Modulo 2\\POO\\Java\\Frota\\Frota\\src\\Veiculos.dat"));
            for (int i=0; i < veiculos.size(); i++)
                outputStream.writeObject(veiculos.get(i));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Impossivel criar arquivo!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {  //Fecha o ObjectOutputStream
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    @SuppressWarnings("finally")
    public ArrayList<Veiculo> recuperaVeiculos (){
        ArrayList<Veiculo> veiculoTemp = new ArrayList<Veiculo>();

        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream
                    (new FileInputStream("D:\\PUC\\1°Semestre\\Modulo 2\\POO\\Java\\Frota\\Frota\\src\\Veiculos.dat"));
            Object obj = null;
            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof Veiculo) {
                    veiculoTemp.add((Veiculo) obj);
                }
            }
        } catch (EOFException ex) {
            System.out.println("Fim de arquivo.");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Arquivo com veiculos NÃO existe!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
            return veiculoTemp;
        }
    }

    public void menuFrota (){

        String menu = "";
        String entrada;
        int opc1, opc2;

        do {
            menu = "Controle Veiculos\n" +
                    "Opçoes:\n" +
                    "1. Cadastrar Veiculos\n" +
                    "2. Exibir Veiculos\n" +
                    "3. Limpar Veiculos\n" +
                    "4. Gravar em arquivo\n" +
                    "5. Recuperar do arquivo\n" +
                    "9. Sair";

            //Interface grafica
            entrada = JOptionPane.showInputDialog (menu + "\n\n"); // caixa de dialogo
            opc1 = this.retornaInteiro(entrada);

            switch (opc1) {
                case 1:// Entrar dados
                    menu = "Entrada de Veiculos \n" +
                            "Opçoes:\n" +
                            "1. Carro\n" +
                            "2. Caminhão\n" +
                            "3. Onibus";

                    entrada = JOptionPane.showInputDialog (menu + "\n\n");
                    opc2 = this.retornaInteiro(entrada);

                    switch (opc2){
                        case 1: veiculos.add((Veiculo) leCarro());
                            break;
                        case 2: veiculos.add((Veiculo) leCaminhao());
                            break;
                        case 3: veiculos.add((Veiculo) leOnibus());
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"Veiculo de entrada NÃO escolhido!");
                    }
                    break;
                case 2: // Exibir dados
                    if (veiculos.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Entre com o veiculo primeiramente");
                        break;
                    }
                    String dados = "";
                    for (int i=0; i < veiculos.size(); i++)	{
                        dados += veiculos.get(i).toString() + "---------------\n";
                    }
                    JOptionPane.showMessageDialog(null,dados);
                    break;
                case 3: // Limpar Dados
                    if (veiculos.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Entre com o veiculo primeiramente");
                        break;
                    }
                    veiculos.clear();
                    JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
                    break;
                case 4: // Grava Dados
                    if (veiculos.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Entre com o veiculo primeiramente");
                        break;
                    }
                    salvaVeiculos(veiculos);
                    JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
                    break;
                case 5: // Recupera Dados
                    veiculos = recuperaVeiculos();
                    if (veiculos.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
                        break;
                    }
                    JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null,"Fim do aplicativo Controle de Frota");
                    break;
            }
        } while (opc1 != 9);
    }

    public static void main (String [] args){

        ControleFrota frota = new ControleFrota ();
        frota.menuFrota();
    }
}
