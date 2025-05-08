package hr.fer.oop;

public class StudentsResultsParser {

  public static void parse(String[] lines, MyList<? super StudentResult> results) {
    MyList<ParseResultException> exceptions = new MyList<>();

    for (int row = 0; row < lines.length; row++) {
      String line = lines[row];

      String[] parts = line.split(";");
      if (parts.length < 5) {
        exceptions.addLast(new ParseResultRowException(row+1, "Invalid number of columns"));
        continue;
      }
      String firstName = parts[0].trim();
      String lastName = parts[1].trim();

      boolean wasException = false;
      double points = 0;
      try {
        points = Double.parseDouble(parts[2].trim());
      } catch (NumberFormatException e) {
        wasException = true;
        exceptions.addLast(new ParseResultCellException(row+1, 3, "Invalid points format"));
      }

      int rank = 0;
      try {
        rank = Integer.parseInt(parts[3].trim());
      } catch (NumberFormatException e) {
        wasException = true;
        exceptions.addLast(new ParseResultCellException(row+1, 4, "Invalid rank format"));
      }

      StudentCourseStatus status = null;
      try {
        status = StudentCourseStatus.valueOf(parts[4].trim().toUpperCase());
      } catch (Exception e) {
        wasException = true;
        exceptions.addLast(new ParseResultCellException(row+1, 5, "Invalid status format"));
      }

      if (!wasException) {
        results.addLast(new StudentResult(firstName, lastName, points, rank, status));
      }
    }

    if(exceptions.size() > 0) {
      ParseResultCollectorException parseResultsExceptions = new ParseResultCollectorException();
      for(int i = 0; i < exceptions.size(); i++) {
        parseResultsExceptions.addReason(exceptions.elementAt(i));
      }
      throw parseResultsExceptions;
    }
  }
}
