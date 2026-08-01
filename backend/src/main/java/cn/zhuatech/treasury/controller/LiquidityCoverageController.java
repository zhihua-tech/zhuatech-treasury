/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.treasury.controller;
import cn.zhuatech.treasury.common.ApiResponse; import cn.zhuatech.treasury.service.LiquidityCoverageService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/admin/liquidity-coverage") public class LiquidityCoverageController {
    private final LiquidityCoverageService service; public LiquidityCoverageController(LiquidityCoverageService service){this.service=service;}
    @PostMapping ApiResponse<LiquidityCoverageService.CoverageResult> evaluate(@Valid @RequestBody LiquidityCoverageService.CoverageRequest request){return ApiResponse.ok(service.evaluate(request));}
}
