package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CatCafeTest {

  CatCafe cafe;

  // Initialisierung der Klasse die getestet werden soll vor jedem Test,
  // da diese jedes mal so gebraucht wird und beim Initialisieren auch noch keine verschiedenen
  // Parameter übergibt bekommt.
  @BeforeEach
  public void setup() {
    // given
    cafe = new CatCafe();
  }

  @Test
  public void test_count_of_cats() {
    // given
    FelineOverLord katze = new FelineOverLord("Pelle", 7);

    // when
    cafe.addCat(katze);
    long katzenzahl = cafe.getCatCount();

    // then
    assertEquals(1, katzenzahl);
  }

  @Test
  public void test_count_of_multiple_cats() {
    // given
    FelineOverLord katze = new FelineOverLord("Pelle", 7);
    FelineOverLord chat = new FelineOverLord("Penny", 5);
    FelineOverLord cat = new FelineOverLord("Kassy", 6);

    // when
    cafe.addCat(katze);
    cafe.addCat(chat);
    cafe.addCat(cat);
    long katzenzahl = cafe.getCatCount();

    // then
    assertEquals(3, katzenzahl);
  }

  @Test
  public void test_count_of_no_cats() {
    // given
    // none

    // when
    long katzenzahl = cafe.getCatCount();

    // then
    assertEquals(0, katzenzahl);
  }

  @Test
  public void test_get_cat_by_name() {
    // given
    FelineOverLord katze = new FelineOverLord("Pelle", 7);
    FelineOverLord chat = new FelineOverLord("Penny", 5);
    FelineOverLord cat = new FelineOverLord("Kassy", 6);
    FelineOverLord gato = new FelineOverLord("Kitty", 4);

    // when
    cafe.addCat(katze);
    cafe.addCat(chat);
    cafe.addCat(cat);
    cafe.addCat(gato);
    FelineOverLord antwortKatze = cafe.getCatByName("Kassy");

    // then
    assertEquals(cat, antwortKatze);
  }

  @Test
  public void test_get_cat_by_duplicate_name() {
    // given
    FelineOverLord katze = new FelineOverLord("Pelle", 7);
    FelineOverLord chat = new FelineOverLord("Penny", 5);
    FelineOverLord cat = new FelineOverLord("Kassy", 6);
    FelineOverLord gato = new FelineOverLord("Penny", 4);

    // when
    cafe.addCat(katze);
    cafe.addCat(chat);
    cafe.addCat(cat);
    cafe.addCat(gato);
    FelineOverLord antwortKatze = cafe.getCatByName("Penny");

    // then
    // Expected to give back the First Cat added of the two
    assertEquals(chat, antwortKatze);
  }

  @Test
  public void test_get_cat_by_fake_name() {
    // given
    FelineOverLord katze = new FelineOverLord("Pelle", 7);
    FelineOverLord chat = new FelineOverLord("Penny", 5);
    FelineOverLord cat = new FelineOverLord("Kassy", 6);
    FelineOverLord gato = new FelineOverLord("Kitty", 4);

    // when
    cafe.addCat(katze);
    cafe.addCat(chat);
    cafe.addCat(cat);
    cafe.addCat(gato);
    FelineOverLord antwortKatze = cafe.getCatByName("Leo");

    // then
    assertNull(antwortKatze);
  }

  @Test
  public void test_get_cat_by_weight() {
    // given
    FelineOverLord katze = new FelineOverLord("Pelle", 7);
    FelineOverLord chat = new FelineOverLord("Penny", 5);
    FelineOverLord cat = new FelineOverLord("Kassy", 6);
    FelineOverLord gato = new FelineOverLord("Kitty", 4);

    // when
    cafe.addCat(katze);
    cafe.addCat(chat);
    cafe.addCat(cat);
    cafe.addCat(gato);
    FelineOverLord antwortKatze = cafe.getCatByWeight(2, 5);

    // then
    assertEquals(gato, antwortKatze);
  }

  @Test
  public void test_get_cat_by_duplicated_weight() {
    // given
    FelineOverLord katze = new FelineOverLord("Pelle", 7);
    FelineOverLord chat = new FelineOverLord("Penny", 5);
    FelineOverLord cat = new FelineOverLord("Kassy", 7);
    FelineOverLord gato = new FelineOverLord("Kitty", 4);

    // when
    cafe.addCat(katze);
    cafe.addCat(chat);
    cafe.addCat(cat);
    cafe.addCat(gato);
    FelineOverLord antwortKatze = cafe.getCatByWeight(7, 8);

    // then
    assertEquals(katze, antwortKatze);
  }

  @Test
  public void test_get_cat_by_fake_weight() {
    // given
    FelineOverLord katze = new FelineOverLord("Pelle", 7);
    FelineOverLord chat = new FelineOverLord("Penny", 5);
    FelineOverLord cat = new FelineOverLord("Kassy", 6);
    FelineOverLord gato = new FelineOverLord("Kitty", 4);

    // when
    cafe.addCat(katze);
    cafe.addCat(chat);
    cafe.addCat(cat);
    cafe.addCat(gato);
    FelineOverLord antwortKatze = cafe.getCatByWeight(8, 10);

    // then
    assertNull(antwortKatze);
  }

  @Test
  public void test_get_cat_by_weight_noLogik_weight() {
    // given
    FelineOverLord katze = new FelineOverLord("Pelle", 7);
    FelineOverLord chat = new FelineOverLord("Penny", 5);
    FelineOverLord cat = new FelineOverLord("Kassy", 6);
    FelineOverLord gato = new FelineOverLord("Kitty", 4);

    // when
    cafe.addCat(katze);
    cafe.addCat(chat);
    cafe.addCat(cat);
    cafe.addCat(gato);
    // minWeight größer als maxWeight
    FelineOverLord antwortKatze = cafe.getCatByWeight(12, 5);

    // then
    assertNull(antwortKatze);
  }
}
