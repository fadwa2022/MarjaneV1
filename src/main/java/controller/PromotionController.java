package controller;

import Entity.PromotionsEntity;
import dao.AbstractDao;
import dao.PromotionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AbstractService;
import service.PromotionService;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/promotions")
public class PromotionController  {

    private AbstractService promotionsService;
    private  PromotionService promotionService1;

    @Autowired
    public PromotionController(@Qualifier("promotionsServiceImp") AbstractService promotionService, PromotionService promotionService1) {
        this.promotionsService = promotionService;
        this.promotionService1 = promotionService1;
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody PromotionsEntity promotion) {
        int id = promotionsService.save(promotion);
        return ResponseEntity.ok().body("New promotion has been saved with ID:" + id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PromotionsEntity> get(@PathVariable("id") int id) {
        PromotionsEntity promotion = (PromotionsEntity) promotionsService.get(id);
        return ResponseEntity.ok().body(promotion);
    }
    @GetMapping("")
    public ResponseEntity<List<PromotionsEntity>> list() {
        List<PromotionsEntity> promotions = promotionsService.list();
        return ResponseEntity.ok().body(promotions);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PromotionsEntity promotion) {
        promotionsService.update(id, promotion);
        return ResponseEntity.ok().body("promotion has been updated successfully.");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        promotionsService.delete(id);
        return ResponseEntity.ok().body("promotion has been deleted successfully.");
    }
    @GetMapping("/byProductId/{productId}")
    public ResponseEntity<List<PromotionsEntity>> getPromotionByProductId(@PathVariable("productId") int productId) {
        List<PromotionsEntity> promotions = promotionService1.getPromotionByProductId(productId);
        return ResponseEntity.ok().body(promotions);
    }
    @GetMapping("/byCategoryId/{categoryId}")
    public ResponseEntity<List<PromotionsEntity>> getPromotionByCategoryId(@PathVariable("categoryId") int categoryId) {
        List<PromotionsEntity> promotions = promotionService1.getPromotionByCategoryId(categoryId);
        return ResponseEntity.ok().body(promotions);
    }

}