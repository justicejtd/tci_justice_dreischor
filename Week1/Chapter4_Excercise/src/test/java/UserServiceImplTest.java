import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {
    private final String password = "password";
    private final UserDAO userDAO = mock(UserDAO.class);
    private final SecurityService securityService = mock(SecurityService.class);
    private final User user = mock(User.class);
    private final UserServiceImpl userService = new UserServiceImpl(userDAO, securityService);

    /**
     * @verifies makes sure that user gets his new password
     * @see UserServiceImpl#assignPassword(User)
     */
    @Test
    public void assignPassword_shouldMakesSureThatUserGetsHisNewPassword() throws Exception {
        // Act
        when(user.getPassword()).thenReturn(password);
        when(securityService.md5(password)).thenReturn(password);
        userService.assignPassword(user);

        // Verify
        verify(user).setPassword(password);

    }

    /**
     * @verifies makes sure that user gets updated in userDOA
     * @see UserServiceImpl#assignPassword(User)
     */
    @Test
    public void assignPassword_shouldMakesSureThatUserGetsUpdatedInUserDOA() throws Exception {
        // Act
        userService.assignPassword(user);

        // Verify
        verify(userDAO).updateUser(user);
    }
}