package io.vscale.uniservice.services.implementations.admin;

import io.vscale.uniservice.domain.Cooperator;
import io.vscale.uniservice.domain.Profile;
import io.vscale.uniservice.forms.rest.CooperatorForm;
import io.vscale.uniservice.repositories.data.CooperatorRepository;
import io.vscale.uniservice.repositories.data.ProfileRepository;
import io.vscale.uniservice.services.interfaces.admin.CooperatorAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 17.03.2018
 *
 * @author Andrey Romanov
 * @version 1.0
 */
@Service
public class CooperatorAdminServiceImpl implements CooperatorAdminService{

    private final ProfileRepository profileRepository;
    private final CooperatorRepository cooperatorRepository;

    @Autowired
    public CooperatorAdminServiceImpl(ProfileRepository profileRepository, CooperatorRepository cooperatorRepository) {
        this.profileRepository = profileRepository;
        this.cooperatorRepository = cooperatorRepository;
    }

    @Override
    public void makeCooperator(CooperatorForm cooperatorForm) {

        Profile profile = this.profileRepository.findOne(cooperatorForm.getProfileId());

        Cooperator cooperator = Cooperator.builder()
                                          .profile(profile)
                                          .recordOfService(cooperatorForm.getRecordOfService())
                                          .appointment(cooperatorForm.getAppointment())
                                          .build();

        this.cooperatorRepository.save(cooperator);

    }
}
