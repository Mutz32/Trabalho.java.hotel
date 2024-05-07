import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        List<Hospede> hospedes = new ArrayList<>();
        List<Camareira> camareiras = new ArrayList<>();
        List<Recepcionista> recepcionistas = new ArrayList<>();

        // Inicia threads para os hóspedes
        for (int i = 0; i < 50; i++) {
            Hospede hospede = new Hospede("Hóspede " + (i + 1), hotel);
            hospedes.add(hospede);
            hospede.start();
        }

        // Inicia threads para as camareiras
        for (int i = 0; i < 10; i++) {
            Camareira camareira = new Camareira("Camareira " + (i + 1), hotel);
            camareiras.add(camareira);
            camareira.start();
        }

        // Inicia threads para os recepcionistas
        for (int i = 0; i < 5; i++) {
            Recepcionista recepcionista = new Recepcionista("Recepcionista " + (i + 1), hotel);
            recepcionistas.add(recepcionista);
            recepcionista.start();
        }
    }
}
