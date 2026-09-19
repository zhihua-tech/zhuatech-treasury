/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.treasury.controller;

import cn.zhuatech.treasury.common.ApiResponse;
import cn.zhuatech.treasury.service.PaymentInstructionGovernanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/enterprise/treasury")
public class PaymentInstructionGovernanceController {
    private final PaymentInstructionGovernanceService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public PaymentInstructionGovernanceController(PaymentInstructionGovernanceService service) { this.service = service; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/payment-instruction")
    public ApiResponse<PaymentInstructionGovernanceService.Assessment> assess(
            @Valid @RequestBody PaymentInstructionGovernanceService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
