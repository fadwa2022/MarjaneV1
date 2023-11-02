package service;

import Entity.PromotionsEntity;

import java.util.List;

public interface PromotionService {
    List<PromotionsEntity> getPromotionByProductId(int productId);
    List<PromotionsEntity> getPromotionByCategoryId(int categoryId);
    List<PromotionsEntity> getPromotionsByCategory() ;

}
