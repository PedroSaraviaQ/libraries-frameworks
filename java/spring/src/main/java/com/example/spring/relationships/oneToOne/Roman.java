package com.example.spring.relationships.oneToOne;

import com.example.spring.models.SuperModel;
import jakarta.persistence.*;

@Entity
@Table(name = "romans")
public class Roman extends SuperModel {

    //* "@OneToOne" only takes here the lazy "fetch"
    //* "mappedBy" will have the name of the linked object in the other model.
    @OneToOne(mappedBy = "roman", fetch = FetchType.LAZY)

    //* Then the linked object of the other model that Java will use.
    private Arabic arabic;

    public Arabic getArabic() {
        return arabic;
    }

    public void setArabic(Arabic arabic) {
        this.arabic = arabic;
    }
}
