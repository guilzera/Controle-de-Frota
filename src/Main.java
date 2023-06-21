public class Main {
    public static void main(String[] args) {

        Veiculo carro = new Carro("Honda", "Civic", 2023,10000,
                "AOX:1B15", 4);

        Veiculo onibus = new Onibus("Volvo", "Busao", 2020, 50000,
                "AOX:1B14", 35);

        Veiculo caminhao = new Caminhao("Volvo", "Tanque", 2022, 2000,
                "AOX:2626", 5000);

        System.out.println(carro);
        System.out.println();
        System.out.println(onibus);
        System.out.println();
        System.out.println(caminhao);



    }
}