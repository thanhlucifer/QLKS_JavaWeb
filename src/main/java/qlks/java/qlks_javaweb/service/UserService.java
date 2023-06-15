package qlks.java.qlks_javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qlks.java.qlks_javaweb.model.User;
import qlks.java.qlks_javaweb.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(Integer userId, User updatedUser) {
        // Kiểm tra xem user có tồn tại trong cơ sở dữ liệu không
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Cập nhật thông tin người dùng với dữ liệu đã chỉnh sửa
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setRoles(updatedUser.getRoles());
            // Lưu lại người dùng đã cập nhật vào cơ sở dữ liệu
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
    }

}
