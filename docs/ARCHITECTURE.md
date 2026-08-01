# 架构说明

```text
Vue 3 管理端 / 响应式 H5
          │ HTTP / JSON
Spring Security → Controller → Service → Spring Data JPA → MySQL 8
                                  │
                     流动性覆盖与风险规则
```

当前版本采用易于学习和二次开发的单体分层架构。`LiquidityCoverageService` 负责七日资金来源和需求测算，`OperationsService` 管理日常事项及风险概览。生产环境应继续增加银企直联、指令双人复核、密钥托管、账户级权限、不可篡改审计、交易限额与灾备机制。
