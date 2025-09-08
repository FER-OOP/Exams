package hr.fer.oop;

public class Magazine extends Content<String> {

    private DVD supplementDVD;

    public Magazine(String id, String title, String data) {
        super(id, title, data);
        this.supplementDVD = null;
    }
    
    public Magazine(String id, String title, String data, DVD supplement) {
        super(id, title, data);
        this.supplementDVD = supplement;
    }

    public DVD getSupplementDVD() {
        return supplementDVD;
    }

    public void setSupplementDVD(DVD supplementDVD) {
        this.supplementDVD = supplementDVD;
    }

    @Override
    public String describeContent() {  	
    	if (getData() == null || getData().isEmpty()) {
			return "";
		}		
		if (getData().length() <= 30) {
			return "Content: " + getData();
		}
		else {
			return "Content: " + getData().substring(0, 30) + "...";
		}    	
    }

    @Override
    public String getDescription() {
        String baseDescription = super.getDescription();
        if (supplementDVD != null) {
            return baseDescription + "\n + Includes: " + supplementDVD.getDescription();
        }
        return baseDescription;
    }
}