package com.space.service.impl;

import com.space.entity.*;
import com.space.exception.PageEntity;
import com.space.mapper.CommodityMapper;
import com.space.mapper.DocumentInfoMapper;
import com.space.service.CommodityService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @describe:
 * @author: 彭爽pross
 * @date: 2019/03/01
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private DocumentInfoMapper documentInfoMapper;

    /**
     * 添加分组
     */
    @Override
    public int addGoodType(Integer shopId, String typeName, String typeSubName, Integer seatNumber, Integer role) {
        int num = 0;
        // 添加时间 为当前时间
        String currentTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        if (StringUtils.isBlank(typeSubName) && seatNumber == 0) {
            // 添加商品父分组
            num = commodityMapper.addGoodType(typeName, shopId, currentTime);
        }

        if (seatNumber != 0 && !StringUtils.isBlank(typeSubName)) {
            // 添加子分组
            role = 1;
            num = commodityMapper.addGoodSubType(typeName, typeSubName, shopId, seatNumber, currentTime, role);
        }
        return num;
    }

    /**
     * 查询座位分组
     */
    @Override
    public PageEntity getGoodType(Integer shopId) {
        PageEntity entity = new PageEntity();
        List<CommodityType> type = commodityMapper.getGoodType(shopId);
        entity.setList(type);
        entity.setCount(0);
        return entity;
    }

    /**
     * 删除分组
     */
    @Override
    public int deleteGoodType(Integer shopId, String typeName) {
        return commodityMapper.deleteGoodType(shopId, typeName);
    }

    /**
     * 编辑分组
     */
    @Override
    public int updateGoodType(Integer typeId, Integer shopId, String typeName) {
        return commodityMapper.updateGoodType(typeId, shopId, typeName);

    }

    /**
     * 查询商品
     */
    @Override
    public PageEntity getGoods(String productName,
                               Integer pageNo,
                               Integer pageSize,
                               Integer productCategoryNo,
                               Integer shopId,
                               Integer productStatus,
                               String keyWord,Integer optNum) {
        logger.info("CommodityServiceImpl|getGoods,productName:" + productName + ",pageNo:" + pageNo + ",pageSize" + pageSize);
        // 查询
        List<Commodity> goods = commodityMapper.getGoods(productName, pageNo, pageSize, productCategoryNo, shopId, productStatus, keyWord);
        if(optNum>=1){
            for (Commodity item:goods){
                item= GetGoodById(item.getProductId(),optNum);
            }
        }
        // 总数
        int goodsCount = commodityMapper.getGoodsCount(productName);
        PageEntity pageEntity = new PageEntity();
        pageEntity.setList(goods);
        pageEntity.setCount(goodsCount);
        return pageEntity;
    }


    /**
     * 判断添加商品，商品名称是否存在
     */
    @Override
    public int checkProductName(String productName) {
        logger.info("CommodityServiceImpl|checkProductName,productName:" + productName);
        int count = commodityMapper.checkProductName(productName);
        return count;
    }

    /**
     * 发布商品
     */
    @Override
    public int addGood(Commodity commodity) {
        int addGood = 0;
        try {
            logger.info("CommodityServiceImpl|publishGoods,commodity:" + commodity.toString());
            commodity.setCreateTime(new Date());
            addGood = commodityMapper.addGood(commodity);
            List<DocumentInfo> documentInfos = commodity.getDocumentInfos();
            //商品价格关联
            List<CommodityPrice> CommodityPriceList = commodity.getCommodityPriceList();
            //添加商品图片
            if (documentInfos != null && documentInfos.size() > 0) {
                for (DocumentInfo ditem : documentInfos) {
                    CommodityDocument commodityDocument = new CommodityDocument();
                    commodityDocument.setCommodityId(commodity.getProductId());
                    commodityDocument.setShopId(commodity.getShopId());
                    commodityDocument.setDocumentId(ditem.getDocumentId());
                    commodityMapper.addCommodityDocument(commodityDocument);
                }
            }
            //添加商品价格时间设置
            if (CommodityPriceList != null && CommodityPriceList.size() > 0) {
                for (CommodityPrice pitem : CommodityPriceList) {
                    commodityMapper.addCommodityPrices(pitem);
                }
            }
        } catch (Exception e) {
            logger.error("CommodityServiceImpl|publishGoods,error message:" + e.getMessage(), e);
        }
        return addGood;
    }

    /*商品详情 根据商品ID*/
    @Override
    public Commodity GetGoodById(Integer commodityId, Integer optNum) {
        Commodity model = commodityMapper.getCommodityById(commodityId);
        if (optNum > 0) {
            List<Integer> commodityIds = new ArrayList<>();
            commodityIds.add(commodityId);
            //文档数据
            List<CommodityDocument> commodityDocumentList = commodityMapper.getCommodityDocuments(commodityIds);
            List<String> documentIds = new ArrayList<>();
            if (commodityDocumentList != null && commodityDocumentList.size() > 0) {
                commodityDocumentList.forEach((g)->{
                    documentIds.add(g.getDocumentId());
                });
                String[] arraydIds = documentIds.toArray(new String[documentIds.size()]);
                model.setDocumentInfos(documentInfoMapper.getByIds(arraydIds));
                model.setDefaultDocument(model.getDocumentInfos().get(0));
            }
            //价格数据
            //商品价格关联
            List<CommodityPrice> CommodityPriceList = commodityMapper.getPricesByCommodityId(commodityId);
            if(CommodityPriceList!=null&&CommodityPriceList.size()>0){
                Date curDate=new Date();
                SimpleDateFormat f=new SimpleDateFormat("HH");
                int curDateHour=Integer.parseInt( f.format(curDate));
                for (CommodityPrice price : CommodityPriceList) {
                    if (price.getStartTime() <= curDateHour && curDateHour <= price.getEndTime()) {
                        model.setPrice(price.getPrice());
                        break;
                    }
                }
            }
        }
        return model;
    }

    /**
     * 删除和上架商品
     */
    @Override
    public int deleteAndUpGoods(List<Integer> productIds, Integer opNumber, List<Object> setValues) {
        int returnNum = 0;
        try {

            if (opNumber == 0) {
                //关联文档
                List<CommodityDocument> commodityDocumentList = commodityMapper.getCommodityDocuments(productIds);
                // 删除商品和删除价格和删除关联文档
                returnNum = commodityMapper.deleteProducts(productIds);
                //删除商品价格
                commodityMapper.deletePrice(productIds);
                //删除关联文档
                commodityMapper.deleteCommodityDocumentByCommodityIds(productIds);
                if (commodityDocumentList != null && commodityDocumentList.size() > 0) {
                    List<String> documentIds = new ArrayList<>();
                    for (CommodityDocument citem : commodityDocumentList) {
                        documentIds.add(citem.getDocumentId());
                    }
                    String[] array = documentIds.toArray(new String[documentIds.size()]);

                    documentInfoMapper.deleteByIds(array);
                }

            } else {
                // 上架
                returnNum = commodityMapper.upProduct(opNumber, productIds, setValues);
            }
        } catch (Exception e) {
            logger.error("CommodityServiceImpl|deleteAndUpGoods,error message:" + e.getMessage(), e);
        }
        return returnNum;
    }

    /**
     * 更新商品
     */
    @Override
    public int updateGood(Commodity commodity) {
        try {
            List<DocumentInfo> documentInfos = commodity.getDocumentInfos();
            // List<CommodityDocument> CommodityDocumentList =commodity.getCommodityDocumentList();
            //删除商品图片
            commodityMapper.deleteCommodityDocumentByCommodityId(commodity.getProductId());
            //添加商品图片
            if (documentInfos != null && documentInfos.size() > 0) {
                for (DocumentInfo ditem : documentInfos) {
                    CommodityDocument commodityDocument = new CommodityDocument();
                    commodityDocument.setCommodityId(commodity.getProductId());
                    commodityDocument.setShopId(commodity.getShopId());
                    commodityDocument.setDocumentId(ditem.getDocumentId());
                    commodityMapper.addCommodityDocument(commodityDocument);
                }
            }
            //商品价格关联
            List<CommodityPrice> CommodityPriceList = commodity.getCommodityPriceList();
            //添加商品价格时间设置
            commodityMapper.deletePriceByCommodityId(commodity.getProductId());
            if (CommodityPriceList != null && CommodityPriceList.size() > 0) {
                for (CommodityPrice pitem : CommodityPriceList) {
                    commodityMapper.addCommodityPrices(pitem);
                }
            }
            return commodityMapper.updateGood(commodity);
        } catch (Exception e) {
            logger.error("CommodityServiceImpl|publishGoods,error message:" + e.getMessage(), e);
            return -1;
        }
    }


    /**
     * 添加座位编号
     */
    @Override
    public int addSeatMark(Integer shopId, String seatType, String seatPrefix, Integer seatNum, Integer seatCount) {
        String seatMark = seatPrefix + seatNum;
        return commodityMapper.addSeatMark(shopId, seatType, seatMark, seatCount);
    }

    /**
     * 查询桌位
     */
    @Override
    public PageEntity getSeat(Integer shopId) {
        List<ShopSeat> seat = commodityMapper.getSeat(shopId);
        PageEntity entity = new PageEntity();
        entity.setList(seat);
        entity.setCount(0);
        return entity;
    }

    /**
     * 删除桌位
     */
    @Override
    public int deleteSeat(Integer seatId, Integer shopId) {
        return commodityMapper.deleteSeat(seatId, shopId);
    }

    /**
     * 删除商品时，检查商品中是否 存在上架商品
     */
    @Override
    public int checkProductUp(List<Integer> productIds) {
        logger.info("CommodityServiceImpl|checkProductUp,productIds:" + productIds.toString());
        return commodityMapper.checkProductUp(productIds);
    }


}
