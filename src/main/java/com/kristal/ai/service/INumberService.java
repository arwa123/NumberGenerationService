package com.kristal.ai.service;

import com.kristal.ai.domain.dto.Response;
import org.springframework.stereotype.Service;


@Service
public interface INumberService {

    Response generate();
}
