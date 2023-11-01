package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class StockEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private int id;

    private Integer total;

    private Integer idproduct;

    private Integer idresponsable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
    }

    public Integer getIdresponsable() {
        return idresponsable;
    }

    public void setIdresponsable(Integer idresponsable) {
        this.idresponsable = idresponsable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockEntity that = (StockEntity) o;

        if (id != that.id) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (idproduct != null ? !idproduct.equals(that.idproduct) : that.idproduct != null) return false;
        if (idresponsable != null ? !idresponsable.equals(that.idresponsable) : that.idresponsable != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (idproduct != null ? idproduct.hashCode() : 0);
        result = 31 * result + (idresponsable != null ? idresponsable.hashCode() : 0);
        return result;
    }
}
