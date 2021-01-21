package com.lei.min.core.controller;

import com.lei.min.common.model.ApiCode;
import com.lei.min.common.model.ApiResult;
import com.lei.min.common.service.INormalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: CoreController
 * @author: leiming5
 * @date: 2021-01-21 14:21
 */
@RestController
public class CoreController {

    /**
     * service 接口哦
     */
    @Resource
    private INormalService normalService;

    /**
     * 根据id 查询对象
     *
     * @param id id
     * @return 对象
     * @author leiming5
     */
    @GetMapping("normal/core")
    public ApiResult getById(Long id) {


        if (id == null) {
            return ApiResult.fail(ApiCode.PARAMETER_EXCEPTION);
        }

        return ApiResult.ok(normalService.getById(id));
    }
}
