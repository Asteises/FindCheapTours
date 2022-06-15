package ru.asteises.findcheaptours.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.asteises.findcheaptours.mapper.OfferMapper;
import ru.asteises.findcheaptours.models.Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO BotFather - telegram - создать бота

@Service
public class LevelTravel {

    @Autowired
    private OfferMapper offerMapper;

    private WebDriver webDriver;
    public void execute() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();

        List<WebElement> webOffers;
        List<Offer> offers = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            StringBuilder date = new StringBuilder("offer_date=2022-09-0" + i);

            String hotelUrl = "https://level.travel/hotels/9017352-Amaya_Beach_Resort_And_Spa_Ex_Centara_Passikudah_Resort_And_Spa?adults=2&from=Moscow-RU&kids=2&kids_ages=8%2C10&nights=16&" + date + "&offer_instant_confirm=false&offer_lt_extras=&offer_operators=&start_date=01.09.2022";
            System.out.println(hotelUrl);
            webDriver.get(hotelUrl);
            webDriver.manage().window().fullscreen();
            Thread.sleep(7000);
            try {
                webDriver.findElement(By.xpath("//div[contains(@class, 'HotelOfferCell__StyledContainer-sc-8qtl5h-9')]"));
                webOffers = webDriver.findElements(By.xpath("//div[contains(@class, 'HotelOfferCell__StyledContainer-sc-8qtl5h-9')]"));
            } catch (NoSuchElementException e) {
                webDriver.findElement(By.xpath("/html/body/section/div/div/div/div[2]/div[8]/div/div/div[2]/div/button")).click();
                Thread.sleep(7000);
                webOffers = webDriver.findElements(By.xpath("//div[contains(@class, 'HotelOfferCell__StyledContainer-sc-8qtl5h-9')]"));
            }
            for (WebElement webElement: webOffers) {
                offers.add(offerMapper.webElementToOffer(webElement));
            }
            System.out.println(offers.toString());
        }
        webDriver.close();
    }
}
