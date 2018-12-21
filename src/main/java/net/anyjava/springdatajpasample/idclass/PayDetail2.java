package net.anyjava.springdatajpasample.idclass;

import lombok.NoArgsConstructor;
import lombok.Setter;
import net.anyjava.springdatajpasample.embeddedid.PayShop;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pay_detail_2")
@IdClass(PayDetailId2.class)
@NoArgsConstructor
public class PayDetail2 {

    @Id
    private Long payId;

    @Id
    private Long paySeq;

    @Id
    private Long payDetailId;

    @OneToMany(mappedBy = "payDetail2", fetch = FetchType.LAZY)
    @org.hibernate.annotations.ForeignKey(name = "none")
    private List<PayShop2> payShops = new ArrayList<>();

    public PayDetail2(Long payId,
                      Long paySeq,
                      Long payDetailId) {
        this.payId = payId;
        this.paySeq = paySeq;
        this.payDetailId = payDetailId;
    }

    public void addPayShop2(PayShop2 payShop2) {
        this.payShops.add(payShop2);
    }
}