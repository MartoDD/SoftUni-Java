package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.TableRepository;

public class TableRepositoryImpl extends BaseRepository<Table> implements TableRepository<Table> {


    @Override
    public Table byNumber(int number) {
        return getAllEntities().stream().filter(table -> table.getTableNumber() == number).findFirst().orElse(null);
    }
}
