package vn.aptech;

public class SinhVienValidator {
    
    public static boolean validateId(int id) {
        return id > 0;
    }
    
    public static boolean validateFullName(String fullName) {
        return fullName != null && !fullName.isEmpty();
    }
    
    public static boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber != null && !phoneNumber.isEmpty();
    }
    
    public static boolean validateAddress(String address) {
        return address != null && !address.isEmpty();
    }
}
