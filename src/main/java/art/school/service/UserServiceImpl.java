package art.school.service;

import art.school.AuthorizedUser;
import art.school.entity.Block;
import art.school.entity.Users;
import art.school.helper.BlockHelper;
import art.school.helper.UserHelper;
import art.school.repository.BlockRepository;
import art.school.repository.UserRepository;
import art.school.to.BlockTo;
import art.school.to.UserTo;
import art.school.util.FileUtil;
import art.school.web.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

import static art.school.util.ValidationUtil.checkNotFoundWithId;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private UserHelper userHelper;

    @Autowired
    private BlockHelper blockHelper;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public void createBlockForUserWithTo(BlockTo to, int id) {
        blockRepository.save(blockHelper.createBlock(get(id), get(SecurityUtil.getAuthId()), to));
    }

    @Override
    public BlockTo checkIfBlocked() {
        Block block = blockRepository.getLatestByUserIdAndByNotAccepted(SecurityUtil.getAuthId());
        if (block == null) {
            return null;
        }
        return blockHelper.createTo(block);
    }

    @Override
    public void accepted() {
        Block b = blockRepository.getLatestByUserIdAndByNotAccepted(SecurityUtil.getAuthId());
        if (b != null) b.setAccepted(true);
        blockRepository.save(b);
    }

    @Override
    public void unblockUser(int id) {
        Block b = blockRepository.getLatestByUserId(id);
        if (b != null) {
            b.setDatum(LocalDateTime.now());
        }
        blockRepository.save(b);
    }

    @Override
    public String getImage(int authId) {
        byte[] arr = get(authId).getImage();
        if (arr == null) return null;
        return FileUtil.convertByteArrayToString(arr);
    }

    @Override
    @Transactional
    public List<UserTo> getOnlyActiveKids() {
        return userHelper.transformTos(repository.getOnlyActiveKids());
    }

    @Override
    public Users getUsersByThemaId(int themaId) {
        return repository.getUsersByThemaId(themaId);
    }

    @Override
    @Transactional
    public void toggleAktiv(int id) {
        Users users = get(id);
        users.setAktiv(!users.getAktiv());
    }

    @Override
    public Users getUsersByEmail(String email) {
        return repository.getUsersByEmail(email);
    }

    @Override
    public Users create(Users users) {
        Assert.notNull(users, "users must not be null");
        users.setPasswort(encoder.encode(users.getAdminPasswort()));
        return repository.save(users);
    }

    public Users createWithTo(UserTo to) {
        Users u = to.isNew() ? userHelper.createUser(to) : userHelper.updateUser(get(to.getId()), to);
        return create(u);
    }

    @Override
    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    @Transactional
    public Users get(int id) {
        return repository.get(id);
    }

    @Override
    public void update(Users users) {

    }

    public void updateProfile(UserTo userTo) {
        create(userHelper.updateProfile(get(SecurityUtil.getAuthId()), userTo));
    }

    @Transactional
    public UserTo getUserTo(int id) {
        return userHelper.createTo(get(id));
    }

    @Override
    public boolean isUserBanned(int id) {
        return blockRepository.getLatestByUserId(id) != null;
    }

    @Transactional
    public List<Users> getAll() {
        return repository.getAll();
    }

    @Override
    @Transactional
    public List<UserTo> getAllTos() {
        return userHelper.transformTos(getAll());
    }

    @Override
    @Transactional
    public List<UserTo> getAllKids() {
        return userHelper.transformTos(repository.getAllKids());
    }

    @Override
    @Transactional
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = repository.getUsersByEmail(email);
        if (users == null) {
            throw new UsernameNotFoundException("Users " + email + " is not found");
        }
        return new AuthorizedUser(users);
    }
}
