public interface Fraction {
  Fraction add(Fraction other);

  Fraction add(int numerator,int denominator);

  double getDecimalValue(int places);
}
