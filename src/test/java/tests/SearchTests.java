package tests;


import org.junit.jupiter.api.Test;
import pages.BrowserStackPage;


public class SearchTests extends TestBase {
    BrowserStackPage browserStackPage = new BrowserStackPage();


    @Test
    void openArticleTest() {
        browserStackPage
                .searchWikiInput()
                .requestInputWiki("kid cudi")
                .openFirstArticle()
                .checkErrorText("Error");
    }

    @Test
    void successfulSearchTest() {
        browserStackPage
                .searchWikiInput()
                .requestInputWiki("Appium")
                .checkResultList(0);
    }

}
