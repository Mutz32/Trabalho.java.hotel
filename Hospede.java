import java.util.Random;

public class Hospede extends Thread {
    private String nome;
    private Hotel hotel;

    public Hospede(String nome, Hotel hotel) {
        this.nome = nome;
        this.hotel = hotel;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(random.nextInt(15000)); // Simula tempo de espera antes de tentar alugar um quarto
                Quarto quarto = hotel.getQuartoDisponivel();
                if (quarto != null) {
                    hotel.checkIn();
                } else {
                    System.out.println(getNome() + " está aguardando um quarto ficar vago.");
                    Thread.sleep(random.nextInt(10000)); // Simula o tempo de espera
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getNome() {
        return nome;
    }
}
