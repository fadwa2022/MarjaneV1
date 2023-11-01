package service;

import Entity.AdminEntity;

import java.util.List;

public interface AdminService {
    long save(AdminEntity admin);

    AdminEntity get(long id);

    List<AdminEntity> list();

    void update(long id, AdminEntity admin);

    void delete(long id);
}
