package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import lombok.AllArgsConstructor;
import persistence.dao.BoardColumnDAO;
import persistence.entity.BoardColumnEntity;

@AllArgsConstructor
public class BoardColumnQueryService {
    private final Connection connection;

    public Optional<BoardColumnEntity> findById(final Long id) throws SQLException {
        BoardColumnDAO dao = new BoardColumnDAO(connection);
        return dao.findById(id);
    }
}
