/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.treasury.controller;
import cn.zhuatech.treasury.common.ApiResponse;import cn.zhuatech.treasury.service.CounterpartyConcentrationService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/treasury/insights/counterparty-concentration") public class CounterpartyConcentrationController {private final CounterpartyConcentrationService service;public CounterpartyConcentrationController(CounterpartyConcentrationService service){this.service=service;}@PostMapping ApiResponse<CounterpartyConcentrationService.Result> evaluate(@Valid @RequestBody CounterpartyConcentrationService.Request request){return ApiResponse.ok(service.evaluate(request));}}
