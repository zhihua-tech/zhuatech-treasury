# 企业级司库付款指令治理

本模块校验收款方白名单、账户验证、制裁筛查、流动性缓冲、制单复核分离、金额授权、数字签名和高额付款带外确认。

`POST /api/enterprise/treasury/payment-instruction` 返回 `SEND / APPROVAL_REQUIRED / HOLD` 决策。生产使用应与银行直联、硬件签名、动态授权矩阵和交易监控联动。
