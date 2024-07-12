/**
 * This interface represents a fraction and provides methods for basic operations
 */
public interface Fraction {
  /**
   * Adds the specified fraction to this fraction.
   *
   * @param other the fraction to be added to this fraction
   * @return a new Fraction that represents the sum of this fraction and the specified fraction
   */
  Fraction add(Fraction other);
  /**
   * Adds the specified fraction, given as a numerator and denominator, to this fraction.
   *
   * @param numerator   the numerator of the fraction to be added
   * @param denominator the denominator of the fraction to be added
   * @return a new Fraction that represents the sum of this fraction and the specified fraction
   */
  Fraction add(int numerator,int denominator);
  /**
   * Returns the decimal value of this fraction rounded to the specified number of decimal places.
   *
   * @param places the number of decimal places to round to
   * @return the decimal value of this fraction rounded to the specified number of decimal places
   */
  double getDecimalValue(int places);
}
