import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + NUMBERS + SYMBOLS;
    private static final int PASSWORD_LENGTH = 16;

    private String finalPassword;
    private String shuffledPassword;
    
 
    public PasswordGenerator() {
        this.finalPassword = passwordGenerator();
        shuffledPassword(this.finalPassword);
    }


    // METHOD FOR CREATING A 16-CHARACTER PASSWORD STRING //
    public String passwordGenerator() {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);

        // Adding at least one from each category to the password //
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        password.append(SYMBOLS.charAt(random.nextInt(SYMBOLS.length())));

        // Filling the rest of the password with random characters //
        for (int i = password.length(); i < PASSWORD_LENGTH; i++) {
            password.append(ALL_CHARACTERS.charAt(random.nextInt(ALL_CHARACTERS.length())));
        }

        this.finalPassword = password.toString();
        return this.finalPassword;
    }


    // RETURNS THE SHUFFLED PASSWORD //
    public String getShuffledPassword() {
        return this.shuffledPassword;
    }


    // METHOD FOR SHUFFLING THE PASSWORD STRING //
    protected void shuffledPassword(String finalPassword) {
        this.finalPassword = finalPassword;
        StringBuilder shuffledPassword = new StringBuilder(finalPassword);
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < shuffledPassword.length(); i++) {
            int j = random.nextInt(shuffledPassword.length());  // Determines the index of where the current character is placed to
            char temp = shuffledPassword.charAt(i);  // Current character is saved to a temporarily variable
            shuffledPassword.setCharAt(i, shuffledPassword.charAt(j));  // Current character i is swapped with character at j
            shuffledPassword.setCharAt(j, temp);  // The original character is placed to randomly chosen spot j
        }
        this.shuffledPassword = shuffledPassword.toString();
    }


    public static void main(String[] args) {
        PasswordGenerator generator = new PasswordGenerator();
        System.out.println("Generated password: " + generator.getShuffledPassword());
    }
}