package com.genie.myapp.entity.Product;

import com.genie.myapp.entity.Account.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Reply_product implements Serializable {

    @Id
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "genieId")
    private User genieId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "productId")
    private Product productId;

    private int rating;

    private int replyNo;
    private String comment;
    private LocalDateTime writeDate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reply_product that = (Reply_product) o;

        if (rating != that.rating) return false;
        if (replyNo != that.replyNo) return false;
        if (!genieId.equals(that.genieId)) return false;
        if (!productId.equals(that.productId)) return false;
        if (!comment.equals(that.comment)) return false;
        return writeDate.equals(that.writeDate);
    }

    @Override
    public int hashCode() {
        int result = genieId.hashCode();
        result = 31 * result + productId.hashCode();
        result = 31 * result + rating;
        result = 31 * result + replyNo;
        result = 31 * result + comment.hashCode();
        result = 31 * result + writeDate.hashCode();
        return result;
    }
}
