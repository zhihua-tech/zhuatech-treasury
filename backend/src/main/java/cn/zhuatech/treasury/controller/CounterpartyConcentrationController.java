/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.treasury.controller;
import cn.zhuatech.treasury.common.ApiResponse;import cn.zhuatech.treasury.service.CounterpartyConcentrationService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/treasury/insights/counterparty-concentration") public class CounterpartyConcentrationController {private final CounterpartyConcentrationService service;/**
                                                                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                               */
public CounterpartyConcentrationController(CounterpartyConcentrationService service){this.service=service;}/**
                                                                                                                                                                                                                                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                          */
@PostMapping ApiResponse<CounterpartyConcentrationService.Result> evaluate(@Valid @RequestBody CounterpartyConcentrationService.Request request){return ApiResponse.ok(service.evaluate(request));}}
