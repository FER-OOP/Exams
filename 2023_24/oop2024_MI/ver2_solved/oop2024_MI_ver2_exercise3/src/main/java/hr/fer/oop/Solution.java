package hr.fer.oop;


public class Solution implements DisabilityDatasetManager {
	
	private int visual = 0;
	private int intellectual = 0;
	private int physical = 0;
	private int total = 0;
	

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
				
				
				switch (disability) {
				case INTELLECTUAL:
					intellectual++;
					break;
				case PHYSICAL:
					physical++;
					break;
				case VISUAL:
					visual++;
					break;
					
				default:
					break;
				}
	
			} catch (DisabilityException e) {
				noFails++;
			}
		}
		
		total = intellectual + physical + visual;
		
		return noFails;
	}

	@Override
	public DisabilityRecord processLine(String line) throws DisabilityException {
		
		String personName = null;
		Disability disability = null;
		double rating = 0; 
		
		try {
			// good example: "Person_name ### Disability #% ##",
			String[] baseline = line.split("###");
			
			// EXTRACT PERSON NAME:
			personName = baseline[0].trim();
			
			String[] rightParts = baseline[1].split("#");
			String disabilityText = rightParts[0].trim();
			String ratingText = rightParts[1];
			// should finish with "--"
			if(!ratingText.endsWith("--")) throw new Exception();
			// ok, now remove:
			ratingText = ratingText.replace("--", "");
		
			
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
		throw new UnsupportedOperationException();
	}

	@Override
	public String share(Disability disability) throws UnsupportedOperationException {
		 
		int result = 0;
		switch (disability) {
		case INTELLECTUAL:
			result = intellectual;
			break;
		case PHYSICAL:
			result = physical;
			break;
		case VISUAL:
			result = visual;
			break;
		default:
			break;
		}
		
		return String.format("%.1f%%", 100.0*result/total); 
	}

}
