package se.iths.f12022statistics.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.f12022statistics.entity.Role;
import se.iths.f12022statistics.entity.User;
import se.iths.f12022statistics.repository.RoleRepository;
import se.iths.f12022statistics.repository.UserRepository;
import se.iths.f12022statistics.responsehandling.EntityAlreadyExistsException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User foundUser = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("No user " + usernameOrEmail + " found."));

        return new org.springframework.security.core.userdetails.User(foundUser.getEmail(), foundUser.getPassword(), mapRoleToAuthorities(foundUser.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRoleToAuthorities(Set<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public User createNewUser(User user, PasswordEncoder passwordEncoder) {
        Iterable<User> usersList = userRepository.findAll();

        for (User dbUser : usersList) {
            if (dbUser.getUsername().equals(user.getUsername())) {
                throw new EntityAlreadyExistsException("User with that username already exists in database");
            }
            if (dbUser.getEmail().equals(user.getEmail())) {
                throw new EntityAlreadyExistsException("User with that email already exists in database");
            }
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Optional<Role> role = roleRepository.findByName("ROLE_USER");
        Set<Role> userRoleSet = new HashSet<>();
        userRoleSet.add(role.get());
        user.setRoles(userRoleSet);
        userRepository.save(user);

        return user;
    }
}

