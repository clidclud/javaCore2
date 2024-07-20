package les4.second;

public class WrongPasswordException extends RuntimeException{

    public WrongPasswordException(){
        this("Неверный формат пароля", Integer.valueOf("больше 20 символов"));

    }

    public WrongPasswordException(String expected, Integer current) {
        super(String.format("Ожидалась длинна пароля меньше %s символов, введено %s символов", expected, current));
    }
}
