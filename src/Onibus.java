public class Onibus extends Veiculo {
    private static final long serialVersionUID = 1L;
    private int assento;

    public int getAssento() {
        return assento;
    }

    public void setAssento(int assento) {
        this.assento = assento;
    }

    public Onibus(String marca, String modelo, int ano, double quilometragem, String placa, int assento) {
        super(marca, modelo, ano, quilometragem, placa);
        this.assento = assento;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Numero de Assentos: " + assento + " lugares" + "\n-----------------";
    }
}
