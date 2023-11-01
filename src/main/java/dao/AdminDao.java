package dao;

import java.util.List;

import Entity.AdminEntity;


public interface AdminDao {

    long save(AdminEntity admin);

    AdminEntity get(long id);

    List<AdminEntity> list();

    void update(long id, AdminEntity admin);

    void delete(long id);

}