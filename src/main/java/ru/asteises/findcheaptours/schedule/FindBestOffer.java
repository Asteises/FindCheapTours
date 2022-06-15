package ru.asteises.findcheaptours.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.asteises.findcheaptours.service.LevelTravel;

@Component
public class FindBestOffer {

    @Autowired
    private LevelTravel levelTravel;

    @Scheduled(fixedRateString = "${bot.fixedRate}")
    public void find() throws InterruptedException {
        levelTravel.execute();
    }
}
