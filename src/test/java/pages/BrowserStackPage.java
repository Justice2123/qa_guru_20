package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class BrowserStackPage {
    SelenideElement searchWiki = $(accessibilityId("Search Wikipedia")),
            inputSearch = $(id("org.wikipedia.alpha:id/search_src_text")),
            wikiError = $(id("org.wikipedia.alpha:id/view_wiki_error_text"));

    ElementsCollection listItem = $$(id("org.wikipedia.alpha:id/page_list_item_title"));


    @Step("клик на поисковое окно")
    public BrowserStackPage searchWikiInput() {
        searchWiki.click();
        return this;
    }

    @Step("ввод запроса в поисковое окно")
    public BrowserStackPage requestInputWiki(String value) {
        inputSearch.sendKeys(value);
        return this;
    }

    @Step("выбор первой статьи")
    public BrowserStackPage openFirstArticle() {
        listItem.first().click();
        return this;
    }

    @Step("проверка текста ошибки")
    public BrowserStackPage checkErrorText(String value) {
        wikiError.shouldHave(text(value));
        return this;
    }

    @Step("проверка списка запроса")
    public BrowserStackPage checkResultList(int value) {
        listItem.shouldHave(sizeGreaterThan(value));
        return this;
    }


}
