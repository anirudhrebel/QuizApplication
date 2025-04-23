package com.anirudh.quizapp.service;



import com.anirudh.quizapp.model.Option;
import com.anirudh.quizapp.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    @Autowired
    private OptionRepository optionRepository;

    // Save list of options
    public List<Option> saveOptions(List<Option> options) {
        return optionRepository.saveAll(options);
    }
}
