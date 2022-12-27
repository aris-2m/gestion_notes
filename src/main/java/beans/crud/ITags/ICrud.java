package beans.crud.ITags;

import java.sql.ResultSet;

public interface ICrud<T> {
    public ResultSet getAll();

    public ResultSet getById(int id);

    public int insert(T t);

    public int update(T t);

    public int delete(T t);
}
