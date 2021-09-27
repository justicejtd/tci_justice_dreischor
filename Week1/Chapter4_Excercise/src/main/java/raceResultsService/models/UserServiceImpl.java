package raceResultsService.models;

import raceResultsService.interfaces.SecurityService;
import raceResultsService.interfaces.User;
import raceResultsService.interfaces.UserDAO;

public class UserServiceImpl {

    private UserDAO userDAO;
    private SecurityService securityService;

    /**
     * @should makes sure that user gets his new password
     * @should makes sure that user gets updated in userDOA
     * @param user
     * @throws Exception
     */
    public void assignPassword(User user) throws Exception {
        String passwordMd5 = securityService.md5(user.getPassword());
        user.setPassword(passwordMd5);
        userDAO.updateUser(user);
    }

    /**
     *
     * @param dao
     * @param security
     */
    public UserServiceImpl(UserDAO dao, SecurityService security) {
        this.userDAO = dao;
        this.securityService = security;
    }
}
