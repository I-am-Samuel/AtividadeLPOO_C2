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
}
