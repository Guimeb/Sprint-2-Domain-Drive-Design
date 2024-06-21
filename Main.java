import models.*;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        while (true) { //Loop menu
            System.out.println("=================================================");
            System.out.println("Bem-vindo ao Jogo Operation!");
            System.out.println("Você está prestes a ser desafiado a retirar corpos estranhos do corpo humano.");
            System.out.println("Cada parte do corpo pode ter ou não um objeto preso.");
            System.out.println("Você deve tentar retirar os objetos e cada um tem uma chance de retirada. Boa sorte!");
            System.out.println("=================================================");

            Scanner scanner = new Scanner(System.in); //Recebendo nome do jogador
            System.out.println("Por favor, digite o seu nome: ");
            String playerName = scanner.nextLine();
            System.out.println("Olá, " + playerName + "! Vamos começar!");
            System.out.println(" ");
            Timer timer = new Timer();
            timer.start();

            // Criando partes do corpo e corpos estranhos
            BodyPart braco = new BodyPart(BodyPart.Part.BRACO);
            BodyPart corpo = new BodyPart(BodyPart.Part.CORPO);
            BodyPart pernas = new BodyPart(BodyPart.Part.PERNAS);

            ForeignObj[] foreignObjs = {
                new Scissors(),
                new Glass(),
                new Knife(),
                new Needle()
            };
            BodyPart[] bodyParts = {
                braco,
                corpo,
                pernas
            };

            // Randomizador para decidir se uma parte do corpo terá um corpo estranho
            Random random = new Random();

            //Impedindo que nao haja nenhum corpo estranho
            boolean atLeastOne = false;

            while (!atLeastOne) {
                for (BodyPart bodyPart : bodyParts) {
                    if (random.nextBoolean()) {
                        atLeastOne = true;
                        ForeignObj foreignObj = foreignObjs[random.nextInt(foreignObjs.length)];
                        bodyPart.addForeignObj(foreignObj);
                    }
                }
            }

            showBodyObj(bodyParts); //Mostrando partes do corpo e corpos estranhos

            Player player = new Player(playerName);
            Score score = new Score();
            player.setScore(score);
            player.setTimer(timer);

            while (true) { //Menu loop de retirada de objetos
                System.out.println(
                        "Tente retirar os objetos estrangeiros. Digite o nome da parte do corpo que deseja tentar (ex: BRACO) ou 'SAIR' para encerrar:");
                String inputBodyPart = scanner.nextLine().toUpperCase();
                System.out.println(" ");

                if (inputBodyPart.equals("SAIR")) {
                    System.out.println("Operação cancelada. Obrigado por jogar!");
                    break;
                }

                BodyPart chosenBodyPart = null;
                for (BodyPart bodyPart : bodyParts) {
                    if (bodyPart.getPartType().toString().equals(inputBodyPart)) {
                        chosenBodyPart = bodyPart;
                        break;
                    }
                }

                if (chosenBodyPart != null && chosenBodyPart.hasForeignObj()) {
                    ForeignObj foreignObj = chosenBodyPart.getForeignObjInPart().values().iterator().next();
                    System.out.println("Você selecionou uma parte do corpo com um objeto estrangeiro (" + foreignObj.getItemType() + "). Tente retirá-lo digitando SIM:");
                    String inputTentativa = scanner.nextLine().toUpperCase();

                    if (inputTentativa.equals("SIM")) {
                        boolean sucesso = foreignObj.attemptRemoval();

                        if (sucesso) {
                            System.out.println("Parabéns! Você retirou o objeto estrangeiro com sucesso!");
                            chosenBodyPart.removeForeignObj();
                            score.incrementScore();
                        } else {
                            System.out.println("Ops! Você falhou em retirar o objeto estrangeiro. Tente novamente! Você perdeu 1 ponto.");
                            score.decrementScore();
                        }

                        System.out.println("Pontuação atual: " + score.getScore());
                        timer.stop();
                        System.out.println("Tempo decorrido: " + String.format("%.1f", timer.getElapsedTime() / 1000.0) + " segundos");
                        timer.start();
                    } else {
                        System.out.println("Operação cancelada. Obrigado por jogar!");
                        break;
                    }
                } else {
                    System.out.println(
                            "Esta parte do corpo não tem um objeto estrangeiro preso. Escolha outra parte do corpo ou digite 'SAIR' para encerrar o jogo.");
                }

                showBodyObj(bodyParts);

                boolean allPartsCleared = true;
                for (BodyPart bodyPart : bodyParts) {
                    if (bodyPart.hasForeignObj()) {
                        allPartsCleared = false;
                        break;
                    }
                }

                if (allPartsCleared) {
                    System.out.println("Parabéns! Você removeu todos os objetos estrangeiros. Jogo finalizado!");
                    break;
                }
            }
        }
    }

    // Função para mostrar as partes do corpo e os objetos estranhos presos
    private static void showBodyObj(BodyPart[] bodyParts) {
        System.out.println("=================================================");
        System.out.println("Situação do paciente:");
        for (BodyPart bodyPart : bodyParts) {
        System.out.println("Parte do corpo: " + bodyPart.getPartType());
        if (bodyPart.hasForeignObj()) {
        ForeignObj foreignObj = bodyPart.getForeignObjInPart().values().iterator().next();
        System.out.println("Objeto estrangeiro preso: " + foreignObj.getItemType());
        } else {
        System.out.println("Nenhum objeto estrangeiro preso.");
        }
        System.out.println();
        }
    }
}
