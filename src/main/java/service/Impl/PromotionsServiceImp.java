package service.Impl;

import Entity.PromotionsEntity;
import dao.AbstractDao;
import dao.PromotionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AbstractService;
import service.PromotionService;

import java.util.List;

@Service
@Transactional
public class PromotionsServiceImp implements AbstractService<PromotionsEntity>, PromotionService

    {
        private final AbstractDao promotionDao;
        private final PromotionDao promotionDao1;

        @Autowired
        public PromotionsServiceImp(@Qualifier("promotionsDaoImpl") AbstractDao promotionDao, PromotionDao promotionDao1) {
            this.promotionDao = promotionDao;
            this.promotionDao1 = promotionDao1;
        }


        @Override
        public int save(PromotionsEntity promotion) {
            return promotionDao.save(promotion);
                                    }

        @Override
        public PromotionsEntity get(int id) {
        return (PromotionsEntity) promotionDao.get(id);
    }

        @Override
        public List<PromotionsEntity> list() {
        return promotionDao.list();
    }

        @Override
        public void update(int id, PromotionsEntity promotion) {
            PromotionsEntity existingPromotion = (PromotionsEntity) promotionDao.get(id);
            if (existingPromotion != null) {
                if (promotion.getStatus() == null) {
                    promotion.setStatus(existingPromotion.getStatus());
                }
                if (promotion.getComment() == null) {
                    promotion.setComment(existingPromotion.getComment());
                }
                if (promotion.getPourcentage() == null) {
                    promotion.setPourcentage(existingPromotion.getPourcentage());
                }
                if (promotion.getIdproduct() == null && promotion.getIdcategory() == null) {
                    promotion.setIdproduct(existingPromotion.getIdproduct());
                    promotion.setIdcategory(existingPromotion.getIdcategory());

                }

            }
            promotionDao.update(id, promotion);

    }

        @Override
        public void delete(int id) {
        promotionDao.delete(id);

    }

        @Override

      public List<PromotionsEntity> getPromotionByProductId(int productId) {
            return promotionDao1.getPromotionByProductId(productId);
        }
      public List<PromotionsEntity> getPromotionByCategoryId(int categoryId) {
            return promotionDao1.getPromotionByCategoryId(categoryId);
        }
      public List<PromotionsEntity> getPromotionsByCategory() {
            return promotionDao1.getPromotionsByCategory();
        }
    }

