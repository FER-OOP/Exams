package hr.fer.oop;

public class StudentResult {
  private final String firstName, lastName;
  private final double points;
  private final int rank;
  private final StudentCourseStatus status;

  public StudentResult(String firstName, String lastName, double points, int rank, StudentCourseStatus status) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.points = points;
    this.rank = rank;
    this.status = status;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public double getPoints() {
    return points;
  }

  public int getRank() {
    return rank;
  }

  public StudentCourseStatus getStatus() {
    return status;
  }

  @Override
  public String toString() {
    return String.format("%s %s - %.2f (%d) - %s", firstName, lastName, points, rank, status);
  }

}
