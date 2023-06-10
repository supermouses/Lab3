package trinhquangtan.demo.enity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 50, message = "ten phai chua it nhat 50 ki tu")
    @NotBlank(message = "dien ten vao day")
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Size(max = 250, message = "tieu de phai chua it nhat 250 ki tu")
    @Column(name = "tieu de", length = 250)
    private String description;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
