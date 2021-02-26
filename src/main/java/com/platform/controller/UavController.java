package com.platform.controller;


import com.google.common.collect.Maps;
import com.platform.common.CommonResult;
import com.platform.dto.UavDTO;
import com.platform.service.UavService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@Api(tags = "001.UavController 无人机实时信息")
@RestController
@Slf4j
public class UavController {

    @Resource
    private UavService uavService;

    @ApiOperation(value = "获取在线无人机 - 单台", notes = "")
    @GetMapping("/get/online/{uavSn}")
    public CommonResult<UavDTO> getByUavSn(@PathVariable("uavSn") String uavSn) {
        UavDTO uavDTO = uavService.getUavOnlineByUavSn(uavSn);
        return CommonResult.success(uavDTO);
    }

    @ApiOperation(value = "获取在线无人机 - 所有", notes = "")
    @GetMapping("/get/online/all")
    public CommonResult<List<UavDTO>> getOnlineList() {
        List<UavDTO> uavDTOList = uavService.getAllUavOnline();
        return CommonResult.success(uavDTOList);
    }

    /**
     * 无人机实时数据
     */
    @ApiOperation(value = "接收无人机数据 - 来源APP", notes = "")
    @PostMapping(value = "pushRealTimeData")
    public CommonResult pushRealTimeData(@RequestBody UavDTO uavDTO) {
        uavService.setUavOnline(uavDTO);
        return CommonResult.success();
    }

}
