import java.util.Random;

    public class Camareira extends Thread {
    private String nome;
    private Hotel hotel;

    public Camareira(String nome, Hotel hotel) {
        this.nome = nome;
        this.hotel = hotel;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(random.nextInt(10000)); // Simula tempo de limpeza
                Quarto quarto = hotel.getQuartoDisponivel();
                if (quarto != null) {
                    hotel.realizarLimpeza(this, quarto);
                } else {
                    System.out.println(getNome() + " está passeando enquanto aguarda um quarto ficar vago.");
                    Thread.sleep(random.nextInt(10000)); // Simula o tempo de passeio
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       
        