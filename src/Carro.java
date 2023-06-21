public class Carro extends Veiculo {
    private static final long serialVersionUID = 1L;
    protected int porta;

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public Carro(String marca, String modelo, int ano, double quilometragem, String placa, int porta) {
        super(marca, modelo, ano, quilometragem, placa);
        this.porta = porta;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Quantidade de Portas: " + porta + " portas" + "\n---------------";
    }
}
