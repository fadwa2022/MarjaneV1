package service.Impl;

import Entity.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.AbstractDao;
import service.AbstractService;

import java.util.List;

@Service
@Transactional
public class AdminServiceImp implements AbstractService <AdminEntity>  {
    @Autowired
    private AbstractDao adminDao;

    @Override
    public int save(AdminEntity admin) {

        return adminDao.save(admin);
    }

    @Override
    public AdminEntity get(int id) {
        return adminDao.get(id);
    }

    @Override
    public List<AdminEntity> list() {
        return adminDao.list();
    }

    @Override
    public void update(int id, AdminEntity admin) {
        adminDao.update(id, admin);

    }

    @Override
    public void delete(int id) {
        adminDao.delete(id);

    }
}
