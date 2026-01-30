package uz.kuponbot.kupon.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uz.kuponbot.kupon.entity.User;
import uz.kuponbot.kupon.service.ProductService;
import uz.kuponbot.kupon.service.UserService;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    
    private final ProductService productService;
    private final UserService userService;
    
    @Override
    public void run(String... args) throws Exception {
        // Initialize sample products if none exist
        if (productService.getAllProducts().isEmpty()) {
            createSampleProducts();
        }
        
        // Create admin users if not exist
        createAdminUsers();
    }
    
    private void createSampleProducts() {
        // Create sample glasses products
        productService.createProduct(
            "Ray-Ban Aviator Classic",
            "Klassik aviator uslubidagi ko'zoynak. UV himoyasi bilan.",
            "450000",
            "https://images.unsplash.com/photo-1511499767150-a48a237f0083?w=300&h=200&fit=crop",
            15
        );
        
        productService.createProduct(
            "Oakley Holbrook Sport",
            "Sport uslubidagi ko'zoynak. Faol hayot tarzi uchun ideal.",
            "380000",
            "https://images.unsplash.com/photo-1574258495973-f010dfbb5371?w=300&h=200&fit=crop",
            20
        );
        
        productService.createProduct(
            "Persol Premium Collection",
            "Premium sifatli italyan ko'zoynagi. Zamonaviy dizayn.",
            "650000",
            "https://images.unsplash.com/photo-1556306535-38febf6782e7?w=300&h=200&fit=crop",
            10
        );
        
        productService.createProduct(
            "Gucci Designer Frames",
            "Brendli dizayner ko'zoynagi. Moda va sifat.",
            "850000",
            "https://images.unsplash.com/photo-1508296695146-257a814070b4?w=300&h=200&fit=crop",
            8
        );
        
        productService.createProduct(
            "Prada Luxury Eyewear",
            "Hashamatli Prada ko'zoynagi. Yuqori sifat kafolati.",
            "920000",
            "https://images.unsplash.com/photo-1577803645773-f96470509666?w=300&h=200&fit=crop",
            5
        );
        
        System.out.println("✅ Sample products created successfully!");
    }
    
    private void createAdminUsers() {
        // Admin 1: IbodullaR
        if (userService.findByTelegramId(1807166165L).isEmpty()) {
            User admin1 = new User();
            admin1.setTelegramId(1807166165L);
            admin1.setFirstName("Ibodulla");
            admin1.setLastName("Rahimov");
            admin1.setTelegramUsername("@IbodullaR");
            admin1.setPhoneNumber("+998901234567");
            admin1.setBirthDate("15.03.1995");
            admin1.setState(User.UserState.REGISTERED);
            
            userService.save(admin1);
            System.out.println("✅ Admin 1 (IbodullaR) created successfully!");
        }
        
        // Admin 2: Second Admin
        if (userService.findByTelegramId(987654321L).isEmpty()) {
            User admin2 = new User();
            admin2.setTelegramId(987654321L);
            admin2.setFirstName("Admin");
            admin2.setLastName("Manager");
            admin2.setTelegramUsername("@AdminManager");
            admin2.setPhoneNumber("+998909876543");
            admin2.setBirthDate("20.05.1990");
            admin2.setState(User.UserState.REGISTERED);
            
            userService.save(admin2);
            System.out.println("✅ Admin 2 (AdminManager) created successfully!");
        }
    }
}