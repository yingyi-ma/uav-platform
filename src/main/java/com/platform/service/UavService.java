package com.platform.service;

import com.platform.dto.UavDTO;

import java.util.List;

public interface UavService {

    // 无人机在线状态
    String UAV_ONLINE_KEY = "UAV_ONLINE";

    // 无人机飞行信息
    String UAV_FLIGHT_DATA_KEY = "UAV_FLIGHT_DATA";

    void setUavOnline(UavDTO uavDTO);

    UavDTO getUavOnlineByUavSn(String uavSn);

    List<UavDTO> getAllUavOnline();
}
