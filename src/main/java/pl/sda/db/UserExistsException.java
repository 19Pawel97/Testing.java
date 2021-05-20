package pl.sda.db;

class UserExistsException extends RuntimeException {
    public UserExistsException(String message) {
        super(message);
    }
}
