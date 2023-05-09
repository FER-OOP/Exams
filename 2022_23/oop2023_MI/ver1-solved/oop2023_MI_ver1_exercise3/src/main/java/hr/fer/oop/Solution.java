package hr.fer.oop;


public class Solution implements CarManager {

	private int noAETHER;
	private int noNIMBLE;
	private int noZENITH;


	private int noCars;

	public Solution() {
	}

	@Override
	public int processDataset(String input) {

		noAETHER = 0;
		noNIMBLE = 0;
		noZENITH = 0;
		noCars = 0;

		String[] lines = input.split("\r\n");

		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			
			if(i == 0 && line.equals("Brand-Model,Year")) {
				continue;
			}

			try {
				CarDescription cd = processLine(line);

				switch (cd.getBrand()) {
				case AETHER:
					noAETHER++;
					break;
				case NIMBLE:
					noNIMBLE++;
					break;
				case ZENITH:
					noZENITH++;
					break;
				default:
					break;
				}
				noCars++;
			} catch (ParseException exc) {
				// omit
			}

		}

		return noCars;
	}

	@Override
	public CarDescription processLine(String line) throws ParseException {
		// Brand-Model,Year
		
		String[] leftPart = line.split("-");
		if (leftPart.length != 2)
			throw new ParseException("Row length not OKI");
		String[] rightPart = leftPart[1].split(",");
		if (rightPart.length != 2)
			throw new ParseException("Minus part not OKI");

		// BRAND
		String brandText = leftPart[0];
		Brand brand = null;
		if (brandText.equalsIgnoreCase("Nimble")) {
			brand = Brand.NIMBLE;
		} else if (brandText.equalsIgnoreCase("Aether")) {
			brand = Brand.AETHER;
		} else if (brandText.equalsIgnoreCase("Zenith")) {
			brand = Brand.ZENITH;
		} else {
			throw new ParseException("Brand not OKI");
		}

		// MODEL
		String model = rightPart[0];

		// YEAR
		try {
			int year = Integer.parseInt(rightPart[1]);
			if (year <= 1885)
				throw new ParseException("boundaries not OKI");
			return new CarDescription(brand, model, year);
		} catch (Exception e) {
			throw new ParseException("Parsing to integer not OKI");
		}

	}

	@Override
	public double averageYear(Brand brand) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int brandCount(Brand brand) {
		switch (brand) {
		case AETHER:
			return noAETHER;
		case NIMBLE:
			return noNIMBLE;
		case ZENITH:
			return noZENITH;
		default:
			break;
		}
		return 0;
	}



}
