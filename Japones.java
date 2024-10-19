public class Japones extends Castelo {

    protected int numSamurai;

    public Japones(int defesa, int pontosVida, String nome, int numSamurai) {
        super(defesa, pontosVida, nome);
        this.numSamurai = numSamurai;
        //TODO Auto-generated constructor stub
    }
    
    public int getNumSamurai() {
        return this.numSamurai;
    }

    public void setNumSamurai(int numSamurai) {
        this.numSamurai = numSamurai;
    }

    // Eu(Thiago) acredito que seja assim:
    public boolean ataque(int numDado) {
        numSamurai = numSamurai - numDado;

        if (numSamurai < 0) {
            if (super.ataque()) {
                numSamurai += 15;
                return true;
            }
            return false;

        } else {
            return false;
        }
    }

    @Override
    public void situacao() {
        System.out.println("\nNome: " + nome + ", Defesa: " + defesa + ", Vida: " + pontosVida + ", Número de Samurais: " + numSamurai);
    }
}
