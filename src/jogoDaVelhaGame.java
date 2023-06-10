import java.util.Scanner;

class jogoDaVelhaGame {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        //As variáveis l e c criam os espaços (" "), para formar a matriz.
        int l;
        int c;

        //As variáveis linhas e colunas são usadas para guardar as coordenadas que o usuário introduz.
        int linha;
        int coluna;

        //variável jogador é usada para definir a vez de quem tá jogando
        int jogador;

        //variável ganhou é usada dentro das condições para difinir o ganhador.
        int ganhou;

        //A variável jogadas é usadas para contar quantas jogadas já foram feitas.
        int jogadas;

        //A variável opcao é usada para saber se o usuário quer jogar novamente, isso se for igual à 1.
        int opcao;

        //A matriz do tipo char, cria um espaço três por três, onde sereão preechidos o "X" e "O"
        char tab[][] = new char[3][3];

        do {
            //Introduzindo os valores às variáveis;
            jogador = 1;
            ganhou = 0;
            jogadas = 0;

            // Esse "for", cria os espaços da matriz e às preenche com espaços vagos
            for (l = 0; l < 3; l++) {
                for (c = 0; c < 3; c++) {
                    tab[l][c] = ' ';
                }
            }

            do {
                //Impressão do tabuleiro do jogo da velha
                //Imprimi a coornadas superiores
                System.out.print(" 0   1    2\n");
                //linha
                for (l = 0; l < 3; l++) {
                    //coluna
                    for (c = 0; c < 3; c++) {
                        //o loop faz com que os espaços da matriz sejam preenchidos com " "
                        System.out.print(" " + tab[l][c]);
                        //se c for menor que 2 o programa forma as barras laterais do jogo
                        if (c < 2) {
                            System.out.print(" │ ");
                        }
                        //se c for igual a 2, o programa se preenche com espaços vagos
                        if (c == 2) {
                            System.out.println(" " + l);
                        }
                    }
                    //Se l for menor que 2, o prgrama vai printar a figura abaixo e pular uma linha
                    if (l < 2) {
                        System.out.print("───┼────┼───");
                        System.out.print("\n");
                    }
                }

                // Aqui pegamos as coordenadas da matriz, onde o valor é armazenado na variável coluna e linha, se o usuário introduzir um valor fora do padrão, o console irá continuar pedindo as coordenadas,  até que o usuário digite os valores corretos

                do {
                    do {
                        //Exibição do que é pedido para o jogador introduzir nas variáveis.
                        System.out.println("\u001B[m" + "\nJogador " + jogador + ", digite a coluna e linha da posição desejada:");
                        //O comando muda a cor dos dados que é introduzido.
                        System.out.print("\u001B[36m");
                        //variáveis do tipo inteiro, que pega o valor das coordenadas.
                        coluna = ler.nextInt();
                        linha = ler.nextInt();
                        //O comando volta a cor original do console.
                        System.out.print("\u001B[39m");
                    } while (linha < 0 || linha > 2 || coluna < 0 || coluna > 2);
                } while (tab[linha][coluna] != ' ');

				 //Essa parte do código salva as coordenadas que foram digitadas,
				 //e nelas colocam X ou O, de acordo com a vez de cada jogador.

                if (jogador == 1) {
                    //Se for a vez do  jogador 1, o programa irá pegar as coordenadas que foi digitada por ele e colocar o "O".
                    tab[linha][coluna] = 'O';
                    //Incrementamos a variável jogador, para passar a vez da jogada para o jogador 2.
                    jogador++;
                } else {
                    //Se for a vez do  jogador 2, o programa irá pegar as coordenadas que foi digitada por ele e colocar o "X".
                    tab[linha][coluna] = 'X';
                    //Incrementamos a variável jogador com 1, para passar a vez da jogada para o jogador 1.
                    jogador = 1;
                }
                jogadas++;

                //Nessa parte do código, verificamos todas as possiblidades de ganhar, tanto do "O" qunato do "X".

                //Verificar ganhador por linhas
                //O "for" abaixo faz o loop dos valores de "l", assim, teste todas as possiblidades
                //e ordem das posições do caractér para saber quem foi o ganhador da linha (se houver)
                for (l = 0; l < 3; l++) {
                    if (tab[l][0] == 'O' && tab[l][1] == 'O' && tab[l][2] == 'O') {
                        //A variável ganhou, recebe o valor de qual jogador que ganhou o jogo, se foi o 1 ou o 2.
                        ganhou = 1;
                    }
                }
                for (l = 0; l < 3; l++) {
                    if (tab[l][0] == 'X' && tab[l][1] == 'X' && tab[l][2] == 'X') {
                        //A variável ganhou, recebe o valor de qual jogador que ganhou o jogo, se foi o 1 ou o 2.
                        ganhou = 2;
                    }
                }

                //Verificar ganhador por colunas O "for" abaixo faz o loop dos valores de "c", assim, teste todas as possiblidades e ordem das posições do caractér para saber quem foio ganhador da coluna (se houver)

                for (c = 0; c < 3; c++) {
                    if (tab[0][c] == 'O' && tab[1][c] == 'O' && tab[2][c] == 'O') {
                        //A variável ganhou, recebe o valor de qual jogador que ganhou o jogo, se foi o 1 ou o 2.
                        ganhou = 1;
                    }
                }
                for (c = 0; c < 3; c++) {
                    if (tab[0][c] == 'X' && tab[1][c] == 'X' && tab[2][c] == 'X') {
                        //A variável ganhou, recebe o valor de qual jogador que ganhou o jogo, se foi o 1 ou o 2.
                        ganhou = 2;
                    }
                }

                //verificar ganhador na diagonal principal
                //O if testa na posição onde os números são iguais, quem foi o ganhador nelasNesse caso ele testa para o "O".
                if (tab[0][0] == 'O' && tab[1][1] == 'O' && tab[2][2] == 'O') {
                    // a variável ganhou, recebe o valor de qual jogador que ganhou o jogo, se foi o 1 ou o 2.
                    ganhou = 1;
                }
                //O if testa na posição onde os números são iguais, quem foi o ganhador nelas Nesse caso ele testa para o "X".
                if (tab[0][0] == 'X' && tab[1][1] == 'X' && tab[2][2] == 'X') {
                    // a variável ganhou, recebe o valor de qual jogador que ganhou o jogo, se foi o 1 ou o 2.
                    ganhou = 2;
                }

                //Verificar ganhador na diagonal secundária
                //O if testa na posição onde está a diagonal sencudária, quem foi o ganhador nelas Nesse caso ele testa para o "O".
                if (tab[0][2] == 'O' && tab[1][1] == 'O' && tab[2][0] == 'O') {
                    // a variável ganhou, recebe o valor de qual jogador que ganhou o jogo, se foi o 1 ou o 2.
                    ganhou = 1;
                }

                //O if testa na posição onde está a diagonal sencudária, quem foi o ganhador nelas Nesse caso ele testa para o "X".
                if (tab[0][2] == 'X' && tab[1][1] == 'X' && tab[2][0] == 'X') {
                    // a variável ganhou, recebe o valor de qual jogador que ganhou o jogo, se foi o 1 ou o 2.
                    ganhou = 2;
                }

                //O loop while, verifica se os valores de ganhou ainda é igual a 0, e se as jogadas forem menores que 9 se isso for verdadeiro o programa irá continuar rodando, até que uma das condições seja difrente da que está padronizada no loop

            } while (ganhou == 0 && jogadas < 9);

            //Impressão do tabuleiro do jogo da velha
            //Imprimi a coornadas superiores
            System.out.print(" 0   1    2\n");
            for (l = 0; l < 3; l++) {
                for (c = 0; c < 3; c++) {
                    //O loop faz com que os espaços da matriz sejam preenchidos com " "
                    System.out.print(" " + tab[l][c]);
                    //Se c for menor que 2 o programa forma as barras laterais do jogo
                    if (c < 2) {
                        System.out.print(" │ ");
                    }
                    //Se c for igual a 2, o programa se preenche com espaços vagos
                    if (c == 2) {
                        System.out.println(" " + l);
                    }
                }
                //Se l for menor que 2, o prgrama vai printar a figura abaixo e pular uma linha
                if (l < 2) {
                    System.out.print("───┼────┼───");
                    System.out.print("\n");
                }
            }

            //Criando uma variável empate do tipo int
            int empate = 0;

            // O código abaixo faz um teste de verificação dentro da matriz, e depois incrementa a variável empate

            for (int i = 0; i < tab.length; i++) {
                for (int j = 0; j < tab.length; j++) {
                    if (tab[i][j] != ' ') {
                        empate++;
                    }
                }
            }

            //A condição if verifica se deu empate ou não, de acordo com a expressõa abaixou, em seguida imprimi na tela que "Deu Velha"

            if (empate == 9 && ganhou != 1 && ganhou != 2) {
                //Imprimi a mensagem na tela, e muda a cor dela.
                System.out.println("\u001B[31m" + "Deu Velha\n");
            }

            // A condição else if verifica se o jogador 1 ganhou o jogo, em seguida imprimi na tela: "Parabéns Jogador 1. Você ganhou!"

            else if (ganhou == 1) {
                //Imprimi a mensagem na tela, e muda a cor dela
                System.out.println("\u001B[32m" + "\nParabéns Jogador 1. Você ganhou!\n");
                //Volta a cor original do programa.
                System.out.print("\u001B[39m");
            }

			 //A condição else verifica se o jogador 2 ganhou o jogo,
			 //em seguida imprimi na tela: "Parabéns Jogador 2. Você ganhou!"

            else {
                //Imprimi a mensagem na tela, e muda a cor dela
                System.out.println("\u001B[32m" + "\nParabéns Jogador 2. Você ganhou!\n");
                //Volta a cor original do programa.
                System.out.print("\u001B[39m");
            }
            //Volta a variável empate para 0;
            empate = 0;
            //Pergunta se o usuário quer jogar de novo ou não
            System.out.println("Digite 1 para jogar novamente:");
            //Faz um input na variável para introduzir os dados
            opcao = ler.nextInt();
            //Se a opcão que o usuário introduzir for igual a 1, ele irá jogar novamente
            //Caso contrário o jogo irá acabar
        } while (opcao == 1);
    }
}


