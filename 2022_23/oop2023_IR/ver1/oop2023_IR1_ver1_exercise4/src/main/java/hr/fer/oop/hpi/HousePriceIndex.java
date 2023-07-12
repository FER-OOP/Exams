package hr.fer.oop.hpi;

public class HousePriceIndex {
    private String region;
    private RegionType regionType;
    private String time;
    private double value;

    public HousePriceIndex(String region, RegionType regionType, String time, double value) {
        this.region = region;
        this.regionType = regionType;
        this.time = time;
        this.value = value;
    }

    public String getRegion() {
        return region;
    }

    public RegionType getRegionType() {
        return regionType;
    }

    public String getTime() {
        return time;
    }

    public double getValue() {
        return value;
    }
        
    @Override
    public String toString() {
        return "HousePriceIndex{" + "region=" + region + ", regionType=" + regionType + ", time=" + time + ", percentage=" + value + '}';
    }                   
}
