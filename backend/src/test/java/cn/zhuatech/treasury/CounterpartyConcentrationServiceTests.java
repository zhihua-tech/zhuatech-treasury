/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.treasury;
import cn.zhuatech.treasury.service.CounterpartyConcentrationService;import org.junit.jupiter.api.Test;import java.math.*;import static org.junit.jupiter.api.Assertions.*;
class CounterpartyConcentrationServiceTests {private final CounterpartyConcentrationService service=new CounterpartyConcentrationService();
 @Test void diversifiesConcentratedCash(){var r=service.evaluate(new CounterpartyConcentrationService.Request(b("1000"),b("650"),b("100"),"A",b("200"),b("100")));assertEquals("DIVERSIFY",r.status());assertEquals(65.0,r.concentrationRate());}
 @Test void acceptsBalancedPortfolio(){var r=service.evaluate(new CounterpartyConcentrationService.Request(b("1000"),b("300"),b("0"),"AA",b("200"),b("100")));assertEquals("BALANCED",r.status());}private BigDecimal b(String v){return new BigDecimal(v);}}
