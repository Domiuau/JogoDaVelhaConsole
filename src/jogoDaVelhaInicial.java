import java.util.Scanner;

class jogoDaVelhaInicial {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int l, c, linha, coluna, jogador, jogadas, opcao;

        //A matriz do tipo char, cria um espaço três por três, onde sereão preechidos o "X" e "O".
        char tab[][] = new char[3][3];

        do {

            jogador = 1;
            jogadas = 0;

            // Esse for cria os espaços da matriz e às preenche com espaços vagos.
            for (l = 0; l < 3; l++) {
                for (c = 0; c < 3; c++) {
                    tab[l][c] = ' ';
                }
            }

            do {
                // Impressão do tabuleiro do jogo da velha.
                System.out.print(" 0   1    2\n");
                for (l = 0; l < 3; l++) {
                    for (c = 0; c < 3; c++) {

                        System.out.print(" " + tab[l][c]);

                        if (c < 2) {
                            System.out.print(" │ ");
                        }

                        if (c == 2) {
                            System.out.println(" " + l);
                        }
                    }

                    if (l < 2) {
                        System.out.print("───┼────┼───");
                        System.out.print("\n");
                    }
                }

                do {
                    do {
                        //Exibição do que é pedido para o jogador introduzir nas variáveis.
                        System.out.println("\u001B[33m" + "\nJogador" + jogador + ", digite a coluna e linha da posição desejada:");
                        System.out.print("\u001B[36m");

                        //variáveis do tipo inteiro, que pega o valor das coordenadas.
                        coluna = ler.nextInt();
                        linha = ler.nextInt();
                        System.out.print("\u001B[39m");

                    } while (linha < 0 || linha > 2 || coluna < 0 || coluna > 2);
                } while (tab[linha][coluna] != ' ');


                if (jogador == 1) {
                    tab[linha][coluna] = 'O';
                    jogador++;
                } else {
                    tab[linha][coluna] = 'X';
                    jogador = 1;
                }
                jogadas++;

            } while (jogadas < 9);

            //O tabuleiro é resetado
            System.out.print(" 0   1    2\n");
            for (l = 0; l < 3; l++) {
                for (c = 0; c < 3; c++) {

                    System.out.print(" " + tab[l][c]);

                    if (c < 2) {
                        System.out.print(" │ ");
                    }
                    if (c == 2) {
                        System.out.println(" " + l);
                    }
                }
                if (l < 2) {
                    System.out.print("───┼────┼───");
                    System.out.print("\n");
                }
            }

            opcao = ler.nextInt();
            //se a opcão que o usuário introduzir for igual a 1, ele irá jogar novamente.
            //caso contrário o jogo irá acabar.
        } while (opcao == 1);
    }
}
