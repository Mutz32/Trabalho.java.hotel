public class Quarto {
    private int numero;
    private boolean ocupado;

    public Quarto(int numero) {
        this.numero = numero;
        this.ocupado = false;
    }

    public synchronized void ocupar() {
        ocupado = true;
        System.out.println("Quarto " + numero + " ocupado.");
    }

    public synchronized void desocupar() {
        ocupado = false;
        System.out.println("Quarto " + numero + " desocupado.");
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public int getNumero() {
        return numero;
    }

    // Método para limpar o quarto
    public void limpar() {
        System.out.println("Limpando o quarto " + numero + "...");
        // Simula a limpeza com um atraso de 5 segundos
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("O quarto " + numero + " foi limpo.");
    }
}
