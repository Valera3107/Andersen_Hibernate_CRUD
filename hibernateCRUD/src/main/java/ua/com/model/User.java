package ua.com.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usr")
@Data
@ToString(of = {"name", "username", "email"})
@EqualsAndHashCode(of = {"id", "username", "email"})
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NonNull
  @Column(length = 30)
  private String name;

  @NonNull
  @Column(length = 30, updatable = false, unique = true)
  private String username;

  @NonNull
  @Column(unique = true, length = 50)
  private String email;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "passport_id")
  private Passport passport;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "address_id")
  private Address address;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(name = "user_skill",
  joinColumns = @JoinColumn(name = "user_id"),
  inverseJoinColumns = @JoinColumn(name = "skill_id"))
  private Set<Skill> skills = new HashSet<>();
}
