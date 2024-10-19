public class Europeu extends Castelo{

    protected int numPaladino;

    public Europeu(int defesa, int pontosVida, String nome, int numPaladino) {
        super(defesa, pontosVida, nome);
        this.numPaladino = numPaladino;
        //TODO Auto-generated constructor stub
    }

    public int getNumPaladino() {
        return this.numPaladino;
    }

    public void setNumPaladino(int numPaladino) {
        this.numPaladino = numPaladino;
    }
    // tentativa do metodo de Eliminar
    /*public boolean elimina(Double dado){
        if (dado > numPaladino && dado > 0) {
            if (ataque()) {
                numPaladino += 10;
                return true;
            }
            return false;
        } else{
            return false;
        }
    } */
    
}
