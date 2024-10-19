/**
 * Castelo
 */
public abstract class Castelo {

    protected int defesa;
    protected int pontosVida;
    protected String nome;

    public Castelo(int defesa, int pontosVida, String nome) {
        this.defesa = defesa;
        this.pontosVida = pontosVida;
        this.nome = nome;
    }

    public int getDefesa() {
        return this.defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontosVida() {
        return this.pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    // Vale a pena conferir se é isso mesmo (acredito que seja isso mesmo)
    public String situacao(){
        return "Nome: " + nome + ", Defesa: " + defesa + ", Vida: " + pontosVida;
    }

    // metodo de ataque tá show
    public boolean ataque(){
        if (defesa > 0) {
            defesa --;
            return true;
        } else if (pontosVida > 0) {
            pontosVida --;
            defesa = 2;
            return true;
        } else {
            return false;
        }
    }


}