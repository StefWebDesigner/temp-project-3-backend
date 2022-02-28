
package revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * This class represents a User entity in the database.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private long registrationDate;

    private String homePage;

    @Column(length = 1000)
    private String location;

    @Column(length = 1000)
    private String description;

    // Returns items in both cart and wishlist
    // Filter by CartItem's saved field to separate the lists
    @OneToMany
    @JoinColumn(name = "cart_item_id")
    private List<CartItem> itemList;

}