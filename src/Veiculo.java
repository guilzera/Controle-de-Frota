import java.io.Serializable;

public  abstract class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String marca;
    private String modelo;
    private int ano;
    private double quilometragem;
    private String placa;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Veiculo(String marca, String modelo, int ano, double quilometragem, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.placa = placa;
    }

    public String toString() {
        return "Marca: " + marca + "\n" +
                "Modelo: " + modelo  + "\n" +
                "Ano: " + ano + "\n" +
                "Quilometragem: " + quilometragem + " KM" + "\n" +
                "Placa: " + placa;
    }
}
