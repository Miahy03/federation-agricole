package com.example.federation.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CollectivityStatisticsResponse {
    private String collectivityId;
    private String collectivityName;
    private String collectivityNumber;
    private PeriodDto period;
    private List<MemberStatisticsDto> memberStatistics;
    private SummaryDto summary;

    @Getter
    @Setter
    public static class PeriodDto {
        private String startDate;
        private String endDate;
    }

    @Getter
    @Setter
    public static class MemberStatisticsDto {
        private String memberId;
        private String memberName;
        private double amountCollected;
        private double potentialUnpaidAmount;
    }

    @Getter
    @Setter
    public static class SummaryDto {
        private double totalCollected;
        private double totalUnpaid;
        private int activeMembersCount;
    }
}