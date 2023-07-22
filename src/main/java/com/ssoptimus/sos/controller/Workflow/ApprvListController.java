package com.ssoptimus.sos.controller.Workflow;

import com.ssoptimus.sos.service.Workflow.ApprvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/workflow/apprvList")
@RestController
public class ApprvListController {
    private final ApprvService apprvService;

    @Autowired
    public ApprvListController(ApprvService apprvService) {
        this.apprvService = apprvService;
    }

    @RequestMapping(value = "/process/{step}")
    private int getProcessDocList(@PathVariable String step){
        apprvService.getApprvCountByIdStatus("so12112",step);
        return apprvService.getApprvCountByIdStatus("so12112",step);
    }

    @RequestMapping(value = "/end/{step}")
    private String getEndDocList(@PathVariable String step){

        if(step.equals("complete")){

        } else if (step.equals("deny")) {

        } else{

        }

        return step;
    }

    @RequestMapping(value = "/refer/{step}")
    private String getReferDocList(@PathVariable String step){

        if(step.equals("")){

        } else if (step.equals("temp")) {

        }else{

        }

        return step;
    }


}
