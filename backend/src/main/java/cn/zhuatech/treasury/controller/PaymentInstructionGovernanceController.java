/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.treasury.controller;

import cn.zhuatech.treasury.common.ApiResponse;
import cn.zhuatech.treasury.service.PaymentInstructionGovernanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enterprise/treasury")
public class PaymentInstructionGovernanceController {
    private final PaymentInstructionGovernanceService service;
    public PaymentInstructionGovernanceController(PaymentInstructionGovernanceService service) { this.service = service; }

    @PostMapping("/payment-instruction")
    public ApiResponse<PaymentInstructionGovernanceService.Assessment> assess(
            @Valid @RequestBody PaymentInstructionGovernanceService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
