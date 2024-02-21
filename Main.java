import java.util.Scanner;

// DiscountRate interface
interface DiscountRate {
    double getServiceMemberDiscount();
    double getProductMemberDiscount();
}

// Customer class
class Customer implements DiscountRate {
    private String customerName;
    private String customerType;
    
    public Customer(String customerName, String customerType) {
        this.customerName = customerName;
        this.customerType = customerType;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public String getCustomerType() {
        return customerType;
    }
    
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    
    @Override
    public double getServiceMemberDiscount() {
        switch (customerType) {
            case "Premium":
                return 0.20;
            case "Gold":
                return 0.15;
            case "Silver":
                return 0.10;
            default:
                return 0.0;
        }
    }
    
    @Override
    public double getProductMemberDiscount() {
        switch (customerType) {
            case "Premium":
            case "Gold":
            case "Silver":
                return 0.10;
            default:
                return 0.0;
        }
    }
}

// Sale class
class Sale {
    private Customer customer;
    private String date;
    private double serviceExpense;
    private double productExpense;
    
    public Sale(Customer customer, String date) {
        this.customer = customer;
        this.date = date;
    }
    
    public String getDate() {
        return date;
    }
    
    public double getServiceExpense() {
        return serviceExpense;
    }
    
    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }
    
    public double getProductExpense() {
        return productExpense;
    }
    
    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }
    
    public double getTotalExpense() {
        return serviceExpense + productExpense;
    }
    
    public double getServiceDiscount() {
        return serviceExpense * customer.getServiceMemberDiscount();
    }
    
    public double getProductDiscount() {
        return productExpense * customer.getProductMemberDiscount();
    }
    
    public void DisplayInfo() {
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Customer Type: " + customer.getCustomerType());
        System.out.println("Date: " + date);
        System.out.println("Service Expense: " + serviceExpense);
        System.out.println("Product Expense: " + productExpense);
        System.out.println("Service Discount: " + getServiceDiscount());
        System.out.println("Product Discount: " + getProductDiscount());
        System.out.println("Total Expense: " + getTotalExpense());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input customer details
        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();
        
        System.out.println("Enter customer type (Premium, Gold, Silver, Normal):");
        String customerType = scanner.nextLine();
        
        // Create customer object
        Customer customer = new Customer(customerName, customerType);
        
        // Input sale details
        System.out.println("Enter date (YYYY-MM-DD):");
        String date = scanner.nextLine();
        
        System.out.println("Enter service expense:");
        double serviceExpense = scanner.nextDouble();
        
        System.out.println("Enter product expense:");
        double productExpense = scanner.nextDouble();
        
        // Create sale object
        Sale sale = new Sale(customer, date);
        sale.

setServiceExpense(serviceExpense);
        sale.setProductExpense(productExpense);
        
        // Display sale information
        sale.DisplayInfo();
        
        scanner.close();
    }
}