package ui;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import persistence.config.ConnectionConfig;
import persistence.dto.BoardColumnInfoDTO;
import persistence.dto.BoardDetailsDTO;
import persistence.entity.BoardColumnEntity;
import persistence.entity.BoardEntity;
import persistence.entity.CardEntity;
import service.BoardColumnQueryService;
import service.BoardQueryService;
import service.CardQueryService;
import service.CardService;

@AllArgsConstructor
public class BoardMenu {
    private final BoardEntity entity;
    private static Scanner Sc = new Scanner(System.in);

    public void execute() throws SQLException {
        System.out.printf("Bem-vindo ao board %s, selecione a operação que deseja: \n", entity.getId());
        int option = -1;
        while (option != 9) {
            System.out.println("============================");
            System.out.println("1 - Criar um card");
            System.out.println("2 - Mover um card");
            System.out.println("3 - Bloquear um card");
            System.out.println("4 - Desbloquear um card");
            System.out.println("5 - Cancelar um card");
            System.out.println("6 - Ver board");
            System.out.println("7 - Ver coluna");
            System.out.println("8 - Ver card");
            System.out.println("9 - Voltar para o menu");
            System.out.println("10 - Sair");
            option = Sc.nextInt();
            Sc.nextLine();
            switch (option) {
                case 1 -> createCard();
                case 2 -> moveCard();
                case 3 -> blockCard();
                case 4 -> unblockCard();
                case 5 -> cancelCard();
                case 6 -> showBoard();
                case 7 -> showColumn();
                case 8 -> showCard();
                case 9 -> System.out.println("Voltando para o menu anterior");
                case 10 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        }
    }

    private void createCard() throws SQLException {
        CardEntity card = new CardEntity();
        System.out.println("Informe o título do card");
        card.setTitle(Sc.nextLine());
        System.out.println("Informe a descrição do card");
        card.setDescription(Sc.nextLine());
        card.setBoardColumnEntity(entity.getInitialColumn());
        try (Connection connection = ConnectionConfig.getConnection()) {
            new CardService(connection).insert(card);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void moveCard() throws SQLException {
        System.out.println("Insira o id do card que deseja mover para próxima coluna: ");
        Long cardId = Sc.nextLong();
        Sc.nextLine();
        List<BoardColumnInfoDTO> boardColumnInfoDTOs = entity.getBoardColumns().stream()
                .map(bc -> new BoardColumnInfoDTO(bc.getId(), bc.getOrder(), bc.getKind())).toList();
        try (Connection connection = ConnectionConfig.getConnection()) {
            new CardService(connection).moveToNextColumn(cardId, boardColumnInfoDTOs);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void blockCard() throws SQLException {
        System.out.println("Insira o id do card que será bloqueado: ");
        Long cardId = Sc.nextLong();
        Sc.nextLine();
        System.out.println("Informe o motivo do bloqueio do card: ");
        String reason = Sc.nextLine();
        List<BoardColumnInfoDTO> boardColumnInfoDTOs = entity.getBoardColumns().stream()
                .map(bc -> new BoardColumnInfoDTO(bc.getId(), bc.getOrder(), bc.getKind())).toList();
        try (Connection connection = ConnectionConfig.getConnection()) {
            new CardService(connection).block(cardId, reason, boardColumnInfoDTOs);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void unblockCard() throws SQLException {
        System.out.println("Insira o id do card que será desbloqueado: ");
        Long cardId = Sc.nextLong();
        Sc.nextLine();
        System.out.println("Informe o motivo do desbloqueio do card: ");
        String reason = Sc.nextLine();
        try (Connection connection = ConnectionConfig.getConnection()) {
            new CardService(connection).unblock(cardId, reason);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void cancelCard() throws SQLException {
        System.out.println("Insira o id do card que deseja mover para coluna de cancelamento");
        Long cardId = Sc.nextLong();
        Sc.nextLine();
        BoardColumnEntity cancelColumn = entity.getCancelColumn();
        List<BoardColumnInfoDTO> boardColumnInfoDTOs = entity.getBoardColumns().stream()
                .map(bc -> new BoardColumnInfoDTO(bc.getId(), bc.getOrder(), bc.getKind())).toList();
        try (Connection connection = ConnectionConfig.getConnection()) {
            new CardService(connection).cancel(cardId, cancelColumn.getId(), boardColumnInfoDTOs);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showBoard() throws SQLException {
        try (Connection connection = ConnectionConfig.getConnection()) {
            Optional<BoardDetailsDTO> optional = new BoardQueryService(connection).showBoardDetails(entity.getId());
            optional.ifPresent(b -> {
                System.out.printf("Board [%s, %s]\n", b.id(), b.name());
                b.columns().forEach(c -> {
                    System.out.printf("Coluna [%s] | tipo [%s] | tem [%s] cards\n", c.name(), c.kind(),
                            c.cardsAmount());
                });
            });

        }
    }

    private void showColumn() throws SQLException {
        List<Long> columnsIds = entity.getBoardColumns().stream().map(BoardColumnEntity::getId).toList();
        Long selectedColumn = -1L;
        while (!columnsIds.contains(selectedColumn)) {
            System.out.printf("Escolha uma coluna do board %s\n", entity.getName());
            entity.getBoardColumns()
                    .forEach(c -> System.out.printf("%s - %s [%s]\n", c.getId(), c.getName(), c.getKind()));
            selectedColumn = Sc.nextLong();
            Sc.nextLine();
        }

        try (Connection connection = ConnectionConfig.getConnection()) {
            Optional<BoardColumnEntity> column = new BoardColumnQueryService(connection).findById(selectedColumn);
            column.ifPresent(co -> {
                System.out.printf("Coluna %s | tipo %s\n", co.getName(), co.getKind());
                co.getCards().forEach(ca -> {
                    System.out.printf("Card %s: %s\nDescription: %s\n", ca.getId(), ca.getTitle(), ca.getDescription());
                });
            });
        }
    }

    private void showCard() throws SQLException {
        System.out.println("Informe o id do card que deseja visualizar: ");
        Long selectedCardId = Sc.nextLong();
        Sc.nextLine();
        try (Connection connection = ConnectionConfig.getConnection()) {
            new CardQueryService(connection).findById(selectedCardId).ifPresentOrElse(c -> {
                System.out.printf("Card %s - %s\nDescrição: %s\n", c.id(), c.title(), c.description());
                System.out
                        .println(c.blocked() ? "Está bloqueado pelo motivo: " + c.blockReason() : "Não está bloqueado");
                System.out.printf("Foi bloqueado %s vezes\n", c.blockAmount());
                System.out.printf("Está no momento na coluna %s - %s\n", c.columnId(), c.columnName());
            }, () -> System.out.printf("Não existe um card com o id %s\n", selectedCardId));
        }
    }
}
