package hr.fer.oop.hpi;

import java.util.Objects;

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
    public int hashCode() {
        return Objects.hash(this.region, this.time);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HousePriceIndex other = (HousePriceIndex) obj;
        if (!Objects.equals(this.region, other.region)) {
            return false;
        }
        return Objects.equals(this.time, other.time);
    }
        
    @Override
    public String toString() {
        return "HousePriceIndex{" + "region=" + region + ", regionType=" + regionType + ", time=" + time + ", percentage=" + value + '}';
    }                   
}
