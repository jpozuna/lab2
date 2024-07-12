/**
 * This class implements the Fraction interface and represents a non-negative fraction.
 * The fraction is stored as a numerator and denominator, both of which are integers.
 */
public class SimpleFraction implements Fraction {
  private final int numerator;
  private final int denominator;
  /**
   * Constructs a new SimpleFraction with the specified numerator and denominator.
   * If both the numerator and denominator are negative, they are converted to positive.
   * If either the numerator or the denominator is negative, an IllegalArgumentException is thrown.
   * If the denominator is zero, an IllegalArgumentException is thrown.
   *
   * @param numerator   the numerator of the fraction
   * @param denominator the denominator of the fraction
   * @throws IllegalArgumentException if the fraction is negative or the denominator is zero
   */
  public SimpleFraction(int numerator, int denominator) {
    if (numerator < 0 && denominator < 0) {
      this.numerator = Math.abs(numerator);
      this.denominator = Math.abs(denominator);
    } else if (numerator < 0 || denominator < 0) {
      throw new IllegalArgumentException("fraction cant be negative");
    } else {
      this.numerator = numerator;
      this.denominator = denominator;
    }
    if (denominator == 0) {
      throw new IllegalArgumentException("fraction undefined");
    }
  }
  /**
   * Returns the numerator of this fraction.
   *
   * @return the numerator of this fraction
   */
  public int getNumerator() {
    return numerator;
  }
  /**
   * Returns the denominator of this fraction.
   *
   * @return the denominator of this fraction
   */
  public int getDenominator() {
    return denominator;
  }
  /**
   * Adds the specified fraction to this fraction and returns the result as a new SimpleFraction.
   * If the denominators are the same, the numerators are added directly.
   * Otherwise, the fractions are converted to a common denominator before adding.
   *
   * @param other the fraction to be added to this fraction
   * @return a new SimpleFraction that represents the sum of this fraction and the specified fraction
   */
  @Override
  public Fraction add (Fraction other) {
    SimpleFraction o = (SimpleFraction) other;
    if (this.denominator == o.denominator) {
      int newNumerator = this.numerator + o.numerator;
      return new SimpleFraction(newNumerator, this.denominator);
    } else {
      int commonDenominator = this.denominator * o.getDenominator();
      int newNumerator = (this.numerator * o.getDenominator()) + (o.getNumerator() * this.denominator);
      return new SimpleFraction(newNumerator, commonDenominator);
    }
  }
  /**
   * Adds the specified fraction, given as a numerator and denominator, to this fraction and returns the result as a new SimpleFraction.
   *
   * @param numerator   the numerator of the fraction to be added
   * @param denominator the denominator of the fraction to be added
   * @return a new SimpleFraction that represents the sum of this fraction and the specified fraction
   */
  @Override
  public Fraction add(int numerator,int denominator) {
    SimpleFraction other = new SimpleFraction(numerator, denominator);
    return this.add(other);
  }
  /**
   * Returns the decimal value of this fraction.
   *
   * @param places the number of decimal places to round to
   * @return the decimal value of this fraction rounded to the specified number of decimal places
   */
  @Override
  public double getDecimalValue(int places) {
    return (double) numerator / denominator;
  }
  /**
   * Returns a string representation of this fraction in the form "numerator/denominator".
   *
   * @return a string representation of this fraction
   */
  @Override
  public String toString() {
    return numerator + "/" + denominator;
  }
}
