package pl.sda.db;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DatabaseTest {

    @Test
    public void testAddUser() {
        // given
        User user = new User("login", "password");
        User user1 = new User("login1", "password1");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);

        Database database = new Database();

        // when
        database.addUser(user);
        database.addUser(user1);

        // then
        assertThat(database.findAll().size())
                .as("Should be 2")
                .isEqualTo(2);

    }

    @Test(expected = UserExistsException.class)
    public void testAddUserAlreadyThere() {
        // given
        User user = new User("login", "password");
        User user1 = new User("login1", "password1");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);

        Database database = new Database(users);

        // when
        database.addUser(user);
    }

    @Test
    public void testFindAll() {
        // given
        User user = new User("login", "password");
        User user1 = new User("login1", "password1");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);

        int sizeBefore = users.size();

        Database database = new Database(users);

        // when
        List<User> userList = database.findAll();

        // then
        assertAll(
                () -> assertThat(userList.size())
                        .isEqualTo(2),
                () -> assertThat(userList.contains(user))
                        .isEqualTo(true),
                () -> assertThat(userList.contains(user1))
                        .isEqualTo(true),
                () -> assertThat(userList.get(0).getLogin())
                        .isEqualTo("login"),
                () -> assertThat(userList.get(0).getPassword())
                        .isEqualTo("password"),
                () -> assertThat(userList.get(1).getLogin())
                        .isEqualTo("login1"),
                () -> assertThat(userList.get(1).getPassword())
                        .isEqualTo("password1")
        );
    }

    @Test
    public void testRemoveUser() {
        // given
        User user = new User("login", "password");
        User user1 = new User("login1", "password1");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);

        int sizeBefore = users.size();

        Database database = new Database(users);

        // when
        User removedUser = user;
        database.removeUser(removedUser.getLogin());
        int size = database.findAll().size();

        // then
        assertThat(removedUser.getLogin())
                .isEqualTo("login");

        assertThat(removedUser.getPassword())
                .isEqualTo("password");

        assertThat(size)
                .isEqualTo(sizeBefore - 1);
    }

    @Test(expected = UserNotFoundException.class)
    public void testRemoveUserNoUserFound() {
        // given
        User user = new User("login", "password");
        User user1 = new User("login1", "password1");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);

        int sizeBefore = users.size();

        Database database = new Database(users);

        // when
        database.removeUser("login2");
    }

    @Test
    public void testFindUser() {
        // given
        User user = new User("login", "password");

        List<User> users = new ArrayList<>();
        users.add(user);

        Database database = new Database(users);

        // when
        User foundUser = database.findUser(user.getLogin());
        int size = users.size();

        // then
        assertThat(foundUser.getLogin())
                .as("should be login")
                .isEqualTo(user.getLogin());

        assertThat(foundUser.getPassword())
                .as("should be password")
                .isEqualTo(user.getPassword());

        assertThat(size)
                .as("should be 1")
                .isEqualTo(1);
    }

    @Test(expected = UserNotFoundException.class)
    public void testFindUserNoUserFound() {
        // given
        User user = new User("login", "password");

        List<User> users = new ArrayList<>();
        users.add(user);

        Database database = new Database(users);

        // when
        database.findUser("login1");
    }

    @Test
    public void testFindByPartOfLoginE() {
        // given
        User user = new User("login", "password");

        List<User> users = new ArrayList<>();
        users.add(user);

        Database database = new Database(users);

        // when
        User foundUser = database.findByPartOfLogin("in");

        // then
        assertThat(foundUser)
                .isEqualToComparingFieldByField(user);
    }

    @Test(expected = UserNotFoundException.class)
    public void testFindByPartOfLoginENoUser() {
        // given
        User user = new User("login", "password");

        List<User> users = new ArrayList<>();
        users.add(user);

        Database database = new Database(users);

        // when
        database.findByPartOfLogin("ing");
    }

    @Test
    public void testFindByPartOfLoginB() {
        // given
        User user = new User("login", "password");

        List<User> users = new ArrayList<>();
        users.add(user);

        Database database = new Database(users);

        // when
        User foundUser = database.findByPartOfLogin("lo");

        // then
        assertThat(foundUser)
                .isEqualToComparingFieldByField(user);
    }

    @Test(expected = UserNotFoundException.class)
    public void testFindByPartOfLoginBNoUser() {
        // given
        User user = new User("login", "password");

        List<User> users = new ArrayList<>();
        users.add(user);

        Database database = new Database(users);

        // when
        database.findByPartOfLogin("ad");
    }

    @Test
    public void testFindByPartOfLoginM() {
        // given
        User user = new User("login", "password");

        List<User> users = new ArrayList<>();
        users.add(user);

        Database database = new Database(users);

        // when
        User foundUser = database.findByPartOfLogin("gi");

        // then
        assertThat(foundUser)
                .isEqualToComparingFieldByField(user);
    }

    @Test(expected = UserNotFoundException.class)
    public void testFindByPartOfLoginMNoUser() {
        // given
        User user = new User("login", "password");

        List<User> users = new ArrayList<>();
        users.add(user);

        Database database = new Database(users);

        // when
        database.findByPartOfLogin("dmi");
    }

    @Test
    public void testModifyUser() {
        // given
        User user = new User("login", "password");

        List<User> users = new ArrayList<>();
        users.add(user);

        Database database = new Database(users);

        // when
        database.modifyUser(user.getLogin(), "newLogin");

        // then
        assertThat(user.getLogin())
                .isEqualTo("newLogin");
    }

    @Test(expected = UserNotFoundException.class)
    public void testModifyUserNoUser() {
        // given
        User user = new User("login", "password");

        List<User> users = new ArrayList<>();
        users.add(user);

        Database database = new Database(users);

        // when
        database.modifyUser("login1", "newLogin");
    }
}