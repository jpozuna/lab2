import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SimpleFractionTest {

  @Test
  public void testFraction() {
    SimpleFraction fraction = new SimpleFraction(2,4);
    assertEquals("2/4", fraction.toString());
  }

  @Test
  public void testNegativeFraction() {
    assertThrows(IllegalArgumentException.class, () -> {
      new SimpleFraction(-2, 4);
    });
  }

  @Test
  public void testUndefinedDenominator() {
    assertThrows(IllegalArgumentException.class, () -> {
      new SimpleFraction(2, 0);
    });
  }

  @Test
  public void testTwoNegativeValues() {
    SimpleFraction fraction = new SimpleFraction(-2,-4);
    assertEquals("2/4", fraction.toString());
  }

  @Test
  public void testAddSameDenominator() {
    SimpleFraction fraction1 = new SimpleFraction(1, 3);
    SimpleFraction fraction2 = new SimpleFraction(2, 3);
    Fraction result = fraction1.add(fraction2);
    assertEquals("3/3",result.toString());
  }

  @Test
  public void testAddDifferentDenominator() {
    SimpleFraction fraction1 = new SimpleFraction(2, 6);
    SimpleFraction fraction2 = new SimpleFraction(1, 2);
    Fraction result = fraction1.add(fraction2);
    assertEquals("10/12",result.toString());
  }

  @Test
  public void getDecimalValue() {
    SimpleFraction fraction1 = new SimpleFraction(1, 2);
    assertEquals(0.5, fraction1.getDecimalValue(1), 0.01);

    SimpleFraction fraction2 = new SimpleFraction(1, 3);
    assertEquals(0.333, fraction2.getDecimalValue(3), 0.001);

    SimpleFraction fraction3 = new SimpleFraction(2, 5);
    assertEquals(0.4, fraction3.getDecimalValue(1), 0.01);

    SimpleFraction fraction4 = new SimpleFraction(7, 8);
    assertEquals(0.875, fraction4.getDecimalValue(3), 0.001);
  }
}