package com.platform.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.platform.dto.UavDTO;
import com.platform.service.UavService;
import com.platform.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@Slf4j
public class UavServiceImpl implements UavService {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 在线
     * @param uavDTO
     */
    @Override
    public void setUavOnline(UavDTO uavDTO) {
        String uavKey = UavService.UAV_ONLINE_KEY + "_" + uavDTO.getUavSn();
        BeanMap map = new BeanMap(uavDTO);
        for (Object key : map.keySet()) {
            if (map.get(key) == null) {
                continue;
            }
            redisUtil.hset(uavKey, key + "", map.get(key) + "");
        }
        redisUtil.expire(uavKey, 20);
    }

    /**
     * 获取通过无人机序列号
     * @param uavSn
     * @return
     */
    @Override
    public UavDTO getUavOnlineByUavSn(String uavSn) {
        UavDTO uavDTO = new UavDTO();
        String uavKey = UavService.UAV_ONLINE_KEY + "_" + uavSn;
        Map<Object, Object> map = redisUtil.hgetall(uavKey);
        if (MapUtils.isEmpty(map)) {
            return null;
        }
        try {
            BeanUtils.populate(uavDTO, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("Map转换对象异常,obj:{},map:{}", uavDTO, map);
        }
        return uavDTO;
    }

    /**
     * 获取所有在线无人机
     * @return
     */
    @Override
    public List<UavDTO> getAllUavOnline() {
        List<UavDTO> uavDTOList = Lists.newArrayList();
        Set<String> onlineKeysSet = redisUtil.keys("*ONLINE*");
        for (String key : onlineKeysSet) {
            UavDTO uavDTO = new UavDTO();
            Map<Object, Object> map = redisUtil.hgetall(key);
            if (MapUtils.isEmpty(map)) {
                return null;
            }
            try {
                BeanUtils.populate(uavDTO, map);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                log.error(e.getMessage());
                log.error("Map转换对象异常,obj:{},map:{}", uavDTO, map);
            }
            uavDTOList.add(uavDTO);
        }
        return uavDTOList;
    }


}
