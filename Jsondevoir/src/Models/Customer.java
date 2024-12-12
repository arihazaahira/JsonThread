package Models;

public class Customer {
    private int idCustomer;
    private String name;
    private String email;  // Nouveau champ
    private String phone;  // Nouveau champ

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer(int idCustomer, String name, String email, String phone) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
