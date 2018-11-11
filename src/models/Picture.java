package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "pictures")
@NamedQueries({
    @NamedQuery(
            name = "getAllPictures",
            query = "SELECT p FROM Picture AS p ORDER BY p.id DESC"
            ),
    @NamedQuery(
            name = "GetPictureCount",
            query = "SELECT COUNT(p) FROM Picture AS p"
          )
})
@Entity
public class Picture {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "reshipi_id",nullable = false)
    private Reshipi reshipi_id;

    @Column(name = "file_name",nullable = false)
    private String file_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reshipi getReshipi_id() {
        return reshipi_id;
    }

    public void setReshipi_id(Reshipi reshipi_id) {
        this.reshipi_id = reshipi_id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }




}
