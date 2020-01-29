package ua.com.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(of = {"id", "name", "number", "code"})
@EqualsAndHashCode(of = {"id", "name", "number", "code"})
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NonNull
  private String name;

  @NonNull
  private int number;

  @NonNull
  @Column(unique = true)
  private String code;

  @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
  private Set<User> users = new HashSet<>();
}
