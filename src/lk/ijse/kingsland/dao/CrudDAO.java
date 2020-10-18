package lk.ijse.kingsland.dao;

import java.util.ArrayList;
import java.util.List;

public interface CrudDAO<T,ID> extends SuperDAO{

    public boolean add(T t) throws Exception;

    public boolean update(T t) throws Exception;

    public boolean delete(ID id) throws Exception;

    public T serach(ID id) throws Exception;

    public ArrayList<T> getAll() throws Exception;



}
