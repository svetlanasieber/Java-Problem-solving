package phonebook.entity;

public class Contact {
    private String name;
    private String number;

    public Contact() {
    }

    public Contact(String name, String number) {
        this.name = name;
        setNumber(number);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {       //some simple example validations
        if (number.length() < 6) {
            throw new IllegalArgumentException("Number must be at least 6 symbols.");
        } else {
            for (int i = 0; i < number.length(); i++) {
                if (!Character.isAlphabetic(number.charAt(i))) {
                    continue;
                }
                throw new IllegalArgumentException("Number must contains only digits.");
            }
            this.number = number;
        }
    }

    public String getName() {
        return this.name;
    }
}


