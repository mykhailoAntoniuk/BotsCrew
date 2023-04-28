package test.botscrew.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.botscrew.model.Lector;
import test.botscrew.repo.LectorRepository;
import test.botscrew.service.LectorService;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    @Override
    public String globalSearch(String template) {
        List<Lector> lectors = lectorRepository.findAllByTemplate(template);
        return lectors.stream()
                .map(l -> MessageFormat.format("{0} {1}", l.getFirstname(), l.getLastname()))
                .collect(Collectors.joining(","));
    }
}
