package ru.asteises.findcheaptours.mapper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;
import ru.asteises.findcheaptours.models.Offer;

import java.util.UUID;

@Service
public class OfferMapper {

    public Offer webElementToOffer(WebElement webElement) {
        Offer offer = new Offer();
        offer.setUuid(UUID.randomUUID());
        try {
            offer.setFullPrice(Integer.parseInt(webElement.findElement(By.xpath(".//span[@class='HotelOfferPrice__StyledPrice-sc-1v3l0l6-3 hlbfbO']")).getText().replaceAll("\\D", "")));
            offer.setNightPrice(Integer.parseInt(webElement.findElement(By.xpath(".//div[@class='HotelOfferInfo__StyledText-sc-oi8hjh-1 ifZVip']/span")).getText().replaceAll("\\D", "")));
            offer.setMeals(webElement.findElement(By.xpath(".//div[@class='HotelOfferCell__StyledMealInfo-sc-8qtl5h-0 fvxKGa']")).getText());
            offer.setNights(offer.getFullPrice() / offer.getNightPrice());
            return offer;
        }
        catch (NoSuchElementException e) {
            return null;
        }
    }
}
