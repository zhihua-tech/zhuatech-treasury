/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.treasury.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PaymentInstructionGovernanceServiceTest {
    private final PaymentInstructionGovernanceService service = new PaymentInstructionGovernanceService();

    @Test void sendsFullyAuthorizedInstruction() {
        var result = service.assess(new PaymentInstructionGovernanceService.Request(
                "TRX-001", 5_000_000, true, true, true, true, true, true, true, true, true));
        assertThat(result.decision()).isEqualTo(PaymentInstructionGovernanceService.Decision.SEND);
        assertThat(result.blockers()).isEmpty();
    }

    @Test void holdsUnsafeInstruction() {
        var result = service.assess(new PaymentInstructionGovernanceService.Request(
                "TRX-002", 8_000_000, true, false, false, false, false, false, false, false, false));
        assertThat(result.decision()).isEqualTo(PaymentInstructionGovernanceService.Decision.HOLD);
        assertThat(result.blockers()).hasSize(5);
        assertThat(result.actions()).hasSize(3);
    }
}
