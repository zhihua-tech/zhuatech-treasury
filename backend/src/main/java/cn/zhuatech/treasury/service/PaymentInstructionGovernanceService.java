/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.treasury.service;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentInstructionGovernanceService {
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        if (!request.beneficiaryWhitelisted()) blockers.add("收款方不在已核验白名单");
        if (!request.bankAccountVerified()) blockers.add("收款账户未通过独立回拨或可信渠道验证");
        if (!request.sanctionsCleared()) blockers.add("制裁与反洗钱筛查未通过");
        if (!request.liquidityAvailable()) blockers.add("付款后流动性缓冲不足");
        if (!request.makerCheckerSeparated()) blockers.add("制单与复核未实现职责分离");
        if (!request.approvalMatrixSatisfied()) actions.add("补齐金额分级授权");
        if (!request.instructionDigitallySigned()) actions.add("对银行指令进行数字签名");
        if (request.highValue() && !request.outOfBandConfirmed()) actions.add("完成高额付款带外确认");

        Decision decision = !blockers.isEmpty() ? Decision.HOLD
                : !actions.isEmpty() ? Decision.APPROVAL_REQUIRED : Decision.SEND;
        return new Assessment(request.instructionNo(), decision,
                List.copyOf(blockers), List.copyOf(actions));
    }

    public record Request(@NotBlank String instructionNo, @Min(1) long amountCents,
                          boolean highValue, boolean beneficiaryWhitelisted,
                          boolean bankAccountVerified, boolean sanctionsCleared,
                          boolean liquidityAvailable, boolean makerCheckerSeparated,
                          boolean approvalMatrixSatisfied, boolean instructionDigitallySigned,
                          boolean outOfBandConfirmed) {}
    public record Assessment(String instructionNo, Decision decision, List<String> blockers,
                             List<String> actions) {}
    public enum Decision { SEND, APPROVAL_REQUIRED, HOLD }
}
