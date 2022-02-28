package revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * This class represents an individual location controlled by a Seller.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private int id;

    private String location;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
}