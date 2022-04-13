package hr.fer.oop;

public class Parser {

	public static User parseInputString (String input) throws Exception {

		Double oib=null;
		String name = null;
		String surname =null;
		ServiceType serviceType = null;

		String [] parts = input.split("/");

		if (parts.length != 4)
			throw new InvalidNumberOfArgumentsException("Exception occured!");

		else {

			try {
				oib = Double.parseDouble(parts[0]);
				name = parts[1];
				surname = parts[2];

				if(parts[3].equals("A"))
					serviceType = ServiceType.SUBSCRIBE;
				else if(parts[3].equals("B"))
					serviceType = ServiceType.PREPAID;
				else if(parts[3].equals("C"))
					serviceType = ServiceType.VIRTUAL;
				else
					throw new ArgumentParseException("Exception occured!");
			}
			catch  (Exception e){
				throw new ArgumentParseException("Exception occured!", e);
			}
		}

		return new User(oib, name, surname, serviceType);
	}

}
