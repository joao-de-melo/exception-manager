package uk.fttek.exception.manager.controller;

import uk.fttek.exception.manager.api.LogException;
import uk.fttek.exception.manager.persistency.model.LogExceptionEntity;
import uk.fttek.exception.manager.persistency.repositories.LogExceptionEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/rest/log")
@Controller
public class RestController {
    private final LogExceptionEntityRepository repository;

    @Autowired
    public RestController(LogExceptionEntityRepository repository) {
        this.repository = repository;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public String addAction (@RequestBody LogException exception) {
        LogExceptionEntity saved = repository.save(LogExceptionEntity.fromLogException(exception));
        return saved.getId();
    }
}
