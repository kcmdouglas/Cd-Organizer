import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;


public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
    public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("CD Organizer");
    }

  @Test
    public void albumIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText ("Add A New Album"));
    fill("#artist").with("David Bowie");
    fill("#album").with("Hunky Dory");
    submit(".btn");
    assertThat(pageSource()).contains("Your CD has been saved.");
  }

  @Test
  public void albumIsDisplayedTest() {
  goTo("http://localhost:4567/albums/new");
  fill("#artist").with("David Bowie");
  fill("#album").with("Hunky Dory");
  submit(".btn");
  assertThat(pageSource()).contains("Your CD has been saved.");
  click("a", withText("View All Albums"));
  assertThat(pageSource()).contains("David Bowie");
}

}
