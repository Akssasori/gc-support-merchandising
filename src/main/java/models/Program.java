package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Program implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Program id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Program name.
     */
    private String program;




}
