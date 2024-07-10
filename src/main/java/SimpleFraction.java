public class SimpleFraction implements Fraction {
  private final int numerator;
  private final int denominator;

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
  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }
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
  @Override
  public Fraction add(int numerator,int denominator) {
    SimpleFraction other = new SimpleFraction(numerator, denominator);
    return this.add(other);
  }
  @Override
  public double getDecimalValue(int places) {
    return (double) numerator / denominator;
  }
  @Override
  public String toString() {
    return numerator + "/" + denominator;
  }
}
