import models.*;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
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
        ForeignObj[] foreignObjs = { new ForeignObj(ForeignObj.Type.VIDRO), new ForeignObj(ForeignObj.Type.TESOURA), new ForeignObj(ForeignObj.Type.FACA) };
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
                    bodyPart.setHasForeignObj(true);
                    bodyPart.getForeignObjInPart().put(foreignObj.getItemType(), foreignObj); // Colocando o objeto preso na parte do corpo
                }
            }

            mostrarPartesCorpoEObjetosEstrangeiros(braco);
            mostrarPartesCorpoEObjetosEstrangeiros(corpo);
            mostrarPartesCorpoEObjetosEstrangeiros(pernas);

            Player jogador = new Player(nomeJogador);
            Score score = new Score();
            jogador.setTimer(timer);

            while (true) {
                System.out.println("Tente retirar os objetos estrangeiros. Digite o nome da parte do corpo que deseja tentar (ex: BRACO):");
                String inputParteCorpo = scanner.nextLine().toUpperCase();

                BodyPart parteCorpoSelecionada = null;
                for (BodyPart bodyPart : bodyParts) {
                    if (bodyPart.getPartType().toString().equals(inputParteCorpo)) {
                        parteCorpoSelecionada = bodyPart;
                        break;
                    }
                }

                if (parteCorpoSelecionada != null && parteCorpoSelecionada.hasForeignObj()) {
                    // Se a parte do corpo selecionada tem um objeto estrangeiro, o jogador tem uma chance de retirá-lo
                    System.out.println("Você selecionou uma parte do corpo com um objeto estrangeiro. Tente retirá-lo digitando SIM:");
                    String inputTentativa = scanner.nextLine().toUpperCase();

                    if (inputTentativa.equals("SIM")) {
                        // O jogador tenta retirar o objeto estrangeiro
                        boolean sucesso = random.nextBoolean(); // 50% de chance de sucesso

                        if (sucesso) {
                            System.out.println("Parabéns! Você retirou o objeto estrangeiro com sucesso!");
                            score.incrementScore(); // Incrementa o score do jogador
                            continue;
                        } else {
                            System.out.println("Ops! Você falhou em retirar o objeto estrangeiro. Tente novamente!");
                            continue;
                        }
                    } else {
                        System.out.println("Operação cancelada. Obrigado por jogar!");
                        break;
                    }
                } else {
                    // Se a parte do corpo não tiver um objeto estrangeiro, informe o jogador
                    System.out.println("Esta parte do corpo não tem um objeto estrangeiro preso. Escolha outra parte do corpo ou encerre o jogo.");
                    break;
                }
            }
        }
    }

    // Função para mostrar as partes do corpo e os objetos estrangeiros presos
    private static void mostrarPartesCorpoEObjetosEstrangeiros(BodyPart bodyPart) {
        System.out.println("Parte do corpo: " + bodyPart.getPartType());
        if (bodyPart.hasForeignObj()) {
            System.out.println("Objeto estrangeiro preso: " + bodyPart.getForeignObjInPart().values().iterator().next().getItemType());
        } else {
            System.out.println("Nenhum objeto estrangeiro preso.");
        }
        System.out.println();
    }
}