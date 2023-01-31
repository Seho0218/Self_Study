package com.genie.myapp.entity.Product;

import com.genie.myapp.entity.Account.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter @NotEmpty
public class ProductLike implements Serializable {

    @Id @OneToOne(fetch = EAGER)
    @MapsId @JoinColumn(name = "productId")
    private Product productId;

    private long likeNum;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "genieId")
    private User genieId;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductLike that = (ProductLike) o;

        if (likeNum != that.likeNum) return false;
        if (!productId.equals(that.productId)) return false;
        return genieId.equals(that.genieId);
    }

    @Override
    public int hashCode() {
        int result = productId.hashCode();
        result = 31 * result + (int) (likeNum ^ (likeNum >>> 32));
        result = 31 * result + genieId.hashCode();
        return result;
    }
}
