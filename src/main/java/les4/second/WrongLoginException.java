package les4.second;

public class WrongLoginException extends RuntimeException{
    public WrongLoginException(){
        this("Неверный формат логина", Integer.valueOf("меньше 20 символов"));
    }

    public WrongLoginException(String expected, Integer current){
        super(String.format("Ожидалась длинна логина меньше %s символов, введено %s символов", expected, current));
    }
}
