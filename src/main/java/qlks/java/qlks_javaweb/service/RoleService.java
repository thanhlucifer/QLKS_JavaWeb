package qlks.java.qlks_javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qlks.java.qlks_javaweb.model.Role;
import qlks.java.qlks_javaweb.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    // Phương thức ví dụ để lấy tất cả các vai trò
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Phương thức ví dụ để lấy vai trò bằng ID
    public Optional<Role> getRoleById(Integer roleId) {
        return roleRepository.findById(roleId);
    }

    // Phương thức ví dụ để lưu hoặc cập nhật vai trò
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    // Phương thức ví dụ để xóa vai trò bằng ID
    public void deleteRole(Integer roleId) {
        roleRepository.deleteById(roleId);
    }
}
