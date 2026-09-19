/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.treasury.controller;
import cn.zhuatech.treasury.common.ApiResponse; import cn.zhuatech.treasury.service.LiquidityCoverageService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/admin/liquidity-coverage") public class LiquidityCoverageController {
    private final LiquidityCoverageService service; /**
                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                     */
public LiquidityCoverageController(LiquidityCoverageService service){this.service=service;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping ApiResponse<LiquidityCoverageService.CoverageResult> evaluate(@Valid @RequestBody LiquidityCoverageService.CoverageRequest request){return ApiResponse.ok(service.evaluate(request));}
}
