
import java.util.Random;
import java.io.IOException;

public class App {
    private static Random random = new Random();

    public static int girarDado() {
        int valorDado = random.nextInt(10); // Gera um número entre 0 e 10

        return valorDado;
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        Fila filaDeCastelo = new Fila();
        int numDado, numJogadorAlvo = 0;
        Castelo casteloAtual, casteloAlvo;
        
        filaDeCastelo.adicionar(new Japones(2, 2, "C1", 15));
        filaDeCastelo.adicionar(new Japones(2, 2, "C2", 15));
        filaDeCastelo.adicionar(new Europeu(3, 2, "C3", 10));
        filaDeCastelo.adicionar(new Europeu(3, 2, "C4", 10));

        while (filaDeCastelo.size() > 1) {
            casteloAtual = filaDeCastelo.remover();

            if (casteloAtual instanceof Europeu) {
                casteloAtual = (Europeu)casteloAtual;
            
            } else {
                casteloAtual = (Japones)casteloAtual;
            }

            MenuFormatter.titulo("Vez do Castelo: " + casteloAtual.getNome());         
            numDado = girarDado();

            System.out.println("| O castelo '" + casteloAtual.getNome() + "' tirou " + numDado + " no dado.");

            if (numDado != 0) {
                numJogadorAlvo = random.nextInt(filaDeCastelo.size());
                casteloAlvo = filaDeCastelo.getCastelo(numJogadorAlvo);

                System.out.println("| O Castelo '" + casteloAtual.getNome() + "' irá atacar o Castelo '" + casteloAlvo.getNome() + "'.");
                MenuFormatter.linha();

                if (casteloAtual.ataque()) {
                    String msgDeAtaque = "| Catelo '" + casteloAtual.getNome() + "' atacou o Castelo '" + casteloAlvo.getNome() + "'." 
                                + "\n" + "| Situação do Castelo Atacado: ";

                    if (casteloAlvo instanceof Europeu) {
                        Europeu casteloAlvoEuropeu = (Europeu)casteloAlvo;
                        casteloAlvoEuropeu.setNumPaladino(casteloAlvoEuropeu.getNumPaladino() - numDado);

                       msgDeAtaque += "\n" + " - " + casteloAlvoEuropeu.situacao();                        

                    } else {
                        Japones casteloAlvoJapones = (Japones)casteloAlvo;
                        casteloAlvoJapones.setNumSamurai(casteloAlvoJapones.getNumSamurai() - numDado);

                        msgDeAtaque += "\n" + " - " + casteloAlvoJapones.situacao();   
                    }

                    System.out.println(msgDeAtaque);

                    if (casteloAlvo.getPontosVida() <= 0) {
                        MenuFormatter.msgTerminalINFO("CASTELO " + casteloAlvo.getNome() + " DESTRUÍDO.");

                        Fila aux = new Fila();
                        Castelo castelo;
                        for (int i = 0; i < filaDeCastelo.size(); ) {
                            castelo = filaDeCastelo.remover();
                            if (!castelo.equals(casteloAlvo)) {
                                aux.adicionar(castelo);
                            }
                        }

                        for (int f = 0; f < aux.size(); ) {
                            filaDeCastelo.adicionar(aux.remover());
                        }
                    }

                } else {
                    MenuFormatter.msgTerminalINFO("O ataque do Castelo '" + casteloAtual.getNome() + "' falhou!");
                }

            } else {
                MenuFormatter.msgTerminalINFO(casteloAtual.getNome() + " Passou a vez.");
            }

            filaDeCastelo.adicionar(casteloAtual);
            numJogadorAlvo = 0;

            MenuFormatter.linha();
            MenuFormatter.delay(2);
            MenuFormatter.limparTerminal();
        }

        MenuFormatter.msgTerminalINFO("CASTELO " + filaDeCastelo.getCastelo(0).getNome() + " VENCEDOR");
    }
}
