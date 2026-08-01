/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.treasury.service;
import jakarta.validation.constraints.*; import org.springframework.stereotype.Service; import java.math.*; import java.util.*;
@Service public class LiquidityCoverageService {
    public CoverageResult evaluate(CoverageRequest request){
        BigDecimal sources=request.availableCash().add(request.committedFacilities()).add(request.receivablesSevenDays()).subtract(request.restrictedCash());
        BigDecimal requirement=request.paymentsDueSevenDays().add(request.minimumBuffer());
        BigDecimal surplus=sources.subtract(requirement).setScale(2,RoundingMode.HALF_UP);
        double coverage=requirement.signum()==0?100:sources.multiply(BigDecimal.valueOf(100)).divide(requirement,1,RoundingMode.HALF_UP).doubleValue();
        String status=surplus.signum()<0?"GAP":coverage<120?"WATCH":"COVERED";
        List<String> actions=new ArrayList<>(); if(surplus.signum()<0)actions.add("启用备用授信或调整非刚性付款节奏"); if(request.restrictedCash().signum()>0)actions.add("核查受限资金释放条件和可用时间"); if(request.receivablesSevenDays().signum()>0)actions.add("跟进七日内应收款回款确定性"); if(actions.isEmpty())actions.add("流动性覆盖充足，维持滚动预测");
        return new CoverageResult(sources,requirement,surplus,coverage,status,actions);
    }
    public record CoverageRequest(@NotNull @DecimalMin("0.00") BigDecimal availableCash,@NotNull @DecimalMin("0.00") BigDecimal committedFacilities,@NotNull @DecimalMin("0.00") BigDecimal paymentsDueSevenDays,@NotNull @DecimalMin("0.00") BigDecimal receivablesSevenDays,@NotNull @DecimalMin("0.00") BigDecimal restrictedCash,@NotNull @DecimalMin("0.00") BigDecimal minimumBuffer){}
    public record CoverageResult(BigDecimal availableSources,BigDecimal requirement,BigDecimal surplus,double coverageRate,String status,List<String> actions){}
}
