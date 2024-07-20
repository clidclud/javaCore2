package les4.second;

public class loginPassword {

    public static boolean сheckLoginPass(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        try {
            if (login.length() >= 20) {
                throw new WrongLoginException("20", login.length());
            }
            if (password.length() < 20 && password.equals(confirmPassword)) {
                throw new WrongPasswordException("20", password.length());
            }
            return true;
        } catch (WrongLoginException | WrongPasswordException e){
            e.printStackTrace();
            return false;
        }
    }
}
