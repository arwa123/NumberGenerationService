package com.kristal.ai.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


@Component
public class NumberScheduler {

    private static final Logger logger = LoggerFactory.getLogger(NumberScheduler.class);
    static ArrayList<Integer> numList = new ArrayList<>();

    @Scheduled(fixedRate = 1000)
    public static void create() {
        System.out.println("Next Batch");
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int num = random.nextInt(999);
            numList.add(num);
            System.out.println("Random number: " + num);
        }
    }
}
