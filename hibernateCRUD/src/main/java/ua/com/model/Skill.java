package ua.com.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of ={"id", "name"})
@ToString(of = {"id", "name"})
public class Skill {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NonNull
  @Column(unique = true)
  private String name;

  @ManyToMany(cascade = CascadeType.ALL, mappedBy = "skills")
  private Set<User> users = new HashSet<>();
}
