package com.testtask.test_rest.web.controller;

import com.testtask.test_rest.model.Colleague;
import com.testtask.test_rest.service.ColleagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ColleagueService colleagueService;

    /**
     * @param model Get all colleagues
     * @return
     */
    @RequestMapping(value = "colleagues/viewColleagues", method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        List<Colleague> colleagues = colleagueService.readAllColleagues();
        model.put("colleagues", colleagues);
        return "home";
    }

    /**
     * Create new colleague using @RequestBody
     *
     * @param model
     * @param colleague
     * @return
     */
    @RequestMapping(value = "/colleagues/addColleagueReqBody", method = RequestMethod.POST)
    public ResponseEntity<?> addColleague(Model model,
                                          @RequestBody Colleague colleague) {
        Long colleagueId = colleagueService.createColleague(colleague);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Create new colleague using @RequestParam
     *
     * @param model
     * @param firstName
     * @param lastName
     * @param fathersName
     * @param jobPosition
     * @param dateOfBirth
     * @return
     */
    @RequestMapping(value = "/colleagues/addColleagueReqParam", method = RequestMethod.POST)
    public ResponseEntity<?> addColleague(Model model,
                                          @RequestParam(value = "firstname") String firstName,
                                          @RequestParam(value = "secondname") String lastName,
                                          @RequestParam(value = "fatherstname") String fathersName,
                                          @RequestParam(value = "jobposition") String jobPosition,
                                          @RequestParam(value = "dateofbirth") Date dateOfBirth) {
        Colleague colleague = new Colleague();
        colleague.setFirstName(firstName);
        colleague.setLastName(lastName);
        colleague.setFathersName(fathersName);
        colleague.setJobPosition(jobPosition);
        colleague.setDateOfBirth(dateOfBirth);
        Long colleagueId = colleagueService.createColleague(colleague);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
