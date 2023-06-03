package trinhquangtan.demo.enity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    @NotBlank(message = "Username cần phải nhập")
    @Size(max = 50, message = "Username cần phải ít nhất 50 kí tự")
    //@ValidUsername
    private  String username;

    @Column(name = "password", length = 250, nullable = false)
    @NotBlank(message = "Password cần phải nhập")
    private  String password;

    @Column(name = "email", length = 50, nullable = false)
    @Size(max = 50, message = "Email cần phải ít nhất 50 kí tự")
    @Email(message = "Email should be vaild")
    private String email;

    @Column(name = "name", length = 50, nullable = false)
    @Size(max = 50, message = "tên của bạn cần phải ít nhất 50 kí tự")
    @NotBlank(message = "Tên cần phải được điền")
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();
}
