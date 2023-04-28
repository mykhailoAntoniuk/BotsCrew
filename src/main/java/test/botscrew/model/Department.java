package test.botscrew.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class Department {
    @Id
    private String name;
    @OneToOne
    private Lector headOfDepartment;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Lector> personnel;
}
