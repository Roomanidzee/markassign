package io.vscale.uniservice.controllers.general.admin;

import io.vscale.uniservice.domain.Cooperator;
import io.vscale.uniservice.services.interfaces.admin.CooperatorAdminService;
import io.vscale.uniservice.services.interfaces.cooperator.CooperatorService;
import io.vscale.uniservice.utils.PageWrapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 26.03.2018
 *
 * @author Andrey Romanov
 * @version 1.0
 */
@Controller
@RequestMapping("/admin")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CooperatorController {

    private CooperatorService cooperatorService;
    private CooperatorAdminService cooperatorAdminService;

    @GetMapping("/cooperators")
    public ModelAndView showCooperators(@PageableDefault(value = 4) Pageable pageable){

        PageWrapper<Cooperator> pageWrapper =
                new PageWrapper<>(this.cooperatorService.findAll(pageable), "/admin/cooperators");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/admin-employees");
        modelAndView.addObject("pageWrapper", pageWrapper);

        return modelAndView;

    }

}
