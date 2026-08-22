/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.treasury.domain;
import org.springframework.stereotype.Component;
import java.util.List;
@Component public class DomainCatalog {
    public String systemName(){return "知华 Treasury 企业司库管理平台";}
    public String sceneName(){return "账户、资金头寸、收付款、融资、流动性与风险监测";}
    public List<SeedItem> seedItems(){return List.of(
        new SeedItem("TR-20260801-001","未来七日资金缺口滚动预测","处理中","流动性管理组","高"),
        new SeedItem("TR-20260801-002","境内账户余额归集确认","待处理","资金结算组","中"),
        new SeedItem("TR-20260801-003","授信额度与到期结构复核","已完成","融资管理组","高"),
        new SeedItem("TR-20260801-004","大额付款资金计划校验","处理中","司库运营组","紧急"));}
    public List<String> recommendedActions(){return List.of("优先覆盖短期刚性付款和最低现金缓冲","核查受限资金与可用授信状态","滚动更新应收回款和融资到期预测");}
    public record SeedItem(String recordNo,String title,String status,String owner,String priority){}
}
