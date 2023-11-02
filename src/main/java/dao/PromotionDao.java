package dao;

import Entity.PromotionsEntity;

import java.util.List;

public interface PromotionDao {
    List<PromotionsEntity> getPromotionByProductId(int productId);
    List<PromotionsEntity> getPromotionByCategoryId(int categoryId);
   List<PromotionsEntity> getPromotionsByCategory() ;

}
