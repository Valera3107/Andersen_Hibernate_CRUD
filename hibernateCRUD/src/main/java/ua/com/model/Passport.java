package ua.com.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "passport")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(of = {"id", "country", "code"})
@EqualsAndHashCode(of = {"id", "country", "code"})
public class Passport {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NonNull
  private String country;

  @NonNull
  @Column(unique = true)
  private String code;

  @OneToOne(mappedBy = "passport")
  private User user;
}
