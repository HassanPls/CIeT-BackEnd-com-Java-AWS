package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import exception.CardBlockedException;
import exception.CardFinishedException;
import exception.EntityNotFoundedException;
import lombok.AllArgsConstructor;
import persistence.dao.CardDAO;
import persistence.dto.BoardColumnInfoDTO;
import persistence.dto.CardDetailsDTO;
import persistence.entity.BoardColumnKindEnum;
import persistence.entity.CardEntity;

@AllArgsConstructor
public class CardService {
    private final Connection connection;

    public CardEntity insert(final CardEntity entity) throws SQLException {
        try {
            CardDAO dao = new CardDAO(connection);
            dao.insert(entity);
            connection.commit();
            return entity;
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

    public void moveToNextColumn(final Long cardId, final List<BoardColumnInfoDTO> boardColumnInfoDTOs)
            throws SQLException {
        try {
            CardDAO dao = new CardDAO(connection);
            Optional<CardDetailsDTO> optional = dao.findById(cardId);
            CardDetailsDTO dto = optional.orElseThrow(
                    () -> new EntityNotFoundedException(String.format("O card de id %s não foi encontrado", cardId)));
            if (dto.blocked()) {
                throw new CardBlockedException(
                        String.format("O card %s está bloqueado. É necessário desbloquea-lo.", cardId));
            }
            BoardColumnInfoDTO boardColumnInfo = boardColumnInfoDTOs.stream()
                    .filter(bc -> bc.id().equals(dto.columnId())).findFirst()
                    .orElseThrow(() -> new IllegalStateException("O card informado percente a outro board"));
            if (boardColumnInfo.kind()
                    .equals(BoardColumnKindEnum.FINAL)) {
                throw new CardFinishedException("O card já foi finalizado");
            }
            BoardColumnInfoDTO nextColumn = boardColumnInfoDTOs.stream()
                    .filter(bc -> bc.order() == boardColumnInfo.order() + 1).findFirst()
                    .orElseThrow(() -> new IllegalStateException("O card está cancelado"));
            dao.moveToColumn(nextColumn.id(), cardId);
            connection.commit();
            System.out.println("Card movido com sucesso");
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

    public void cancel(final Long cardId, final Long cancelColumnId, final List<BoardColumnInfoDTO> boardColumnInfoDTOs)
            throws SQLException {
        try {

            CardDAO dao = new CardDAO(connection);
            Optional<CardDetailsDTO> optional = dao.findById(cardId);
            CardDetailsDTO dto = optional.orElseThrow(
                    () -> new EntityNotFoundedException(String.format("O card de id %s não foi encontrado", cardId)));

            if (dto.blocked()) {
                throw new CardBlockedException(
                        String.format("O card %s está bloqueado. É necessário desbloquea-lo.", cardId));
            }
            BoardColumnInfoDTO boardColumnInfo = boardColumnInfoDTOs.stream()
                    .filter(bc -> bc.id().equals(dto.columnId())).findFirst()
                    .orElseThrow(() -> new IllegalStateException("O card informado percente a outro board"));
            if (boardColumnInfo.kind()
                    .equals(BoardColumnKindEnum.FINAL)) {
                throw new CardFinishedException("O card já foi finalizado");
            }
            boardColumnInfoDTOs.stream()
                    .filter(bc -> bc.order() == boardColumnInfo.order() + 1).findFirst()
                    .orElseThrow(() -> new IllegalStateException("O card está cancelado"));
            dao.moveToColumn(cancelColumnId, cardId);
            connection.commit();
            System.out.println("Card foi cancelado com sucesso");
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

    public void block(final Long cardId, final String reason, final List<BoardColumnInfoDTO> boardColumnInfoDTOs)
            throws SQLException {
        try {

            CardDAO dao = new CardDAO(connection);
            Optional<CardDetailsDTO> optional = dao.findById(cardId);
            CardDetailsDTO dto = optional.orElseThrow(
                    () -> new EntityNotFoundedException(String.format("O card de id %s não foi encontrado.", cardId)));

            if (dto.blocked()) {
                throw new CardBlockedException(
                        String.format("O card %s já está bloqueado.", cardId));
            }

            BoardColumnInfoDTO boardColumnInfo = boardColumnInfoDTOs.stream()
                    .filter(bc -> bc.id().equals(dto.columnId())).findFirst()
                    .orElseThrow(() -> new IllegalStateException("O card informado percente a outro board"));
            if (boardColumnInfo.kind().equals(BoardColumnKindEnum.FINAL) || 
                boardColumnInfo.kind().equals(BoardColumnKindEnum.CANCEL)) {
                throw new CardFinishedException(String.format(
                        "O card está em uma coluna do tipo [%s] e não pode ser bloqueado", boardColumnInfo.kind()));
            }
            dao.block(cardId, reason);
            connection.commit();
            System.out.println("Card foi bloqueado com sucesso");
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

    public void unblock(final Long cardId, final String reason) throws SQLException {
        try {

            CardDAO dao = new CardDAO(connection);
            Optional<CardDetailsDTO> optional = dao.findById(cardId);
            CardDetailsDTO dto = optional.orElseThrow(
                    () -> new EntityNotFoundedException(String.format("O card de id %s não foi encontrado.", cardId)));

            if (!dto.blocked()) {
                throw new CardBlockedException(
                        String.format("O card %s já está desbloqueado.", cardId));
            }

            dao.unblock(cardId, reason);
            connection.commit();
            System.out.println("Card foi desbloqueado com sucesso");
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }
}
