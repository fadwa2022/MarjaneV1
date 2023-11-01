package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Entity.AdminEntity;
import service.AdminService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /*---Add new admin---*/
    @PostMapping("/admin")
    public ResponseEntity<?> save(@RequestBody AdminEntity admin) {
        System.out.println("the json value of admin is :::::: "+admin);
        long id = adminService.save(admin);
        return ResponseEntity.ok().body("New admin has been saved with ID:" + id);
    }

    /*---Get a admin by id---*/
    @GetMapping("/admin/{id}")
    public ResponseEntity<AdminEntity> get(@PathVariable("id") long id) {
        AdminEntity admin = adminService.get(id);
        return ResponseEntity.ok().body(admin);
    }

    /*---get all admins---*/
    @GetMapping("/admin")
    public ResponseEntity<List<AdminEntity>> list() {
        List<AdminEntity> admins = adminService.list();
        return ResponseEntity.ok().body(admins);
    }

    /*---Update a admin by id---*/
    @PutMapping("/admin/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody AdminEntity admin) {
        adminService.update(id, admin);
        return ResponseEntity.ok().body("admin has been updated successfully.");
    }

    /*---Delete a admin by id---*/
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        adminService.delete(id);
        return ResponseEntity.ok().body("admin has been deleted successfully.");
    }
}
