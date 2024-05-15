package hr.fer.oop;


public class Solution implements DisabilityDatasetManager {
	
	private double maxVisual = 0;
	private double maxIntellectual = 0;
	private double maxPhysical = 0;
	

	@Override
	public int processDataset(String input) {
		String[] lines = input.split("\n");
		
		int noFails = 0;
		
		final int START_INDEX_TO_SKIP_HEADER = 1;
		for (int i = START_INDEX_TO_SKIP_HEADER; i < lines.length; i++) {
			String line = lines[i];
			try {
				DisabilityRecord disabilityRecord = processLine(line);
				
				Disability disability = disabilityRecord.getDisability();
				double rating = disabilityRecord.getRating();
				
				switch (disability) {
				case INTELLECTUAL:
					if(rating>maxIntellectual) maxIntellectual = rating;
					break;
				case PHYSICAL:
					if(rating>maxPhysical) maxPhysical = rating;
					break;
				case VISUAL:
					if(rating>maxVisual) maxVisual = rating;
					break;
					
				default:
					break;
				}
	
			} catch (DisabilityException e) {
				noFails++;
			}
		}
		
		return noFails;
	}

	@Override
	public DisabilityRecord processLine(String line) throws DisabilityException {
		
		String personName = null;
		Disability disability = null;
		double rating = 0;
		
		try {
			// good example: "Pero -> VISUAL #33.45"
			String[] baseline = line.split("->");
			
			// EXTRACT PERSON NAME:
			personName = baseline[0].trim();
			
			String[] rightParts = baseline[1].split("#");
			String disabilityText = rightParts[0].trim();
			String ratingText = rightParts[1];
		
			
			// EXTRACT DISABILITY:
			Disability[] disabilities = {Disability.VISUAL, Disability.INTELLECTUAL, Disability.PHYSICAL};
			boolean disabilityParsed = false;
			for(Disability dis : disabilities) {
				if(disabilityText.equalsIgnoreCase(dis.toString())) {
					disability = dis;
					disabilityParsed = true;
					break;
				}
			}
			if(!disabilityParsed) throw new Exception();
			
			// EXTRACT RATING:
			rating = Double.parseDouble(ratingText)/100;
			if(rating<0 || rating>1) {throw new Exception();}
			
		} catch (Exception e) {
			throw new DisabilityException(line);
		}
		
		return new DisabilityRecord(personName, disability, rating);
	}

	@Override
	public String maxRating(Disability disability) {
		double result = 0;
		switch (disability) {
		case INTELLECTUAL:
			result = maxIntellectual;
			break;
		case PHYSICAL:
			result = maxPhysical;
			break;
		case VISUAL:
			result = maxVisual;
			break;
		default:
			break;
		}
		
		return String.format("%.1f%%", result*100);
	}

	@Override
	public String share(Disability disability) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

}
