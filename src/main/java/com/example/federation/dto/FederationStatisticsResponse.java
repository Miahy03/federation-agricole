package com.example.federation.dto;

import java.util.List;

public class FederationStatisticsResponse {
    private PeriodDto period;
    private List<CollectivityStatsDto> collectivitiesStats;
    private SummaryDto summary;

    public FederationStatisticsResponse() {}

    // Getters
    public PeriodDto getPeriod() { return period; }
    public List<CollectivityStatsDto> getCollectivitiesStats() { return collectivitiesStats; }
    public SummaryDto getSummary() { return summary; }

    // Setters
    public void setPeriod(PeriodDto period) { this.period = period; }
    public void setCollectivitiesStats(List<CollectivityStatsDto> collectivitiesStats) { this.collectivitiesStats = collectivitiesStats; }
    public void setSummary(SummaryDto summary) { this.summary = summary; }

    public static class PeriodDto {
        private String startDate;
        private String endDate;

        public PeriodDto() {}
        public String getStartDate() { return startDate; }
        public void setStartDate(String startDate) { this.startDate = startDate; }
        public String getEndDate() { return endDate; }
        public void setEndDate(String endDate) { this.endDate = endDate; }
    }


    public static class CollectivityStatsDto {
        private String collectivityId;
        private String collectivityName;
        private double percentageMembersUpToDate;
        private int newMembersCount;
        private int totalActiveMembers;

        public CollectivityStatsDto() {}
        public String getCollectivityId() { return collectivityId; }
        public void setCollectivityId(String collectivityId) { this.collectivityId = collectivityId; }
        public String getCollectivityName() { return collectivityName; }
        public void setCollectivityName(String collectivityName) { this.collectivityName = collectivityName; }
        public double getPercentageMembersUpToDate() { return percentageMembersUpToDate; }
        public void setPercentageMembersUpToDate(double percentageMembersUpToDate) { this.percentageMembersUpToDate = percentageMembersUpToDate; }
        public int getNewMembersCount() { return newMembersCount; }
        public void setNewMembersCount(int newMembersCount) { this.newMembersCount = newMembersCount; }
        public int getTotalActiveMembers() { return totalActiveMembers; }
        public void setTotalActiveMembers(int totalActiveMembers) { this.totalActiveMembers = totalActiveMembers; }
    }

    public static class SummaryDto {
        private double globalAveragePercentage;
        private int totalNewMembers;
        private int totalActiveMembers;

        public SummaryDto() {}
        public double getGlobalAveragePercentage() { return globalAveragePercentage; }
        public void setGlobalAveragePercentage(double globalAveragePercentage) { this.globalAveragePercentage = globalAveragePercentage; }
        public int getTotalNewMembers() { return totalNewMembers; }
        public void setTotalNewMembers(int totalNewMembers) { this.totalNewMembers = totalNewMembers; }
        public int getTotalActiveMembers() { return totalActiveMembers; }
        public void setTotalActiveMembers(int totalActiveMembers) { this.totalActiveMembers = totalActiveMembers; }
    }
}