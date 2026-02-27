package ui;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import persistence.config.ConnectionConfig;
import persistence.entity.BoardColumnEntity;
import persistence.entity.BoardColumnKindEnum;
import persistence.entity.BoardEntity;
import service.BoardQueryService;
import service.BoardService;

public class MainMenu {
    private final Scanner Sc = new Scanner(System.in);

    public void execute() throws SQLException {
        System.out.println("Bem-vindo ao gerenciador de boards, escolha a opção desejada: ");
        int option = -1;
        while (true) {
            System.out.println("======================");
            System.out.println("1 - Criar um novo board");
            System.out.println("2 - Selecionar um board existente");
            System.out.println("3 - Excluir um board");
            System.out.println("4 - Sair");
            option = Sc.nextInt();
            Sc.nextLine();
            switch (option) {
                case 1 -> createBoard();
                case 2 -> selectBoard();
                case 3 -> deleteBoard();
                case 4 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        }
    }

    private void createBoard() throws SQLException {
        BoardEntity entity = new BoardEntity();
        System.out.println("Informe o nome do seu board: ");
        entity.setName(Sc.nextLine());

        System.out.println("Seu board terá colunas além de 3 padrões? Se sim informe quantas, senão digite 0");
        int additionalColumns = Sc.nextInt();
        Sc.nextLine();

        List<BoardColumnEntity> columns = new ArrayList<>();

        System.out.println("Informe o nome da coluna inicial do board: ");
        String initialColumnName = Sc.nextLine();
        BoardColumnEntity initialColumn = createColumn(initialColumnName, BoardColumnKindEnum.INITIAL, 0);
        columns.add(initialColumn);

        for (int i = 0; i < additionalColumns; i++) {
            System.out.println("Informe o nome da coluna de pendentes do board: ");
            String pendingColumnName = Sc.nextLine();
            BoardColumnEntity pendingColumn = createColumn(pendingColumnName, BoardColumnKindEnum.PENDING, i + 1);
            columns.add(pendingColumn);
        }

        System.out.println("Informe o nome da coluna de finais do board: ");
        String finalColumnName = Sc.nextLine();
        BoardColumnEntity finalColumn = createColumn(finalColumnName, BoardColumnKindEnum.FINAL, additionalColumns + 1);
        columns.add(finalColumn);

        System.out.println("Informe o nome da coluna de cancelados do board: ");
        String cancelColumnName = Sc.nextLine();
        BoardColumnEntity cancelColumn = createColumn(cancelColumnName, BoardColumnKindEnum.CANCEL,
                additionalColumns + 2);
        columns.add(cancelColumn);

        entity.setBoardColumns(columns);
        try (Connection connection = ConnectionConfig.getConnection()) {
            new BoardService(connection).insert(entity);
        }
    }

    private void selectBoard() throws SQLException {
        System.out.println("Informe o id do board que deseja selecionar");
        Long id = Sc.nextLong();
        Sc.nextLine();
        try (Connection connection = ConnectionConfig.getConnection()) {
            BoardQueryService queryService = new BoardQueryService(connection);
            Optional<BoardEntity> optional = queryService.findById(id);
            if (optional.isPresent()) {
                BoardMenu boardMenu = new BoardMenu(optional.get());
                boardMenu.execute();
            } else {
                System.out.printf("Não foi possível encontrar o board com id %s\n", id);
            }
        }
    }

    private void deleteBoard() throws SQLException {
        System.out.println("Informe o id da board que será excluida");
        Long id = Sc.nextLong();
        Sc.nextLine();
        try (Connection connection = ConnectionConfig.getConnection()) {
            BoardService service = new BoardService(connection);
            if (!service.delete(id)) {
                System.out.printf("Não foi possível encontrar o board com id %s\n", id);
            }
        }
    }

    private BoardColumnEntity createColumn(final String name, final BoardColumnKindEnum kind, final int order) {
        BoardColumnEntity boardColumnEntity = new BoardColumnEntity();
        boardColumnEntity.setName(name);
        boardColumnEntity.setKind(kind);
        boardColumnEntity.setOrder(order);
        return boardColumnEntity;
    }
}
