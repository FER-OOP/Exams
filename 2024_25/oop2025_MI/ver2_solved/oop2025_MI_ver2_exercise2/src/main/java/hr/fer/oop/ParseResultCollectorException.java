package hr.fer.oop;

public class ParseResultCollectorException extends ParseResultException {
  private MyList<ParseResultException> reasons = new MyList<>();

  public ParseResultCollectorException() {
  }

  public ParseResultCollectorException(String message) {
    super(message);
  }

  public void addReason(ParseResultException parseResultException) {
    reasons.addLast(parseResultException);
  }

  public MyList<ParseResultException> getReasons() {
    return reasons;
  }

  public void collect(MyList<? super ParseResultException> collected) {
    for (int i = 0; i < reasons.size(); i++) {
      ParseResultException e = reasons.elementAt(i);
      if(e instanceof ParseResultCollectorException pe) {
        pe.collect(collected);
      } else {
        collected.addLast(e);
      }
    }
  }
}
