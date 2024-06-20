// if (parteCorpoSelecionada != null && parteCorpoSelecionada.hasForeignObj()) {
            //     // Se a parte do corpo selecionada tem um objeto estrangeiro, o jogador tem uma chance de retirá-lo
            //     System.out.println("Você selecionou uma parte do corpo com um objeto estrangeiro. Tente retirá-lo digitando SIM:");
            //     String inputTentativa = scanner.nextLine().toUpperCase();

            //     if (inputTentativa.equals("SIM")) {
            //         // O jogador tenta retirar o objeto estrangeiro
            //         boolean sucesso = random.nextBoolean(); // 50% de chance de sucesso

            //         if (sucesso) {
            //             System.out.println("Parabéns! Você retirou o objeto estrangeiro com sucesso!");
            //             score.incrementScore(); // Incrementa o score do jogador
            //             continue;
            //         } else {
            //             System.out.println("Ops! Você falhou em retirar o objeto estrangeiro. Tente novamente!");
            //             continue;
            //         }
            //     } else {
            //         System.out.println("Operação cancelada. Obrigado por jogar!");
            //         break;
            //     }
            // } else {
            //     // Se a parte do corpo não tiver um objeto estrangeiro, informe o jogador
            //     System.out.println("Esta parte do corpo não tem um objeto estrangeiro preso. Escolha outra parte do corpo ou encerre o jogo.");
            //     break;
            // }


        // // Exceção de loop para garantir que pelo menos uma parte do corpo tenha um objeto estrangeiro
        // do {
        //     hasAtLeastOneForeignObj = false;

        //     for (BodyPart bodyPart : bodyParts) {
        //         if (random.nextBoolean()) {
        //             hasAtLeastOneForeignObj = true;
        //             // Se houver um objeto estrangeiro, escolha aleatoriamente um objeto estrangeiro
        //             ForeignObj foreignObj = foreignObjs[random.nextInt(foreignObjs.length)];
        //             bodyPart.setHasForeignObj(true);
        //             bodyPart.getForeignObjInPart().put(foreignObj.getItemType(), foreignObj); // Colocando o objeto preso na parte do corpo
        //         }
        //     }
        // } while (!hasAtLeastOneForeignObj);

        // // Mostrando as partes do corpo e objetos estrangeiros presos, se houver
        // mostrarPartesCorpoEObjetosEstrangeiros(braco);
        // mostrarPartesCorpoEObjetosEstrangeiros(corpo);
        // mostrarPartesCorpoEObjetosEstrangeiros(pernas);

        // // Criar jogador e associar um score e o timer
        // Player jogador = new Player(nomeJogador);
        // Score score = new Score();
        // jogador.setTimer(timer);

        // // Iniciar interações com o jogador
        // System.out.println("Tente retirar os objetos estrangeiros. Digite o nome da parte do corpo que deseja tentar (ex: BRACO):");
        // String inputParteCorpo = scanner.nextLine().toUpperCase();

        // BodyPart parteCorpoSelecionada = null;
        // for (BodyPart bodyPart : bodyParts) {
        //     if (bodyPart.getPartType().toString().equals(inputParteCorpo)) {
        //         parteCorpoSelecionada = bodyPart;
        //         break;
        //     }
        // }

        // if (parteCorpoSelecionada != null && parteCorpoSelecionada.hasForeignObj()) {
        //     // Se a parte do corpo selecionada tem um objeto estrangeiro, o jogador tem uma chance de retirá-lo
        //     System.out.println("Você selecionou uma parte do corpo com um objeto estrangeiro. Tente retirá-lo digitando SIM:");
        //     String inputTentativa = scanner.nextLine().toUpperCase();

        //     if (inputTentativa.equals("SIM")) {
        //         // O jogador tenta retirar o objeto estrangeiro
        //         boolean sucesso = random.nextBoolean(); // 50% de chance de sucesso

        //         if (sucesso) {
        //             System.out.println("Parabéns! Você retirou o objeto estrangeiro com sucesso!");
        //             score.incrementScore(); // Incrementa o score do jogador
        //         } else {
        //             System.out.println("Ops! Você falhou em retirar o objeto estrangeiro. Tente novamente!");
        //         }
        //     } else {
        //         System.out.println("Operação cancelada. Obrigado por jogar!");
        //     }
        // } else {
        //     // Se a parte do corpo não tiver um objeto estrangeiro, informe o jogador
        //     System.out.println("Esta parte do corpo não tem um objeto estrangeiro preso. Escolha outra parte do corpo ou encerre o jogo.");
        // }


        // // Parar o timer e calcular o tempo decorrido
        // timer.stop();
        // long tempoDecorrido = timer.getElapsedTime();
        // System.out.println("Tempo decorrido: " + tempoDecorrido / 1000 + " segundos.");

        // // Atualizar score do jogador
        // jogador.setScore(score);

        // // Mostrar o score final do jogador
        // System.out.println("Score final de " + jogador.getNome() + ": " + jogador.getScore().getScore());