package io.vscale.uniservice.controllers.general.admin;

import io.vscale.uniservice.domain.Organization;
import io.vscale.uniservice.services.interfaces.events.OrganizationService;
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
public class OrganizationController {

    private OrganizationService organizationService;

    @GetMapping("/organizations")
    public ModelAndView showOrganizations(@PageableDefault(value = 4) Pageable pageable){

        PageWrapper<Organization> pageWrapper =
                new PageWrapper<>(this.organizationService.findAll(pageable), "/admin/organizations");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/admin-organizations");
        modelAndView.addObject("pageWrapper", pageWrapper);

        return modelAndView;

    }

    @GetMapping("/organizations/asc")
    public ModelAndView showOrganizationsAsc(@PageableDefault(value = 4) Pageable pageable){

        PageWrapper<Organization> pageWrapper =
                    new PageWrapper<>(this.organizationService.retrieveSortedOrganizationsAsc(pageable),
                                                                    "/admin/organizations/asc");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/admin-organizations");
        modelAndView.addObject("pageWrapper", pageWrapper);

        return modelAndView;
    }

    @GetMapping("/organizations/desc")
    public ModelAndView showOrganizationsDesc(@PageableDefault(value = 4) Pageable pageable){

        PageWrapper<Organization> pageWrapper =
                new PageWrapper<>(this.organizationService.retrieveSortedOrganizationsDesc(pageable),
                                                                       "/admin/organizations/desc");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/admin-organizations");
        modelAndView.addObject("pageWrapper", pageWrapper);

        return modelAndView;
    }

    @GetMapping("/organizations/show/id")
    public ModelAndView showOrganization(){

        return new ModelAndView("organizations/view-organization");

    }


    @GetMapping("/organizations/create")
    public ModelAndView createOrganization(){

        return new ModelAndView("organizations/create-organization");

    }

    @GetMapping("/organizations/edit/id")
    public ModelAndView editOrganization(){

        return new ModelAndView("organizations/edit-organization");

    }

}
