import models.*;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Bem-vindo ao Jogo dos Objetos Estrangeiros!");
            System.out.println("Você está prestes a ser desafiado a retirar objetos estrangeiros do corpo humano.");
            System.out.println("Cada parte do corpo pode ter ou não um objeto estrangeiro preso.");
            System.out.println("Você deve tentar retirar os objetos com cuidado. Boa sorte!");

            // Pedir o nome do jogador e iniciar o timer
            Scanner scanner = new Scanner(System.in);
            System.out.println("Por favor, digite o seu nome:");
            String nomeJogador = scanner.nextLine();
            Timer timer = new Timer();
            timer.start();

            // Criando instâncias de diferentes partes do corpo
            BodyPart braco = new BodyPart(BodyPart.Part.BRACO);
            BodyPart corpo = new BodyPart(BodyPart.Part.CORPO);
            BodyPart pernas = new BodyPart(BodyPart.Part.PERNAS);

            // Arrays de objetos estrangeiros e partes do corpo
            ForeignObj[] foreignObjs = {
                new Scissors(),
                new Glass(),
                new Knife(),
                new Needle()
            };
            BodyPart[] bodyParts = { braco, corpo, pernas };

            // Randomizador para decidir se uma parte do corpo terá um objeto estrangeiro
            Random random = new Random();

            boolean hasAtLeastOneForeignObj = false;

            while (!hasAtLeastOneForeignObj) {
                for (BodyPart bodyPart : bodyParts) {
                    if (random.nextBoolean()) {
                        hasAtLeastOneForeignObj = true;
                        // Se houver um objeto estrangeiro, escolha aleatoriamente um objeto estrangeiro
                        ForeignObj foreignObj = foreignObjs[random.nextInt(foreignObjs.length)];
                        bodyPart.addForeignObj(foreignObj);
                    }
                }
            }

            // Mostrar todas as partes do corpo e os objetos estrangeiros
            mostrarPartesCorpoEObjetosEstrangeiros(bodyParts);

            Player jogador = new Player(nomeJogador);
            Score score = new Score();
            jogador.setScore(score); // Corrigido para definir o Score do jogador
            jogador.setTimer(timer);

            while (true) {
                System.out.println(
                        "Tente retirar os objetos estrangeiros. Digite o nome da parte do corpo que deseja tentar (ex: BRACO) ou 'SAIR' para encerrar:");
                String inputParteCorpo = scanner.nextLine().toUpperCase();

                if (inputParteCorpo.equals("SAIR")) {
                    System.out.println("Operação cancelada. Obrigado por jogar!");
                    break;
                }

                BodyPart parteCorpoSelecionada = null;
                for (BodyPart bodyPart : bodyParts) {
                    if (bodyPart.getPartType().toString().equals(inputParteCorpo)) {
                        parteCorpoSelecionada = bodyPart;
                        break;
                    }
                }

                if (parteCorpoSelecionada != null && parteCorpoSelecionada.hasForeignObj()) {
                    ForeignObj foreignObj = parteCorpoSelecionada.getForeignObjInPart().values().iterator().next();
                    System.out.println("Você selecionou uma parte do corpo com um objeto estrangeiro (" + foreignObj.getItemType() + "). Tente retirá-lo digitando SIM:");
                    String inputTentativa = scanner.nextLine().toUpperCase();

                    if (inputTentativa.equals("SIM")) {
                        boolean sucesso = foreignObj.attemptRemoval(); // Usar o método específico de tentativa de remoção

                        if (sucesso) {
                            System.out.println("Parabéns! Você retirou o objeto estrangeiro com sucesso!");
                            parteCorpoSelecionada.removeForeignObj(); // Remove o objeto estrangeiro
                            score.incrementScore(); // Incrementa o score do jogador
                        } else {
                            System.out.println("Ops! Você falhou em retirar o objeto estrangeiro. Tente novamente! Você perdeu 1 ponto.");
                            score.decrementScore(); // Decrementa o score do jogador
                        }

                        // Exibir a pontuação atual
                        System.out.println("Pontuação atual: " + score.getScore());
                        // Exibir o tempo decorrido
                        timer.stop();
                        System.out.println("Tempo decorrido: " + String.format("%.1f", timer.getElapsedTime() / 1000.0) + " segundos");
                        timer.start(); // Reiniciar o timer para a próxima tentativa
                    } else {
                        System.out.println("Operação cancelada. Obrigado por jogar!");
                        break;
                    }
                } else {
                    // Se a parte do corpo não tiver um objeto estrangeiro, informe o jogador
                    System.out.println(
                            "Esta parte do corpo não tem um objeto estrangeiro preso. Escolha outra parte do corpo ou digite 'SAIR' para encerrar o jogo.");
                }

                // Mostrar todas as partes do corpo e os objetos estrangeiros após a tentativa
                mostrarPartesCorpoEObjetosEstrangeiros(bodyParts);

                // Verifica se todas as partes do corpo estão livres de objetos estrangeiros
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

    // Função para mostrar as partes do corpo e os objetos estrangeiros presos
    private static void mostrarPartesCorpoEObjetosEstrangeiros(BodyPart[] bodyParts) {
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
