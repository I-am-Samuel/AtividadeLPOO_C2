import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

public class App {
    private static Random random = new Random();

    public static int girarDado() {
        int valorDado = random.nextInt(10); // Gera um número entre 0 e 10

        return valorDado;
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<Castelo> listaDeCastelos = new ArrayList<>();
        int numDado, numJogadorAtual = 0, numJogadorAlvo = 0;
        Castelo casteloAtual, casteloAlvo;
        
        listaDeCastelos.add(new Japones(2, 2, "C1", 15));
        listaDeCastelos.add(new Japones(2, 2, "C2", 15));
        listaDeCastelos.add(new Europeu(3, 2, "C3", 10));
        listaDeCastelos.add(new Europeu(3, 2, "C4", 10));

        casteloAtual = listaDeCastelos.get(numJogadorAtual);

        while (listaDeCastelos.size() > 1) {
            casteloAtual = listaDeCastelos.get(numJogadorAtual);

            MenuFormatter.titulo("Vez do Castelo: " + casteloAtual.getNome());         
            numDado = girarDado();

            System.out.println("| O castelo '" + casteloAtual.getNome() + "' tirou " + numDado + " no dado.");

            if (numDado != 0) {
                while (numJogadorAlvo == numJogadorAtual) {
                    numJogadorAlvo = random.nextInt(listaDeCastelos.size()-1);
                }
                casteloAlvo = listaDeCastelos.get(numJogadorAlvo);

                System.out.println("| O Castelo '" + casteloAtual.getNome() + "' irá atacar o Castelo '" + casteloAlvo.getNome() + "'.");

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
                    }

                } else {
                    MenuFormatter.msgTerminalINFO("O ataque do Castelo '" + casteloAtual.getNome() + "' falhou!");
                }

            } else {
                MenuFormatter.msgTerminalINFO(casteloAtual.getNome() + " Passou a vez.");
            }

            if (numJogadorAtual == 3) {
                numJogadorAtual = 0;
                numJogadorAlvo = 0;

            } else {
                numJogadorAtual += 1;
                numJogadorAlvo += 1;

            }


            MenuFormatter.delay(2);
            MenuFormatter.limparTerminal();
        }

        // mensagem do ganhador
        MenuFormatter.msgTerminalINFO("CASTELO " + listaDeCastelos.get(0).getNome() + " VENCEDOR");
    }
}
