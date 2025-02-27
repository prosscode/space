package com.space.service.impl;

import com.space.entity.ShopInfo;
import com.space.mapper.LoginMapper;
import com.space.service.LoginService;
import com.space.utils.InfoEncryption;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @describe:
 * @author: 彭爽pross
 * @date: 2019/02/16
 */
@Service
public class LoginServiceImpl implements LoginService {
    private static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 商户注册
     * @param login
     * @return
     */
    @Transactional
    public int registered(ShopInfo login) throws Exception {
        logger.info("LoginServiceImpl|registered,barName:"+login.getBarName());
        int returnNum = 0;
        try{
            String currentTime = DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
            login.setCreateDate(currentTime);
            // 注册到店铺信息

            int count = loginMapper.registered(login);
            Integer shopId = login.getShopId();
            String mark = DateFormatUtils.format(new Date(),"yyyyMMdd");
            String uniqueMark = "A"+mark+Integer.toString(shopId);
            // 插入商家编号
            loginMapper.insertShopMark(shopId,uniqueMark);
            // 生成登录账号，可以进行登录
            String userName = login.getUserName();
            String password = login.getPassword();
            int shopIdPass = login.getShopId();
            // 进行加密存储
            String passwordBASE64 = InfoEncryption.encryptBASE64(password);
            returnNum = loginMapper.insertLogin(userName, passwordBASE64,shopIdPass);

        }catch (Exception e){
            logger.error("LoginServiceImpl|registered,error message:" + e.getMessage() ,e);
        }
        return returnNum;
    }

    /**
     * 检查用户名是否存在
     * @param userName
     * @return
     */
    public Integer checkUserName(String userName) {
        return loginMapper.checkUserName(userName);
    }

    /**
     * 检查用户名是否存在
     * @param userName
     * @return
     */
    public Integer checkBarName(String userName) {
        return loginMapper.checkBarName(userName);
    }

    /**
     * 登录
     * @param userName
     * @return
     */
    public void login(String userName,String password) throws Exception {
        // 拿出数据库的加密的密码
        String passwordDB = loginMapper.login(userName);
        if(StringUtils.isBlank(passwordDB)){
            throw new Exception("用户名/密码错误");
        }
        // 解密
        String passwordBASE64 = InfoEncryption.decryptBASE64(passwordDB);
        // 比较
        if(password.equals(passwordBASE64)){
            return;
        }else{
            throw new Exception("用户名/密码错误");
        }
    }

    public static void main(String[] args) {
        System.out.println(DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
    }
}
