package com.kristal.ai.service;

import com.kristal.ai.domain.dto.Response;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

import static com.kristal.ai.constants.Constants.*;

@Service
public class NumberServiceImpl implements INumberService {


    @Override
    public Response generate() {
        ArrayList<Integer> numList = NumberScheduler.numList;
        System.out.println("numList is: " + numList);

        ArrayList<Long> cumulativelist = getCumulation(numList);
        int size = numList.size();
        long totalCumulation = cumulativelist.get(size - 1);

        Response response = new Response();
        response.setTotalCumulation(totalCumulation);
        response.setMins30Cumulation(size >= numsIn30mins ? cumulativelist.get(numsIn30mins-1) : totalCumulation);
        response.setMins10Cumulation(size >= numsIn10mins ? cumulativelist.get(numsIn10mins-1) : totalCumulation);
        response.setMins5Cumulation(size >= numsIn5mins ? cumulativelist.get(numsIn5mins-1) : totalCumulation);

        return response;
}

    private ArrayList<Long> getCumulation(List<Integer> numList) {
        Collections.reverse(numList);
        return numList.stream()
                .collect(
                        Collector.of(
                                ArrayList::new,
                                (a, b) -> a.add(a.isEmpty() ? b : b + a.get(a.size() - 1)),
                                (a, b) -> {
                                    throw new UnsupportedOperationException();
                                }
                        )
                );
    }
}
