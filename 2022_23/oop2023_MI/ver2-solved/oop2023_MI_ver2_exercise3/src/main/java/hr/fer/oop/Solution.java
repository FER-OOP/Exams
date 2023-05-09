package hr.fer.oop;


public class Solution implements CarManager {

	private int noAETHER;
	private int noNIMBLE;
	private int noZENITH;
	
	private double yearAETHER;
	private double yearNIMBLE;
	private double yearZENITH;


	private int noCars;

	public Solution() {
	}

	@Override
	public int processDataset(String input) {

		noAETHER = 0;
		noNIMBLE = 0;
		noZENITH = 0;
		noCars = 0;
		yearAETHER=0;
		yearNIMBLE=0;
		yearZENITH=0;

		String[] lines = input.split("\r\n");

		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			
			if(i == 0 && line.equals(",Brand-Model,Year")) {
				continue;
			}

			try {
				CarDescription cd = processLine(line);

				switch (cd.getBrand()) {
				case AETHER:
					yearAETHER+=cd.getYear();
					noAETHER++;
					break;
				case NIMBLE:
					yearNIMBLE+=cd.getYear();
					noNIMBLE++;
					break;
				case ZENITH:
					yearZENITH+=cd.getYear();
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
		// ,Brand-Model,Year\r\n
		
		String[] parts = line.split(",");
		if(parts.length != 3) throw new ParseException("Plus part not OKI");
		
		String[] brandModel = parts[1].split("-");
		if(brandModel.length != 2) throw new ParseException("Plus part not OKI");
		String brandText = brandModel[0];
		String model = brandModel[1];
		

		// BRAND
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


		// YEAR
		try {
			int year = Integer.parseInt(parts[2]);
			if (year <= 1885)
				throw new ParseException("boundaries not OKI");
			return new CarDescription(brand, model, year);
		} catch (Exception e) {
			throw new ParseException("Parsing to integer not OKI");
		}

	}

	@Override
	public double averageYear(Brand brand) {
		switch (brand) {
		case AETHER:
			return noAETHER==0 ? 0 : yearAETHER/noAETHER;
		case NIMBLE:
			return noNIMBLE==0 ? 0 : yearNIMBLE/noNIMBLE;
		case ZENITH:
			return noZENITH==0 ? 0 : yearZENITH/noZENITH;
		default:
			break;
		}
		return 0;
		
	}

	@Override
	public int brandCount(Brand brand) {
		throw new UnsupportedOperationException();
	}



}
