import com.tamas.gyorkis.User.User;
import com.tamas.gyorkis.User.UserManager;
import com.tamas.gyorkis.User.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserManagerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserManager userManager;

    @Test
    public void testGetUsernameById() {
        when(userService.getUser(1)).thenReturn(new User("Endre", 1));

        String actual = userManager.getUsernameById(1);
        String expected = "Endre";

        assertEquals(actual, expected);

        verify(userService).getUser(1);
    }

    @Test
    public void testUpdateUsername() {
        when(userService.getUser(1)).thenReturn(new User("Tibor", 1));

        userManager.updateUserName(1, "Mercédesz");

        verify(userService).getUser(1);
        verify(userService).updateUser(argThat(user -> user.getName().equals("Mercédesz")));
    }

    @Test
    public void testGetAllUsers() {
        when(userService.getAllUsers()).thenReturn(Arrays.asList(
                new User("Balázs", 1),
                new User("Ákos",2)
        ));

        List<User> users = userManager.getAllUsers();

        verify(userService).getAllUsers();

        int expected = 2;
        int actual = users.size();

        assertEquals(expected, actual);
    }
}
