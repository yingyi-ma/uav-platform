package com.platform.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 数据推送 数据DTO
 * 含在飞无人机的飞行轨迹序列
 */
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@ApiModel
public class UavDTO implements Serializable {

    @ApiModelProperty("无人机是否直播: 1-直播 0-未直播")
    private Integer isLive;

    @ApiModelProperty("无人机直播地址")
    private String liveUrl;

    @ApiModelProperty("品牌")
    private String uavBrand;

    @ApiModelProperty("无人机型号")
    private String uavModel;

    @ApiModelProperty("无人机飞控序列号")
    private String uavSn;

    @ApiModelProperty("无人机固件版本")
    private String uavSw;

    @ApiModelProperty("home位置-经度")
    private String homeLongitude;

    @ApiModelProperty("Home位置-纬度")
    private String homeLatitude;

//    @ApiModelProperty("飞行轨迹 lng, lat")
//    private List<double[]> flightPath;

    //====================无人机电池状态信息=============

    @ApiModelProperty("电池电压，单位mv")
    private String voltage;

    @ApiModelProperty("电池电流，正数正在充电，负数正在放电，单位ma")
    private String current;

    @ApiModelProperty("剩余电量百分比")
    private String lifeTime;

    @ApiModelProperty("电池温度")
    private String temperature;

    //=================无人机飞行数据==============

    @ApiModelProperty("飞行高度")
    private String altitude;

    @ApiModelProperty("水平飞行速度")
    private String velocity;

    @ApiModelProperty("垂直飞行速度")
    private String verticalSpeed;

    @ApiModelProperty("飞行航向")
    private String attitude;

    @ApiModelProperty("飞行方位角")
    private String flyHeading;

    @ApiModelProperty("当前坐标经度")
    private String longitude;

    @ApiModelProperty("当前坐标纬度")
    private String latitude;

    @ApiModelProperty("是否在飞行")
    private String isFlying;

    @ApiModelProperty("开机后累计飞行时长")
    private String flightTimesec;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("电池告警")
    private String batteryWarning;

    @ApiModelProperty("大风告警")
    private String windWarning;

    @ApiModelProperty("是否到达最大高度")
    private String maxHeight;

    @ApiModelProperty("是否到达最大半径")
    private String maxRadius;

    @ApiModelProperty("下行带宽")
    private String bandwidth;

    @ApiModelProperty("图像传输质量")
    private String videoTransportRate;

    @ApiModelProperty("图传信号")
    private String videoSignal;

    @ApiModelProperty("遥控器信号")
    private String remoteControlSignal;

    @ApiModelProperty("遥控器电量")
    private String remoteControlBattery;

    @ApiModelProperty("俯仰角")
    private String pitch;

    @ApiModelProperty("横滚角")
    private String roll;

    //==============无人机GPS信息===================

    @ApiModelProperty("卫星个数")
    private String gpsNum;

    @ApiModelProperty("卫星信号等级")
    private String gpsLevel;

    @ApiModelProperty("飞行模式")
    private String flightMode;

    @ApiModelProperty("起飞时间，用于标记同一段飞行轨迹")
    private String startTime;


}
