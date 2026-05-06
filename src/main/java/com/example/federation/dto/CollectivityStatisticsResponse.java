package com.example.federation.dto;

import java.util.List;

public class CollectivityStatisticsResponse {
    private String collectivityId;
    private String collectivityName;
    private String collectivityNumber;
    private PeriodDto period;
    private List<MemberStatisticsDto> memberStatistics;
    private SummaryDto summary;

    // Constructeurs
    public CollectivityStatisticsResponse() {}

    // Getters
    public String getCollectivityId() { return collectivityId; }
    public String getCollectivityName() { return collectivityName; }
    public String getCollectivityNumber() { return collectivityNumber; }
    public PeriodDto getPeriod() { return period; }
    public List<MemberStatisticsDto> getMemberStatistics() { return memberStatistics; }
    public SummaryDto getSummary() { return summary; }

    // Setters
    public void setCollectivityId(String collectivityId) { this.collectivityId = collectivityId; }
    public void setCollectivityName(String collectivityName) { this.collectivityName = collectivityName; }
    public void setCollectivityNumber(String collectivityNumber) { this.collectivityNumber = collectivityNumber; }
    public void setPeriod(PeriodDto period) { this.period = period; }
    public void setMemberStatistics(List<MemberStatisticsDto> memberStatistics) { this.memberStatistics = memberStatistics; }
    public void setSummary(SummaryDto summary) { this.summary = summary; }

    // PeriodDto
    public static class PeriodDto {
        private String startDate;
        private String endDate;

        public PeriodDto() {}
        public String getStartDate() { return startDate; }
        public void setStartDate(String startDate) { this.startDate = startDate; }
        public String getEndDate() { return endDate; }
        public void setEndDate(String endDate) { this.endDate = endDate; }
    }

    // MemberStatisticsDto
    public static class MemberStatisticsDto {
        private String memberId;
        private String memberName;
        private double amountCollected;
        private double potentialUnpaidAmount;

        public MemberStatisticsDto() {}
        public String getMemberId() { return memberId; }
        public void setMemberId(String memberId) { this.memberId = memberId; }
        public String getMemberName() { return memberName; }
        public void setMemberName(String memberName) { this.memberName = memberName; }
        public double getAmountCollected() { return amountCollected; }
        public void setAmountCollected(double amountCollected) { this.amountCollected = amountCollected; }
        public double getPotentialUnpaidAmount() { return potentialUnpaidAmount; }
        public void setPotentialUnpaidAmount(double potentialUnpaidAmount) { this.potentialUnpaidAmount = potentialUnpaidAmount; }
    }

    // SummaryDto
    public static class SummaryDto {
        private double totalCollected;
        private double totalUnpaid;
        private int activeMembersCount;

        public SummaryDto() {}
        public double getTotalCollected() { return totalCollected; }
        public void setTotalCollected(double totalCollected) { this.totalCollected = totalCollected; }
        public double getTotalUnpaid() { return totalUnpaid; }
        public void setTotalUnpaid(double totalUnpaid) { this.totalUnpaid = totalUnpaid; }
        public int getActiveMembersCount() { return activeMembersCount; }
        public void setActiveMembersCount(int activeMembersCount) { this.activeMembersCount = activeMembersCount; }
    }
}