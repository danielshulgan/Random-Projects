import java.security.SecureRandom;

public class PasswordGenerator {
    //Fields
    private int length = 0;
    private boolean useUpper = false;
    private boolean useLower = false;
    private boolean useDigits = false;
    private boolean useSpecialCharacters = false;
    //Constructor
    private PasswordGenerator(Builder builder) {
        this.useUpper = builder.useUpper;
        this.useLower = builder.useLower;
        this.useDigits = builder.useDigits;
        this.useSpecialCharacters = builder.useSpecialCharacters;
        this.length = builder.length;
    }

    public String generate() {
        //Store generated password and characters 
        StringBuilder password = new StringBuilder();
        String characters = "";

        if (useLower) characters += "abcdefghijklmnopqrstuvwxyz";
        if (useUpper) characters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (useDigits) characters += "123456789";
        if (useSpecialCharacters) characters += "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

        if (characters.isEmpty()) {
            throw new IllegalStateException("Include at least one set of characters please");
        }
        //Generates secure random number
        SecureRandom random = new SecureRandom();
        try {
            for (int i = 0; i < length; i++) {
                int randomIndex = random.nextInt(characters.length());
                password.append(characters.charAt(randomIndex));
            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new RuntimeException("Error generating password", e);
        }
        //return password
        return password.toString();
        }

    public static class Builder {
        //Configuration Options
        private int length = 0;
        private boolean useUpper = false;
        private boolean useLower = false;
        private boolean useDigits = false;
        private boolean useSpecialCharacters = false;
        //Constructor
        public Builder(int length) {
            this.length = length;                
        }
        //Setters and allow for method chaining
        public Builder useUpper (boolean useUpper) {
            this.useUpper = useUpper;
            return this;
        }

        public Builder useLower (boolean useLower) {
            this.useLower = useLower;
            return this;
        }

        public Builder useDigits (boolean useDigits) {
            this.useDigits = useDigits;
            return this;
        }

        public Builder useSpecialCharacters (boolean useSpecialCharacters) {
            this.useSpecialCharacters = useSpecialCharacters;
            return this;
        }
        //Creates a PasswordGenerator instance and returns it
        public PasswordGenerator build() {
            return new PasswordGenerator(this);
        }

        }
        public static void main(String[] args) {
            //Create instance of PasswordGenerator
            PasswordGenerator passwordGenerator = new PasswordGenerator.Builder(8)
                .useUpper(true)
                .useLower(true)
                .useDigits(true)
                .useSpecialCharacters(false)
                .build();
            //Creates password with generate method
            String generatedPassword = passwordGenerator.generate();
            System.out.println("Generated Password: " + generatedPassword);
        }
    }
