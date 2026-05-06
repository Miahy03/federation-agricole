package com.example.federation.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class FederationStatisticsResponse {
    private PeriodDto period;
    private List<CollectivityStatsDto> collectivitiesStats;
    private SummaryDto summary;

    @Getter
    @Setter
    public static class PeriodDto {
        private String startDate;
        private String endDate;
    }

    @Getter
    @Setter
    public static class CollectivityStatsDto {
        private String collectivityId;
        private String collectivityName;
        private double percentageMembersUpToDate;
        private int newMembersCount;
        private int totalActiveMembers;
    }

    @Getter
    @Setter
    public static class SummaryDto {
        private double globalAveragePercentage;
        private int totalNewMembers;
        private int totalActiveMembers;
    }
}