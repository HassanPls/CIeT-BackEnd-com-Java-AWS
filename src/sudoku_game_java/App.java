package sudoku_game_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import sudoku_game_java.model.Board;
import sudoku_game_java.model.Space;
import sudoku_game_java.util.BoardTemplate;

public class App {
    private final static Scanner Sc = new Scanner(System.in);
    private static Board board;
    private final static int BOARD_LIMIT = 9;

    public static void main(String[] args) throws Exception {
        final Map<String, String> positions = Stream.of(args)
                .collect(Collectors.toMap(k -> k.split(";")[0], v -> v.split(";")[1]));

        int option = -1;
        while (true) {
            System.out.println("Selecione uma das opções a seguir");
            System.out.println("1 - Iniciar um novo Jogo");
            System.out.println("2 - Colocar um novo número");
            System.out.println("3 - Remover um número");
            System.out.println("4 - Visualizar jogo atual");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("6 - limpar jogo");
            System.out.println("7 - Finalizar jogo");
            System.out.println("8 - Sair");

            option = Sc.nextInt();

            switch (option) {
                case 1 -> startGame(positions);
                case 2 -> inputNumber();
                case 3 -> removeNumber();
                case 4 -> showCurrentGame();
                case 5 -> showGameStatus();
                case 6 -> clearGame();
                case 7 -> finishGame();
                case 8 -> System.exit(0);
                default -> System.out.println("Opção inválida, selecione uma das opções do menu");
            }
        }
    }

    private static void finishGame() {
        if (Objects.isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        if (board.isFinished()) {
            System.out.println("Parabéns você concluiu o jogo");
            showCurrentGame();
            board = null;
        } else if (board.hasErrors()) {
            System.out.println("Seu jogo conté, erros, verifique seu board e ajuste-o");
        } else {
            System.out.println("Você ainda precisa preenhcer algum espaço");
        }
    }

    private static void clearGame() {
        if (Objects.isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        System.out.println("Tem certeza que deseja limpar seu jogo e perder todo seu progresso?");
        var confirm = Sc.next();
        while (!confirm.equalsIgnoreCase("sim") && !confirm.equalsIgnoreCase("não")) {
            System.out.println("Informe 'sim' ou 'não'.");
            confirm = Sc.next();
        }

        if (confirm.equalsIgnoreCase("sim")) {
            board.reset();
        }
    }

    private static void showGameStatus() {
        if (Objects.isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        System.out.printf("O jogo atualmente se encontra no status %s\n", board.getStatus().getLabel());
        if (board.hasErrors()) {
            System.out.println("O jogo contém erros");
        } else {
            System.out.println("O jogo não contém erros");
        }
    }

    private static void showCurrentGame() {
        if (Objects.isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        var args = new Object[81];
        var argPos = 0;
        for (int i = 0; i < BOARD_LIMIT; i++) {
            for (var col : board.getSpaces()) {
                args[argPos++] = " " + ((Objects.isNull(col.get(i).getActual())) ? " " : col.get(i).getActual());
            }
        }
        System.out.println("Seu jogo se encontra da seguinte forma: ");
        System.out.printf((BoardTemplate.BOARD_TEMPLATE) + "\n", args);
    }

    private static void removeNumber() {
        if (Objects.isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        System.out.println("Informe a coluna que em que o número será removido.");
        var col = runUntilGetValidNumber(0, 8);
        System.out.println("Informe a linha que em que o número será removido.");
        var row = runUntilGetValidNumber(0, 8);
        if (!board.clearValue(col, row)) {
            System.out.printf("A posição [%s,%s] tem um valor fixo.\n", col, row);
        } else {
            System.out.println("O número foi removido.");
        }
    }

    private static void inputNumber() {
        if (Objects.isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado.");
            return;
        }

        System.out.println("Informe a coluna que em que o número será inserido.");
        var col = runUntilGetValidNumber(0, 8);
        System.out.println("Informe a linha que em que o número será inserido.");
        var row = runUntilGetValidNumber(0, 8);
        System.out.printf("Informe o número que vai entrar na posição [%s,%s].\n", col, row);
        var value = runUntilGetValidNumber(1, 9);
        if (!board.changeValue(col, row, value)) {
            System.out.printf("A posição [%s,%s] tem um valor fixo\n", col, row);
        } else {
            System.out.println("O número foi adicionado");
        }
    }

    private static void startGame(Map<String, String> positions) {
        if (Objects.nonNull(board)) {
            System.out.println("O jogo já foi iniciado.");
            return;
        }

        List<List<Space>> spaces = new ArrayList<>();
        for (int i = 0; i < BOARD_LIMIT; i++) {
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; j++) {
                String positionConfig = positions.get("%s, %s".formatted(i, j));
                int expected = Integer.parseInt(positionConfig.split(",")[0]);
                boolean fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
                Space currentSpace = new Space(expected, fixed);
                spaces.get(i).add(currentSpace);
            }
        }

        board = new Board(spaces);
        System.out.println("O jogo já pode começar.");
    }

    private static int runUntilGetValidNumber(int min, int max) {
        int current = Sc.nextInt();
        while (current < min || current > max) {
            System.out.printf("Informe um número entre %s e %s\n", min, max);
            current = Sc.nextInt();
        }
        return current;
    }
}
