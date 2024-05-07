import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final int numQuartos = 10;
    private final List<Quarto> quartos;
    private final List<Camareira> camareiras;
    private final List<Recepcionista> recepcionistas;

    public Hotel() {
        quartos = new ArrayList<>();
        camareiras = new ArrayList<>();
        recepcionistas = new ArrayList<>();
        for (int i = 1; i <= numQuartos; i++) {
            quartos.add(new Quarto(i));
        }
        for (int i = 1; i <= 10; i++) {
            Camareira camareira = new Camareira("Camareira " + i, this);
            camareiras.add(camareira);
            camareira.start();
        }
        for (int i = 1; i <= 5; i++) {
            Recepcionista recepcionista = new Recepcionista("Recepcionista " + i, this);
            recepcionistas.add(recepcionista);
            recepcionista.start();
        }
    }

    public synchronized Quarto checkIn() throws InterruptedException {
        for (Quarto quarto : quartos) {
            if (!quarto.isOcupado()) {
                quarto.ocupar();
                return quarto;
            }
        }
        wait(); // Se não houver quartos disponíveis, aguarda
        return checkIn(); // Tentar novamente após a espera
    }

    public synchronized void checkOut(Quarto quarto) {
        quarto.desocupar();
        notifyAll(); // Notifica as threads em espera
    }

    public synchronized Quarto getQuartoDisponivel() {
        for (Quarto quarto : quartos) {
            if (!quarto.isOcupado()) {
                return quarto;
            }
        }
        return null;
    }

    // Método para realizar a limpeza de um quarto
    public synchronized void realizarLimpeza(Camareira camareira, Quarto quarto) {
        System.out.println(camareira.getNome() + " está limpando o quarto " + quarto.getNumero() + ".");
        // Simula a limpeza
        quarto.limpar();
        System.out.println(camareira.getNome() + " terminou a limpeza do quarto " + quarto.getNumero() + ".");
        checkOut(quarto); // Marca o quarto como desocupado após a limpeza
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }
}
