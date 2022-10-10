package com.project.AdminManagementSevice.service;


import com.project.AdminManagementSevice.model.Admin;
import com.project.AdminManagementSevice.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.project.AdminManagementSevice.model.Admin.SEQUENCE_NAME;

@Service
public class AdminServiceImpl implements AdminService,UserDetailsService {
    @Autowired
    public AdminRepository adminrepository;

    @Autowired
    public SequenceGeneratorService sequenceGeneratorService;

    @Override
    public Admin add(Admin admin)
    {
        admin.setAdminId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
        return adminrepository.save(admin);
    }

    @Override
    public Optional<Admin> view(int adminId) {
        return adminrepository.findById(adminId);
    }
    @Override
    public void deleteAdmin(int adminId)
    {
        adminrepository.deleteById(adminId);
    }

    @Override
    public Admin updateAdmin(int adminId, Admin admin) {
        Optional<Admin> findById = adminrepository.findById(adminId);
        if (findById.isPresent()) {
            Admin adminEntity = findById.get();
            if (admin.getUserName() != null && !admin.getUserName().isEmpty())
                adminEntity.setUserName(admin.getUserName());
            if (admin.getPassword() != null && !admin.getPassword().isEmpty())
                adminEntity.setPassword(admin.getPassword());
            if (admin.getEmail() != null && !admin.getEmail().isEmpty())
                adminEntity.setEmail(admin.getEmail());
            if (admin.getPhone() != null && !admin.getPhone().isEmpty())
                adminEntity.setPhone(admin.getPhone());
            if (admin.getAddress() != null && !admin.getAddress().isEmpty())
                adminEntity.setAddress(admin.getAddress());
            return adminrepository.save(adminEntity);
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        Admin findAdmin = adminrepository.findByUserName(username);
        if(findAdmin==null) {
            return null;
        }
        else {
            String name=findAdmin.getUserName();
            String pwd = findAdmin.getPassword();
            return new User(name,pwd,new ArrayList<>());
        }
    }





}
