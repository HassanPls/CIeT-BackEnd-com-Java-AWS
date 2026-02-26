package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import lombok.AllArgsConstructor;
import persistence.dao.CardDAO;
import persistence.dto.CardDetailsDTO;

@AllArgsConstructor
public class CardQueryService {
    private final Connection connection;

    public Optional<CardDetailsDTO> findById(final Long id) throws SQLException {
        CardDAO dao = new CardDAO(connection);
        return dao.findById(id);
    }
}
